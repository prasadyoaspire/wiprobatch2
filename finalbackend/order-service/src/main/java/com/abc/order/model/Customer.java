package com.abc.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

	private int customerId;
	private String customerName;
	private int age;	
	private String email;	
	private String city;	
	private String mobile;
}
