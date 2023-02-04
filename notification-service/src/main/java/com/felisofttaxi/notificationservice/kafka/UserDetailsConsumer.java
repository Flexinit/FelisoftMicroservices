package com.felisofttaxi.notificationservice.kafka;

import com.felisofttaxi.registrationservice.model.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDetailsConsumer {
    @KafkaListener(
            topics = "${spring.kafka.topic.name}"
            ,groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consumeKafkaMessage(UserDetails userDetails){
        log.info("Kafka Message Received is ->{}",userDetails);
    }
}
