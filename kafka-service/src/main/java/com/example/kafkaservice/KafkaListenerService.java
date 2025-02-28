package com.example.kafkaservice;

import com.example.kafkaservice.dto.KafkaMessage;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class KafkaListenerService {

    private static final Logger log = LoggerFactory.getLogger(KafkaListenerService.class);

    @KafkaListener(
            topics = "${elchinmicro.kafka.topic}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void listen(@Payload KafkaMessage message) {
        log.info("Message received.. MessageID : {} Message: {} Date : {}",
                message.getId(),
                message.getMessage(),
                message.getMessageDate());
    }
}


