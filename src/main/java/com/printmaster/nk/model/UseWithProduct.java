package com.printmaster.nk.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="use_with_product")
public class UseWithProduct implements Serializable{

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
	
	@NotEmpty
	@Column(name="typeProduct")//Тип продукта
	private String typeProduct;
	
	@Column(name="prise")
	protected double prise;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	protected boolean showOnSite = true;
	
	@Column(nullable = false, columnDefinition = "bit default 1")
	protected boolean showOnHomePage = true;
	
	@Column(nullable = false, columnDefinition = "bit default 0")
	protected boolean showOnLeftSide = false;
	
	@Column(name="availability")
	protected String availability;
	
	@Column(name="availabilitySpecialCase")
	protected String availabilitySpecialCase;
	
	@Column(name="description", columnDefinition="TEXT")
	protected String description;
	
	@Column(name="description_eng", columnDefinition="TEXT")
	protected String descriptionEng;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="path_pictures")
	private List<String> pathPictures = new ArrayList<String>();
	
	@Column(name="service_information", columnDefinition="TEXT")
	protected String serviceInformation;
	
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
	
	public UseWithProduct(){}

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

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
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

	public List<String> getPathPictures() {
		return pathPictures;
	}

	public void setPathPictures(List<String> pathPictures) {
		this.pathPictures = pathPictures;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((partNumber == null) ? 0 : partNumber.hashCode());
		result = prime * result + ((pathPictures == null) ? 0 : pathPictures.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prise);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((serviceInformation == null) ? 0 : serviceInformation.hashCode());
		result = prime * result + (showOnHomePage ? 1231 : 1237);
		result = prime * result + (showOnLeftSide ? 1231 : 1237);
		result = prime * result + (showOnSite ? 1231 : 1237);
		result = prime * result + ((typeProduct == null) ? 0 : typeProduct.hashCode());
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
		if (typeProduct == null) {
			if (other.typeProduct != null)
				return false;
		} else if (!typeProduct.equals(other.typeProduct))
			return false;
		return true;
	}
	
}
