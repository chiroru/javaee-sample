package jp.ddo.chiroru.testing.database;

import jp.ddo.chiroru.testing.junit.dbunit.DBTestRunner;

import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Daoのユニットテストに必要なTestFixture（テストデータの意）の操作を行う{@link TestRunner}です.
 * 
 */
public class DaoTestRunner
        extends BlockJUnit4ClassRunner {

    protected static Logger L = LoggerFactory.getLogger(DBTestRunner.class);

    private Class<?> testClazz;

    /**
     * コンストラクタです.
     * @param clazz テストクラス
     * @throws InitializationError {@link TestRunner} の初期化に失敗した際にスローされる例外です.
     */
    public DaoTestRunner(Class<?> clazz)
            throws InitializationError {
        super(clazz);
        this.testClazz = clazz;
        this.analyzeTestDataFixture(clazz);
    }

    private void analyzeTestDataFixture(Class<?> clazz) {
        
    }
}
