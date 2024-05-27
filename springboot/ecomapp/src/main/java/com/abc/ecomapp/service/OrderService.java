package com.abc.ecomapp.service;

import java.util.List;

import com.abc.ecomapp.entity.Order;
import com.abc.ecomapp.model.OrderDto;

public interface OrderService {

	Order saveOrder(OrderDto orderDto);
	
	Order findOrderById(int orderId);
	
	List<Order> findAllOrders();
}
