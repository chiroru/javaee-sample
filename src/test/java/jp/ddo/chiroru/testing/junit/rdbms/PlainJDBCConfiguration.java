package jp.ddo.chiroru.testing.junit.rdbms;

import java.io.IOException;
import java.util.Properties;

import jp.ddo.chiroru.testing.resource.PropertyLoader;
import jp.ddo.chiroru.testing.resource.PropertyLoaderFactory;
import jp.ddo.chiroru.testing.resource.StoreType;

public class PlainJDBCConfiguration
        implements JDBCConfiguration {

    private final static String TARGET_PROPERTY_FILE = "JDBC.properties";
    private final Properties props;

    public PlainJDBCConfiguration() {
        PropertyLoaderFactory factory = PropertyLoaderFactory.getFactory();
        PropertyLoader loader = factory.getLoader(StoreType.CLASSPATH);
        try {
            props = loader.load(TARGET_PROPERTY_FILE);
        } catch (IOException e) {
            throw new RuntimeException("Can't load ths property file[" + TARGET_PROPERTY_FILE + "].", e);
        }
    }

    @Override
    public String getUrl() {
        return props.getProperty("jdbc.url");
    }

    @Override
    public String getUserName() {
        return props.getProperty("jdbc.username");
    }

    @Override
    public String getPassword() {
        return props.getProperty("jdbc.password");
    }

    @Override
    public String getDriver() {
        return props.getProperty("jdbc.driver");
    }

    @Override
    public String getSchema() {
        return props.getProperty("jdbc.schema");
    }
}
