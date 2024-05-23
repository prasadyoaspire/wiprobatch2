package com.abc.ecomapp.service;

import java.util.List;

import com.abc.ecomapp.entity.Customer;

public interface CustomerService {

	Customer saveCustomer(Customer customer);
	
	Customer findCustomerById(int customerId);
	
	List<Customer> findAllCusotmers();
}
