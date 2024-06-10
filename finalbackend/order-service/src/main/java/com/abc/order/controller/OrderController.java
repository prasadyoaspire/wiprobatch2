package com.abc.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.order.entity.OrderEntity;
import com.abc.order.model.Order;
import com.abc.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/")
	public ResponseEntity<OrderEntity> placeOrder(@RequestBody OrderEntity orderEntity) {		
		OrderEntity newOrder = orderService.saveOrder(orderEntity);
		return new ResponseEntity<>(newOrder,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> fetchOrderDetails(@PathVariable("id") int orderId) {
		Order order = orderService.findOrderById(orderId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<OrderEntity> fetchAllOrders() {		
		return orderService.findAllOrders();
	}
}
