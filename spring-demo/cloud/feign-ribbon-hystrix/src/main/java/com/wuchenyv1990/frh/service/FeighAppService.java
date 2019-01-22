package com.wuchenyv1990.frh.service;

import com.wuchenyv1990.frh.client.feign.AppFeignCli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeighAppService {

    @Autowired
    AppFeignCli appFeignCli;

    public String getInfo() {
        return appFeignCli.getInfo();
    }

    public String doFailCall() {
        return appFeignCli.failCall();
    }

    public String error500() {
        return appFeignCli.error500();
    }
}
