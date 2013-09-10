/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ddo.chiroru.testing.util.restAssured;

import java.io.IOException;
import java.util.Properties;

import jp.ddo.chiroru.testing.resource.ClassPathPropertyLoader;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.specification.RequestSpecification;

public class LoggingRestAssured
        extends RestAssured {

    private final static String INTEGRATIONTEST_CONFIG_FILE = "IntegrationTest.properties";
    static {
        ClassPathPropertyLoader loader = ClassPathPropertyLoader.getInstance();
        try {
            Properties props = loader.load(INTEGRATIONTEST_CONFIG_FILE);
            baseURI = props.getProperty("base.uri");
            port = Integer.parseInt(props.getProperty("port"));
            basePath = props.getProperty("context.path");
        } catch (IOException e) {
            throw new RuntimeException("Integration Test の設定ファイル[" + INTEGRATIONTEST_CONFIG_FILE + "]の読み込みに失敗しました");
        }
    }

    public static RequestSpecification given() {
        return new LoggingRequestSpecification(RestAssured.given());
    }
}
