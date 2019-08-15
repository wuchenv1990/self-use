package com.wuchenyv1990.spring.cache.service;

import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class ServiceFoo {

    private Random random = new Random();

    public String getValue(String key) {
        try {
            TimeUnit.SECONDS.sleep(random.nextInt(3));
        } catch (InterruptedException ignore) {
        }
        return LocalTime.now().toString();
    }

}
