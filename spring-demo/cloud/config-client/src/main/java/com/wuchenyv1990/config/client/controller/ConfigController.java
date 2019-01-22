package com.wuchenyv1990.config.client.controller;

import com.wuchenyv1990.config.client.service.ConfigClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    ConfigClient configClient;

    @GetMapping("projectName")
    public String getProjectName() {
        return configClient.getProjectName();
    }

    @GetMapping("projectDesc")
    public String getProjectDesc() {
        return configClient.getProjectDescription();
    }


}
