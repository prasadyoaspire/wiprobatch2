package com.abc.nofitication.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDetails {

	private double orderAmount;
	private LocalDate orderDate;	
	private String orderStauts;
	private String customerName;
	private String email;	
	private String mobile;
	private int itemCount;
	
}
