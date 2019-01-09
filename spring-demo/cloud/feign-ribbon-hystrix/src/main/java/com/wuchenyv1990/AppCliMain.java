package com.wuchenyv1990;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableHystrixDashboard
@EnableCircuitBreaker
public class AppCliMain {

    public static void main(String[] args) {
        SpringApplication.run(AppCliMain.class, args);
    }

}
