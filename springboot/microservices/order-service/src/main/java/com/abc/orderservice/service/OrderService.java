package com.abc.orderservice.service;

import java.util.List;

import com.abc.orderservice.entity.OrderEntity;
import com.abc.orderservice.model.Order;

public interface OrderService {

	OrderEntity saveOrder(OrderEntity orderEntity);
	
	Order findOrderById(int orderId);
	
	List<OrderEntity> findAllOrders();
}
