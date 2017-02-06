package com.printmaster.nk.model.entity.search;

import java.io.Serializable;

public class SearchRips extends SearchGeneric implements Serializable{

private static final long serialVersionUID = 6702501013538481082L;

private String[] typeEquipment;
private String[] softwareMaker;
private String[] softwareClass;
private String[] softwareVersion;

public SearchRips(){}

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

@Override
public String[] getTypeProduct() {
	return getTypeEquipment();
}

@Override
public void setTypeProduct(String[] typeProduct) {
	setTypeEquipment(typeEquipment);
}


}
