package com.printmaster.nk.custom_tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AdminRadioTag extends SimpleTagSupport {
	private String nameOfAttribyte;
	private String productValue;
	private JSONArray properties;
		
	public void setNameOfAttribyte(String nameOfAttribyte) {
		this.nameOfAttribyte = nameOfAttribyte;
	}

	public void setProperties(JSONArray properties) {
		this.properties = properties;
	}

	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	StringWriter sw = new StringWriter();

	@SuppressWarnings("rawtypes")
	public void doTag() throws JspException, IOException {
		
		StringBuilder result = new StringBuilder();

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
				.append("' type='radio'");
			
			if(value.equals(productValue)){
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
