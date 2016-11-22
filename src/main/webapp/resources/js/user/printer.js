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

                $( this ).has(':checked').length ? ifCheckedOption( $(this) ): ifUnCheckedOption( $(this) ) ;
       	       			
       	       	checkOption( $(this),".amount-sizeDropRangeFrom", ".amount-sizeDropRangeUntil");       	       				
       	       	checkOption( $(this),".amount-prise0", ".amount-prise1");			
       	       	checkOption( $(this),".amount-speed-print0", ".amount-speed-print1");	
       	       	checkOption( $(this),".amount-maximum_weight_of_vehicle0", ".amount-maximum_weight_of_vehicle1");       	       	
       	        	       	       		
       	        checkOption( $(this),".amount-max_power_consumption0", ".amount-max_power_consumption1");	
       	        checkOption( $(this),".amount-weight0", ".amount-weight1");             	
       	        checkOption( $(this),".amount-width0", ".amount-width1");
       	        checkOption( $(this),".amount-depth0", ".amount-depth1");       	        
       	        checkOption( $(this),".amount-heigth0", ".amount-heigth1");        	        
       	        checkOption( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");        	        
                     				
               if($( this ).has(".amount-maximum_media_thickness60_0").length>0)
            	   ($( this ).find(".amount-maximum_media_thickness60_0").val() != $( this ).find(".amount-maximum_media_thickness60_1").val())
            	   	|| ($( this ).find(".amount-maximum_media_thickness500_0").val() != $( this ).find(".amount-maximum_media_thickness500_1").val()) ?
            	   			ifCheckedOption( $(this) ): ifUnCheckedOption( $(this) ) ;
             });
        	
        });
               
        $(function() {
        	
        	function range(range, left_edge, right_edge, min_val, max_val){
//        		 $(function() {
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
//        		 })
        	}
        	
        	 /*---- диапазон для цены ----*/   
        	range(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
        	
        	/*---- диапазон для поиска по определенной ширине ----*/ 
        	range(".slider-range-weightPrintMMRange", ".amount-weightPrintMMRangeFrom", ".amount-weightPrintMMRangeUntil", 1, 5400);
        	
        	/*---- диапазон для размера капли ----*/  
        	range(".slider-range-size-drop", ".amount-sizeDropRangeFrom", ".amount-sizeDropRangeUntil", 0, 100);
        	
        	/*---- Средняя потребляемая мощность ----*/
        	range(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 100000);
        	
        	/*---- диапазон для скорости печати----*/ 
        	range(".slider-range-speed-print", ".amount-speed-print0", ".amount-speed-print1", 1, 300);
        	
        	/*---- диапазон для максимальной толщины носителя ----*/
            /*для диапазона от 1 до 60*/
        	range(".slider-range-maximum_media_thickness60", ".amount-maximum_media_thickness60_0", ".amount-maximum_media_thickness60_1", 1, 60);
        	/*для диапазона от 60 до 500*/
        	range(".slider-range-maximum_media_thickness500", ".amount-maximum_media_thickness500_0", ".amount-maximum_media_thickness500_1", 60, 500);
        	
        	/*--- для максимального веса носителя ---*/
        	range(".slider-range-maximum_weight_of_vehicle", ".amount-maximum_weight_of_vehicle0", ".amount-maximum_weight_of_vehicle1", 5, 500);
        	
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
                  /*  check.css('display', 'block');*/
                    check_point.addClass('opened');
		   /* $(this).find("i, p").css('color','#006080');*/
                }else{
                    check.slideUp();
                 /*   check.css('display', 'none');*/
                    check_point.removeClass('opened');
		   /* $(this).find("i, p").css('color','rgb(144, 144, 144)');*/
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
        
    	
        /* for type print head */
    	$( function(){
                $(".block_search_criteria .block_check_boxes .outer_type_print_head .print_series").click(function(){
                    var check = $(this).parent('.outer_type_print_head').find(".inner_block_print_head");
					var check_input = $(this).parent('.outer_type_print_head').find(".check_print_head");
    		
                    if (check.css('display') == 'none') {
                        check.slideDown();
						check_input.prop("checked", false );
                    }else{
                        check.slideUp();
						check_input.prop("checked", true );
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
