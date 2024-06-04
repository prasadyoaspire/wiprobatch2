package com.abc.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@Value("${message}")
	private String msg;
	
	@GetMapping("/demo")
	public String getMsg() {
		return msg;
	}
}
