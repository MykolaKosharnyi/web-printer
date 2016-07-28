package com.printmaster.nk.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="laser")
public class Laser extends Product{

	private static final long serialVersionUID = 3857611283069796552L;

	@NotEmpty(message = "Please enter type of product.")
	@Column(name="type_laser")//Тип лазерa
	private String typeLaser;
	
	@Column(name="size_working_area_x")
	private int sizeWorkAreaX;//Размер рабочей области по оси Х
	
	@Column(name="size_working_area_y")
	private int sizeWorkAreaY;//Размер рабочей области по оси Y
	
	@Column(name="size_working_area_z")
	private int sizeWorkAreaZ;//Размер рабочей области по оси Z
	
	@Column(name="typeOfCooling")
	private String typeOfCooling;//Тип охлаждения
	
	@Column(name="power_of_laser")
	private int powerOfLaser;//Мощность лазера
	
	@Column(name="type_engine")
	private String typeEngine;//Тип двигателей
	
	@Column(name="mechanical_resolution")
	private int mechanicalResolution;//Механическое разрешение
	
	@Column(name="softwareResolution")
	private int softwareResolution;//Программное разрешение
	
	@Column(name="minimumThicknessOfCut")
	private double minimumThicknessOfCut;//Минимальная толщина реза
	
	@Column(name="engravingSpeed")
	private int engravingSpeed;//Скорость гравировки
	
	@Column(name="cuttingSpeed")
	private int cuttingSpeed;//Скорость резки
	
	@Column(name="connectionInterface")
	private String[] connectionInterface;//Интерфейс подключения
	
	@Column(name="fileTypes")
	private String[] fileTypes;//Типы файлов
	
	@Column(name="software")
	private String[] software;//Програмное обеспечение
	
	@Column(name="numberOfHeads")
	private int numberOfHeads = 0;//Количество головок
	
	@Column(name="positioningSpeed")
	private int positioningSpeed = 0;//Скорость позиционирования
	
	@Column(name="colorSeparation")
	private String colorSeparation;//Цветоделение
	
	@Column(name="typeTheDisplayedImage")
	private String[] typeTheDisplayedImage;//Тип выводимого изображения

	//Минимальный размер символа (two values)
	@Column(name="firstPartTheMinimumCharacterSize")
	private int firstPartTheMinimumCharacterSize;//First number
	
	@Column(name="secondPartTheMinimumCharacterSize")
	private int secondPartTheMinimumCharacterSize;//Second number
	
	@Column(name="maximumResolution")
	private int maximumResolution;//Максимальное разрешение
	
	@Column(name="maximumPositioningAccuracy")
	private double maximumPositioningAccuracy;//Предельная точность позиционирования
	
	//Регулировка мощности лазера (two values)
	@Column(name="firstPartAdjustingTheLaserPower")
	private int firstPartAdjustingTheLaserPower;//First number
		
	@Column(name="secondPartAdjustingTheLaserPower")
	private int secondPartAdjustingTheLaserPower;//Second number
	
	@Column(name="laserWavelength")
	private int laserWavelength;//Длинна волны лазера
	
	//Импульс лазера
	@Column(name="laserPulse0")
	private int laserPulse0;
	
	@Column(name="laserPulse1")
	private int laserPulse1;
	
	@Column(name="theDiameterOfTheLaser")
	private int theDiameterOfTheLaser;//Диаметр лазера
	
	@Column(name="engravingDepth")
	private int engravingDepth;//Глубина гравировки
	
	@Column(name="laserSource")
	private int laserSource;//Ресурс лазера
	
	@Column(name="specialPurpose")
	private String[] specialPurpose;//Целевое назначение
	
	//Целевое назначение (индивидуально на товар, значение которые могут быть только у него)
	@Column(name="specialPurpose1")
	private String specialPurpose1;
	
	@Column(name="specialPurpose2")
	private String specialPurpose2;
	
	@Column(name="specialPurpose3")
	private String specialPurpose3;
	
