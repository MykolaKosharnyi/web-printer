package com.printmaster.nk.model.entity.search;

import java.io.Serializable;
import java.util.Arrays;

public class SearchPrinters extends SearchGeneric implements Serializable{

	private static final long serialVersionUID = 6702501013538481082L;
	
	private String[] typePrinter;
	private String[] weightPrintMM;
	private int weightPrintMMRangeFrom;
	private int weightPrintMMRangeUntil;
	private String[] previouslyUsed;
	private String[] typePrint;
	private String[] feed;
	private String[] chromaticity;
	private String[] manufacturerPrinthead;
	private String[] typeOfPrinthead;
	private String[] typeOfPrintheadSeries;
	private String[] compatibleInk; 
	private String[] typeDrops;
	private double sizeDropRangeFrom;
	private double sizeDropRangeUntil;
	private String[] sizeDrops;
	private int speedPrint0;
	private int speedPrint1;
	private String[] printResolution;
	private String[] equipmentManufacturer;
	private String[] interfaceConnection;
	private int maximumMediaThickness60_0;
	private int maximumMediaThickness60_1;
	private int maximumMediaThickness500_0;
	private int maximumMediaThickness500_1;
	private int maximumWeightOfVehicle0;
	private int maximumWeightOfVehicle1;
	private String[] rip;
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
	
	public SearchPrinters() {}

	@Override
	public String toString() {
		return "SearchPrinters [typePrinter="
				+ Arrays.toString(typePrinter) + ", weightPrintMM=" + Arrays.toString(weightPrintMM)
				+ ", previouslyUsed=" + Arrays.toString(previouslyUsed) + ", typePrint=" + Arrays.toString(typePrint)
				+ ", feed=" + Arrays.toString(feed) + ", chromaticity=" + Arrays.toString(chromaticity)
				+ ", manufacturerPrinthead=" + Arrays.toString(manufacturerPrinthead) + ", typeOfPrinthead="
				+ Arrays.toString(typeOfPrinthead) + ", compatibleInk=" + Arrays.toString(compatibleInk)
				+ ", typeDrops=" + Arrays.toString(typeDrops) + ", sizeDrops=" + Arrays.toString(sizeDrops)
				+ ", speedPrint0=" + speedPrint0 + ", speedPrint1=" + speedPrint1 + ", printResolution="
				+ Arrays.toString(printResolution) + ", equipmentManufacturer=" + Arrays.toString(equipmentManufacturer)
				+ ", interfaceConnection=" + Arrays.toString(interfaceConnection) + ", maximumMediaThickness60_0="
				+ maximumMediaThickness60_0 + ", maximumMediaThickness60_1=" + maximumMediaThickness60_1
				+ ", maximumMediaThickness500_0=" + maximumMediaThickness500_0 + ", maximumMediaThickness500_1="
				+ maximumMediaThickness500_1 + ", maximumWeightOfVehicle0=" + maximumWeightOfVehicle0
				+ ", maximumWeightOfVehicle1=" + maximumWeightOfVehicle1 + ", rip=" + Arrays.toString(rip)
				+ ", maxPowerConsumption0=" + maxPowerConsumption0 + ", maxPowerConsumption1=" + maxPowerConsumption1
				+ ", weight0=" + weight0 + ", weight1=" + weight1 + ", width0=" + width0 + ", width1=" + width1
				+ ", heigth0=" + heigth0 + ", heigth1=" + heigth1 + ", depth0=" + depth0 + ", depth1=" + depth1 + "]";
	}
	
	public int getWeightPrintMMRangeFrom() {
		return weightPrintMMRangeFrom;
	}

	public void setWeightPrintMMRangeFrom(int weightPrintMMRangeFrom) {
		this.weightPrintMMRangeFrom = weightPrintMMRangeFrom;
	}

	public int getWeightPrintMMRangeUntil() {
		return weightPrintMMRangeUntil;
	}

	public void setWeightPrintMMRangeUntil(int weightPrintMMRangeUntil) {
		this.weightPrintMMRangeUntil = weightPrintMMRangeUntil;
	}

	public String[] getTypeOfPrintheadSeries() {
		return typeOfPrintheadSeries;
	}

