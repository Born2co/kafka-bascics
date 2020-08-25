package com.kafka.app.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;


import lombok.extern.slf4j.Slf4j;



@Component
@Slf4j
public class Consumer {

	 Logger logger = LoggerFactory.getLogger(Consumer.class);
    
	@KafkaListener(topics = "message-topic", groupId = "message-events-listener-group")
    public void onMessage(ConsumerRecord<Integer,String> consumerRecord) throws JsonProcessingException {

    	logger.info("consumerRecord {}",consumerRecord);

    }
}