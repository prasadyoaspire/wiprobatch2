package com.abc.springaop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abc.springaop.config.AppConfiguration;
import com.abc.springaop.service.MyService;

public class Main {

	public static void main(String[] args) {
		
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appcontext.xml");	
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		MyService myService =  context.getBean(MyService.class);
		myService.performTask();
		context.close();
	}

}
