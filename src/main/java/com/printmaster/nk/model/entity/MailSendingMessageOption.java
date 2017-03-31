package com.printmaster.nk.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MailSendingMessageOption implements Serializable{
	private static final long serialVersionUID = 3031695775597440046L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name="showOnSite")
	private boolean showOnSite;
	
	@Column(name="text", columnDefinition="TEXT")
	private String text;
	
	@Column(name="dateLastChanging")
	private Date dateLastChanging;
	
	@Column(name="optionType")
	private OptionType optionType;
	
	public static enum OptionType{
		HEADER, FOOTER
	}
	
	public MailSendingMessageOption(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isShowOnSite() {
		return showOnSite;
	}

	public void setShowOnSite(boolean showOnSite) {
		this.showOnSite = showOnSite;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDateLastChanging() {
		return dateLastChanging;
	}

	public void setDateLastChanging(Date dateLastChanging) {
		this.dateLastChanging = dateLastChanging;
	}

	public OptionType getOptionType() {
		return optionType;
	}

	public void setOptionType(OptionType optionType) {
		this.optionType = optionType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
