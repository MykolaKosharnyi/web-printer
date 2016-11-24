
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
                
                checkOption( $(this),".amount-prise0", ".amount-prise1" );
                checkOption( $(this),".amount-powerOfLaser0", ".amount-powerOfLaser1" );
                checkOption( $(this),".amount-mechanicalResolution0", ".amount-mechanicalResolution1" );
                checkOption( $(this),".amount-softwareResolution0", ".amount-softwareResolution1" );
                checkOption( $(this),".amount-minimumThicknessOfCut0", ".amount-minimumThicknessOfCut1" );
                checkOption( $(this),".amount-engravingSpeed0", ".amount-engravingSpeed1" );
                checkOption( $(this),".amount-cuttingSpeed0", ".amount-cuttingSpeed1" );
                checkOption( $(this),".amount-max_power_consumption0", ".amount-max_power_consumption1" );
                checkOption( $(this),".amount-weight0", ".amount-weight1" );
                checkOption( $(this),".amount-width0", ".amount-width1" );
                checkOption( $(this),".amount-depth0", ".amount-depth1" );
                checkOption( $(this),".amount-heigth0", ".amount-heigth1" );
                checkOption( $(this),".amount-maximumResolution0", ".amount-maximumResolution1" );
                checkOption( $(this),".amount-firstPartAdjustingTheLaserPower", ".amount-secondPartAdjustingTheLaserPower" );
                checkOption( $(this),".amount-powerOfLaser0", ".amount-powerOfLaser1" );
                checkOption( $(this),".amount-laserPulse0", ".amount-laserPulse1" );
                checkOption( $(this),".amount-theDiameterOfTheLaser0", ".amount-theDiameterOfTheLaser1" );
                checkOption( $(this),".amount-engravingDepth0", ".amount-engravingDepth1" );
                checkOption( $(this),".amount-laserSource0", ".amount-laserSource1" );
                checkOption( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1" );
                checkOption( $(this),".amount-laserWavelength0", ".amount-laserWavelength1" );
       	        	       	       		
       	        if($( this ).has(".amount-sizeWorkAreaX0").length>0)
       	        	($( this ).find(".amount-sizeWorkAreaX0").val() != $( this ).find(".amount-sizeWorkAreaX1").val())
       	            	|| ($( this ).find(".amount-sizeWorkAreaY0").val() != $( this ).find(".amount-sizeWorkAreaY1").val())
       	            	|| ($( this ).find(".amount-sizeWorkAreaZ0").val() != $( this ).find(".amount-sizeWorkAreaZ1").val()) ?
       	            			ifCheckedOption( $(this) ): ifUnCheckedOption( $(this) );		

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
        	
        	/*---- Ресурс лазера ----*/ 
        	range(".slider-range-laserSource", ".amount-laserSource0", ".amount-laserSource1", 0, 10000000); 	
        	
        	/*---- Глубина гравировки ----*/ 
        	range(".slider-range-engravingDepth", ".amount-engravingDepth0", ".amount-engravingDepth1", 0, 1000);
        	
        	/*---- Максимальное разрешение ----*/ 
        	range(".slider-range-maximumResolution", ".amount-maximumResolution0", ".amount-maximumResolution1", 0, 100000); 	
        	
        	/*---- Регулировка мощности лазера ----*/ 
        	range(".slider-range-adjustingTheLaserPower", ".amount-firstPartAdjustingTheLaserPower", ".amount-secondPartAdjustingTheLaserPower", 0, 1000);
        	
        	/*---- Длинна волны лазера ----*/
        	range(".slider-range-laserWavelength", ".amount-laserWavelength0", ".amount-laserWavelength1", 0, 100000); 
        	
        	/*---- Импульс лазера ----*/ 
        	range(".slider-range-laserPulse", ".amount-laserPulse0", ".amount-laserPulse1", 0, 100000);
        	
        	/*---- Диаметр лазера ----*/
        	range(".slider-range-theDiameterOfTheLaser", ".amount-theDiameterOfTheLaser0", ".amount-theDiameterOfTheLaser1", 0, 1000); 
        	
        	/*--- Для рабочей области ---*/
        	range(".slider-range-sizeWorkAreaX", ".amount-sizeWorkAreaX0", ".amount-sizeWorkAreaX1", 1, 1000); 	
        	range(".slider-range-sizeWorkAreaY", ".amount-sizeWorkAreaY0", ".amount-sizeWorkAreaY1", 1, 1000);
        	range(".slider-range-sizeWorkAreaZ", ".amount-sizeWorkAreaZ0", ".amount-sizeWorkAreaZ1", 1, 1000);
        	
        	/*--- Мощность лазера ----*/
        	range(".slider-range-powerOfLaser", ".amount-powerOfLaser0", ".amount-powerOfLaser1", 0, 1000);
        	
        	/*--- Механическое разрешение ----*/
        	range(".slider-range-mechanicalResolution", ".amount-mechanicalResolution0", ".amount-mechanicalResolution1", 0, 100); 	
        	
        	/*--- Программное разрешение ----*/
        	range(".slider-range-softwareResolution", ".amount-softwareResolution0", ".amount-softwareResolution1", 0, 100); 
        	
        	/*--- Минимальная толщина реза ----*/
        	range(".slider-range-minimumThicknessOfCut", ".amount-minimumThicknessOfCut0", ".amount-minimumThicknessOfCut1", 0, 10000); 	
        	
        	/*--- Скорость гравировки ----*/
        	range(".slider-range-engravingSpeed", ".amount-engravingSpeed0", ".amount-engravingSpeed1", 0, 10000); 	
        	
        	/*--- Скорость резки ----*/
        	range(".slider-range-cuttingSpeed", ".amount-cuttingSpeed0", ".amount-cuttingSpeed1", 0, 10000); 
        	
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
