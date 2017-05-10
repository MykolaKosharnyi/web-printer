package com.printmaster.nk.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -357378939455722167L;
	
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
	
	@Column(name="password")
	private String password;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	private boolean enabled;
	
	@Column(name="telephone")
	private String telephone;
	
	@Column(name="company")
	private String company;
	
	@Column(name="email")
	private String email;
	
	@Column(name="date_of_birth_bay")
	private Date dateOfBirthDay;
	
	@Column(name="time_registration")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeRegistration = new Date();
	
	@Transient
	private String passwordConfirm;
	
	@Column(name="role")
    private String role;
	
	@Column(name="nameUserPicture")
	private String nameUserPicture;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="subscription")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<String> subscription = new ArrayList<String>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="scopeOfActivities")
	private List<String> scopeOfActivities = new ArrayList<String>();
	
	public User(){}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getNameUserPicture() {
		return nameUserPicture;
	}

	public void setNameUserPicture(String nameUserPicture) {
		this.nameUserPicture = nameUserPicture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", telephone=" + telephone
				+ ", company=" + company + ", email=" + email + ", dateOfBirthDay=" + dateOfBirthDay
				+ ", timeRegistration=" + timeRegistration + "]";
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<String> getScopeOfActivities() {
		return scopeOfActivities;
	}

	public void setScopeOfActivities(List<String> scopeOfActivities) {
		this.scopeOfActivities = scopeOfActivities;
	}

	public List<String> getSubscription() {
		return subscription;
	}

	public void setSubscription(List<String> subscription) {
		this.subscription = subscription;
	}

}
