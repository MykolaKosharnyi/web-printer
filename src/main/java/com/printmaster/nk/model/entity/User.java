package com.printmaster.nk.model.entity;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User extends AbstractUser{
	private static final long serialVersionUID = 2779875230120306603L;

	@Column(name="password")
	private String password;
	
	@Transient
	private String passwordConfirm;
	
	@Column(name="role")
    private String role;
	
	@Column(name="nameUserPicture")
	private String nameUserPicture;
	
	public User(){}

	public String getNameUserPicture() {
		return nameUserPicture;
	}

	public void setNameUserPicture(String nameUserPicture) {
		this.nameUserPicture = nameUserPicture;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
