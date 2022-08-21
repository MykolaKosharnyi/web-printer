package com.mykoshar.shop.api.model.dao.impl;

public enum TypeProductContainer {
	PRINTER("printer"), PRINTER_3D("3d_printer"),DIGITAL_PRINTER("digital_printer"),
	CUTTER("cutter"), LAMINATOR("laminator"),LASER("laser"), SCANNER("scanner"), USE_WITH_PRODUCT("use_with_product");
	
	private String type;
	
	private TypeProductContainer(String type){
		this.type=type;
	}

	public String getType() {
		return type;
	}
	
	
}
