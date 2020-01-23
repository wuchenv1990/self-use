package com.wcyv90.kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wcyv90.kafka.domain.dto.TopicDescriptionDTO;
import com.wcyv90.kafka.service.MessageSender;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.TopicDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    @Autowired
    MessageSender messageSender;

    @Autowired
    KafkaAdmin kafkaAdmin;

    @PostMapping("/message")
    public void sendMessage(@RequestBody String msg) {
        messageSender.sendMessage(msg);
    }

    @GetMapping("/topic")
    public Map<String, TopicDescriptionDTO> describeTopicsResult(@RequestParam("name") String name)
            throws ExecutionException, InterruptedException, JsonProcessingException {
        try (AdminClient client = AdminClient.create(kafkaAdmin.getConfig())) {
            if (client != null) {
                Map<String, TopicDescription> stringTopicDescriptionMap = client
                        .describeTopics(Collections.singletonList(name)).all().get();
                return stringTopicDescriptionMap.keySet()
                        .stream()
                        .collect(Collectors.toMap(
                                Function.identity(),
                                k -> TopicDescriptionDTO.from(stringTopicDescriptionMap.get(k)))
                        );
            }
        }
        return null;
    }

}
