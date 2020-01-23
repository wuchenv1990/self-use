package com.wcyv90.kafka.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartitionInfo;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TopicDescriptionDTO {

    private String name;

    private List<TopicPartitionInfoDTO> topicPartitionInfoDTOs;

    public static TopicDescriptionDTO from(TopicDescription topicDescription) {
        return TopicDescriptionDTO.builder()
                .name(topicDescription.name())
                .topicPartitionInfoDTOs(topicDescription.partitions()
                        .stream()
                        .map(TopicPartitionInfoDTO::from)
                        .collect(Collectors.toList()))
                .build();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class TopicPartitionInfoDTO {
        private int partition;
        private NodeDTO leader;
        private List<NodeDTO> replicas;
        private List<NodeDTO> isr;

        static TopicPartitionInfoDTO from(TopicPartitionInfo topicPartitionInfo) {
            return TopicPartitionInfoDTO.builder()
                    .partition(topicPartitionInfo.partition())
                    .leader(NodeDTO.from(topicPartitionInfo.leader()))
                    .replicas(topicPartitionInfo.replicas().stream().map(NodeDTO::from).collect(Collectors.toList()))
                    .isr(topicPartitionInfo.isr().stream().map(NodeDTO::from).collect(Collectors.toList()))
                    .build();
        }
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    private static class NodeDTO {
        private int id;
        private String idString;
        private String host;
        private int port;
        private String rack;

        static NodeDTO from(Node node) {
            return NodeDTO.builder()
                    .id(node.id())
                    .idString(node.idString())
                    .host(node.host())
                    .port(node.port())
                    .rack(node.rack())
                    .build();
        }

    }
}
