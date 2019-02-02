package com.wuchenyv1990.dubbo.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wuchenyv1990.dubbo.api.ServiceApi;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @Reference(
        version = "${service.version}",
        group = "${service.group}"
    )
    private ServiceApi serviceApi;

    public String getInfo() {
        return serviceApi.getInfo();
    };

}
