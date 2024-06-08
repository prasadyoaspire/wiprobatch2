package com.abc.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.order.entity.OrderItemEntity;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Integer>  {

}
