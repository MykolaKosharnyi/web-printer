package com.printmaster.nk.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="scaner")
public class Scanner extends Product{

	private static final long serialVersionUID = 3857611283069796552L;
	
	@NotEmpty(message = "Please enter type of product.")
	@Column(name="typeProduct")//Тип сканера
	private String typeProduct;
	
	@Column(name="scanningWidth")//Ширина сканирования
	private String scanningWidth;
	
	@Column(name="inputFirstWeightPrintMM")//для ввода вручную ширины: первое число
	private int inputFirstWeightPrintMM;
	
	@Column(name="inputSecondWeightPrintMM")//для ввода вручную ширины: второе число
	private int inputSecondWeightPrintMM;
	
	@Column(name="innings")//Подача
	private String innings;
	
	@Column(name="chromaticity")//Цветность
	private String chromaticity;
	
	@Column(name="scanningElement")//Сканирующий элемент
	private String scanningElement;
	
	@Column(name="lightSource")//Источник света
	private String lightSource;
	
	@Column(name="bitColorScanning")//Разрядность цветного сканирования
	private String bitColorScanning;
	
	@Column(name="bitScanningGrayscale")//Разрядность сканирования с оттенками серого
	private String bitScanningGrayscale;
	
	@Column(name="softwareResolution")//Программное разрешение
	private int softwareResolution;
	
	@Column(name="scanSpeed")//Скорость сканирования
	private int scanSpeed;
	
	@Column(name="opticalResolution")//Оптическое разрешение
	private String opticalResolution;
	
	@Column(name="connectionInterface")//Интерфейс подключения
	private String[] connectionInterface;
	
	@Column(name="theMaximumThicknessOfTheCarrier")//Максимальная толщина  носителя
	private int theMaximumThicknessOfTheCarrier;
	
	@Column(name="software")//П/О
	private String[] software;

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	public String getScanningWidth() {
		return scanningWidth;
	}

	public void setScanningWidth(String scanningWidth) {
		this.scanningWidth = scanningWidth;
	}

	public String getInnings() {
		return innings;
	}

	public void setInnings(String innings) {
		this.innings = innings;
	}

	public String getChromaticity() {
		return chromaticity;
	}

	public void setChromaticity(String chromaticity) {
		this.chromaticity = chromaticity;
	}

	public String getScanningElement() {
		return scanningElement;
	}

	public void setScanningElement(String scanningElement) {
		this.scanningElement = scanningElement;
	}

	public String getLightSource() {
		return lightSource;
	}

	public void setLightSource(String lightSource) {
		this.lightSource = lightSource;
	}

	public String getBitColorScanning() {
		return bitColorScanning;
	}

	public void setBitColorScanning(String bitColorScanning) {
		this.bitColorScanning = bitColorScanning;
	}

	public String getBitScanningGrayscale() {
		return bitScanningGrayscale;
	}

	public void setBitScanningGrayscale(String bitScanningGrayscale) {
		this.bitScanningGrayscale = bitScanningGrayscale;
	}

	public int getSoftwareResolution() {
		return softwareResolution;
	}

	public void setSoftwareResolution(int softwareResolution) {
		this.softwareResolution = softwareResolution;
	}

	public int getScanSpeed() {
		return scanSpeed;
	}

	public void setScanSpeed(int scanSpeed) {
		this.scanSpeed = scanSpeed;
	}

	public String getOpticalResolution() {
		return opticalResolution;
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

	public void setOpticalResolution(String opticalResolution) {
		this.opticalResolution = opticalResolution;
	}

	public String[] getConnectionInterface() {
		return connectionInterface;
	}

	public void setConnectionInterface(String[] connectionInterface) {
		this.connectionInterface = connectionInterface;
	}

	public int getTheMaximumThicknessOfTheCarrier() {
		return theMaximumThicknessOfTheCarrier;
	}

	public void setTheMaximumThicknessOfTheCarrier(int theMaximumThicknessOfTheCarrier) {
		this.theMaximumThicknessOfTheCarrier = theMaximumThicknessOfTheCarrier;
	}

	public String[] getSoftware() {
		return software;
	}

	public void setSoftware(String[] software) {
		this.software = software;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bitColorScanning == null) ? 0 : bitColorScanning.hashCode());
		result = prime * result + ((bitScanningGrayscale == null) ? 0 : bitScanningGrayscale.hashCode());
		result = prime * result + ((chromaticity == null) ? 0 : chromaticity.hashCode());
		result = prime * result + Arrays.hashCode(connectionInterface);
		result = prime * result + ((innings == null) ? 0 : innings.hashCode());
		result = prime * result + ((lightSource == null) ? 0 : lightSource.hashCode());
		result = prime * result + ((opticalResolution == null) ? 0 : opticalResolution.hashCode());
		result = prime * result + scanSpeed;
		result = prime * result + ((scanningElement == null) ? 0 : scanningElement.hashCode());
		result = prime * result + ((scanningWidth == null) ? 0 : scanningWidth.hashCode());
		result = prime * result + Arrays.hashCode(software);
		result = prime * result + softwareResolution;
		result = prime * result + theMaximumThicknessOfTheCarrier;
		result = prime * result + ((typeProduct == null) ? 0 : typeProduct.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Scanner other = (Scanner) obj;
		if (bitColorScanning == null) {
			if (other.bitColorScanning != null)
				return false;
		} else if (!bitColorScanning.equals(other.bitColorScanning))
			return false;
		if (bitScanningGrayscale == null) {
			if (other.bitScanningGrayscale != null)
				return false;
		} else if (!bitScanningGrayscale.equals(other.bitScanningGrayscale))
			return false;
		if (chromaticity == null) {
			if (other.chromaticity != null)
				return false;
		} else if (!chromaticity.equals(other.chromaticity))
			return false;
		if (!Arrays.equals(connectionInterface, other.connectionInterface))
			return false;
		if (innings == null) {
			if (other.innings != null)
				return false;
		} else if (!innings.equals(other.innings))
			return false;
		if (lightSource == null) {
			if (other.lightSource != null)
				return false;
		} else if (!lightSource.equals(other.lightSource))
			return false;
		if (opticalResolution == null) {
			if (other.opticalResolution != null)
				return false;
		} else if (!opticalResolution.equals(other.opticalResolution))
			return false;
		if (scanSpeed != other.scanSpeed)
			return false;
		if (scanningElement == null) {
			if (other.scanningElement != null)
				return false;
		} else if (!scanningElement.equals(other.scanningElement))
			return false;
		if (scanningWidth == null) {
			if (other.scanningWidth != null)
				return false;
		} else if (!scanningWidth.equals(other.scanningWidth))
			return false;
		if (!Arrays.equals(software, other.software))
			return false;
		if (softwareResolution != other.softwareResolution)
			return false;
		if (theMaximumThicknessOfTheCarrier != other.theMaximumThicknessOfTheCarrier)
			return false;
		if (typeProduct == null) {
			if (other.typeProduct != null)
				return false;
		} else if (!typeProduct.equals(other.typeProduct))
			return false;
		return true;
	}
	
}
