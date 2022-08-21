package com.mykoshar.shop.api.model.entity.search;

import java.io.Serializable;
import java.util.Arrays;

public class SearchPrinters3D extends SearchGeneric implements Serializable {
	
	private static final long serialVersionUID = 6702501013538481082L;
	
	private String[] typePrinter3D;
	private int sizePrintableAreaX0;
	private int sizePrintableAreaX1;
	private int sizePrintableAreaY0;
	private int sizePrintableAreaY1;
	private int sizePrintableAreaZ0;
	private int sizePrintableAreaZ1;
	private String[] printTechnology;
	private String[] previouslyUsed;
	private String[] chromaticity;
	private String[] typeOfPrinthead;
	private int meltingPointOfThePrintingMaterial0;
	private int meltingPointOfThePrintingMaterial1;
	private String[] media;
	private double sizeExtruder0;
	private double sizeExtruder1;
	private int speedPrint0;
	private int speedPrint1;
	private int thicknessOfThePrintingLayer0;
	private int thicknessOfThePrintingLayer1;
	private String[] interfaceConnection;
	private String[] typesOfFiles;
	private String[] rip;
	private int maximumWeightOfThePrintedModel0;
	private int maximumWeightOfThePrintedModel1;
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
	private String[] typeExtruder;
	private int[] extruderNumber;
	private int speedOfMovingThePrintHead0;
	private int speedOfMovingThePrintHead1;
	private int positioningAccuracyOfThePrintHead0;
	private int positioningAccuracyOfThePrintHead1;
	private String[] airflowModels;
	private int numberOfFansForBlowingModels0;
	private int numberOfFansForBlowingModels1;
	
	public SearchPrinters3D() {}

	public String[] getTypeExtruder() {
		return typeExtruder;
	}

	public void setTypeExtruder(String[] typeExtruder) {
		this.typeExtruder = typeExtruder;
	}

	public int[] getExtruderNumber() {
		return extruderNumber;
	}

	public void setExtruderNumber(int[] extruderNumber) {
		this.extruderNumber = extruderNumber;
	}

	public int getSpeedOfMovingThePrintHead0() {
		return speedOfMovingThePrintHead0;
	}

	public void setSpeedOfMovingThePrintHead0(int speedOfMovingThePrintHead0) {
		this.speedOfMovingThePrintHead0 = speedOfMovingThePrintHead0;
	}

	public int getSpeedOfMovingThePrintHead1() {
		return speedOfMovingThePrintHead1;
	}

	public void setSpeedOfMovingThePrintHead1(int speedOfMovingThePrintHead1) {
		this.speedOfMovingThePrintHead1 = speedOfMovingThePrintHead1;
	}

	public int getPositioningAccuracyOfThePrintHead0() {
		return positioningAccuracyOfThePrintHead0;
	}

	public void setPositioningAccuracyOfThePrintHead0(int positioningAccuracyOfThePrintHead0) {
		this.positioningAccuracyOfThePrintHead0 = positioningAccuracyOfThePrintHead0;
	}

	public int getPositioningAccuracyOfThePrintHead1() {
		return positioningAccuracyOfThePrintHead1;
	}

	public void setPositioningAccuracyOfThePrintHead1(int positioningAccuracyOfThePrintHead1) {
		this.positioningAccuracyOfThePrintHead1 = positioningAccuracyOfThePrintHead1;
	}

	public String[] getAirflowModels() {
		return airflowModels;
	}

	public void setAirflowModels(String[] airflowModels) {
		this.airflowModels = airflowModels;
	}

	public int getNumberOfFansForBlowingModels0() {
		return numberOfFansForBlowingModels0;
	}

	public void setNumberOfFansForBlowingModels0(int numberOfFansForBlowingModels0) {
		this.numberOfFansForBlowingModels0 = numberOfFansForBlowingModels0;
	}

	public int getNumberOfFansForBlowingModels1() {
		return numberOfFansForBlowingModels1;
	}

