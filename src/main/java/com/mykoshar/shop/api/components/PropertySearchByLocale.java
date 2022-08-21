package com.mykoshar.shop.api.components;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PropertySearchByLocale extends SimpleTagSupport {
	private String nameOfAttribyte;
	private JSONArray properties;
		
	public void setNameOfAttribyte(String nameOfAttribyte) {
		this.nameOfAttribyte = nameOfAttribyte;
	}

	public void setProperties(JSONArray properties) {
		this.properties = properties;
	}

	StringWriter sw = new StringWriter();

	@SuppressWarnings("rawtypes")
	public void doTag() throws JspException, IOException {
		
		StringBuilder result = new StringBuilder();
		String locate = getJspContext().findAttribute("localeCode").toString();

		int counter = 1;
		for (Iterator iterator = properties.iterator(); iterator.hasNext();) {
			JSONObject nextObject = (JSONObject) iterator.next();

			result.append("<li><input id='")
				.append(nameOfAttribyte)
				.append(counter)
				.append("' name='")
				.append(nameOfAttribyte)
				.append("' value='")
				.append(nextObject.get("ru").toString())
				.append("' type='checkbox'><label for='")
				.append(nameOfAttribyte)
				.append(counter)
				.append("'>")
				.append(getOptionByLocale(locate, nextObject))
				.append("</label></li>");

			counter++;
		}

		JspWriter out = getJspContext().getOut();
		out.println(result.toString());

	}
	
	private String getOptionByLocale(String locale, JSONObject object){
		if(locale.equals("en") && !object.get("en").toString().isEmpty()){
			return object.get("en").toString();
		} else {
			return object.get("ru").toString();
		}
	}
}
