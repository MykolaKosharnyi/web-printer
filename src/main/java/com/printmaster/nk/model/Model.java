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
/*import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;*/
import javax.persistence.MappedSuperclass;

@MappedSuperclass
/*@Inheritance(strategy = InheritanceType.SINGLE_TABLE)*/
public abstract class Model implements Serializable{

	private static final long serialVersionUID = 3031695775597440046L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	protected Long id;
	
	@Column(name="part_number")
	protected String partNumber;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="prise")
	protected int prise; 
	
	@Column(name="previously_used")
	protected String previouslyUsed;
	
	@Column(name="equipment_manufacturer")
	protected String equipmentManufacturer;
	
	@Column(name="weight")
	protected int weight;
	
	@Column(name="width")
	protected int width;
	
	@Column(name="heigth")
	protected int heigth;
	
	@Column(name="depth")
	protected int depth;
	
	@Column(name="max_power_consumption")
	protected int maxPowerConsumption;
	
	@Column(name="description", columnDefinition="TEXT")
	protected String description;
	
	@Column(name="description_eng", columnDefinition="TEXT")
	protected String descriptionEng;
	
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

	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="path_pictures")
	private List<String> pathPictures = new ArrayList<String>();
	
	public Model(){
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

	public int getPrise() {
		return prise;
	}

	public void setPrise(int prise) {
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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
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

	@Override
	public String toString() {
		return "id=" + id + ", name=" + name + ", prise=" + prise + ", previouslyUsed=" + previouslyUsed
				+ ", partNumber=" + partNumber + ", equipmentManufacturer=" + equipmentManufacturer + ", weight="
				+ weight + ", width=" + width + ", heigth=" + heigth + ", depth=" + depth + ", maxPowerConsumption="
				+ maxPowerConsumption + ", pathPictures=" + pathPictures;
	}
	
}
