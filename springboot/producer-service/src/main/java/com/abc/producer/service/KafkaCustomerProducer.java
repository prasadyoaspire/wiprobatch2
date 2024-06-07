package com.abc.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.abc.producer.model.Customer;

@Service
public class KafkaCustomerProducer {

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	public void sendMessage(Customer customer) {
		
		kafkaTemplate.send("sample-topic",customer);
	}	
}
