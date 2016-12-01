
		/* Для обозначения заполненных полей в поиске */       
        $(function() {

        	$('.check_boxes').click(function(){
        		
                $( this ).has(':checked').length ? ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) );

                checkOptionSearch( $(this),".amount-prise0", ".amount-prise1");
                checkOptionSearch( $(this),".amount-mechanicalResolution0", ".amount-mechanicalResolution1");
                checkOptionSearch( $(this),".amount-softwareResolution0", ".amount-softwareResolution1");
                checkOptionSearch( $(this),".amount-frequencySpindle0", ".amount-frequencySpindle1");
                checkOptionSearch( $(this),".amount-processingSpeedXY0", ".amount-processingSpeedXY1");
                checkOptionSearch( $(this),".amount-processingSpeedZ0", ".amount-processingSpeedZ1");
                checkOptionSearch( $(this),".amount-max_power_consumption0", ".amount-max_power_consumption1");
                checkOptionSearch( $(this),".amount-weight0", ".amount-weight1");
                checkOptionSearch( $(this),".amount-width0", ".amount-width1");
                checkOptionSearch( $(this),".amount-depth0", ".amount-depth1");
                checkOptionSearch( $(this),".amount-heigth0", ".amount-heigth1");
                checkOptionSearch( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");       	        	       	       		              
                
       	        if($( this ).has(".amount-sizeWorkAreaX0").length>0)
       	        	($( this ).find(".amount-sizeWorkAreaX0").val() != $( this ).find(".amount-sizeWorkAreaX1").val())
       	            	|| ($( this ).find(".amount-sizeWorkAreaY0").val() != $( this ).find(".amount-sizeWorkAreaY1").val())
       	            	|| ($( this ).find(".amount-sizeWorkAreaZ0").val() != $( this ).find(".amount-sizeWorkAreaZ1").val()) ?
       	            			ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) );		

             });
        	
        	
        	 /*---- диапазон для цены ----*/   
        	rangeSearch(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
        	
        	/*---- Средняя потребляемая мощность ----*/
        	rangeSearch(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 100000);
        	
        	/*--- Для рабочей области ---*/
        	rangeSearch(".slider-range-sizeWorkAreaX", ".amount-sizeWorkAreaX0", ".amount-sizeWorkAreaX1", 1, 1000);
        	rangeSearch(".slider-range-sizeWorkAreaY", ".amount-sizeWorkAreaY0", ".amount-sizeWorkAreaY1", 1, 1000);
        	rangeSearch(".slider-range-sizeWorkAreaZ", ".amount-sizeWorkAreaZ0", ".amount-sizeWorkAreaZ1", 1, 1000);
        	
        	/*--- Механическое разрешение ----*/
        	rangeSearch(".slider-range-mechanicalResolution", ".amount-mechanicalResolution0", ".amount-mechanicalResolution1", 0, 100);
        	
        	/*--- Программное разрешение ----*/
        	rangeSearch(".slider-range-softwareResolution", ".amount-softwareResolution0", ".amount-softwareResolution1", 0, 100);
        	
        	/*--- Частота вращения шпинделя ----*/
        	rangeSearch(".slider-range-frequencySpindle", ".amount-frequencySpindle0", ".amount-frequencySpindle1", 100, 10000);
        	
        	/*--- Скорость обработки(XY) ----*/
        	rangeSearch(".slider-range-processingSpeedXY", ".amount-processingSpeedXY0", ".amount-processingSpeedXY1", 0, 100);
        	
        	/*--- Скорость обработки(Z) ----*/
        	rangeSearch(".slider-range-processingSpeedZ", ".amount-processingSpeedZ0", ".amount-processingSpeedZ1", 0, 500);
        	
        	/*--- для максимальной потребляемой мощности ----*/
        	rangeSearch(".slider-range-max_power_consumption", ".amount-max_power_consumption0", ".amount-max_power_consumption1", 0, 1000);
        	
        	/*--- для веса ----*/
        	rangeSearch(".slider-range-weight", ".amount-weight0", ".amount-weight1", 0, 5000);
        	
        	/*--- для ширины ---*/
        	rangeSearch(".slider-range-width", ".amount-width0", ".amount-width1", 0, 10000);
        	
        	/*--- для высоты ---*/
        	rangeSearch(".slider-range-heigth", ".amount-heigth0", ".amount-heigth1", 0, 10000);
        	
        	/*--- для глубины ---*/
        	rangeSearch(".slider-range-depth", ".amount-depth0", ".amount-depth1", 0, 10000);        	
      });	

