package com.abc.ecomapp.controller;

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

import com.abc.ecomapp.entity.Customer;
import com.abc.ecomapp.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/all")
	public List<Customer> fetchAllCustomers() {		
		List<Customer> customers = customerService.findAllCusotmers();
		return customers;
	}	
	
	@PostMapping("/save")
	public ResponseEntity<Customer>  addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);		
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer,HttpStatus.CREATED);		
		return responseEntity;
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Customer> fetchCustomerDetails( @PathVariable("id") int customerId) {
		Customer customer = customerService.findCustomerById(customerId);
		ResponseEntity<Customer> responseEntity = new ResponseEntity<>(customer,HttpStatus.OK);	
		return responseEntity;
	}	
}