package com.wcyv90.kafka.infra;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
@EnableKafka
public class KafkaConfig {

    public static final String TOPIC_W = "topic-w";
    public static final String CONSUMER_GROUP_W = "consumer-group-w";

    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name(TOPIC_W)
                .partitions(3)
                .replicas(1)
//                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd")
//                .compact()
                .build();
    }

}
