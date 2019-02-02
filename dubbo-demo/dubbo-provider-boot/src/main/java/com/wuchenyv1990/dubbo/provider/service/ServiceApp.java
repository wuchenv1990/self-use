package com.wuchenyv1990.dubbo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.wuchenyv1990.dubbo.api.ServiceApi;

@Service(
    version = "${service.version}",
    group = "${service.group}")
public class ServiceApp implements ServiceApi {
    @Override
    public String getInfo() {
        return "service api called.";
    }
}
