package com.abc.ecomapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.abc.ecomapp.model.Customer;

@Controller
public class RegistrationController {
	
	@RequestMapping("/regisrationform")
	public ModelAndView getRegistrationForm() {
		Customer customer = new Customer();		
		return new ModelAndView("registration", "myCustomer",customer);
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegistration(@ModelAttribute("myCustomer") Customer customer,Model model) {
		model.addAttribute("customer", customer);
		return "registration-success";
	}
}
