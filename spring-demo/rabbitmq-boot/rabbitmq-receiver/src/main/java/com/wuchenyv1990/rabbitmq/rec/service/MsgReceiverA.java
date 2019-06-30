package com.wuchenyv1990.rabbitmq.rec.service;

import com.wuchenyv1990.rabbitmq.rec.config.RecConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(
        containerFactory = "rabbitListenerContainerFactory",
        bindings = {
                @QueueBinding(
                        value = @Queue(value = RecConfig.QUEUE_A),
                        exchange = @Exchange(value = RecConfig.DIRECT_EXCHANGE),
                        key = RecConfig.ROUTING_A
                ),
                @QueueBinding(
                        value = @Queue(value = RecConfig.QUEUE_A),
                        exchange = @Exchange(
                                value = RecConfig.FANOUT_EXCHANGE,
                                type = ExchangeTypes.FANOUT
                        )
                )}
)
public class MsgReceiverA {

    @RabbitHandler
    public void process(byte[] content) {
        log.info("A received: {}", new String(content));
    }

    @RabbitHandler
    public void process(String str) {
        log.info("A received: {}", str);
    }

    @RabbitHandler
    public void process(Message message) {
        log.info("A received: {}", message);
    }

}
