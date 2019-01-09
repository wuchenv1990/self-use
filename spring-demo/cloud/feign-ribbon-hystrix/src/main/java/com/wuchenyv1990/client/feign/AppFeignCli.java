package com.wuchenyv1990.client.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * name 服务名，使用ribbon做lb，名字取相同
 * 两种方式
 */
//@FeignClient(name = "eureka-client", fallback = AppFeignCliFallback.class)
@FeignClient(name = "eureka-client", fallbackFactory = AppFallbackFactory.class)
public interface AppFeignCli {

    @GetMapping("/app/info")
    String getInfo();

    /**
     * 没有对应路径，测试熔断
     * @return String
     */
    @GetMapping("/app/nullPath")
    String failCall();

    /**
     * SynchronousMethodHandler中处理return code
     * 200~300|404|其余throw Exception
     * @return String
     */
    @GetMapping("/app/error500")
    String error500();

}
