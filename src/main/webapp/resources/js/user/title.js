
/* for searching in input field */
function searchByPhraseIncludeType(typeProduct){
	openInNewTabWinBrowser("/search_by_phrase?type=" + typeProduct + "&phrase=" + $( "input#search_input_by_phrase" ).val() );
}
	
function openInNewTabWinBrowser(url) {
	var win = window.open(url, '_blank');
	win.focus();
}

/* for showing description on divs which right of big animation on home page*/
$(function() {
	$('.rigt_of_reklam_animation div').hover(function() {
		$(this).find("p").slideDown(50);
	}, function() {
		$(this).find("p").slideUp(100);
	});
});


/* Чтобы безопасность пропускала AJAX */
$(function () {
		  var token = $("meta[name='_csrf']").attr("content");
		  var header = $("meta[name='_csrf_header']").attr("content");
		  $(document).ajaxSend(function(e, xhr, options) {
		    xhr.setRequestHeader(header, token);
		  });
		});
/* Для згортання-розгортання лівого меню */
$( function() {
           $("#full_menu i").click(function(){
               if ( $(".menu").css('display') == 'none' ) {
                     $(".menu").slideDown(1500);
                      } else {
                     $(".menu").slideUp(1500);
                     }
              });
        } ); 

/* Вивід в ліве меню назв продукту і їх ссилок */
jQuery(document).ready(function($) {
	
	function menuHasProductInSection(array){

		array.forEach(function(sub_section) {
			$( "li#" + sub_section + " ul.menu_drop_drop" ).has( "li" ).length ? $( "li#" + sub_section).addClass( "menu_list_list" ) : "" ;
		});
				
	}
	
	/* For printers */	
	menuHasProductInSection(["list_dissolving", 
	                         "list_ecosolvent",
	                         "list_UV_roll",
	                         "list_UV_flatbed",
	                         "list_sublimation",
	                         "list_textile",
	                         "list_water_pigment",
	                         "list_digital_printers",
	                         "list_SAPR-GIS_printers"]);
		
	/* For 3d printers */
	menuHasProductInSection(["list_3d_printers_FDM-extruder", 
	                         "list_3d_printers_photo_printing_polyjet",
	                         "list_3d_printers_laser_sintering_LENS",
	                         "list_3d_printers_lamination_LOM",
	                         "list_3d_printers_stereolithography_SL",
	                         "list_3d_printers_laser_sintering_LS",
	                         "list_3d_printers_powder_bonding_3DP"]);
		
	/* For digital printers */
	menuHasProductInSection(["list_digital_printer_FullColorLaserPrinters", 
	                         "list_digital_printer_MonochromeLaserPrinters",
	                         "list_digital_printer_FullColorInkjetPrinters"]);
	
	/* For lasers */
	menuHasProductInSection(["list_laser_CO2_gas_lasers", 
	                         "list_laser_solid_state_lasers",
	                         "list_laser_for_the_treatment_of_metal",
	                         "list_laser_diode_pumped",
	                         "list_laser_fiber_lasers",
	                         "list_laser_plasma_lasers"]);
	
	/* For cutters */
	menuHasProductInSection(["list_cutter_for_wood", 
	                         "list_cutter_for_the_treatment_of_metal",
	                         "list_cutter_stone_processing"]);
	
	/* For laminators */
	menuHasProductInSection(["list_laminators_hot_lamination", 
	                         "list_laminators_cold_laminating",
	                         "list_laminators_liquid",
	                         "list_laminators_flatbed_laminating_machine"]);
		
	/* For scanners */
	menuHasProductInSection(["list_scanner_large_format_scanners", 
	                         "list_scanner_3d_scanners"]);
		
	/* For rips */
	menuHasProductInSection(["list_rip_printing_equipment", 
	                         "list_rip_3D_printers",
	                         "list_rip_laser_milling_equipment",
	                         "list_rip_3D_scanners",
	                         "list_rip_scanners"]);
		
	/* For used with product */
	menuHasProductInSection(["list_use_with_product_ink_for_inkjet", 
	                         "list_use_with_product_consumables_for_digital_equipment",
	                         "list_use_with_product_consumables_for_3D_equipment",
	                         "list_use_with_product_products_for_maintenance",
	                         "list_use_with_product_parts_and_accessories"]);
		
}); // ready()