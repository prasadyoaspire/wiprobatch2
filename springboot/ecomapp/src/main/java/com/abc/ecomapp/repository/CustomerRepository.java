package com.abc.ecomapp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abc.ecomapp.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

	List<Customer> findByCity(String city) ;
	
	Optional<Customer> findByEmail(String email);
	
	@Query("select c from Customer c where c.age > :cage")
	List<Customer>  findCustomersAboveAge(@Param("cage") int age);
}
