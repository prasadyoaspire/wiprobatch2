package com.abc.springaop.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogginAspect.class);
		
	@Before("execution (* com.abc.springaop.service.MyService.performTask())")
	public void logBeforeMethod() {
		logger.info("Before Method...");
	}
	
	@After("execution (* com.abc.springaop.service.MyService.performTask())")
	public void logAfterMethod() {
		logger.info("After Method...");
	}
}
