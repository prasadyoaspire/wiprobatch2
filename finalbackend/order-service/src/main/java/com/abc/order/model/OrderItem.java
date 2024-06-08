package com.abc.order.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItem {
	private int orderItemId;	  
	private Product product;
	private int quantity;
	private double itemTotal;
}
