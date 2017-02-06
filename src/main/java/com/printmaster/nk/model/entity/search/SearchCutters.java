package com.printmaster.nk.model.entity.search;

import java.io.Serializable;

public class SearchCutters extends SearchGeneric implements Serializable{

private static final long serialVersionUID = 6702501013538481082L;
	
	private String[] typeCutter;
	private String[] previouslyUsed;
	private String[] typeOfCooling;
	private int sizeWorkAreaX0;
	private int sizeWorkAreaX1;
	private int sizeWorkAreaY0;
	private int sizeWorkAreaY1;
	private int sizeWorkAreaZ0;
	private int sizeWorkAreaZ1;	
	private String[] engravingStyle;
	private String[] typeEngine;
	private int mechanicalResolution0;
	private int mechanicalResolution1;
	private int softwareResolution0;
	private int softwareResolution1;
	private int frequencySpindle0;
	private int frequencySpindle1;
	private int processingSpeedXY0;
	private int processingSpeedXY1;
	private int processingSpeedZ0;
	private int processingSpeedZ1;
	private String[] mountingTool;
	private String[] connectionInterface;
	private String[] software;
	private String[] equipmentManufacturer;
	private int averagePowerConsumption0;
	private int averagePowerConsumption1;
	private int maxPowerConsumption0;
	private int maxPowerConsumption1;
	private double weight0;
	private double weight1;
	private int width0;
	private int width1;
	private int heigth0;
	private int heigth1;
	private int depth0;
	private int depth1;
	
	public SearchCutters(){}
	
	public int getAveragePowerConsumption0() {
		return averagePowerConsumption0;
	}

	public void setAveragePowerConsumption0(int averagePowerConsumption0) {
		this.averagePowerConsumption0 = averagePowerConsumption0;
	}

	public int getAveragePowerConsumption1() {
		return averagePowerConsumption1;
	}

	public void setAveragePowerConsumption1(int averagePowerConsumption1) {
		this.averagePowerConsumption1 = averagePowerConsumption1;
	}

	public String[] getTypeOfCooling() {
		return typeOfCooling;
	}

	public void setTypeOfCooling(String[] typeOfCooling) {
		this.typeOfCooling = typeOfCooling;
	}

	public String[] getTypeCutter() {
		return typeCutter;
	}

	public void setTypeCutter(String[] typeCutter) {
		this.typeCutter = typeCutter;
	}

	public String[] getPreviouslyUsed() {
		return previouslyUsed;
	}

	public void setPreviouslyUsed(String[] previouslyUsed) {
		this.previouslyUsed = previouslyUsed;
	}

	public int getSizeWorkAreaX0() {
		return sizeWorkAreaX0;
	}

	public void setSizeWorkAreaX0(int sizeWorkAreaX0) {
		this.sizeWorkAreaX0 = sizeWorkAreaX0;
	}

	public int getSizeWorkAreaX1() {
		return sizeWorkAreaX1;
	}

	public void setSizeWorkAreaX1(int sizeWorkAreaX1) {
		this.sizeWorkAreaX1 = sizeWorkAreaX1;
	}

	public int getSizeWorkAreaY0() {
		return sizeWorkAreaY0;
	}

	public void setSizeWorkAreaY0(int sizeWorkAreaY0) {
		this.sizeWorkAreaY0 = sizeWorkAreaY0;
	}

	public int getSizeWorkAreaY1() {
		return sizeWorkAreaY1;
	}

	public void setSizeWorkAreaY1(int sizeWorkAreaY1) {
		this.sizeWorkAreaY1 = sizeWorkAreaY1;
	}

	public int getSizeWorkAreaZ0() {
		return sizeWorkAreaZ0;
	}

	public void setSizeWorkAreaZ0(int sizeWorkAreaZ0) {
		this.sizeWorkAreaZ0 = sizeWorkAreaZ0;
	}

	public int getSizeWorkAreaZ1() {
		return sizeWorkAreaZ1;
	}

	public void setSizeWorkAreaZ1(int sizeWorkAreaZ1) {
		this.sizeWorkAreaZ1 = sizeWorkAreaZ1;
	}

	public String[] getEngravingStyle() {
		return engravingStyle;
	}

	public void setEngravingStyle(String[] engravingStyle) {
		this.engravingStyle = engravingStyle;
	}

	public String[] getTypeEngine() {
		return typeEngine;
	}

	public void setTypeEngine(String[] typeEngine) {
		this.typeEngine = typeEngine;
	}

	public int getMechanicalResolution0() {
		return mechanicalResolution0;
	}

