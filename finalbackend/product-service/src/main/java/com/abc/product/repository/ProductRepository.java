package com.abc.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.product.entity.ProductEntity;


public interface ProductRepository extends JpaRepository<ProductEntity,Integer>  {

}
