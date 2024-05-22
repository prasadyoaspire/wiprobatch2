package com.abc.springcore3.bean;

public class Greeting {

	private String message;

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void sayHello() {
		System.out.println("Message: "+message);
	}
}
