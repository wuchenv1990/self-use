package com.wuchenyv1990.config.client;

import com.wuchenyv1990.config.client.service.ConfigClient;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConfigClientMain.class)
public class ConfigTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    ConfigClient configService;

    @Test
    public void test1() {
        switch (applicationContext.getEnvironment().getProperty("spring.cloud.config.profile")) {
            case "default":
                Assert.assertEquals("spring-demo:cloud", configService.getProjectName());
                Assert.assertEquals("spring cloud demo", configService.getProjectDescription());
                break;
            case "dev" :
                Assert.assertEquals("spring-demo:cloud-dev", configService.getProjectName());
                Assert.assertEquals("spring cloud demo[dev]", configService.getProjectDescription());
                break;
            }
    }

}
