package com.printmaster.nk.model;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)*/
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
	
	@Column(name="previously_used")
	protected String previouslyUsed;
	
	@Column(name="equipment_model")
	private String equipmentModel;
	
	@Column(name="equipment_manufacturer")
	protected String equipmentManufacturer;
	
	@Column(name="weight")
	protected Double weight;
	
	@Column(name="width")
	protected int width;
	
	@Column(name="heigth")
	protected int heigth;
	
	@Column(name="depth")
	protected int depth;
	
	@Column(name="max_power_consumption")
	protected int maxPowerConsumption;
	
	@Column(name="averagePowerConsumption")
	protected int averagePowerConsumption;//Средняя потребляемая мощность
	
	@Column(name="description", columnDefinition="TEXT")
	protected String description;
	
	@Column(name="description_eng", columnDefinition="TEXT")
	protected String descriptionEng;

	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="path_pictures")
	private List<String> pathPictures = new ArrayList<String>();
	
	@Column(name="idUseWithProduct")
	private long[] idUseWithProduct;
	
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
	
	@Column(name="time_shares")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="dd.MM.yyyy")
	protected Date timeShares;
	
	@Column(name="timeSharesText", columnDefinition="TEXT")
	protected String timeSharesText;
	
	@Column(name="delivery")
	protected String delivery;
	
	@Column(name="guarantee")
	protected String guarantee;
	
	@Column(name="availability")
	protected String availability;
	
	@Column(name="availabilitySpecialCase")
	protected String availabilitySpecialCase;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	protected boolean showOnSite = true;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	protected boolean showOnHomePage = true;
	
	@Column(nullable = false, columnDefinition = "bit default 0")
	protected boolean showOnLeftSide = false;
	
	@Column(name="service_information", columnDefinition="TEXT")
	protected String serviceInformation;
	
	//Option - price for addition opportunity with product
	@Column(name="optionRIP", columnDefinition="Decimal(10,2) default '0.00'")
	protected double optionRIP;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionRIP")
	protected String descriptionOptionRIP;
	
	@Column(name="optionSNCP", columnDefinition="Decimal(10,2) default '0.00'")
	protected double optionSNCP;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionSNCP")
	protected String descriptionOptionSNCP;
	
	@Column(name="optionDelivery", columnDefinition="Decimal(10,2) default '0.00'")
	protected double optionDelivery;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionDelivery")
	protected String descriptionOptionDelivery;
	
	@Column(name="optionGuarantee", columnDefinition="Decimal(10,2) default '0.00'")
	protected double optionGuarantee;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionGuarantee")
	protected String descriptionOptionGuarantee;
	
	@Column(name="optionInstallation", columnDefinition="Decimal(10,2) default '0.00'")
	protected double optionInstallation;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionInstallation")
	protected String descriptionOptionInstallation;
	
	@Column(name="optionVAT", columnDefinition="Decimal(10,2) default '1.20'")
	protected double optionVAT;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionVAT")
	protected String descriptionOptionVAT;
	
	@Column(name="nameAddedOption")
	protected String nameAddedOption;
	
	@Column(name="priceAddedOption", columnDefinition="Decimal(10,2) default '0.00'")
	protected double priceAddedOption;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionAddedOption")
	protected String descriptionOptionAddedOption;
	
	@Column(name="nameAddedOption2")
	protected String nameAddedOption2;
	
	@Column(name="priceAddedOption2", columnDefinition="Decimal(10,2) default '0.00'")
	protected double priceAddedOption2;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionAddedOption2")
	protected String descriptionOptionAddedOption2;
	
	@Column(name="nameAddedOption3")
	protected String nameAddedOption3;
	
	@Column(name="priceAddedOption3", columnDefinition="Decimal(10,2) default '0.00'")
	protected double priceAddedOption3;
	
	@Size(min = 5, max = 50)
	@Column(name="descriptionAddedOption3")
	protected String descriptionOptionAddedOption3;
	
	public Product(){}

	public String getDescriptionOptionRIP() {
		return descriptionOptionRIP;
	}

	public void setDescriptionOptionRIP(String descriptionOptionRIP) {
		this.descriptionOptionRIP = descriptionOptionRIP;
	}

	public String getDescriptionOptionSNCP() {
		return descriptionOptionSNCP;
	}

	public void setDescriptionOptionSNCP(String descriptionOptionSNCP) {
		this.descriptionOptionSNCP = descriptionOptionSNCP;
	}

	public String getDescriptionOptionDelivery() {
		return descriptionOptionDelivery;
	}

	public void setDescriptionOptionDelivery(String descriptionOptionDelivery) {
		this.descriptionOptionDelivery = descriptionOptionDelivery;
	}

	public String getDescriptionOptionGuarantee() {
		return descriptionOptionGuarantee;
	}

	public void setDescriptionOptionGuarantee(String descriptionOptionGuarantee) {
		this.descriptionOptionGuarantee = descriptionOptionGuarantee;
	}

	public String getDescriptionOptionInstallation() {
		return descriptionOptionInstallation;
	}

	public void setDescriptionOptionInstallation(String descriptionOptionInstallation) {
		this.descriptionOptionInstallation = descriptionOptionInstallation;
	}

	public String getDescriptionOptionVAT() {
		return descriptionOptionVAT;
	}

	public void setDescriptionOptionVAT(String descriptionOptionVAT) {
		this.descriptionOptionVAT = descriptionOptionVAT;
	}

	public String getDescriptionOptionAddedOption() {
		return descriptionOptionAddedOption;
	}

	public void setDescriptionOptionAddedOption(String descriptionOptionAddedOption) {
		this.descriptionOptionAddedOption = descriptionOptionAddedOption;
	}

	public String getDescriptionOptionAddedOption2() {
		return descriptionOptionAddedOption2;
	}

	public void setDescriptionOptionAddedOption2(String descriptionOptionAddedOption2) {
		this.descriptionOptionAddedOption2 = descriptionOptionAddedOption2;
	}

	public String getDescriptionOptionAddedOption3() {
		return descriptionOptionAddedOption3;
	}

	public void setDescriptionOptionAddedOption3(String descriptionOptionAddedOption3) {
		this.descriptionOptionAddedOption3 = descriptionOptionAddedOption3;
	}

	public double getOptionInstallation() {
		return optionInstallation;
	}

	public void setOptionInstallation(double optionInstallation) {
		this.optionInstallation = optionInstallation;
	}


	public double getOptionVAT() {
		return optionVAT;
	}

	public void setOptionVAT(double optionVAT) {
		this.optionVAT = optionVAT;
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

	public double getOptionRIP() {
		return optionRIP;
	}

	public void setOptionRIP(double optionRIP) {
		this.optionRIP = optionRIP;
	}

	public double getOptionSNCP() {
		return optionSNCP;
	}

	public void setOptionSNCP(double optionSNCP) {
		this.optionSNCP = optionSNCP;
	}

	public double getOptionDelivery() {
		return optionDelivery;
	}

	public void setOptionDelivery(double optionDelivery) {
		this.optionDelivery = optionDelivery;
	}

	public double getOptionGuarantee() {
		return optionGuarantee;
	}

	public void setOptionGuarantee(double optionGuarantee) {
		this.optionGuarantee = optionGuarantee;
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

	public String getAvailabilitySpecialCase() {
		return availabilitySpecialCase;
	}

	public void setAvailabilitySpecialCase(String availabilitySpecialCase) {
		this.availabilitySpecialCase = availabilitySpecialCase;
	}

	public String getTimeSharesText() {
		return timeSharesText;
	}

	public void setTimeSharesText(String timeSharesText) {
		this.timeSharesText = timeSharesText;
	}

	public long[] getIdUseWithProduct() {
		return idUseWithProduct;
	}

	public void setIdUseWithProduct(long[] idUseWithProduct) {
		this.idUseWithProduct = idUseWithProduct;
	}

	public int getAveragePowerConsumption() {
		return averagePowerConsumption;
	}

	public void setAveragePowerConsumption(int averagePowerConsumption) {
		this.averagePowerConsumption = averagePowerConsumption;
	}

	public String getServiceInformation() {
		return serviceInformation;
	}

	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public void setServiceInformation(String serviceInformation) {
		this.serviceInformation = serviceInformation;
	}

	public boolean isShowOnLeftSide() {
		return showOnLeftSide;
	}

	public void setShowOnLeftSide(boolean showOnLeftSide) {
		this.showOnLeftSide = showOnLeftSide;
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

	public String getLeftSharesLink() {
		return leftSharesLink;
	}

	public void setLeftSharesLink(String leftSharesLink) {
		this.leftSharesLink = leftSharesLink;
	}

	public String getRightSharesLink() {
		return rightSharesLink;
	}

	public void setRightSharesLink(String rightSharesLink) {
		this.rightSharesLink = rightSharesLink;
	}

	public Date getTimeShares() {
		return timeShares;
	}

	public void setTimeShares(Date timeShares) {
		this.timeShares = timeShares;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(String guarantee) {
		this.guarantee = guarantee;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getPreviouslyUsed() {
		return previouslyUsed;
	}

	public void setPreviouslyUsed(String previouslyUsed) {
		this.previouslyUsed = previouslyUsed;
	}

	public String getPartNumber() {
		return partNumber;
	}

	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	public String getEquipmentManufacturer() {
		return equipmentManufacturer;
	}

	public void setEquipmentManufacturer(String equipmentManufacturer) {
		this.equipmentManufacturer = equipmentManufacturer;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeigth() {
		return heigth;
	}

	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getMaxPowerConsumption() {
		return maxPowerConsumption;
	}

	public void setMaxPowerConsumption(int maxPowerConsumption) {
		this.maxPowerConsumption = maxPowerConsumption;
	}

	public List<String> getPathPictures() {
		return pathPictures;
	}

	public void setPathPictures(List<String> pathPictures) {
		this.pathPictures = pathPictures;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((availability == null) ? 0 : availability.hashCode());
		result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result + depth;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((descriptionEng == null) ? 0 : descriptionEng.hashCode());
		result = prime * result + ((equipmentManufacturer == null) ? 0 : equipmentManufacturer.hashCode());
		result = prime * result + ((guarantee == null) ? 0 : guarantee.hashCode());
		result = prime * result + heigth;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((leftSharesLink == null) ? 0 : leftSharesLink.hashCode());
		result = prime * result + ((leftSharesLinkColorFone == null) ? 0 : leftSharesLinkColorFone.hashCode());
		result = prime * result + ((leftSharesLinkColorText == null) ? 0 : leftSharesLinkColorText.hashCode());
		result = prime * result + maxPowerConsumption;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
		result = prime * result + ((pathPictures == null) ? 0 : pathPictures.hashCode());
		result = prime * result + ((previouslyUsed == null) ? 0 : previouslyUsed.hashCode());
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
		result = prime * result + ((timeShares == null) ? 0 : timeShares.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		result = prime * result + width;
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
		Product other = (Product) obj;
		if (availability == null) {
			if (other.availability != null)
				return false;
		} else if (!availability.equals(other.availability))
			return false;
		if (delivery == null) {
			if (other.delivery != null)
				return false;
		} else if (!delivery.equals(other.delivery))
			return false;
		if (depth != other.depth)
			return false;
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
		if (equipmentManufacturer == null) {
			if (other.equipmentManufacturer != null)
				return false;
		} else if (!equipmentManufacturer.equals(other.equipmentManufacturer))
			return false;
		if (guarantee == null) {
			if (other.guarantee != null)
				return false;
		} else if (!guarantee.equals(other.guarantee))
			return false;
		if (heigth != other.heigth)
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
		if (maxPowerConsumption != other.maxPowerConsumption)
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
		if (previouslyUsed == null) {
			if (other.previouslyUsed != null)
				return false;
		} else if (!previouslyUsed.equals(other.previouslyUsed))
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
		if (timeShares == null) {
			if (other.timeShares != null)
				return false;
		} else if (!timeShares.equals(other.timeShares))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		if (width != other.width)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", partNumber=" + partNumber + ", name=" + name + ", prise=" + prise
				+ ", previouslyUsed=" + previouslyUsed + ", equipmentManufacturer=" + equipmentManufacturer
				+ ", weight=" + weight + ", width=" + width + ", heigth=" + heigth + ", depth=" + depth
				+ ", maxPowerConsumption=" + maxPowerConsumption + ", description=" + description + ", descriptionEng="
				+ descriptionEng + ", pathPictures=" + pathPictures + ", leftSharesLink=" + leftSharesLink
				+ ", leftSharesLinkColorText=" + leftSharesLinkColorText + ", leftSharesLinkColorFone="
				+ leftSharesLinkColorFone + ", rightSharesLink=" + rightSharesLink + ", rightSharesLinkColorText="
				+ rightSharesLinkColorText + ", rightSharesLinkColorFone=" + rightSharesLinkColorFone + ", timeShares="
				+ timeShares + ", delivery=" + delivery + ", guarantee=" + guarantee + ", availability=" + availability
				+ ", showOnSite=" + showOnSite + ", showOnHomePage=" + showOnHomePage + ", showOnLeftSide="
				+ showOnLeftSide + ", serviceInformation=" + serviceInformation + "]";
	}
	
}
