/* for showing desctiption on divs wich right of big animation on home page*/
$(function(){
  		$('.rigt_of_reklam_animation div').hover(function(){
    			$(this).find("p").slideDown(50);
   		},
   		function(){
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
           $("#full_menu").click(function(){
               if ( $(".menu").css('display') == 'none' ) {
                     $(".menu").slideDown(1500);
                      } else {
                     $(".menu").slideUp(1500);
                     }
              });
        } ); 

/* Вивід в ліве меню назв продукту і їх ссилок */
jQuery(document).ready(function($) {
	
		/* For printers */	
		$( "li#list_dissolving ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_dissolving').addClass( "menu_list_list" ) : "" ;
		$( "li#list_ecosolvent ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_ecosolvent').addClass( "menu_list_list" ) : "" ;
		$( "li#list_UV_roll ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_UV_roll').addClass( "menu_list_list" ) : "" ;
		$( "li#list_UV_flatbed ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_UV_flatbed').addClass( "menu_list_list" ) : "" ;
		$( "li#list_sublimation ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_sublimation').addClass( "menu_list_list" ) : "" ;
		$( "li#list_textile ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_textile').addClass( "menu_list_list" ) : "" ;
		$( "li#list_water_pigment ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_water_pigment').addClass( "menu_list_list" ) : "" ;
		$( "li#list_digital_printers ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_digital_printers').addClass( "menu_list_list" ) : "" ;
		$( "li#list_SAPR-GIS_printers ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_SAPR-GIS_printers').addClass( "menu_list_list" ) : "" ;
		
		/* For 3d printers */
		$( "li#list_3d_printers_FDM-extruder ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_3d_printers_FDM-extruder').addClass( "menu_list_list" ) : "" ;
		$( "li#list_3d_printers_photo_printing_polyjet ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_3d_printers_photo_printing_polyjet').addClass( "menu_list_list" ) : "" ;
		$( "li#list_3d_printers_laser_sintering_LENS ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_3d_printers_laser_sintering_LENS').addClass( "menu_list_list" ) : "" ;
		$( "li#list_3d_printers_lamination_LOM ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_3d_printers_lamination_LOM').addClass( "menu_list_list" ) : "" ;
		$( "li#list_3d_printers_stereolithography_SL ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_3d_printers_stereolithography_SL').addClass( "menu_list_list" ) : "" ;
		$( "li#list_3d_printers_laser_sintering_LS ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_3d_printers_laser_sintering_LS').addClass( "menu_list_list" ) : "" ;
		$( "li#list_3d_printers_powder_bonding_3DP ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_3d_printers_powder_bonding_3DP').addClass( "menu_list_list" ) : "" ;
		
		/* For digital printers */
		$( "li#list_digital_printer_FullColorLaserPrinters ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_digital_printer_FullColorLaserPrinters').addClass( "menu_list_list" ) : "" ;
		$( "li#list_digital_printer_MonochromeLaserPrinters ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_digital_printer_MonochromeLaserPrinters').addClass( "menu_list_list" ) : "" ;
		$( "li#list_digital_printer_FullColorInkjetPrinters ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_digital_printer_FullColorInkjetPrinters').addClass( "menu_list_list" ) : "" ;
	
		/* For lasers */
		$( "li#list_laser_CO2_gas_lasers ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laser_CO2_gas_lasers').addClass( "menu_list_list" ) : "" ;
		$( "li#list_laser_solid_state_lasers ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laser_solid_state_lasers').addClass( "menu_list_list" ) : "" ;
		$( "li#list_laser_for_the_treatment_of_metal ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laser_for_the_treatment_of_metal').addClass( "menu_list_list" ) : "" ;
		$( "li#list_laser_diode_pumped ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laser_diode_pumped').addClass( "menu_list_list" ) : "" ;
		$( "li#list_laser_fiber_lasers ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laser_fiber_lasers').addClass( "menu_list_list" ) : "" ;
		$( "li#list_laser_plasma_lasers ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laser_plasma_lasers').addClass( "menu_list_list" ) : "" ;
	
		/* For cutters */
		$( "li#list_cutter_for_wood ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_cutter_for_wood').addClass( "menu_list_list" ) : "" ;
		$( "li#list_cutter_for_the_treatment_of_metal ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_cutter_for_the_treatment_of_metal').addClass( "menu_list_list" ) : "" ;
		$( "li#list_cutter_stone_processing ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_cutter_stone_processing').addClass( "menu_list_list" ) : "" ;
		
		/* For laminators */
		$( "li#list_laminators_hot_lamination ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laminators_hot_lamination').addClass( "menu_list_list" ) : "" ;
		$( "li#list_laminators_cold_laminating ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laminators_cold_laminating').addClass( "menu_list_list" ) : "" ;
		$( "li#list_laminators_liquid ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laminators_liquid').addClass( "menu_list_list" ) : "" ;
		$( "li#list_laminators_flatbed_laminating_machine ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_laminators_flatbed_laminating_machine').addClass( "menu_list_list" ) : "" ;
		
		/* For laminators */
		$( "li#list_scanner_large_format_scanners ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_scanner_large_format_scanners').addClass( "menu_list_list" ) : "" ;
		$( "li#list_scanner_3d_scanners ul.menu_drop_drop" ).has( "li" ).length ? $( 'li#list_scanner_3d_scanners').addClass( "menu_list_list" ) : "" ;
}); // ready()