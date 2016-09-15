package com.printmaster.nk.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConstController {
	
	private Logger logger = Logger.getLogger(ConstController.class);
	private String pathToFile = "/var/www/localhost/products/constant.json";
	
	@RequestMapping(value = "/admin/constants", method = RequestMethod.GET)
	public String getConstants(Model model){
		logger.info("Read json CONST file.");

		 try {
				model.addAttribute("constants", (JSONObject)new JSONParser().
    					parse(new InputStreamReader(new FileInputStream(pathToFile), "UTF-8")));
			} catch (IOException | ParseException e) {}
	    return "admin/constants";
	}

}
