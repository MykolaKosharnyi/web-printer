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
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

@Component
@Scope(value=WebApplicationContext.SCOPE_GLOBAL_SESSION,
		proxyMode = ScopedProxyMode.TARGET_CLASS)
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
		
		constants.put("dollar_in_grivna", (Double) jsonFile.get("dollar_in_grivna"));
		constants.put("euro_in_grivna", (Double) jsonFile.get("euro_in_grivna"));
		constants.put("price_avia_size", (Double) jsonFile.get("price_avia_size"));
		constants.put("price_avia_weight", (Double) jsonFile.get("price_avia_weight"));
		constants.put("price_sea_size", (Double) jsonFile.get("price_sea_size"));
		constants.put("price_sea_weight", (Double) jsonFile.get("price_sea_weight"));
		constants.put("price_ukraine_size", (Double) jsonFile.get("price_ukraine_size"));
		constants.put("price_ukraine_weight", (Double) jsonFile.get("price_ukraine_weight"));
		constants.put("price_kyiv_size", (Double) jsonFile.get("price_kyiv_size"));
		constants.put("price_kyiv_weight", (Double) jsonFile.get("price_kyiv_weight"));
		return constants;
	}

}
