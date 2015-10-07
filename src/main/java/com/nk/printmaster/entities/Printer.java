package com.nk.printmaster.entities;

import java.io.Serializable;

public class Printer implements Serializable{

	private static final long serialVersionUID = -7914406547800809890L;
	
//	private int id;
	private String printerName;//
	private String printerPartNumber;// 
	private int printerPrise;// 
	private boolean printerIsNew;// 
	private int printerWeightPrintMM;//
	private String printerTypePrint;//
	private String printerFeed; // 
	private String printerChromaticity;//
	private String printerManufacturerPrinthead;//
	private String printerTypeOfPrinthead;// 
	private String printerCompatibleInk;// 
	private String printerTypeDrops;//
	private int printerSizeDrops;// 
	private int printerSpeedPrint;//
	private String printerPrintResolution;// 
	private String printerEquipmentManufacturer;//
	private String printerEquipmentModel;// 
	private String printerInterfaceConnection;//
	private int printerMaximumMediaThickness;// 
	private int printerMaximumWeightOfVehicle;// 
	private String printerRip;// 
	private int printerMaxPowerConsumption;//
	private int printerWeight;//
	private int printerWidth;//
	private int printerHeigth;//
	private int printerDepth;//
	private String printerDescription;// 

	public Printer() {
	}

	/**
	 * @return the printerPartNumber
	 */
	public String getPrinterPartNumber() {
		return printerPartNumber;
	}

	/**
	 * @param printerPartNumber the printerPartNumber to set
	 */
	public void setPrinterPartNumber(String printerPartNumber) {
		this.printerPartNumber = printerPartNumber;
	}

	/**
	 * @return the printerName
	 */
	public String getPrinterName() {
		return printerName;
	}

	/**
	 * @param printerName the printerName to set
	 */
	public void setPrinterName(String printerName) {
		this.printerName = printerName;
	}

	/**
	 * @return the printerPrise
	 */
	public int getPrinterPrise() {
		return printerPrise;
	}

	/**
	 * @param printerPrise the printerPrise to set
	 */
	public void setPrinterPrise(int printerPrise) {
		this.printerPrise = printerPrise;
	}

	/**
	 * @return the printerIsNew
	 */
	public boolean isPrinterIsNew() {
		return printerIsNew;
	}

	/**
	 * @param printerIsNew the printerIsNew to set
	 */
	public void setPrinterIsNew(boolean printerIsNew) {
		this.printerIsNew = printerIsNew;
	}

	/**
	 * @return the printerWeightPrintMM
	 */
	public int getPrinterWeightPrintMM() {
		return printerWeightPrintMM;
	}

	/**
	 * @param printerWeightPrintMM the printerWeightPrintMM to set
	 */
	public void setPrinterWeightPrintMM(int printerWeightPrintMM) {
		this.printerWeightPrintMM = printerWeightPrintMM;
	}

	/**
	 * @return the printerTypePrint
	 */
	public String getPrinterTypePrint() {
		return printerTypePrint;
	}

	/**
	 * @param printerTypePrint the printerTypePrint to set
	 */
	public void setPrinterTypePrint(String printerTypePrint) {
		this.printerTypePrint = printerTypePrint;
	}

	/**
	 * @return the printerFeed
	 */
	public String getPrinterFeed() {
		return printerFeed;
	}

	/**
	 * @param printerFeed the printerFeed to set
	 */
	public void setPrinterFeed(String printerFeed) {
		this.printerFeed = printerFeed;
	}

	/**
	 * @return the printerChromaticity
	 */
	public String getPrinterChromaticity() {
		return printerChromaticity;
	}

	/**
	 * @param printerChromaticity the printerChromaticity to set
	 */
	public void setPrinterChromaticity(String printerChromaticity) {
		this.printerChromaticity = printerChromaticity;
	}

	/**
	 * @return the printerManufacturerPrinthead
	 */
	public String getPrinterManufacturerPrinthead() {
		return printerManufacturerPrinthead;
	}

	/**
	 * @param printerManufacturerPrinthead the printerManufacturerPrinthead to set
	 */
	public void setPrinterManufacturerPrinthead(String printerManufacturerPrinthead) {
		this.printerManufacturerPrinthead = printerManufacturerPrinthead;
	}

	/**
	 * @return the printerTypeOfPrinthead
	 */
	public String getPrinterTypeOfPrinthead() {
		return printerTypeOfPrinthead;
	}

	/**
	 * @param printerTypeOfPrinthead the printerTypeOfPrinthead to set
	 */
	public void setPrinterTypeOfPrinthead(String printerTypeOfPrinthead) {
		this.printerTypeOfPrinthead = printerTypeOfPrinthead;
	}

	/**
	 * @return the printerCompatibleInk
	 */
	public String getPrinterCompatibleInk() {
		return printerCompatibleInk;
	}

	/**
	 * @param printerCompatibleInk the printerCompatibleInk to set
	 */
	public void setPrinterCompatibleInk(String printerCompatibleInk) {
		this.printerCompatibleInk = printerCompatibleInk;
	}

	/**
	 * @return the printerTypeDrops
	 */
	public String getPrinterTypeDrops() {
		return printerTypeDrops;
	}

	/**
	 * @param printerTypeDrops the printerTypeDrops to set
	 */
	public void setPrinterTypeDrops(String printerTypeDrops) {
		this.printerTypeDrops = printerTypeDrops;
	}

