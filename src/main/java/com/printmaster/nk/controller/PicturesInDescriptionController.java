package com.printmaster.nk.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PicturesInDescriptionController {

	private static final String ROOT_PATH_TO_PICTURES = "/var/www/localhost/images";
	
//	@RequestMapping(value = "/pictures_in_description", method = RequestMethod.GET)	
    public String getFilesInImages(Model model) {
    	File folder = new File(ROOT_PATH_TO_PICTURES);
    	File[] listOfFiles = folder.listFiles();
    	
    	List<String> listOfFolders = new ArrayList<>();
    	List<String> listOfPictures = new ArrayList<>();

    	    for (int i = 0; i < listOfFiles.length; i++) {
    	      if (listOfFiles[i].isFile()) {
    	    	  listOfPictures.add(listOfFiles[i].getName());
    	      } else if (listOfFiles[i].isDirectory()) {
    	    	  listOfFolders.add(listOfFiles[i].getName());
    	      }
    	    }
        return "s";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/pictures_in_description/{concreteFolder}", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JSONArray getDirectoryWithFiles(@PathVariable("concreteFolder") String concreteFolder){
    	JSONArray result = new JSONArray();
    	File folder = new File(ROOT_PATH_TO_PICTURES/* + concreteFolder*/);
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
    	return result;
    }
}
