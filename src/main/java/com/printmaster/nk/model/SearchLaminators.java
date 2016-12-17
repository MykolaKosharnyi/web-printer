package com.printmaster.nk.model;

import java.io.Serializable;

public class SearchLaminators extends SearchGeneric implements Serializable{

private static final long serialVersionUID = 6702501013538481082L;

	private String[] typeProduct;
	private String[] previouslyUsed;
	private String[] laminatingWidth;
	private String[] innings;
	private int numberOfShafts0;
	private int numberOfShafts1;
	private int shaftDiameter0;
	private int shaftDiameter1;
	private int filmThickness0;
	private int filmThickness1;
	private int warmUpTime0;
	private int warmUpTime1;
	private int laminationTemperature0;
	private int laminationTemperature1;
	private int laminatingSpeed0;
	private int laminatingSpeed1;
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
	
	public SearchLaminators(){}

	public String[] getTypeProduct() {
		return typeProduct;
	}

	public void setTypeProduct(String[] typeProduct) {
		this.typeProduct = typeProduct;
	}

	public String[] getPreviouslyUsed() {
		return previouslyUsed;
	}

	public void setPreviouslyUsed(String[] previouslyUsed) {
		this.previouslyUsed = previouslyUsed;
	}

	public String[] getLaminatingWidth() {
		return laminatingWidth;
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

	public void setLaminatingWidth(String[] laminatingWidth) {
		this.laminatingWidth = laminatingWidth;
	}

	public String[] getInnings() {
		return innings;
	}

	public void setInnings(String[] innings) {
		this.innings = innings;
	}

	public int getNumberOfShafts0() {
		return numberOfShafts0;
	}

	public void setNumberOfShafts0(int numberOfShafts0) {
		this.numberOfShafts0 = numberOfShafts0;
	}

	public int getNumberOfShafts1() {
		return numberOfShafts1;
	}

	public void setNumberOfShafts1(int numberOfShafts1) {
		this.numberOfShafts1 = numberOfShafts1;
	}

	public int getShaftDiameter0() {
		return shaftDiameter0;
	}

	public void setShaftDiameter0(int shaftDiameter0) {
		this.shaftDiameter0 = shaftDiameter0;
	}

	public int getShaftDiameter1() {
		return shaftDiameter1;
	}

	public void setShaftDiameter1(int shaftDiameter1) {
		this.shaftDiameter1 = shaftDiameter1;
	}

	public int getFilmThickness0() {
		return filmThickness0;
	}

	public void setFilmThickness0(int filmThickness0) {
		this.filmThickness0 = filmThickness0;
	}

	public int getFilmThickness1() {
		return filmThickness1;
	}

	public void setFilmThickness1(int filmThickness1) {
		this.filmThickness1 = filmThickness1;
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

	public int getLaminationTemperature0() {
		return laminationTemperature0;
	}

	public void setLaminationTemperature0(int laminationTemperature0) {
		this.laminationTemperature0 = laminationTemperature0;
	}

	public int getLaminationTemperature1() {
		return laminationTemperature1;
	}

	public void setLaminationTemperature1(int laminationTemperature1) {
		this.laminationTemperature1 = laminationTemperature1;
	}

	public int getLaminatingSpeed0() {
		return laminatingSpeed0;
	}

	public void setLaminatingSpeed0(int laminatingSpeed0) {
		this.laminatingSpeed0 = laminatingSpeed0;
	}

	public int getLaminatingSpeed1() {
		return laminatingSpeed1;
	}

	public void setLaminatingSpeed1(int laminatingSpeed1) {
		this.laminatingSpeed1 = laminatingSpeed1;
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

}
