package com.wuchenyv1990.frh.infra;

import com.netflix.hystrix.strategy.HystrixPlugins;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@ConfigurationProperties("feign.hystrix.enabled")
public class HystrixConfig {

    @PostConstruct
    public void init() {
        HystrixPlugins.getInstance().registerConcurrencyStrategy(
                new RequestContextConcurrencyStrategy()
        );
    }

}
