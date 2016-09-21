package com.printmaster.nk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
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
			
			@Size(max = 50)
			@Column(name="descriptionRIP")
			protected String descriptionOptionRIP;
			
			@Column(name="optionSNCP", columnDefinition="Decimal(10,2) default '0.00'")
			protected double optionSNCP;
			
			@Size(max = 50)
			@Column(name="descriptionSNCP")
			protected String descriptionOptionSNCP;
			
			@Column(name="optionGuarantee", columnDefinition="Decimal(10,2) default '0.00'")
			protected double optionGuarantee;
			
			@Size(max = 50)
			@Column(name="descriptionGuarantee")
			protected String descriptionOptionGuarantee;
			
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
	
	//air
	@Column(name="airDeliveryPriceSize", nullable = false, columnDefinition = "bit default 0")
	protected boolean airDeliveryPriceSize;
	
	@Column(name="airDeliveryPriceWeight", nullable = false, columnDefinition = "bit default 0")
	protected boolean airDeliveryPriceWeight;
	
	//sea	
	@Column(name="seaDeliveryPriceSize", nullable = false, columnDefinition = "bit default 0")
	protected boolean seaDeliveryPriceSize;
	
	@Column(name="seaDeliveryPriceWeight", nullable = false, columnDefinition = "bit default 0")
	protected boolean seaDeliveryPriceWeight;
	
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
	
	//first custom variant
	@Column(name="variant1DeliveryName")
	protected String variant1DeliveryName;

	@Column(name="variant1DeliveryPriceSize", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant1DeliveryPriceSize;
			
	@Column(name="variant1DeliveryPriceWeight", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant1DeliveryPriceWeight;
	
	//second custom variant
	@Column(name="variant2DeliveryName")
	protected String variant2DeliveryName;
	
	@Column(name="variant2DeliveryPriceSize", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant2DeliveryPriceSize;
						
	@Column(name="variant2DeliveryPriceWeight", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant2DeliveryPriceWeight;
	
	//third custom variant
	@Column(name="variant3DeliveryName")
	protected String variant3DeliveryName;

	@Column(name="variant3DeliveryPriceSize", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant3DeliveryPriceSize;
								
	@Column(name="variant3DeliveryPriceWeight", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant3DeliveryPriceWeight;
			
	//insurance
	//1. Страхование груза международная перевозка
	//2. Страхование груза по Украине
	@Column(name="insuranceInternationalTransport", columnDefinition="Decimal(10,2) default '0.00'")
	protected double insuranceInternationalTransport;
	
	@Size(max = 50)
	@Column(name="descriptionInsuranceInternationalTransport")
	protected String descriptionInsuranceInternationalTransport;
	
	@Column(name="insuranceUkraineTransport", columnDefinition="Decimal(10,2) default '0.00'")
	protected double insuranceUkraineTransport;
	
	@Size(max = 50)
	@Column(name="descriptionInsuranceUkraineTransport")
	protected String descriptionInsuranceUkraineTransport;
	
	public Product(){}
	
	public String getDescriptionInsuranceInternationalTransport() {
		return descriptionInsuranceInternationalTransport;
	}

	public void setDescriptionInsuranceInternationalTransport(String descriptionInsuranceInternationalTransport) {
		this.descriptionInsuranceInternationalTransport = descriptionInsuranceInternationalTransport;
	}

	public String getDescriptionInsuranceUkraineTransport() {
		return descriptionInsuranceUkraineTransport;
	}

	public void setDescriptionInsuranceUkraineTransport(String descriptionInsuranceUkraineTransport) {
		this.descriptionInsuranceUkraineTransport = descriptionInsuranceUkraineTransport;
	}

	public double getInsuranceInternationalTransport() {
		return insuranceInternationalTransport;
	}

	public void setInsuranceInternationalTransport(double insuranceInternationalTransport) {
		this.insuranceInternationalTransport = insuranceInternationalTransport;
	}

	public double getInsuranceUkraineTransport() {
		return insuranceUkraineTransport;
	}

	public void setInsuranceUkraineTransport(double insuranceUkraineTransport) {
		this.insuranceUkraineTransport = insuranceUkraineTransport;
	}

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

	public String getVariant1DeliveryName() {
		return variant1DeliveryName;
	}

	public void setVariant1DeliveryName(String variant1DeliveryName) {
		this.variant1DeliveryName = variant1DeliveryName;
	}

	public String getVariant2DeliveryName() {
		return variant2DeliveryName;
	}

	public void setVariant2DeliveryName(String variant2DeliveryName) {
		this.variant2DeliveryName = variant2DeliveryName;
	}

	public String getVariant3DeliveryName() {
		return variant3DeliveryName;
	}

	public void setVariant3DeliveryName(String variant3DeliveryName) {
		this.variant3DeliveryName = variant3DeliveryName;
	}

	public boolean isAirDeliveryPriceSize() {
		return airDeliveryPriceSize;
	}

	public void setAirDeliveryPriceSize(boolean airDeliveryPriceSize) {
		this.airDeliveryPriceSize = airDeliveryPriceSize;
	}

	public boolean isAirDeliveryPriceWeight() {
		return airDeliveryPriceWeight;
	}

	public void setAirDeliveryPriceWeight(boolean airDeliveryPriceWeight) {
		this.airDeliveryPriceWeight = airDeliveryPriceWeight;
	}

	public boolean isSeaDeliveryPriceSize() {
		return seaDeliveryPriceSize;
	}

	public void setSeaDeliveryPriceSize(boolean seaDeliveryPriceSize) {
		this.seaDeliveryPriceSize = seaDeliveryPriceSize;
	}

	public boolean isSeaDeliveryPriceWeight() {
		return seaDeliveryPriceWeight;
	}

	public void setSeaDeliveryPriceWeight(boolean seaDeliveryPriceWeight) {
		this.seaDeliveryPriceWeight = seaDeliveryPriceWeight;
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

	public double getVariant1DeliveryPriceSize() {
		return variant1DeliveryPriceSize;
	}

	public void setVariant1DeliveryPriceSize(double variant1DeliveryPriceSize) {
		this.variant1DeliveryPriceSize = variant1DeliveryPriceSize;
	}

	public double getVariant1DeliveryPriceWeight() {
		return variant1DeliveryPriceWeight;
	}

	public void setVariant1DeliveryPriceWeight(double variant1DeliveryPriceWeight) {
		this.variant1DeliveryPriceWeight = variant1DeliveryPriceWeight;
	}

	public double getVariant2DeliveryPriceSize() {
		return variant2DeliveryPriceSize;
	}

	public void setVariant2DeliveryPriceSize(double variant2DeliveryPriceSize) {
		this.variant2DeliveryPriceSize = variant2DeliveryPriceSize;
	}

	public double getVariant2DeliveryPriceWeight() {
		return variant2DeliveryPriceWeight;
	}

	public void setVariant2DeliveryPriceWeight(double variant2DeliveryPriceWeight) {
		this.variant2DeliveryPriceWeight = variant2DeliveryPriceWeight;
	}

	public double getVariant3DeliveryPriceSize() {
		return variant3DeliveryPriceSize;
	}

	public void setVariant3DeliveryPriceSize(double variant3DeliveryPriceSize) {
		this.variant3DeliveryPriceSize = variant3DeliveryPriceSize;
	}

	public double getVariant3DeliveryPriceWeight() {
		return variant3DeliveryPriceWeight;
	}

	public void setVariant3DeliveryPriceWeight(double variant3DeliveryPriceWeight) {
		this.variant3DeliveryPriceWeight = variant3DeliveryPriceWeight;
	}

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
		result = prime * result + ((availabilitySpecialCase == null) ? 0 : availabilitySpecialCase.hashCode());
		result = prime * result + averagePowerConsumption;
		result = prime * result + ((delivery == null) ? 0 : delivery.hashCode());
		result = prime * result + depth;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((descriptionEng == null) ? 0 : descriptionEng.hashCode());
		result = prime * result
				+ ((descriptionOptionAddedOption == null) ? 0 : descriptionOptionAddedOption.hashCode());
		result = prime * result
				+ ((descriptionOptionAddedOption2 == null) ? 0 : descriptionOptionAddedOption2.hashCode());
		result = prime * result
				+ ((descriptionOptionAddedOption3 == null) ? 0 : descriptionOptionAddedOption3.hashCode());
		result = prime * result + ((descriptionOptionGuarantee == null) ? 0 : descriptionOptionGuarantee.hashCode());
		result = prime * result
				+ ((descriptionOptionInstallation == null) ? 0 : descriptionOptionInstallation.hashCode());
		result = prime * result + ((descriptionOptionRIP == null) ? 0 : descriptionOptionRIP.hashCode());
		result = prime * result + ((descriptionOptionSNCP == null) ? 0 : descriptionOptionSNCP.hashCode());
		result = prime * result + ((descriptionOptionVAT == null) ? 0 : descriptionOptionVAT.hashCode());
		result = prime * result + ((equipmentManufacturer == null) ? 0 : equipmentManufacturer.hashCode());
		result = prime * result + ((equipmentModel == null) ? 0 : equipmentModel.hashCode());
		result = prime * result + ((guarantee == null) ? 0 : guarantee.hashCode());
		result = prime * result + heigth;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(idUseWithProduct);
		result = prime * result + ((leftSharesLink == null) ? 0 : leftSharesLink.hashCode());
		result = prime * result + ((leftSharesLinkColorFone == null) ? 0 : leftSharesLinkColorFone.hashCode());
		result = prime * result + ((leftSharesLinkColorText == null) ? 0 : leftSharesLinkColorText.hashCode());
		result = prime * result + maxPowerConsumption;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nameAddedOption == null) ? 0 : nameAddedOption.hashCode());
		result = prime * result + ((nameAddedOption2 == null) ? 0 : nameAddedOption2.hashCode());
		result = prime * result + ((nameAddedOption3 == null) ? 0 : nameAddedOption3.hashCode());
		long temp;
		temp = Double.doubleToLongBits(optionGuarantee);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(optionInstallation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(optionRIP);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(optionSNCP);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(optionVAT);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
		result = prime * result + ((pathPictures == null) ? 0 : pathPictures.hashCode());
		result = prime * result + ((previouslyUsed == null) ? 0 : previouslyUsed.hashCode());
		temp = Double.doubleToLongBits(priceAddedOption);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceAddedOption2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(priceAddedOption3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		result = prime * result + ((timeSharesText == null) ? 0 : timeSharesText.hashCode());
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
		if (availabilitySpecialCase == null) {
			if (other.availabilitySpecialCase != null)
				return false;
		} else if (!availabilitySpecialCase.equals(other.availabilitySpecialCase))
			return false;
		if (averagePowerConsumption != other.averagePowerConsumption)
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
		if (descriptionOptionAddedOption == null) {
			if (other.descriptionOptionAddedOption != null)
				return false;
		} else if (!descriptionOptionAddedOption.equals(other.descriptionOptionAddedOption))
			return false;
		if (descriptionOptionAddedOption2 == null) {
			if (other.descriptionOptionAddedOption2 != null)
				return false;
		} else if (!descriptionOptionAddedOption2.equals(other.descriptionOptionAddedOption2))
			return false;
		if (descriptionOptionAddedOption3 == null) {
			if (other.descriptionOptionAddedOption3 != null)
				return false;
		} else if (!descriptionOptionAddedOption3.equals(other.descriptionOptionAddedOption3))
			return false;
		if (descriptionOptionGuarantee == null) {
			if (other.descriptionOptionGuarantee != null)
				return false;
		} else if (!descriptionOptionGuarantee.equals(other.descriptionOptionGuarantee))
			return false;
		if (descriptionOptionInstallation == null) {
			if (other.descriptionOptionInstallation != null)
				return false;
		} else if (!descriptionOptionInstallation.equals(other.descriptionOptionInstallation))
			return false;
		if (descriptionOptionRIP == null) {
			if (other.descriptionOptionRIP != null)
				return false;
		} else if (!descriptionOptionRIP.equals(other.descriptionOptionRIP))
			return false;
		if (descriptionOptionSNCP == null) {
			if (other.descriptionOptionSNCP != null)
				return false;
		} else if (!descriptionOptionSNCP.equals(other.descriptionOptionSNCP))
			return false;
		if (descriptionOptionVAT == null) {
			if (other.descriptionOptionVAT != null)
				return false;
		} else if (!descriptionOptionVAT.equals(other.descriptionOptionVAT))
			return false;
		if (equipmentManufacturer == null) {
			if (other.equipmentManufacturer != null)
				return false;
		} else if (!equipmentManufacturer.equals(other.equipmentManufacturer))
			return false;
		if (equipmentModel == null) {
			if (other.equipmentModel != null)
				return false;
		} else if (!equipmentModel.equals(other.equipmentModel))
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
		if (!Arrays.equals(idUseWithProduct, other.idUseWithProduct))
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
		if (nameAddedOption == null) {
			if (other.nameAddedOption != null)
				return false;
		} else if (!nameAddedOption.equals(other.nameAddedOption))
			return false;
		if (nameAddedOption2 == null) {
			if (other.nameAddedOption2 != null)
				return false;
		} else if (!nameAddedOption2.equals(other.nameAddedOption2))
			return false;
		if (nameAddedOption3 == null) {
			if (other.nameAddedOption3 != null)
				return false;
		} else if (!nameAddedOption3.equals(other.nameAddedOption3))
			return false;
		if (Double.doubleToLongBits(optionGuarantee) != Double.doubleToLongBits(other.optionGuarantee))
			return false;
		if (Double.doubleToLongBits(optionInstallation) != Double.doubleToLongBits(other.optionInstallation))
			return false;
		if (Double.doubleToLongBits(optionRIP) != Double.doubleToLongBits(other.optionRIP))
			return false;
		if (Double.doubleToLongBits(optionSNCP) != Double.doubleToLongBits(other.optionSNCP))
			return false;
		if (Double.doubleToLongBits(optionVAT) != Double.doubleToLongBits(other.optionVAT))
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
		if (Double.doubleToLongBits(priceAddedOption) != Double.doubleToLongBits(other.priceAddedOption))
			return false;
		if (Double.doubleToLongBits(priceAddedOption2) != Double.doubleToLongBits(other.priceAddedOption2))
			return false;
		if (Double.doubleToLongBits(priceAddedOption3) != Double.doubleToLongBits(other.priceAddedOption3))
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
		if (timeSharesText == null) {
			if (other.timeSharesText != null)
				return false;
		} else if (!timeSharesText.equals(other.timeSharesText))
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
