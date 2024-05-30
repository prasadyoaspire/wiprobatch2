package com.abc.orderservice.util;

import java.util.ArrayList;
import java.util.List;

import com.abc.orderservice.entity.OrderEntity;
import com.abc.orderservice.entity.OrderItemEntity;
import com.abc.orderservice.model.Order;
import com.abc.orderservice.model.OrderItem;

public class OrderMapper {

	public static OrderEntity mapToEntity(Order order) {
		
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderId(order.getOrderId());
		orderEntity.setOrderAmount(order.getOrderAmount());
		orderEntity.setCustomerId(order.getCustomerId());
		orderEntity.setOrderDate(order.getOrderDate());
		orderEntity.setOrderStauts(order.getOrderStauts());
		
		List<OrderItem> orderItemList = order.getOrderItems();
		List<OrderItemEntity> orderItemEntityList = OrderItemMapper.mapToEntityList(orderItemList);		
		orderEntity.setOrderItems(orderItemEntityList);
		return orderEntity;
	}
	
	public static Order mapToModel(OrderEntity orderEntity) {
		
		Order order = new Order();
		order.setOrderId(orderEntity.getOrderId());
		order.setOrderAmount(orderEntity.getOrderAmount());
		order.setCustomerId(orderEntity.getCustomerId());
		order.setOrderDate(orderEntity.getOrderDate());
		order.setOrderStauts(orderEntity.getOrderStauts());
		
		List<OrderItemEntity> orderItemEntityList = orderEntity.getOrderItems();
		List<OrderItem> orderItemList = OrderItemMapper.mapToModelList(orderItemEntityList);		
		order.setOrderItems(orderItemList);
		return order;
	}
	
	public static List<Order> mapToModelList(List<OrderEntity> orderEntityList) {
		
		List<Order> orderList = new ArrayList<>();
		for(OrderEntity orderEntity : orderEntityList) {
			Order order = mapToModel(orderEntity);
			orderList.add(order);
		}
		return orderList;
	}
	
	public static List<OrderEntity> mapToEntityList(List<Order> orderList) {
		
		List<OrderEntity> orderEntityList = new ArrayList<>();
		for(Order order : orderList) {
			OrderEntity orderEnity = mapToEntity(order);
			orderEntityList.add(orderEnity);
		}
		return orderEntityList;
	}
	
}
