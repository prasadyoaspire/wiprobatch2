package com.abc.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.abc.order.model.OrderDetails;

@Service
public class KafkaProducer {

//	@Autowired
//	private KafkaTemplate<String,String> kafkaTemplate;
//	
//	public void sendMessage(String msg) {
//		
//		kafkaTemplate.send("ecom-topic",msg);
//	}	
	
	@Autowired
	private KafkaTemplate<String,OrderDetails> kafkaTemplate;
	
	public void sendMessage(OrderDetails orderDetails) {
		kafkaTemplate.send("ecom-topic", orderDetails);
	}
	
}
