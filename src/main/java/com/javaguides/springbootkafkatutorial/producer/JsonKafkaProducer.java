package com.javaguides.springbootkafkatutorial.producer;

import com.javaguides.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class.getSimpleName());
    private KafkaTemplate<String, String> kafkaTemplate;

    public JsonKafkaProducer(KafkaTemplate<String, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User user){
        LOGGER.info(String.format("Message sent -> %s", user.toString()));
        Message<User> message = MessageBuilder.withPayload(user)
                        .setHeader(KafkaHeaders.TOPIC, "json_topic")
                        .build();
        kafkaTemplate.send(message);
    }
}
