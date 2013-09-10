/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ddo.chiroru.testing.util.restAssured;

import com.google.common.collect.Iterators;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.mapper.ObjectMapper;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingResponse
        implements Response {

    private final static Logger L = LoggerFactory.getLogger(LoggingResponse.class);

    private Response instance;
    private String buffer = null;

    public LoggingResponse(Response instance) {
        this.instance = instance;
        dumpResponse();
    }

    @Override
    public Response andReturn() {
        return this.instance.andReturn();
    }

    @Override
    public Response thenReturn() {
        return this.instance.thenReturn();
    }

    @Override
    public ResponseBody body() {
        return this.instance.body();
    }

    @Override
    public ResponseBody getBody() {
        return this.instance.getBody();
    }

    @Override
    public Headers headers() {
        return this.instance.headers();
    }

    @Override
    public Headers getHeaders() {
        return this.instance.getHeaders();
    }

    @Override
    public String header(String name) {
        return this.instance.header(name);
    }

    @Override
    public String getHeader(String name) {
        return this.instance.getHeader(name);
    }

    @Override
    public Map<String, String> cookies() {
        return this.instance.cookies();
    }

    @Override
    public Cookies detailedCookies() {
        return this.instance.detailedCookies();
    }

    @Override
    public Map<String, String> getCookies() {
        return this.instance.getCookies();
    }

    @Override
    public Cookies getDetailedCookies() {
        return this.instance.getDetailedCookies();
    }

    @Override
    public String cookie(String name) {
        return this.instance.cookie(name);
    }

    @Override
    public String getCookie(String name) {
        return this.instance.getCookie(name);
    }

    @Override
    public Cookie detailedCookie(String name) {
        return this.instance.detailedCookie(name);
    }

    @Override
    public Cookie getDetailedCookie(String name) {
        return this.instance.getDetailedCookie(name);
    }

    @Override
    public String contentType() {
        return this.instance.contentType();
    }

    @Override
    public String getContentType() {
        return this.instance.getContentType();
    }

    @Override
    public String statusLine() {
        return this.instance.statusLine();
    }

    @Override
    public String getStatusLine() {
        return this.instance.getStatusLine();
    }

    @Override
    public String sessionId() {
        return this.instance.sessionId();
    }

    @Override
    public String getSessionId() {
        return this.instance.getSessionId();
    }

    @Override
    public int statusCode() {
        return this.instance.statusCode();
    }

    @Override
    public int getStatusCode() {
        return this.instance.getStatusCode();
    }

    @Override
    public String print() {
        return this.instance.print();
    }

    @Override
    public String prettyPrint() {
        return this.instance.prettyPrint();
    }

    @Override
    public <T> T as(Class<T> cls) {
        return this.instance.as(cls);
    }

    @Override
    public <T> T as(Class<T> cls, ObjectMapperType mapperType) {
        return this.instance.as(cls, mapperType);
    }

    @Override
    public <T> T as(Class<T> cls, ObjectMapper mapper) {
        return this.instance.as(cls, mapper);
    }

    @Override
    public JsonPath jsonPath() {
        return this.instance.jsonPath();
    }

    @Override
    public XmlPath xmlPath() {
        return this.instance.xmlPath();
    }

    @Override
    public <T> T path(String path) {
        return this.instance.path(path);
    }

    @Override
    public String asString() {
        if (buffer == null) {
            buffer = this.instance.asString();
        }
        return buffer;
    }

    @Override
    public byte[] asByteArray() {
        return this.instance.asByteArray();
    }

    @Override
    public InputStream asInputStream() {
        return this.instance.asInputStream();
    }

    private void dumpResponse() {
        L.info(generateDumpString());
    }

    private String generateDumpString() {
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("\n");
            builder.append("Status Code:\t");
            builder.append(this.getStatusCode());
            builder.append("\n");
            builder.append("Headers:");
            Headers headers = this.getHeaders();
            for (Header h : Iterators.toArray(headers.iterator(), Header.class)) {
                builder.append("\t");
                builder.append(h.getName());
                builder.append("=");
                builder.append(h.getValue());
                builder.append("\n");
            }
            builder.append("\n");
            builder.append("Cookies:\t");
            Map<String, String> cookies = this.getCookies();
            for (String key : cookies.keySet()) {
                builder.append(key);
                builder.append("=");
                builder.append(cookies.get(key));
                builder.append("\n\t");
            }
            builder.append("\n");
            builder.append("Body:\t");
            builder.append(new String(this.asString().getBytes("ISO-8859-1"), "UTF-8"));
            return builder.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
