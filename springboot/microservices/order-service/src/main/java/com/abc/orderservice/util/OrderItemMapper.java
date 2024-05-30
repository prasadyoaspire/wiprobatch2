package com.abc.orderservice.util;

import java.util.ArrayList;
import java.util.List;

import com.abc.orderservice.entity.OrderItemEntity;
import com.abc.orderservice.model.OrderItem;

public class OrderItemMapper {

	public static OrderItem mapToModel(OrderItemEntity orderItemEntity) {
		OrderItem orderItem = new OrderItem();
		orderItem.setOrderItemId(orderItemEntity.getOrderItemId());
		orderItem.setProductId(orderItemEntity.getProductId());
		orderItem.setQuantity(orderItemEntity.getQuantity());
		orderItem.setItemTotal(orderItemEntity.getItemTotal());
		return orderItem;
	}
	
	public static OrderItemEntity mapToEntity(OrderItem orderItem) {
		OrderItemEntity orderItemEntity = new OrderItemEntity();
		orderItemEntity.setOrderItemId(orderItem.getOrderItemId());
		orderItemEntity.setProductId(orderItem.getProductId());
		orderItemEntity.setQuantity(orderItem.getQuantity());
		orderItemEntity.setItemTotal(orderItem.getItemTotal());
		return orderItemEntity;
	}
	
	public static List<OrderItemEntity> mapToEntityList(List<OrderItem> orderItemList) {		
		List<OrderItemEntity> orderItemEntityList = new ArrayList<>();
		for(OrderItem orderItem : orderItemList) {
			OrderItemEntity orderItemEntity = mapToEntity(orderItem);
			orderItemEntityList.add(orderItemEntity);
		}		
		return orderItemEntityList;
	}
	
	public static List<OrderItem> mapToModelList(List<OrderItemEntity> orderItemEntityList) {		
		List<OrderItem> orderItemList = new ArrayList<>();
		for(OrderItemEntity orderItemEntity : orderItemEntityList) {
			OrderItem orderItem = mapToModel(orderItemEntity);
			orderItemList.add(orderItem);
		}		
		return orderItemList;
	}
}
