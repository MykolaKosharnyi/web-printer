package com.nk.printmaster.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nk.printmaster.entities.Printer;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@ModelAttribute("feeds")
	public Map<String, String> feeds(){
		Map<String, String> m = new HashMap<String, String>();
		m.put("Рулонный", "Рулонный \n");
		m.put("Плоскопечатный", "Плоскопечатный");
		m.put("Гибридный", "Гибридный");
		return m;
	}

	@RequestMapping(value = "/add_printer", method = RequestMethod.GET)
	public ModelAndView addNewPrinter() {
	    return new ModelAndView("addPrinter", "printer", new Printer());
	}
}
