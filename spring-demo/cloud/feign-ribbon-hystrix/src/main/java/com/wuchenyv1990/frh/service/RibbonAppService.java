package com.wuchenyv1990.frh.service;

import com.wuchenyv1990.frh.client.ribbon.AppRibbonCli;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RibbonAppService {

    @Autowired
    AppRibbonCli appRibbonCli;

    public String getInfo() {
        return appRibbonCli.getInfo();
    }

    public String getInfoByApi() {
        return appRibbonCli.getInfoByApi();
    }

    public String doFailCall() {
        return appRibbonCli.failCall();
    }

    public String error500() {
        return appRibbonCli.error500();
    }

}
