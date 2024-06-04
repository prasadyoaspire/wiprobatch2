package com.abc.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {

	@Value("${message}")
	private String msg;
	
	@GetMapping("/hello")
	public String displayMsg() {
		return msg;
	}
}
