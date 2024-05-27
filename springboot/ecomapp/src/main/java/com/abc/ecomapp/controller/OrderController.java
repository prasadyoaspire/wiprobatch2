package com.abc.ecomapp.controller;

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

import com.abc.ecomapp.entity.Order;
import com.abc.ecomapp.model.OrderDto;
import com.abc.ecomapp.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@PostMapping("/save")
	public ResponseEntity<Order> placeOrder(@RequestBody OrderDto orderDto) {
		Order order = orderService.saveOrder(orderDto);
		return new ResponseEntity<>(order,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> fetchOrderDetails(@PathVariable("id") int orderId) {
		Order order = orderService.findOrderById(orderId);
		return new ResponseEntity<>(order,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Order> fetchAllOrders() {		
		return orderService.findAllOrders();
	}
}
