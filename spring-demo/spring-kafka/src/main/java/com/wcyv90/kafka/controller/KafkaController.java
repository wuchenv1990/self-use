package com.wcyv90.kafka.controller;

import com.wcyv90.kafka.domain.dto.TopicDescriptionDTO;
import com.wcyv90.kafka.service.KafkaManagerService;
import com.wcyv90.kafka.service.MessageSender;
import org.apache.kafka.clients.admin.TopicDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    KafkaManagerService kafkaManagerService;

    @PostMapping("/message")
    public void sendMessage(@RequestBody String msg) {
        messageSender.sendMessage(msg);
    }

    @GetMapping("/topic")
    public Map<String, TopicDescriptionDTO> describeTopicsResult(@RequestParam("name") String name)
            throws ExecutionException, InterruptedException {
        Map<String, TopicDescription> stringTopicDescriptionMap = kafkaManagerService.describeTopicsResult(name);
        return stringTopicDescriptionMap.keySet()
                .stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        k -> TopicDescriptionDTO.from(stringTopicDescriptionMap.get(k)))
                );
    }

}
