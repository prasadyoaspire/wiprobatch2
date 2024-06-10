package com.abc.nofitication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.abc.nofitication.model.EmailDetails;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);	
	
	@Autowired
	private EmailService emailService;

    @KafkaListener(topics = "ecom-topic",
                    groupId = "ecom-group-id")
    public void consume(String message){
    	
    	LOGGER.info(message);
    	
    	EmailDetails emailDetails = new EmailDetails();
    	emailDetails.setRecipient("sanskarchourasia1275@gmail.com");
    	emailDetails.setBody(message);
    	emailDetails.setSubject("Order");
    	
    	emailService.sendEmail(emailDetails);
    	
    	LOGGER.info("Email Sent");
    }    
    
}
