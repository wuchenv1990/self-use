package com.wuchenyv1990.exe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ExeMain {

    public static void main(String[] args) {
        SpringApplication.run(ExeMain.class, args);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

}
