package com.wuchenyv1990.eureka.client.service;

import com.wuchenyv1990.eureka.client.service.itf.ServiceItf;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("b")
public class ServiceB implements ServiceItf {
    @Override
    public String getInfo() {
        return "(｀Д´#)==3";
    }
}
