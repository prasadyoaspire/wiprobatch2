package com.abc.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springcore.bean.Product;

public class ProductMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Product product = (Product) context.getBean("product1");
		
		System.out.println("Id: "+product.getProductId());
		System.out.println("Name: "+product.getProductName());
		System.out.println("Price: "+product.getProductPrice());
		
		Product product2 = (Product) context.getBean("product2");
		
		System.out.println("Id: "+product2.getProductId());
		System.out.println("Name: "+product2.getProductName());
		System.out.println("Price: "+product2.getProductPrice());
		
		context.close();

	}

}
