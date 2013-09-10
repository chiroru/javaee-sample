package jp.ddo.chiroru.testing.junit.jpa;

import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jp.ddo.chiroru.testing.junit.rdbms.JDBCConfiguration;
import jp.ddo.chiroru.testing.junit.rdbms.JDBCConfigurationManager;
import jp.ddo.chiroru.testing.junit.rdbms.PlainJDBCConfiguration;

import org.junit.rules.ExternalResource;

public class EntityManagerResource
        extends ExternalResource {

    private EntityManager em;
    private String persistenceUnitName;
    private JDBCConfiguration config = JDBCConfigurationManager.getConfiguration(PlainJDBCConfiguration.class);

    public EntityManagerResource(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public EntityManagerResource(String persistenceUnitName, Class<JDBCConfiguration> clazz) {
        this.persistenceUnitName = persistenceUnitName;
        this.config = JDBCConfigurationManager.getConfiguration(clazz);
    }

    @Override
    protected void before()
            throws Throwable {

        HashMap<String, String> settings = new HashMap<String, String>();
        settings.put("javax.persistence.jdbc.user", config.getUserName());
        settings.put("javax.persistence.jdbc.password", config.getPassword());
        settings.put("javax.persistence.jdbc.url", config.getUrl());
        settings.put("javax.persistence.jdbc.driver", config.getDriver());
        settings.put("javax.persistence.jdbc.schema", config.getSchema());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.persistenceUnitName, settings);
        em = emf.createEntityManager();
    }

        @Override
    protected void after() {
        if (em != null)
            em.close();
    }

    public EntityManager getEntityManager() {
        return em;
    }
}
