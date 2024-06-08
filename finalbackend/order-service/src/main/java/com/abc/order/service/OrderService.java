package com.abc.order.service;

import java.util.List;

import com.abc.order.entity.OrderEntity;
import com.abc.order.model.Order;

public interface OrderService {

	OrderEntity saveOrder(OrderEntity orderEntity);
	
	Order findOrderById(int orderId);
	
	List<OrderEntity> findAllOrders();
}
