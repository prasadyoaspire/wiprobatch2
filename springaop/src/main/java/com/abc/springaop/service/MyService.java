package com.abc.springaop.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class MyService {
	
	//private static final Logger logger = LoggerFactory.getLogger(MyService.class);

	public void performTask() {
		
		//logger.info("peformTask() starts execution");
		
		System.out.println("task performed for business logic");
		
		//logger.info("peformTask() completes execution");
	}	
	
}
