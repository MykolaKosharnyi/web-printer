package com.printmaster.nk.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="printer")
public class Printer extends Model{

	private static final long serialVersionUID = -7914406547800809890L;
	
	@Column(name="type_printer")//тип принтера
	private String typePrinter;
	
	@Column(name="equipment_model")
	private String equipmentModel;
	
	@Column(name="weight_print_mm")
	private int weightPrintMM;
	
	@Column(name="type_print")
	private String[] typePrint;
	
	@Column(name="feed")
	private String[] feed;
	
	@Column(name="chromaticity")
	private String[] chromaticity;
	
	@Column(name="manufacturer_printhead")
	private String manufacturerPrinthead;
	
	@Column(name="type_of_printhead")
	private String typeOfPrinthead;
	
	@Column(name="compatible_ink")
	private String[] compatibleInk; 
	
	@Column(name="type_drops")
	private String[] typeDrops;
	
	@Column(name="size_drops")
	private String[] sizeDrops;
	
	@Column(name="speed_print")
	private int speedPrint;
	
	@Column(name="print_resolution")
	private String[] printResolution;
	
	@Column(name="interface_connection")
	private String[] interfaceConnection;
	
	@Column(name="maximum_media_thickness")
	private int maximumMediaThickness; 
	
	@Column(name="maximum_weight_of_vehicle")
	private int maximumWeightOfVehicle;
	
	@Column(name="rip")
	private String[] rip;
	
	@OneToMany(mappedBy="printer", fetch = FetchType.EAGER/*, orphanRemoval=true*/)
	private Set<OrderPrinter> orderPrinters = new HashSet<OrderPrinter>();

	public Printer() {
		super();
	}

	public String getTypePrinter() {
		return typePrinter;
	}

	public void setTypePrinter(String typePrinter) {
		this.typePrinter = typePrinter;
	}

	public String getEquipmentModel() {
		return equipmentModel;
	}

	public void setEquipmentModel(String equipmentModel) {
		this.equipmentModel = equipmentModel;
	}

	public String[] getChromaticity() {
		return chromaticity;
	}

	public void setChromaticity(String[] chromaticity) {
		this.chromaticity = chromaticity;
	}

	public int getSpeedPrint() {
		return speedPrint;
	}

	public void setSpeedPrint(int speedPrint) {
		this.speedPrint = speedPrint;
	}

	public Set<OrderPrinter> getOrderPrinters() {
		return orderPrinters;
	}

	public void setOrderPrinters(Set<OrderPrinter> orderPrinters) {
		this.orderPrinters = orderPrinters;
	}

	public void setTypeOfPrinthead(String typeOfPrinthead) {
		this.typeOfPrinthead = typeOfPrinthead;
	}

	public String[] getTypePrint() {
		return typePrint;
	}

	public void setTypePrint(String[] typePrint) {
		this.typePrint = typePrint;
	}

	public String[] getFeed() {
		return feed;
	}

	public void setFeed(String[] feed) {
		this.feed = feed;
	}

	public String[] getCompatibleInk() {
		return compatibleInk;
	}

	public void setCompatibleInk(String[] compatibleInk) {
		this.compatibleInk = compatibleInk;
	}

	public String[] getTypeDrops() {
		return typeDrops;
	}

	public void setTypeDrops(String[] typeDrops) {
		this.typeDrops = typeDrops;
	}

	public String[] getSizeDrops() {
		return sizeDrops;
	}

	public void setSizeDrops(String[] sizeDrops) {
		this.sizeDrops = sizeDrops;
	}

	public String[] getPrintResolution() {
		return printResolution;
	}

	public void setPrintResolution(String[] printResolution) {
		this.printResolution = printResolution;
	}

	public String[] getInterfaceConnection() {
		return interfaceConnection;
	}

	public void setInterfaceConnection(String[] interfaceConnection) {
		this.interfaceConnection = interfaceConnection;
	}

	public String[] getRip() {
		return rip;
	}

	public void setRip(String[] rip) {
		this.rip = rip;
	}

	public int getWeightPrintMM() {
		return weightPrintMM;
	}

	public void setWeightPrintMM(int weightPrintMM) {
		this.weightPrintMM = weightPrintMM;
	}

	public String getManufacturerPrinthead() {
		return manufacturerPrinthead;
	}

	public void setManufacturerPrinthead(String manufacturerPrinthead) {
		this.manufacturerPrinthead = manufacturerPrinthead;
	}

	public String getTypeOfPrinthead() {
		return typeOfPrinthead;
	}

	public int getMaximumMediaThickness() {
		return maximumMediaThickness;
	}

	public void setMaximumMediaThickness(int maximumMediaThickness) {
		this.maximumMediaThickness = maximumMediaThickness;
	}

	public int getMaximumWeightOfVehicle() {
		return maximumWeightOfVehicle;
	}

	public void setMaximumWeightOfVehicle(int maximumWeightOfVehicle) {
		this.maximumWeightOfVehicle = maximumWeightOfVehicle;
	}

	@Override
	public String toString() {
		return "Printer: typePrinter=" + typePrinter + ", equipmentModel=" + equipmentModel + ", weightPrintMM="
				+ weightPrintMM + ", typePrint=" + Arrays.toString(typePrint) + ", feed=" + Arrays.toString(feed)
				+ ", chromaticity=" + Arrays.toString(chromaticity) + ", manufacturerPrinthead=" + manufacturerPrinthead
				+ ", typeOfPrinthead=" + typeOfPrinthead + ", compatibleInk=" + Arrays.toString(compatibleInk)
				+ ", typeDrops=" + Arrays.toString(typeDrops) + ", sizeDrops=" + Arrays.toString(sizeDrops)
				+ ", speedPrint=" + speedPrint + ", printResolution=" + Arrays.toString(printResolution)
				+ ", interfaceConnection=" + Arrays.toString(interfaceConnection) + ", maximumMediaThickness="
				+ maximumMediaThickness + ", maximumWeightOfVehicle=" + maximumWeightOfVehicle + ", rip="
				+ Arrays.toString(rip) + ", orderPrinters=" + orderPrinters + super.toString();
	}

}