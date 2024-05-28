package com.abc.ecomwebflux.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.abc.ecomwebflux.entity.Product;

public interface ProductRepository  extends ReactiveCrudRepository<Product, Integer>{

}
