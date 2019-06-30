package com.wuchenyv1990.rabbitmq.pub.service;

import com.wuchenyv1990.rabbitmq.pub.config.PubConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ReturnCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MsgSender implements ConfirmCallback, ReturnCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("ack: {}, cause:{}", ack, cause);
    }

    public void send(String routingKey, String msg) {
        rabbitTemplate.convertAndSend(PubConfig.DIRECT_EXCHANGE, routingKey, msg);
    }

    public void broadcast(String msg) {
        rabbitTemplate.convertAndSend(PubConfig.FANOUT_EXCHANGE, "", msg);
    }

    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("Message: {}, replyCode: {}, replyText: {}, exchange: {}, routingKey: {}",
                message, replyCode, replyText, exchange, routingKey);
    }
}
