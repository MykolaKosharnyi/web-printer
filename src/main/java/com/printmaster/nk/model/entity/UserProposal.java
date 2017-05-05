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
@Table(name="users_proposal")
public class UserProposal implements Serializable{
	
	private static final long serialVersionUID = 3031695775597440046L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(nullable = false, columnDefinition = "bit default 0")
	private boolean logined = false;
	
	@Column(name="name")
	private String name;
	
	@Column(name="phoneNumber")
	private String phoneNumber;
	
	@Column(name="email")
	private String email;
	
	@Column(name="idUser", nullable = false, columnDefinition = "bigint default 0")
	private long idUser;
	
	@Column(name="typeProduct")
	private String typeProduct;
		
	@Column(name="idProduct")
	private long idProduct;
	
	//price for product
	@Column(name="price")
	private String price;
	
	@Column(name="description")
	private String description;
	
	@Column(name="typeProposal")
	private TypeProposal typeProposal;
	
	@Column(name="dateCreation")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreation = new Date();
	
	public static enum TypeProposal{
		SPECIFY/*уточняйте*/, SUGGEST_YOUR_PRICE/*Предложить свою цену*/
	}
	
	public UserProposal(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isLogined() {
		return logined;
	}

	public void setLogined(boolean logined) {
		this.logined = logined;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getIdUser() {
		return idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(long idProduct) {
		this.idProduct = idProduct;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TypeProposal getTypeProposal() {
		return typeProposal;
	}

	public void setTypeProposal(TypeProposal typeProposal) {
		this.typeProposal = typeProposal;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
