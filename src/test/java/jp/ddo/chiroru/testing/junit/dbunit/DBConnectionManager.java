package jp.ddo.chiroru.testing.junit.dbunit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {

    private final static DBConnectionInfo CONNECTION_INFO = new DBConnectionInfo();
    private final static DBConnectionManager INSTANCE = new DBConnectionManager();

    private DBConnectionManager() {
    }

    public static DBConnectionManager getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        try {
            Connection conn;
            if (CONNECTION_INFO.getUsername() == null && CONNECTION_INFO.getPassword() == null) {
                conn = DriverManager.getConnection(CONNECTION_INFO.getUrl());
            } else {
                conn = DriverManager.getConnection(
                        CONNECTION_INFO.getUrl(),
                        CONNECTION_INFO.getUsername(),
                        CONNECTION_INFO.getPassword());
            }
            return conn;
        } catch (SQLException e) {
            throw new RuntimeException("データベースの接続の作成に失敗しました.");
        }
    }

    public static DBConnectionInfo getDBConnectionInfo() {
        return CONNECTION_INFO;
    }
}
