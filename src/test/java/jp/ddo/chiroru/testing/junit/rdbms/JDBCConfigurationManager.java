package jp.ddo.chiroru.testing.junit.rdbms;

public class JDBCConfigurationManager {

    public static JDBCConfiguration getConfiguration(Class<?> clazz) {
        try {
            Object obj = clazz.newInstance();
            if (obj instanceof JDBCConfiguration) {
                return (JDBCConfiguration)clazz.newInstance();
            } else {
                throw new RuntimeException("指定されたクラス" + clazz.getSimpleName() + " はインタフェース JDBCConfiguration のAPI仕様に違反しています");
            }
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("JDBC Configuration の取得に失敗しました", e);
        }
    }
}
