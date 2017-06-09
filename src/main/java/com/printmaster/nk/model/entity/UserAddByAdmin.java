package com.printmaster.nk.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_add_by_admin")
public class UserAddByAdmin extends AbstractUser {
	private static final long serialVersionUID = -2962121413734525491L;
	
	@Column(name="email2")
	private String email2;
	
	@Column(name="email3")
	private String email3;
	
	public UserAddByAdmin(){}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
