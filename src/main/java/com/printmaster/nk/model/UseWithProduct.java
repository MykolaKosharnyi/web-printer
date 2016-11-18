package com.printmaster.nk.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="use_with_product")
public class UseWithProduct extends Product implements Serializable{

	private static final long serialVersionUID = 3031695775597440046L;	
	
	@NotEmpty
	@Column(name="typeProduct")//Тип продукта
	private String typeProduct;
	
	@Column(name="typeInk")
	private String typeInk; 
	
	@Column(name="availability")
	protected String availability;
	
	@Column(name="availabilitySpecialCase")
	protected String availabilitySpecialCase;
	
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
	//@ManyToMany(fetch = FetchType.LAZY, mappedBy = "useWithProduct")
	//private Set<Cutter> useWithProduct = new HashSet<Cutter>(0);
	
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
	
	@Column(name="ukraineDeliveryDescription")
	protected String ukraineDeliveryDescription;
		
	//on Kyiv
	@Column(name="kyivDeliveryPriceSize", nullable = false, columnDefinition = "bit default 0")
	protected boolean kyivDeliveryPriceSize;
			
	@Column(name="kyivDeliveryPriceWeight", nullable = false, columnDefinition = "bit default 0")
	protected boolean kyivDeliveryPriceWeight;
	
	@Column(name="kyivDeliveryDescription")
	protected String kyivDeliveryDescription;
	
