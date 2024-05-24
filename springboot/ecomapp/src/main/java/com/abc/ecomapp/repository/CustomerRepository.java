package com.abc.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecomapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	
}
