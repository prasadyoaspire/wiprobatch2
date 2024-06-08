package com.abc.customer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.customer.entity.CustomerEntity;
import com.abc.customer.exception.ResourceNotFoundException;
import com.abc.customer.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerEntity saveCustomer(CustomerEntity customerEntity) {
		
		return customerRepository.save(customerEntity);
	}

	@Override
	public CustomerEntity findCustomerById(int customerId) {
	
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			throw new ResourceNotFoundException("Customer not existing with id: "+customerId);
		}
		CustomerEntity customerEntity = optionalCustomer.get();
		return customerEntity;
	}

	@Override
	public List<CustomerEntity> findAllCusotmers() {
		
		return customerRepository.findAll();
	}

}
