package jp.ddo.chiroru.testing.junit.dbunit;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

import com.googlecode.flyway.core.Flyway;

public class Migration {

    private DBConnectionInfo connectionInfo;
    private Flyway flyway;

    public Migration() {
        connectionInfo = DBConnectionManager.getDBConnectionInfo();
        flyway = new Flyway();
        flyway.setSchemas(connectionInfo.getSchema());
        flyway.setDataSource(getDataSource());
    }

    public void migrate() {
        flyway.migrate();
    }

    private DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(connectionInfo.getUrl());
        dataSource.setDriverClassName(connectionInfo.getDriverClass());
        dataSource.setUsername(connectionInfo.getUsername());
        dataSource.setPassword(connectionInfo.getPassword());
        return dataSource;
    }
}
