package com.wuchenyv1990.web;

import com.wuchenyv1990.web.util.JsonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@RunWith(SpringRunner.class)
//@SpringBootTest(classes = WebApplication.class)
public class WebTest {

    RestTemplate restTemplate = new RestTemplate();

    private final String baseUrl = "http://127.0.0.1:8080";

    @Test
    public void t2_from() {
        ResponseEntity<String> response = restTemplate.postForEntity(
            baseUrl + "/login?username=admin&password=admin",
            null,
            String.class
        );
        String session = response.getHeaders().getFirst("Set-Cookie");

        RequestEntity entity = RequestEntity.get(URI.create(baseUrl + "/svc/test"))
            .header("JSESSIONID", session)
            .build();

        ResponseEntity<String> getResult = restTemplate.exchange(entity, String.class);
    }

}
