package com.wuchenyv1990.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.wuchenyv1990.web.common.Result;
import com.wuchenyv1990.web.util.JsonUtils;
import org.apache.http.HttpEntity;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class WebTest {

    @LocalServerPort
    private int port = 8080;

    RestTemplate restTemplate = new RestTemplate();

    private String baseUrl;

    @PostConstruct
    public void init() {
        baseUrl = "http://127.0.0.1:" + port;
    }

    @Test
    public void t1_digest() throws IOException {
        CloseableHttpResponse response = executeRequest(
            "rest",
            "admin",
            baseUrl + "/rest/test"
        );
        HttpEntity entity = response.getEntity();
        String rawResult = EntityUtils.toString(entity);
        System.out.println(rawResult);
        Result<String> result = JsonUtils.loadGeneric(
            rawResult,
            new TypeReference<Result<String>>() {
            }
        );
        Assert.assertEquals("rest", result.getData());
    }

    @Test
    public void t2_no_permission() throws IOException {
        CloseableHttpResponse response = executeRequest(
            "viewer",
            "admin",
            baseUrl + "/rest/test"
        );
        HttpEntity entity = response.getEntity();
        String rawResult = EntityUtils.toString(entity);
        System.out.println(rawResult);
        Result<String> result = JsonUtils.loadGeneric(
            rawResult,
            new TypeReference<Result<String>>() {
            }
        );
        Assert.assertEquals("rest", result.getData());
    }

    private CloseableHttpResponse executeRequest(String username, String password, String path)
        throws IOException {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials =
            new UsernamePasswordCredentials(username, password);
        provider.setCredentials(AuthScope.ANY, credentials);

        CloseableHttpClient client = HttpClients.custom()
            .setDefaultCredentialsProvider(provider)
            .build();

        HttpGet get = new HttpGet(path);
        get.addHeader("Content-type","application/json; charset=utf-8");
        get.setHeader("Accept", "application/json");
        return client.execute(get);
    }

    @Test
    public void t3_from() {
        ResponseEntity<String> response = restTemplate.postForEntity(
            baseUrl + "/login?username=admin&password=admin",
            null,
            String.class
        );
        String session = response.getHeaders().getFirst("Set-Cookie");
        Assert.assertNotNull(session);
        RequestEntity entity = RequestEntity.get(URI.create(baseUrl + "/svc/test"))
            .header(HttpHeaders.COOKIE, session)
            .build();
        ResponseEntity<String> getResult = restTemplate.exchange(entity, String.class);
        Result<String> result = JsonUtils.loadGeneric(
            getResult.getBody(),
            new TypeReference<Result<String>>() {
            }
        );
        Assert.assertEquals("svc", result.getData());
    }

    @Test
    public void t4_from_no_permission() {
        ResponseEntity<String> response = restTemplate.postForEntity(
            baseUrl + "/login?username=viewer&password=admin",
            null,
            String.class
        );
        String session = response.getHeaders().getFirst("Set-Cookie");
        Assert.assertNotNull(session);
        RequestEntity entity = RequestEntity.get(URI.create(baseUrl + "/svc/test"))
            .header(HttpHeaders.COOKIE, session)
            .build();
        ResponseEntity<String> getResult = restTemplate.exchange(entity, String.class);
        Result<String> result = JsonUtils.loadGeneric(
            getResult.getBody(),
            new TypeReference<Result<String>>() {
            }
        );
        Assert.assertEquals("/svc/test", result.getMessage());
    }

}
