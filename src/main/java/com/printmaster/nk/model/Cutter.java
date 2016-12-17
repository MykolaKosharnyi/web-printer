package com.printmaster.nk.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="cutter")
public class Cutter extends HeadProduct{

	private static final long serialVersionUID = 3857611283069796552L;

	@NotEmpty(message = "Please enter type of product.")
	@Column(name="type_cutter")//Тип фрезера
	private String typeCutter;
	
	@Column(name="size_working_area_x")
	private int sizeWorkAreaX;//Размер рабочей области по оси Х
	
	@Column(name="size_working_area_y")
	private int sizeWorkAreaY;//Размер рабочей области по оси Y
	
	@Column(name="size_working_area_z")
	private int sizeWorkAreaZ;//Размер рабочей области по оси Z
	
	@Column(name="engravingStyle")//Тип гравировки
	private String engravingStyle;
	
	@Column(name="typeOfCooling")
	private String typeOfCooling;//Тип охлаждения
	
	@Column(name="type_engine")
	private String typeEngine;//Тип двигателей
	
	@Column(name="mechanical_resolution")
	private int mechanicalResolution;//Механическое разрешение
	
	@Column(name="softwareResolution")
	private int softwareResolution;//Программное разрешение
	
	@Column(name="frequencySpindle")
	private int frequencySpindle;//Частота вращения шпинделя
	
	@Column(name="processingSpeedXY")
	private int processingSpeedXY;//Скорость обработки, XY
	
	@Column(name="processingSpeedZ")
	private int processingSpeedZ;//Скорость обработки, Z
	
	@Column(name="mountingTool")
	private String mountingTool;//Крепление инструмента
	
	@Column(name="connectionInterface")
	private String[] connectionInterface;//Интерфейс подключения
	
	@Column(name="software")
	private String[] software;//Програмное обеспечение
	
	@Column(name="numberOfSpindles")
	private int numberOfSpindles = 0;//Количество шпинделей
	
	@Column(name="positioningSpeed")
	private int positioningSpeed = 0;//Скорость позиционирования

//	@ManyToMany(fetch = FetchType.EAGER)
//	@Fetch(value = FetchMode.SUBSELECT)
//	@JoinTable(name = "cutter_use_with_product", 
//			joinColumns = { @JoinColumn(name = "CUTTER_ID") }, 
//			inverseJoinColumns = { @JoinColumn(name = "USE_WITH_PRODUCT_ID") })
//	private Set<UseWithProduct> useWithProduct = new HashSet<UseWithProduct>(0);
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(connectionInterface);
		result = prime * result + ((engravingStyle == null) ? 0 : engravingStyle.hashCode());
		result = prime * result + frequencySpindle;
		result = prime * result + mechanicalResolution;
		result = prime * result + ((mountingTool == null) ? 0 : mountingTool.hashCode());
		result = prime * result + numberOfSpindles;
		result = prime * result + positioningSpeed;
		result = prime * result + processingSpeedXY;
		result = prime * result + processingSpeedZ;
		result = prime * result + sizeWorkAreaX;
		result = prime * result + sizeWorkAreaY;
		result = prime * result + sizeWorkAreaZ;
		result = prime * result + Arrays.hashCode(software);
		result = prime * result + softwareResolution;
		result = prime * result + ((typeCutter == null) ? 0 : typeCutter.hashCode());
		result = prime * result + ((typeEngine == null) ? 0 : typeEngine.hashCode());
		result = prime * result + ((typeOfCooling == null) ? 0 : typeOfCooling.hashCode());;
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
		Cutter other = (Cutter) obj;
		if (!Arrays.equals(connectionInterface, other.connectionInterface))
			return false;
		if (engravingStyle == null) {
			if (other.engravingStyle != null)
				return false;
		} else if (!engravingStyle.equals(other.engravingStyle))
			return false;
		if (frequencySpindle != other.frequencySpindle)
			return false;
		if (mechanicalResolution != other.mechanicalResolution)
			return false;
		if (mountingTool == null) {
			if (other.mountingTool != null)
				return false;
		} else if (!mountingTool.equals(other.mountingTool))
			return false;
		if (numberOfSpindles != other.numberOfSpindles)
			return false;
		if (positioningSpeed != other.positioningSpeed)
			return false;
		if (processingSpeedXY != other.processingSpeedXY)
			return false;
		if (processingSpeedZ != other.processingSpeedZ)
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
		if (typeCutter == null) {
			if (other.typeCutter != null)
				return false;
		} else if (!typeCutter.equals(other.typeCutter))
			return false;
		if (typeEngine == null) {
			if (other.typeEngine != null)
				return false;
		} else if (!typeEngine.equals(other.typeEngine))
			return false;
		if (typeOfCooling == null) {
			if (other.typeOfCooling != null)
				return false;
		} else if (!typeOfCooling.equals(other.typeOfCooling))
			return false;
		return true;
	}

	public int getPositioningSpeed() {
		return positioningSpeed;
	}

	public void setPositioningSpeed(int positioningSpeed) {
		this.positioningSpeed = positioningSpeed;
	}

	public int getNumberOfSpindles() {
		return numberOfSpindles;
	}

	public void setNumberOfSpindles(int numberOfSpindles) {
		this.numberOfSpindles = numberOfSpindles;
	}

	public String getTypeCutter() {
		return typeCutter;
	}

	public String getTypeOfCooling() {
		return typeOfCooling;
	}

	public void setTypeOfCooling(String typeOfCooling) {
		this.typeOfCooling = typeOfCooling;
	}

	public void setTypeCutter(String typeCutter) {
		this.typeCutter = typeCutter;
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

	public String getEngravingStyle() {
		return engravingStyle;
	}

	public void setEngravingStyle(String engravingStyle) {
		this.engravingStyle = engravingStyle;
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

	public int getFrequencySpindle() {
		return frequencySpindle;
	}

	public void setFrequencySpindle(int frequencySpindle) {
		this.frequencySpindle = frequencySpindle;
	}

	public int getProcessingSpeedXY() {
		return processingSpeedXY;
	}

	public void setProcessingSpeedXY(int processingSpeedXY) {
		this.processingSpeedXY = processingSpeedXY;
	}

	public int getProcessingSpeedZ() {
		return processingSpeedZ;
	}

	public void setProcessingSpeedZ(int processingSpeedZ) {
		this.processingSpeedZ = processingSpeedZ;
	}

	public String getMountingTool() {
		return mountingTool;
	}

	public void setMountingTool(String mountingTool) {
		this.mountingTool = mountingTool;
	}

	public String[] getConnectionInterface() {
		return connectionInterface;
	}

	public void setConnectionInterface(String[] connectionInterface) {
		this.connectionInterface = connectionInterface;
	}

	public String[] getSoftware() {
		return software;
	}

	public void setSoftware(String[] software) {
		this.software = software;
	}

	public String getTypeProduct() {
		return getTypeCutter();
	}

}
