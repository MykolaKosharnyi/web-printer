package com.mykoshar.shop.api.model.entity.search;

import java.io.Serializable;
import java.util.Arrays;

public class SearchRips extends SearchGeneric implements Serializable {

	private static final long serialVersionUID = 6702501013538481082L;

	private String[] typeEquipment;
	private String[] softwareMaker;
	private String[] softwareClass;
	private String[] softwareVersion;

	public SearchRips() {
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

	@Override
	public String[] getTypeProduct() {
		return getTypeEquipment();
	}

	@Override
	public void setTypeProduct(String[] typeProduct) {
		setTypeEquipment(typeEquipment);
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SEARCH RIP details:");
		
		if(typeEquipment!=null && typeEquipment.length > 0){
			result.append(" typeEquipment=" + Arrays.toString(typeEquipment));
		}
		
		if(softwareMaker!=null && softwareMaker.length > 0){
			result.append(" softwareMaker=" + Arrays.toString(softwareMaker));
		}
		
		if(softwareClass!=null && softwareClass.length > 0){
			result.append(" softwareClass=" + Arrays.toString(softwareClass));
		}
		
		if(softwareVersion!=null && softwareVersion.length > 0){
			result.append(" softwareVersion=" + Arrays.toString(softwareVersion));
		}
		
		return result.toString();
	}

}
