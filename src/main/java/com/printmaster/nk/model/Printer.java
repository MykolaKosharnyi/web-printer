package com.printmaster.nk.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="printer")
public class Printer extends Product{

	private static final long serialVersionUID = -7914406547800809890L;
	
	@NotEmpty(message = "Please enter type of product.")
	@Column(name="type_printer")//Тип принтера
	private String typePrinter;
	
	@Column(name="weight_print_mm")
	private int weightPrintMM;
	
	@Column(name="inputFirstWeightPrintMM")//для ввода вручную ширины: первое число
	private int inputFirstWeightPrintMM;
	
	@Column(name="inputSecondWeightPrintMM")//для ввода вручную ширины: второе число
	private int inputSecondWeightPrintMM;
	
	@Column(name="type_print")
	private String typePrint;
	
	@Column(name="feed")
	private String[] feed;
	
	@Column(name="chromaticity")
	private String[] chromaticity;//Цветовая схема
	
	//4 подписи под каждую цветность
	@Column(name="chromaticityCMYK", length = 15)
	private String chromaticityCMYK = "";
	
	@Column(name="chromaticityCMYKx2", length = 15)
	private String chromaticityCMYKx2 = "";
	
	@Column(name="chromaticityCMYKLcLm", length = 15)
	private String chromaticityCMYKLcLm = "";
	
	@Column(name="chromaticityCMYKLcLmOG", length = 15)
	private String chromaticityCMYKLcLmOG = "";
	
	@Column(name="manufacturer_printhead")
	private String manufacturerPrinthead;
	
	@Column(name="type_of_printhead")
	private String typeOfPrinthead;//Тип печатающей головки
	
	//Количество печатающих головок
	@Column(name="numberOfPrintheads")
	private int numberOfPrintheads;//Количество (в общем)
	
	@Column(name="onEachColorNumberOfPrintheads")
	private int onEachColorNumberOfPrintheads;//На каждый цвет
	
	@Column(name="whiteColorNumberOfPrintheads")
	private int whiteColorNumberOfPrintheads;//Белый цвет
	
	@Column(name="varnishNumberOfPrintheads")
	private int varnishNumberOfPrintheads;//Лак 
	
	@Column(name="firstEmptyNameTypeNumberOfPrintheads", length = 20)
	private String firstEmptyNameTypeNumberOfPrintheads;//Пустое поле для ввода 20 символов (надпись до какого-то кол. головок)
	
	@Column(name="firstTypeNumberOfPrintheads")
	private int firstTypeNumberOfPrintheads;//
	
	@Column(name="secondEmptyNameTypeNumberOfPrintheads", length = 20)
	private String secondEmptyNameTypeNumberOfPrintheads;//Пустое поле для ввода 20 символов (надпись до какого-то кол. головок)
	
	@Column(name="secondTypeNumberOfPrintheads")
	private int secondTypeNumberOfPrintheads;
	
	@Column(name="compatible_ink")
	private String[] compatibleInk; 
	
	@Column(name="type_drops")
	private String[] typeDrops;
	
	//Размер капли
	@Column(name="sizeDropStatic")
	private double sizeDropStatic = 0;//Размер капли (постоянная)
	
	@Column(name="size_drop_range_from")//Диапазон от
	private double sizeDropRangeFrom = 0;
	
	@Column(name="size_drop_range_until")//Диапазон до
	private double sizeDropRangeUntil = 0;
	
	@Column(name="nameOfNewTypeDrop")//Дополнительное название типа капли
	private String nameOfNewTypeDrop;
	
	@Column(name="valueOfNewTypeDrop")//Значение дополнительного названия капли
	private double valueOfNewTypeDrop = 0;
	
	@Column(name="size_drops")//приготовленные по умолчанию значения размеров капель
	private String[] sizeDrops;
	
	//Расход чернил
	@Column(name="averageConsumptionOfCMYKink")//Средний расход чернил CMYK
	private double averageConsumptionOfCMYKink;
	
	@Column(name="averageConsumptionOfWhiteInk")//Средний расход белых чернил
	private double averageConsumptionOfWhiteInk;
	
