package jp.ddo.chiroru.testing.integration.dao.mybatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import jp.ddo.chiroru.javaee.sample.core.mybatis.BootstrapSqlSessionFactory;
import jp.ddo.chiroru.testing.junit.rdbms.JDBCConfiguration;
import jp.ddo.chiroru.testing.junit.rdbms.JDBCConfigurationManager;
import jp.ddo.chiroru.testing.junit.rdbms.PlainJDBCConfiguration;

import org.apache.ibatis.session.SqlSession;
import org.junit.rules.ExternalResource;

public class SqlSessionResource
extends ExternalResource {

    private final static String ENVIRONMENT = "testing";

    private BootstrapSqlSessionFactory factory;

    private JDBCConfiguration config;

    private Map<String, SqlSession> repo;

    public SqlSessionResource() {
        this.config = JDBCConfigurationManager.getConfiguration(PlainJDBCConfiguration.class);
        this.factory = new BootstrapSqlSessionFactory(ENVIRONMENT, convertToProperties(config));
        this.repo = new HashMap<>();
    }

    public SqlSession getSqlSession(String sessionId) {
        if (repo.containsKey(sessionId))
            return repo.get(sessionId);
        SqlSession sqlSession = factory.generate();
        try {
            sqlSession.getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        repo.put(sessionId, sqlSession);
        return repo.get(sessionId);
    }

    @Override
    protected void before()
            throws Throwable {
        
    }

    @Override
    protected void after() {
        System.out.println("[SqlSessionResource] -----> sqlSession#close()");
        for (SqlSession sqlSession : repo.values()) {
            if (sqlSession != null)
                sqlSession.close();
        }
    }
    private Properties convertToProperties(JDBCConfiguration config) {
        Properties props = new Properties();
        props.put("jdbc.driver", config.getDriver());
        props.put("jdbc.url", config.getUrl());
        props.put("jdbc.username", config.getUserName());
        props.put("jdbc.password", config.getPassword());
        return props;
    }
}
