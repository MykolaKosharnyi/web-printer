package com.printmaster.nk.custom_tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AdminCheckboxTag extends SimpleTagSupport {
	private String nameOfAttribyte;
	private String[] productValues;
	private JSONArray properties;
		
	public void setNameOfAttribyte(String nameOfAttribyte) {
		this.nameOfAttribyte = nameOfAttribyte;
	}

	public void setProperties(JSONArray properties) {
		this.properties = properties;
	}

	public void setProductValues(String[] productValues) {
		this.productValues = productValues;
	}

	StringWriter sw = new StringWriter();

	@SuppressWarnings("rawtypes")
	public void doTag() throws JspException, IOException {
		
		StringBuilder result = new StringBuilder();
		List<String> listPV = Arrays.asList(productValues);

		int counter = 1;
		for (Iterator iterator = properties.iterator(); iterator.hasNext();) {
			JSONObject nextObject = (JSONObject) iterator.next();
			
			String value = nextObject.get("ru").toString();

			result.append("<li><input id='")
				.append(nameOfAttribyte)
				.append(counter)
				.append("' name='")
				.append(nameOfAttribyte)
				.append("' value='")
				.append(value)
				.append("' type='checkbox'");
			
			if(listPV.contains(value)){
				result.append(" checked='checked'");
			}
				
			result.append("><label for='")
				.append(nameOfAttribyte)
				.append(counter)
				.append("'>")
				.append(value)
				.append("</label></li>");

			counter++;
		}

		JspWriter out = getJspContext().getOut();
		out.println(result.toString());
	}
}
