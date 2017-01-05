package com.printmaster.nk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	private static final long serialVersionUID = -357378939455722167L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="username", unique = true)
	private String username;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastname;
	
	@Column(name="password")
	private String password;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	private boolean enabled;
	
	@Column(name="telephone")
	private int telephone;
	
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
	
//	@OneToOne(cascade=CascadeType.ALL)
//    @JoinTable(name="user_roles",
//        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
//        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
//    )
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_comment", 
		joinColumns = {
				@JoinColumn(name = "USER_ID", nullable = false) },
		inverseJoinColumns = { 
				@JoinColumn(name = "COMMENT_ID", nullable = false) })
	private Set<Comment> comments = new HashSet<Comment>(0);
	
	@Column(name="role")
    private String role;
	
	@Column(name="nameUserPicture")
	private String nameUserPicture;
	
	public User(){
	}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
