package jp.ddo.chiroru.testing.junit.external;

import java.io.IOException;
import java.util.Properties;

import jp.ddo.chiroru.testing.junit.rdbms.JDBCConfiguration;
import jp.ddo.chiroru.testing.resource.PropertyLoader;
import jp.ddo.chiroru.testing.resource.PropertyLoaderFactory;
import jp.ddo.chiroru.testing.resource.StoreType;

public class H2ServerConfiguration
        implements JDBCConfiguration {

    private final static String TARGET_PROPERTY_FILE = "H2ServerConfiguration.properties";
    private final Properties props;

    public H2ServerConfiguration() {
        PropertyLoaderFactory factory = PropertyLoaderFactory.getFactory();
        PropertyLoader loader = factory.getLoader(StoreType.CLASSPATH);
        try {
            props = loader.load(TARGET_PROPERTY_FILE);
        } catch (IOException e) {
            throw new RuntimeException("Can't load ths property file[" + TARGET_PROPERTY_FILE + "].", e);
        }
    }

    public String getBaseDir() {
        return props.getProperty("base.dir");
    }

    public String getDbName() {
        return props.getProperty("db.name");
    }

    public String getSchema() {
        return props.getProperty("schema.name");
    }

    @Override
    public String getUserName() {
        return props.getProperty("user.name");
    }

    @Override
    public String getPassword() {
        return props.getProperty("user.password");
    }

    @Override
    public String getUrl() {
        return generateUrl();
    }

    @Override
    public String getDriver() {
        return props.getProperty("jdbc.driver");
    }

    protected String generateUrl() {
        return "jdbc:h2:tcp://127.0.0.1/" + getBaseDir() + "/" + getDbName();
    }
}
