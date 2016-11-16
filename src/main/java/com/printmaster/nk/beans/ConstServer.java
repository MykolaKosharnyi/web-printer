package com.printmaster.nk.beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class ConstServer {
	
	private Logger logger = Logger.getLogger(ConstServer.class);
	
	private String pathToFile = "/var/www/localhost/products/constant.json";
	
	public Map<String, Double> getConstants(){
		logger.info("Read json CONST file.");
		Map<String, Double> constants = new HashMap<String, Double>();
		
		JSONObject jsonFile = null;
		
		try {
			jsonFile = (JSONObject)new JSONParser().
    					parse(new InputStreamReader(new FileInputStream(pathToFile), "UTF-8"));
    		} catch (IOException | ParseException e) {}
	
		constants.put("dollar_in_grivna", ((Number)jsonFile.get("dollar_in_grivna")).doubleValue());
		constants.put("euro_in_grivna", ((Number)jsonFile.get("euro_in_grivna")).doubleValue());
		constants.put("price_avia_size", ((Number)jsonFile.get("price_avia_size")).doubleValue());
		constants.put("price_avia_weight", ((Number)jsonFile.get("price_avia_weight")).doubleValue());
		constants.put("price_sea_size", ((Number)jsonFile.get("price_sea_size")).doubleValue());
		constants.put("price_sea_weight", ((Number)jsonFile.get("price_sea_weight")).doubleValue());
		constants.put("price_ukraine_size", ((Number)jsonFile.get("price_ukraine_size")).doubleValue());
		constants.put("price_ukraine_weight", ((Number)jsonFile.get("price_ukraine_weight")).doubleValue());
		constants.put("price_kyiv_size", ((Number)jsonFile.get("price_kyiv_size")).doubleValue());
		constants.put("price_kyiv_weight", ((Number)jsonFile.get("price_kyiv_weight")).doubleValue());
		constants.put("percent_insurance_ukraine", ((Number)jsonFile.get("percent_insurance_ukraine")).doubleValue());
		constants.put("percent_insurance_international", ((Number)jsonFile.get("percent_insurance_international")).doubleValue());
		
		return constants;
	}

}
