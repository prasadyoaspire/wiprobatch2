package com.abc.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecomapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>  {

}
