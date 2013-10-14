package jp.ddo.chiroru.testing.junit.dbunit;

import org.dbunit.dataset.IDataSet;
import org.junit.internal.runners.statements.InvokeMethod;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBTestRunner
extends BlockJUnit4ClassRunner {

    protected static Logger L = LoggerFactory.getLogger(DBTestRunner.class);
    private Class<?> testTargetClass;
    private DataSetFixtureAnnotationParser annotationParser;
    private DBUnitOperator dbUnitOperator;
    private Migration maigration;

    public DBTestRunner(Class<?> clazz)
            throws Exception {
        super(clazz);
        testTargetClass = clazz;
        annotationParser = new DataSetFixtureAnnotationParser(clazz);
        dbUnitOperator = new DBUnitOperator(DBConnectionManager.getDBConnectionInfo().getSchema());
        maigration = new Migration();
    }

    @Override
    protected void runChild(FrameworkMethod method, RunNotifier notifier) {
        super.runChild(method, notifier);
    }

    @Override
    protected Statement methodInvoker(FrameworkMethod method, Object test) {
        return new DBTestRunner.InvokeDBTestMethod(method, test);
    }

    private class InvokeDBTestMethod
    extends InvokeMethod {

        private FrameworkMethod testMethod;
        private Object testTarget;

        public InvokeDBTestMethod(FrameworkMethod testMethod, Object target) {
            super(testMethod, target);
            this.testMethod = testMethod;
            this.testTarget = target;
        }

        @Override
        public void evaluate()
                throws Throwable {
            L.info(getTestClass().getName() + "#" + testMethod.getName() + " [start]");
            maigration.migrate();
            IDataSet dataSet = annotationParser.doParse(testMethod);
            if (dataSet != null) {
                L.info("DataSet を設定します・・・");
                dbUnitOperator.setDataSet(dataSet);
            }
            dbUnitOperator.onSetup();
            super.evaluate();
            dbUnitOperator.onTearDown();
            L.info(getTestClass().getName() + "#" + testMethod.getName() + " [end]");
        }
    }
}
