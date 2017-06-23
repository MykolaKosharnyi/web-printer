package com.printmaster.nk.components;

public enum ResourceMap {
	DESCRIPTIONS("descriptions", "/var/www/localhost/products/descriptions_common.json"),
	CONSTANTS("constants", "/var/www/localhost/products/constant.json"),
	PICTURES_IN_HEAD_MENU("picturesInHeadMenu", "/var/www/localhost/pictures_head_menu.json"),
	LIST_LEFT_LINKS("listLeftLinks", "/var/www/localhost/links.json");

	private String name;
	private String path;
	
	ResourceMap(String name, String path){
		this.name=name;
		this.path=path;
	}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}
	
}
