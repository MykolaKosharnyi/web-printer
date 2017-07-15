package com.printmaster.nk.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.printmaster.nk.components.ResourceHashHolder;

@Controller
public class InternationalizationController {
	
	@Autowired
	ResourceHashHolder resourseHashHolder;
	
	@RequestMapping(value = "/admin/internationalizations", method = RequestMethod.GET)
	public String internationalizations(Model model){
	    return "admin/internationalizations";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/internationalization/{subType}", method = RequestMethod.GET)
	public String getConcreteInternationalization(@PathVariable("subType") String subType, Model model){
		model.addAttribute("title", "Интернационализация");
		model.addAttribute("subType", subType);

		final JSONObject jsonObject = getObject(subType);
			
		Map<String, JSONObject> result = new TreeMap<String , JSONObject>(new Comparator<String>(){
			@Override
			public int compare(String o1, String o2) {
				int resultOfComparation = ( (Long)((JSONObject) jsonObject.get(o1)).get("id"))
						.compareTo( (Long)((JSONObject) jsonObject.get(o2)).get("id"));
				
				if(resultOfComparation==0){
					return o1.compareTo(o2);
				}
				return resultOfComparation;
			}
		});
			
		for(Iterator<String> iterator = jsonObject.keySet().iterator(); iterator.hasNext();){
			String key = iterator.next();
			result.put(key, (JSONObject)jsonObject.get(key));
		}
				
		model.addAttribute("descriptions", result);

	    return "admin/internationalization";
	}

	@RequestMapping(value = "/admin/internationalization/{subType}/update", method = RequestMethod.POST) 
	public String changeDescription(@PathVariable("subType") String subType, Model model,
			@RequestParam Map<String,String> allRequestParams){
		
		JSONObject object = getObject(subType);
		changeObject(object, allRequestParams);
		resourseHashHolder.changeResource(subType, object);
		saveObject(object, subType);
		
	   return "redirect:/admin/internationalization/" + subType;
	}
	
	@SuppressWarnings("unchecked")
	@Autowired(required = false)
	private void changeObject(JSONObject object,  Map<String,String> allRequestParams){
		for (Map.Entry<String, String> entry : allRequestParams.entrySet()){
			if(!"_csrf".equals(entry.getKey())){
				JSONObject objectValue = (JSONObject) object.get(entry.getKey());
				objectValue.put("en", entry.getValue());
				object.put(entry.getKey(), objectValue);
			}	
		}
	}
	
	private JSONObject getObject(String subType){
		JSONObject result = null;
		JSONParser parser = new JSONParser();
		try {
			result = (JSONObject)parser
					.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/products/descriptions/" + subType + ".json"), "UTF-8"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private void saveObject(JSONObject jsonWithCharakteristic, String subType){
    	try {
			Writer out = new PrintWriter("/var/www/localhost/products/descriptions/" + subType + ".json", "UTF-8");
			out.write(jsonWithCharakteristic.toJSONString());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
    }
}
