package com.abc.springcore3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.abc.springcore3.bean.Circle;
import com.abc.springcore3.bean.Greeting;
import com.abc.springcore3.bean.Triangle;
import com.abc.springcore3.service.ShapeService;

@Configuration
public class AppConfig {

	@Bean
	public Greeting getGreetingBean() {
		Greeting greeting = new Greeting();
		greeting.setMessage("How are you doing?");		
		return greeting;
	}
	
	@Bean
	public Circle getCircleBean() {
		Circle circle = new Circle();
		circle.setRadius(5);
		return circle;
	}
	
	@Bean
	public Triangle getTriangleBean() {
		Triangle triangle = new Triangle();
		triangle.setBase(3);
		triangle.setHeight(5);
		return triangle;
	}
	
	@Bean
	public ShapeService getShapeServiceBean() {
		ShapeService shapeService = new ShapeService();
		shapeService.setShape(getTriangleBean()); // injection
		return shapeService;
	}
}
