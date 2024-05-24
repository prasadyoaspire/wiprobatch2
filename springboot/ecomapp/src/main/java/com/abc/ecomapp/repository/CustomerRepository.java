package com.abc.ecomapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecomapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	List<Customer> findByCity(String city) ;
	
	Optional<Customer> findByEmail(String email);
}
