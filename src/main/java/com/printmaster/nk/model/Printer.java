package com.printmaster.nk.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="printer")
public class Printer extends Model{

	private static final long serialVersionUID = -7914406547800809890L;
	
	@Column(name="part_number")
	private String partNumber;
	
	@Column(name="name")
	private String name;
	
	@Column(name="type_printer")//тип принтера
	private String typePrinter;
	
	@Column(name="equipment_model")
	private String equipmentModel;
	
	@Column(name="prise")
	private int prise; 
	
	@Column(name="previously_used")
	private String previouslyUsed;
	
	@Column(name="weight_print_mm")
	private int weightPrintMM;
	
	@Column(name="type_print")
	private String[] typePrint;
	
	@Column(name="feed")
	private String[] feed;
	
	@Column(name="chromaticity")
	private String[] chromaticity;
	
	@Column(name="manufacturer_printhead")
	private String manufacturerPrinthead;
	
	@Column(name="type_of_printhead")
	private String typeOfPrinthead;
	
	@Column(name="compatible_ink")
	private String[] compatibleInk; 
	
	@Column(name="type_drops")
	private String[] typeDrops;
	
	@Column(name="size_drops")
	private String[] sizeDrops;
	
	@Column(name="speed_print")
	private int speedPrint;
	
	@Column(name="print_resolution")
	private String[] printResolution;
	
	@Column(name="equipment_manufacturer")
	private String equipmentManufacturer;
	
	@Column(name="interface_connection")
	private String[] interfaceConnection;
	
	@Column(name="maximum_media_thickness")
	private int maximumMediaThickness; 
	
	@Column(name="maximum_weight_of_vehicle")
	private int maximumWeightOfVehicle;
	
	@Column(name="rip")
	private String[] rip;
	
	@Column(name="max_power_consumption")
	private int maxPowerConsumption;
	
	@Column(name="weight")
	private int weight;
	
	@Column(name="width")
	private int width;
	
	@Column(name="heigth")
	private int heigth;
	
	@Column(name="depth")
	private int depth;
	
	@Column(name="description")
	private String description;
	
	@OneToMany(mappedBy="printer", fetch = FetchType.EAGER)
	private Set<OrderPrinter> orderPrinters = new HashSet<OrderPrinter>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@Column(name="path_pictures")
	private List<String> pathPictures = new ArrayList<String>();

	public Printer() {
		super();
	}

	public Printer(int id) {
		super(id);
	}

	public List<String> getPathPictures() {
		return pathPictures;
	}

	public void setPathPictures(List<String> pathPictures) {
		this.pathPictures = pathPictures;
	}

	public String getTypePrinter() {
		return typePrinter;
	}

	public void setTypePrinter(String typePrinter) {
		this.typePrinter = typePrinter;
	}

	/**
	 * @return the orderPrinters
	 */
	public Set<OrderPrinter> getOrderPrinters() {
		return orderPrinters;
	}

	/**
	 * @param orderPrinters the orderPrinters to set
	 */
	public void setOrderPrinters(Set<OrderPrinter> orderPrinters) {
		this.orderPrinters = orderPrinters;
	}

	/**
	 * @return the previouslyUsed
	 */
	public String getPreviouslyUsed() {
		return previouslyUsed;
	}

	/**
	 * @param previouslyUsed the previouslyUsed to set
	 */
	public void setPreviouslyUsed(String previouslyUsed) {
		this.previouslyUsed = previouslyUsed;
	}

	/**
	 * @return the typePrint
	 */
	public String[] getTypePrint() {
		return typePrint;
	}

	/**
	 * @param typePrint the typePrint to set
	 */
	public void setTypePrint(String[] typePrint) {
		this.typePrint = typePrint;
	}

	/**
	 * @return the feed
	 */
	public String[] getFeed() {
		return feed;
	}

	/**
	 * @param feed the feed to set
	 */
	public void setFeed(String[] feed) {
		this.feed = feed;
	}

	/**
	 * @return the chromaticity
	 */
	public String[] getChromaticity() {
		return chromaticity;
	}

	/**
	 * @param chromaticity the chromaticity to set
	 */
	public void setChromaticity(String[] chromaticity) {
		this.chromaticity = chromaticity;
	}

	/**
	 * @return the compatibleInk
	 */
	public String[] getCompatibleInk() {
		return compatibleInk;
	}

	/**
	 * @param compatibleInk the compatibleInk to set
	 */
	public void setCompatibleInk(String[] compatibleInk) {
		this.compatibleInk = compatibleInk;
	}

	/**
	 * @return the typeDrops
	 */
	public String[] getTypeDrops() {
		return typeDrops;
	}

	/**
	 * @param typeDrops the typeDrops to set
	 */
	public void setTypeDrops(String[] typeDrops) {
		this.typeDrops = typeDrops;
	}

	/**
	 * @return the sizeDrops
	 */
	public String[] getSizeDrops() {
		return sizeDrops;
	}

	/**
	 * @param sizeDrops the sizeDrops to set
	 */
	public void setSizeDrops(String[] sizeDrops) {
		this.sizeDrops = sizeDrops;
	}

	/**
	 * @return the printResolution
	 */
	public String[] getPrintResolution() {
		return printResolution;
	}

	/**
	 * @param printResolution the printResolution to set
	 */
	public void setPrintResolution(String[] printResolution) {
		this.printResolution = printResolution;
	}

	/**
	 * @return the interfaceConnection
	 */
	public String[] getInterfaceConnection() {
		return interfaceConnection;
	}

