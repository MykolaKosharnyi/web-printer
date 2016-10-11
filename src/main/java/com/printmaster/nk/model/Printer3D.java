package com.printmaster.nk.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="printer3d")
public class Printer3D extends HeadProduct{

	private static final long serialVersionUID = -3145839526222670744L;

	@NotEmpty(message = "Please enter type of product.")
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
	
	@Column(name="typeExtruder")
	private String typeExtruder;//Тип Экструдера
	
	@Column(name="extruderNumber", nullable = false, columnDefinition = "int default 0")
	private int extruderNumber;//Количество экструдеров
	
	@Column(name="speedOfMovingThePrintHead", nullable = false, columnDefinition = "int default 0")
	private int speedOfMovingThePrintHead;//Скорость перемещения печатной головки
	
	@Column(name="positioningAccuracyOfThePrintHead", nullable = false, columnDefinition = "int default 0")
	private int positioningAccuracyOfThePrintHead;//Точность позиционирования печатной головки
	
	@Column(name="airflowModels")
	private String airflowModels;//Обдув модели
	
	@Column(name="numberOfFansForBlowingModels", nullable = false, columnDefinition = "int default 0")
	private int numberOfFansForBlowingModels;//Кол-во вентиляторов для обдува модели

	public Printer3D() {}

	public String getTypeExtruder() {
		return typeExtruder;
	}

	public void setTypeExtruder(String typeExtruder) {
		this.typeExtruder = typeExtruder;
	}

	public int getExtruderNumber() {
		return extruderNumber;
	}

	public void setExtruderNumber(int extruderNumber) {
		this.extruderNumber = extruderNumber;
	}

	public int getSpeedOfMovingThePrintHead() {
		return speedOfMovingThePrintHead;
	}

	public void setSpeedOfMovingThePrintHead(int speedOfMovingThePrintHead) {
		this.speedOfMovingThePrintHead = speedOfMovingThePrintHead;
	}

	public int getPositioningAccuracyOfThePrintHead() {
		return positioningAccuracyOfThePrintHead;
	}

	public void setPositioningAccuracyOfThePrintHead(int positioningAccuracyOfThePrintHead) {
		this.positioningAccuracyOfThePrintHead = positioningAccuracyOfThePrintHead;
	}

	public String getAirflowModels() {
		return airflowModels;
	}

	public void setAirflowModels(String airflowModels) {
		this.airflowModels = airflowModels;
	}

	public int getNumberOfFansForBlowingModels() {
		return numberOfFansForBlowingModels;
	}

	public void setNumberOfFansForBlowingModels(int numberOfFansForBlowingModels) {
		this.numberOfFansForBlowingModels = numberOfFansForBlowingModels;
	}

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

	@Override
	public String toString() {
		return "Printer3D: typePrinter3D=" + typePrinter3D + ", sizePrintableAreaX=" + sizePrintableAreaX
				+ ", sizePrintableAreaY=" + sizePrintableAreaY + ", sizePrintableAreaZ=" + sizePrintableAreaZ
				+ ", printTechnology=" + printTechnology + ", chromaticity=" + Arrays.toString(chromaticity)
				+ ", typeOfPrinthead=" + typeOfPrinthead + ", meltingPointOfThePrintingMaterial="
				+ meltingPointOfThePrintingMaterial + ", media=" + Arrays.toString(media) + ", sizeExtruder="
				+ sizeExtruder + ", speedPrint=" + speedPrint + ", thicknessOfThePrintingLayer="
				+ thicknessOfThePrintingLayer + ", interfaceConnection=" + Arrays.toString(interfaceConnection)
				+ ", typesOfFiles=" + Arrays.toString(typesOfFiles) + ", rip=" + Arrays.toString(rip)
				+ ", maximumWeightOfThePrintedModel=" + maximumWeightOfThePrintedModel + super.toString();
	}
	
}
