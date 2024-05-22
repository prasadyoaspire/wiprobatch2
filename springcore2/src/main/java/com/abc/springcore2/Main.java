package com.abc.springcore2;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springcore2.controller.ProductController;
import com.abc.springcore2.dto.Product;

public class Main {

	public static void main(String[] args) {
		
		//create application context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");	
		
		//get the controller bean
		//ProductController pController = (ProductController) context.getBean("pController");
		
		ProductController pController = context.getBean(ProductController.class);
		
		Product p1 = new Product();
		p1.setProductId(40);
		p1.setProductName("DellXP");
		p1.setProductPrice(120000);	
		
		Product p2 = new Product();
		p2.setProductId(50);
		p2.setProductName("Lenovo");
		p2.setProductPrice(220000);	
				
		pController.saveProduct(p1);
		System.out.println("Product Saved!");
		
		pController.saveProduct(p2);
		System.out.println("Product Saved!");
		
		List<Product> products = pController.fetchAllProducts();
		products.forEach(p-> System.out.println(p.getProductId()+" "+p.getProductName()+" "+p.getProductPrice()));
				
		
		int productId = 10;
		Product myProduct = pController.fetchProductDetails(productId);
		//display product
		
		context.close();
	}
}