	@Column(name="nameOfAverageDischarge1")//Средний расход (name, particular to this product)
	private String nameOfAverageDischarge1;
	
	@Column(name="averageDischarge1")//Средний расход (value, particular to this product)
	private double averageDischarge1;
	
	@Column(name="nameOfAverageDischarge2")//Средний расход (name, particular to this product)
	private String nameOfAverageDischarge2;
	
	@Column(name="averageDischarge2")//Средний расход (value, particular to this product)
	private double averageDischarge2;
	
	@Column(name="nameOfAverageDischarge3")//Средний расход (name, particular to this product)
	private String nameOfAverageDischarge3;
	
	@Column(name="averageDischarge3")//Средний расход (value, particular to this product)
	private double averageDischarge3;
	
	//10 характеристик для скорости печати
	    // 5 указание скорости и их площади
	@Column(name="speed_print_draft")
	private double speedPrintDraft = 0;
	
	@Column(name="speed_print_draft_resolution")
	private String speedPrintDraftResolution;
	
	@Column(name="speedPrintDraftPass")//pass
	private int speedPrintDraftPass;
	
	@Column(name="speed_print_fast")
	private double speedPrintFast = 0;
	
	@Column(name="speed_print_fast_resolution")
	private String speedPrintFastResolution;
	
	@Column(name="speedPrintFastPass")//pass
	private int speedPrintFastPass;
	
	@Column(name="speed_print_normal")
	private double speedPrintNormal = 0;
	
	@Column(name="speed_print_normal_resolution")
	private String speedPrintNormalResolution;
		
	@Column(name="speedPrintNormalPass")//pass
	private int speedPrintNormalPass;
	
	@Column(name="speed_print_quality")
	private double speedPrintQuality = 0;
	
	@Column(name="speed_print_quality_resolution")
	private String speedPrintQualityResolution;
		
	@Column(name="speedPrintQualityPass")//pass
	private int speedPrintQualityPass;
	
	@Column(name="speed_print_hiqual")
	private double speedPrintHiQual = 0;
	
	@Column(name="speed_print_hiqual_resolution")
	private String speedPrintHiqualResolution;
	
	@Column(name="speedPrintHiqualPass")//pass
	private int speedPrintHiqualPass;
	
	// 5 характеристик для указания скорости и их площади без указания конкретного типа скорости
	@Column(name="speedPrint1")
	private double speedPrint1 = 0;
	
	@Column(name="speedPrintResolution1")
	private String speedPrintResolution1;
	
	@Column(name="speedPrintPass1")//pass
	private int speedPrintPass1;
	
	@Column(name="speedPrint2")
	private double speedPrint2 = 0;
	
	@Column(name="speedPrintResolution2")
	private String speedPrintResolution2;
	
	@Column(name="speedPrintPass2")//pass
	private int speedPrintPass2;
	
	@Column(name="speedPrint3")
	private double speedPrint3 = 0;
	
	@Column(name="speedPrintResolution3")
	private String speedPrintResolution3;
	
	@Column(name="speedPrintPass3")//pass
	private int speedPrintPass3;
	
	@Column(name="speedPrint4")
	private double speedPrint4 = 0;
	
	@Column(name="speedPrintResolution4")
	private String speedPrintResolution4;
	
	@Column(name="speedPrintPass4")//pass
	private int speedPrintPass4;
	
	@Column(name="speedPrint5")
	private double speedPrint5 = 0;
	
	@Column(name="speedPrintResolution5")
	private String speedPrintResolution5;
	
	@Column(name="speedPrintPass5")//pass
	private int speedPrintPass5;
	
	@Column(name="print_resolution")
	private String[] printResolution;
	
	@Column(name="inputFirstPrintResolution")//для ввода вручную разшерения печати: первое число
	private int inputFirstPrintResolution;
	
	@Column(name="inputSecondPrintResolution")//для ввода вручную разшерения печати: второе число
	private int inputSecondPrintResolution;
	
	@Column(name="interface_connection")
	private String[] interfaceConnection;
	
