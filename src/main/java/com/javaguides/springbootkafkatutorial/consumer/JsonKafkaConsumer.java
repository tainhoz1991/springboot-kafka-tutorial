package com.javaguides.springbootkafkatutorial.consumer;

import com.javaguides.springbootkafkatutorial.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class.getSimpleName());

    @KafkaListener(topics = "json_topic", groupId = "myGroup")
    public void jsonConsumer(User user){
        LOGGER.info(String.format("Message received -> %s", user.toString()));
    }
}
