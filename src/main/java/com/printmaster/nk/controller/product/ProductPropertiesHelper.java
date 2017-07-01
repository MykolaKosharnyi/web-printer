package com.printmaster.nk.controller.product;

public class ProductPropertiesHelper {
	private String title;
	private String headerAdd;
	private String wrongMessage;
	private String buttonAdd;
	private String headerChange;
	
	public ProductPropertiesHelper(){}
	
	public ProductPropertiesHelper(String title, String headerAdd, String wrongMessage, String buttonAdd,
			String headerChange) {
		this.title = title;
		this.headerAdd = headerAdd;
		this.wrongMessage = wrongMessage;
		this.buttonAdd = buttonAdd;
		this.headerChange = headerChange;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeaderAdd() {
		return headerAdd;
	}
	public void setHeaderAdd(String headerAdd) {
		this.headerAdd = headerAdd;
	}
	public String getWrongMessage() {
		return wrongMessage;
	}
	public void setWrongMessage(String wrongMessage) {
		this.wrongMessage = wrongMessage;
	}
	public String getButtonAdd() {
		return buttonAdd;
	}
	public void setButtonAdd(String buttonAdd) {
		this.buttonAdd = buttonAdd;
	}
	public String getHeaderChange() {
		return headerChange;
	}
	public void setHeaderChange(String headerChange) {
		this.headerChange = headerChange;
	}
	
}
