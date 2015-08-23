package com.sudarshan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sudarshan.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginSrvc;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String getHomePage(Model model) {
		
		String weolcomeMessage = "Hello World!";
		
		model.addAttribute("welcomeMessage", weolcomeMessage);
		
		return "home";
	}
	
	@RequestMapping(value="/getname", method=RequestMethod.GET)
	public String getName(Model model) {
		
		String name = loginSrvc.getNameById(1);
		
		model.addAttribute("name", name);
		
		return "name";
	}
	
	@RequestMapping(value="/ispresent", method=RequestMethod.GET)
	public String isPresent(Model model) {
		
		boolean isPresent = loginSrvc.isPresent("Sudarshan");
		
		model.addAttribute("isPresent", isPresent);
		
		return "present";
	}
	
}
