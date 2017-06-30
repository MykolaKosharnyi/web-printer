package com.printmaster.nk.custom_tags;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Iterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class SinglePropertyProductTag extends SimpleTagSupport {
	private String productValue;
	private JSONArray properties;

	public void setProductValue(String productValue) {
		this.productValue = productValue;
	}

	public void setProperties(JSONArray properties) {
		this.properties = properties;
	}

	StringWriter sw = new StringWriter();

	@SuppressWarnings("rawtypes")
	public void doTag() throws JspException, IOException {
		
		String result = null;
		String locale = getJspContext().findAttribute("localeCode").toString();
		
		if(locale.equals("en")){
			for(Iterator iterator = properties.iterator();iterator.hasNext();){
				JSONObject nextObject = (JSONObject) iterator.next();
				if(productValue.equals(nextObject.get("ru").toString())){
					result = nextObject.get("en").toString();
					break;
				}
			}
		} else {
			result = productValue;
		}

		JspWriter out = getJspContext().getOut();
		out.println(result);

	}
}
