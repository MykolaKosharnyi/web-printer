package com.printmaster.nk.model.entity.search;

import java.io.Serializable;
import java.util.Arrays;

public class SearchDigitalPrinters extends SearchGeneric implements Serializable{
	private static final long serialVersionUID = 6702501013538481082L;
	
	private String[] typePrinter;
	private String[] previouslyUsed;
	private String[] equipmentManufacturer;
	private String[] device;
	private String[] typeOfPrinting;
	private String[] printTechnology;
	private String[] accommodation;
	private String[] applicationArea;
	private int numberOfPagesPerMonth0;
	private int numberOfPagesPerMonth1;
	private String[] maximumFormat;
	private String[] automaticTwoSidedPrinting;
	private String[] theMaximumResolutionForColorPrinting;
	private String[] theMaximumResolutionForBWPrinting;
	private int speedPrintBW0;
	private int speedPrintBW1;
	private int speedPrintColor0;
	private int speedPrintColor1;
	private int speedCopyBW0;
	private int speedCopyBW1;
	private int speedCopyColor0;
	private int speedCopyColor1;
	private int warmUpTime0;
	private int warmUpTime1;
	private int firstPrintColor0;
	private int firstPrintColor1;
	private int firstPrintBW0;
	private int firstPrintBW1;
	private String[] scannerType;
	private String[] theMaximumSizeOfTheOriginal;
	private String[] maximumScanSize;
	private String[] scannerResolution;
	private int scanSpeedColor0;
	private int scanSpeedColor1;
	private int scanSpeedBW0;
	private int scanSpeedBW1;
	private String[] sendingImagesByEmail;
	private String[] maximumResolutionCopierBW;
	private int firstCopyOutTime0;
	private int firstCopyOutTime1;
	private int zooming0;
	private int zooming1;
	private int stepZoom0;
	private int stepZoom1;
	private int theMaximumNumberOfCopiesPerCycle0;
	private int theMaximumNumberOfCopiesPerCycle1;
	private int paperFeedStandart0;
	private int paperFeedStandart1;
	private int paperFeedMax0;
	private int paperFeedMax1;
	private int paperOutputStandart0;
	private int paperOutputStandart1;
	private int paperOutputMax0;
	private int paperOutputMax1;
	private int theCapacityOfTheBypassTray0;
	private int theCapacityOfTheBypassTray1;
	private String[] electronicSorting;
	private String[] stapler;
	private int paperDensity0;
	private int paperDensity1;
	private String[] printingOn;
	private int resourceDeveloper0;
	private int resourceDeveloper1;
	private int resourceDrum0;
	private int resourceDrum1;
	private int resourceBWCartridgeToner0;
	private int resourceBWCartridgeToner1;
	private int numberOfCartridges0;
	private int numberOfCartridges1;
	private int memory0;
	private int memory1;
	private int hardDriveCapacity0;
	private int hardDriveCapacity1;
	private String[] interfaces;
	private String[] directPrinting;
	private String[] webInterface;
	private String[] supportPostScript;
	private String[] support;
	private int theNumberOfInstalledPostScriptFonts0;
	private int theNumberOfInstalledPostScriptFonts1;
	private int theNumberOfInstalledPCLFonts0;
	private int theNumberOfInstalledPCLFonts1;
	private String[] oSSupport;
	private String[] displayInformation;
	private double displaySize0;
	private double displaySize1;
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
	
	public SearchDigitalPrinters(){}
	
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

	public int getSpeedPrintBW0() {
		return speedPrintBW0;
	}

	public void setSpeedPrintBW0(int speedPrintBW0) {
		this.speedPrintBW0 = speedPrintBW0;
	}

	public int getSpeedPrintBW1() {
		return speedPrintBW1;
	}

	public void setSpeedPrintBW1(int speedPrintBW1) {
		this.speedPrintBW1 = speedPrintBW1;
	}

	public int getSpeedPrintColor0() {
		return speedPrintColor0;
	}

	public void setSpeedPrintColor0(int speedPrintColor0) {
		this.speedPrintColor0 = speedPrintColor0;
	}

	public int getSpeedPrintColor1() {
		return speedPrintColor1;
	}

	public void setSpeedPrintColor1(int speedPrintColor1) {
		this.speedPrintColor1 = speedPrintColor1;
	}

	public int getSpeedCopyBW0() {
		return speedCopyBW0;
	}

