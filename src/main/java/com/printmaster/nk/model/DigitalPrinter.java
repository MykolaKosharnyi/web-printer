package com.printmaster.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="digital_printer")
public class DigitalPrinter extends HeadProduct{

	private static final long serialVersionUID = -7914406547800809890L;
	
	@NotEmpty(message = "Please enter type of product.")
	@Column(name="type_printer")//тип принтера
	private String typePrinter;
	
	@Column(name="device")//Устройство
	private String device;
	
	@Column(name="type_of_printing")//Тип печати
	private String typeOfPrinting;
	
	@Column(name="print_technology")//Технология печати
	private String printTechnology;
	
	@Column(name="accommodation")//Размещение
	private String accommodation;
	
	@Column(name="application_area")//Область применения
	private String applicationArea;
	
	@Column(name="number_of_pages_per_month")//Количество страниц в месяц
	private int numberOfPagesPerMonth;
	
	@Column(name="maximum_format")//Максимальный формат
	private String maximumFormat;
	
	@Column(name="automatic_two_sided_printing")//Автоматическая двусторонняя печать
	private String automaticTwoSidedPrinting;
	
	@Column(name="theMaximumResolutionForColorPrinting")//Максимальное разрешение для цветной печати
	private String theMaximumResolutionForColorPrinting;
	
	@Column(name="theMaximumResolutionForBWPrinting")//Максимальное разрешение для ч/б печати
	private String theMaximumResolutionForBWPrinting;
	
//Скорость печати для ч/б печати
	@Column(name="speed_print_BW_A4")
	private int speedPrintBWA4 = 0;
	
	@Column(name="speed_print_BW_A3")
	private int speedPrintBWA3 = 0;
	
	@Column(name="speed_print_BW_A2")
	private int speedPrintBWA2 = 0;
	
	@Column(name="speed_print_BW_A1")
	private int speedPrintBWA1 = 0;
	
	@Column(name="speed_print_BW_A0")
	private int speedPrintBWA0 = 0;
	
//Скорость печати для цветной печати
	@Column(name="speed_print_color_A4")
	private int speedPrintColorA4 = 0;
	
	@Column(name="speed_print_color_A3")
	private int speedPrintColorA3 = 0;
	
	@Column(name="speed_print_color_A2")
	private int speedPrintColorA2 = 0;
	
	@Column(name="speed_print_color_A1")
	private int speedPrintColorA1 = 0;
	
	@Column(name="speed_print_color_A0")
	private int speedPrintColorA0 = 0;
	
	@Column(name="warm_up_time")//Время разогрева
	private Double warmUpTime;
	
	@Column(name="first_print_color")//Время выхода первого отпечатка color
	private Double firstPrintColor;
	
	@Column(name="first_print_BW")//Время выхода первого отпечатка BW
	private Double firstPrintBW;
	
	@Column(name="scannerType")//Тип сканера
	private String[] scannerType;
	
	@Column(name="theMaximumSizeOfTheOriginal")//Максимальный формат оригинала
	private String theMaximumSizeOfTheOriginal;
	
	@Column(name="maximumScanSize")//Максимальный размер сканирования
	private String maximumScanSize;
	
	@Column(name="scannerResolution")//Разрешение сканера
	private String scannerResolution;
	
	@Column(name="scanSpeedColor")//Скорость сканирования (цветн.)
	private int scanSpeedColor;
	
	@Column(name="scanSpeedBW")//Скорость сканирования (BW)
	private int scanSpeedBW;
	
	@Column(name="sendingImagesByEmail")//Отправка изображения по e-mail
	private String sendingImagesByEmail;
	
	@Column(name="maximumResolutionCopierBW")//Максимальное разрешение копира (ч/б)
	private String maximumResolutionCopierBW;
	
	//Скорость копирования BW
	@Column(name="speed_copy_BW_A4")
	private int speedCopyBWA4 = 0;
	
	@Column(name="speed_copy_BW_A3")
	private int speedCopyBWA3 = 0;
	
	@Column(name="speed_copy_BW_A2")
	private int speedCopyBWA2 = 0;
	
	@Column(name="speed_copy_BW_A1")
	private int speedCopyBWA1 = 0;
	
	@Column(name="speed_copy_BW_A0")
	private int speedCopyBWA0 = 0;
	
	//Скорость копирования Color
	@Column(name="speed_copy_color_A4")
	private int speedCopyColorA4 = 0;
	
	@Column(name="speed_copy_color_A3")
	private int speedCopyColorA3 = 0;
	