	@Column(name="maximum_media_thickness")
	private double maximumMediaThickness; 
	
	@Column(name="maximum_weight_of_vehicle")
	private double maximumWeightOfVehicle;
	
	//UV Блок
	
	//UV лампа
	@Column(name="lengthWaveUVlamp")//длинна волны
	private int lengthWaveUVlamp;
	
	@Column(name="powerUVlamp")//мощность UV излучения
	private int powerUVlamp;
	
	//LED модуль
	@Column(name="lengthWaveLEDmodule")//длинна волны
	private int lengthWaveLEDmodule;
	
	@Column(name="powerLEDmodule")//мощность UV излучения
	private int powerLEDmodule;
	
	@Column(name="rip")
	private String[] rip;
	
	@OneToMany(mappedBy="printer", fetch = FetchType.EAGER/*, orphanRemoval=true*/)
	private Set<OrderPrinter> orderPrinters = new HashSet<OrderPrinter>();

	public Printer() {
		super();
	}

	public int getSpeedPrintDraftPass() {
		return speedPrintDraftPass;
	}

	public void setSpeedPrintDraftPass(int speedPrintDraftPass) {
		this.speedPrintDraftPass = speedPrintDraftPass;
	}

	public int getSpeedPrintFastPass() {
		return speedPrintFastPass;
	}

	public void setSpeedPrintFastPass(int speedPrintFastPass) {
		this.speedPrintFastPass = speedPrintFastPass;
	}

	public int getSpeedPrintNormalPass() {
		return speedPrintNormalPass;
	}

	public void setSpeedPrintNormalPass(int speedPrintNormalPass) {
		this.speedPrintNormalPass = speedPrintNormalPass;
	}

	public int getSpeedPrintQualityPass() {
		return speedPrintQualityPass;
	}

	public void setSpeedPrintQualityPass(int speedPrintQualityPass) {
		this.speedPrintQualityPass = speedPrintQualityPass;
	}

	public int getSpeedPrintHiqualPass() {
		return speedPrintHiqualPass;
	}

	public void setSpeedPrintHiqualPass(int speedPrintHiqualPass) {
		this.speedPrintHiqualPass = speedPrintHiqualPass;
	}

	public int getSpeedPrintPass1() {
		return speedPrintPass1;
	}

	public void setSpeedPrintPass1(int speedPrintPass1) {
		this.speedPrintPass1 = speedPrintPass1;
	}

	public int getSpeedPrintPass2() {
		return speedPrintPass2;
	}

	public void setSpeedPrintPass2(int speedPrintPass2) {
		this.speedPrintPass2 = speedPrintPass2;
	}

	public int getSpeedPrintPass3() {
		return speedPrintPass3;
	}

	public void setSpeedPrintPass3(int speedPrintPass3) {
		this.speedPrintPass3 = speedPrintPass3;
	}

	public int getSpeedPrintPass4() {
		return speedPrintPass4;
	}

	public void setSpeedPrintPass4(int speedPrintPass4) {
		this.speedPrintPass4 = speedPrintPass4;
	}

	public int getSpeedPrintPass5() {
		return speedPrintPass5;
	}

	public void setSpeedPrintPass5(int speedPrintPass5) {
		this.speedPrintPass5 = speedPrintPass5;
	}

	public int getLengthWaveUVlamp() {
		return lengthWaveUVlamp;
	}

	public void setLengthWaveUVlamp(int lengthWaveUVlamp) {
		this.lengthWaveUVlamp = lengthWaveUVlamp;
	}

	public int getPowerUVlamp() {
		return powerUVlamp;
	}

	public void setPowerUVlamp(int powerUVlamp) {
		this.powerUVlamp = powerUVlamp;
	}

	public int getLengthWaveLEDmodule() {
		return lengthWaveLEDmodule;
	}

	public void setLengthWaveLEDmodule(int lengthWaveLEDmodule) {
		this.lengthWaveLEDmodule = lengthWaveLEDmodule;
	}

	public int getPowerLEDmodule() {
		return powerLEDmodule;
	}