	public void setMechanicalResolution0(int mechanicalResolution0) {
		this.mechanicalResolution0 = mechanicalResolution0;
	}

	public int getMechanicalResolution1() {
		return mechanicalResolution1;
	}

	public void setMechanicalResolution1(int mechanicalResolution1) {
		this.mechanicalResolution1 = mechanicalResolution1;
	}

	public int getSoftwareResolution0() {
		return softwareResolution0;
	}

	public void setSoftwareResolution0(int softwareResolution0) {
		this.softwareResolution0 = softwareResolution0;
	}

	public int getSoftwareResolution1() {
		return softwareResolution1;
	}

	public void setSoftwareResolution1(int softwareResolution1) {
		this.softwareResolution1 = softwareResolution1;
	}

	public int getFrequencySpindle0() {
		return frequencySpindle0;
	}

	public void setFrequencySpindle0(int frequencySpindle0) {
		this.frequencySpindle0 = frequencySpindle0;
	}

	public int getFrequencySpindle1() {
		return frequencySpindle1;
	}

	public void setFrequencySpindle1(int frequencySpindle1) {
		this.frequencySpindle1 = frequencySpindle1;
	}

	public int getProcessingSpeedXY0() {
		return processingSpeedXY0;
	}

	public void setProcessingSpeedXY0(int processingSpeedXY0) {
		this.processingSpeedXY0 = processingSpeedXY0;
	}

	public int getProcessingSpeedXY1() {
		return processingSpeedXY1;
	}

	public void setProcessingSpeedXY1(int processingSpeedXY1) {
		this.processingSpeedXY1 = processingSpeedXY1;
	}

	public int getProcessingSpeedZ0() {
		return processingSpeedZ0;
	}

	public void setProcessingSpeedZ0(int processingSpeedZ0) {
		this.processingSpeedZ0 = processingSpeedZ0;
	}

	public int getProcessingSpeedZ1() {
		return processingSpeedZ1;
	}

	public void setProcessingSpeedZ1(int processingSpeedZ1) {
		this.processingSpeedZ1 = processingSpeedZ1;
	}

	public String[] getMountingTool() {
		return mountingTool;
	}

	public void setMountingTool(String[] mountingTool) {
		this.mountingTool = mountingTool;
	}

	public String[] getConnectionInterface() {
		return connectionInterface;
	}

	public void setConnectionInterface(String[] connectionInterface) {
		this.connectionInterface = connectionInterface;
	}

	public String[] getSoftware() {
		return software;
	}

	public void setSoftware(String[] software) {
		this.software = software;
	}

	public String[] getEquipmentManufacturer() {
		return equipmentManufacturer;
	}

	public void setEquipmentManufacturer(String[] equipmentManufacturer) {
		this.equipmentManufacturer = equipmentManufacturer;
	}

	public int getMaxPowerConsumption0() {
		return maxPowerConsumption0;
	}

	public void setMaxPowerConsumption0(int maxPowerConsumption0) {
		this.maxPowerConsumption0 = maxPowerConsumption0;
	}

	public int getMaxPowerConsumption1() {
		return maxPowerConsumption1;
	}

	public void setMaxPowerConsumption1(int maxPowerConsumption1) {
		this.maxPowerConsumption1 = maxPowerConsumption1;
	}

	public double getWeight0() {
		return weight0;
	}

	public void setWeight0(double weight0) {
		this.weight0 = weight0;
	}

	public double getWeight1() {
		return weight1;
	}

	public void setWeight1(double weight1) {
		this.weight1 = weight1;
	}

	public int getWidth0() {
		return width0;
	}

	public void setWidth0(int width0) {
		this.width0 = width0;
	}

	public int getWidth1() {
		return width1;
	}

	public void setWidth1(int width1) {
		this.width1 = width1;
	}

	public int getHeigth0() {
		return heigth0;
	}

	public void setHeigth0(int heigth0) {
		this.heigth0 = heigth0;
	}

	public int getHeigth1() {
		return heigth1;
	}

	public void setHeigth1(int heigth1) {
		this.heigth1 = heigth1;
	}

	public int getDepth0() {
		return depth0;
	}

	public void setDepth0(int depth0) {
		this.depth0 = depth0;
	}

	public int getDepth1() {
		return depth1;
	}

	public void setDepth1(int depth1) {
		this.depth1 = depth1;
	}

	@Override
	public String[] getTypeProduct() {
		return getTypeCutter();
	}

	@Override
	public void setTypeProduct(String[] typeProduct) {
		setTypeCutter(typeProduct);
	}
	
}
