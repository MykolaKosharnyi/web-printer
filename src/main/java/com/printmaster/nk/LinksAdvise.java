package com.printmaster.nk;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class LinksAdvise {
	private Logger logger = Logger.getLogger(LinksAdvise.class);

	private String path = "/var/www/localhost" + File.separator + "links.json";
	
	@ModelAttribute
    public void addLinksInLeftMenu(Model model) {
		logger.info("Creating links for left menu.");
		JSONParser parser = new JSONParser();
		
		try {		
			
			JSONObject jsonObject=(JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			model.addAttribute("listLeftLinks", jsonObject);

		} catch (FileNotFoundException e) {
			logger.error("File not found: ", e);
		} catch (IOException e) {
			logger.error("IOException: ", e);
		} catch (org.json.simple.parser.ParseException e) {
			logger.error("simple.parser.ParseException: ", e);
		}	catch (Exception e) {
			logger.error("Just exception : ", e);
		}
    }

	@ModelAttribute
    public void addReklam(Model model) {
		logger.info("Add reklam.");
		JSONParser parser = new JSONParser();
	
			try {
				JSONObject jsonObject = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/left_reklam.json"), "UTF-8"));
				JSONArray reklam = (JSONArray) jsonObject.get("reklam");
				model.addAttribute("reklam", reklam);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
    }
	
	@ModelAttribute
    public void addPicturesHeadMenu(Model model) {
		logger.info("Add pictures in head menu.");
		JSONParser parser = new JSONParser();
	
			try {
				JSONObject jsonObject = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream("/var/www/localhost/pictures_head_menu.json"), "UTF-8"));
				model.addAttribute("picturesInHeadMenu", jsonObject);
			} catch (IOException | ParseException e) {
				e.printStackTrace();
			}
    }
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        sdf.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
}
