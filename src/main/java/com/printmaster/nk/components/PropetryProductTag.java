package com.printmaster.nk.components;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class PropetryProductTag extends SimpleTagSupport {
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
		
		for(Iterator iterator = properties.iterator();iterator.hasNext();){
			JSONObject nextObject = (JSONObject) iterator.next();
			if(nameOfAttribyte.equals(nextObject.get("ru").toString())){
				
			}
		}
		
		
		


		JspWriter out = getJspContext().getOut();
		out.println("");

	}
}
