package com.wuchenyv1990.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用feign-ribbon-hystrix工程
 */
@FeignClient(name = "app-clients", fallback = FRHAppFallBack.class)
public interface FRHAppClient {

    @GetMapping("/frh/serviceName")
    String getFRHServiceName();

    @GetMapping("/appCli/feign/info")
    String getInfo();

    @GetMapping("/appCli/ribbon/info")
    String getInfoRibbon();

}
