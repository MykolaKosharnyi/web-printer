package com.printmaster.nk.model;

import java.io.Serializable;

public class SearchPUE implements Serializable{

private static final long serialVersionUID = 6702501013538481082L;

private double prise0;
private double prise1;
private String[] typePrinter;
private String[] printerEquipment;
private String[] type3dPrinter;
private String[] d3PrinterEquipment;
private String[] typeDigitalPrinter;
private String[] digitalPrinterEquipment;
private String[] typeLaminator;
private String[] laminatorEquipment;
private String[] typeLaser;
private String[] laserEquipment;
private String[] typeCutter;
private String[] cutterEquipment;
private String[] typeScanner;
private String[] scannerEquipment;

public SearchPUE(){}

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
public String[] getTypePrinter() {
	return typePrinter;
}
public void setTypePrinter(String[] typePrinter) {
	this.typePrinter = typePrinter;
}
public String[] getPrinterEquipment() {
	return printerEquipment;
}
public void setPrinterEquipment(String[] printerEquipment) {
	this.printerEquipment = printerEquipment;
}
public String[] getType3dPrinter() {
	return type3dPrinter;
}
public void setType3dPrinter(String[] type3dPrinter) {
	this.type3dPrinter = type3dPrinter;
}
public String[] getD3PrinterEquipment() {
	return d3PrinterEquipment;
}
public void setD3PrinterEquipment(String[] d3PrinterEquipment) {
	this.d3PrinterEquipment = d3PrinterEquipment;
}
public String[] getTypeDigitalPrinter() {
	return typeDigitalPrinter;
}
public void setTypeDigitalPrinter(String[] typeDigitalPrinter) {
	this.typeDigitalPrinter = typeDigitalPrinter;
}
public String[] getDigitalPrinterEquipment() {
	return digitalPrinterEquipment;
}
public void setDigitalPrinterEquipment(String[] digitalPrinterEquipment) {
	this.digitalPrinterEquipment = digitalPrinterEquipment;
}
public String[] getTypeLaminator() {
	return typeLaminator;
}
public void setTypeLaminator(String[] typeLaminator) {
	this.typeLaminator = typeLaminator;
}
public String[] getLaminatorEquipment() {
	return laminatorEquipment;
}
public void setLaminatorEquipment(String[] laminatorEquipment) {
	this.laminatorEquipment = laminatorEquipment;
}
public String[] getTypeLaser() {
	return typeLaser;
}
public void setTypeLaser(String[] typeLaser) {
	this.typeLaser = typeLaser;
}
public String[] getLaserEquipment() {
	return laserEquipment;
}
public void setLaserEquipment(String[] laserEquipment) {
	this.laserEquipment = laserEquipment;
}
public String[] getTypeCutter() {
	return typeCutter;
}
public void setTypeCutter(String[] typeCutter) {
	this.typeCutter = typeCutter;
}
public String[] getCutterEquipment() {
	return cutterEquipment;
}
public void setCutterEquipment(String[] cutterEquipment) {
	this.cutterEquipment = cutterEquipment;
}
public String[] getTypeScanner() {
	return typeScanner;
}
public void setTypeScanner(String[] typeScanner) {
	this.typeScanner = typeScanner;
}
public String[] getScannerEquipment() {
	return scannerEquipment;
}
public void setScannerEquipment(String[] scannerEquipment) {
	this.scannerEquipment = scannerEquipment;
}

}
