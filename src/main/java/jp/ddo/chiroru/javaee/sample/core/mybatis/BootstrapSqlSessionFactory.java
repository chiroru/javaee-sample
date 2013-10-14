package jp.ddo.chiroru.javaee.sample.core.mybatis;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.google.common.base.Strings;
import com.google.common.collect.TreeTraverser;
import com.google.common.io.Files;

public class BootstrapSqlSessionFactory {

    private final static String SQLMAP_CONFIG_FILE_PATH = "sqlmap-config.xml";

    private SqlSessionFactory sqlSessionFactory;

    public BootstrapSqlSessionFactory(String environment) {
        this(environment, null);
    }

    public BootstrapSqlSessionFactory(String environment, Properties properties) {
        try {
            InputStream is = Resources.getResourceAsStream(SQLMAP_CONFIG_FILE_PATH);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is, environment, properties);
        } catch (IOException e) {
            throw new RuntimeException("MyBatis設定ファイル[" + SQLMAP_CONFIG_FILE_PATH + "]の読み込みに失敗しました", e);
        }
    }

    public SqlSession generate() {
        return sqlSessionFactory.openSession();
    }

    public void loadXMLFileFromClasspath() {
        String classpath = System.getProperties().getProperty("java.class.path");
        System.out.println(classpath);
    }

    public static void main(String[] args) {
        List<File> xmlFileList = new ArrayList<>();
        String classpaths = System.getProperties().getProperty("java.class.path");
        if (!Strings.isNullOrEmpty(classpaths)) {
            String[] classpathList = classpaths.split(";");
            for (String cp : classpathList) {
                if (!cp.endsWith("jar")) {
                    xmlFileList = traverse(new File(cp));
                }
            }
        }
        
        for (File f : xmlFileList) {
            System.out.println(f.getName());
        }
    }

    public static List<File> traverse(File directory) {
        List<File> xmlFileList = new ArrayList<>();
        TreeTraverser<File> traverser = Files.fileTreeTraverser();
        Iterable<File> children = traverser.children(directory);
        for (File f : children) {
            if (f.isDirectory()) {
                xmlFileList.addAll(traverse(f));
            }
            if ("xml".equals(Files.getFileExtension(f.getName()).toLowerCase())) {
                xmlFileList.add(f);
            }
        }
        return xmlFileList;
    }
}
