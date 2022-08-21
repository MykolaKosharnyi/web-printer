package com.mykoshar.shop.api.model.entity.search;

import java.io.Serializable;
import java.util.Arrays;

public class SearchScanners extends SearchGeneric implements Serializable {

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

	public SearchScanners() {
	}

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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SEARCH SCANNER details:");

		if (typeProduct != null && typeProduct.length > 0) {
			result.append(" typeProduct=" + Arrays.toString(typeProduct));
		}
		
		if (previouslyUsed != null && previouslyUsed.length > 0) {
			result.append(" previouslyUsed=" + Arrays.toString(previouslyUsed));
		}
		
		if (scanningWidth != null && scanningWidth.length > 0) {
			result.append(" scanningWidth=" + Arrays.toString(scanningWidth));
		}
		
		if (innings != null && innings.length > 0) {
			result.append(" innings=" + Arrays.toString(innings));
		}
		
		if (chromaticity != null && chromaticity.length > 0) {
			result.append(" chromaticity=" + Arrays.toString(chromaticity));
		}
		
		if (scanningElement != null && scanningElement.length > 0) {
			result.append(" scanningElement=" + Arrays.toString(scanningElement));
		}
		
		if (lightSource != null && lightSource.length > 0) {
			result.append(" lightSource=" + Arrays.toString(lightSource));
		}
		
		if (bitColorScanning != null && bitColorScanning.length > 0) {
			result.append(" bitColorScanning=" + Arrays.toString(bitColorScanning));
		}
		
		if (bitScanningGrayscale != null && bitScanningGrayscale.length > 0) {
			result.append(" bitScanningGrayscale=" + Arrays.toString(bitScanningGrayscale));
		}
		
		if(softwareResolution0 > 0){
			result.append(" softwareResolution0=" + softwareResolution0);
		}
		
		if(softwareResolution1 > 0){
			result.append(" softwareResolution1=" + softwareResolution1);
		}
		
		if(scanSpeed0 > 0){
			result.append(" scanSpeed0=" + scanSpeed0);
		}
		
		if(scanSpeed1 > 0){
			result.append(" scanSpeed1=" + scanSpeed1);
		}

		if (opticalResolution != null && opticalResolution.length > 0) {
			result.append(" opticalResolution=" + Arrays.toString(opticalResolution));
		}
		
		if (connectionInterface != null && connectionInterface.length > 0) {
			result.append(" connectionInterface=" + Arrays.toString(connectionInterface));
		}
		
		if(theMaximumThicknessOfTheCarrier0 > 0){
			result.append(" theMaximumThicknessOfTheCarrier0=" + theMaximumThicknessOfTheCarrier0);
		}
		
		if(theMaximumThicknessOfTheCarrier1 > 0){
			result.append(" theMaximumThicknessOfTheCarrier1=" + theMaximumThicknessOfTheCarrier1);
		}
		
		if (software != null && software.length > 0) {
			result.append(" software=" + Arrays.toString(software));
		}
		
		if (equipmentManufacturer != null && equipmentManufacturer.length > 0) {
			result.append(" equipmentManufacturer=" + Arrays.toString(equipmentManufacturer));
		}
		
		if(averagePowerConsumption0 > 0){
			result.append(" averagePowerConsumption0=" + averagePowerConsumption0);
		}
		
		if(averagePowerConsumption1 > 0){
			result.append(" averagePowerConsumption1=" + averagePowerConsumption1);
		}
		
		if(maxPowerConsumption0 > 0){
			result.append(" maxPowerConsumption0=" + maxPowerConsumption0);
		}
		
		if(maxPowerConsumption1 > 0){
			result.append(" maxPowerConsumption1=" + maxPowerConsumption1);
		}
		
		if(weight0 > 0){
			result.append(" weight0=" + weight0);
		}
		
		if(weight1 > 0){
			result.append(" weight1=" + weight1);
		}
		
		if(width0 > 0){
			result.append(" width0=" + width0);
		}
		
		if(width1 > 0){
			result.append(" width1=" + width1);
		}
		
		if(heigth0 > 0){
			result.append(" heigth0=" + heigth0);
		}
		
		if(heigth1 > 0){
			result.append(" heigth1=" + heigth1);
		}
		
		if(depth0 > 0){
			result.append(" depth0=" + depth0);
		}
		
		if(depth1 > 0){
			result.append(" depth1=" + depth1);
		}
		
		return result.toString();
	}

}
