package com.abc.springcore;

import com.abc.springcore.bean.Circle;
import com.abc.springcore.bean.Triangle;
import com.abc.springcore.service.ShapeService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShapeServiceMain {

	public static void main(String[] args) {
		
		//Circle s = new Circle();
		//s.setRadius(5);
		
//		Triangle s = new Triangle();
//		s.setBase(3);
//		s.setHeight(5);
//		
//		ShapeService shapeService = new ShapeService();
//		shapeService.setShape(s); // injecting dependency object into shapeSerivce
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");		
		ShapeService shapeService = (ShapeService) context.getBean("shapeService");
		
		double result = shapeService.findArea();
		System.out.println("Area: "+result);
		
		context.close();
	}
}
