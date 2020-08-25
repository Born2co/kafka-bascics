package com.kafka.app.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kafka.app.model.Message;
import com.kafka.app.producer.MessageProducer;

@RestController
@RequestMapping("/api/v1/message")
public class MessageController {
    @Autowired
	MessageProducer messageProducer;

    @PostMapping("/createMessage")
    public ResponseEntity<Message> postBookingEvent(@RequestBody Message message) throws JsonProcessingException, ExecutionException, InterruptedException  {
    	messageProducer.sendMessageEvent(message);
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }
}
