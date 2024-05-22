package com.abc.springcore3.bean;

public class Triangle implements Shape {

	private int base;
	private int height;
	
	public void setBase(int base) {
		this.base = base;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public double area() {
		System.out.println("Triangle Area: ");
		double area = 0.5 * base * height;
		return area;
	}

}
