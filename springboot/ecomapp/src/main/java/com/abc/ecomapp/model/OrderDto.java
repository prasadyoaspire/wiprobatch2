package com.abc.ecomapp.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class OrderDto {

	private int customerId;
	private List<OrderItemDto> orderItems;
}
