package com.wuchenyv1990.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan("com.wuchenyv1990.mybatis.mapper")
@SpringBootApplication
@EnableTransactionManagement
public class MyBatisAppMain {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisAppMain.class, args);
    }

}
