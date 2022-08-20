package com.printmaster.nk.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.printmaster.nk.beans.Cart;
import com.printmaster.nk.components.ResourceHashHolder;
import com.printmaster.nk.components.ResourceMap;

@Slf4j
@ControllerAdvice
public class LinksAdvise {
	@Autowired
	Cart cart;
	
	@Autowired
	ResourceHashHolder resourseHashHolder;	
	
	@ModelAttribute
    public void cart(Model model){
		model.addAttribute("cart", cart);
    }
	
	@ModelAttribute
    public void commonResources(Model model) {		
		for(ResourceMap map: ResourceMap.values()){
			model.addAttribute(map.getName(), resourseHashHolder.getResource(map.getName()));
		}		
		/**
		 * just be ready for changing in the future
		 * */
//		model.addAttribute(ResourceMap.DESCRIPTIONS.getName(), resourseHashHolder.getResource(ResourceMap.DESCRIPTIONS.getName()));

    }

	@ModelAttribute
    public void addReklam(Model model) {
		JSONParser parser = new JSONParser();	
		try {
			JSONArray reklam = (JSONArray)parser.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/left_reklam.json"), "UTF-8"));
				
			//for showing new added reklam in top
			Collections.reverse(reklam);
			model.addAttribute("reklam", reklam);
		} catch (IOException | ParseException e) {
			log.error("Error, while add to request parameters reklam: ", e);
		}
    }
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
