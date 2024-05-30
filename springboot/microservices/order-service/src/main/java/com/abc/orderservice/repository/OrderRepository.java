package com.abc.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.orderservice.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer>  {

}