	@Column(name="speed_copy_color_A2")
	private int speedCopyColorA2 = 0;
	
	@Column(name="speed_copy_color_A1")
	private int speedCopyColorA1 = 0;
	
	@Column(name="speed_copy_color_A0")
	private int speedCopyColorA0 = 0;
	
	@Column(name="firstCopyOutTime")//Время выхода первой копии
	private int firstCopyOutTime;
	
	@Column(name="zooming")//Изменение масштаба
	private int zooming;
	
	@Column(name="stepZoom")//Шаг масштабирования
	private Double stepZoom;
	
	@Column(name="theMaximumNumberOfCopiesPerCycles")//Максимальное количество копий за цикл
	private int theMaximumNumberOfCopiesPerCycle;
	
	@Column(name="paperFeedStandart")//Подача бумаги (стандартная)
	private int paperFeedStandart;
	
	@Column(name="paperFeedMax")//Подача бумаги (максимальная)
	private int paperFeedMax;
	
	@Column(name="paperOutputStandart")//Вывод бумаги (стандартная)
	private int paperOutputStandart;
	
	@Column(name="paperOutputMax")//Вывод бумаги (максимальная)
	private int paperOutputMax;
	
	@Column(name="theCapacityOfTheBypassTray")//Емкость лотка ручной подачи
	private int theCapacityOfTheBypassTray;
	
	@Column(name="electronicSorting")//Электронная сортировка
	private String electronicSorting;
	
	@Column(name="stapler")//Степлер
	private String stapler;
	
	@Column(name="paperDensity")//Плотность бумаги
	private int paperDensity;
	
	@Column(name="printingOn")//Печать на
	private String[] printingOn;
	
	@Column(name="resourceDeveloper")//Ресурс девелопера
	private int resourceDeveloper;
	
	@Column(name="resourceDrum")//Ресурс фотобарабана
	private int resourceDrum;
	
	@Column(name="resourceBWCartridgeToner")//Ресурс ч/б картриджа/тонера
	private int resourceBWCartridgeToner;
	
	@Column(name="numberOfCartridges")//Количество картриджей
	private int numberOfCartridges;
	
	@Column(name="memory")//Объем памяти
	private int memory;
	
	@Column(name="hardDriveCapacity")//Емкость жесткого диска
	private int hardDriveCapacity;
	
	@Column(name="interfaces")//Интерфейсы
	private String[] interfaces;
	
	@Column(name="directPrinting")//Прямая печать
	private String directPrinting;
	
	@Column(name="webInterface")//Веб-интерфейс
	private String webInterface;
	
	@Column(name="supportPostScript")//Поддержка PostScript
	private String supportPostScript;
	
	@Column(name="support")//Поддержка
	private String[] support;
	
	@Column(name="theNumberOfInstalledPostScriptFonts")//Количество установленных шрифтов PostScript
	private int theNumberOfInstalledPostScriptFonts;
	
	@Column(name="theNumberOfInstalledPCLFonts")//Количество установленных шрифтов PCL
	private int theNumberOfInstalledPCLFonts;
	
	@Column(name="oSSupport")//Поддержка ОС
	private String[] oSSupport;
	
	@Column(name="displayInformation")//Отображение информации
	private String displayInformation;
	
	@Column(name="displaySize")//Диагональ дисплея
	private double displaySize;

	public DigitalPrinter(){}

	public int getSpeedPrintBWA4() {
		return speedPrintBWA4;
	}

	public void setSpeedPrintBWA4(int speedPrintBWA4) {
		this.speedPrintBWA4 = speedPrintBWA4;
	}

	public int getSpeedPrintBWA3() {
		return speedPrintBWA3;
	}

	public void setSpeedPrintBWA3(int speedPrintBWA3) {
		this.speedPrintBWA3 = speedPrintBWA3;
	}

	public int getSpeedPrintBWA2() {
		return speedPrintBWA2;
	}

	public void setSpeedPrintBWA2(int speedPrintBWA2) {
		this.speedPrintBWA2 = speedPrintBWA2;
	}

	public int getSpeedPrintBWA1() {
		return speedPrintBWA1;
	}

	public void setSpeedPrintBWA1(int speedPrintBWA1) {
		this.speedPrintBWA1 = speedPrintBWA1;
	}

	public int getSpeedPrintBWA0() {
		return speedPrintBWA0;
	}

	public void setSpeedPrintBWA0(int speedPrintBWA0) {
		this.speedPrintBWA0 = speedPrintBWA0;
	}

