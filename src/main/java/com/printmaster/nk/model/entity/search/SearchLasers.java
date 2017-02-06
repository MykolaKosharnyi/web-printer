package com.printmaster.nk.model.entity.search;

import java.io.Serializable;

public class SearchLasers extends SearchGeneric implements Serializable{

	private static final long serialVersionUID = 6702501013538481082L;
	
	private String[] typeLaser;
	private String[] typeOfCooling;
	private int sizeWorkAreaX0;
	private int sizeWorkAreaX1;
	private int sizeWorkAreaY0;
	private int sizeWorkAreaY1;
	private int sizeWorkAreaZ0;
	private int sizeWorkAreaZ1;	
	private String[] previouslyUsed;
	private int powerOfLaser0;
	private int powerOfLaser1;
	private String[] typeEngine;
	private int mechanicalResolution0;
	private int mechanicalResolution1;
	private int softwareResolution0;
	private int softwareResolution1;
	private double minimumThicknessOfCut0;
	private double minimumThicknessOfCut1;
	private int engravingSpeed0;
	private int engravingSpeed1;
	private int cuttingSpeed0;
	private int cuttingSpeed1;
	private String[] connectionInterface;
	private String[] fileTypes;
	private String[] software;
	private String[] equipmentManufacturer;
	private String[] colorSeparation;
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
	private String[] typeTheDisplayedImage;
	private int maximumResolution0;
	private int maximumResolution1;
	private int firstPartAdjustingTheLaserPower;
	private int secondPartAdjustingTheLaserPower;
	private int laserWavelength0;
	private int laserWavelength1;
	private int laserPulse0;
	private int laserPulse1;
	private int theDiameterOfTheLaser0;
	private int theDiameterOfTheLaser1;
	private int engravingDepth0;
	private int engravingDepth1;
	private int laserSource0;
	private int laserSource1;
	private String[] specialPurpose;
	
	public SearchLasers(){}

	public String[] getSpecialPurpose() {
		return specialPurpose;
	}

	public void setSpecialPurpose(String[] specialPurpose) {
		this.specialPurpose = specialPurpose;
	}

	public int getLaserSource0() {
		return laserSource0;
	}

	public void setLaserSource0(int laserSource0) {
		this.laserSource0 = laserSource0;
	}

