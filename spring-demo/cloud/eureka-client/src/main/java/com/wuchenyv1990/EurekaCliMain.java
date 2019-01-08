package com.wuchenyv1990;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaCliMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaCliMain.class, args);
    }

}