	public int getSpeedPrintColorA4() {
		return speedPrintColorA4;
	}

	public void setSpeedPrintColorA4(int speedPrintColorA4) {
		this.speedPrintColorA4 = speedPrintColorA4;
	}

	public int getSpeedPrintColorA3() {
		return speedPrintColorA3;
	}

	public void setSpeedPrintColorA3(int speedPrintColorA3) {
		this.speedPrintColorA3 = speedPrintColorA3;
	}

	public int getSpeedPrintColorA2() {
		return speedPrintColorA2;
	}

	public void setSpeedPrintColorA2(int speedPrintColorA2) {
		this.speedPrintColorA2 = speedPrintColorA2;
	}

	public int getSpeedPrintColorA1() {
		return speedPrintColorA1;
	}

	public void setSpeedPrintColorA1(int speedPrintColorA1) {
		this.speedPrintColorA1 = speedPrintColorA1;
	}

	public int getSpeedPrintColorA0() {
		return speedPrintColorA0;
	}

	public void setSpeedPrintColorA0(int speedPrintColorA0) {
		this.speedPrintColorA0 = speedPrintColorA0;
	}

	public int getSpeedCopyBWA4() {
		return speedCopyBWA4;
	}

	public void setSpeedCopyBWA4(int speedCopyBWA4) {
		this.speedCopyBWA4 = speedCopyBWA4;
	}

	public int getSpeedCopyBWA3() {
		return speedCopyBWA3;
	}

	public void setSpeedCopyBWA3(int speedCopyBWA3) {
		this.speedCopyBWA3 = speedCopyBWA3;
	}

	public int getSpeedCopyBWA2() {
		return speedCopyBWA2;
	}

	public void setSpeedCopyBWA2(int speedCopyBWA2) {
		this.speedCopyBWA2 = speedCopyBWA2;
	}

	public int getSpeedCopyBWA1() {
		return speedCopyBWA1;
	}

	public void setSpeedCopyBWA1(int speedCopyBWA1) {
		this.speedCopyBWA1 = speedCopyBWA1;
	}

	public int getSpeedCopyBWA0() {
		return speedCopyBWA0;
	}

	public void setSpeedCopyBWA0(int speedCopyBWA0) {
		this.speedCopyBWA0 = speedCopyBWA0;
	}

	public int getSpeedCopyColorA4() {
		return speedCopyColorA4;
	}

	public void setSpeedCopyColorA4(int speedCopyColorA4) {
		this.speedCopyColorA4 = speedCopyColorA4;
	}

	public int getSpeedCopyColorA3() {
		return speedCopyColorA3;
	}

	public void setSpeedCopyColorA3(int speedCopyColorA3) {
		this.speedCopyColorA3 = speedCopyColorA3;
	}

	public int getSpeedCopyColorA2() {
		return speedCopyColorA2;
	}

	public void setSpeedCopyColorA2(int speedCopyColorA2) {
		this.speedCopyColorA2 = speedCopyColorA2;
	}

	public int getSpeedCopyColorA1() {
		return speedCopyColorA1;
	}

	public void setSpeedCopyColorA1(int speedCopyColorA1) {
		this.speedCopyColorA1 = speedCopyColorA1;
	}

	public int getSpeedCopyColorA0() {
		return speedCopyColorA0;
	}

	public void setSpeedCopyColorA0(int speedCopyColorA0) {
		this.speedCopyColorA0 = speedCopyColorA0;
	}

	public String getTypePrinter() {
		return typePrinter;
	}

	public void setTypePrinter(String typePrinter) {
		this.typePrinter = typePrinter;
	}

	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	public String getTypeOfPrinting() {
		return typeOfPrinting;
	}

	public void setTypeOfPrinting(String typeOfPrinting) {
		this.typeOfPrinting = typeOfPrinting;
	}

	public String getPrintTechnology() {
		return printTechnology;
	}

	public void setPrintTechnology(String printTechnology) {
		this.printTechnology = printTechnology;
	}

	public String getAccommodation() {
		return accommodation;
	}

	public void setAccommodation(String accommodation) {
		this.accommodation = accommodation;
	}

	public String getApplicationArea() {
		return applicationArea;
	}

	public void setApplicationArea(String applicationArea) {
		this.applicationArea = applicationArea;
	}

	public int getNumberOfPagesPerMonth() {
		return numberOfPagesPerMonth;
	}

	public void setNumberOfPagesPerMonth(int numberOfPagesPerMonth) {
		this.numberOfPagesPerMonth = numberOfPagesPerMonth;
	}

