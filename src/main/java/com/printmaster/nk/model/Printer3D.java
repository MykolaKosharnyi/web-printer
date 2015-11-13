package com.printmaster.nk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="printer3d")
public class Printer3D extends Model{

	private static final long serialVersionUID = -3145839526222670744L;

	@Column(name="type_printer")//тип принтера
	private String typePrinter3D;
	
	@Column(name="size_printable_area_x")
	private int sizePrintableAreaX;//Размер запечатываемой области по оси Х
	
	@Column(name="size_printable_area_y")
	private int sizePrintableAreaY;//Размер запечатываемой области по оси Y
	
	@Column(name="size_printable_area_z")
	private int sizePrintableAreaZ;//Размер запечатываемой области по оси Z
	
	@Column(name="print_technology")
	private String printTechnology;//Технология печати
	
	@Column(name="chromaticity")
	private String[] chromaticity;
	
	@Column(name="type_of_printhead")
	private String typeOfPrinthead;
	
	@Column(name="melting_point_of_the_printing_material")
	private int meltingPointOfThePrintingMaterial;//Температура плавления печатного материала
	
	@Column(name="media")
	private String[] media;//Материал для печати
	
	@Column(name="size_extruder")
	private double sizeExtruder;//Размер эктрудера
	
	@Column(name="speed_print")
	private int speedPrint;
	
	@Column(name="thickness_of_the_printing_layer")
	private int thicknessOfThePrintingLayer;//Толщина слоя печати
	
	@Column(name="interface_connection")
	private String[] interfaceConnection;
	
	@Column(name="types_of_files")
	private String[] typesOfFiles;//Тыпы файлов
	
	@Column(name="rip")
	private String[] rip;
	
	@Column(name="maximum_weight_of_the_printed_model")
	private int maximumWeightOfThePrintedModel;//Максимальная масса распечатываемой модели 

	public Printer3D() {}

	public String[] getChromaticity() {
		return chromaticity;
	}

	public void setChromaticity(String[] chromaticity) {
		this.chromaticity = chromaticity;
	}

	public double getSizeExtruder() {
		return sizeExtruder;
	}

	public void setSizeExtruder(double sizeExtruder) {
		this.sizeExtruder = sizeExtruder;
	}

	public String getTypePrinter3D() {
		return typePrinter3D;
	}

	public void setTypePrinter3D(String typePrinter3D) {
		this.typePrinter3D = typePrinter3D;
	}

	public int getSizePrintableAreaX() {
		return sizePrintableAreaX;
	}

	public void setSizePrintableAreaX(int sizePrintableAreaX) {
		this.sizePrintableAreaX = sizePrintableAreaX;
	}

	public int getSizePrintableAreaY() {
		return sizePrintableAreaY;
	}

	public void setSizePrintableAreaY(int sizePrintableAreaY) {
		this.sizePrintableAreaY = sizePrintableAreaY;
	}

	public int getSizePrintableAreaZ() {
		return sizePrintableAreaZ;
	}

	public void setSizePrintableAreaZ(int sizePrintableAreaZ) {
		this.sizePrintableAreaZ = sizePrintableAreaZ;
	}

	public String getPrintTechnology() {
		return printTechnology;
	}

	public void setPrintTechnology(String printTechnology) {
		this.printTechnology = printTechnology;
	}

	public String getTypeOfPrinthead() {
		return typeOfPrinthead;
	}

	public void setTypeOfPrinthead(String typeOfPrinthead) {
		this.typeOfPrinthead = typeOfPrinthead;
	}

	public int getMeltingPointOfThePrintingMaterial() {
		return meltingPointOfThePrintingMaterial;
	}

	public void setMeltingPointOfThePrintingMaterial(int meltingPointOfThePrintingMaterial) {
		this.meltingPointOfThePrintingMaterial = meltingPointOfThePrintingMaterial;
	}

	public String[] getMedia() {
		return media;
	}

	public void setMedia(String[] media) {
		this.media = media;
	}

	public int getSpeedPrint() {
		return speedPrint;
	}

	public void setSpeedPrint(int speedPrint) {
		this.speedPrint = speedPrint;
	}

	public int getThicknessOfThePrintingLayer() {
		return thicknessOfThePrintingLayer;
	}

	public void setThicknessOfThePrintingLayer(int thicknessOfThePrintingLayer) {
		this.thicknessOfThePrintingLayer = thicknessOfThePrintingLayer;
	}

	public String[] getInterfaceConnection() {
		return interfaceConnection;
	}

	public void setInterfaceConnection(String[] interfaceConnection) {
		this.interfaceConnection = interfaceConnection;
	}

	public String[] getTypesOfFiles() {
		return typesOfFiles;
	}

	public void setTypesOfFiles(String[] typesOfFiles) {
		this.typesOfFiles = typesOfFiles;
	}

	public String[] getRip() {
		return rip;
	}

	public void setRip(String[] rip) {
		this.rip = rip;
	}

	public int getMaximumWeightOfThePrintedModel() {
		return maximumWeightOfThePrintedModel;
	}

	public void setMaximumWeightOfThePrintedModel(int maximumWeightOfThePrintedModel) {
		this.maximumWeightOfThePrintedModel = maximumWeightOfThePrintedModel;
	}
	
}
