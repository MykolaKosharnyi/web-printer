package com.printmaster.nk.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class VideoCaruoselHomePageController {

	private Logger logger = Logger.getLogger(VideoCaruoselHomePageController.class);
	
	private JSONObject obj = null;
	private String pathToJSONFile = "/var/www/localhost/home.json";
    
    @RequestMapping(value="/admin/video_on_home_page", method = RequestMethod.GET)
    public String showMenu(Model model){
    	
    	JSONParser parser = new JSONParser();

			try {
				obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(pathToJSONFile), "UTF-8"));
				model.addAttribute("listVideo", (JSONArray) obj.get("listVideo"));
			} catch (IOException | ParseException  e) {
				e.printStackTrace();
			}
   
    	return "admin/video_on_home_page";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/video_on_home_page/upload_video/{pathVideo}/{description}", method = RequestMethod.POST,consumes="application/json",
		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody String uploadPicturesMenu(@PathVariable("pathVideo") String pathVideo, @PathVariable("description") String description) {
    	logger.info("upload new video.");
		JSONParser parser = new JSONParser();
		
		try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(pathToJSONFile), "UTF-8"));
			
			JSONArray arrayOfVideo = null;
			if( obj.get("listVideo") != null ){
				arrayOfVideo = (JSONArray) obj.get("listVideo");
				obj.remove("listVideo");
			} else {
				arrayOfVideo = new JSONArray();
			}
			
			//add transformation DESCRIPTION into correct form
			String str = "word";
			str = str.replace('>', '/');
			JSONObject video = new JSONObject();
			video.put("path", pathVideo);
			video.put("description", description.replace('^', '.').replace('>', '/'));
			arrayOfVideo.add(video);

			obj.put("listVideo", arrayOfVideo);
			
			Writer out = new PrintWriter(pathToJSONFile, "UTF-8");
			out.write(obj.toJSONString());
			out.flush();
			out.close();
			
		} catch (ParseException e) {
			e.printStackTrace();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        
         return "rlxjuG9YHkM";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/admin/video_on_home_page/change_order_video", method = RequestMethod.POST,consumes="application/json",
		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void changeOrderVideos(@RequestBody List<String> videoOrder) {
    	logger.info("change order of video");
    	
    	JSONParser parser = new JSONParser();
		
			try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(pathToJSONFile), "UTF-8"));
			
			JSONArray arrayOfVideo = (JSONArray) obj.get("listVideo");			
			JSONArray sortedArrayOfVideo = new JSONArray();
			
			for(String videoPath : videoOrder){
				JSONObject video = new JSONObject();
				video.put("path", videoPath);
				video.put("description", findDescription(arrayOfVideo, videoPath));
				sortedArrayOfVideo.add(video);
			}
		
			obj.remove("listVideo");
			obj.put("listVideo", sortedArrayOfVideo);
			

				Writer out = new PrintWriter(pathToJSONFile, "UTF-8");
				out.write(obj.toJSONString());
				out.flush();
				out.close();
				
			} catch (ParseException e) {
				e.printStackTrace();	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	  	  	
    }
    
    @SuppressWarnings("rawtypes")
	private String findDescription(JSONArray arrayOfVideo, String videoPath){
    	String result = null;
    	Iterator it = arrayOfVideo.iterator();
    	while(it.hasNext()){
    		JSONObject video = (JSONObject) it.next();
    		if(video.get("path").equals(videoPath)){
    			result = (String) video.get("description");
    			break;
    		}
    	}
    	return result;
    }
    
    
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value="/admin/video_on_home_page/remove_video/{path}", method = RequestMethod.POST,consumes="application/json",
		headers = "content-type=application/x-www-form-urlencoded")
    public @ResponseBody void removeVideo(@PathVariable("path") String pathVideo) {

    	logger.info("remove video from home page carousel"); 	

    	JSONParser parser = new JSONParser();
		
		try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(pathToJSONFile), "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		JSONArray arrayOfVideo = (JSONArray) obj.get("listVideo");			
		
		Iterator it = arrayOfVideo.iterator();
    	while(it.hasNext()){
    		JSONObject video = (JSONObject) it.next();
    		if(video.get("path").equals(pathVideo)){
    			it.remove();
    			break;
    		}
    	}
		
		obj.remove("listVideo");
		obj.put("listVideo", arrayOfVideo);
		
		try {
			Writer out = new PrintWriter(pathToJSONFile, "UTF-8");
			out.write(obj.toJSONString());
			out.flush();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
    }
	
}

