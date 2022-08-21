package com.mykoshar.shop.api.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="mail_message")
public class MailSendingMessage implements Serializable{
	private static final long serialVersionUID = 3031695775597440046L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="title", length = 350)
	private String title;
	
	@Column(name="message", columnDefinition="TEXT")
	private String message;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="subscription")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<String> subscription = new ArrayList<String>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="scopeOfActivities")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<String> scopeOfActivities = new ArrayList<String>();
	
	@Column(name="dateCreation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation = new Date();
	
	@Column(name="dateSending")
	private Date dateSending;
	
	@Column(name="dateLastChanging")
	private Date dateLastChanging;
	
	@Column(name="status")
	private StatusOfSending status;
	
	public static enum StatusOfSending{
		SENDED, WAITING, CANCELED, MODIFICATION_PROCESS
	}
	
	@Column(name="headerOption", nullable = false, columnDefinition = "int default 0")
	private int headerOption = 0;
	
	@Column(name="footerOption", nullable = false, columnDefinition = "int default 0")
	private int footerOption = 0;
	
	public MailSendingMessage(){}

	public int getHeaderOption() {
		return headerOption;
	}

	public void setHeaderOption(int headerOption) {
		this.headerOption = headerOption;
	}

	public int getFooterOption() {
		return footerOption;
	}

	public void setFooterOption(int footerOption) {
		this.footerOption = footerOption;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getScopeOfActivities() {
		return scopeOfActivities;
	}

	public void setScopeOfActivities(List<String> scopeOfActivities) {
		this.scopeOfActivities = scopeOfActivities;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateSending() {
		return dateSending;
	}

	public void setDateSending(Date dateSending) {
		this.dateSending = dateSending;
	}

	public Date getDateLastChanging() {
		return dateLastChanging;
	}

	public void setDateLastChanging(Date dateLastChanging) {
		this.dateLastChanging = dateLastChanging;
	}

	public StatusOfSending getStatus() {
		return status;
	}

	public void setStatus(StatusOfSending status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getSubscription() {
		return subscription;
	}

	public void setSubscription(List<String> subscription) {
		this.subscription = subscription;
	}

	@Override
	public String toString() {
		return "MailSendingMessage [id=" + id + ", title=" + title 
				+ ", dateCreation=" + dateCreation + ", dateSending=" + dateSending + ", dateLastChanging="
				+ dateLastChanging + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateCreation == null) ? 0 : dateCreation.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MailSendingMessage other = (MailSendingMessage) obj;
		if (dateCreation == null) {
			if (other.dateCreation != null)
				return false;
		} else if (!dateCreation.equals(other.dateCreation))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
