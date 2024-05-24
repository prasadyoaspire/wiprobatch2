package com.abc.ecomapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecomapp.entity.Customer;
import com.abc.ecomapp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {		
		customerRepository.save(customer);		
		return customer;
	}

	@Override
	public Customer findCustomerById(int customerId) {		
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			
		}		
		Customer customer = optionalCustomer.get();		
		return customer;
	}

	@Override
	public List<Customer> findAllCusotmers() {		
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@Override
	public Customer updateCustomer(Customer customer) {		
		Optional<Customer> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isEmpty()) {
			// throw some exception 
		}		
		customerRepository.save(customer);		
		return customer;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			// throw some exception 
		}
		
		Customer customer = optionalCustomer.get();
		customerRepository.delete(customer);
	}

	@Override
	public List<Customer> findCustomerByCity(String city) {	
		List<Customer> customers = customerRepository.findByCity(city);
		return customers;
	}

	@Override
	public List<Customer> findCustomersByAboveAge(int age) {
	
		return customerRepository.findCustomersAboveAge(age);
	}

}
