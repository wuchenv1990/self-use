package com.wuchenyv1990;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AppCliMain {

    public static void main(String[] args) {
        SpringApplication.run(AppCliMain.class, args);
    }

}
