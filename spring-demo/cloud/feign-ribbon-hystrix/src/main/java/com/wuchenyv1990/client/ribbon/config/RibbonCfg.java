package com.wuchenyv1990.client.ribbon.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 只提供了restTemplate
 */
@Configuration
public class RibbonCfg {

    @Bean
    @LoadBalanced
    public RestTemplate ribbonTemplate() {
        return new RestTemplate();
    }


}
