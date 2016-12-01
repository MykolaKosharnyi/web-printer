		/* Для обозначения заполненных полей в поиске */       
        $(function() {

        	$('.check_boxes').click(function(){
       	       			
                checkOptionSearch( $(this),".amount-sizeDropRangeFrom", ".amount-sizeDropRangeUntil");       	       				
                checkOptionSearch( $(this),".amount-prise0", ".amount-prise1");			
                checkOptionSearch( $(this),".amount-speed-print0", ".amount-speed-print1");	
                checkOptionSearch( $(this),".amount-maximum_weight_of_vehicle0", ".amount-maximum_weight_of_vehicle1");       	       	
       	        
                checkOptionSearch( $(this),".amount-weightPrintMMRangeFrom", ".amount-weightPrintMMRangeUntil");	
                checkOptionSearch( $(this),".amount-max_power_consumption0", ".amount-max_power_consumption1");	
                checkOptionSearch( $(this),".amount-weight0", ".amount-weight1");             	
                checkOptionSearch( $(this),".amount-width0", ".amount-width1");
                checkOptionSearch( $(this),".amount-depth0", ".amount-depth1");       	        
                checkOptionSearch( $(this),".amount-heigth0", ".amount-heigth1");        	        
                checkOptionSearch( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");        	        
                     				
               if($( this ).has(".amount-maximum_media_thickness60_0").length>0)
            	   ($( this ).find(".amount-maximum_media_thickness60_0").val() != $( this ).find(".amount-maximum_media_thickness60_1").val())
            	   	|| ($( this ).find(".amount-maximum_media_thickness500_0").val() != $( this ).find(".amount-maximum_media_thickness500_1").val()) ?
            	   			ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) ) ;
            	   			
            $( this ).has(':checked').length ? ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) ) ;   			
             });

        	 /*---- диапазон для цены ----*/   
        	rangeSearch(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
        	
        	/*---- диапазон для поиска по определенной ширине ----*/ 
        	rangeSearch(".slider-range-weightPrintMMRange", ".amount-weightPrintMMRangeFrom", ".amount-weightPrintMMRangeUntil", 1, 5400);
        	
        	/*---- диапазон для размера капли ----*/  
        	rangeSearch(".slider-range-size-drop", ".amount-sizeDropRangeFrom", ".amount-sizeDropRangeUntil", 0, 100);
        	
        	/*---- Средняя потребляемая мощность ----*/
        	rangeSearch(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 100000);
        	
        	/*---- диапазон для скорости печати----*/ 
        	rangeSearch(".slider-range-speed-print", ".amount-speed-print0", ".amount-speed-print1", 1, 300);
        	
        	/*---- диапазон для максимальной толщины носителя ----*/
            /*для диапазона от 1 до 60*/
        	rangeSearch(".slider-range-maximum_media_thickness60", ".amount-maximum_media_thickness60_0", ".amount-maximum_media_thickness60_1", 1, 60);
        	/*для диапазона от 60 до 500*/
        	rangeSearch(".slider-range-maximum_media_thickness500", ".amount-maximum_media_thickness500_0", ".amount-maximum_media_thickness500_1", 60, 500);
        	
        	/*--- для максимального веса носителя ---*/
        	rangeSearch(".slider-range-maximum_weight_of_vehicle", ".amount-maximum_weight_of_vehicle0", ".amount-maximum_weight_of_vehicle1", 5, 500);
        	
        	/*--- для максимальной потребляемой мощности ----*/
        	rangeSearch(".slider-range-max_power_consumption", ".amount-max_power_consumption0", ".amount-max_power_consumption1", 0, 100000);
        	
        	/*--- для веса ----*/
        	rangeSearch(".slider-range-weight", ".amount-weight0", ".amount-weight1", 0, 5000);
        	
        	/*--- для ширины ---*/
        	rangeSearch(".slider-range-width", ".amount-width0", ".amount-width1", 0, 10000);
        	
        	/*--- для высоты ---*/
        	rangeSearch(".slider-range-heigth", ".amount-heigth0", ".amount-heigth1", 0, 10000);
        	
        	/*--- для глубины ---*/
        	rangeSearch(".slider-range-depth", ".amount-depth0", ".amount-depth1", 0, 10000);
      });

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
    	