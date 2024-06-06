package com.abc.kafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.kafkademo.service.KafkaConsumer;
import com.abc.kafkademo.service.KafkaProducer;

@RestController
@RequestMapping("/api")
public class DemoController {

	@Autowired
	private KafkaProducer kafkaProducer;
		
	@GetMapping("/send")
	public ResponseEntity<String> publishMessage(@RequestParam("msg") String message)  {
		
		kafkaProducer.sendMessage(message);
		
		return new ResponseEntity<>("Message sent to the server", HttpStatus.OK);
	}	

}
