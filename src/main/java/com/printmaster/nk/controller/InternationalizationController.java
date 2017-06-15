package com.printmaster.nk.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class InternationalizationController {
	
	@RequestMapping(value = "/admin/internationalization/{subType}", method = RequestMethod.GET)
	public String getConstants(@PathVariable("subType") String subType, Model model){
		model.addAttribute("title", "Интернационализация");
		model.addAttribute("subType", subType);
		
		JSONParser parser = new JSONParser();
		
		try {
			JSONObject jsonObject = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/" + subType + ".json"), "UTF-8"));
			model.addAttribute("descriptions", jsonObject);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
	    return "admin/internationalization";
	}
	
	private JSONArray getParametersLikeArray(JSONObject jsonObject){
		JSONArray result  = new JSONArray();
		Iterator<String> keys = jsonObject.keySet().iterator();
		
		while(keys.hasNext()){
			
		}
		
		return result;
	}

	@RequestMapping(value = "/admin/internationalization/{subType}/update", method = RequestMethod.POST) 
	public String handleFormUploadSave(@PathVariable("subType") String subType, Model model,
			@RequestParam Map<String,String> allRequestParams){
		

		
	   return "redirect:/admin/internationalization/" + subType;
	}
}
