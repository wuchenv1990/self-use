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
import java.util.stream.IntStream;

@Ignore
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    ServiceBar bar;

    @Test
    public void shouldCacheWorked() {
        IntStream.range(1, 10)
                .forEach(i -> {
                            try {
                                TimeUnit.SECONDS.sleep(1);
                                System.out.println(LocalTime.now() + " get value : " + bar.getValue("key"));
                            } catch (InterruptedException e) {
                            }
                        }
                );

    }

}