	public String getMaximumFormat() {
		return maximumFormat;
	}

	public void setMaximumFormat(String maximumFormat) {
		this.maximumFormat = maximumFormat;
	}

	public String getAutomaticTwoSidedPrinting() {
		return automaticTwoSidedPrinting;
	}

	public void setAutomaticTwoSidedPrinting(String automaticTwoSidedPrinting) {
		this.automaticTwoSidedPrinting = automaticTwoSidedPrinting;
	}

	public String getTheMaximumResolutionForColorPrinting() {
		return theMaximumResolutionForColorPrinting;
	}

	public void setTheMaximumResolutionForColorPrinting(String theMaximumResolutionForColorPrinting) {
		this.theMaximumResolutionForColorPrinting = theMaximumResolutionForColorPrinting;
	}

	public String getTheMaximumResolutionForBWPrinting() {
		return theMaximumResolutionForBWPrinting;
	}

	public void setTheMaximumResolutionForBWPrinting(String theMaximumResolutionForBWPrinting) {
		this.theMaximumResolutionForBWPrinting = theMaximumResolutionForBWPrinting;
	}

	public String getTheMaximumSizeOfTheOriginal() {
		return theMaximumSizeOfTheOriginal;
	}

	public void setTheMaximumSizeOfTheOriginal(String theMaximumSizeOfTheOriginal) {
		this.theMaximumSizeOfTheOriginal = theMaximumSizeOfTheOriginal;
	}

	public String getMaximumScanSize() {
		return maximumScanSize;
	}

	public void setMaximumScanSize(String maximumScanSize) {
		this.maximumScanSize = maximumScanSize;
	}

	public String getScannerResolution() {
		return scannerResolution;
	}

	public void setScannerResolution(String scannerResolution) {
		this.scannerResolution = scannerResolution;
	}

	public int getScanSpeedColor() {
		return scanSpeedColor;
	}

	public void setScanSpeedColor(int scanSpeedColor) {
		this.scanSpeedColor = scanSpeedColor;
	}

	public int getScanSpeedBW() {
		return scanSpeedBW;
	}

	public void setScanSpeedBW(int scanSpeedBW) {
		this.scanSpeedBW = scanSpeedBW;
	}

	public String getMaximumResolutionCopierBW() {
		return maximumResolutionCopierBW;
	}

	public void setMaximumResolutionCopierBW(String maximumResolutionCopierBW) {
		this.maximumResolutionCopierBW = maximumResolutionCopierBW;
	}

	public int getFirstCopyOutTime() {
		return firstCopyOutTime;
	}

	public void setFirstCopyOutTime(int firstCopyOutTime) {
		this.firstCopyOutTime = firstCopyOutTime;
	}

	public int getZooming() {
		return zooming;
	}

	public void setZooming(int zooming) {
		this.zooming = zooming;
	}

	public Double getStepZoom() {
		return stepZoom;
	}

	public void setStepZoom(Double stepZoom) {
		this.stepZoom = stepZoom;
	}

	public int getTheMaximumNumberOfCopiesPerCycle() {
		return theMaximumNumberOfCopiesPerCycle;
	}

	public void setTheMaximumNumberOfCopiesPerCycle(int theMaximumNumberOfCopiesPerCycle) {
		this.theMaximumNumberOfCopiesPerCycle = theMaximumNumberOfCopiesPerCycle;
	}

	public int getPaperFeedStandart() {
		return paperFeedStandart;
	}

	public void setPaperFeedStandart(int paperFeedStandart) {
		this.paperFeedStandart = paperFeedStandart;
	}

	public int getPaperFeedMax() {
		return paperFeedMax;
	}

	public void setPaperFeedMax(int paperFeedMax) {
		this.paperFeedMax = paperFeedMax;
	}

	public int getPaperOutputStandart() {
		return paperOutputStandart;
	}

	public void setPaperOutputStandart(int paperOutputStandart) {
		this.paperOutputStandart = paperOutputStandart;
	}

	public int getPaperOutputMax() {
		return paperOutputMax;
	}

	public void setPaperOutputMax(int paperOutputMax) {
		this.paperOutputMax = paperOutputMax;
	}

	public int getTheCapacityOfTheBypassTray() {
		return theCapacityOfTheBypassTray;
	}

	public void setTheCapacityOfTheBypassTray(int theCapacityOfTheBypassTray) {
		this.theCapacityOfTheBypassTray = theCapacityOfTheBypassTray;
	}

