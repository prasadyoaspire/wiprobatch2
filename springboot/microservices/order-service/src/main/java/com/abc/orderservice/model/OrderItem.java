package com.abc.orderservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderItem {
	private int orderItemId;	  
	private int productId;	
	private int quantity;
	private double itemTotal;
}
