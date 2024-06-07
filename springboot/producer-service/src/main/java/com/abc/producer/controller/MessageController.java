package com.abc.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.producer.service.KafkaProducer;

@RestController
@RequestMapping("/api")
public class MessageController {

	@Autowired
	private KafkaProducer kafkaProducer;
		
	@GetMapping("/send")
	public ResponseEntity<String> publishMessage(@RequestParam("msg") String message)  {
		
		kafkaProducer.sendMessage(message);		
		return new ResponseEntity<>("Message sent to the server", HttpStatus.OK);
	}	
}