	public void setPowerLEDmodule(int powerLEDmodule) {
		this.powerLEDmodule = powerLEDmodule;
	}

	public String getTypePrinter() {
		return typePrinter;
	}

	public void setTypePrinter(String typePrinter) {
		this.typePrinter = typePrinter;
	}

	public double getAverageConsumptionOfCMYKink() {
		return averageConsumptionOfCMYKink;
	}

	public void setAverageConsumptionOfCMYKink(double averageConsumptionOfCMYKink) {
		this.averageConsumptionOfCMYKink = averageConsumptionOfCMYKink;
	}

	public double getAverageConsumptionOfWhiteInk() {
		return averageConsumptionOfWhiteInk;
	}

	public void setAverageConsumptionOfWhiteInk(double averageConsumptionOfWhiteInk) {
		this.averageConsumptionOfWhiteInk = averageConsumptionOfWhiteInk;
	}

	public String getNameOfAverageDischarge1() {
		return nameOfAverageDischarge1;
	}

	public void setNameOfAverageDischarge1(String nameOfAverageDischarge1) {
		this.nameOfAverageDischarge1 = nameOfAverageDischarge1;
	}

	public double getAverageDischarge1() {
		return averageDischarge1;
	}

	public void setAverageDischarge1(double averageDischarge1) {
		this.averageDischarge1 = averageDischarge1;
	}

	public String getNameOfAverageDischarge2() {
		return nameOfAverageDischarge2;
	}

	public void setNameOfAverageDischarge2(String nameOfAverageDischarge2) {
		this.nameOfAverageDischarge2 = nameOfAverageDischarge2;
	}

	public double getAverageDischarge2() {
		return averageDischarge2;
	}

	public void setAverageDischarge2(double averageDischarge2) {
		this.averageDischarge2 = averageDischarge2;
	}

	public String getNameOfAverageDischarge3() {
		return nameOfAverageDischarge3;
	}

	public void setNameOfAverageDischarge3(String nameOfAverageDischarge3) {
		this.nameOfAverageDischarge3 = nameOfAverageDischarge3;
	}

	public double getAverageDischarge3() {
		return averageDischarge3;
	}

	public void setAverageDischarge3(double averageDischarge3) {
		this.averageDischarge3 = averageDischarge3;
	}

	public String getChromaticityCMYK() {
		return chromaticityCMYK;
	}

	public void setChromaticityCMYK(String chromaticityCMYK) {
		this.chromaticityCMYK = chromaticityCMYK;
	}

	public String getChromaticityCMYKx2() {
		return chromaticityCMYKx2;
	}

	public void setChromaticityCMYKx2(String chromaticityCMYKx2) {
		this.chromaticityCMYKx2 = chromaticityCMYKx2;
	}

	public String getChromaticityCMYKLcLm() {
		return chromaticityCMYKLcLm;
	}

	public void setChromaticityCMYKLcLm(String chromaticityCMYKLcLm) {
		this.chromaticityCMYKLcLm = chromaticityCMYKLcLm;
	}

	public String getChromaticityCMYKLcLmOG() {
		return chromaticityCMYKLcLmOG;
	}

	public void setChromaticityCMYKLcLmOG(String chromaticityCMYKLcLmOG) {
		this.chromaticityCMYKLcLmOG = chromaticityCMYKLcLmOG;
	}

	public double getSpeedPrint1() {
		return speedPrint1;
	}

	public void setSpeedPrint1(double speedPrint1) {
		this.speedPrint1 = speedPrint1;
	}

	public String getSpeedPrintResolution1() {
		return speedPrintResolution1;
	}

	public void setSpeedPrintResolution1(String speedPrintResolution1) {
		this.speedPrintResolution1 = speedPrintResolution1;
	}

	public double getSpeedPrint2() {
		return speedPrint2;
	}

	public void setSpeedPrint2(double speedPrint2) {
		this.speedPrint2 = speedPrint2;
	}

	public String getSpeedPrintResolution2() {
		return speedPrintResolution2;
	}

	public void setSpeedPrintResolution2(String speedPrintResolution2) {
		this.speedPrintResolution2 = speedPrintResolution2;
	}

