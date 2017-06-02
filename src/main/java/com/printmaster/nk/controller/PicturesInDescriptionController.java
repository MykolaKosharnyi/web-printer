package com.printmaster.nk.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
public class PicturesInDescriptionController {

	private static final String ROOT_PATH_TO_PICTURES = "/var/www/localhost/images/description";
    
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
	
	@RequestMapping(value="/load_new_picture_to_modal_window/{concreteFolder}", method = RequestMethod.POST)
	public @ResponseBody String uploadPicture(MultipartHttpServletRequest request,
			@PathVariable("concreteFolder") String concreteFolder) {
		String result = null;
		
		String allPath = ("root_path".equals(concreteFolder)) ? ROOT_PATH_TO_PICTURES:
			ROOT_PATH_TO_PICTURES + File.separator + concreteFolder.replace(":", File.separator);
		
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		String fileName = null;

		while (itr.hasNext()) {
			mpf = request.getFile(itr.next());
			fileName = System.currentTimeMillis() + "" + mpf.getOriginalFilename().substring(mpf.getOriginalFilename()
							.lastIndexOf("."))/* last part is file extension */;

			try {
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(allPath + File.separator + fileName));
				result = "Изображение успешно загружено!";   
			} catch (IOException e) {
				result = "Не удалось загрузить изображение!";
			}
		}
		return result;
	}
	
	@RequestMapping(value = "/delete_element_pictures_in_description/{concreteElement}", method = RequestMethod.POST, 
            produces = {"application/json; charset=UTF-8","*/*;charset=UTF-8"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String deleteElement(@PathVariable("concreteElement") String concreteElement, @RequestBody String elementName){
 
		String allPath = ("root_path".equals(concreteElement)) ? ROOT_PATH_TO_PICTURES:
			ROOT_PATH_TO_PICTURES + File.separator + concreteElement.replace(":", File.separator);
		
		if(elementName.charAt(0)=='"' && elementName.charAt(elementName.length()-1)=='"'){
			elementName = elementName.substring(1, elementName.length()-1);
		}
		
		String result = null;
		if(elementName.indexOf(".")!=-1){
			try {
	    		FileUtils.forceDelete(new File(allPath + File.separator + elementName));
	    		result = "{\"msg\":\"Елемент успешно удален!\"}";
			} catch (IOException e) {
				result = "{\"msg\":\"Не удалось удалить выбранный елемент!\"}";
			} 
		} else {
			try {
	    		FileUtils.deleteDirectory(new File(allPath + File.separator + elementName));
	    		result = "{\"msg\":\"Елемент успешно удален!\"}";
			} catch (IOException e) {
				result = "{\"msg\":\"Не удалось удалить выбранный елемент!\"}";
			}
		}
		
		return result;  
    }
}
