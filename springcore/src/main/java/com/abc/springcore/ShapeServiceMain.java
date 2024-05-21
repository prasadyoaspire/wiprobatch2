package com.abc.springcore;

import com.abc.springcore.bean.Circle;
import com.abc.springcore.bean.Triangle;
import com.abc.springcore.service.ShapeService;

public class ShapeServiceMain {

	public static void main(String[] args) {
		
		//Circle s = new Circle();
		//s.setRadius(5);
		
		Triangle s = new Triangle();
		s.setBase(3);
		s.setHeight(5);
		
		ShapeService shapeService = new ShapeService();
		shapeService.setShape(s); // injecting dependency object into shapeSerivce
		
		double result = shapeService.findArea();
		System.out.println("Area: "+result);
	}

}
