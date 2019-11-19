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
@RabbitListener(bindings = {
        @QueueBinding(
                value = @Queue(value = RecConfig.QUEUE_B),
                exchange = @Exchange(value = RecConfig.DIRECT_EXCHANGE),
                key = RecConfig.ROUTING_B
        ),
        @QueueBinding(
                value = @Queue(value = RecConfig.QUEUE_B),
                exchange = @Exchange(
                        value = RecConfig.FANOUT_EXCHANGE,
                        type = ExchangeTypes.FANOUT
                )
        ),
        @QueueBinding(
                value = @Queue(
                        value = RecConfig.QUEUE_C,
                        arguments = {
                                @Argument(name = "x-max-length", value = "10", type = "java.lang.Integer"),
                                @Argument(name = "x-overflow", value = "reject-publish")
                        }
                ),
                exchange = @Exchange(
                        value = RecConfig.FANOUT_EXCHANGE,
                        type = ExchangeTypes.FANOUT
                )
        )}
)
public class MsgReceiverB {

    @RabbitHandler
    public void process(byte[] content, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("B received: {}", new String(content));
        Common.ack(channel, tag, log);
    }

    @RabbitHandler
    public void process(String str, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("B received: {}", str);
        Common.ack(channel, tag, log);
    }

    @RabbitHandler
    public void process(Message message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        log.info("B received: {}", message);
        Common.ack(channel, tag, log);
    }

}
