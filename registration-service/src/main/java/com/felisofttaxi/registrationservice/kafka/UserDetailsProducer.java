package com.felisofttaxi.registrationservice.kafka;

import com.felisofttaxi.registrationservice.model.UserDetails;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j

public class UserDetailsProducer {

    private NewTopic newTopic;
    private KafkaTemplate<String, UserDetails> kafkaTemplate;

    public UserDetailsProducer(NewTopic newTopic, KafkaTemplate<String, UserDetails> kafkaTemplate){
        this.newTopic = newTopic;
        this.kafkaTemplate = kafkaTemplate;

    }

    public  void sendMessage(UserDetails userDetails){
        log.info("UserDetails being sent ->{}", userDetails);

        Message<UserDetails> kafkaMessage = MessageBuilder
                .withPayload(userDetails)
                .setHeader(KafkaHeaders.TOPIC, newTopic.name())
                .build();

        kafkaTemplate.send(kafkaMessage);
    }

}