	public int getLaserSource1() {
		return laserSource1;
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

	public void setLaserSource1(int laserSource1) {
		this.laserSource1 = laserSource1;
	}

	public int getEngravingDepth0() {
		return engravingDepth0;
	}

	public void setEngravingDepth0(int engravingDepth0) {
		this.engravingDepth0 = engravingDepth0;
	}

	public int getEngravingDepth1() {
		return engravingDepth1;
	}

	public void setEngravingDepth1(int engravingDepth1) {
		this.engravingDepth1 = engravingDepth1;
	}

	public int getTheDiameterOfTheLaser0() {
		return theDiameterOfTheLaser0;
	}

	public void setTheDiameterOfTheLaser0(int theDiameterOfTheLaser0) {
		this.theDiameterOfTheLaser0 = theDiameterOfTheLaser0;
	}

	public int getTheDiameterOfTheLaser1() {
		return theDiameterOfTheLaser1;
	}

	public void setTheDiameterOfTheLaser1(int theDiameterOfTheLaser1) {
		this.theDiameterOfTheLaser1 = theDiameterOfTheLaser1;
	}

	public int getLaserPulse0() {
		return laserPulse0;
	}

	public void setLaserPulse0(int laserPulse0) {
		this.laserPulse0 = laserPulse0;
	}

	public int getLaserPulse1() {
		return laserPulse1;
	}

	public void setLaserPulse1(int laserPulse1) {
		this.laserPulse1 = laserPulse1;
	}

	public int getLaserWavelength0() {
		return laserWavelength0;
	}

	public void setLaserWavelength0(int laserWavelength0) {
		this.laserWavelength0 = laserWavelength0;
	}

	public int getLaserWavelength1() {
		return laserWavelength1;
	}

	public void setLaserWavelength1(int laserWavelength1) {
		this.laserWavelength1 = laserWavelength1;
	}

	public int getFirstPartAdjustingTheLaserPower() {
		return firstPartAdjustingTheLaserPower;
	}

	public void setFirstPartAdjustingTheLaserPower(int firstPartAdjustingTheLaserPower) {
		this.firstPartAdjustingTheLaserPower = firstPartAdjustingTheLaserPower;
	}

	public int getSecondPartAdjustingTheLaserPower() {
		return secondPartAdjustingTheLaserPower;
	}

	public void setSecondPartAdjustingTheLaserPower(int secondPartAdjustingTheLaserPower) {
		this.secondPartAdjustingTheLaserPower = secondPartAdjustingTheLaserPower;
	}

	public int getMaximumResolution0() {
		return maximumResolution0;
	}

	public void setMaximumResolution0(int maximumResolution0) {
		this.maximumResolution0 = maximumResolution0;
	}

	public int getMaximumResolution1() {
		return maximumResolution1;
	}

	public void setMaximumResolution1(int maximumResolution1) {
		this.maximumResolution1 = maximumResolution1;
	}

	public String[] getTypeTheDisplayedImage() {
		return typeTheDisplayedImage;
	}

	public void setTypeTheDisplayedImage(String[] typeTheDisplayedImage) {
		this.typeTheDisplayedImage = typeTheDisplayedImage;
	}

	public String[] getColorSeparation() {
		return colorSeparation;
	}

	public void setColorSeparation(String[] colorSeparation) {
		this.colorSeparation = colorSeparation;
	}

	public String[] getTypeOfCooling() {
		return typeOfCooling;
	}

	public void setTypeOfCooling(String[] typeOfCooling) {
		this.typeOfCooling = typeOfCooling;
	}

	public String[] getTypeLaser() {
		return typeLaser;
	}

	public void setTypeLaser(String[] typeLaser) {
		this.typeLaser = typeLaser;
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

	public String[] getPreviouslyUsed() {
		return previouslyUsed;
	}

	public void setPreviouslyUsed(String[] previouslyUsed) {
		this.previouslyUsed = previouslyUsed;
	}

	public int getPowerOfLaser0() {
		return powerOfLaser0;
	}

	public void setPowerOfLaser0(int powerOfLaser0) {
		this.powerOfLaser0 = powerOfLaser0;
	}

	public int getPowerOfLaser1() {
		return powerOfLaser1;
	}

	public void setPowerOfLaser1(int powerOfLaser1) {
		this.powerOfLaser1 = powerOfLaser1;
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

	public double getMinimumThicknessOfCut0() {
		return minimumThicknessOfCut0;
	}

	public void setMinimumThicknessOfCut0(double minimumThicknessOfCut0) {
		this.minimumThicknessOfCut0 = minimumThicknessOfCut0;
	}

	public double getMinimumThicknessOfCut1() {
		return minimumThicknessOfCut1;
	}

	public void setMinimumThicknessOfCut1(double minimumThicknessOfCut1) {
		this.minimumThicknessOfCut1 = minimumThicknessOfCut1;
	}

	public int getEngravingSpeed0() {
		return engravingSpeed0;
	}

	public void setEngravingSpeed0(int engravingSpeed0) {
		this.engravingSpeed0 = engravingSpeed0;
	}

	public int getEngravingSpeed1() {
		return engravingSpeed1;
	}

	public void setEngravingSpeed1(int engravingSpeed1) {
		this.engravingSpeed1 = engravingSpeed1;
	}

	public int getCuttingSpeed0() {
		return cuttingSpeed0;
	}

	public void setCuttingSpeed0(int cuttingSpeed0) {
		this.cuttingSpeed0 = cuttingSpeed0;
	}

	public int getCuttingSpeed1() {
		return cuttingSpeed1;
	}

	public void setCuttingSpeed1(int cuttingSpeed1) {
		this.cuttingSpeed1 = cuttingSpeed1;
	}

	public String[] getConnectionInterface() {
		return connectionInterface;
	}

	public void setConnectionInterface(String[] connectionInterface) {
		this.connectionInterface = connectionInterface;
	}

	public String[] getFileTypes() {
		return fileTypes;
	}

	public void setFileTypes(String[] fileTypes) {
		this.fileTypes = fileTypes;
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
		return getTypeLaser();
	}

	@Override
	public void setTypeProduct(String[] typeProduct) {
		setTypeLaser(typeProduct);
	}

}
