package com.abc.orderservice.service;

import java.util.List;

import com.abc.orderservice.model.Order;


public interface OrderService {

	Order saveOrder(Order order);
	
	Order findOrderById(int orderId);
	
	List<Order> findAllOrders();
}
