package com.abc.registration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.abc.registration.model.Course;
import com.abc.registration.model.Registration;
import com.abc.registration.service.RegistrationService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;


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
	
	
	@GetMapping("/courses")
	//@CircuitBreaker(name="courseClient", fallbackMethod = "getAllCoursesFallBack")
	@Retry(name="courseClient", fallbackMethod = "getAllCoursesFallBack")
	public List<Course> getAllCourses() {		
		List<Course> courses = restTemplate.getForObject("http://localhost:7072/course/all", ArrayList.class);
		return courses;		
	}
	
	public List<Course> getAllCoursesFallBack(Exception e) {
		return Stream.of(
				new Course(10,"Course-1",1000,30),
				new Course(20,"Course-2",1000,30),
				new Course(30,"Course-3",1000,30),
				new Course(40,"Course-4",1000,30),
				new Course(50,"Course-5",1000,30)
				).collect(Collectors.toList());				
	}

}
