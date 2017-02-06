package com.printmaster.nk.model.entity;

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
@Table(name="user_add_by_admin")
public class UserAddByAdmin implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	private boolean enabled;
	
	@Column(name="telephone")
	private int telephone;
	
	@Column(name="company")
	private String company;
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="date_of_birth_bay")
	private Date dateOfBirthDay;
	
	@Column(name="time_registration")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeRegistration = new Date();
	
	@Column(name="subscription")
	private String[] subscription;
	
	public UserAddByAdmin(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirthDay() {
		return dateOfBirthDay;
	}

	public void setDateOfBirthDay(Date dateOfBirthDay) {
		this.dateOfBirthDay = dateOfBirthDay;
	}

	public Date getTimeRegistration() {
		return timeRegistration;
	}

	public void setTimeRegistration(Date timeRegistration) {
		this.timeRegistration = timeRegistration;
	}

	public String[] getSubscription() {
		return subscription;
	}

	public void setSubscription(String[] subscription) {
		this.subscription = subscription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
