package com.abc.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.abc.registration.entity.RegistrationEntity;
import com.abc.registration.model.Registration;
import com.abc.registration.service.RegistrationService;


@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/save")
	public ResponseEntity<RegistrationEntity> doRegistration(@RequestBody RegistrationEntity registrationEntity) {
		registrationService.register(registrationEntity);
		return new ResponseEntity<>(registrationEntity, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Registration> getRegistrationDetails(@PathVariable("id") int registrationId) {
		Registration registration = registrationService.findRegistrationDetailsById(registrationId);
		return new ResponseEntity<>(registration, HttpStatus.OK);
	}

	@GetMapping("/all")
	public List<RegistrationEntity> getRegistrationDetails() {
		return registrationService.findAllRegistrations();
	}

}
