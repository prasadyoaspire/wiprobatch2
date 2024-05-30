package com.abc.orderservice.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.orderservice.entity.OrderEntity;
import com.abc.orderservice.entity.OrderItemEntity;
import com.abc.orderservice.exception.ResourceNotFoundException;
import com.abc.orderservice.model.Customer;
import com.abc.orderservice.model.Order;
import com.abc.orderservice.model.OrderItem;
import com.abc.orderservice.model.Product;
import com.abc.orderservice.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public OrderEntity saveOrder(OrderEntity orderEntity) {

		List<OrderItemEntity> orderItems = orderEntity.getOrderItems();
		
		double orderTotal = 0;

		for (OrderItemEntity item : orderItems) {

			// we need to call Product-service getProductById() method to get the product details
			
			ResponseEntity<Product> responseEntity = restTemplate
					.getForEntity("http://localhost:8081/product/" + item.getProductId(), Product.class);
			Product product = responseEntity.getBody();
			
			double itemTotal = item.getQuantity()*product.getProductPrice();
			item.setItemTotal(itemTotal);
			
			orderTotal = orderTotal+itemTotal;
			
			item.setOrder(orderEntity);
		}

		//set total order amount
		orderEntity.setOrderAmount(orderTotal);
		orderEntity.setOrderStauts("New");
		orderEntity.setOrderDate(LocalDate.now());	
		
		orderRepository.save(orderEntity);	

		return orderEntity;
	}

	@Override
	public Order findOrderById(int orderId) {

		Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderId);
		if (optionalOrderEntity.isEmpty()) {
			throw new ResourceNotFoundException("Order not found with id: "+orderId);
		}
		OrderEntity orderEntity = optionalOrderEntity.get();
		
		ResponseEntity<Customer> responseEntity = restTemplate
				.getForEntity("http://localhost:8082/customer/get/" + orderEntity.getCustomerId(), Customer.class);
		Customer customer = responseEntity.getBody();
		
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
			
			ResponseEntity<Product> productResponseEntity = restTemplate
					.getForEntity("http://localhost:8081/product/" +orderItemEntity.getProductId(), Product.class);
			Product product = productResponseEntity.getBody();
			
			orderItem.setProduct(product);
			
			orderItems.add(orderItem);			
		}
		
		order.setOrderItems(orderItems);		
				
		return order;
	}

	@Override
	public List<OrderEntity> findAllOrders() {
		List<OrderEntity> orderEntityList = orderRepository.findAll();	
		return orderEntityList;
	}

}
