package com.abc.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.orderservice.entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Integer>  {

}
