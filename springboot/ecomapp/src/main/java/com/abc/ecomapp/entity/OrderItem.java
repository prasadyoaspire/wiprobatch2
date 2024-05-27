package com.abc.ecomapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="order_item_tbl")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_item_id")
	private int orderItemId;
	
    @OneToOne
    @JoinColumn(name="product_id")
   	private Product product;
	
	private int quantity;
	
	@Column(name="item_total")
	private double itemTotal;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order order;
}
