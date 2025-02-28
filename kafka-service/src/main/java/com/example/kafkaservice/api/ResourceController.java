package com.example.kafkaservice.api;

import com.example.kafkaservice.dto.KafkaMessage;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/kmessage")

public class ResourceController {
    @Value("${elchinmicro.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    public ResourceController(KafkaTemplate<String, KafkaMessage> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public void sendMessage(@RequestBody KafkaMessage message) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), message);
    }
}