	/* FOR PAINT OPTION SECTION */
	@Column(name="cyanPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double cyanPaint;//Cyan
	
	@Column(name="magentaPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double magentaPaint;//Magenta

	@Column(name="yellowPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double yellowPaint;//Yellow
	
	@Column(name="blackPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double blackPaint;//Black
	
	@Column(name="lightCyanPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double lightCyanPaint;//Light Cyan
	
	@Column(name="lightMagentaPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double lightMagentaPaint;//Light Magenta
	
	@Column(name="solventPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double solventPaint;//Solvent
	
	@Column(name="matteBlackPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double matteBlackPaint;//Matte black
	
	@Column(name="grayPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double grayPaint;//Gray
	
	@Column(name="orangePaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double orangePaint;//Orange
	
	@Column(name="greenPaint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double greenPaint;//Green
	
	@Column(name="variant1NamePaint")
	protected String variant1NamePaint;//Name paint first custom variant
	
	@Column(name="variant1Paint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant1Paint;//First custom variant
	
	@Column(name="variant2NamePaint")
	protected String variant2NamePaint;//Name paint second custom variant
	
	@Column(name="variant2Paint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant2Paint;//Second custom variant
	
	@Column(name="variant3NamePaint")
	protected String variant3NamePaint;//Name paint third custom variant
	
	@Column(name="variant3Paint", columnDefinition="Decimal(10,2) default '0.00'")
	protected double variant3Paint;//Third custom variant
	
	//insurance
	//1. Страхование груза международная перевозка
	//2. Страхование груза по Украине
//	@Column(name="insuranceInternationalTransport", columnDefinition="Decimal(10,2) default '0.00'")
//	protected double insuranceInternationalTransport;
	@Column(name="insuranceInternationalTransport", nullable = false, columnDefinition = "bit default 0")
	protected boolean insuranceInternationalTransport;
	
	@Size(max = 50)
	@Column(name="descriptionInsuranceInternationalTransport")
	protected String descriptionInsuranceInternationalTransport;
		
//	@Column(name="insuranceUkraineTransport", columnDefinition="Decimal(10,2) default '0.00'")
//	protected double insuranceUkraineTransport;
	@Column(name="insuranceUkraineTransport", nullable = false, columnDefinition = "bit default 0")
	protected boolean insuranceUkraineTransport;
	
	@Size(max = 50)
	@Column(name="descriptionInsuranceUkraineTransport")
	protected String descriptionInsuranceUkraineTransport;
	
	public UseWithProduct(){}
	
	public String getUkraineDeliveryDescription() {
		return ukraineDeliveryDescription;
	}

	public void setUkraineDeliveryDescription(String ukraineDeliveryDescription) {
		this.ukraineDeliveryDescription = ukraineDeliveryDescription;
	}

	public String getKyivDeliveryDescription() {
		return kyivDeliveryDescription;
	}

	public void setKyivDeliveryDescription(String kyivDeliveryDescription) {
		this.kyivDeliveryDescription = kyivDeliveryDescription;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	public String getTypeInk() {
		return typeInk;
	}

	public void setTypeInk(String typeInk) {
		this.typeInk = typeInk;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getAvailabilitySpecialCase() {
		return availabilitySpecialCase;
	}

	public void setAvailabilitySpecialCase(String availabilitySpecialCase) {
		this.availabilitySpecialCase = availabilitySpecialCase;
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

	public double getCyanPaint() {
		return cyanPaint;
	}

	public void setCyanPaint(double cyanPaint) {
		this.cyanPaint = cyanPaint;
	}

	public double getMagentaPaint() {
		return magentaPaint;
	}

	public void setMagentaPaint(double magentaPaint) {
		this.magentaPaint = magentaPaint;
	}

	public double getYellowPaint() {
		return yellowPaint;
	}

	public void setYellowPaint(double yellowPaint) {
		this.yellowPaint = yellowPaint;
	}

	public double getBlackPaint() {
		return blackPaint;
	}

	public void setBlackPaint(double blackPaint) {
		this.blackPaint = blackPaint;
	}

	public double getLightCyanPaint() {
		return lightCyanPaint;
	}

	public void setLightCyanPaint(double lightCyanPaint) {
		this.lightCyanPaint = lightCyanPaint;
	}

	public double getLightMagentaPaint() {
		return lightMagentaPaint;
	}

	public void setLightMagentaPaint(double lightMagentaPaint) {
		this.lightMagentaPaint = lightMagentaPaint;
	}

	public double getSolventPaint() {
		return solventPaint;
	}

	public void setSolventPaint(double solventPaint) {
		this.solventPaint = solventPaint;
	}

	public double getMatteBlackPaint() {
		return matteBlackPaint;
	}

	public void setMatteBlackPaint(double matteBlackPaint) {
		this.matteBlackPaint = matteBlackPaint;
	}

	public double getGrayPaint() {
		return grayPaint;
	}

	public void setGrayPaint(double grayPaint) {
		this.grayPaint = grayPaint;
	}

	public double getOrangePaint() {
		return orangePaint;
	}

	public void setOrangePaint(double orangePaint) {
		this.orangePaint = orangePaint;
	}

	public double getGreenPaint() {
		return greenPaint;
	}

	public void setGreenPaint(double greenPaint) {
		this.greenPaint = greenPaint;
	}

	public String getVariant1NamePaint() {
		return variant1NamePaint;
	}

	public void setVariant1NamePaint(String variant1NamePaint) {
		this.variant1NamePaint = variant1NamePaint;
	}

	public double getVariant1Paint() {
		return variant1Paint;
	}

	public void setVariant1Paint(double variant1Paint) {
		this.variant1Paint = variant1Paint;
	}

	public String getVariant2NamePaint() {
		return variant2NamePaint;
	}

	public void setVariant2NamePaint(String variant2NamePaint) {
		this.variant2NamePaint = variant2NamePaint;
	}

	public double getVariant2Paint() {
		return variant2Paint;
	}

	public void setVariant2Paint(double variant2Paint) {
		this.variant2Paint = variant2Paint;
	}

	public String getVariant3NamePaint() {
		return variant3NamePaint;
	}

	public void setVariant3NamePaint(String variant3NamePaint) {
		this.variant3NamePaint = variant3NamePaint;
	}

	public double getVariant3Paint() {
		return variant3Paint;
	}

	public void setVariant3Paint(double variant3Paint) {
		this.variant3Paint = variant3Paint;
	}

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

	public boolean isInsuranceInternationalTransport() {
		return insuranceInternationalTransport;
	}

	public void setInsuranceInternationalTransport(boolean insuranceInternationalTransport) {
		this.insuranceInternationalTransport = insuranceInternationalTransport;
	}

	public boolean isInsuranceUkraineTransport() {
		return insuranceUkraineTransport;
	}

	public void setInsuranceUkraineTransport(boolean insuranceUkraineTransport) {
		this.insuranceUkraineTransport = insuranceUkraineTransport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prise);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		UseWithProduct other = (UseWithProduct) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(prise) != Double.doubleToLongBits(other.prise))
			return false;
		return true;
	}
	
}