	public double getSpeedPrint3() {
		return speedPrint3;
	}

	public void setSpeedPrint3(double speedPrint3) {
		this.speedPrint3 = speedPrint3;
	}

	public String getSpeedPrintResolution3() {
		return speedPrintResolution3;
	}

	public void setSpeedPrintResolution3(String speedPrintResolution3) {
		this.speedPrintResolution3 = speedPrintResolution3;
	}

	public double getSpeedPrint4() {
		return speedPrint4;
	}

	public void setSpeedPrint4(double speedPrint4) {
		this.speedPrint4 = speedPrint4;
	}

	public String getSpeedPrintResolution4() {
		return speedPrintResolution4;
	}

	public void setSpeedPrintResolution4(String speedPrintResolution4) {
		this.speedPrintResolution4 = speedPrintResolution4;
	}

	public double getSpeedPrint5() {
		return speedPrint5;
	}

	public void setSpeedPrint5(double speedPrint5) {
		this.speedPrint5 = speedPrint5;
	}

	public String getSpeedPrintResolution5() {
		return speedPrintResolution5;
	}

	public void setSpeedPrintResolution5(String speedPrintResolution5) {
		this.speedPrintResolution5 = speedPrintResolution5;
	}

	public int getInputFirstPrintResolution() {
		return inputFirstPrintResolution;
	}

	public void setInputFirstPrintResolution(int inputFirstPrintResolution) {
		this.inputFirstPrintResolution = inputFirstPrintResolution;
	}

	public int getInputSecondPrintResolution() {
		return inputSecondPrintResolution;
	}

	public void setInputSecondPrintResolution(int inputSecondPrintResolution) {
		this.inputSecondPrintResolution = inputSecondPrintResolution;
	}

	public int getInputFirstWeightPrintMM() {
		return inputFirstWeightPrintMM;
	}

	public void setInputFirstWeightPrintMM(int inputFirstWeightPrintMM) {
		this.inputFirstWeightPrintMM = inputFirstWeightPrintMM;
	}

	public int getInputSecondWeightPrintMM() {
		return inputSecondWeightPrintMM;
	}

	public void setInputSecondWeightPrintMM(int inputSecondWeightPrintMM) {
		this.inputSecondWeightPrintMM = inputSecondWeightPrintMM;
	}

	public String getNameOfNewTypeDrop() {
		return nameOfNewTypeDrop;
	}

	public void setNameOfNewTypeDrop(String nameOfNewTypeDrop) {
		this.nameOfNewTypeDrop = nameOfNewTypeDrop;
	}

	public double getValueOfNewTypeDrop() {
		return valueOfNewTypeDrop;
	}

	public void setValueOfNewTypeDrop(double valueOfNewTypeDrop) {
		this.valueOfNewTypeDrop = valueOfNewTypeDrop;
	}

	public double getSizeDropStatic() {
		return sizeDropStatic;
	}

