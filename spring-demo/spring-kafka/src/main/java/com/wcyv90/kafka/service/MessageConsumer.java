package com.wcyv90.kafka.service;

import com.wcyv90.kafka.infra.KafkaConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.wcyv90.kafka.infra.KafkaConfig.CONSUMER_GROUP_W;

@Component
@Slf4j
public class MessageConsumer {

    @KafkaListener(id = CONSUMER_GROUP_W, topics = KafkaConfig.TOPIC_W)
    public void onMessage(String msg) {
        log.info("Receive msg : {}", msg);
    }

}
