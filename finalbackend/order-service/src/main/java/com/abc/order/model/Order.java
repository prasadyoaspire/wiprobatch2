package com.abc.order.model;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {

	private int orderId;	
	private double orderAmount;
	private LocalDate orderDate;	
	private String orderStauts;
	private Customer customer;
	private List<OrderItem> orderItems;
}