	public void setSizeDropStatic(double sizeDropStatic) {
		this.sizeDropStatic = sizeDropStatic;
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

	public double getSpeedPrintDraft() {
		return speedPrintDraft;
	}

	public void setSpeedPrintDraft(double speedPrintDraft) {
		this.speedPrintDraft = speedPrintDraft;
	}

	public String getSpeedPrintDraftResolution() {
		return speedPrintDraftResolution;
	}

	public void setSpeedPrintDraftResolution(String speedPrintDraftResolution) {
		this.speedPrintDraftResolution = speedPrintDraftResolution;
	}

	public double getSpeedPrintFast() {
		return speedPrintFast;
	}

	public void setSpeedPrintFast(double speedPrintFast) {
		this.speedPrintFast = speedPrintFast;
	}

	public String getSpeedPrintFastResolution() {
		return speedPrintFastResolution;
	}

	public void setSpeedPrintFastResolution(String speedPrintFastResolution) {
		this.speedPrintFastResolution = speedPrintFastResolution;
	}

	public double getSpeedPrintNormal() {
		return speedPrintNormal;
	}

	public void setSpeedPrintNormal(double speedPrintNormal) {
		this.speedPrintNormal = speedPrintNormal;
	}

	public String getSpeedPrintNormalResolution() {
		return speedPrintNormalResolution;
	}

	public void setSpeedPrintNormalResolution(String speedPrintNormalResolution) {
		this.speedPrintNormalResolution = speedPrintNormalResolution;
	}

	public double getSpeedPrintQuality() {
		return speedPrintQuality;
	}

	public void setSpeedPrintQuality(double speedPrintQuality) {
		this.speedPrintQuality = speedPrintQuality;
	}

	public String getSpeedPrintQualityResolution() {
		return speedPrintQualityResolution;
	}

	public void setSpeedPrintQualityResolution(String speedPrintQualityResolution) {
		this.speedPrintQualityResolution = speedPrintQualityResolution;
	}

	public double getSpeedPrintHiQual() {
		return speedPrintHiQual;
	}

	public void setSpeedPrintHiQual(double speedPrintHiQual) {
		this.speedPrintHiQual = speedPrintHiQual;
	}

	public String getSpeedPrintHiqualResolution() {
		return speedPrintHiqualResolution;
	}

	public void setSpeedPrintHiqualResolution(String speedPrintHiqualResolution) {
		this.speedPrintHiqualResolution = speedPrintHiqualResolution;
	}

	public String[] getChromaticity() {
		return chromaticity;
	}

	public void setChromaticity(String[] chromaticity) {
		this.chromaticity = chromaticity;
	}

	public Set<OrderPrinter> getOrderPrinters() {
		return orderPrinters;
	}

	public void setOrderPrinters(Set<OrderPrinter> orderPrinters) {
		this.orderPrinters = orderPrinters;
	}

	public void setTypeOfPrinthead(String typeOfPrinthead) {
		this.typeOfPrinthead = typeOfPrinthead;
	}

	public String getTypePrint() {
		return typePrint;
	}

	public void setTypePrint(String typePrint) {
		this.typePrint = typePrint;
	}

	public String[] getFeed() {
		return feed;
	}

	public void setFeed(String[] feed) {
		this.feed = feed;
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

	public String[] getPrintResolution() {
		return printResolution;
	}

	public void setPrintResolution(String[] printResolution) {
		this.printResolution = printResolution;
	}

	public String[] getInterfaceConnection() {
		return interfaceConnection;
	}

	public void setInterfaceConnection(String[] interfaceConnection) {
		this.interfaceConnection = interfaceConnection;
	}

	public String[] getRip() {
		return rip;
	}

	public void setRip(String[] rip) {
		this.rip = rip;
	}

	public int getWeightPrintMM() {
		return weightPrintMM;
	}

	public void setWeightPrintMM(int weightPrintMM) {
		this.weightPrintMM = weightPrintMM;
	}

	public String getManufacturerPrinthead() {
		return manufacturerPrinthead;
	}

	public void setManufacturerPrinthead(String manufacturerPrinthead) {
		this.manufacturerPrinthead = manufacturerPrinthead;
	}

	public String getTypeOfPrinthead() {
		return typeOfPrinthead;
	}

	public void setMaximumWeightOfVehicle(int maximumWeightOfVehicle) {
		this.maximumWeightOfVehicle = maximumWeightOfVehicle;
	}

	public double getMaximumMediaThickness() {
		return maximumMediaThickness;
	}

	public void setMaximumMediaThickness(double maximumMediaThickness) {
		this.maximumMediaThickness = maximumMediaThickness;
	}

	public double getMaximumWeightOfVehicle() {
		return maximumWeightOfVehicle;
	}

	public void setMaximumWeightOfVehicle(double maximumWeightOfVehicle) {
		this.maximumWeightOfVehicle = maximumWeightOfVehicle;
	}
	
	public int getNumberOfPrintheads() {
		return numberOfPrintheads;
	}

	public void setNumberOfPrintheads(int numberOfPrintheads) {
		this.numberOfPrintheads = numberOfPrintheads;
	}

	public int getOnEachColorNumberOfPrintheads() {
		return onEachColorNumberOfPrintheads;
	}

	public void setOnEachColorNumberOfPrintheads(int onEachColorNumberOfPrintheads) {
		this.onEachColorNumberOfPrintheads = onEachColorNumberOfPrintheads;
	}

	public int getWhiteColorNumberOfPrintheads() {
		return whiteColorNumberOfPrintheads;
	}

	public void setWhiteColorNumberOfPrintheads(int whiteColorNumberOfPrintheads) {
		this.whiteColorNumberOfPrintheads = whiteColorNumberOfPrintheads;
	}

	public int getVarnishNumberOfPrintheads() {
		return varnishNumberOfPrintheads;
	}

	public void setVarnishNumberOfPrintheads(int varnishNumberOfPrintheads) {
		this.varnishNumberOfPrintheads = varnishNumberOfPrintheads;
	}

	public String getFirstEmptyNameTypeNumberOfPrintheads() {
		return firstEmptyNameTypeNumberOfPrintheads;
	}

	public void setFirstEmptyNameTypeNumberOfPrintheads(String firstEmptyNameTypeNumberOfPrintheads) {
		this.firstEmptyNameTypeNumberOfPrintheads = firstEmptyNameTypeNumberOfPrintheads;
	}

	public int getFirstTypeNumberOfPrintheads() {
		return firstTypeNumberOfPrintheads;
	}

	public void setFirstTypeNumberOfPrintheads(int firstTypeNumberOfPrintheads) {
		this.firstTypeNumberOfPrintheads = firstTypeNumberOfPrintheads;
	}

	public String getSecondEmptyNameTypeNumberOfPrintheads() {
		return secondEmptyNameTypeNumberOfPrintheads;
	}

	public void setSecondEmptyNameTypeNumberOfPrintheads(String secondEmptyNameTypeNumberOfPrintheads) {
		this.secondEmptyNameTypeNumberOfPrintheads = secondEmptyNameTypeNumberOfPrintheads;
	}

	public int getSecondTypeNumberOfPrintheads() {
		return secondTypeNumberOfPrintheads;
	}

	public void setSecondTypeNumberOfPrintheads(int secondTypeNumberOfPrintheads) {
		this.secondTypeNumberOfPrintheads = secondTypeNumberOfPrintheads;
	}

	@Override
	public String toString() {
		return "Printer: weightPrintMM="
				+ weightPrintMM + ", typePrint=" + typePrint + ", feed=" + Arrays.toString(feed)
				+ ", chromaticity=" + Arrays.toString(chromaticity) + ", manufacturerPrinthead=" + manufacturerPrinthead
				+ ", typeOfPrinthead=" + typeOfPrinthead + ", compatibleInk=" + Arrays.toString(compatibleInk)
				+ ", typeDrops=" + Arrays.toString(typeDrops) + ", sizeDropRangeFrom=" + sizeDropRangeFrom
				+ ", sizeDropRangeUntil=" + sizeDropRangeUntil + ", sizeDrops=" + Arrays.toString(sizeDrops)
				+ ", speedPrintDraft=" + speedPrintDraft + ", speedPrintDraftResolution=" + speedPrintDraftResolution
				+ ", speedPrintFast=" + speedPrintFast + ", speedPrintFastResolution=" + speedPrintFastResolution
				+ ", speedPrintNormal=" + speedPrintNormal + ", speedPrintNormalResolution="
				+ speedPrintNormalResolution + ", speedPrintQuality=" + speedPrintQuality
				+ ", speedPrintQualityResolution=" + speedPrintQualityResolution + ", speedPrintHiQual="
				+ speedPrintHiQual + ", speedPrintHiqualResolution=" + speedPrintHiqualResolution + ", printResolution="
				+ Arrays.toString(printResolution) + ", interfaceConnection=" + Arrays.toString(interfaceConnection)
				+ ", maximumMediaThickness=" + maximumMediaThickness + ", maximumWeightOfVehicle="
				+ maximumWeightOfVehicle + ", rip=" + Arrays.toString(rip) + ", orderPrinters=" + orderPrinters +
				super.toString();
	}

}