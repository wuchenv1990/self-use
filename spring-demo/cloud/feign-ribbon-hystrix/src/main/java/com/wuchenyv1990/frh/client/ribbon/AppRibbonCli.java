package com.wuchenyv1990.frh.client.ribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class AppRibbonCli {

    static private final String EUREKA_CLIENT = "eureka-client";

    static private final String URL_INFO = "app/info";

    static private final String URL_NULL = "app/nullPath";

    static private final String URL_500 = "app/error500";

    @Autowired
    @Qualifier("ribbonTemplate")
    RestTemplate ribbonTemplate;

    //普通restTemplate
    @Autowired
    @Qualifier("restTemplate")
    RestTemplate restTemplate;

    @Autowired
    LoadBalancerClient loadBalancer;

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getInfo() {
        return ribbonTemplate.getForObject(String.format("http://%s/%s", EUREKA_CLIENT, URL_INFO), String.class);
    }

    /**
     * 直接使用ribbon api
     * @return 返回结果
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String getInfoByApi() {
        ServiceInstance instance = loadBalancer.choose(EUREKA_CLIENT);
        URI getInfoUri = URI.create(String.format("http://%s:%s/%s", instance.getHost(), instance.getPort(), URL_INFO));
        return restTemplate.getForObject(getInfoUri, String.class);
    }

    /**
     * 没有对应路径，测试熔断
     * @return String
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String failCall() {
        return ribbonTemplate.getForObject(String.format("http://%s/%s", EUREKA_CLIENT, URL_NULL), String.class);
    }

    /**
     * code 500
     * @return String
     */
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public String error500() {
        return ribbonTemplate.getForObject(String.format("http://%s/%s", EUREKA_CLIENT, URL_500), String.class);
    }

    protected String fallbackMethod() {
        return "Ribbon's hystrix fallback";
    }

}
