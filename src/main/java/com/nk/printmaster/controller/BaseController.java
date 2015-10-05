package com.nk.printmaster.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/hello")
public class BaseController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView welcome() {
	    ModelAndView mav = new ModelAndView("home"); 
	    return mav;
	}


	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {

		model.addAttribute("message", name);
		return "hello";

	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model){
		model.addAttribute("message", "Hello Spring WEB MVC!");
		return "hello";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index1(ModelMap model){
		return "home";
	}
	
}
