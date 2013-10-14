package jp.ddo.chiroru.javaee.sample.core.mybatis;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.apache.ibatis.session.SqlSession;

@Singleton
@Startup
public class SqlSessionFactoryInjector {

    private static String ENVIRONMENT = "production";
    
    private BootstrapSqlSessionFactory generator;
    
    @PostConstruct
    public void bootstrap() {
        this.generator = new BootstrapSqlSessionFactory(ENVIRONMENT);
    }

    @Produces
    public SqlSession getSqlSession() {
      return generator.generate();
    }
}
