package com.abc.ecomapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecomapp.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>  {

}
