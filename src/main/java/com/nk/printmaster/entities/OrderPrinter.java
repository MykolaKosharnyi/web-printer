package com.nk.printmaster.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_printer")
public class OrderPrinter extends Model{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410894288329287520L;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="printer_id")
	private Printer printer;
	
	@Column(name="time_order")
	private Date timeOrder;
	
	@Column(name="amount")
	private int amount;
	
	public OrderPrinter() {
		super();
	}

	public OrderPrinter(int id) {
		super(id);
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
