package com.printmaster.nk.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="comment")
public class Comment implements Serializable{	
	private static final long serialVersionUID = -357378939455722167L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="dateWriting")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateWriting = new Date();
	
	@Column(name="message", columnDefinition="TEXT")
	private String message;
	
	@Column(name="nameUser")
	private String nameUser;
	
	@Column(name="secondName")
	private String secondName;
	
	@Column(name="pathUserPicture")
	private String pathUserPicture;
	
	@Column(name="userId")
	private long userId;
	
	@Column(name="productType")
	private String productType;
	
	@Column(name="productId")
	private long productId;
	
	@Column(length = 40, columnDefinition = "varchar(40) default 'COMMENT'")
	@Enumerated(value = EnumType.STRING)
	private TypeComment typeComment = TypeComment.COMMENT;
	
	public static enum TypeComment{
		COMMENT, INACCURACY_IN_DESCRIPTION
	}
	
	public Comment(){}

	public TypeComment getTypeComment() {
		return typeComment;
	}

	public void setTypeComment(TypeComment typeComment) {
		this.typeComment = typeComment;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getPathUserPicture() {
		return pathUserPicture;
	}

	public void setPathUserPicture(String pathUserPicture) {
		this.pathUserPicture = pathUserPicture;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public Date getDateWriting() {
		return dateWriting;
	}

	public void setDateWriting(Date dateWriting) {
		this.dateWriting = dateWriting;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", dateWriting=" + dateWriting + ", message=" + message + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateWriting == null) ? 0 : dateWriting.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (dateWriting == null) {
			if (other.dateWriting != null)
				return false;
		} else if (!dateWriting.equals(other.dateWriting))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
