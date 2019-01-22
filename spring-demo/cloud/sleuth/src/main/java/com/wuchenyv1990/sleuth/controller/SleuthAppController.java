package com.wuchenyv1990.sleuth.controller;

import com.wuchenyv1990.sleuth.client.EurekaAppClient;
import com.wuchenyv1990.sleuth.client.FRHAppClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sleuth")
public class SleuthAppController {

    @Autowired
    EurekaAppClient eurekaAppClient;

    @Autowired
    FRHAppClient frhAppClient;

    @GetMapping("frhServiceName")
    public String getFRHServiceName() {
        return frhAppClient.getFRHServiceName();
    }

    @GetMapping("eurekaCliServiceName")
    public String getEurekaCliServiceName() {
        return eurekaAppClient.getEurekaCliServiceName();
    }

    @GetMapping("feignInfo")
    public String feignInfo() {
        return frhAppClient.getInfo();
    }

    @GetMapping("ribbonInfo")
    public String ribbonInfo() {
        return frhAppClient.getInfoRibbon();
    }

}
