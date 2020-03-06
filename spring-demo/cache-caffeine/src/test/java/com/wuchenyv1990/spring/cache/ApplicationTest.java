package com.wuchenyv1990.spring.cache;

import com.wuchenyv1990.spring.cache.service.ServiceBar;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    ServiceBar bar;

    @Test
    public void shouldCacheWorked() throws InterruptedException {
        for (int i = 1; i < 10; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(LocalTime.now() + " get value : " + bar.getValue("key"));
        }

    }

}
