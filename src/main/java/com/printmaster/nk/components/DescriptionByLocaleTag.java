package com.printmaster.nk.components;

import javax.servlet.jsp.tagext.*;

import org.json.simple.JSONObject;

import javax.servlet.jsp.*;
import java.io.*;

public class DescriptionByLocaleTag extends SimpleTagSupport {
	private JSONObject description;

	public void setDescription(JSONObject description) {
		this.description = description;
	}

	StringWriter sw = new StringWriter();

	public void doTag() throws JspException, IOException {
		String result = null;
		
		String locate = getJspContext().findAttribute("localeCode").toString();
		
		if(locate.equals("en") && !description.get("en").toString().isEmpty()){
			result = description.get("en").toString();
		} else {
			result = description.get("ru").toString();
		}

		JspWriter out = getJspContext().getOut();
		out.println(result);

	}
}