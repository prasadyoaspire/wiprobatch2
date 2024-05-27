package com.abc.ecomapp.service;

import java.util.List;

import com.abc.ecomapp.entity.Order;

public interface OrderService {

	Order saveOrder(Order order);
	
	Order findOrderById(int orderId);
	
	List<Order> findAllOrders();
}
