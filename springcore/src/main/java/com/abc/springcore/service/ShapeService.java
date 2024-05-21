package com.abc.springcore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.abc.springcore.bean.Shape;

public class ShapeService {
	
	@Autowired
	@Qualifier("circle1")
	private Shape shape; // dependency 
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public double findArea() {		
		double result = shape.area();
		return result;
	}
}
