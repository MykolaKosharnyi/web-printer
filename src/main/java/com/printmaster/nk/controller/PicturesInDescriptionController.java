package com.printmaster.nk.controller;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PicturesInDescriptionController {

	private static final String ROOT_PATH_TO_PICTURES = "/var/www/localhost/images";
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/pictures_in_description/{concreteFolder}", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JSONArray getDirectoryWithFiles(@PathVariable("concreteFolder") String concreteFolder){
    	JSONArray result = new JSONArray();
    	
    	File folder = ("root_path".equals(concreteFolder)) ? new File(ROOT_PATH_TO_PICTURES):
    			new File(ROOT_PATH_TO_PICTURES + File.separator + concreteFolder.replace(":", File.separator));
    	
    	File[] listOfFiles = folder.listFiles();
    	
		for (int i = 0; i < listOfFiles.length; i++) {
			JSONObject object = new JSONObject();
			object.put("name", listOfFiles[i].getName());
			if (listOfFiles[i].isFile()) {
				object.put("isDirectory", false);
			} else if (listOfFiles[i].isDirectory()) {
				object.put("isDirectory", true);
			}
			result.add(object);
		}  	
		
		Collections.sort(result, new Comparator<JSONObject>(){
			@Override
			public int compare(JSONObject o1, JSONObject o2) {
				return ((Boolean) o2.get("isDirectory")).compareTo((Boolean) o1.get("isDirectory"));
			}
		});
		
    	return result;
    }
    

	@RequestMapping(value = "/create_directory_pictures_in_description/{concreteFolder}", method = RequestMethod.POST, 
            produces = {"application/json; charset=UTF-8","*/*;charset=UTF-8"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String createNewDirectory(@PathVariable("concreteFolder") String concreteFolder, @RequestBody String folderName){
 
		String allPath = ("root_path".equals(concreteFolder)) ? ROOT_PATH_TO_PICTURES:
			ROOT_PATH_TO_PICTURES + File.separator + concreteFolder.replace(":", File.separator);
		
		if(folderName.charAt(0)=='"' && folderName.charAt(folderName.length()-1)=='"'){
			folderName = folderName.substring(1, folderName.length()-1);
		}
		
		if(new File(allPath + File.separator + folderName).mkdir()){
			return "{\"msg\":\"Директория успешно создана!\"}";       	
        } else {
        	return "{\"msg\":\"Не удалось создать директорию!\"}";
        }
    }
}
