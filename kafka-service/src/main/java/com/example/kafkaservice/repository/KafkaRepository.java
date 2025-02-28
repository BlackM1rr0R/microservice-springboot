package com.example.kafkaservice.repository;

import com.example.kafkaservice.dto.KafkaMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KafkaRepository extends JpaRepository<KafkaMessage, Long> {
}
