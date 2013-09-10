package jp.ddo.chiroru.testing.junit.dbunit;

import org.dbunit.AbstractDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.ext.h2.H2DataTypeFactory;

public class DBUnitOperator
        extends AbstractDatabaseTester {

    private static final DBConnectionManager manager = DBConnectionManager.getInstance();

    public DBUnitOperator(String schema) {
        //setSchema(DBConnectionManager.getDBConnectionInfo().getSchema());
        super(schema);
    }

    @Override
    public IDatabaseConnection getConnection() throws Exception {
        DatabaseConnection databaseConnection =
                new DatabaseConnection(manager.getConnection(), getSchema());
        DatabaseConfig config = databaseConnection.getConfig();
        config.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new H2DataTypeFactory());
        return databaseConnection;
    }
}
