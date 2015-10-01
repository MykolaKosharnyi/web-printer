package com.nk.printmaster.entities;

import java.io.Serializable;

public class Printer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7914406547800809890L;
	
	private int id;
	private String partNumber;// партийный номер
	private String name;// название
	private int prise;// цена товара в долларах
	private boolean isNew;// новый или Б/У
	private int weightPrintMM;// ширина печати в миллиметрах
	private String typePrint;// тип печати
	private String feed; // подача материала
	private String chromaticity;// цветность
	private String manufacturerPrinthead;// производитель печатающей головки
	private String typeOfPrinthead;// тип печатающей головки
	private String compatibleInk;// совместимые чернила
	private String typeDrops;// тип капли
	private int sizeDrops;// размер капли
	private int speedPrint;// скорость печати
	private String printResolution;// разрешение печати
	private String equipmentManufacturer;// производитель оборудования
	private String equipmentModel;// модель оборудования
	private String interfaceConnection;// интерфейс подключения
	private int maximumMediaThickness;// максимальная толщина носителя
	private int maximumWeightOfVehicle;// максимальный вес носителя
	private String rip;// программное обеспечение RIP
	private int maxPowerConsumption;// максимальная потребляемая мощность
	private int weight;// вес
	private int width;// ширина
	private int heigth;// высота
	private int depth;// глубина
	private String description;// описание

	public Printer() {
	}

	public Printer(int id, String partNumber, String name, int prise, boolean isNew, int weightPrintMM,
			String typePrint, String feed, String chromaticity, String manufacturerPrinthead, String typeOfPrinthead,
			String compatibleInk, String typeDrops, int sizeDrops, int speedPrint, String printResolution,
			String equipmentManufacturer, String equipmentModel, String interfaceConnection, int maximumMediaThickness,
			int maximumWeightOfVehicle, String rip, int maxPowerConsumption, int weight, int width, int heigth,
			int depth, String description) {
		this.id = id;
		this.partNumber = partNumber;
		this.name = name;
		this.prise = prise;
		this.isNew = isNew;
		this.weightPrintMM = weightPrintMM;
		this.typePrint = typePrint;
		this.feed = feed;
		this.chromaticity = chromaticity;
		this.manufacturerPrinthead = manufacturerPrinthead;
		this.typeOfPrinthead = typeOfPrinthead;
		this.compatibleInk = compatibleInk;
		this.typeDrops = typeDrops;
		this.sizeDrops = sizeDrops;
		this.speedPrint = speedPrint;
		this.printResolution = printResolution;
		this.equipmentManufacturer = equipmentManufacturer;
		this.equipmentModel = equipmentModel;
		this.interfaceConnection = interfaceConnection;
		this.maximumMediaThickness = maximumMediaThickness;
		this.maximumWeightOfVehicle = maximumWeightOfVehicle;
		this.rip = rip;
		this.maxPowerConsumption = maxPowerConsumption;
		this.weight = weight;
		this.width = width;
		this.heigth = heigth;
		this.depth = depth;
		this.description = description;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the isNew
	 */
	public boolean isNew() {
		return isNew;
	}

	/**
	 * @param isNew the isNew to set
	 */
	public void setNew(boolean isNew) {
		this.isNew = isNew;
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
	 * @return the typePrint
	 */
	public String getTypePrint() {
		return typePrint;
	}

	/**
	 * @param typePrint the typePrint to set
	 */
	public void setTypePrint(String typePrint) {
		this.typePrint = typePrint;
	}

	/**
	 * @return the feed
	 */
	public String getFeed() {
		return feed;
	}

	/**
	 * @param feed the feed to set
	 */
	public void setFeed(String feed) {
		this.feed = feed;
	}

	/**
	 * @return the chromaticity
	 */
	public String getChromaticity() {
		return chromaticity;
	}

	/**
	 * @param chromaticity the chromaticity to set
	 */
	public void setChromaticity(String chromaticity) {
		this.chromaticity = chromaticity;
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
	 * @return the compatibleInk
	 */
	public String getCompatibleInk() {
		return compatibleInk;
	}

	/**
	 * @param compatibleInk the compatibleInk to set
	 */
	public void setCompatibleInk(String compatibleInk) {
		this.compatibleInk = compatibleInk;
	}

	/**
	 * @return the typeDrops
	 */
	public String getTypeDrops() {
		return typeDrops;
	}

	/**
	 * @param typeDrops the typeDrops to set
	 */
	public void setTypeDrops(String typeDrops) {
		this.typeDrops = typeDrops;
	}

	/**
	 * @return the sizeDrops
	 */
	public int getSizeDrops() {
		return sizeDrops;
	}

	/**
	 * @param sizeDrops the sizeDrops to set
	 */
	public void setSizeDrops(int sizeDrops) {
		this.sizeDrops = sizeDrops;
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
	 * @return the printResolution
	 */
	public String getPrintResolution() {
		return printResolution;
	}

	/**
	 * @param printResolution the printResolution to set
	 */
	public void setPrintResolution(String printResolution) {
		this.printResolution = printResolution;
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
	 * @return the interfaceConnection
	 */
	public String getInterfaceConnection() {
		return interfaceConnection;
	}

	/**
	 * @param interfaceConnection the interfaceConnection to set
	 */
	public void setInterfaceConnection(String interfaceConnection) {
		this.interfaceConnection = interfaceConnection;
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
	 * @return the rip
	 */
	public String getRip() {
		return rip;
	}

	/**
	 * @param rip the rip to set
	 */
	public void setRip(String rip) {
		this.rip = rip;
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

}