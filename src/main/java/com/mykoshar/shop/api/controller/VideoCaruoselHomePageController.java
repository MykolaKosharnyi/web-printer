package com.mykoshar.shop.api.controller;

import static com.mykoshar.shop.api.controller.ConstUsedInContr.*;

import java.util.Iterator;
import java.util.List;

import com.mykoshar.shop.api.beans.ComponentsForControllers;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class VideoCaruoselHomePageController {
	private static final String NAME_JSON_FILE = "home";
	private static final String LIST_VIDEO = "listVideo"; 
	private static final String PATH_PARAMETER = "path";
	private static final String PATH_DESCRIPTION = "description";
	
	@Autowired
    ComponentsForControllers componets;
    
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
		log.info("upload new video.");
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
		log.info("change order of video");
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
		log.info("remove video from home page carousel");
    }
	
	private JSONArray getJsonArrayOfVideo(){
		return (JSONArray) getHomeJSON().get(LIST_VIDEO);
    }
    
    private JSONObject getHomeJSON(){
    	return componets.jsonObjectParser(NAME_JSON_FILE);
    }
    
    @SuppressWarnings("unchecked")
	private void saveJsonArray(JSONArray array){
    	JSONObject homeJSON = getHomeJSON();    	
    	homeJSON.put(LIST_VIDEO, array);

    	componets.saveObject(homeJSON, NAME_JSON_FILE); 	
    }
	
}

