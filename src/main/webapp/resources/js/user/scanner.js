
/* Для обозначения заполненных полей в поиске */       
$(function() {
        	
    $('.check_boxes').click(function(){
        		
    	$( this ).has(':checked').length ? ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) );
                
    	checkOptionSearch( $(this),".amount-prise0", ".amount-prise1");
    	checkOptionSearch( $(this),".amount-scanSpeed0", ".amount-scanSpeed1");
    	checkOptionSearch( $(this),".amount-softwareResolution0", ".amount-softwareResolution1");
    	checkOptionSearch( $(this),".amount-theMaximumThicknessOfTheCarrier0", ".amount-theMaximumThicknessOfTheCarrier1");
    	checkOptionSearch( $(this),".amount-max_power_consumption0", ".amount-max_power_consumption1");
    	checkOptionSearch( $(this),".amount-weight0", ".amount-weight1");
    	checkOptionSearch( $(this),".amount-width0", ".amount-width1");
    	checkOptionSearch( $(this),".amount-depth0", ".amount-depth1");
    	checkOptionSearch( $(this),".amount-heigth0", ".amount-heigth1");
    	checkOptionSearch( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");                   

	});
	
	 /*---- диапазон для цены ----*/   
    rangeSearch(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
	/*---- Средняя потребляемая мощность ----*/
    rangeSearch(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 1000);
	/*---- диапазон для Программное разрешение ----*/   
    rangeSearch(".slider-range-softwareResolution", ".amount-softwareResolution0", ".amount-softwareResolution1", 25, 19200);
	/*---- диапазон для Скорость сканирования ----*/ 
    rangeSearch(".slider-range-scanSpeed", ".amount-scanSpeed0", ".amount-scanSpeed1", 0, 20);
	/*---- диапазон для Максимальная толщина  носителя ----*/   
    rangeSearch(".slider-range-theMaximumThicknessOfTheCarrier", ".amount-theMaximumThicknessOfTheCarrier0", ".amount-theMaximumThicknessOfTheCarrier1", 0, 20);
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
