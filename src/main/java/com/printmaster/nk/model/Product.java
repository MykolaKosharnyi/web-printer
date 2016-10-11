package com.printmaster.nk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

public abstract class Product implements Serializable{
	
	private static final long serialVersionUID = 3031695775597440046L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	protected Long id;
	
	@Column(name="part_number")
	protected String partNumber;
	
	@NotEmpty(message = "Please enter name of product.")
	@Column(name="name")
	protected String name;
	
	@Column(name="prise")
	protected double prise; 
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	protected boolean showOnSite = true;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	protected boolean showOnHomePage = true;
	
	@Column(nullable = false, columnDefinition = "bit default 0")
	protected boolean showOnLeftSide = false;
	
	@Column(name="top",nullable = false, columnDefinition = "bit default 0")
	private boolean top;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="path_pictures")
	private List<String> pathPictures = new ArrayList<String>();
	
	@Column(name="description", columnDefinition="TEXT")
	protected String description;
	
	@Column(name="description_eng", columnDefinition="TEXT")
	protected String descriptionEng;
	
	@Column(name="service_information", columnDefinition="TEXT")
	protected String serviceInformation;
	
	public Product(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrise() {
		return prise;
	}

	public void setPrise(double prise) {
		this.prise = prise;
	}

	public boolean isShowOnSite() {
		return showOnSite;
	}

	public void setShowOnSite(boolean showOnSite) {
		this.showOnSite = showOnSite;
	}

	public boolean isShowOnHomePage() {
		return showOnHomePage;
	}

	public void setShowOnHomePage(boolean showOnHomePage) {
		this.showOnHomePage = showOnHomePage;
	}

	public boolean isShowOnLeftSide() {
		return showOnLeftSide;
	}

	public void setShowOnLeftSide(boolean showOnLeftSide) {
		this.showOnLeftSide = showOnLeftSide;
	}

	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public List<String> getPathPictures() {
		return pathPictures;
	}

	public void setPathPictures(List<String> pathPictures) {
		this.pathPictures = pathPictures;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescriptionEng() {
		return descriptionEng;
	}

	public void setDescriptionEng(String descriptionEng) {
		this.descriptionEng = descriptionEng;
	}

	public String getServiceInformation() {
		return serviceInformation;
	}

	public void setServiceInformation(String serviceInformation) {
		this.serviceInformation = serviceInformation;
	}
	
}
