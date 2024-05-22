package com.abc.ecomapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hi")
	public String sayHello() {
		return "hello";
	}	
	
	@RequestMapping("/demo")
	public String test(Model model) {		
		String data = "Product Details";
		model.addAttribute("data", data);
		return "home";
	}	
	
}