	public String getSpecialPurpose1() {
		return specialPurpose1;
	}

	public void setSpecialPurpose1(String specialPurpose1) {
		this.specialPurpose1 = specialPurpose1;
	}

	public String getSpecialPurpose2() {
		return specialPurpose2;
	}

	public void setSpecialPurpose2(String specialPurpose2) {
		this.specialPurpose2 = specialPurpose2;
	}

	public String getSpecialPurpose3() {
		return specialPurpose3;
	}

	public void setSpecialPurpose3(String specialPurpose3) {
		this.specialPurpose3 = specialPurpose3;
	}

	public String[] getSpecialPurpose() {
		return specialPurpose;
	}

	public void setSpecialPurpose(String[] specialPurpose) {
		this.specialPurpose = specialPurpose;
	}

	public int getLaserSource() {
		return laserSource;
	}

	public void setLaserSource(int laserSource) {
		this.laserSource = laserSource;
	}

	public String getTypeLaser() {
		return typeLaser;
	}

	public int getTheDiameterOfTheLaser() {
		return theDiameterOfTheLaser;
	}

	public void setTheDiameterOfTheLaser(int theDiameterOfTheLaser) {
		this.theDiameterOfTheLaser = theDiameterOfTheLaser;
	}

	public int getEngravingDepth() {
		return engravingDepth;
	}

