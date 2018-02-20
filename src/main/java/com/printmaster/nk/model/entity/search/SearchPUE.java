package com.printmaster.nk.model.entity.search;

import java.io.Serializable;
import java.util.Arrays;

public class SearchPUE implements Serializable {

	private static final long serialVersionUID = 6702501013538481082L;

	private double prise0;
	private double prise1;
	private String[] type;
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

	public SearchPUE() {
	}

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

	public String[] getType() {
		return type;
	}

	public void setType(String[] type) {
		this.type = type;
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

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append("SEARCH PREVIOUSLY USED EQUIPMENT details:");
		
		if(prise0 > 0){
			result.append(" prise0=" + prise0);
		}
		
		if(prise1 > 0){
			result.append(" prise1=" + prise1);
		}
		
		if(type!=null && type.length > 0){
			result.append(" type=" + Arrays.toString(type));
		}
		
		if(typePrinter!=null && typePrinter.length > 0){
			result.append(" typePrinter=" + Arrays.toString(typePrinter));
		}
		
		if(printerEquipment!=null && printerEquipment.length > 0){
			result.append(" printerEquipment=" + Arrays.toString(printerEquipment));
		}
		
		if(type3dPrinter!=null && type3dPrinter.length > 0){
			result.append(" type3dPrinter=" + Arrays.toString(type3dPrinter));
		}
		
		if(d3PrinterEquipment!=null && d3PrinterEquipment.length > 0){
			result.append(" d3PrinterEquipment=" + Arrays.toString(d3PrinterEquipment));
		}
		
		if(typeDigitalPrinter!=null && typeDigitalPrinter.length > 0){
			result.append(" typeDigitalPrinter=" + Arrays.toString(typeDigitalPrinter));
		}
		
		if(digitalPrinterEquipment!=null && digitalPrinterEquipment.length > 0){
			result.append(" digitalPrinterEquipment=" + Arrays.toString(digitalPrinterEquipment));
		}
		
		if(typeLaminator!=null && typeLaminator.length > 0){
			result.append(" typeLaminator=" + Arrays.toString(typeLaminator));
		}
		
		if(laminatorEquipment!=null && laminatorEquipment.length > 0){
			result.append(" laminatorEquipment=" + Arrays.toString(laminatorEquipment));
		}
		
		if(typeLaser!=null && typeLaser.length > 0){
			result.append(" typeLaser=" + Arrays.toString(typeLaser));
		}
		
		if(laserEquipment!=null && laserEquipment.length > 0){
			result.append(" laserEquipment=" + Arrays.toString(laserEquipment));
		}
		
		if(typeCutter!=null && typeCutter.length > 0){
			result.append(" typeCutter=" + Arrays.toString(typeCutter));
		}
		
		if(cutterEquipment!=null && cutterEquipment.length > 0){
			result.append(" cutterEquipment=" + Arrays.toString(cutterEquipment));
		}
		
		if(typeScanner!=null && typeScanner.length > 0){
			result.append(" typeScanner=" + Arrays.toString(typeScanner));
		}
		
		if(scannerEquipment!=null && scannerEquipment.length > 0){
			result.append(" scannerEquipment=" + Arrays.toString(scannerEquipment));
		}
		
		return result.toString();
	}

}
