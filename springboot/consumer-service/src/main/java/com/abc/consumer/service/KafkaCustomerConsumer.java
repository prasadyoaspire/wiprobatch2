package com.abc.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.abc.consumer.model.Customer;

@Service
public class KafkaCustomerConsumer {

	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaCustomerConsumer.class);	

    @KafkaListener(topics = "sample-topic", containerFactory = "customerKafkaListenerContainerFactory")
    public void consume(Customer customer){
    	
    	LOGGER.info(customer.getFirstName()+" "+customer.getLastName());
    	System.out.println(customer.getFirstName()+" "+customer.getLastName());
    }    
}
