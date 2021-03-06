package com.printmaster.nk.components;

public enum ResourceMap {
	CONSTANTS("constants", "/var/www/localhost/products/constant.json"),
	PICTURES_IN_HEAD_MENU("picturesInHeadMenu", "/var/www/localhost/pictures_head_menu.json"),
	LIST_LEFT_LINKS("listLeftLinks", "/var/www/localhost/links.json"),
	
	DESCRIPTIONS("descriptions", "/var/www/localhost/products/descriptions/common.json"),	
	INACCURACY_IN_DESCRIPTION("d_inaccuracy","/var/www/localhost/products/descriptions/inaccuracy_in_description.json"),
	COMMENTS("d_comments","/var/www/localhost/products/descriptions/comments.json"),
	
	DESCRIPTIONS_SEARCH_COMMON("d_search", "/var/www/localhost/products/descriptions/search.json"),
	DESCRIPTIONS_SEARCH_PRINTER("search_printer", "/var/www/localhost/products/descriptions/search_printer.json"),
	DESCRIPTIONS_SEARCH_3D_PRINTER("search_3d_printer", "/var/www/localhost/products/descriptions/search_3d_printer.json"),
	DESCRIPTIONS_SEARCH_DIGITAL_PRINTER("search_d_printer", "/var/www/localhost/products/descriptions/search_d_printer.json"),
	DESCRIPTIONS_SEARCH_LAMINATOR("search_laminator", "/var/www/localhost/products/descriptions/search_laminator.json"),
	DESCRIPTIONS_SEARCH_LASER("search_laser", "/var/www/localhost/products/descriptions/search_laser.json"),
	DESCRIPTIONS_SEARCH_CUTTER("search_cutter", "/var/www/localhost/products/descriptions/search_cutter.json"),
	DESCRIPTIONS_SEARCH_SCANNER("search_scanner", "/var/www/localhost/products/descriptions/search_scanner.json"),
	DESCRIPTIONS_SEARCH_PUE("search_pue", "/var/www/localhost/products/descriptions/search_pue.json"),
	DESCRIPTIONS_SEARCH_RIP("search_rip", "/var/www/localhost/products/descriptions/search_rip.json");
	
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
