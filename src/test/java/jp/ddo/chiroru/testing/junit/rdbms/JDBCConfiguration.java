package jp.ddo.chiroru.testing.junit.rdbms;

public interface JDBCConfiguration {

    String getUrl();

    String getUserName();

    String getPassword();

    String getDriver();

    String getSchema();
}
