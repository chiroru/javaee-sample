package jp.ddo.chiroru.testing.database;

import java.io.IOException;
import java.util.Properties;

import jp.ddo.chiroru.testing.resource.ClassPathPropertyLoader;

public class DaoTestConfiguration {

    private final static String DEFAULT_DAO_TEST_CONFIGURATION_FILE_PATH = "DaoTest";

    private Properties props;

    public DaoTestConfiguration() {
        this(DEFAULT_DAO_TEST_CONFIGURATION_FILE_PATH);
    }

    public DaoTestConfiguration(String configurationFilePath) {
        ClassPathPropertyLoader loader = ClassPathPropertyLoader.getInstance();
        try {
            props = loader.load(configurationFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't load the Dao test configuration file[" + configurationFilePath + "]");
        }
    }

    private TestingStorategy testingStorategy;
}
