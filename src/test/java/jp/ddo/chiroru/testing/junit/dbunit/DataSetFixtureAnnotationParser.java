package jp.ddo.chiroru.testing.junit.dbunit;

import com.google.common.collect.ObjectArrays;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.junit.runners.model.FrameworkMethod;

public class DataSetFixtureAnnotationParser {

    private boolean isAnnotatedAtClass;
    private IDataSet globalDataSet;

    public DataSetFixtureAnnotationParser(Class<?> testTargetClass) {

        DataSetFixture dataSetFixture =
                testTargetClass.getAnnotation(DataSetFixture.class);
        if (dataSetFixture != null) {
            isAnnotatedAtClass = true;
            globalDataSet = generateDataSet(dataSetFixture);
        } else {
            isAnnotatedAtClass = false;
        }
    }

    public IDataSet doParse(FrameworkMethod testMethod) {
        if (isAnnotatedAtClass()) {
            return globalDataSet;
        } else {
            DataSetFixture dataSetFixture =
                    testMethod.getAnnotation(DataSetFixture.class);
            if (dataSetFixture != null) {
                return generateDataSet(dataSetFixture);
            } else {
                return null;
            }
        }
    }

    private IDataSet generateDataSet(DataSetFixture dataSetFixture) {
        try {
            DataSetType type = dataSetFixture.type();
            String[] paths = dataSetFixture.value();
            DataSetFixtureProcessor processor = new DataSetFixtureProcessor();
            IDataSet[] s = ObjectArrays.newArray(IDataSet.class, paths.length);
            for (int i = 0; i < paths.length; i++) {
                s[i] = processor.doProcess(type, paths[i]);
            }
            return new CompositeDataSet(s);
        } catch (DataSetException e) {
            throw new RuntimeException("DataSetの作成に失敗しました.", e);
        }
    }

    private boolean isAnnotatedAtClass() {
        return isAnnotatedAtClass;
    }
}
