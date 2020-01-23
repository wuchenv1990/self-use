package com.wcyv90.kafka.service;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaManagerService {

    @Autowired
    KafkaAdmin kafkaAdmin;

    public Map<String, TopicDescription> describeTopicsResult(String name)
            throws ExecutionException, InterruptedException {
        try (AdminClient client = AdminClient.create(kafkaAdmin.getConfig())) {
            if (client != null) {
                return client.describeTopics(Collections.singletonList(name)).all().get();
            }
        }
        return Collections.emptyMap();
    }

}
