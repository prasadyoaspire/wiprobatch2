package com.abc.order.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.order.entity.OrderEntity;
import com.abc.order.entity.OrderItemEntity;
import com.abc.order.exception.ResourceNotFoundException;
import com.abc.order.model.Customer;
import com.abc.order.model.Order;
import com.abc.order.model.OrderItem;
import com.abc.order.model.Product;
import com.abc.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductApiClient productApiClient;
	
	@Autowired
	private CustomerApiClient customerApiClient;

	@Override
	public OrderEntity saveOrder(OrderEntity orderEntity) {
		
		List<OrderItemEntity> orderItems = orderEntity.getOrderItems();
		double orderTotal = 0;

		for (OrderItemEntity item : orderItems) {
			// using Feign client			
			
			Product product = productApiClient.getProductDetials(item.getProductId());
			
			double itemTotal = item.getQuantity()*product.getProductPrice();
			item.setItemTotal(itemTotal);
			
			orderTotal = orderTotal+itemTotal;
			item.setOrder(orderEntity);
		}

		//set total order amount
		orderEntity.setOrderAmount(orderTotal);
		orderEntity.setOrderStauts("Pending");
		orderEntity.setOrderDate(LocalDate.now());	
		
		orderRepository.save(orderEntity);	

		return orderEntity;
	}

	@Override
	public Order findOrderById(int orderId) {
		
		Optional<OrderEntity> optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new ResourceNotFoundException("Order not found with id: "+orderId);
		}
		OrderEntity orderEntity = optionalOrder.get();
		
		//using Feign client
		Customer customer = customerApiClient.getCustomerDetails(orderEntity.getCustomerId());
		
		
		Order order = new Order();
		order.setOrderId(orderEntity.getOrderId());
		order.setOrderAmount(orderEntity.getOrderAmount());
		order.setOrderDate(orderEntity.getOrderDate());
		order.setOrderStauts(orderEntity.getOrderStauts());
		order.setCustomer(customer);
		
		List<OrderItemEntity> orderItemEntityList = orderEntity.getOrderItems();
		
		List<OrderItem> orderItems = new ArrayList<>();
		
		for(OrderItemEntity orderItemEntity : orderItemEntityList) {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderItemId(orderItemEntity.getOrderItemId());
			orderItem.setQuantity(orderItemEntity.getQuantity());
			orderItem.setItemTotal(orderItemEntity.getItemTotal());
			
			//using Feign client
			Product product = productApiClient.getProductDetials(orderItemEntity.getProductId());
			
			orderItem.setProduct(product);
			
			orderItems.add(orderItem);			
		}
		
		order.setOrderItems(orderItems);		
				
		return order;
	}

	@Override
	public List<OrderEntity> findAllOrders() {
		
		return orderRepository.findAll();
	}

}
