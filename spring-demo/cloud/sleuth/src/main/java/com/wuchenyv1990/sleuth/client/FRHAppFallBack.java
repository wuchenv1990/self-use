package com.wuchenyv1990.sleuth.client;

import org.springframework.stereotype.Component;

@Component
public class FRHAppFallBack implements FRHAppClient {
    @Override
    public String getFRHServiceName() {
        return "unknown";
    }

    @Override
    public String getInfo() {
        return "unknown";
    }

    @Override
    public String getInfoRibbon() {
        return "unknown";
    }
}
