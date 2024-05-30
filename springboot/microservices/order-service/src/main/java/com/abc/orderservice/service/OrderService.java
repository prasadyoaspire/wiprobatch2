package com.abc.orderservice.service;

import java.util.List;

import com.abc.orderservice.entity.OrderEntity;

public interface OrderService {

	OrderEntity saveOrder(OrderEntity orderEntity);
	
	OrderEntity findOrderById(int orderId);
	
	List<OrderEntity> findAllOrders();
}
