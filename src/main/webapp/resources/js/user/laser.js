
/* Для обозначения заполненных полей в поиске */       
$(function() {  
        	
        	$('.check_boxes').click(function(){
        		
                $( this ).has(':checked').length ? ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) );
                
                checkOptionSearch( $(this),".amount-prise0", ".amount-prise1" );
                checkOptionSearch( $(this),".amount-powerOfLaser0", ".amount-powerOfLaser1" );
                checkOptionSearch( $(this),".amount-mechanicalResolution0", ".amount-mechanicalResolution1" );
                checkOptionSearch( $(this),".amount-softwareResolution0", ".amount-softwareResolution1" );
                checkOptionSearch( $(this),".amount-minimumThicknessOfCut0", ".amount-minimumThicknessOfCut1" );
                checkOptionSearch( $(this),".amount-engravingSpeed0", ".amount-engravingSpeed1" );
                checkOptionSearch( $(this),".amount-cuttingSpeed0", ".amount-cuttingSpeed1" );
                checkOptionSearch( $(this),".amount-max_power_consumption0", ".amount-max_power_consumption1" );
                checkOptionSearch( $(this),".amount-weight0", ".amount-weight1" );
                checkOptionSearch( $(this),".amount-width0", ".amount-width1" );
                checkOptionSearch( $(this),".amount-depth0", ".amount-depth1" );
                checkOptionSearch( $(this),".amount-heigth0", ".amount-heigth1" );
                checkOptionSearch( $(this),".amount-maximumResolution0", ".amount-maximumResolution1" );
                checkOptionSearch( $(this),".amount-firstPartAdjustingTheLaserPower", ".amount-secondPartAdjustingTheLaserPower" );
                checkOptionSearch( $(this),".amount-powerOfLaser0", ".amount-powerOfLaser1" );
                checkOptionSearch( $(this),".amount-laserPulse0", ".amount-laserPulse1" );
                checkOptionSearch( $(this),".amount-theDiameterOfTheLaser0", ".amount-theDiameterOfTheLaser1" );
                checkOptionSearch( $(this),".amount-engravingDepth0", ".amount-engravingDepth1" );
                checkOptionSearch( $(this),".amount-laserSource0", ".amount-laserSource1" );
                checkOptionSearch( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1" );
                checkOptionSearch( $(this),".amount-laserWavelength0", ".amount-laserWavelength1" );
       	        	       	       		
       	        if($( this ).has(".amount-sizeWorkAreaX0").length>0)
       	        	($( this ).find(".amount-sizeWorkAreaX0").val() != $( this ).find(".amount-sizeWorkAreaX1").val())
       	            	|| ($( this ).find(".amount-sizeWorkAreaY0").val() != $( this ).find(".amount-sizeWorkAreaY1").val())
       	            	|| ($( this ).find(".amount-sizeWorkAreaZ0").val() != $( this ).find(".amount-sizeWorkAreaZ1").val()) ?
       	            			ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) );		

             });
        	
        	 /*---- диапазон для цены ----*/   
        	rangeSearch(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
        	
        	/*---- Средняя потребляемая мощность ----*/
        	rangeSearch(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 1000); 	
        	
        	/*---- Ресурс лазера ----*/ 
        	rangeSearch(".slider-range-laserSource", ".amount-laserSource0", ".amount-laserSource1", 0, 10000000); 	
        	
        	/*---- Глубина гравировки ----*/ 
        	rangeSearch(".slider-range-engravingDepth", ".amount-engravingDepth0", ".amount-engravingDepth1", 0, 1000);
        	
        	/*---- Максимальное разрешение ----*/ 
        	rangeSearch(".slider-range-maximumResolution", ".amount-maximumResolution0", ".amount-maximumResolution1", 0, 100000); 	
        	
        	/*---- Регулировка мощности лазера ----*/ 
        	rangeSearch(".slider-range-adjustingTheLaserPower", ".amount-firstPartAdjustingTheLaserPower", ".amount-secondPartAdjustingTheLaserPower", 0, 1000);
        	
        	/*---- Длинна волны лазера ----*/
        	rangeSearch(".slider-range-laserWavelength", ".amount-laserWavelength0", ".amount-laserWavelength1", 0, 100000); 
        	
        	/*---- Импульс лазера ----*/ 
        	rangeSearch(".slider-range-laserPulse", ".amount-laserPulse0", ".amount-laserPulse1", 0, 100000);
        	
        	/*---- Диаметр лазера ----*/
        	rangeSearch(".slider-range-theDiameterOfTheLaser", ".amount-theDiameterOfTheLaser0", ".amount-theDiameterOfTheLaser1", 0, 1000); 
        	
        	/*--- Для рабочей области ---*/
        	rangeSearch(".slider-range-sizeWorkAreaX", ".amount-sizeWorkAreaX0", ".amount-sizeWorkAreaX1", 1, 1000); 	
        	rangeSearch(".slider-range-sizeWorkAreaY", ".amount-sizeWorkAreaY0", ".amount-sizeWorkAreaY1", 1, 1000);
        	rangeSearch(".slider-range-sizeWorkAreaZ", ".amount-sizeWorkAreaZ0", ".amount-sizeWorkAreaZ1", 1, 1000);
        	
        	/*--- Мощность лазера ----*/
        	rangeSearch(".slider-range-powerOfLaser", ".amount-powerOfLaser0", ".amount-powerOfLaser1", 0, 1000);
        	
        	/*--- Механическое разрешение ----*/
        	rangeSearch(".slider-range-mechanicalResolution", ".amount-mechanicalResolution0", ".amount-mechanicalResolution1", 0, 100); 	
        	
        	/*--- Программное разрешение ----*/
        	rangeSearch(".slider-range-softwareResolution", ".amount-softwareResolution0", ".amount-softwareResolution1", 0, 100); 
        	
        	/*--- Минимальная толщина реза ----*/
        	rangeSearch(".slider-range-minimumThicknessOfCut", ".amount-minimumThicknessOfCut0", ".amount-minimumThicknessOfCut1", 0, 10000); 	
        	
        	/*--- Скорость гравировки ----*/
        	rangeSearch(".slider-range-engravingSpeed", ".amount-engravingSpeed0", ".amount-engravingSpeed1", 0, 10000); 	
        	
        	/*--- Скорость резки ----*/
        	rangeSearch(".slider-range-cuttingSpeed", ".amount-cuttingSpeed0", ".amount-cuttingSpeed1", 0, 10000); 
        	
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