package com.abc.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springcore.bean.Greeting;

public class GreetingMain {

	public static void main(String[] args) {

		// Greeting greeting = new Greeting();
		// greeting.setMessage("Hello How Are You?");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");

		Greeting greeting = (Greeting) context.getBean("helloBean");
		greeting.sayHello();

	}
}
