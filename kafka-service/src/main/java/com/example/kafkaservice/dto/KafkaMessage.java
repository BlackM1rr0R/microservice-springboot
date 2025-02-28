package com.example.kafkaservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(of = {"id", "message", "messageDate"})
public class KafkaMessage {
    private String id = UUID.randomUUID().toString();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(LocalDateTime messageDate) {
        this.messageDate = messageDate;
    }

    private String message;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime messageDate;
}
