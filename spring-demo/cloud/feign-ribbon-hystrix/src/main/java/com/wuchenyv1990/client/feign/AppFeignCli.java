package com.wuchenyv1990.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("eureka-client")
public interface AppFeignCli {

    @GetMapping("/app/info")
    String getInfo();

}
