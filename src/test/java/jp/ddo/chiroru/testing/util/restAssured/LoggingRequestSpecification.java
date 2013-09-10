/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.ddo.chiroru.testing.util.restAssured;

import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.filter.Filter;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import com.jayway.restassured.mapper.ObjectMapper;
import com.jayway.restassured.response.Cookie;
import com.jayway.restassured.response.Cookies;
import com.jayway.restassured.response.Header;
import com.jayway.restassured.response.Headers;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.AuthenticationSpecification;
import com.jayway.restassured.specification.MultiPartSpecification;
import com.jayway.restassured.specification.RedirectSpecification;
import com.jayway.restassured.specification.RequestLogSpecification;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;

public class LoggingRequestSpecification
implements RequestSpecification {

    private static final Logger L = LoggerFactory.getLogger(LoggingRequestSpecification.class);

    private RequestSpecification instance;

    public LoggingRequestSpecification(RequestSpecification instance) {
        this.instance = instance;
    }

    @Override
    public RequestSpecification body(String body) {
        return new LoggingRequestSpecification(instance.body(body));
    }

    @Override
    public RequestSpecification body(byte[] body) {
        return new LoggingRequestSpecification(this.instance.body(body));
    }

    @Override
    public RequestSpecification body(Object object) {
        return new LoggingRequestSpecification(this.instance.body(object));
    }

    @Override
    public RequestSpecification body(Object object, ObjectMapper mapper) {
        return new LoggingRequestSpecification(this.instance.body(object, mapper));
    }

    @Override
    public RequestSpecification body(Object object, ObjectMapperType mapperType) {
        return new LoggingRequestSpecification(this.instance.body(object, mapperType));
    }

    @Override
    public RequestSpecification content(String content) {
        return new LoggingRequestSpecification(this.instance.content(content));
    }

    @Override
    public RequestSpecification content(byte[] content) {
        return new LoggingRequestSpecification(this.instance.content(content));
    }

    @Override
    public RequestSpecification content(Object object) {
        return new LoggingRequestSpecification(this.instance.content(object));
    }

    @Override
    public RequestSpecification content(Object object, ObjectMapperType mapperType) {
        return new LoggingRequestSpecification(this.instance.content(object, mapperType));
    }

    @Override
    public RequestSpecification content(Object object, ObjectMapper mapper) {
        return new LoggingRequestSpecification(this.instance.content(object, mapper));
    }

    @Override
    public RedirectSpecification redirects() {
        return this.instance.redirects();
    }

    @Override
    public RequestSpecification cookies(String firstCookieName, Object firstCookieValue, Object... cookieNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.cookies(firstCookieName, firstCookieValue, cookieNameValuePairs));
    }

    @Override
    public RequestSpecification cookies(Map<String, ?> cookies) {
        return new LoggingRequestSpecification(this.instance.cookies(cookies));
    }

    @Override
    public RequestSpecification cookies(Cookies cookies) {
        return new LoggingRequestSpecification(this.instance.cookies(cookies));
    }

    @Override
    public RequestSpecification cookie(String cookieName, Object value, Object... additionalValues) {
        return new LoggingRequestSpecification(this.instance.cookie(cookieName, value, additionalValues));
    }

    @Override
    public RequestSpecification cookie(String cookieName) {
        return new LoggingRequestSpecification(this.instance.cookie(cookieName));
    }

    @Override
    public RequestSpecification cookie(Cookie cookie) {
        return new LoggingRequestSpecification(this.instance.cookie(cookie));
    }

    @Override
    public RequestSpecification parameters(String firstParameterName, Object firstParameterValue, Object... parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.parameters(firstParameterName, firstParameterValue, parameterNameValuePairs));
    }

    @Override
    public RequestSpecification parameters(Map<String, ?> parametersMap) {
        return new LoggingRequestSpecification(this.instance.parameters(parametersMap));
    }

    @Override
    public RequestSpecification parameter(String parameterName, Object... parameterValues) {
        return new LoggingRequestSpecification(this.instance.parameter(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification parameter(String parameterName, Collection<?> parameterValues) {
        return new LoggingRequestSpecification(this.instance.parameter(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification params(String firstParameterName, Object firstParameterValue, Object... parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.params(firstParameterName, firstParameterValue, parameterNameValuePairs));
    }

    @Override
    public RequestSpecification params(Map<String, ?> parametersMap) {
        return new LoggingRequestSpecification(this.instance.params(parametersMap));
    }

    @Override
    public RequestSpecification param(String parameterName, Object... parameterValues) {

        return new LoggingRequestSpecification(this.instance.param(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification param(String parameterName, Collection<?> parameterValues) {
        return new LoggingRequestSpecification(this.instance.param(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification queryParameters(String firstParameterName, Object firstParameterValue, Object... parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.param(firstParameterName, firstParameterValue, parameterNameValuePairs));
    }

    @Override
    public RequestSpecification queryParameters(Map<String, ?> parametersMap) {
        return new LoggingRequestSpecification(this.instance.queryParameters(parametersMap));
    }

    @Override
    public RequestSpecification queryParameter(String parameterName, Object... parameterValues) {
        return new LoggingRequestSpecification(this.instance.queryParameter(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification queryParameter(String parameterName, Collection<?> parameterValues) {
        return new LoggingRequestSpecification(this.instance.queryParameter(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification queryParams(String firstParameterName, Object firstParameterValue, Object... parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.queryParams(firstParameterName, firstParameterValue, parameterNameValuePairs));
    }

    @Override
    public RequestSpecification queryParams(Map<String, ?> parametersMap) {
        return new LoggingRequestSpecification(this.instance.queryParams(parametersMap));
    }

    @Override
    public RequestSpecification queryParam(String parameterName, Object... parameterValues) {
        return new LoggingRequestSpecification(this.instance.queryParam(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification queryParam(String parameterName, Collection<?> parameterValues) {
        return new LoggingRequestSpecification(this.instance.queryParam(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification formParameters(String firstParameterName, Object firstParameterValue, Object... parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.formParameters(firstParameterName, firstParameterValue, parameterNameValuePairs));
    }

    @Override
    public RequestSpecification formParameters(Map<String, ?> parametersMap) {
        return new LoggingRequestSpecification(this.instance.formParameters(parametersMap));
    }

    @Override
    public RequestSpecification formParameter(String parameterName, Object... parameterValues) {
        return new LoggingRequestSpecification(this.instance.formParam(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification formParameter(String parameterName, Collection<?> parameterValues) {
        return new LoggingRequestSpecification(this.instance.formParam(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification formParams(String firstParameterName, Object firstParameterValue, Object... parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.formParams(firstParameterName, firstParameterValue, parameterNameValuePairs));
    }

    @Override
    public RequestSpecification formParams(Map<String, ?> parametersMap) {
        return new LoggingRequestSpecification(this.instance.formParams(parametersMap));
    }

    @Override
    public RequestSpecification formParam(String parameterName, Object... parameterValues) {
        return new LoggingRequestSpecification(this.instance.formParam(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification formParam(String parameterName, Collection<?> parameterValues) {
        return new LoggingRequestSpecification(this.instance.formParam(parameterName, parameterValues));
    }

    @Override
    public RequestSpecification pathParameter(String parameterName, Object parameterValue) {
        return new LoggingRequestSpecification(this.instance.pathParam(parameterName, parameterValue));
    }

    @Override
    public RequestSpecification pathParameters(String firstParameterName, Object firstParameterValue, Object... parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.pathParameters(firstParameterName, firstParameterValue, parameterNameValuePairs));
    }

    @Override
    public RequestSpecification pathParameters(Map<String, ?> parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.pathParameters(parameterNameValuePairs));
    }

    @Override
    public RequestSpecification pathParam(String parameterName, Object parameterValue) {
        return new LoggingRequestSpecification(this.instance.pathParam(parameterName, parameterValue));
    }

    @Override
    public RequestSpecification pathParams(String firstParameterName, Object firstParameterValue, Object... parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.pathParams(firstParameterName, firstParameterValue, parameterNameValuePairs));
    }

    @Override
    public RequestSpecification pathParams(Map<String, ?> parameterNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.pathParams(parameterNameValuePairs));
    }

    @Override
    public RequestSpecification config(RestAssuredConfig config) {
        return new LoggingRequestSpecification(this.instance.config(config));
    }

    @Override
    public RequestSpecification keystore(String pathToJks, String password) {
        return new LoggingRequestSpecification(this.instance.keystore(pathToJks, password));
    }

    @Override
    public RequestSpecification keystore(File pathToJks, String password) {
        return new LoggingRequestSpecification(this.instance.keystore(pathToJks, password));
    }

    @Override
    public RequestSpecification headers(String firstHeaderName, Object firstHeaderValue, Object... headerNameValuePairs) {
        return new LoggingRequestSpecification(this.instance.headers(firstHeaderName, firstHeaderValue, headerNameValuePairs));
    }

    @Override
    public RequestSpecification headers(Map<String, ?> headers) {
        return new LoggingRequestSpecification(this.instance.headers(headers));
    }

    @Override
    public RequestSpecification headers(Headers headers) {
        return new LoggingRequestSpecification(this.instance.headers(headers));
    }

    @Override
    public RequestSpecification header(String headerName, Object headerValue, Object... additionalHeaderValues) {
        return new LoggingRequestSpecification(this.instance.header(headerName, headerValue, additionalHeaderValues));
    }

    @Override
    public RequestSpecification header(Header header) {
        return new LoggingRequestSpecification(this.instance.header(header));
    }

    @Override
    public RequestSpecification contentType(ContentType contentType) {
        return new LoggingRequestSpecification(this.instance.contentType(contentType));
    }

    @Override
    public RequestSpecification contentType(String contentType) {
        return new LoggingRequestSpecification(this.instance.contentType(contentType));
    }

    @Override
    public RequestSpecification multiPart(MultiPartSpecification multiPartSpecification) {
        return new LoggingRequestSpecification(this.instance.multiPart(multiPartSpecification));
    }

    @Override
    public RequestSpecification multiPart(File file) {
        return new LoggingRequestSpecification(this.instance.multiPart(file));
    }

    @Override
    public RequestSpecification multiPart(String controlName, File file) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, file));
    }

    @Override
    public RequestSpecification multiPart(String controlName, File file, String mimeType) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, file, mimeType));
    }

    @Override
    public RequestSpecification multiPart(String controlName, Object object) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, object));
    }

    @Override
    public RequestSpecification multiPart(String controlName, Object object, String mimeType) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, object, mimeType));
    }

    @Override
    public RequestSpecification multiPart(String controlName, String fileName, byte[] bytes) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, fileName, bytes));
    }

    @Override
    public RequestSpecification multiPart(String controlName, String fileName, byte[] bytes, String mimeType) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, fileName, bytes, mimeType));
    }

    @Override
    public RequestSpecification multiPart(String controlName, String fileName, InputStream stream) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, fileName, stream));
    }

    @Override
    public RequestSpecification multiPart(String controlName, String fileName, InputStream stream, String mimeType) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, fileName, stream, mimeType));
    }

    @Override
    public RequestSpecification multiPart(String controlName, String contentBody) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, contentBody));
    }

    @Override
    public RequestSpecification multiPart(String controlName, String contentBody, String mimeType) {
        return new LoggingRequestSpecification(this.instance.multiPart(controlName, contentBody, mimeType));
    }

    @Override
    public AuthenticationSpecification authentication() {
        return this.instance.authentication();
    }

    @Override
    public AuthenticationSpecification auth() {
        return this.instance.auth();
    }

    @Override
    public RequestSpecification port(int port) {
        return new LoggingRequestSpecification(this.instance.port(port));
    }

    @Override
    public RequestSpecification spec(RequestSpecification requestSpecificationToMerge) {
        return new LoggingRequestSpecification(this.instance.spec(requestSpecificationToMerge));
    }

    @Override
    public RequestSpecification specification(RequestSpecification requestSpecificationToMerge) {
        return new LoggingRequestSpecification(this.instance.specification(requestSpecificationToMerge));
    }

    @Override
    public RequestSpecification sessionId(String sessionIdValue) {
        return new LoggingRequestSpecification(this.instance.sessionId(sessionIdValue));
    }

    @Override
    public RequestSpecification sessionId(String sessionIdName, String sessionIdValue) {
        return new LoggingRequestSpecification(this.instance.sessionId(sessionIdName, sessionIdValue));
    }

    @Override
    public RequestSpecification urlEncodingEnabled(boolean isEnabled) {
        return new LoggingRequestSpecification(this.instance.urlEncodingEnabled(isEnabled));
    }

    @Override
    public RequestSpecification filter(Filter filter) {
        return new LoggingRequestSpecification(this.instance.filter(filter));
    }

    @Override
    public RequestSpecification filters(List<Filter> filters) {
        return new LoggingRequestSpecification(this.instance.filters(filters));
    }

    @Override
    public RequestSpecification filters(Filter filter, Filter... additionalFilter) {
        return new LoggingRequestSpecification(this.instance.filters(filter, additionalFilter));
    }

    @Override
    public RequestSpecification noFilters() {
        return new LoggingRequestSpecification(this.instance.noFilters());
    }

    @Override
    public <T extends Filter> RequestSpecification noFiltersOfType(Class<T> filterType) {
        return new LoggingRequestSpecification(this.instance.noFiltersOfType(filterType));
    }

    @Override
    public RequestLogSpecification log() {
        return this.instance.log();
    }

    @Override
    public ResponseSpecification response() {
        return this.instance.response();
    }

    @Override
    public RequestSpecification and() {
        return new LoggingRequestSpecification(this.instance.and());
    }

    @Override
    public RequestSpecification with() {
        return new LoggingRequestSpecification(this.instance.with());
    }

    @Override
    public ResponseSpecification then() {
        return this.instance.then();
    }

    @Override
    public ResponseSpecification expect() {
        return this.instance.expect();
    }

    @Override
    public RequestSpecification when() {
        return new LoggingRequestSpecification(this.instance.when());
    }

    @Override
    public RequestSpecification given() {
        return new LoggingRequestSpecification(this.instance.given());
    }

    @Override
    public RequestSpecification that() {
        return new LoggingRequestSpecification(this.instance.that());
    }

    @Override
    public RequestSpecification request() {
        return new LoggingRequestSpecification(this.instance.request());
    }

    @Override
    public Response get(String path, Object... pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.get(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response get(String path, Map<String, ?> pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.get(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response post(String path, Object... pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.post(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response post(String path, Map<String, ?> pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.post(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response put(String path, Object... pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.put(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response put(String path, Map<String, ?> pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.put(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response delete(String path, Object... pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.delete(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response delete(String path, Map<String, ?> pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.delete(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response head(String path, Object... pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.head(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response head(String path, Map<String, ?> pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.head(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response patch(String path, Object... pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.patch(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response patch(String path, Map<String, ?> pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.patch(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response options(String path, Object... pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.options(path, pathParams));
        } finally {
            postRequest();
        }
    }

    @Override
    public Response options(String path, Map<String, ?> pathParams) {
        try {
            preRequest();
            return new LoggingResponse(this.instance.options(path, pathParams));
        } finally {
            postRequest();
        }
    }

    private void preRequest() {
        L.info(this.log().all().toString());
    }

    private void postRequest() {
    }

    public String getCallerInfo() {
        StackTraceElement e = new Exception().getStackTrace()[2];
        return e.getClassName() + "#" + e.getMethodName();
    }
}
