package com.wuchenyv1990.sleuth.client;

import org.springframework.stereotype.Component;

@Component
public class EurekaAppFallback implements EurekaAppClient {

    @Override
    public String getInfo() {
        return "unknown";
    }

    @Override
    public String getEurekaCliServiceName() {
        return "unknown";
    }

}
