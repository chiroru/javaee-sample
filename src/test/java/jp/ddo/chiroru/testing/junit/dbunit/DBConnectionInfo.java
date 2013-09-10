package jp.ddo.chiroru.testing.junit.dbunit;

import java.io.IOException;
import java.util.Properties;

import jp.ddo.chiroru.testing.resource.ClassPathPropertyLoader;

public class DBConnectionInfo {

    private final static String PROPERTY_PATH = "jdbc.properties";
    private Properties connectionInfo;
    private String username;
    private String password;
    private String url;
    private String schema;
    private String driverClass;

    public DBConnectionInfo() {
        try {
            ClassPathPropertyLoader loader = ClassPathPropertyLoader.getInstance();
            connectionInfo = loader.load(PROPERTY_PATH);
            username = connectionInfo.getProperty("jdbc.username");
            password = connectionInfo.getProperty("jdbc.password");
            url = connectionInfo.getProperty("jdbc.url");
            driverClass = connectionInfo.getProperty("jdbc.driver");
            schema = connectionInfo.getProperty("jdbc.schema");
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getUrl() {
        return this.url;
    }

    public String getDriverClass() {
        return this.driverClass;
    }

    public String getSchema() {
        return this.schema;
    }
}
