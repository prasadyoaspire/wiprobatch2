package com.abc.customerservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.customerservice.entity.CustomerEntity;
import com.abc.customerservice.model.Customer;
import com.abc.customerservice.repository.CustomerRepository;
import com.abc.customerservice.util.CustomerMapper;


@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer saveCustomer(Customer customer) {
		
		CustomerEntity customerEntity = CustomerMapper.mapToEntity(customer);
		customerRepository.save(customerEntity);			
		Customer customer2 = CustomerMapper.mapToModel(customerEntity);
		return customer2;
	}

	@Override
	public Customer findCustomerById(int customerId) {		
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			
		}		
		CustomerEntity customerEntity = optionalCustomer.get();	
		
		return CustomerMapper.mapToModel(customerEntity);
	}

	@Override
	public List<Customer> findAllCusotmers() {		
		List<CustomerEntity> customers = customerRepository.findAll();
		return CustomerMapper.mapToModelList(customers);
	}

	@Override
	public Customer updateCustomer(Customer customer) {		
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customer.getCustomerId());
		if(optionalCustomer.isEmpty()) {
			// throw some exception 
		}		
		
		CustomerEntity customerEntity = CustomerMapper.mapToEntity(customer);		
		customerRepository.save(customerEntity);			
		Customer customer2 = CustomerMapper.mapToModel(customerEntity);
		
		return customer2;
	}

	@Override
	public void deleteCustomer(int customerId) {
		Optional<CustomerEntity> optionalCustomer = customerRepository.findById(customerId);
		if(optionalCustomer.isEmpty()) {
			// throw some exception 
		}
		
		CustomerEntity customerEntity = optionalCustomer.get();
		customerRepository.delete(customerEntity);
	}

	@Override
	public List<Customer> findCustomerByCity(String city) {	
		List<CustomerEntity> customers = customerRepository.findByCity(city);
		return CustomerMapper.mapToModelList(customers);
	}

	@Override
	public List<Customer> findCustomersByAboveAge(int age) {	
		List<CustomerEntity> customers = customerRepository.findCustomersAboveAge(age);
		return CustomerMapper.mapToModelList(customers);
	}

}
