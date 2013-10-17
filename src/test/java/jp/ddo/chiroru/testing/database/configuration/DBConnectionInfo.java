package jp.ddo.chiroru.testing.database.configuration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

    private static Map<String, DBConnectionInfo> REPO = new HashMap<>();
    
    static {
        REPO.put(PROPERTY_PATH, new DBConnectionInfo());
    }

    private DBConnectionInfo() {
        try {
            ClassPathPropertyLoader loader = ClassPathPropertyLoader.getInstance();
            connectionInfo = loader.load(PROPERTY_PATH);
            username = connectionInfo.getProperty("jdbc.username");
            password = connectionInfo.getProperty("jdbc.password");
            url = connectionInfo.getProperty("jdbc.url");
            driverClass = connectionInfo.getProperty("jdbc.driver");
            schema = connectionInfo.getProperty("jdbc.schema");
        } catch (IOException e) {
            throw new RuntimeException("Can't load a configuration file [" + PROPERTY_PATH + "].", e);
        }
    }

    public DBConnectionInfo(String propertyPath) {
        try {
            ClassPathPropertyLoader loader = ClassPathPropertyLoader.getInstance();
            connectionInfo = loader.load(propertyPath);
            username = connectionInfo.getProperty("jdbc.username");
            password = connectionInfo.getProperty("jdbc.password");
            url = connectionInfo.getProperty("jdbc.url");
            driverClass = connectionInfo.getProperty("jdbc.driver");
            schema = connectionInfo.getProperty("jdbc.schema");
        } catch (IOException e) {
            throw new RuntimeException("Can't load a configuration file [" + propertyPath + "].", e);
        }
    }

    public static DBConnectionInfo get() {
        return REPO.get(PROPERTY_PATH);
    }

    public static DBConnectionInfo get(String propertyPath) {
        if (REPO.containsKey(propertyPath))
            return REPO.get(propertyPath);

        REPO.put(propertyPath, new DBConnectionInfo(propertyPath));
        return REPO.get(propertyPath);
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
