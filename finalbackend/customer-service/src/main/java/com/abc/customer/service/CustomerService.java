package com.abc.customer.service;

import java.util.List;

import com.abc.customer.entity.CustomerEntity;


public interface CustomerService {

	CustomerEntity saveCustomer(CustomerEntity customerEntity);
	
	CustomerEntity findCustomerById(int customerId);
	
	List<CustomerEntity> findAllCusotmers();	
	
}
