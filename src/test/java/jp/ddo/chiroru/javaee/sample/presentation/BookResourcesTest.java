package jp.ddo.chiroru.javaee.sample.presentation;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jp.ddo.chiroru.javaee.sample.common.validation.validator.ValidationExceptionMapper;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationFeature;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

public class BookResourcesTest
        extends JerseyTest {

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);
        ResourceConfig config =  new ResourceConfig();
        config.register(org.glassfish.jersey.jackson.JacksonFeature.class);
        config.register(ValidationConfigurationContextResolver.class);
        config.register(ValidationFeature.class);
        config.register(ValidationExceptionMapper.class);
        config.register(BookResources.class);
        return config;
    }
 
    @Test
    public void test1() {
        String result = target("/books").request().get(String.class);
        System.out.println(result);
    }

    @Test
    public void test2() {
        Client client = client();
        String result = client.target("http://localhost:9998/books/1").queryParam("mail", "aaa.com").request().get(String.class);
        //String result = target("/books/1").request().get(String.class);
        System.out.println(result);
    }
}
