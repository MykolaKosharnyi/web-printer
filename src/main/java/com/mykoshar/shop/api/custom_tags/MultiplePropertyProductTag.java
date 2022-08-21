package com.mykoshar.shop.api.custom_tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MultiplePropertyProductTag extends SimpleTagSupport {
	private String[] productValues;
	private JSONArray properties;

	public void setProductValues(String[] productValues) {
		this.productValues = productValues;
	}

	public void setProperties(JSONArray properties) {
		this.properties = properties;
	}

	StringWriter sw = new StringWriter();

	@SuppressWarnings("rawtypes")
	public void doTag() throws JspException, IOException {
		
		StringBuilder result = new StringBuilder();
		String locale = getJspContext().findAttribute("localeCode").toString();
		
		if(locale.equals("en")){
			for(int k = 0; k < productValues.length; k++){
				for(Iterator iterator = properties.iterator();iterator.hasNext();){
					JSONObject nextObject = (JSONObject) iterator.next();
					
					if(productValues[k].equals(nextObject.get("ru").toString())){
						result.append(nextObject.get("en").toString());
					}
				}
				
				if(k < productValues.length-1){
					result.append(", ");
				}
			}
			
			
		} else {
			for(int k = 0; k < productValues.length; k++){
				result.append(productValues[k]);
				
				if(k < productValues.length-1){
					result.append(", ");
				}
			}
		}

		JspWriter out = getJspContext().getOut();
		out.println(result.toString());

	}
}
