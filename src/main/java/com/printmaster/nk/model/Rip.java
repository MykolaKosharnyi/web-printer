package com.printmaster.nk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="rip")
public class Rip implements Serializable {
	
private static final long serialVersionUID = 3031695775597440046L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="part_number")
	private String partNumber;
	
	@NotEmpty(message = "Please enter name of product.")
	@Column(name="name")
	private String name;
	
	@Column(name="prise")
	private double prise; 

	@NotEmpty
	@Column(name="typeEquipment")
	private String typeEquipment;//Тип оборудования
	
	@NotEmpty
	@Column(name="softwareMaker")
	private String softwareMaker;//Производитель ПО
	
	@NotEmpty
	@Column(name="softwareClass")
	private String softwareClass;//Класс ПО
	
	@Column(name="softwareVersion", length = 10)
	private String softwareVersion;//Версия ПО
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="path_pictures")
	private List<String> pathPictures = new ArrayList<String>();
	
	@Column(name="left_shares_link")
	private String leftSharesLink;
	
	@Column(name="left_shares_link_color_text")
	private String leftSharesLinkColorText = "#000000";
	
	@Column(name="left_shares_link_color_fone")
	private String leftSharesLinkColorFone = "#006080";
	
	@Column(name="right_shares_link")
	private String rightSharesLink;
	
	@Column(name="right_shares_link_color_text")
	private String rightSharesLinkColorText = "#000000";
	
	@Column(name="right_shares_link_color_fone")
	private String rightSharesLinkColorFone = "#006080";
	
	@Column(name="time_shares")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd.MM.yyyy")
	private Date timeShares;
	
	@Column(name="timeSharesText", columnDefinition="TEXT")
	protected String timeSharesText;
	
	@Column(name="description", columnDefinition="TEXT")
	private String description;
	
	@Column(name="description_eng", columnDefinition="TEXT")
	private String descriptionEng;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	private boolean showOnSite = true;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	private boolean showOnHomePage = true;
	
	@Column(nullable = false, columnDefinition = "bit default 0")
	private boolean showOnLeftSide = false;
	
	@Column(name="service_information", columnDefinition="TEXT")
	private String serviceInformation;
	
	@Column(name="optionInstallation", columnDefinition="Decimal(10,2) default '0.00'")
	protected double optionInstallation;
	
	@Size(max = 50)
	@Column(name="descriptionInstallation")
	protected String descriptionOptionInstallation;
	
	@Column(name="optionVAT", columnDefinition="Decimal(10,2) default '1.20'")
	protected double optionVAT;
	
	@Size(max = 50)
	@Column(name="descriptionVAT")
	protected String descriptionOptionVAT;
	
	@Column(name="nameAddedOption")
	protected String nameAddedOption;
	
	@Column(name="priceAddedOption", columnDefinition="Decimal(10,2) default '0.00'")
	protected double priceAddedOption;
	
	@Size(max = 50)
	@Column(name="descriptionAddedOption")
	protected String descriptionOptionAddedOption;
	
	@Column(name="nameAddedOption2")
	protected String nameAddedOption2;
	
	@Column(name="priceAddedOption2", columnDefinition="Decimal(10,2) default '0.00'")
	protected double priceAddedOption2;
	
	@Size(max = 50)
	@Column(name="descriptionAddedOption2")
	protected String descriptionOptionAddedOption2;
	
	@Column(name="nameAddedOption3")
	protected String nameAddedOption3;
	
	@Column(name="priceAddedOption3", columnDefinition="Decimal(10,2) default '0.00'")
	protected double priceAddedOption3;
	
	@Size(max = 50)
	@Column(name="descriptionAddedOption3")
	protected String descriptionOptionAddedOption3;
	
	//Option for delivery	
	@Column(name="deliveryWidth", columnDefinition="Decimal(10,2) default '0.00'")
	protected double deliveryWidth;
					
	@Column(name="deliveryHeight", columnDefinition="Decimal(10,2) default '0.00'")
	protected double deliveryHeight;
					
	@Column(name="deliveryDepth", columnDefinition="Decimal(10,2) default '0.00'")
	protected double deliveryDepth;	
			
	@Column(name="deliveryWeight", columnDefinition="Decimal(10,2) default '0.00'")
	protected double deliveryWeight;
			
	//on Ukraine		
	@Column(name="ukraineDeliveryPriceSize", nullable = false, columnDefinition = "bit default 0")
	protected boolean ukraineDeliveryPriceSize;
					
	@Column(name="ukraineDeliveryPriceWeight", nullable = false, columnDefinition = "bit default 0")
	protected boolean ukraineDeliveryPriceWeight;
			
	//on Kyiv
	@Column(name="kyivDeliveryPriceSize", nullable = false, columnDefinition = "bit default 0")
	protected boolean kyivDeliveryPriceSize;
				
	@Column(name="kyivDeliveryPriceWeight", nullable = false, columnDefinition = "bit default 0")
	protected boolean kyivDeliveryPriceWeight;
	
	public Rip(){}
	
	public double getDeliveryWidth() {
		return deliveryWidth;
	}

	public void setDeliveryWidth(double deliveryWidth) {
		this.deliveryWidth = deliveryWidth;
	}

	public double getDeliveryHeight() {
		return deliveryHeight;
	}

	public void setDeliveryHeight(double deliveryHeight) {
		this.deliveryHeight = deliveryHeight;
	}

	public double getDeliveryDepth() {
		return deliveryDepth;
	}

	public void setDeliveryDepth(double deliveryDepth) {
		this.deliveryDepth = deliveryDepth;
	}

	public double getDeliveryWeight() {
		return deliveryWeight;
	}

	public void setDeliveryWeight(double deliveryWeight) {
		this.deliveryWeight = deliveryWeight;
	}

	public boolean isUkraineDeliveryPriceSize() {
		return ukraineDeliveryPriceSize;
	}

	public void setUkraineDeliveryPriceSize(boolean ukraineDeliveryPriceSize) {
		this.ukraineDeliveryPriceSize = ukraineDeliveryPriceSize;
	}

	public boolean isUkraineDeliveryPriceWeight() {
		return ukraineDeliveryPriceWeight;
	}

	public void setUkraineDeliveryPriceWeight(boolean ukraineDeliveryPriceWeight) {
		this.ukraineDeliveryPriceWeight = ukraineDeliveryPriceWeight;
	}

	public boolean isKyivDeliveryPriceSize() {
		return kyivDeliveryPriceSize;
	}

	public void setKyivDeliveryPriceSize(boolean kyivDeliveryPriceSize) {
		this.kyivDeliveryPriceSize = kyivDeliveryPriceSize;
	}

	public boolean isKyivDeliveryPriceWeight() {
		return kyivDeliveryPriceWeight;
	}

	public void setKyivDeliveryPriceWeight(boolean kyivDeliveryPriceWeight) {
		this.kyivDeliveryPriceWeight = kyivDeliveryPriceWeight;
	}

	public double getOptionInstallation() {
		return optionInstallation;
	}

	public void setOptionInstallation(double optionInstallation) {
		this.optionInstallation = optionInstallation;
	}

	public String getDescriptionOptionInstallation() {
		return descriptionOptionInstallation;
	}

	public void setDescriptionOptionInstallation(String descriptionOptionInstallation) {
		this.descriptionOptionInstallation = descriptionOptionInstallation;
	}

	public double getOptionVAT() {
		return optionVAT;
	}

	public void setOptionVAT(double optionVAT) {
		this.optionVAT = optionVAT;
	}

	public String getDescriptionOptionVAT() {
		return descriptionOptionVAT;
	}

	public void setDescriptionOptionVAT(String descriptionOptionVAT) {
		this.descriptionOptionVAT = descriptionOptionVAT;
	}

	public String getNameAddedOption() {
		return nameAddedOption;
	}

	public void setNameAddedOption(String nameAddedOption) {
		this.nameAddedOption = nameAddedOption;
	}

	public double getPriceAddedOption() {
		return priceAddedOption;
	}

	public void setPriceAddedOption(double priceAddedOption) {
		this.priceAddedOption = priceAddedOption;
	}

	public String getDescriptionOptionAddedOption() {
		return descriptionOptionAddedOption;
	}

	public void setDescriptionOptionAddedOption(String descriptionOptionAddedOption) {
		this.descriptionOptionAddedOption = descriptionOptionAddedOption;
	}

	public String getNameAddedOption2() {
		return nameAddedOption2;
	}

	public void setNameAddedOption2(String nameAddedOption2) {
		this.nameAddedOption2 = nameAddedOption2;
	}

	public double getPriceAddedOption2() {
		return priceAddedOption2;
	}

	public void setPriceAddedOption2(double priceAddedOption2) {
		this.priceAddedOption2 = priceAddedOption2;
	}

	public String getDescriptionOptionAddedOption2() {
		return descriptionOptionAddedOption2;
	}

	public void setDescriptionOptionAddedOption2(String descriptionOptionAddedOption2) {
		this.descriptionOptionAddedOption2 = descriptionOptionAddedOption2;
	}

	public String getNameAddedOption3() {
		return nameAddedOption3;
	}

	public void setNameAddedOption3(String nameAddedOption3) {
		this.nameAddedOption3 = nameAddedOption3;
	}

	public double getPriceAddedOption3() {
		return priceAddedOption3;
	}

	public void setPriceAddedOption3(double priceAddedOption3) {
		this.priceAddedOption3 = priceAddedOption3;
	}

	public String getDescriptionOptionAddedOption3() {
		return descriptionOptionAddedOption3;
	}

	public void setDescriptionOptionAddedOption3(String descriptionOptionAddedOption3) {
		this.descriptionOptionAddedOption3 = descriptionOptionAddedOption3;
	}

	public String getTimeSharesText() {
		return timeSharesText;
	}

	public void setTimeSharesText(String timeSharesText) {
		this.timeSharesText = timeSharesText;
	}

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

	public String getTypeEquipment() {
		return typeEquipment;
	}

	public void setTypeEquipment(String typeEquipment) {
		this.typeEquipment = typeEquipment;
	}

	public String getSoftwareMaker() {
		return softwareMaker;
	}

	public void setSoftwareMaker(String softwareMaker) {
		this.softwareMaker = softwareMaker;
	}

	public String getSoftwareClass() {
		return softwareClass;
	}

	public void setSoftwareClass(String softwareClass) {
		this.softwareClass = softwareClass;
	}

	public String getSoftwareVersion() {
		return softwareVersion;
	}

	public void setSoftwareVersion(String softwareVersion) {
		this.softwareVersion = softwareVersion;
	}

	public List<String> getPathPictures() {
		return pathPictures;
	}

	public void setPathPictures(List<String> pathPictures) {
		this.pathPictures = pathPictures;
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

	public Date getTimeShares() {
		return timeShares;
	}

	public void setTimeShares(Date timeShares) {
		this.timeShares = timeShares;
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

	public String getServiceInformation() {
		return serviceInformation;
	}

	public void setServiceInformation(String serviceInformation) {
		this.serviceInformation = serviceInformation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((descriptionEng == null) ? 0 : descriptionEng.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((leftSharesLink == null) ? 0 : leftSharesLink.hashCode());
		result = prime * result + ((leftSharesLinkColorFone == null) ? 0 : leftSharesLinkColorFone.hashCode());
		result = prime * result + ((leftSharesLinkColorText == null) ? 0 : leftSharesLinkColorText.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
		result = prime * result + ((pathPictures == null) ? 0 : pathPictures.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prise);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((rightSharesLink == null) ? 0 : rightSharesLink.hashCode());
		result = prime * result + ((rightSharesLinkColorFone == null) ? 0 : rightSharesLinkColorFone.hashCode());
		result = prime * result + ((rightSharesLinkColorText == null) ? 0 : rightSharesLinkColorText.hashCode());
		result = prime * result + ((serviceInformation == null) ? 0 : serviceInformation.hashCode());
		result = prime * result + (showOnHomePage ? 1231 : 1237);
		result = prime * result + (showOnLeftSide ? 1231 : 1237);
		result = prime * result + (showOnSite ? 1231 : 1237);
		result = prime * result + ((softwareClass == null) ? 0 : softwareClass.hashCode());
		result = prime * result + ((softwareMaker == null) ? 0 : softwareMaker.hashCode());
		result = prime * result + ((softwareVersion == null) ? 0 : softwareVersion.hashCode());
		result = prime * result + ((timeShares == null) ? 0 : timeShares.hashCode());
		result = prime * result + ((typeEquipment == null) ? 0 : typeEquipment.hashCode());
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
		Rip other = (Rip) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (descriptionEng == null) {
			if (other.descriptionEng != null)
				return false;
		} else if (!descriptionEng.equals(other.descriptionEng))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (leftSharesLink == null) {
			if (other.leftSharesLink != null)
				return false;
		} else if (!leftSharesLink.equals(other.leftSharesLink))
			return false;
		if (leftSharesLinkColorFone == null) {
			if (other.leftSharesLinkColorFone != null)
				return false;
		} else if (!leftSharesLinkColorFone.equals(other.leftSharesLinkColorFone))
			return false;
		if (leftSharesLinkColorText == null) {
			if (other.leftSharesLinkColorText != null)
				return false;
		} else if (!leftSharesLinkColorText.equals(other.leftSharesLinkColorText))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (partNumber == null) {
			if (other.partNumber != null)
				return false;
		} else if (!partNumber.equals(other.partNumber))
			return false;
		if (pathPictures == null) {
			if (other.pathPictures != null)
				return false;
		} else if (!pathPictures.equals(other.pathPictures))
			return false;
		if (Double.doubleToLongBits(prise) != Double.doubleToLongBits(other.prise))
			return false;
		if (rightSharesLink == null) {
			if (other.rightSharesLink != null)
				return false;
		} else if (!rightSharesLink.equals(other.rightSharesLink))
			return false;
		if (rightSharesLinkColorFone == null) {
			if (other.rightSharesLinkColorFone != null)
				return false;
		} else if (!rightSharesLinkColorFone.equals(other.rightSharesLinkColorFone))
			return false;
		if (rightSharesLinkColorText == null) {
			if (other.rightSharesLinkColorText != null)
				return false;
		} else if (!rightSharesLinkColorText.equals(other.rightSharesLinkColorText))
			return false;
		if (serviceInformation == null) {
			if (other.serviceInformation != null)
				return false;
		} else if (!serviceInformation.equals(other.serviceInformation))
			return false;
		if (showOnHomePage != other.showOnHomePage)
			return false;
		if (showOnLeftSide != other.showOnLeftSide)
			return false;
		if (showOnSite != other.showOnSite)
			return false;
		if (softwareClass == null) {
			if (other.softwareClass != null)
				return false;
		} else if (!softwareClass.equals(other.softwareClass))
			return false;
		if (softwareMaker == null) {
			if (other.softwareMaker != null)
				return false;
		} else if (!softwareMaker.equals(other.softwareMaker))
			return false;
		if (softwareVersion == null) {
			if (other.softwareVersion != null)
				return false;
		} else if (!softwareVersion.equals(other.softwareVersion))
			return false;
		if (timeShares == null) {
			if (other.timeShares != null)
				return false;
		} else if (!timeShares.equals(other.timeShares))
			return false;
		if (typeEquipment == null) {
			if (other.typeEquipment != null)
				return false;
		} else if (!typeEquipment.equals(other.typeEquipment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rip [id=" + id + ", partNumber=" + partNumber + ", name=" + name + ", prise=" + prise
				+ ", typeEquipment=" + typeEquipment + ", softwareMaker=" + softwareMaker + ", softwareClass="
				+ softwareClass + ", softwareVersion=" + softwareVersion + ", pathPictures=" + pathPictures
				+ ", leftSharesLink=" + leftSharesLink + ", leftSharesLinkColorText=" + leftSharesLinkColorText
				+ ", leftSharesLinkColorFone=" + leftSharesLinkColorFone + ", rightSharesLink=" + rightSharesLink
				+ ", rightSharesLinkColorText=" + rightSharesLinkColorText + ", rightSharesLinkColorFone="
				+ rightSharesLinkColorFone + ", timeShares=" + timeShares + ", description=" + description
				+ ", descriptionEng=" + descriptionEng + ", showOnSite=" + showOnSite + ", showOnHomePage="
				+ showOnHomePage + ", showOnLeftSide=" + showOnLeftSide + ", serviceInformation=" + serviceInformation
				+ "]";
	}
	
}
