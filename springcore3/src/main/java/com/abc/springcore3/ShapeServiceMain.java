package com.abc.springcore3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abc.springcore3.config.AppConfig;
import com.abc.springcore3.service.ShapeService;

public class ShapeServiceMain {

	public static void main(String[] args) {
	
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		ShapeService shapeService = context.getBean(ShapeService.class);
		
		double result = shapeService.findArea();
		System.out.println(result);
		
		context.close();

	}

}
