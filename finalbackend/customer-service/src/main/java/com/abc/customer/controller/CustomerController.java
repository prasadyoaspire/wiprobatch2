package com.abc.customer.controller;

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

import com.abc.customer.entity.CustomerEntity;
import com.abc.customer.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/")
	public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customerEntity) {
		customerService.saveCustomer(customerEntity);		
		ResponseEntity<CustomerEntity> responseEntity = new ResponseEntity<>(customerEntity,HttpStatus.CREATED);		
		return responseEntity;
	}

	@GetMapping("/all")
	public List<CustomerEntity> fetchAllCustomers() {		
		List<CustomerEntity> customers = customerService.findAllCusotmers();
		return customers;
	}	
		
	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity> fetchCustomerDetails( @PathVariable("id") int customerId) {		
		CustomerEntity customerEntity = customerService.findCustomerById(customerId);		
		ResponseEntity<CustomerEntity> responseEntity = new ResponseEntity<>(customerEntity,HttpStatus.OK);	
		return responseEntity;
	}	
}
