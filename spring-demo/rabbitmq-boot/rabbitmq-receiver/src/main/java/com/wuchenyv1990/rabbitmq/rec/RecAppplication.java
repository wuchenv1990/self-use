package com.wuchenyv1990.rabbitmq.rec;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRabbit
public class RecAppplication {

    public static void main(String[] args) {
        SpringApplication.run(RecAppplication.class, args);
    }

}