	public void setTypeOfPrintheadSeries(String[] typeOfPrintheadSeries) {
		this.typeOfPrintheadSeries = typeOfPrintheadSeries;
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

	public double getSizeDropRangeFrom() {
		return sizeDropRangeFrom;
	}

	public void setSizeDropRangeFrom(double sizeDropRangeFrom) {
		this.sizeDropRangeFrom = sizeDropRangeFrom;
	}

	public double getSizeDropRangeUntil() {
		return sizeDropRangeUntil;
	}

	public void setSizeDropRangeUntil(double sizeDropRangeUntil) {
		this.sizeDropRangeUntil = sizeDropRangeUntil;
	}

	public String[] getWeightPrintMM() {
		return weightPrintMM;
	}
	public void setWeightPrintMM(String[] weightPrintMM) {
		this.weightPrintMM = weightPrintMM;
	}
	
	public String[] getTypePrinter() {
		return typePrinter;
	}
	public void setTypePrinter(String[] typePrinter) {
		this.typePrinter = typePrinter;
	}
	public String[] getPreviouslyUsed() {
		return previouslyUsed;
	}
	public void setPreviouslyUsed(String[] previouslyUsed) {
		this.previouslyUsed = previouslyUsed;
	}
	public String[] getTypePrint() {
		return typePrint;
	}
	public void setTypePrint(String[] typePrint) {
		this.typePrint = typePrint;
	}
	public String[] getFeed() {
		return feed;
	}
	public void setFeed(String[] feed) {
		this.feed = feed;
	}
	public String[] getChromaticity() {
		return chromaticity;
	}
	public void setChromaticity(String[] chromaticity) {
		this.chromaticity = chromaticity;
	}
	public String[] getManufacturerPrinthead() {
		return manufacturerPrinthead;
	}
	public void setManufacturerPrinthead(String[] manufacturerPrinthead) {
		this.manufacturerPrinthead = manufacturerPrinthead;
	}
	public String[] getTypeOfPrinthead() {
		return typeOfPrinthead;
	}
	public void setTypeOfPrinthead(String[] typeOfPrinthead) {
		this.typeOfPrinthead = typeOfPrinthead;
	}
	public String[] getCompatibleInk() {
		return compatibleInk;
	}
	public void setCompatibleInk(String[] compatibleInk) {
		this.compatibleInk = compatibleInk;
	}
	public String[] getTypeDrops() {
		return typeDrops;
	}
	public void setTypeDrops(String[] typeDrops) {
		this.typeDrops = typeDrops;
	}
	public String[] getSizeDrops() {
		return sizeDrops;
	}
	public void setSizeDrops(String[] sizeDrops) {
		this.sizeDrops = sizeDrops;
	}
	public int getSpeedPrint0() {
		return speedPrint0;
	}
	public void setSpeedPrint0(int speedPrint0) {
		this.speedPrint0 = speedPrint0;
	}
	public int getSpeedPrint1() {
		return speedPrint1;
	}
	public void setSpeedPrint1(int speedPrint1) {
		this.speedPrint1 = speedPrint1;
	}
	public String[] getPrintResolution() {
		return printResolution;
	}
	public void setPrintResolution(String[] printResolution) {
		this.printResolution = printResolution;
	}
	public String[] getEquipmentManufacturer() {
		return equipmentManufacturer;
	}
	public void setEquipmentManufacturer(String[] equipmentManufacturer) {
		this.equipmentManufacturer = equipmentManufacturer;
	}
	public String[] getInterfaceConnection() {
		return interfaceConnection;
	}
	public void setInterfaceConnection(String[] interfaceConnection) {
		this.interfaceConnection = interfaceConnection;
	}
	public int getMaximumMediaThickness60_0() {
		return maximumMediaThickness60_0;
	}
	public void setMaximumMediaThickness60_0(int maximumMediaThickness60_0) {
		this.maximumMediaThickness60_0 = maximumMediaThickness60_0;
	}
	public int getMaximumMediaThickness60_1() {
		return maximumMediaThickness60_1;
	}
	public void setMaximumMediaThickness60_1(int maximumMediaThickness60_1) {
		this.maximumMediaThickness60_1 = maximumMediaThickness60_1;
	}
	public int getMaximumMediaThickness500_0() {
		return maximumMediaThickness500_0;
	}
	public void setMaximumMediaThickness500_0(int maximumMediaThickness500_0) {
		this.maximumMediaThickness500_0 = maximumMediaThickness500_0;
	}
	public int getMaximumMediaThickness500_1() {
		return maximumMediaThickness500_1;
	}
	public void setMaximumMediaThickness500_1(int maximumMediaThickness500_1) {
		this.maximumMediaThickness500_1 = maximumMediaThickness500_1;
	}
	public int getMaximumWeightOfVehicle0() {
		return maximumWeightOfVehicle0;
	}
	public void setMaximumWeightOfVehicle0(int maximumWeightOfVehicle0) {
		this.maximumWeightOfVehicle0 = maximumWeightOfVehicle0;
	}
	public int getMaximumWeightOfVehicle1() {
		return maximumWeightOfVehicle1;
	}
	public void setMaximumWeightOfVehicle1(int maximumWeightOfVehicle1) {
		this.maximumWeightOfVehicle1 = maximumWeightOfVehicle1;
	}
	public String[] getRip() {
		return rip;
	}
	public void setRip(String[] rip) {
		this.rip = rip;
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
		return getTypePrinter();
	}

	@Override
	public void setTypeProduct(String[] typeProduct) {
		setTypePrinter(typeProduct);
	}
	
}
