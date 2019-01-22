package com.wuchenyv1990.frh.controller;

import com.wuchenyv1990.frh.service.FeighAppService;
import com.wuchenyv1990.frh.service.RibbonAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 要转发的接口
 */
@RestController
@RequestMapping("appCli")
public class AppClientController {

    @Autowired
    RibbonAppService ribbonAppService;

    @Autowired
    FeighAppService feighAppService;

    @GetMapping("ribbon/info")
    public String ribbonInfo() {
        return ribbonAppService.getInfo();
    }

    @GetMapping("ribbon/info-api")
    public String ribbonInfoByApi() {
        return ribbonAppService.getInfoByApi();
    }

    @GetMapping("feign/info")
    public String feighInfo() {
        return feighAppService.getInfo();
    }

    @GetMapping("feign/nullPath")
    public String feignNullPath() {
        return feighAppService.doFailCall();
    }

    @GetMapping("feign/failCall")
    public String feignFailCall() {
        return feighAppService.error500();
    }

}
