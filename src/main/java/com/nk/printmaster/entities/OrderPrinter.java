package com.nk.printmaster.entities;

import java.io.Serializable;
import java.util.Date;

public class OrderPrinter implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410894288329287520L;
	
	private int id;
	private User user;
	private Printer printer;
	private Date timeOrder;
	private int amount;
	
	public OrderPrinter() {
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the printer
	 */
	public Printer getPrinter() {
		return printer;
	}

	/**
	 * @param printer the printer to set
	 */
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	/**
	 * @return the timeOrder
	 */
	public Date getTimeOrder() {
		return timeOrder;
	}

	/**
	 * @param timeOrder the timeOrder to set
	 */
	public void setTimeOrder(Date timeOrder) {
		this.timeOrder = timeOrder;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
