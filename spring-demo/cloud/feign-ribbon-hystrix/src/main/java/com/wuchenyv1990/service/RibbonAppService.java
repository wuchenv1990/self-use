package com.wuchenyv1990.service;

import com.wuchenyv1990.client.ribbon.AppRibbonCli;
import com.wuchenyv1990.service.itf.AppServiceItf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RibbonAppService implements AppServiceItf {

    @Autowired
    AppRibbonCli appRibbonCli;

    @Override
    public String getInfo() {
        return appRibbonCli.getInfo();
    }

    public String getInfoByApi() {
        return appRibbonCli.getInfoByApi();
    }
}
