package com.printmaster.nk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -357378939455722167L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastname;
	
	@Column(name="password")
	private String password;
	
	@Column(name="telephone")
	private int telephone;
	
	@Column(name="company")
	private String company;
	
	@Column(name="email")
	private String email;
	
	@Column(name="date_of_birth_bay")
	private Date dateOfBirthDay;
	
	@Column(name="time_registration")
	private Date timeRegistration;
	
	public User(){
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
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

}
