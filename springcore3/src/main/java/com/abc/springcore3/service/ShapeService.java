package com.abc.springcore3.service;

import com.abc.springcore3.bean.Shape;

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