	/**
	 * @return the printerSizeDrops
	 */
	public int getPrinterSizeDrops() {
		return printerSizeDrops;
	}

	/**
	 * @param printerSizeDrops the printerSizeDrops to set
	 */
	public void setPrinterSizeDrops(int printerSizeDrops) {
		this.printerSizeDrops = printerSizeDrops;
	}

	/**
	 * @return the printerSpeedPrint
	 */
	public int getPrinterSpeedPrint() {
		return printerSpeedPrint;
	}

	/**
	 * @param printerSpeedPrint the printerSpeedPrint to set
	 */
	public void setPrinterSpeedPrint(int printerSpeedPrint) {
		this.printerSpeedPrint = printerSpeedPrint;
	}

	/**
	 * @return the printerPrintResolution
	 */
	public String getPrinterPrintResolution() {
		return printerPrintResolution;
	}

	/**
	 * @param printerPrintResolution the printerPrintResolution to set
	 */
	public void setPrinterPrintResolution(String printerPrintResolution) {
		this.printerPrintResolution = printerPrintResolution;
	}

	/**
	 * @return the printerEquipmentManufacturer
	 */
	public String getPrinterEquipmentManufacturer() {
		return printerEquipmentManufacturer;
	}

	/**
	 * @param printerEquipmentManufacturer the printerEquipmentManufacturer to set
	 */
	public void setPrinterEquipmentManufacturer(String printerEquipmentManufacturer) {
		this.printerEquipmentManufacturer = printerEquipmentManufacturer;
	}

	/**
	 * @return the printerEquipmentModel
	 */
	public String getPrinterEquipmentModel() {
		return printerEquipmentModel;
	}

	/**
	 * @param printerEquipmentModel the printerEquipmentModel to set
	 */
	public void setPrinterEquipmentModel(String printerEquipmentModel) {
		this.printerEquipmentModel = printerEquipmentModel;
	}

	/**
	 * @return the printerInterfaceConnection
	 */
	public String getPrinterInterfaceConnection() {
		return printerInterfaceConnection;
	}

	/**
	 * @param printerInterfaceConnection the printerInterfaceConnection to set
	 */
	public void setPrinterInterfaceConnection(String printerInterfaceConnection) {
		this.printerInterfaceConnection = printerInterfaceConnection;
	}

	/**
	 * @return the printerMaximumMediaThickness
	 */
	public int getPrinterMaximumMediaThickness() {
		return printerMaximumMediaThickness;
	}

	/**
	 * @param printerMaximumMediaThickness the printerMaximumMediaThickness to set
	 */
	public void setPrinterMaximumMediaThickness(int printerMaximumMediaThickness) {
		this.printerMaximumMediaThickness = printerMaximumMediaThickness;
	}

	/**
	 * @return the printerMaximumWeightOfVehicle
	 */
	public int getPrinterMaximumWeightOfVehicle() {
		return printerMaximumWeightOfVehicle;
	}

	/**
	 * @param printerMaximumWeightOfVehicle the printerMaximumWeightOfVehicle to set
	 */
	public void setPrinterMaximumWeightOfVehicle(int printerMaximumWeightOfVehicle) {
		this.printerMaximumWeightOfVehicle = printerMaximumWeightOfVehicle;
	}

	/**
	 * @return the printerRip
	 */
	public String getPrinterRip() {
		return printerRip;
	}

	/**
	 * @param printerRip the printerRip to set
	 */
	public void setPrinterRip(String printerRip) {
		this.printerRip = printerRip;
	}

	/**
	 * @return the printerMaxPowerConsumption
	 */
	public int getPrinterMaxPowerConsumption() {
		return printerMaxPowerConsumption;
	}

	/**
	 * @param printerMaxPowerConsumption the printerMaxPowerConsumption to set
	 */
	public void setPrinterMaxPowerConsumption(int printerMaxPowerConsumption) {
		this.printerMaxPowerConsumption = printerMaxPowerConsumption;
	}

	/**
	 * @return the printerWeight
	 */
	public int getPrinterWeight() {
		return printerWeight;
	}

	/**
	 * @param printerWeight the printerWeight to set
	 */
	public void setPrinterWeight(int printerWeight) {
		this.printerWeight = printerWeight;
	}

	/**
	 * @return the printerWidth
	 */
	public int getPrinterWidth() {
		return printerWidth;
	}

	/**
	 * @param printerWidth the printerWidth to set
	 */
	public void setPrinterWidth(int printerWidth) {
		this.printerWidth = printerWidth;
	}

	/**
	 * @return the printerHeigth
	 */
	public int getPrinterHeigth() {
		return printerHeigth;
	}

	/**
	 * @param printerHeigth the printerHeigth to set
	 */
	public void setPrinterHeigth(int printerHeigth) {
		this.printerHeigth = printerHeigth;
	}

	/**
	 * @return the printerDepth
	 */
	public int getPrinterDepth() {
		return printerDepth;
	}

	/**
	 * @param printerDepth the printerDepth to set
	 */
	public void setPrinterDepth(int printerDepth) {
		this.printerDepth = printerDepth;
	}

	/**
	 * @return the printerDescription
	 */
	public String getPrinterDescription() {
		return printerDescription;
	}

	/**
	 * @param printerDescription the printerDescription to set
	 */
	public void setPrinterDescription(String printerDescription) {
		this.printerDescription = printerDescription;
	}


}