	public void setSpeedCopyBW0(int speedCopyBW0) {
		this.speedCopyBW0 = speedCopyBW0;
	}

	public int getSpeedCopyBW1() {
		return speedCopyBW1;
	}

	public void setSpeedCopyBW1(int speedCopyBW1) {
		this.speedCopyBW1 = speedCopyBW1;
	}

	public int getSpeedCopyColor0() {
		return speedCopyColor0;
	}

	public void setSpeedCopyColor0(int speedCopyColor0) {
		this.speedCopyColor0 = speedCopyColor0;
	}

	public int getSpeedCopyColor1() {
		return speedCopyColor1;
	}

	public void setSpeedCopyColor1(int speedCopyColor1) {
		this.speedCopyColor1 = speedCopyColor1;
	}
	public String[] getPreviouslyUsed() {
		return previouslyUsed;
	}
	public void setPreviouslyUsed(String[] previouslyUsed) {
		this.previouslyUsed = previouslyUsed;
	}
	public String[] getEquipmentManufacturer() {
		return equipmentManufacturer;
	}
	public void setEquipmentManufacturer(String[] equipmentManufacturer) {
		this.equipmentManufacturer = equipmentManufacturer;
	}
	public String[] getTypePrinter() {
		return typePrinter;
	}
	public void setTypePrinter(String[] typePrinter) {
		this.typePrinter = typePrinter;
	}
	public String[] getDevice() {
		return device;
	}
	public void setDevice(String[] device) {
		this.device = device;
	}
	public String[] getTypeOfPrinting() {
		return typeOfPrinting;
	}
	public void setTypeOfPrinting(String[] typeOfPrinting) {
		this.typeOfPrinting = typeOfPrinting;
	}
	public String[] getPrintTechnology() {
		return printTechnology;
	}
	public void setPrintTechnology(String[] printTechnology) {
		this.printTechnology = printTechnology;
	}
	public String[] getAccommodation() {
		return accommodation;
	}
	public void setAccommodation(String[] accommodation) {
		this.accommodation = accommodation;
	}
	public String[] getApplicationArea() {
		return applicationArea;
	}
	public void setApplicationArea(String[] applicationArea) {
		this.applicationArea = applicationArea;
	}
	public int getNumberOfPagesPerMonth0() {
		return numberOfPagesPerMonth0;
	}
	public void setNumberOfPagesPerMonth0(int numberOfPagesPerMonth0) {
		this.numberOfPagesPerMonth0 = numberOfPagesPerMonth0;
	}
	public int getNumberOfPagesPerMonth1() {
		return numberOfPagesPerMonth1;
	}
	public void setNumberOfPagesPerMonth1(int numberOfPagesPerMonth1) {
		this.numberOfPagesPerMonth1 = numberOfPagesPerMonth1;
	}
	public String[] getMaximumFormat() {
		return maximumFormat;
	}
	public void setMaximumFormat(String[] maximumFormat) {
		this.maximumFormat = maximumFormat;
	}
	public String[] getAutomaticTwoSidedPrinting() {
		return automaticTwoSidedPrinting;
	}
	public void setAutomaticTwoSidedPrinting(String[] automaticTwoSidedPrinting) {
		this.automaticTwoSidedPrinting = automaticTwoSidedPrinting;
	}
	public String[] getTheMaximumResolutionForColorPrinting() {
		return theMaximumResolutionForColorPrinting;
	}
	public void setTheMaximumResolutionForColorPrinting(String[] theMaximumResolutionForColorPrinting) {
		this.theMaximumResolutionForColorPrinting = theMaximumResolutionForColorPrinting;
	}
	public String[] getTheMaximumResolutionForBWPrinting() {
		return theMaximumResolutionForBWPrinting;
	}
	public void setTheMaximumResolutionForBWPrinting(String[] theMaximumResolutionForBWPrinting) {
		this.theMaximumResolutionForBWPrinting = theMaximumResolutionForBWPrinting;
	}
	public int getWarmUpTime0() {
		return warmUpTime0;
	}
	public void setWarmUpTime0(int warmUpTime0) {
		this.warmUpTime0 = warmUpTime0;
	}
	public int getWarmUpTime1() {
		return warmUpTime1;
	}
	public void setWarmUpTime1(int warmUpTime1) {
		this.warmUpTime1 = warmUpTime1;
	}
	public int getFirstPrintColor0() {
		return firstPrintColor0;
	}
	public void setFirstPrintColor0(int firstPrintColor0) {
		this.firstPrintColor0 = firstPrintColor0;
	}
	public int getFirstPrintColor1() {
		return firstPrintColor1;
	}
	public void setFirstPrintColor1(int firstPrintColor1) {
		this.firstPrintColor1 = firstPrintColor1;
	}
	public int getFirstPrintBW0() {
		return firstPrintBW0;
	}
	public void setFirstPrintBW0(int firstPrintBW0) {
		this.firstPrintBW0 = firstPrintBW0;
	}
	public int getFirstPrintBW1() {
		return firstPrintBW1;
	}
	public void setFirstPrintBW1(int firstPrintBW1) {
		this.firstPrintBW1 = firstPrintBW1;
	}
	public String[] getScannerType() {
		return scannerType;
	}
	public void setScannerType(String[] scannerType) {
		this.scannerType = scannerType;
	}
	public String[] getTheMaximumSizeOfTheOriginal() {
		return theMaximumSizeOfTheOriginal;
	}
	public void setTheMaximumSizeOfTheOriginal(String[] theMaximumSizeOfTheOriginal) {
		this.theMaximumSizeOfTheOriginal = theMaximumSizeOfTheOriginal;
	}
	public String[] getMaximumScanSize() {
		return maximumScanSize;
	}
	public void setMaximumScanSize(String[] maximumScanSize) {
		this.maximumScanSize = maximumScanSize;
	}
	public String[] getScannerResolution() {
		return scannerResolution;
	}
	public void setScannerResolution(String[] scannerResolution) {
		this.scannerResolution = scannerResolution;
	}
	public int getScanSpeedColor0() {
		return scanSpeedColor0;
	}
	public void setScanSpeedColor0(int scanSpeedColor0) {
		this.scanSpeedColor0 = scanSpeedColor0;
	}
	public int getScanSpeedColor1() {
		return scanSpeedColor1;
	}
	public void setScanSpeedColor1(int scanSpeedColor1) {
		this.scanSpeedColor1 = scanSpeedColor1;
	}
	public int getScanSpeedBW0() {
		return scanSpeedBW0;
	}
	public void setScanSpeedBW0(int scanSpeedBW0) {
		this.scanSpeedBW0 = scanSpeedBW0;
	}
	public int getScanSpeedBW1() {
		return scanSpeedBW1;
	}
	public void setScanSpeedBW1(int scanSpeedBW1) {
		this.scanSpeedBW1 = scanSpeedBW1;
	}
	public String[] getMaximumResolutionCopierBW() {
		return maximumResolutionCopierBW;
	}
	public void setMaximumResolutionCopierBW(String[] maximumResolutionCopierBW) {
		this.maximumResolutionCopierBW = maximumResolutionCopierBW;
	}
	public int getFirstCopyOutTime0() {
		return firstCopyOutTime0;
	}
	public void setFirstCopyOutTime0(int firstCopyOutTime0) {
		this.firstCopyOutTime0 = firstCopyOutTime0;
	}
	public int getFirstCopyOutTime1() {
		return firstCopyOutTime1;
	}
	public void setFirstCopyOutTime1(int firstCopyOutTime1) {
		this.firstCopyOutTime1 = firstCopyOutTime1;
	}
	public int getZooming0() {
		return zooming0;
	}
	public void setZooming0(int zooming0) {
		this.zooming0 = zooming0;
	}
	public int getZooming1() {
		return zooming1;
	}
	public void setZooming1(int zooming1) {
		this.zooming1 = zooming1;
	}
	public int getStepZoom0() {
		return stepZoom0;
	}
	public void setStepZoom0(int stepZoom0) {
		this.stepZoom0 = stepZoom0;
	}
	public int getStepZoom1() {
		return stepZoom1;
	}
	public void setStepZoom1(int stepZoom1) {
		this.stepZoom1 = stepZoom1;
	}
	public int getTheMaximumNumberOfCopiesPerCycle0() {
		return theMaximumNumberOfCopiesPerCycle0;
	}
	public void setTheMaximumNumberOfCopiesPerCycle0(int theMaximumNumberOfCopiesPerCycle0) {
		this.theMaximumNumberOfCopiesPerCycle0 = theMaximumNumberOfCopiesPerCycle0;
	}
	public int getTheMaximumNumberOfCopiesPerCycle1() {
		return theMaximumNumberOfCopiesPerCycle1;
	}
	public void setTheMaximumNumberOfCopiesPerCycle1(int theMaximumNumberOfCopiesPerCycle1) {
		this.theMaximumNumberOfCopiesPerCycle1 = theMaximumNumberOfCopiesPerCycle1;
	}
	public int getPaperFeedStandart0() {
		return paperFeedStandart0;
	}
	public void setPaperFeedStandart0(int paperFeedStandart0) {
		this.paperFeedStandart0 = paperFeedStandart0;
	}
	public int getPaperFeedStandart1() {
		return paperFeedStandart1;
	}
	public void setPaperFeedStandart1(int paperFeedStandart1) {
		this.paperFeedStandart1 = paperFeedStandart1;
	}
	public int getPaperFeedMax0() {
		return paperFeedMax0;
	}
	public void setPaperFeedMax0(int paperFeedMax0) {
		this.paperFeedMax0 = paperFeedMax0;
	}
	public int getPaperFeedMax1() {
		return paperFeedMax1;
	}
	public void setPaperFeedMax1(int paperFeedMax1) {
		this.paperFeedMax1 = paperFeedMax1;
	}
	public int getPaperOutputStandart0() {
		return paperOutputStandart0;
	}
	public void setPaperOutputStandart0(int paperOutputStandart0) {
		this.paperOutputStandart0 = paperOutputStandart0;
	}
	public int getPaperOutputStandart1() {
		return paperOutputStandart1;
	}
	public void setPaperOutputStandart1(int paperOutputStandart1) {
		this.paperOutputStandart1 = paperOutputStandart1;
	}
	public int getPaperOutputMax0() {
		return paperOutputMax0;
	}
	public void setPaperOutputMax0(int paperOutputMax0) {
		this.paperOutputMax0 = paperOutputMax0;
	}
	public int getPaperOutputMax1() {
		return paperOutputMax1;
	}
	public void setPaperOutputMax1(int paperOutputMax1) {
		this.paperOutputMax1 = paperOutputMax1;
	}
	public int getTheCapacityOfTheBypassTray0() {
		return theCapacityOfTheBypassTray0;
	}
	public void setTheCapacityOfTheBypassTray0(int theCapacityOfTheBypassTray0) {
		this.theCapacityOfTheBypassTray0 = theCapacityOfTheBypassTray0;
	}
	public int getTheCapacityOfTheBypassTray1() {
		return theCapacityOfTheBypassTray1;
	}
	public void setTheCapacityOfTheBypassTray1(int theCapacityOfTheBypassTray1) {
		this.theCapacityOfTheBypassTray1 = theCapacityOfTheBypassTray1;
	}
	public int getPaperDensity0() {
		return paperDensity0;
	}
	public void setPaperDensity0(int paperDensity0) {
		this.paperDensity0 = paperDensity0;
	}
	public int getPaperDensity1() {
		return paperDensity1;
	}
	public void setPaperDensity1(int paperDensity1) {
		this.paperDensity1 = paperDensity1;
	}
	public String[] getPrintingOn() {
		return printingOn;
	}
	public void setPrintingOn(String[] printingOn) {
		this.printingOn = printingOn;
	}
	public int getResourceDeveloper0() {
		return resourceDeveloper0;
	}
	public void setResourceDeveloper0(int resourceDeveloper0) {
		this.resourceDeveloper0 = resourceDeveloper0;
	}
	public int getResourceDeveloper1() {
		return resourceDeveloper1;
	}
	public void setResourceDeveloper1(int resourceDeveloper1) {
		this.resourceDeveloper1 = resourceDeveloper1;
	}
	public int getResourceDrum0() {
		return resourceDrum0;
	}
	public void setResourceDrum0(int resourceDrum0) {
		this.resourceDrum0 = resourceDrum0;
	}
	public int getResourceDrum1() {
		return resourceDrum1;
	}
	public void setResourceDrum1(int resourceDrum1) {
		this.resourceDrum1 = resourceDrum1;
	}
	public int getResourceBWCartridgeToner0() {
		return resourceBWCartridgeToner0;
	}
	public void setResourceBWCartridgeToner0(int resourceBWCartridgeToner0) {
		this.resourceBWCartridgeToner0 = resourceBWCartridgeToner0;
	}
	public int getResourceBWCartridgeToner1() {
		return resourceBWCartridgeToner1;
	}
	public void setResourceBWCartridgeToner1(int resourceBWCartridgeToner1) {
		this.resourceBWCartridgeToner1 = resourceBWCartridgeToner1;
	}
	public int getNumberOfCartridges0() {
		return numberOfCartridges0;
	}
	public void setNumberOfCartridges0(int numberOfCartridges0) {
		this.numberOfCartridges0 = numberOfCartridges0;
	}
	public int getNumberOfCartridges1() {
		return numberOfCartridges1;
	}
	public void setNumberOfCartridges1(int numberOfCartridges1) {
		this.numberOfCartridges1 = numberOfCartridges1;
	}
	public int getMemory0() {
		return memory0;
	}
	public void setMemory0(int memory0) {
		this.memory0 = memory0;
	}
	public int getMemory1() {
		return memory1;
	}
	public void setMemory1(int memory1) {
		this.memory1 = memory1;
	}
	public int getHardDriveCapacity0() {
		return hardDriveCapacity0;
	}
	public void setHardDriveCapacity0(int hardDriveCapacity0) {
		this.hardDriveCapacity0 = hardDriveCapacity0;
	}
	public int getHardDriveCapacity1() {
		return hardDriveCapacity1;
	}
	public void setHardDriveCapacity1(int hardDriveCapacity1) {
		this.hardDriveCapacity1 = hardDriveCapacity1;
	}
	public String[] getInterfaces() {
		return interfaces;
	}
	public void setInterfaces(String[] interfaces) {
		this.interfaces = interfaces;
	}
	public String[] getSupport() {
		return support;
	}
	public void setSupport(String[] support) {
		this.support = support;
	}
	public int getTheNumberOfInstalledPostScriptFonts0() {
		return theNumberOfInstalledPostScriptFonts0;
	}
	public void setTheNumberOfInstalledPostScriptFonts0(int theNumberOfInstalledPostScriptFonts0) {
		this.theNumberOfInstalledPostScriptFonts0 = theNumberOfInstalledPostScriptFonts0;
	}
	public int getTheNumberOfInstalledPostScriptFonts1() {
		return theNumberOfInstalledPostScriptFonts1;
	}
	public void setTheNumberOfInstalledPostScriptFonts1(int theNumberOfInstalledPostScriptFonts1) {
		this.theNumberOfInstalledPostScriptFonts1 = theNumberOfInstalledPostScriptFonts1;
	}
	public int getTheNumberOfInstalledPCLFonts0() {
		return theNumberOfInstalledPCLFonts0;
	}
	public void setTheNumberOfInstalledPCLFonts0(int theNumberOfInstalledPCLFonts0) {
		this.theNumberOfInstalledPCLFonts0 = theNumberOfInstalledPCLFonts0;
	}
	public int getTheNumberOfInstalledPCLFonts1() {
		return theNumberOfInstalledPCLFonts1;
	}
	public void setTheNumberOfInstalledPCLFonts1(int theNumberOfInstalledPCLFonts1) {
		this.theNumberOfInstalledPCLFonts1 = theNumberOfInstalledPCLFonts1;
	}
	public String[] getoSSupport() {
		return oSSupport;
	}
	public void setoSSupport(String[] oSSupport) {
		this.oSSupport = oSSupport;
	}
	public String[] getDisplayInformation() {
		return displayInformation;
	}
	public void setDisplayInformation0(String[] displayInformation) {
		this.displayInformation = displayInformation;
	}
	public double getDisplaySize0() {
		return displaySize0;
	}
	public void setDisplaySize0(double displaySize0) {
		this.displaySize0 = displaySize0;
	}
	public double getDisplaySize1() {
		return displaySize1;
	}
	public void setDisplaySize1(double displaySize1) {
		this.displaySize1 = displaySize1;
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

	public String[] getSendingImagesByEmail() {
		return sendingImagesByEmail;
	}

	public void setSendingImagesByEmail(String[] sendingImagesByEmail) {
		this.sendingImagesByEmail = sendingImagesByEmail;
	}

	public String[] getElectronicSorting() {
		return electronicSorting;
	}

	public void setElectronicSorting(String[] electronicSorting) {
		this.electronicSorting = electronicSorting;
	}

	public String[] getStapler() {
		return stapler;
	}

	public void setStapler(String[] stapler) {
		this.stapler = stapler;
	}

	public String[] getDirectPrinting() {
		return directPrinting;
	}

	public void setDirectPrinting(String[] directPrinting) {
		this.directPrinting = directPrinting;
	}

	public String[] getWebInterface() {
		return webInterface;
	}

	public void setWebInterface(String[] webInterface) {
		this.webInterface = webInterface;
	}

	public String[] getSupportPostScript() {
		return supportPostScript;
	}

	public void setSupportPostScript(String[] supportPostScript) {
		this.supportPostScript = supportPostScript;
	}

	public void setDisplayInformation(String[] displayInformation) {
		this.displayInformation = displayInformation;
	}

	@Override
	public String[] getTypeProduct() {
		return getTypePrinter();
	}

	@Override
	public void setTypeProduct(String[] typeProduct) {
		setTypePrinter(typeProduct);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SEARCH DIGITAL PRINTER details:");
		
		if(typePrinter!=null && typePrinter.length > 0){
			result.append(" typePrinter=" + Arrays.toString(typePrinter));
		}
		
		if(previouslyUsed!=null && previouslyUsed.length > 0){
			result.append(" previouslyUsed=" + Arrays.toString(previouslyUsed));
		}
		
		if(equipmentManufacturer!=null && equipmentManufacturer.length > 0){
			result.append(" equipmentManufacturer=" + Arrays.toString(equipmentManufacturer));
		}
		
		if(device!=null && device.length > 0){
			result.append(" device=" + Arrays.toString(device));
		}
		
		if(typeOfPrinting!=null && typeOfPrinting.length > 0){
			result.append(" typeOfPrinting=" + Arrays.toString(typeOfPrinting));
		}
		
		if(printTechnology!=null && printTechnology.length > 0){
			result.append(" printTechnology=" + Arrays.toString(printTechnology));
		}
		
		if(accommodation!=null && accommodation.length > 0){
			result.append(" accommodation=" + Arrays.toString(accommodation));
		}
		
		if(applicationArea!=null && applicationArea.length > 0){
			result.append(" applicationArea=" + Arrays.toString(applicationArea));
		}
		
		if(numberOfPagesPerMonth0 > 0){
			result.append(" numberOfPagesPerMonth0=" + numberOfPagesPerMonth0);
		}
		
		if(numberOfPagesPerMonth1 > 0){
			result.append(" numberOfPagesPerMonth1=" + numberOfPagesPerMonth1);
		}
		
		if(maximumFormat!=null && maximumFormat.length > 0){
			result.append(" maximumFormat=" + Arrays.toString(maximumFormat));
		}
		
		if(automaticTwoSidedPrinting!=null && automaticTwoSidedPrinting.length > 0){
			result.append(" automaticTwoSidedPrinting=" + Arrays.toString(automaticTwoSidedPrinting));
		}
		
		if(theMaximumResolutionForColorPrinting!=null && theMaximumResolutionForColorPrinting.length > 0){
			result.append(" theMaximumResolutionForColorPrinting=" + Arrays.toString(theMaximumResolutionForColorPrinting));
		}
		
		if(theMaximumResolutionForBWPrinting!=null && theMaximumResolutionForBWPrinting.length > 0){
			result.append(" theMaximumResolutionForBWPrinting=" + Arrays.toString(theMaximumResolutionForBWPrinting));
		}
		
		if(speedPrintBW0 > 0){
			result.append(" speedPrintBW0=" + speedPrintBW0);
		}
		
		if(speedPrintBW1 > 0){
			result.append(" speedPrintBW1=" + speedPrintBW1);
		}
		
		if(speedPrintColor0 > 0){
			result.append(" speedPrintColor0=" + speedPrintColor0);
		}
		
		if(speedPrintColor1 > 0){
			result.append(" speedPrintColor1=" + speedPrintColor1);
		}
		
		if(speedCopyBW0 > 0){
			result.append(" speedCopyBW0=" + speedCopyBW0);
		}
		
		if(speedCopyBW1 > 0){
			result.append(" speedCopyBW1=" + speedCopyBW1);
		}
		
		if(speedCopyColor0 > 0){
			result.append(" speedCopyColor0=" + speedCopyColor0);
		}
		
		if(speedCopyColor1 > 0){
			result.append(" speedCopyColor1=" + speedCopyColor1);
		}
		
		if(warmUpTime0 > 0){
			result.append(" warmUpTime0=" + warmUpTime0);
		}
		
		if(warmUpTime1 > 0){
			result.append(" warmUpTime1=" + warmUpTime1);
		}
		
		if(firstPrintColor0 > 0){
			result.append(" firstPrintColor0=" + firstPrintColor0);
		}
		
		if(firstPrintColor1 > 0){
			result.append(" firstPrintColor1=" + firstPrintColor1);
		}		
		
		if(firstPrintBW0 > 0){
			result.append(" firstPrintBW0=" + firstPrintBW0);
		}
		
		if(firstPrintBW1 > 0){
			result.append(" firstPrintBW1=" + firstPrintBW1);
		}
		
		if(scannerType!=null && scannerType.length > 0){
			result.append(" scannerType=" + Arrays.toString(scannerType));
		}
		
		if(theMaximumSizeOfTheOriginal!=null && theMaximumSizeOfTheOriginal.length > 0){
			result.append(" theMaximumSizeOfTheOriginal=" + Arrays.toString(theMaximumSizeOfTheOriginal));
		}
		
		if(maximumScanSize!=null && maximumScanSize.length > 0){
			result.append(" maximumScanSize=" + Arrays.toString(maximumScanSize));
		}
		
		if(scannerResolution!=null && scannerResolution.length > 0){
			result.append(" scannerResolution=" + Arrays.toString(scannerResolution));
		}
		
		if(scanSpeedColor0 > 0){
			result.append(" scanSpeedColor0=" + scanSpeedColor0);
		}
		
		if(scanSpeedColor1 > 0){
			result.append(" scanSpeedColor1=" + scanSpeedColor1);
		}
		
		if(scanSpeedBW0 > 0){
			result.append(" scanSpeedBW0=" + scanSpeedBW0);
		}
		
		if(scanSpeedBW1 > 0){
			result.append(" scanSpeedBW1=" + scanSpeedBW1);
		}
		
		if(sendingImagesByEmail!=null && sendingImagesByEmail.length > 0){
			result.append(" sendingImagesByEmail=" + Arrays.toString(sendingImagesByEmail));
		}
		
		if(maximumResolutionCopierBW!=null && maximumResolutionCopierBW.length > 0){
			result.append(" maximumResolutionCopierBW=" + Arrays.toString(maximumResolutionCopierBW));
		}
		
		if(firstCopyOutTime0 > 0){
			result.append(" firstCopyOutTime0=" + firstCopyOutTime0);
		}
		
		if(firstCopyOutTime1 > 0){
			result.append(" firstCopyOutTime1=" + firstCopyOutTime1);
		}
		
		if(zooming0 > 0){
			result.append(" zooming0=" + zooming0);
		}
		
		if(zooming1 > 0){
			result.append(" zooming1=" + zooming1);
		}
		
		if(stepZoom0 > 0){
			result.append(" stepZoom0=" + stepZoom0);
		}
		
		if(stepZoom1 > 0){
			result.append(" stepZoom1=" + stepZoom1);
		}
		
		if(theMaximumNumberOfCopiesPerCycle0 > 0){
			result.append(" theMaximumNumberOfCopiesPerCycle0=" + theMaximumNumberOfCopiesPerCycle0);
		}
		
		if(theMaximumNumberOfCopiesPerCycle1 > 0){
			result.append(" theMaximumNumberOfCopiesPerCycle1=" + theMaximumNumberOfCopiesPerCycle1);
		}
		
		if(paperFeedStandart0 > 0){
			result.append(" paperFeedStandart0=" + paperFeedStandart0);
		}
		
		if(paperFeedStandart1 > 0){
			result.append(" paperFeedStandart1=" + paperFeedStandart1);
		}
		
		if(paperFeedMax0 > 0){
			result.append(" paperFeedMax0=" + paperFeedMax0);
		}
		
		if(paperFeedMax1 > 0){
			result.append(" paperFeedMax1=" + paperFeedMax1);
		}
		
		if(paperOutputStandart0 > 0){
			result.append(" paperOutputStandart0=" + paperOutputStandart0);
		}
		
		if(paperOutputStandart1 > 0){
			result.append(" paperOutputStandart1=" + paperOutputStandart1);
		}
		
		if(paperOutputMax0 > 0){
			result.append(" paperOutputMax0=" + paperOutputMax0);
		}
		
		if(paperOutputMax1 > 0){
			result.append(" paperOutputMax1=" + paperOutputMax1);
		}
		
		if(theCapacityOfTheBypassTray0 > 0){
			result.append(" theCapacityOfTheBypassTray0=" + theCapacityOfTheBypassTray0);
		}
		
		if(theCapacityOfTheBypassTray1 > 0){
			result.append(" theCapacityOfTheBypassTray1=" + theCapacityOfTheBypassTray1);
		}
		
		if(electronicSorting!=null && electronicSorting.length > 0){
			result.append(" electronicSorting=" + Arrays.toString(electronicSorting));
		}
		
		if(stapler!=null && stapler.length > 0){
			result.append(" stapler=" + Arrays.toString(stapler));
		}
		
		if(paperDensity0 > 0){
			result.append(" paperDensity0=" + paperDensity0);
		}
		
		if(paperDensity1 > 0){
			result.append(" paperDensity1=" + paperDensity1);
		}
		
		if(printingOn!=null && printingOn.length > 0){
			result.append(" printingOn=" + Arrays.toString(printingOn));
		}
		
		if(resourceDeveloper0 > 0){
			result.append(" resourceDeveloper0=" + resourceDeveloper0);
		}
		
		if(resourceDeveloper1 > 0){
			result.append(" resourceDeveloper1=" + resourceDeveloper1);
		}
		
		if(resourceDrum0 > 0){
			result.append(" resourceDrum0=" + resourceDrum0);
		}
		
		if(resourceDrum1 > 0){
			result.append(" resourceDrum1=" + resourceDrum1);
		}
		
		if(resourceBWCartridgeToner0 > 0){
			result.append(" resourceBWCartridgeToner0=" + resourceBWCartridgeToner0);
		}
		
		if(resourceBWCartridgeToner1 > 0){
			result.append(" resourceBWCartridgeToner1=" + resourceBWCartridgeToner1);
		}
		
		if(numberOfCartridges0 > 0){
			result.append(" numberOfCartridges0=" + numberOfCartridges0);
		}
		
		if(numberOfCartridges1 > 0){
			result.append(" numberOfCartridges1=" + numberOfCartridges1);
		}
		
		if(memory0 > 0){
			result.append(" memory0=" + memory0);
		}
		
		if(memory1 > 0){
			result.append(" memory1=" + memory1);
		}
		
		if(hardDriveCapacity0 > 0){
			result.append(" hardDriveCapacity0=" + hardDriveCapacity0);
		}
		
		if(hardDriveCapacity1 > 0){
			result.append(" hardDriveCapacity1=" + hardDriveCapacity1);
		}
		
		if(interfaces!=null && interfaces.length > 0){
			result.append(" interfaces=" + Arrays.toString(interfaces));
		}
		
		if(directPrinting!=null && directPrinting.length > 0){
			result.append(" directPrinting=" + Arrays.toString(directPrinting));
		}
		
		if(webInterface!=null && webInterface.length > 0){
			result.append(" webInterface=" + Arrays.toString(webInterface));
		}
		
		if(supportPostScript!=null && supportPostScript.length > 0){
			result.append(" supportPostScript=" + Arrays.toString(supportPostScript));
		}
		
		if(support!=null && support.length > 0){
			result.append(" support=" + Arrays.toString(support));
		}
		
		if(theNumberOfInstalledPostScriptFonts0 > 0){
			result.append(" theNumberOfInstalledPostScriptFonts0=" + theNumberOfInstalledPostScriptFonts0);
		}
		
		if(theNumberOfInstalledPostScriptFonts1 > 0){
			result.append(" theNumberOfInstalledPostScriptFonts1=" + theNumberOfInstalledPostScriptFonts1);
		}
		
		if(theNumberOfInstalledPCLFonts0 > 0){
			result.append(" theNumberOfInstalledPCLFonts0=" + theNumberOfInstalledPCLFonts0);
		}
		
		if(theNumberOfInstalledPCLFonts1 > 0){
			result.append(" theNumberOfInstalledPCLFonts1=" + theNumberOfInstalledPCLFonts1);
		}
		
		if(oSSupport!=null && oSSupport.length > 0){
			result.append(" oSSupport=" + Arrays.toString(oSSupport));
		}
		
		if(displayInformation!=null && displayInformation.length > 0){
			result.append(" displayInformation=" + Arrays.toString(displayInformation));
		}
		
		if(displaySize0 > 0){
			result.append(" displaySize0=" + displaySize0);
		}
		
		if(displaySize1 > 0){
			result.append(" displaySize1=" + displaySize1);
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
