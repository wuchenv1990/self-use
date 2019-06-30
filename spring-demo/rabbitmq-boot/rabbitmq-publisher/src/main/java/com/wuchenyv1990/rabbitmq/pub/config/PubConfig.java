package com.wuchenyv1990.rabbitmq.pub.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PubConfig {

    public static final String DIRECT_EXCHANGE = "directExchange";

    public static final String FANOUT_EXCHANGE = "fanoutExchange";

    @Bean
    public DirectExchange directExch() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public FanoutExchange fanoutExch() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

}
