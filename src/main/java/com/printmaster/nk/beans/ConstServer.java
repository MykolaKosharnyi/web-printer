package com.printmaster.nk.beans;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class ConstServer {
	
	private String pathToFile = "/var/www/localhost/products/constant.json";
	
	public Constants getConstants(){
		Constants constants = new Constants();

		JSONObject jsonFile = getJSONObject();
		
		constants.setDollarInGrivna( ((Number)jsonFile.get(Constants.DOLLAR_IN_GRIVNA)).doubleValue() );
		constants.setEuroInGrivna(((Number)jsonFile.get(Constants.EURO_IN_GRIVNA)).doubleValue());
		constants.setPriceAviaSize(((Number)jsonFile.get(Constants.PRICE_AVIA_SIZE)).doubleValue());
		constants.setPriceAviaWeight(((Number)jsonFile.get(Constants.PRICE_AVIA_WEIGHT)).doubleValue());
		constants.setPriceSeaSize(((Number)jsonFile.get(Constants.PRICE_SEA_SIZE)).doubleValue());
		constants.setPriceSeaWeight(((Number)jsonFile.get(Constants.PRICE_SEA_WEIGHT)).doubleValue());
		constants.setPriceUkraineSize(((Number)jsonFile.get(Constants.PRICE_UKRAINE_SIZE)).doubleValue());
		constants.setPriceUkraineWeight(((Number)jsonFile.get(Constants.PRICE_UKRAINE_WEIGHT)).doubleValue());
		constants.setPriceKyivSize(((Number)jsonFile.get(Constants.PRICE_KYIV_SIZE)).doubleValue());
		constants.setPriceKyivWeight(((Number)jsonFile.get(Constants.PRICE_KYIV_WEIGHT)).doubleValue());	
		constants.setPercentInsuranceUkraine(((Number)jsonFile.get(Constants.PERCENT_INSURANCE_UKRAINE)).doubleValue());
		constants.setPercentInsuranceInternational(((Number)jsonFile.get(Constants.PERCENT_INSURANCE_INTERNATIONAL)).doubleValue());
		
		return constants;
	}
	
	@SuppressWarnings("unchecked")
	public void saveConstants(Constants constants){
		JSONObject jsonFile = getJSONObject();
		
		try {

			jsonFile.put(Constants.DOLLAR_IN_GRIVNA, constants.getDollarInGrivna());
			jsonFile.put(Constants.EURO_IN_GRIVNA, constants.getEuroInGrivna());
			jsonFile.put(Constants.PRICE_AVIA_SIZE, constants.getPriceAviaSize());
			jsonFile.put(Constants.PRICE_AVIA_WEIGHT, constants.getPriceAviaWeight());
			jsonFile.put(Constants.PRICE_SEA_SIZE, constants.getPriceSeaSize());
			jsonFile.put(Constants.PRICE_SEA_WEIGHT, constants.getPriceSeaWeight());
			jsonFile.put(Constants.PRICE_UKRAINE_SIZE, constants.getPriceUkraineSize());
			jsonFile.put(Constants.PRICE_UKRAINE_WEIGHT, constants.getPriceUkraineWeight());
			jsonFile.put(Constants.PRICE_KYIV_SIZE, constants.getPriceKyivSize());
			jsonFile.put(Constants.PRICE_KYIV_WEIGHT, constants.getPriceKyivWeight());				
			jsonFile.put(Constants.PERCENT_INSURANCE_UKRAINE, constants.getPercentInsuranceUkraine());				
			jsonFile.put(Constants.PERCENT_INSURANCE_INTERNATIONAL, constants.getPercentInsuranceInternational());
		
		Writer out = new PrintWriter(pathToFile, "UTF-8");
		out.write(jsonFile.toJSONString());
		out.flush();
		out.close();
		
		} catch (IOException e) {}
	}
	
	private JSONObject getJSONObject(){
		JSONObject file = null;
		
		try {
			file = (JSONObject)new JSONParser().
    			parse(new InputStreamReader(new FileInputStream(pathToFile), "UTF-8"));
    	} catch (IOException | ParseException e) {}
		
		return file;
	}

}