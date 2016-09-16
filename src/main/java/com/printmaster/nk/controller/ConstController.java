package com.printmaster.nk.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.printmaster.nk.beans.ConstServer;
import com.printmaster.nk.beans.Constants;

@Controller
public class ConstController {
	
	private Logger logger = Logger.getLogger(ConstController.class);
	
	private String pathToFile = "/var/www/localhost/products/constant.json";
	
	@Autowired
	private ConstServer constantsServer;
	
	@RequestMapping(value = "/admin/constants", method = RequestMethod.GET)
	public String getConstants(Model model){
		logger.info("Read json CONST file.");
		model.addAttribute("title", "Константы");
		
		Constants constants = new Constants();
		constants.setDollarInGrivna(constantsServer.getConstants().get("dollar_in_grivna"));
		constants.setEuroInGrivna(constantsServer.getConstants().get("euro_in_grivna"));
		constants.setPriceAviaSize(constantsServer.getConstants().get("price_avia_size"));
		constants.setPriceAviaWeight(constantsServer.getConstants().get("price_avia_weight"));
		constants.setPriceSeaSize(constantsServer.getConstants().get("price_sea_size"));
		constants.setPriceSeaWeight(constantsServer.getConstants().get("price_sea_weight"));
		constants.setPriceUkraineSize(constantsServer.getConstants().get("price_ukraine_size"));
		constants.setPriceUkraineWeight(constantsServer.getConstants().get("price_ukraine_weight"));
		constants.setPriceKyivSize(constantsServer.getConstants().get("price_kyiv_size"));
		constants.setPriceKyivWeight(constantsServer.getConstants().get("price_kyiv_weight"));
		
		model.addAttribute("constantsChange", constants);
	    return "admin/constants";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/constants/update", method = RequestMethod.POST) 
	public String handleFormUploadSave(@ModelAttribute("constantsChange") @Valid Constants constants,
			BindingResult result, Model model) throws IOException{

			if (result.hasErrors()) {
				model.addAttribute("constants", constants);
	            return "admin/constants";
	        }
		
			//action for saving new CONSTANTS
			JSONObject jsonFile = null;
			
			try {
				jsonFile = (JSONObject)new JSONParser().
	    					parse(new InputStreamReader(new FileInputStream(pathToFile), "UTF-8"));

				jsonFile.put("dollar_in_grivna", constants.getDollarInGrivna());

				jsonFile.put("euro_in_grivna", constants.getEuroInGrivna());

				jsonFile.put("price_avia_size", constants.getPriceAviaSize());

				jsonFile.put("price_avia_weight", constants.getPriceAviaWeight());

				jsonFile.put("price_sea_size", constants.getPriceSeaSize());

				jsonFile.put("price_sea_weight", constants.getPriceSeaWeight());
	
				jsonFile.put("price_ukraine_size", constants.getPriceUkraineSize());

				jsonFile.put("price_ukraine_weight", constants.getPriceUkraineWeight());

				jsonFile.put("price_kyiv_size", constants.getPriceKyivSize());

				jsonFile.put("price_kyiv_weight", constants.getPriceKyivWeight());
			
			Writer out = new PrintWriter(pathToFile, "UTF-8");
			out.write(jsonFile.toJSONString());
			out.flush();
			out.close();
			
			} catch (IOException | ParseException e) {}
			
	   return "redirect:/admin/constants";
	}

}