package com.abc.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.order.entity.OrderEntity;

public interface OrderRepository extends JpaRepository<OrderEntity,Integer>  {

}
