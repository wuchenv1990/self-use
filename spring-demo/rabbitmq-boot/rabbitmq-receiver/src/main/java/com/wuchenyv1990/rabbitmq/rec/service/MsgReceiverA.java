package com.wuchenyv1990.rabbitmq.rec.service;

import com.rabbitmq.client.Channel;
import com.wuchenyv1990.rabbitmq.rec.Common;
import com.wuchenyv1990.rabbitmq.rec.config.RecConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
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
    public void process(byte[] content, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("A received: {}", new String(content));
        Common.ack(channel, tag, log);
    }

    @RabbitHandler
    public void process(String str, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("A received: {}", str);
        Common.ack(channel, tag, log);
    }

    @RabbitHandler
    public void process(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("A received: {}", message);
        Common.ack(channel, tag, log);
    }

}
