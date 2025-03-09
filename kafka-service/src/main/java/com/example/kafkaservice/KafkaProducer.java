package com.example.kafkaservice;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class KafkaProducer {
    public static final String TOPIC = "replace with your topic name";

    private final KafkaTemplate<String, MyEvent> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, MyEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendFlightEvent(MyEvent event){
        String key = event.getKey();
        kafkaTemplate.send(TOPIC, key , event);
        log.info("Sent flight event: " + event);
        // write your handlers and post-processing logic, based on your use case
    }

    @Data
    class MyEvent {
        private String key;
        // other variables state, based on your use case
    }
}
