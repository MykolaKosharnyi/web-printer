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

import static com.printmaster.nk.controller.ConstUsedInContr.*;

@Controller
public class VideoCaruoselHomePageController {

	private Logger logger = Logger.getLogger(VideoCaruoselHomePageController.class);
	
	private static final String PATH_TO_JSON_FILE = "/var/www/localhost/home.json";
	private static final String LIST_VIDEO = "listVideo"; 
	private static final String PATH_PARAMETER = "path";
	private static final String PATH_DESCRIPTION = "description";
    
    @RequestMapping(value="/"+PATH_ADMIN+"/video_on_home_page", method = RequestMethod.GET)
    public String showMenu(Model model){
		model.addAttribute(LIST_VIDEO, getJsonArrayOfVideo());
    	return "admin/video_on_home_page";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/"+PATH_ADMIN+"/video_on_home_page/upload_video/{pathVideo}/{description}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
		headers = JSON_HEADERS)
    public @ResponseBody String uploadPicturesMenu(@PathVariable("pathVideo") String pathVideo, @PathVariable(PATH_DESCRIPTION) String description) {
		JSONArray arrayOfVideo = getJsonArrayOfVideo();

		// add transformation DESCRIPTION into correct form
		String str = "word";
		str = str.replace('>', '/');
		JSONObject video = new JSONObject();
		video.put(PATH_PARAMETER, pathVideo);
		video.put(PATH_DESCRIPTION, description.replace('^', '.').replace('>', '/'));
		arrayOfVideo.add(video);

		saveJsonArray(arrayOfVideo);
		logger.info("upload new video.");
		return "rlxjuG9YHkM";
    }
    
    @SuppressWarnings("unchecked")
	@RequestMapping(value="/"+PATH_ADMIN+"/video_on_home_page/change_order_video", method = RequestMethod.POST,consumes=JSON_CONSUMES,
		headers = JSON_HEADERS)
    public @ResponseBody void changeOrderVideos(@RequestBody List<String> videoOrder) {
		JSONArray arrayOfVideo = getJsonArrayOfVideo();
		JSONArray sortedArrayOfVideo = new JSONArray();

		for (String videoPath : videoOrder) {
			JSONObject video = new JSONObject();
			video.put(PATH_PARAMETER, videoPath);
			video.put(PATH_DESCRIPTION, findDescription(arrayOfVideo, videoPath));
			sortedArrayOfVideo.add(video);
		}

		saveJsonArray(sortedArrayOfVideo);
		logger.info("change order of video");
    }
    
    @SuppressWarnings("rawtypes")
	private String findDescription(JSONArray arrayOfVideo, String videoPath){
    	String result = null;
    	Iterator it = arrayOfVideo.iterator();
    	while(it.hasNext()){
    		JSONObject video = (JSONObject) it.next();
    		if(video.get(PATH_PARAMETER).equals(videoPath)){
    			result = (String) video.get(PATH_DESCRIPTION);
    			break;
    		}
    	}
    	return result;
    }
    
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value="/"+PATH_ADMIN+"/video_on_home_page/remove_video/{path}", method = RequestMethod.POST,consumes=JSON_CONSUMES,
		headers = JSON_HEADERS)
    public @ResponseBody void removeVideo(@PathVariable(PATH_PARAMETER) String pathVideo) {
		JSONArray arrayOfVideo = getJsonArrayOfVideo();			
		
		Iterator it = arrayOfVideo.iterator();
    	while(it.hasNext()){
    		JSONObject video = (JSONObject) it.next();
    		if(video.get(PATH_PARAMETER).equals(pathVideo)){
    			it.remove();
    			break;
    		}
    	}
		saveJsonArray(arrayOfVideo);
		logger.info("remove video from home page carousel"); 
    }
	
	private JSONArray getJsonArrayOfVideo(){
		return (JSONArray) getHomeJSON().get(LIST_VIDEO);
    }
    
    private JSONObject getHomeJSON(){
    	try(InputStreamReader reader = new InputStreamReader(new FileInputStream(PATH_TO_JSON_FILE), "UTF-8")) {
			JSONParser parser = new JSONParser();
			return (JSONObject)parser.parse(reader);
		} catch (IOException | ParseException  e) {
			throw new RuntimeException(e);
		}
    }
    
    @SuppressWarnings("unchecked")
	private void saveJsonArray(JSONArray array){
    	JSONObject homeJSON = getHomeJSON();    	
    	homeJSON.put(LIST_VIDEO, array);

		try {
			Writer out = new PrintWriter(PATH_TO_JSON_FILE, "UTF-8");
			out.write(homeJSON.toJSONString());
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

