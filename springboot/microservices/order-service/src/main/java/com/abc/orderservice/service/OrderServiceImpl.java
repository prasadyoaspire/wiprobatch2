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
	public Order saveOrder(Order order) {

		// each item total

		List<OrderItem> orderItems = order.getOrderItems();
		
		double orderTotal = 0;

		for (OrderItem item : orderItems) {

			// we need to call Product-service getProductById() method and store it in
			// product object
			ResponseEntity<Product> responseEntity = restTemplate
					.getForEntity("http://localhost:8081/product/" + item.getProductId(), Product.class);

			Product product = responseEntity.getBody();
			
			double itemTotal = item.getQuantity()*product.getProductPrice();
			item.setItemTotal(itemTotal);
			
			orderTotal = orderTotal+itemTotal;	
		
		}

		// total order amount
		order.setOrderAmount(orderTotal);
		order.setOrderStauts("New");
		order.setOrderDate(LocalDate.now());

		OrderEntity orderEntity = OrderMapper.mapToEntity(order);
		List<OrderItemEntity> orderItemEntityList = orderEntity.getOrderItems();
		orderItemEntityList.forEach(item-> item.setOrder(orderEntity));
		orderRepository.save(orderEntity);
		Order newOrder = OrderMapper.mapToModel(orderEntity);

		return newOrder;
	}

	@Override
	public Order findOrderById(int orderId) {

		Optional<OrderEntity> optionalOrderEntity = orderRepository.findById(orderId);
		if (optionalOrderEntity.isEmpty()) {

		}
		OrderEntity orderEntity = optionalOrderEntity.get();

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
