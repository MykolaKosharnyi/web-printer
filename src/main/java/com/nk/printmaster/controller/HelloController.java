package com.nk.printmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class HelloController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model){
		model.addAttribute("message", "Hello Spring WEB MVC!");
		return "hello";
	}
	
	@RequestMapping(value = "/index1", method = RequestMethod.GET)
	public String index1(ModelMap model){
		model.addAttribute("message", "Hello!");
		return "ask";
	}
	
}
