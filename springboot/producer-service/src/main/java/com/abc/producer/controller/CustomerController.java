package com.abc.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.producer.model.Customer;
import com.abc.producer.service.KafkaCustomerProducer;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private KafkaCustomerProducer kafkaProducer;
	
	@PostMapping("/customer")
	public ResponseEntity<String> sendCustomer(@RequestBody Customer customer) {
		
		kafkaProducer.sendMessage(customer);
		return new ResponseEntity<>("customer detials sent", HttpStatus.OK);
	}
}
