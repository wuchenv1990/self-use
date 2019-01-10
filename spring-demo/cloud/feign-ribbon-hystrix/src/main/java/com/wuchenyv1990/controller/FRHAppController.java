package com.wuchenyv1990.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本服务提供接口
 */
@RestController
@RequestMapping("frh")
public class FRHAppController {

    @Value("${spring.application.name}")
    private String serviceName;

    @GetMapping("serviceName")
    public String serviceName() {
        return serviceName;
    }

}
