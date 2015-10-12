package com.nk.printmaster.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -357378939455722167L;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="second_name")
	private String secondName;
	
	@Column(name="phone_number")
	private int phoneNumber;
	
	@Column(name="company")
	private String company;
	
	@Column(name="email")
	private String email;
	
	@OneToMany(mappedBy="user")
	private Set<OrderPrinter> orderPrinters = new HashSet<OrderPrinter>();
	
	public User(){
		super();
	}

	public User(int id) {
		super(id);
	}

	/**
	 * @return the orderPrinters
	 */
	public Set<OrderPrinter> getOrderPrinters() {
		return orderPrinters;
	}

	/**
	 * @param orderPrinters the orderPrinters to set
	 */
	public void setOrderPrinters(Set<OrderPrinter> orderPrinters) {
		this.orderPrinters = orderPrinters;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the secondName
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * @param secondName the secondName to set
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the company
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * @param company the company to set
	 */
	public void setCompany(String company) {
		this.company = company;
	}
}
