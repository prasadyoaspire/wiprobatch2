package com.abc.orderservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.orderservice.entity.OrderEntity;
import com.abc.orderservice.model.Order;
import com.abc.orderservice.repository.OrderRepository;
import com.abc.orderservice.util.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order saveOrder(Order order) {
				
		
		OrderEntity orderEntity = OrderMapper.mapToEntity(order);		
		orderRepository.save(orderEntity);		
		Order newOrder = OrderMapper.mapToModel(orderEntity);
		
		return newOrder;
	}

	@Override
	public Order findOrderById(int orderId) {
		
		Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderId);
		if(optionalOrderEntity.isEmpty()) {
			
		}
		OrderEntity  orderEntity = optionalOrderEntity.get();
		
		Order order = OrderMapper.mapToModel(orderEntity);
		
		return order;
	}

	@Override
	public List<Order> findAllOrders() {
		List<OrderEntity> orderEntityList = orderRepository.findAll();
		List<Order> orderList = OrderMapper.mapToModelList(orderEntityList);
		return orderList;
	}

}
