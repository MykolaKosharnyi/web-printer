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

	private JSONObject obj = null;
	
	private String path = "/var/www/localhost" + File.separator + "left_reklam.json";
	
	
	@SuppressWarnings("unchecked")
	public void addReklam(ReklamProduct reklamProduct){
		JSONParser parser = new JSONParser();
			try {
				obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
				
				JSONArray jsonArray = null;
				if( obj.get("reklam") != null ){
					jsonArray = (JSONArray) obj.get("reklam");
					obj.remove("reklam");
				} else{
					jsonArray = new JSONArray();
				}
				
				Iterator iter = jsonArray.iterator();
				
				while (iter.hasNext()){
					JSONObject jsonObject = (JSONObject) iter.next();
					if(jsonObject.get("partNumber").equals(reklamProduct.getPartNumber()) && 
							jsonObject.get("nameProduct").equals(reklamProduct.getNameProduct())){
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
				obj.put("reklam", jsonArray);
				
				Writer out = new PrintWriter(path, "UTF-8");
				out.write(obj.toJSONString());
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
	
	@SuppressWarnings("unchecked")
	public void deleteReklam(ReklamProduct reklamProduct){
		JSONParser parser = new JSONParser();
		try {
			obj = (JSONObject)parser.parse(new InputStreamReader(new FileInputStream(path), "UTF-8"));
			
			if( obj.get("reklam") != null ){
				JSONArray jsonArray = (JSONArray) obj.get("reklam");
				obj.remove("reklam");
				
				Iterator iter = jsonArray.iterator();
				
				while (iter.hasNext()){
					JSONObject jsonObject = (JSONObject) iter.next();
					if(jsonObject.get("partNumber").equals(reklamProduct.getPartNumber()) && 
							jsonObject.get("nameProduct").equals(reklamProduct.getNameProduct())){
						iter.remove();
						break;
					}
				}
				obj.put("reklam", jsonArray);
			} 

			Writer out = new PrintWriter(path, "UTF-8");
			out.write(obj.toJSONString());
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
