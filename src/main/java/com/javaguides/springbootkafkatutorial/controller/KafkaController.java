package com.javaguides.springbootkafkatutorial.controller;

import com.javaguides.springbootkafkatutorial.payload.User;
import com.javaguides.springbootkafkatutorial.producer.JsonKafkaProducer;
import com.javaguides.springbootkafkatutorial.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {
    @Autowired
    private KafkaProducer kafkaProducer;
    @Autowired
    private JsonKafkaProducer jsonKafkaProducer;

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic");
    }

    @PostMapping("/user")
    public ResponseEntity<String> sendUser(@RequestBody User user ){
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Message sent to topic");
    }
}
