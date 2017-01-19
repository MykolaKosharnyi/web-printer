package com.printmaster.nk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Column(name="subscription")
	private String[] subscription;
	
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
		SENDED, WAITING, CANCELED
	}
	
	public MailSendingMessage(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String[] getSubscription() {
		return subscription;
	}

	public void setSubscription(String[] subscription) {
		this.subscription = subscription;
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
	
}
