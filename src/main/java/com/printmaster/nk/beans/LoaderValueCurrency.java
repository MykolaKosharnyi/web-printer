package com.printmaster.nk.beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.printmaster.nk.controller.CurrencyInfo;

@Slf4j
@Component("loaderValueCurrency")
public class LoaderValueCurrency {
	public void loadCurrency(){
		double dollar = 0;
		double euro = 0;
		
		try{
			RestTemplate restTemplate = new RestTemplate();
			
			ResponseEntity<List<CurrencyInfo>> infoResponse =
			        restTemplate.exchange("https://api.privatbank.ua/p24api/pubinfo?exchange&json&coursid=11", 
			        		HttpMethod.GET, null, new ParameterizedTypeReference<List<CurrencyInfo>>() {});
			
			
			for(CurrencyInfo curency : infoResponse.getBody()){
				if(curency.getCcy().equals("USD")){
					dollar = curency.getSale();
					log.info("Current currentsy of USD: " + dollar);
				} else if(curency.getCcy().equals("EUR")){
					euro = curency.getSale();
					log.info("Current currentsy of EUR: " + euro);
				}
			}
		} catch(Exception ex){
			log.error("Error while loading currentsy from PRIVATE BANK API",ex);
		}
		
		saveNewConstants(dollar, euro);
	}
	
	@SuppressWarnings("unchecked")
	private void saveNewConstants(double dollar, double euro){
		String pathToFile = "/var/www/localhost/products/constant.json";
		
		//action for saving new CONSTANTS
		JSONObject jsonFile = null;
		
		try {
			jsonFile = (JSONObject)new JSONParser().
    					parse(new InputStreamReader(new FileInputStream(pathToFile), "UTF-8"));	
			
			if(dollar > 0)
				jsonFile.put("dollar_in_grivna", dollar);
			
			if(euro > 0)
			jsonFile.put("euro_in_grivna", euro);
		
		Writer out = new PrintWriter(pathToFile, "UTF-8");
		out.write(jsonFile.toJSONString());
		out.flush();
		out.close();
		
		} catch (IOException | ParseException e) {
			log.error("Error while saving new constans (currentsy constants)",e);
		}
	}
}
