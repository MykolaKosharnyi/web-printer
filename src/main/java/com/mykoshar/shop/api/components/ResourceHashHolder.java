package com.mykoshar.shop.api.components;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class ResourceHashHolder {

	private Map<String, JSONObject> resourse = new HashMap<>();
	
	public ResourceHashHolder(){
		for(ResourceMap map:ResourceMap.values()){
			resourse.put(map.getName(), getJSONObject(map.getPath()));
		}
	}
	
	public JSONObject getResource(String nameResource){
		return resourse.get(nameResource);
	}
	
	public void changeResource(String nameResource, JSONObject resource){
		resourse.put(nameResource, resource);
	}
	
	private JSONObject getJSONObject(String nameFile){
		JSONObject result = null;	
		JSONParser parser = new JSONParser();
	
		try {
			result = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(nameFile), "UTF-8"));
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
