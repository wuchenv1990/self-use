package com.wcyv90.kafka.service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import static com.wcyv90.kafka.infra.KafkaConfig.TOPIC_W;

@Component
public class MessageSender {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public MessageSender(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String msg) {
        kafkaTemplate.send(TOPIC_W, msg);
    }

}
