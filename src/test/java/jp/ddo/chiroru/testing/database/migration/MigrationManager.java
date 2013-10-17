package jp.ddo.chiroru.testing.database.migration;

import javax.sql.DataSource;

import jp.ddo.chiroru.testing.junit.dbunit.DBConnectionInfo;
import jp.ddo.chiroru.testing.junit.dbunit.DBConnectionManager;
import jp.ddo.chiroru.testing.junit.external.H2DatabaseTCPServerManager;

import org.apache.commons.dbcp.BasicDataSource;

import com.googlecode.flyway.core.Flyway;
import com.googlecode.flyway.core.api.MigrationInfo;
import com.googlecode.flyway.core.api.MigrationInfoService;
import com.googlecode.flyway.core.api.MigrationState;

public class MigrationManager {

    private static MigrationManager INSTANCE = new MigrationManager();
    private static Flyway flyway;
    private DBConnectionInfo connectionInfo;
    private static MigrationInfo info;

    public MigrationManager() {
        connectionInfo = DBConnectionManager.getDBConnectionInfo();
        flyway = new Flyway();
        flyway.setSchemas(connectionInfo.getSchema());
        flyway.setDataSource(getDataSource());
    }

    public static void migrate() {
        synchronized (INSTANCE) {
            info = flyway.info().current();
            if (info == null && !info.getState().isApplied()) {
                flyway.migrate();
            }
        }
    }

    private DataSource getDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(connectionInfo.getUrl());
        dataSource.setDriverClassName(connectionInfo.getDriverClass());
        dataSource.setUsername(connectionInfo.getUsername());
        dataSource.setPassword(connectionInfo.getPassword());
        return dataSource;
    }

    public static void main(String[] args) throws Exception {
        H2DatabaseTCPServerManager h2 = new H2DatabaseTCPServerManager();
        h2.start();
        MigrationManager.migrate();
        h2.stop();
    }
}
