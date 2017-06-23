package com.printmaster.nk.beans;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

@Component
public class ReclamOnSite {	
	private String path = "/var/www/localhost" + File.separator + "left_reklam.json";
	
	@SuppressWarnings("unchecked")
	public void addReklam(ReklamProduct reklamProduct){
		JSONParser parser = new JSONParser();
			try {
				
				JSONArray jsonArray = (JSONArray)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
				@SuppressWarnings("rawtypes")
				Iterator iter = jsonArray.iterator();
				
				while (iter.hasNext()){
					JSONObject jsonObject = (JSONObject) iter.next();
					if(jsonObject.get("id").equals(reklamProduct.getId()) && 
							jsonObject.get("type").equals(reklamProduct.getType())){
						iter.remove();
						break;
					}
				}
				
				JSONObject productJSON = new JSONObject();
				
				productJSON.put("type", reklamProduct.getType());
				productJSON.put("id", reklamProduct.getId());
				productJSON.put("partNumber", reklamProduct.getPartNumber());
				
				productJSON.put("leftSharesLink", reklamProduct.getLeftSharesLink());
				productJSON.put("leftSharesLinkColorText", reklamProduct.getLeftSharesLinkColorText());
				productJSON.put("leftSharesLinkColorFone", reklamProduct.getLeftSharesLinkColorFone());
				
				productJSON.put("rightSharesLink", reklamProduct.getRightSharesLink());
				productJSON.put("rightSharesLinkColorText", reklamProduct.getRightSharesLinkColorText());
				productJSON.put("rightSharesLinkColorFone", reklamProduct.getRightSharesLinkColorFone());
				
				productJSON.put("pathToPicture", reklamProduct.getPathToPicture());
				productJSON.put("nameProduct", reklamProduct.getNameProduct());
				productJSON.put("priceProduct", reklamProduct.getPriceProduct());
				
				jsonArray.add(productJSON);
				
				Writer out = new PrintWriter(path, "UTF-8");
				out.write(jsonArray.toJSONString());
				out.flush();
				out.close();
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
	}
	
	public void deleteReklam(ReklamProduct reklamProduct){
		JSONParser parser = new JSONParser();
		try {
			
			JSONArray jsonArray = (JSONArray)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
			@SuppressWarnings("rawtypes")
			Iterator iter = jsonArray.iterator();
				
			while (iter.hasNext()){
				JSONObject jsonObject = (JSONObject) iter.next();
				if(jsonObject.get("id").equals(reklamProduct.getId()) && 
						jsonObject.get("type").equals(reklamProduct.getType())){
					iter.remove();
					break;
				}
			} 

			Writer out = new PrintWriter(path, "UTF-8");
			out.write(jsonArray.toJSONString());
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ParseException e1) {
			e1.printStackTrace();
		}		
	}
}
