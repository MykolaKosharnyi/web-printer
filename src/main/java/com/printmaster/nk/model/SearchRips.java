package com.printmaster.nk.model;

import java.io.Serializable;

public class SearchRips implements Serializable{

private static final long serialVersionUID = 6702501013538481082L;

private double prise0;
private double prise1;
private String[] typeEquipment;
private String[] softwareMaker;
private String[] softwareClass;
private String[] softwareVersion;

public SearchRips(){}

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

public String[] getTypeEquipment() {
	return typeEquipment;
}

public void setTypeEquipment(String[] typeEquipment) {
	this.typeEquipment = typeEquipment;
}

public String[] getSoftwareMaker() {
	return softwareMaker;
}

public void setSoftwareMaker(String[] softwareMaker) {
	this.softwareMaker = softwareMaker;
}

public String[] getSoftwareClass() {
	return softwareClass;
}

public void setSoftwareClass(String[] softwareClass) {
	this.softwareClass = softwareClass;
}

public String[] getSoftwareVersion() {
	return softwareVersion;
}

public void setSoftwareVersion(String[] softwareVersion) {
	this.softwareVersion = softwareVersion;
}


}
