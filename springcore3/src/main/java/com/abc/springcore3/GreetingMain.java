package com.abc.springcore3;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.abc.springcore3.bean.Greeting;
import com.abc.springcore3.config.AppConfig;

public class GreetingMain {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		Greeting greeting = context.getBean(Greeting.class);
		greeting.sayHello();
		
		context.close();

	}

}
