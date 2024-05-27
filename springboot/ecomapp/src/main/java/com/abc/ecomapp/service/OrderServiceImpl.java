package com.abc.ecomapp.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecomapp.entity.Customer;
import com.abc.ecomapp.entity.Order;
import com.abc.ecomapp.entity.OrderItem;
import com.abc.ecomapp.entity.Product;
import com.abc.ecomapp.exception.OrderNotFoundException;
import com.abc.ecomapp.model.OrderDto;
import com.abc.ecomapp.model.OrderItemDto;
import com.abc.ecomapp.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;

	@Override
	public Order saveOrder(OrderDto orderDto) {	
		
		int customerId = orderDto.getCustomerId();
		List<OrderItemDto> orderItemDto = orderDto.getOrderItems();
		
		Order order = new Order();
		
		List<OrderItem> orderItems = new ArrayList<>(); 
		
		orderItemDto.forEach(itemDto -> {
			OrderItem orderItem = new OrderItem();
			orderItem.setOrderItemId(0);	
			
			int productId = itemDto.getProductId();
			int qty = itemDto.getQuantity();			
			Product product= productService.findProductById(productId);
			
			orderItem.setProduct(product);
			orderItem.setQuantity(qty);
			orderItem.setItemTotal(product.getProductPrice()*qty);
			
			orderItem.setOrder(order);
			
			orderItems.add(orderItem);			
		});
		
		
		Customer customer = customerService.findCustomerById(customerId);
		
		
		//order.setOrderId(0);
		order.setOrderDate(LocalDate.now());
		order.setOrderAmount(0);  // task - calculate all items total and set it
		order.setOrderStauts("New");
		order.setCustomer(customer);
		order.setOrderItems(orderItems);
		
		orderRepository.save(order);	
		return order;
	}

	@Override
	public Order findOrderById(int orderId) {
		
		Optional<Order>  optionalOrder = orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new OrderNotFoundException("Order not existing with id: "+orderId);
		}
		
		Order order = optionalOrder.get();
		return order;
	}

	@Override
	public List<Order> findAllOrders() {
		
		return orderRepository.findAll();
	}

}
