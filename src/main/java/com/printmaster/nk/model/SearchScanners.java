package com.printmaster.nk.model;

import java.io.Serializable;

public class SearchScanners extends SearchGeneric implements Serializable{

private static final long serialVersionUID = 6702501013538481082L;

private String[] typeProduct;
private String[] previouslyUsed;
private String[] scanningWidth;
private String[] innings;
private String[] chromaticity;
private String[] scanningElement;
private String[] lightSource;
private String[] bitColorScanning;
private String[] bitScanningGrayscale;
private int softwareResolution0;
private int softwareResolution1;
private int scanSpeed0;
private int scanSpeed1;
private String[] opticalResolution;
private String[] connectionInterface;
private int theMaximumThicknessOfTheCarrier0;
private int theMaximumThicknessOfTheCarrier1;
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

public SearchScanners(){}

public String[] getTypeProduct() {
	return typeProduct;
}

public void setTypeProduct(String[] typeProduct) {
	this.typeProduct = typeProduct;
}

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

public String[] getPreviouslyUsed() {
	return previouslyUsed;
}

public void setPreviouslyUsed(String[] previouslyUsed) {
	this.previouslyUsed = previouslyUsed;
}

public String[] getScanningWidth() {
	return scanningWidth;
}

public void setScanningWidth(String[] scanningWidth) {
	this.scanningWidth = scanningWidth;
}

public String[] getInnings() {
	return innings;
}

public void setInnings(String[] innings) {
	this.innings = innings;
}

public String[] getChromaticity() {
	return chromaticity;
}

public void setChromaticity(String[] chromaticity) {
	this.chromaticity = chromaticity;
}

public String[] getScanningElement() {
	return scanningElement;
}

public void setScanningElement(String[] scanningElement) {
	this.scanningElement = scanningElement;
}

public String[] getLightSource() {
	return lightSource;
}

public void setLightSource(String[] lightSource) {
	this.lightSource = lightSource;
}

public String[] getBitColorScanning() {
	return bitColorScanning;
}

public void setBitColorScanning(String[] bitColorScanning) {
	this.bitColorScanning = bitColorScanning;
}

public String[] getBitScanningGrayscale() {
	return bitScanningGrayscale;
}

public void setBitScanningGrayscale(String[] bitScanningGrayscale) {
	this.bitScanningGrayscale = bitScanningGrayscale;
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

public int getScanSpeed0() {
	return scanSpeed0;
}

public void setScanSpeed0(int scanSpeed0) {
	this.scanSpeed0 = scanSpeed0;
}

public int getScanSpeed1() {
	return scanSpeed1;
}

public void setScanSpeed1(int scanSpeed1) {
	this.scanSpeed1 = scanSpeed1;
}

public String[] getOpticalResolution() {
	return opticalResolution;
}

public void setOpticalResolution(String[] opticalResolution) {
	this.opticalResolution = opticalResolution;
}

public String[] getConnectionInterface() {
	return connectionInterface;
}

public void setConnectionInterface(String[] connectionInterface) {
	this.connectionInterface = connectionInterface;
}

public int getTheMaximumThicknessOfTheCarrier0() {
	return theMaximumThicknessOfTheCarrier0;
}

public void setTheMaximumThicknessOfTheCarrier0(int theMaximumThicknessOfTheCarrier0) {
	this.theMaximumThicknessOfTheCarrier0 = theMaximumThicknessOfTheCarrier0;
}

public int getTheMaximumThicknessOfTheCarrier1() {
	return theMaximumThicknessOfTheCarrier1;
}

public void setTheMaximumThicknessOfTheCarrier1(int theMaximumThicknessOfTheCarrier1) {
	this.theMaximumThicknessOfTheCarrier1 = theMaximumThicknessOfTheCarrier1;
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

}
