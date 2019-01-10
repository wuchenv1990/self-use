package com.wuchenyv1990.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 调用eureka-client
 */
@FeignClient(name = "eureka-client", fallback = EurekaAppFallback.class)
public interface EurekaAppClient {

    @GetMapping("/app/info")
    String getInfo();

    @GetMapping("/app/serviceName")
    String getEurekaCliServiceName();

}
