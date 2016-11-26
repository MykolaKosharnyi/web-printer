
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
                checkOption( $(this),".amount-meltingPointOfThePrintingMaterial0", ".amount-meltingPointOfThePrintingMaterial1");
                checkOption( $(this),".amount-sizeExtruder0", ".amount-sizeExtruder1");
                checkOption( $(this),".amount-speedPrint0", ".amount-speedPrint1");
                checkOption( $(this),".amount-maxPowerConsumption0", ".amount-maxPowerConsumption1");
                checkOption( $(this),".amount-thicknessOfThePrintingLayer0", ".amount-thicknessOfThePrintingLayer1");
                checkOption( $(this),".amount-maximumWeightOfThePrintedModel0", ".amount-maximumWeightOfThePrintedModel1");
                checkOption( $(this),".amount-weight0", ".amount-weight1");
                checkOption( $(this),".amount-width0", ".amount-width1");
                checkOption( $(this),".amount-depth0", ".amount-depth1");
                checkOption( $(this),".amount-heigth0", ".amount-heigth1");
                checkOption( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");
                checkOption( $(this),".amount-speedOfMovingThePrintHead0", ".amount-speedOfMovingThePrintHead1");
                checkOption( $(this),".amount-positioningAccuracyOfThePrintHead0", ".amount-positioningAccuracyOfThePrintHead1");
                checkOption( $(this),".amount-numberOfFansForBlowingModels0", ".amount-numberOfFansForBlowingModels1");   

             	if($( this ).has(".amount-sizePrintableAreaX0").length>0)
                	($( this ).find(".amount-sizePrintableAreaX0").val() != $( this ).find(".amount-sizePrintableAreaX1").val())
                	|| ($( this ).find(".amount-sizePrintableAreaY0").val() != $( this ).find(".amount-sizePrintableAreaY1").val())
                	|| ($( this ).find(".amount-sizePrintableAreaZ0").val() != $( this ).find(".amount-sizePrintableAreaZ1").val()) ?
                			ifCheckedOption( $(this) ): ifUnCheckedOption( $(this) );

        	});
        	
        });		

/*--- пошли слайдеры ---*/
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
	 
	range(".slider-range-speedOfMovingThePrintHead", ".amount-speedOfMovingThePrintHead0", ".amount-speedOfMovingThePrintHead1", 0, 1000);
	range(".slider-range-positioningAccuracyOfThePrintHead", ".amount-positioningAccuracyOfThePrintHead0",
			".amount-positioningAccuracyOfThePrintHead1", 0, 1000);
	range(".slider-range-numberOfFansForBlowingModels", ".amount-numberOfFansForBlowingModels0", ".amount-numberOfFansForBlowingModels1", 0, 100);
	range(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
	range(".slider-range-sizePrintableAreaX", ".amount-sizePrintableAreaX0", ".amount-sizePrintableAreaX1", 1, 1000);
	range(".slider-range-sizePrintableAreaY", ".amount-sizePrintableAreaY0", ".amount-sizePrintableAreaY1", 1, 1000);
	range(".slider-range-sizePrintableAreaZ", ".amount-sizePrintableAreaZ0", ".amount-sizePrintableAreaZ1", 1, 1000);
	
	/*---- Средняя потребляемая мощность ----*/ 
	range(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 1000);
	
	range(".slider-range-meltingPointOfThePrintingMaterial", ".amount-meltingPointOfThePrintingMaterial0", ".amount-meltingPointOfThePrintingMaterial1", 1, 500);
	range(".slider-range-sizeExtruder", ".amount-sizeExtruder0", ".amount-sizeExtruder1", 0, 2);
	range(".slider-range-speedPrint", ".amount-speedPrint0", ".amount-speedPrint1", 1, 1000);
	range(".slider-range-thicknessOfThePrintingLayer", ".amount-thicknessOfThePrintingLayer0", ".amount-thicknessOfThePrintingLayer1", 1, 500);
	range(".slider-range-maximumWeightOfThePrintedModel", ".amount-maximumWeightOfThePrintedModel0", ".amount-maximumWeightOfThePrintedModel1", 0, 100);
	range(".slider-range-maxPowerConsumption", ".amount-maxPowerConsumption0", ".amount-maxPowerConsumption1", 0, 100000);
	/*--- для веса ----*/
	range(".slider-range-weight", ".amount-weight0", ".amount-weight1", 0, 5000);
	/*--- для ширины ---*/
	range(".slider-range-width", ".amount-width0", ".amount-width1", 0, 10000);
	/*--- для высоты ---*/
	range(".slider-range-heigth", ".amount-heigth0", ".amount-heigth1", 0, 10000);
	/*--- для глубины ---*/
	range(".slider-range-depth", ".amount-depth0", ".amount-depth1", 0, 10000);
  	
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
                }else{
                    check.slideUp();
                 /*   check.css('display', 'none');*/
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