	public int getPaperDensity() {
		return paperDensity;
	}

	public void setPaperDensity(int paperDensity) {
		this.paperDensity = paperDensity;
	}

	public String[] getPrintingOn() {
		return printingOn;
	}

	public void setPrintingOn(String[] printingOn) {
		this.printingOn = printingOn;
	}

	public int getResourceDeveloper() {
		return resourceDeveloper;
	}

	public void setResourceDeveloper(int resourceDeveloper) {
		this.resourceDeveloper = resourceDeveloper;
	}

	public int getResourceDrum() {
		return resourceDrum;
	}

	public void setResourceDrum(int resourceDrum) {
		this.resourceDrum = resourceDrum;
	}

	public int getResourceBWCartridgeToner() {
		return resourceBWCartridgeToner;
	}

	public void setResourceBWCartridgeToner(int resourceBWCartridgeToner) {
		this.resourceBWCartridgeToner = resourceBWCartridgeToner;
	}

	public int getNumberOfCartridges() {
		return numberOfCartridges;
	}

	public void setNumberOfCartridges(int numberOfCartridges) {
		this.numberOfCartridges = numberOfCartridges;
	}

	public int getMemory() {
		return memory;
	}

	public void setMemory(int memory) {
		this.memory = memory;
	}

	public int getHardDriveCapacity() {
		return hardDriveCapacity;
	}

	public void setHardDriveCapacity(int hardDriveCapacity) {
		this.hardDriveCapacity = hardDriveCapacity;
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

	public int getTheNumberOfInstalledPostScriptFonts() {
		return theNumberOfInstalledPostScriptFonts;
	}

	public void setTheNumberOfInstalledPostScriptFonts(int theNumberOfInstalledPostScriptFonts) {
		this.theNumberOfInstalledPostScriptFonts = theNumberOfInstalledPostScriptFonts;
	}

	public int getTheNumberOfInstalledPCLFonts() {
		return theNumberOfInstalledPCLFonts;
	}

	public void setTheNumberOfInstalledPCLFonts(int theNumberOfInstalledPCLFonts) {
		this.theNumberOfInstalledPCLFonts = theNumberOfInstalledPCLFonts;
	}

	public String[] getoSSupport() {
		return oSSupport;
	}

	public void setoSSupport(String[] oSSupport) {
		this.oSSupport = oSSupport;
	}

	public String getDisplayInformation() {
		return displayInformation;
	}

	public void setDisplayInformation(String displayInformation) {
		this.displayInformation = displayInformation;
	}

	public double getDisplaySize() {
		return displaySize;
	}

	public void setDisplaySize(double displaySize) {
		this.displaySize = displaySize;
	}

	public String getSendingImagesByEmail() {
		return sendingImagesByEmail;
	}

	public void setSendingImagesByEmail(String sendingImagesByEmail) {
		this.sendingImagesByEmail = sendingImagesByEmail;
	}

	public String getElectronicSorting() {
		return electronicSorting;
	}

	public void setElectronicSorting(String electronicSorting) {
		this.electronicSorting = electronicSorting;
	}

	public String getStapler() {
		return stapler;
	}

	public void setStapler(String stapler) {
		this.stapler = stapler;
	}

	public String getDirectPrinting() {
		return directPrinting;
	}

	public void setDirectPrinting(String directPrinting) {
		this.directPrinting = directPrinting;
	}

	public String getWebInterface() {
		return webInterface;
	}

	public void setWebInterface(String webInterface) {
		this.webInterface = webInterface;
	}

	public String getSupportPostScript() {
		return supportPostScript;
	}

	public void setSupportPostScript(String supportPostScript) {
		this.supportPostScript = supportPostScript;
	}

	public String[] getScannerType() {
		return scannerType;
	}

	public void setScannerType(String[] scannerType) {
		this.scannerType = scannerType;
	}

	public Double getWarmUpTime() {
		return warmUpTime;
	}

	public void setWarmUpTime(Double warmUpTime) {
		this.warmUpTime = warmUpTime;
	}

	public Double getFirstPrintColor() {
		return firstPrintColor;
	}

	public void setFirstPrintColor(Double firstPrintColor) {
		this.firstPrintColor = firstPrintColor;
	}

	public Double getFirstPrintBW() {
		return firstPrintBW;
	}

	public void setFirstPrintBW(Double firstPrintBW) {
		this.firstPrintBW = firstPrintBW;
	}
	
	public String getTypeProduct() {
		return getTypePrinter();
	}
	
}
