package com.printmaster.nk.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="order_printer")
public class OrderPrinter  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7410894288329287520L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="printer_id")
	private Printer printer;
	
	@Column(name="time_order")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timeOrder;
	
	@Column(name="amount")
	private int amount;
	
	public OrderPrinter() {
		super();
	}


	public int getId() {
		return id;
	}


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
