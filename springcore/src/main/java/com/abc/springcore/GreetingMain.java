package com.abc.springcore;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springcore.bean.Greeting;

public class GreetingMain {

	public static void main(String[] args) {

		// Greeting greeting = new Greeting();
		// greeting.setMessage("Hello How Are You?");

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");

		Greeting greeting1 = (Greeting) context.getBean("helloBean");
		
		Greeting greeting2 = (Greeting) context.getBean("helloBean");
		
		if(greeting1 == greeting2) {
			System.out.println("both refer to same object");
		}
		else {
			System.out.println("both refer to different object");
		}
				
		greeting1.sayHello();
	}
}