	public void setEngravingDepth(int engravingDepth) {
		this.engravingDepth = engravingDepth;
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

	public int getMaximumResolution() {
		return maximumResolution;
	}

	public void setMaximumResolution(int maximumResolution) {
		this.maximumResolution = maximumResolution;
	}

	public double getMaximumPositioningAccuracy() {
		return maximumPositioningAccuracy;
	}

	public void setMaximumPositioningAccuracy(double maximumPositioningAccuracy) {
		this.maximumPositioningAccuracy = maximumPositioningAccuracy;
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

	public int getLaserWavelength() {
		return laserWavelength;
	}

	public void setLaserWavelength(int laserWavelength) {
		this.laserWavelength = laserWavelength;
	}

	public int getFirstPartTheMinimumCharacterSize() {
		return firstPartTheMinimumCharacterSize;
	}

	public void setFirstPartTheMinimumCharacterSize(int firstPartTheMinimumCharacterSize) {
		this.firstPartTheMinimumCharacterSize = firstPartTheMinimumCharacterSize;
	}

	public int getSecondPartTheMinimumCharacterSize() {
		return secondPartTheMinimumCharacterSize;
	}

	public void setSecondPartTheMinimumCharacterSize(int secondPartTheMinimumCharacterSize) {
		this.secondPartTheMinimumCharacterSize = secondPartTheMinimumCharacterSize;
	}

	public String[] getTypeTheDisplayedImage() {
		return typeTheDisplayedImage;
	}

	public void setTypeTheDisplayedImage(String[] typeTheDisplayedImage) {
		this.typeTheDisplayedImage = typeTheDisplayedImage;
	}

	public String getColorSeparation() {
		return colorSeparation;
	}

	public void setColorSeparation(String colorSeparation) {
		this.colorSeparation = colorSeparation;
	}

	public int getPositioningSpeed() {
		return positioningSpeed;
	}

	public void setPositioningSpeed(int positioningSpeed) {
		this.positioningSpeed = positioningSpeed;
	}

	public int getNumberOfHeads() {
		return numberOfHeads;
	}

	public void setNumberOfHeads(int numberOfHeads) {
		this.numberOfHeads = numberOfHeads;
	}

	public String getTypeOfCooling() {
		return typeOfCooling;
	}

	public void setTypeOfCooling(String typeOfCooling) {
		this.typeOfCooling = typeOfCooling;
	}

	public void setTypeLaser(String typeLaser) {
		this.typeLaser = typeLaser;
	}

	public int getSizeWorkAreaX() {
		return sizeWorkAreaX;
	}

	public void setSizeWorkAreaX(int sizeWorkAreaX) {
		this.sizeWorkAreaX = sizeWorkAreaX;
	}

	public int getSizeWorkAreaY() {
		return sizeWorkAreaY;
	}

	public void setSizeWorkAreaY(int sizeWorkAreaY) {
		this.sizeWorkAreaY = sizeWorkAreaY;
	}

	public int getSizeWorkAreaZ() {
		return sizeWorkAreaZ;
	}

	public void setSizeWorkAreaZ(int sizeWorkAreaZ) {
		this.sizeWorkAreaZ = sizeWorkAreaZ;
	}

	public int getPowerOfLaser() {
		return powerOfLaser;
	}

	public void setPowerOfLaser(int powerOfLaser) {
		this.powerOfLaser = powerOfLaser;
	}

	public String getTypeEngine() {
		return typeEngine;
	}

	public void setTypeEngine(String typeEngine) {
		this.typeEngine = typeEngine;
	}

	public int getMechanicalResolution() {
		return mechanicalResolution;
	}

	public void setMechanicalResolution(int mechanicalResolution) {
		this.mechanicalResolution = mechanicalResolution;
	}

	public int getSoftwareResolution() {
		return softwareResolution;
	}

	public void setSoftwareResolution(int softwareResolution) {
		this.softwareResolution = softwareResolution;
	}

	public double getMinimumThicknessOfCut() {
		return minimumThicknessOfCut;
	}

	public void setMinimumThicknessOfCut(double minimumThicknessOfCut) {
		this.minimumThicknessOfCut = minimumThicknessOfCut;
	}

	public int getEngravingSpeed() {
		return engravingSpeed;
	}

	public void setEngravingSpeed(int engravingSpeed) {
		this.engravingSpeed = engravingSpeed;
	}

	public int getCuttingSpeed() {
		return cuttingSpeed;
	}

	public void setCuttingSpeed(int cuttingSpeed) {
		this.cuttingSpeed = cuttingSpeed;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(connectionInterface);
		result = prime * result + cuttingSpeed;
		result = prime * result + engravingSpeed;
		result = prime * result + Arrays.hashCode(fileTypes);
		result = prime * result + mechanicalResolution;
		result = prime * result + powerOfLaser;
		result = prime * result + sizeWorkAreaX;
		result = prime * result + sizeWorkAreaY;
		result = prime * result + sizeWorkAreaZ;
		result = prime * result + Arrays.hashCode(software);
		result = prime * result + softwareResolution;
		result = prime * result + ((typeEngine == null) ? 0 : typeEngine.hashCode());
		result = prime * result + ((typeLaser == null) ? 0 : typeLaser.hashCode());
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
		Laser other = (Laser) obj;
		if (!Arrays.equals(connectionInterface, other.connectionInterface))
			return false;
		if (cuttingSpeed != other.cuttingSpeed)
			return false;
		if (engravingSpeed != other.engravingSpeed)
			return false;
		if (!Arrays.equals(fileTypes, other.fileTypes))
			return false;
		if (mechanicalResolution != other.mechanicalResolution)
			return false;
		if (minimumThicknessOfCut != other.minimumThicknessOfCut)
			return false;
		if (powerOfLaser != other.powerOfLaser)
			return false;
		if (sizeWorkAreaX != other.sizeWorkAreaX)
			return false;
		if (sizeWorkAreaY != other.sizeWorkAreaY)
			return false;
		if (sizeWorkAreaZ != other.sizeWorkAreaZ)
			return false;
		if (!Arrays.equals(software, other.software))
			return false;
		if (softwareResolution != other.softwareResolution)
			return false;
		if (typeEngine == null) {
			if (other.typeEngine != null)
				return false;
		} else if (!typeEngine.equals(other.typeEngine))
			return false;
		if (typeLaser == null) {
			if (other.typeLaser != null)
				return false;
		} else if (!typeLaser.equals(other.typeLaser))
			return false;
		return true;
	}

}
