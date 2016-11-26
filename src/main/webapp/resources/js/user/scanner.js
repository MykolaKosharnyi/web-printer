
/* Для обозначения заполненных полей в поиске */       
$(function() {

	function ifCheckedOption(this_object){
		this_object.parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080')
	}
	
	function ifUnCheckedOption(this_object){
		this_object.parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)')	
	}
	
	function checkOption(element, class0, class1){
		if(element.has(class0).length>0)
			element.find(class0).val() != element.find(class1).val() ? ifCheckedOption( element ): ifUnCheckedOption( element ) ;
	}
        	
    $('.check_boxes').click(function(){
        		
    	$( this ).has(':checked').length ? ifCheckedOption( $(this) ): ifUnCheckedOption( $(this) );
                
    	checkOption( $(this),".amount-prise0", ".amount-prise1");
    	checkOption( $(this),".amount-scanSpeed0", ".amount-scanSpeed1");
    	checkOption( $(this),".amount-softwareResolution0", ".amount-softwareResolution1");
    	checkOption( $(this),".amount-theMaximumThicknessOfTheCarrier0", ".amount-theMaximumThicknessOfTheCarrier1");
    	checkOption( $(this),".amount-max_power_consumption0", ".amount-max_power_consumption1");
    	checkOption( $(this),".amount-weight0", ".amount-weight1");
    	checkOption( $(this),".amount-width0", ".amount-width1");
    	checkOption( $(this),".amount-depth0", ".amount-depth1");
    	checkOption( $(this),".amount-heigth0", ".amount-heigth1");
    	checkOption( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");                   

	});

});

$(function() {
	
	function range(range, left_edge, right_edge, min_val, max_val){
    		$( range ).slider({
    	          range: true,
    	          min: min_val,
    	          max: max_val,
    	          create: function () {
    	      	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find( left_edge ).val() );
    	      	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find( right_edge ).val() );
    	      	},
    	          slide: function( event, ui ) {
    	            $( left_edge ).val(ui.values[ 0 ]);
    	            $( right_edge ).val(ui.values[ 1 ]);
    	          }
    	        });
    	            
    	        $( left_edge ).val( $( range ).slider("values", 0 ));             
    	        $( right_edge ).val( $( range ).slider("values", 1 ));
    	            
    	        $( left_edge ).change(function() {
    	        	$( range ).slider('values',0,this.value);
    	            });
    	            
    	        $( right_edge ).change(function() {
    	        	$( range ).slider('values',1,this.value);
    	            });
	}
	
	 /*---- диапазон для цены ----*/   
	range(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
	/*---- Средняя потребляемая мощность ----*/
	range(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 1000);
	/*---- диапазон для Программное разрешение ----*/   
	range(".slider-range-softwareResolution", ".amount-softwareResolution0", ".amount-softwareResolution1", 25, 19200);
	/*---- диапазон для Скорость сканирования ----*/ 
	range(".slider-range-scanSpeed", ".amount-scanSpeed0", ".amount-scanSpeed1", 0, 20);
	/*---- диапазон для Максимальная толщина  носителя ----*/   
	range(".slider-range-theMaximumThicknessOfTheCarrier", ".amount-theMaximumThicknessOfTheCarrier0", ".amount-theMaximumThicknessOfTheCarrier1", 0, 20);
	/*--- для максимальной потребляемой мощности ----*/
	range(".slider-range-max_power_consumption", ".amount-max_power_consumption0", ".amount-max_power_consumption1", 0, 100000);
	/*--- для веса ----*/
	range(".slider-range-weight", ".amount-weight0", ".amount-weight1", 0, 5000);
	/*--- для ширины ---*/
	range(".slider-range-width", ".amount-width0", ".amount-width1", 0, 10000);
	/*--- для высоты ---*/
	range(".slider-range-heigth", ".amount-heigth0", ".amount-heigth1", 0, 10000);
	/*--- для глубины ---*/
	range(".slider-range-depth", ".amount-depth0", ".amount-depth1", 0, 10000);
});

/*-- реализация подпунктов ширины в виде вкладок --*/
          (function($){				
              jQuery.fn.lightTabs = function(options){
                  var createTabs = function(){
                      tabs = this;
                      i = 0;

                      showPage = function(i){
                          $(tabs).children("div").children("div").hide();
                          $(tabs).children("div").children("div").eq(i).show();
                          $(tabs).children("ul").children("li").removeClass("active");
                          $(tabs).children("ul").children("li").eq(i).addClass("active");
                      }

                      showPage(0);				

                      $(tabs).children("ul").children("li").each(function(index, element){
                          $(element).attr("data-page", i);
                          i++;                        
                      });

                      $(tabs).children("ul").children("li").click(function(){
                          showPage(parseInt($(this).attr("data-page")));
                      });				
                  };		
                  return this.each(createTabs);
              };	
          })(jQuery);
          $(document).ready(function(){
              $("#tabs").lightTabs();
          });
          
/*--- реализация выпадающих подпунктов ---*/
        $( function(){
            $(".block_title").click(function(){
                var check = $(this).parent('.search_criteria').find(".check_boxes");
                var check_point = $(this).find("i");
                if (check.css('display') == 'none') {
                    check.slideDown();
                    check_point.addClass('opened');
                }else{
                    check.slideUp();
                    check_point.removeClass('opened');
                }
            });
        } );
        
/* for block characteric */
    	$( function(){
                $(".block_search_criteria .block_block_title").click(function(){
                    var check = $(this).parent('.block_search_criteria').find(".block_check_boxes");
                    var check_point = $(this).find("i").first();
    		var description = $(this).find("p").first();
                    if (check.css('display') == 'none') {
                        check.slideDown();
    		    description.css('color', '#006080');
                        check_point.addClass('opened');
                    }else{
                        check.slideUp();
                        description.css('color', 'rgb(144, 144, 144)');
                        check_point.removeClass('opened');
                    }
                });
            } ); 
        
/*---- Button change display on search block ----*/
        $( function() {
           $("#display_search").click(function(){ 
            var check_point = $(this).find("i");
              if ( $("#search_product").css('display') == 'none' ) {
                     $("#search_product").slideDown(1000);
                     check_point.addClass('opened');
                      } else {
                     $("#search_product").slideUp(1000);
                     check_point.removeClass('opened');
                     }
              });
        } );
