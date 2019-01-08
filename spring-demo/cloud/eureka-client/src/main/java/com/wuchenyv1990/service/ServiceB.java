package com.wuchenyv1990.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import com.wuchenyv1990.service.itf.ServiceItf;

@Service
@Profile("b")
public class ServiceB implements ServiceItf {
    @Override
    public String getInfo() {
        return "(｀Д´#)==3";
    }
}
