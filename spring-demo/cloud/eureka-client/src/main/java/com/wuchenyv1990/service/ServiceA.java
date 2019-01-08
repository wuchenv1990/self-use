package com.wuchenyv1990.service;

import com.wuchenyv1990.service.itf.ServiceItf;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("a")
public class ServiceA implements ServiceItf {
    @Override
    public String getInfo() {
        return "(- -)/~";
    }
}
