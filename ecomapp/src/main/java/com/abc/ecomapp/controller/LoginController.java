package com.abc.ecomapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	@RequestMapping("/loginform")
	public String getLoginForm() {
		return "login";
	}

	@RequestMapping("/login")
	public String doLogin(@RequestParam("uname")  String username, @RequestParam("pwd") String password, Model model) {
		if(password.equals("1234")) {
			model.addAttribute("logginedUser", username);
			return "login-success";
		}
		else {
			return "login-failure";
		}		
	}
}
