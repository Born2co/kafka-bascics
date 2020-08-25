package com.kafka.app.producer;

import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.kafka.app.model.Message;
@Component
public class MessageProducer {
	
	@Autowired
    KafkaTemplate<Integer,String> kafkaTemplate;

    String topic = "message-topic";
    
    @Autowired
    ObjectMapper objectMapper;
    
    Logger logger = LoggerFactory.getLogger(MessageProducer.class);

	public SendResult<Integer, String> sendMessageEvent(Message message) throws JsonProcessingException, ExecutionException, InterruptedException {
        String value = objectMapper.writeValueAsString(message);
        SendResult<Integer,String> sendResult=null;
        try {
            sendResult = kafkaTemplate.send(topic, value).get();
        } catch (ExecutionException | InterruptedException e) {
            logger.error("ExecutionException/InterruptedException exception while sending message : {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Exception Sending the Message {}", e.getMessage());
            throw e;
        }
        return sendResult;
    }


}
