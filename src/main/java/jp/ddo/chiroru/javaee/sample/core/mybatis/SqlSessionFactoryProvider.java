package jp.ddo.chiroru.javaee.sample.core.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;

/**
 * 
 * コンフィグレーション
 * クラスパス直下に{@code sqlmap-config.xml}を配置する。
 * 
 * @author chiroru_0130@yahoo.co.jp
 */
public class SqlSessionFactoryProvider {

    private static final String SQLMAP_CONFIG_PATH = "sqlmap-config.xml";

    private Environment environment;

    private Properties props;

    private String sqlmapConfigPath;

    public SqlSessionFactoryProvider(Environment environment) {
        this(environment, null);
    }

    public SqlSessionFactoryProvider(Environment environment, Properties props) {
        this(environment, props, SQLMAP_CONFIG_PATH);
    }

    public SqlSessionFactoryProvider(Environment environment, Properties props, String sqlmapConfigPath) {
        this.environment = environment;
        this.props = props;
        this.sqlmapConfigPath = sqlmapConfigPath;
    }

    private void setUp() {
        Configuration configuration;
        try {
            InputStream is = Resources.getResourceAsStream(sqlmapConfigPath);
            XMLConfigBuilder xmlConfigBuilder =
                    new XMLConfigBuilder(is, environment.getMyBatisEnvironment(), props);
            configuration = xmlConfigBuilder.getConfiguration();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
