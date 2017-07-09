package com.printmaster.nk.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="user_add_by_admin")
public class UserAddByAdmin extends AbstractUser {
	private static final long serialVersionUID = -2962121413734525491L;
	
	@Column(name="email2")
	private String email2;
	
	@Column(name="email3")
	private String email3;
	
	@Column(length = 40, columnDefinition = "varchar(40) default 'NOT_CHANGED'")
	@Enumerated(value = EnumType.STRING)
	private StatusSubscription statusOfSubscription = StatusSubscription.NOT_CHANGED;
	
	public static enum StatusSubscription{
		NOT_CHANGED/*Не изменялся*/, ADDED_SUBSCRIPTIONS/*Добавил подписки*/,
		REMOVED_SOME_SUBSCRIPTIONS/*Удалил некоторые подписки*/, COMPLETELY_UNSUBSCRIBED/*Полностью отписался*/
	}

	public UserAddByAdmin(){}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public StatusSubscription getStatusOfSubscription() {
		return statusOfSubscription;
	}

	public void setStatusOfSubscription(StatusSubscription statusOfSubscription) {
		this.statusOfSubscription = statusOfSubscription;
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
