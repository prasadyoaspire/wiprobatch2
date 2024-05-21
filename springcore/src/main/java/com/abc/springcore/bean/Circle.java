package com.abc.springcore.bean;

public class Circle implements Shape  {
	
	private int radius;
	
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public double area() {	
		System.out.println("Circle Area:");
		double area = Shape.PI*radius*radius;		
		return area;
	}

}
