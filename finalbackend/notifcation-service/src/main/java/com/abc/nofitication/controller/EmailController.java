package com.abc.nofitication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.nofitication.model.EmailDetails;
import com.abc.nofitication.service.EmailService;

@RestController
@RequestMapping("/api/email")
public class EmailController {

	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendEmail(@RequestBody EmailDetails emailDetais) {
		
		emailService.sendEmail(emailDetais);
		
		return new ResponseEntity<>("Mail Sent",HttpStatus.OK);
	}
}
