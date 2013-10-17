package jp.ddo.chiroru.testing.junit.dbunit;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger;

import javax.sql.DataSource;

public class EasyDataSource
        implements DataSource {

    private static final PrintWriter DEFAULT_WRITER = new PrintWriter(System.out);

    private PrintWriter writer = DEFAULT_WRITER;

    private DBConnectionInfo connectionInfo;

    public EasyDataSource() {
        this.connectionInfo = DBConnectionManager.getDBConnectionInfo();
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return writer;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        this.writer = out;
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        // do nothing.
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public Connection getConnection() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Connection getConnection(String username, String password)
            throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

}
