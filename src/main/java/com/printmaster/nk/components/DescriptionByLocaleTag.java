package com.printmaster.nk.components;

import javax.servlet.jsp.tagext.*;

import org.json.simple.JSONObject;

import javax.servlet.jsp.*;
import java.io.*;

public class DescriptionByLocaleTag extends SimpleTagSupport {
	private String locate;
	private JSONObject description;
	
	public void setLocate(String locate) {
		this.locate = locate;
	}

	public void setDescription(JSONObject description) {
		this.description = description;
	}

	StringWriter sw = new StringWriter();

	public void doTag() throws JspException, IOException {
		String result = null;
		
		

		/* Use message from attribute */
		JspWriter out = getJspContext().getOut();
		out.println(result);

	}
}