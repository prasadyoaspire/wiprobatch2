package com.abc.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecomapp.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer>  {

}
