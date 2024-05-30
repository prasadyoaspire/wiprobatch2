package com.abc.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.productservice.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity,Integer>  {

}