	public void setNumberOfFansForBlowingModels1(int numberOfFansForBlowingModels1) {
		this.numberOfFansForBlowingModels1 = numberOfFansForBlowingModels1;
	}

	public String[] getPreviouslyUsed() {
		return previouslyUsed;
	}

	public void setPreviouslyUsed(String[] previouslyUsed) {
		this.previouslyUsed = previouslyUsed;
	}

	public double getSizeExtruder0() {
		return sizeExtruder0;
	}

	public void setSizeExtruder0(double sizeExtruder0) {
		this.sizeExtruder0 = sizeExtruder0;
	}

	public double getSizeExtruder1() {
		return sizeExtruder1;
	}

	public void setSizeExtruder1(double sizeExtruder1) {
		this.sizeExtruder1 = sizeExtruder1;
	}

	public int getMeltingPointOfThePrintingMaterial0() {
		return meltingPointOfThePrintingMaterial0;
	}

	public void setMeltingPointOfThePrintingMaterial0(int meltingPointOfThePrintingMaterial0) {
		this.meltingPointOfThePrintingMaterial0 = meltingPointOfThePrintingMaterial0;
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

	public int getMeltingPointOfThePrintingMaterial1() {
		return meltingPointOfThePrintingMaterial1;
	}

	public void setMeltingPointOfThePrintingMaterial1(int meltingPointOfThePrintingMaterial1) {
		this.meltingPointOfThePrintingMaterial1 = meltingPointOfThePrintingMaterial1;
	}

	public int getThicknessOfThePrintingLayer0() {
		return thicknessOfThePrintingLayer0;
	}

	public void setThicknessOfThePrintingLayer0(int thicknessOfThePrintingLayer0) {
		this.thicknessOfThePrintingLayer0 = thicknessOfThePrintingLayer0;
	}

	public int getThicknessOfThePrintingLayer1() {
		return thicknessOfThePrintingLayer1;
	}

	public void setThicknessOfThePrintingLayer1(int thicknessOfThePrintingLayer1) {
		this.thicknessOfThePrintingLayer1 = thicknessOfThePrintingLayer1;
	}

	public int getMaximumWeightOfThePrintedModel0() {
		return maximumWeightOfThePrintedModel0;
	}

	public void setMaximumWeightOfThePrintedModel0(int maximumWeightOfThePrintedModel0) {
		this.maximumWeightOfThePrintedModel0 = maximumWeightOfThePrintedModel0;
	}

	public int getMaximumWeightOfThePrintedModel1() {
		return maximumWeightOfThePrintedModel1;
	}

	public void setMaximumWeightOfThePrintedModel1(int maximumWeightOfThePrintedModel1) {
		this.maximumWeightOfThePrintedModel1 = maximumWeightOfThePrintedModel1;
	}

	public String[] getTypePrinter3D() {
		return typePrinter3D;
	}

	public void setTypePrinter3D(String[] typePrinter3D) {
		this.typePrinter3D = typePrinter3D;
	}

	public double getPrise0() {
		return prise0;
	}

	public void setPrise0(double prise0) {
		this.prise0 = prise0;
	}

	public double getPrise1() {
		return prise1;
	}

	public void setPrise1(double prise1) {
		this.prise1 = prise1;
	}

	public int getSizePrintableAreaX0() {
		return sizePrintableAreaX0;
	}

	public void setSizePrintableAreaX0(int sizePrintableAreaX0) {
		this.sizePrintableAreaX0 = sizePrintableAreaX0;
	}

	public int getSizePrintableAreaX1() {
		return sizePrintableAreaX1;
	}

	public void setSizePrintableAreaX1(int sizePrintableAreaX1) {
		this.sizePrintableAreaX1 = sizePrintableAreaX1;
	}

	public int getSizePrintableAreaY0() {
		return sizePrintableAreaY0;
	}

	public void setSizePrintableAreaY0(int sizePrintableAreaY0) {
		this.sizePrintableAreaY0 = sizePrintableAreaY0;
	}

	public int getSizePrintableAreaY1() {
		return sizePrintableAreaY1;
	}

	public void setSizePrintableAreaY1(int sizePrintableAreaY1) {
		this.sizePrintableAreaY1 = sizePrintableAreaY1;
	}

	public int getSizePrintableAreaZ0() {
		return sizePrintableAreaZ0;
	}

	public void setSizePrintableAreaZ0(int sizePrintableAreaZ0) {
		this.sizePrintableAreaZ0 = sizePrintableAreaZ0;
	}

	public int getSizePrintableAreaZ1() {
		return sizePrintableAreaZ1;
	}

	public void setSizePrintableAreaZ1(int sizePrintableAreaZ1) {
		this.sizePrintableAreaZ1 = sizePrintableAreaZ1;
	}

	public String[] getPrintTechnology() {
		return printTechnology;
	}

	public void setPrintTechnology(String[] printTechnology) {
		this.printTechnology = printTechnology;
	}

	public String[] getChromaticity() {
		return chromaticity;
	}

	public void setChromaticity(String[] chromaticity) {
		this.chromaticity = chromaticity;
	}

	public String[] getTypeOfPrinthead() {
		return typeOfPrinthead;
	}

	public void setTypeOfPrinthead(String[] typeOfPrinthead) {
		this.typeOfPrinthead = typeOfPrinthead;
	}

	public String[] getMedia() {
		return media;
	}

	public void setMedia(String[] media) {
		this.media = media;
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

	public String[] getInterfaceConnection() {
		return interfaceConnection;
	}

	public void setInterfaceConnection(String[] interfaceConnection) {
		this.interfaceConnection = interfaceConnection;
	}

	public String[] getTypesOfFiles() {
		return typesOfFiles;
	}

	public void setTypesOfFiles(String[] typesOfFiles) {
		this.typesOfFiles = typesOfFiles;
	}

	public String[] getRip() {
		return rip;
	}

	public void setRip(String[] rip) {
		this.rip = rip;
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
		return getTypePrinter3D();
	}

	@Override
	public void setTypeProduct(String[] typeProduct) {
		setTypePrinter3D(typeProduct);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SEARCH PRINTER 3D details:");
		
		if(typePrinter3D!=null && typePrinter3D.length > 0){
			result.append(" typePrinter3D=" + Arrays.toString(typePrinter3D));
		}
		
		if(sizePrintableAreaX0 > 0){
			result.append(" sizePrintableAreaX0=" + sizePrintableAreaX0);
		}
		
		if(sizePrintableAreaX1 > 0){
			result.append(" sizePrintableAreaX1=" + sizePrintableAreaX1);
		}
		
		if(sizePrintableAreaY0 > 0){
			result.append(" sizePrintableAreaY0=" + sizePrintableAreaY0);
		}
		
		if(sizePrintableAreaY1 > 0){
			result.append(" sizePrintableAreaY1=" + sizePrintableAreaY1);
		}
		
		if(sizePrintableAreaZ0 > 0){
			result.append(" sizePrintableAreaZ0=" + sizePrintableAreaZ0);
		}
		
		if(sizePrintableAreaZ1 > 0){
			result.append(" sizePrintableAreaZ1=" + sizePrintableAreaZ1);
		}
		
		if(printTechnology!=null && printTechnology.length > 0){
			result.append(" printTechnology=" + Arrays.toString(printTechnology));
		}
		
		if(previouslyUsed!=null && previouslyUsed.length > 0){
			result.append(" previouslyUsed=" + Arrays.toString(previouslyUsed));
		}
		
		if(chromaticity!=null && chromaticity.length > 0){
			result.append(" chromaticity=" + Arrays.toString(chromaticity));
		}
		
		if(typeOfPrinthead!=null && typeOfPrinthead.length > 0){
			result.append(" typeOfPrinthead=" + Arrays.toString(typeOfPrinthead));
		}
		
		if(meltingPointOfThePrintingMaterial0 > 0){
			result.append(" meltingPointOfThePrintingMaterial0=" + meltingPointOfThePrintingMaterial0);
		}
		
		if(meltingPointOfThePrintingMaterial1 > 0){
			result.append(" meltingPointOfThePrintingMaterial1=" + meltingPointOfThePrintingMaterial1);
		}
		
		if(media!=null && media.length > 0){
			result.append(" media=" + Arrays.toString(media));
		}
		
		if(sizeExtruder0 > 0){
			result.append(" sizeExtruder0=" + sizeExtruder0);
		}
		
		if(sizeExtruder1 > 0){
			result.append(" sizeExtruder1=" + sizeExtruder1);
		}
		
		if(speedPrint0 > 0){
			result.append(" speedPrint0=" + speedPrint0);
		}
		
		if(speedPrint1 > 0){
			result.append(" speedPrint1=" + speedPrint1);
		}
		
		if(thicknessOfThePrintingLayer0 > 0){
			result.append(" thicknessOfThePrintingLayer0=" + thicknessOfThePrintingLayer0);
		}
		
		if(thicknessOfThePrintingLayer1 > 0){
			result.append(" thicknessOfThePrintingLayer1=" + thicknessOfThePrintingLayer1);
		}
		
		if(interfaceConnection!=null && interfaceConnection.length > 0){
			result.append(" interfaceConnection=" + Arrays.toString(interfaceConnection));
		}
		
		if(typesOfFiles!=null && typesOfFiles.length > 0){
			result.append(" typesOfFiles=" + Arrays.toString(typesOfFiles));
		}
		
		if(rip!=null && rip.length > 0){
			result.append(" rip=" + Arrays.toString(rip));
		}
		
		if(maximumWeightOfThePrintedModel0 > 0){
			result.append(" maximumWeightOfThePrintedModel0=" + maximumWeightOfThePrintedModel0);
		}
		
		if(maximumWeightOfThePrintedModel1 > 0){
			result.append(" maximumWeightOfThePrintedModel1=" + maximumWeightOfThePrintedModel1);
		}
		
		if(equipmentManufacturer!=null && equipmentManufacturer.length > 0){
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
		
		if(typeExtruder!=null && typeExtruder.length > 0){
			result.append(" typeExtruder=" + Arrays.toString(typeExtruder));
		}
		
		if(extruderNumber!=null && extruderNumber.length > 0){
			result.append(" extruderNumber=" + Arrays.toString(extruderNumber));
		}
		
		if(speedOfMovingThePrintHead0 > 0){
			result.append(" speedOfMovingThePrintHead0=" + speedOfMovingThePrintHead0);
		}
		
		if(speedOfMovingThePrintHead1 > 0){
			result.append(" speedOfMovingThePrintHead1=" + speedOfMovingThePrintHead1);
		}
		
		if(positioningAccuracyOfThePrintHead0 > 0){
			result.append(" positioningAccuracyOfThePrintHead0=" + positioningAccuracyOfThePrintHead0);
		}
		
		if(positioningAccuracyOfThePrintHead1 > 0){
			result.append(" positioningAccuracyOfThePrintHead1=" + positioningAccuracyOfThePrintHead1);
		}
		
		if(airflowModels!=null && airflowModels.length > 0){
			result.append(" airflowModels=" + Arrays.toString(airflowModels));
		}
		
		if(numberOfFansForBlowingModels0 > 0){
			result.append(" numberOfFansForBlowingModels0=" + numberOfFansForBlowingModels0);
		}
		
		if(numberOfFansForBlowingModels1 > 0){
			result.append(" numberOfFansForBlowingModels1=" + numberOfFansForBlowingModels1);
		}
		
		return result.toString();
	}

}
