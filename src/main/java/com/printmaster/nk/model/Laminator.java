package com.printmaster.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="laminator")
public class Laminator extends Product{

	private static final long serialVersionUID = 3857611283069796552L;
	
	@NotEmpty(message = "Please enter type of product.")
	@Column(name="typeProduct")//Тип ламинатора
	private String typeProduct;
	
	@Column(name="laminatingWidth")//Ширина ламинирования
	private int laminatingWidth;
	
	@Column(name="inputFirstWeightPrintMM")//для ввода вручную ширины: первое число
	private int inputFirstWeightPrintMM;
	
	@Column(name="inputSecondWeightPrintMM")//для ввода вручную ширины: второе число
	private int inputSecondWeightPrintMM;
	
	//@Column(name="typeLaminating")//Тип ламинации
	//private String typeLaminating;
	
	@Column(name="innings")//Подача
	private String innings;
	
	@Column(name="numberOfShafts")//Количество валов
	private int numberOfShafts;
	
	@Column(name="shaftDiameter")//Диаметр вала
	private int shaftDiameter;
	
	@Column(name="filmThickness")//Толщина пленки
	private int filmThickness;
	
	@Column(name="warmUpTime")//Время разогрева
	private int warmUpTime;
	
	@Column(name="laminationTemperature")//Температура ламинации
	private int laminationTemperature;
	
	@Column(name="laminatingSpeed")//Скорость ламинирования
	private int laminatingSpeed;

	public int getLaminatingWidth() {
		return laminatingWidth;
	}

	public void setLaminatingWidth(int laminatingWidth) {
		this.laminatingWidth = laminatingWidth;
	}

	public String getInnings() {
		return innings;
	}

	public void setInnings(String innings) {
		this.innings = innings;
	}

	public int getNumberOfShafts() {
		return numberOfShafts;
	}

	public void setNumberOfShafts(int numberOfShafts) {
		this.numberOfShafts = numberOfShafts;
	}

	public int getShaftDiameter() {
		return shaftDiameter;
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

	public void setShaftDiameter(int shaftDiameter) {
		this.shaftDiameter = shaftDiameter;
	}

	public int getFilmThickness() {
		return filmThickness;
	}

	public void setFilmThickness(int filmThickness) {
		this.filmThickness = filmThickness;
	}

	public int getWarmUpTime() {
		return warmUpTime;
	}

	public void setWarmUpTime(int warmUpTime) {
		this.warmUpTime = warmUpTime;
	}

	public int getLaminationTemperature() {
		return laminationTemperature;
	}

	public void setLaminationTemperature(int laminationTemperature) {
		this.laminationTemperature = laminationTemperature;
	}

	public int getLaminatingSpeed() {
		return laminatingSpeed;
	}

	public void setLaminatingSpeed(int laminatingSpeed) {
		this.laminatingSpeed = laminatingSpeed;
	}

	public String getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + filmThickness;
		result = prime * result + ((innings == null) ? 0 : innings.hashCode());
		result = prime * result + laminatingSpeed;
		result = prime * result + laminationTemperature;
		result = prime * result + numberOfShafts;
		result = prime * result + shaftDiameter;
		result = prime * result + ((typeProduct == null) ? 0 : typeProduct.hashCode());
		result = prime * result + warmUpTime;
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
		Laminator other = (Laminator) obj;
		if (filmThickness != other.filmThickness)
			return false;
		if (innings == null) {
			if (other.innings != null)
				return false;
		} else if (!innings.equals(other.innings))
			return false;
		if (laminatingSpeed != other.laminatingSpeed)
			return false;
		if (laminationTemperature != other.laminationTemperature)
			return false;
		if (numberOfShafts != other.numberOfShafts)
			return false;
		if (shaftDiameter != other.shaftDiameter)
			return false;
		if (typeProduct == null) {
			if (other.typeProduct != null)
				return false;
		} else if (!typeProduct.equals(other.typeProduct))
			return false;
		if (warmUpTime != other.warmUpTime)
			return false;
		return true;
	}

}