	/**
	 * @param interfaceConnection the interfaceConnection to set
	 */
	public void setInterfaceConnection(String[] interfaceConnection) {
		this.interfaceConnection = interfaceConnection;
	}

	/**
	 * @return the rip
	 */
	public String[] getRip() {
		return rip;
	}

	/**
	 * @param rip the rip to set
	 */
	public void setRip(String[] rip) {
		this.rip = rip;
	}

	/**
	 * @return the partNumber
	 */
	public String getPartNumber() {
		return partNumber;
	}

	/**
	 * @param partNumber the partNumber to set
	 */
	public void setPartNumber(String partNumber) {
		this.partNumber = partNumber;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the prise
	 */
	public int getPrise() {
		return prise;
	}

	/**
	 * @param prise the prise to set
	 */
	public void setPrise(int prise) {
		this.prise = prise;
	}

	/**
	 * @return the weightPrintMM
	 */
	public int getWeightPrintMM() {
		return weightPrintMM;
	}

	/**
	 * @param weightPrintMM the weightPrintMM to set
	 */
	public void setWeightPrintMM(int weightPrintMM) {
		this.weightPrintMM = weightPrintMM;
	}

	/**
	 * @return the manufacturerPrinthead
	 */
	public String getManufacturerPrinthead() {
		return manufacturerPrinthead;
	}

	/**
	 * @param manufacturerPrinthead the manufacturerPrinthead to set
	 */
	public void setManufacturerPrinthead(String manufacturerPrinthead) {
		this.manufacturerPrinthead = manufacturerPrinthead;
	}

	/**
	 * @return the typeOfPrinthead
	 */
	public String getTypeOfPrinthead() {
		return typeOfPrinthead;
	}

	/**
	 * @param typeOfPrinthead the typeOfPrinthead to set
	 */
	public void setTypeOfPrinthead(String typeOfPrinthead) {
		this.typeOfPrinthead = typeOfPrinthead;
	}

	/**
	 * @return the speedPrint
	 */
	public int getSpeedPrint() {
		return speedPrint;
	}

	/**
	 * @param speedPrint the speedPrint to set
	 */
	public void setSpeedPrint(int speedPrint) {
		this.speedPrint = speedPrint;
	}

	/**
	 * @return the equipmentManufacturer
	 */
	public String getEquipmentManufacturer() {
		return equipmentManufacturer;
	}

	/**
	 * @param equipmentManufacturer the equipmentManufacturer to set
	 */
	public void setEquipmentManufacturer(String equipmentManufacturer) {
		this.equipmentManufacturer = equipmentManufacturer;
	}

	/**
	 * @return the equipmentModel
	 */
	public String getEquipmentModel() {
		return equipmentModel;
	}

	/**
	 * @param equipmentModel the equipmentModel to set
	 */
	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	/**
	 * @return the maximumMediaThickness
	 */
	public int getMaximumMediaThickness() {
		return maximumMediaThickness;
	}

	/**
	 * @param maximumMediaThickness the maximumMediaThickness to set
	 */
	public void setMaximumMediaThickness(int maximumMediaThickness) {
		this.maximumMediaThickness = maximumMediaThickness;
	}

	/**
	 * @return the maximumWeightOfVehicle
	 */
	public int getMaximumWeightOfVehicle() {
		return maximumWeightOfVehicle;
	}

	/**
	 * @param maximumWeightOfVehicle the maximumWeightOfVehicle to set
	 */
	public void setMaximumWeightOfVehicle(int maximumWeightOfVehicle) {
		this.maximumWeightOfVehicle = maximumWeightOfVehicle;
	}

	/**
	 * @return the maxPowerConsumption
	 */
	public int getMaxPowerConsumption() {
		return maxPowerConsumption;
	}

	/**
	 * @param maxPowerConsumption the maxPowerConsumption to set
	 */
	public void setMaxPowerConsumption(int maxPowerConsumption) {
		this.maxPowerConsumption = maxPowerConsumption;
	}

	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the heigth
	 */
	public int getHeigth() {
		return heigth;
	}

	/**
	 * @param heigth the heigth to set
	 */
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}

	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Printer [partNumber=" + partNumber + ", name=" + name + ", equipmentModel=" + equipmentModel
				+ ", prise=" + prise + ", previouslyUsed=" + previouslyUsed + ", weightPrintMM=" + weightPrintMM
				+ ", typePrint=" + Arrays.toString(typePrint) + ", feed=" + Arrays.toString(feed) + ", chromaticity="
				+ Arrays.toString(chromaticity) + ", manufacturerPrinthead=" + manufacturerPrinthead
				+ ", typeOfPrinthead=" + typeOfPrinthead + ", compatibleInk=" + Arrays.toString(compatibleInk)
				+ ", typeDrops=" + Arrays.toString(typeDrops) + ", sizeDrops=" + Arrays.toString(sizeDrops)
				+ ", speedPrint=" + speedPrint + ", printResolution=" + Arrays.toString(printResolution)
				+ ", equipmentManufacturer=" + equipmentManufacturer + ", interfaceConnection="
				+ Arrays.toString(interfaceConnection) + ", maximumMediaThickness=" + maximumMediaThickness
				+ ", maximumWeightOfVehicle=" + maximumWeightOfVehicle + ", rip=" + Arrays.toString(rip)
				+ ", maxPowerConsumption=" + maxPowerConsumption + ", weight=" + weight + ", width=" + width
				+ ", heigth=" + heigth + ", depth=" + depth + ", description=" + description + ", orderPrinters="
				+ orderPrinters + "]";
	}

}