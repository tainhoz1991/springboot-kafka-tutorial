package com.javaguides.springbootkafkatutorial.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class.getSimpleName());
    @KafkaListener(topics = "javaguides", groupId = "myGroup")
    public void consumer(String message){
        LOGGER.info(String.format("Message received %s", message));
    }
}
