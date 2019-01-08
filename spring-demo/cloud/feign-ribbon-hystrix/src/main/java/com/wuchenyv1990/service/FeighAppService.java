package com.wuchenyv1990.service;

import com.wuchenyv1990.client.feign.AppFeignCli;
import com.wuchenyv1990.service.itf.AppServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("feighAppService")
public class FeighAppService implements AppServiceItf {

    @Autowired
    AppFeignCli appFeignCli;

    @Override
    public String getInfo() {
        return appFeignCli.getInfo();
    }
}
