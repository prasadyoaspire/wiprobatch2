package com.abc.orderservice.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.abc.orderservice.entity.OrderEntity;
import com.abc.orderservice.entity.OrderItemEntity;
import com.abc.orderservice.model.Order;
import com.abc.orderservice.model.OrderItem;
import com.abc.orderservice.model.Product;
import com.abc.orderservice.repository.OrderRepository;
import com.abc.orderservice.util.OrderMapper;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public OrderEntity saveOrder(OrderEntity orderEntity) {

		// each item total
		List<OrderItemEntity> orderItems = orderEntity.getOrderItems();
		
		double orderTotal = 0;

		for (OrderItemEntity item : orderItems) {

			// we need to call Product-service getProductById() method and store it in
			// product object
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
	public OrderEntity findOrderById(int orderId) {

		Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderId);
		if (optionalOrderEntity.isEmpty()) {

		}
		OrderEntity orderEntity = optionalOrderEntity.get();
		return orderEntity;
	}

	@Override
	public List<OrderEntity> findAllOrders() {
		List<OrderEntity> orderEntityList = orderRepository.findAll();	
		return orderEntityList;
	}

}
