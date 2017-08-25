package com.printmaster.nk.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.NotEmpty;

@MappedSuperclass
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
	
	@Column(name="buyOnlineCoefficient", columnDefinition="Decimal(10,2) default '0.90'")
	protected double buyOnlineCoefficient;
	
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
	
	@Column(name="left_shares_link")
	protected String leftSharesLink;
	
	@Column(name="left_shares_link_color_text")
	protected String leftSharesLinkColorText = "#000000";
	
	@Column(name="left_shares_link_color_fone")
	protected String leftSharesLinkColorFone = "#006080";
	
	@Column(name="right_shares_link")
	protected String rightSharesLink;
	
	@Column(name="right_shares_link_color_text")
	protected String rightSharesLinkColorText = "#000000";
	
	@Column(name="right_shares_link_color_fone")
	protected String rightSharesLinkColorFone = "#006080";	
	
	@Column(name="dateLastChanging")
	private Date dateLastChanging;
	
	@Column(name="pathLeftPictureAction")
	private String pathLeftPictureAction;
	
	@Column(name="pathRightPictureAction")
	private String pathRightPictureAction;
	
	@Column(name="engNameProduct")
	private String engNameProduct;
	
	public Product(){}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getBuyOnlineCoefficient() {
		return buyOnlineCoefficient;
	}

	public void setBuyOnlineCoefficient(double buyOnlineCoefficient) {
		this.buyOnlineCoefficient = buyOnlineCoefficient;
	}

	public String getPathLeftPictureAction() {
		return pathLeftPictureAction;
	}

	public void setPathLeftPictureAction(String pathLeftPictureAction) {
		this.pathLeftPictureAction = pathLeftPictureAction;
	}

	public String getPathRightPictureAction() {
		return pathRightPictureAction;
	}

	public void setPathRightPictureAction(String pathRightPictureAction) {
		this.pathRightPictureAction = pathRightPictureAction;
	}

	public String getEngNameProduct() {
		return engNameProduct;
	}

	public void setEngNameProduct(String engNameProduct) {
		this.engNameProduct = engNameProduct;
	}

	public Date getDateLastChanging() {
		return dateLastChanging;
	}

	public void setDateLastChanging(Date dateLastChanging) {
		this.dateLastChanging = dateLastChanging;
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

	public String getLeftSharesLink() {
		return leftSharesLink;
	}

	public void setLeftSharesLink(String leftSharesLink) {
		this.leftSharesLink = leftSharesLink;
	}

	public String getLeftSharesLinkColorText() {
		return leftSharesLinkColorText;
	}

	public void setLeftSharesLinkColorText(String leftSharesLinkColorText) {
		this.leftSharesLinkColorText = leftSharesLinkColorText;
	}

	public String getLeftSharesLinkColorFone() {
		return leftSharesLinkColorFone;
	}

	public void setLeftSharesLinkColorFone(String leftSharesLinkColorFone) {
		this.leftSharesLinkColorFone = leftSharesLinkColorFone;
	}

	public String getRightSharesLink() {
		return rightSharesLink;
	}

	public void setRightSharesLink(String rightSharesLink) {
		this.rightSharesLink = rightSharesLink;
	}

	public String getRightSharesLinkColorText() {
		return rightSharesLinkColorText;
	}

	public void setRightSharesLinkColorText(String rightSharesLinkColorText) {
		this.rightSharesLinkColorText = rightSharesLinkColorText;
	}

	public String getRightSharesLinkColorFone() {
		return rightSharesLinkColorFone;
	}

	public void setRightSharesLinkColorFone(String rightSharesLinkColorFone) {
		this.rightSharesLinkColorFone = rightSharesLinkColorFone;
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
