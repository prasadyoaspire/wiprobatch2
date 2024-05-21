package com.abc.springcore.service;

import com.abc.springcore.bean.Shape;

public class ShapeService {
	
	private Shape shape; // dependency 
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public double findArea() {		
		double result = shape.area();
		return result;
	}
}
