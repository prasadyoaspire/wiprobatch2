package com.abc.nofitication.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.abc.nofitication.model.EmailDetails;
import com.abc.nofitication.model.OrderDetails;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);	
	
	@Autowired
	private EmailService emailService;

    @KafkaListener(topics = "ecom-topic",containerFactory = "orderDetailsKafkaListenerContainerFactory")
    public void consume(OrderDetails orderDetails){ 	
    
    	String msg = "Thank you "+orderDetails.getCustomerName()+"\nOrder Details\n"+"Order Amount: "+orderDetails.getOrderAmount()+"\n"+
    	"Order Status:"+orderDetails.getOrderStauts();
    	
    	EmailDetails emailDetails = new EmailDetails();
    	emailDetails.setRecipient(orderDetails.getEmail());
    	emailDetails.setBody(msg);
    	emailDetails.setSubject("Order Placed");
    	
    	emailService.sendEmail(emailDetails);
    	
    	LOGGER.info("Email Sent");
    }    
    
}
