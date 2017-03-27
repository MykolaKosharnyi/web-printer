package com.printmaster.nk.model.entity;

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
	
	@Column(name="county")
	private String county;
	
	@Column(name="city")
	private String city;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	private boolean enabled;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="company")
	private String company;
	
	@Column(name="email", unique = true)
	private String email;
	
	@Column(name="email2")
	private String email2;
	
	@Column(name="email3")
	private String email3;
	
	@Column(name="date_of_birth_bay")
	private Date dateOfBirthDay;
	
	@Column(name="time_registration")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeRegistration = new Date();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="subscription")
	private List<String> subscription = new ArrayList<String>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="scopeOfActivities")
	private List<String> scopeOfActivities = new ArrayList<String>();
	
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
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

	public List<String> getSubscription() {
		return subscription;
	}

	public void setSubscription(List<String> subscription) {
		this.subscription = subscription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<String> getScopeOfActivities() {
		return scopeOfActivities;
	}

	public void setScopeOfActivities(List<String> scopeOfActivities) {
		this.scopeOfActivities = scopeOfActivities;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}
	
}
