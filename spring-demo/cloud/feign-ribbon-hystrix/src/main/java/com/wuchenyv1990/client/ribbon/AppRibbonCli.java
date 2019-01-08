package com.wuchenyv1990.client.ribbon;

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

    @Autowired
    @Qualifier("ribbonTemplate")
    RestTemplate ribbonTemplate;

    @Autowired
    LoadBalancerClient loadBalancer;

    public String getInfo() {
        return ribbonTemplate.getForObject(String.format("http://%s/%s", EUREKA_CLIENT, URL_INFO), String.class);
    }

    /**
     * 直接使用ribbon api
     * @return 返回结果
     */
    public String getInfoByApi() {
        ServiceInstance instance = loadBalancer.choose(EUREKA_CLIENT);
        URI getInfoUri = URI.create(String.format("http://%s:%s/%s", instance.getHost(), instance.getPort(), URL_INFO));
        return ribbonTemplate.getForObject(getInfoUri, String.class);
    }

}
