
/* Для обозначения заполненных полей в поиске */
$(function() {
		
	$('.check_boxes').click(function() {

		$(this).has(':checked').length ? ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) );
		
		checkOptionSearch( $(this),".amount-prise0", ".amount-prise1" );
		checkOptionSearch( $(this),".amount-numberOfShafts0", ".amount-numberOfShafts1" );
		checkOptionSearch( $(this),".amount-shaftDiameter0", ".amount-shaftDiameter1" );
		checkOptionSearch( $(this),".amount-filmThickness0", ".amount-filmThickness1" );
		checkOptionSearch( $(this),".amount-warmUpTime0", ".amount-warmUpTime1" );
		checkOptionSearch( $(this),".amount-laminationTemperature0", ".amount-laminationTemperature1" );
		checkOptionSearch( $(this),".amount-laminatingSpeed0", ".amount-laminatingSpeed1" );
		checkOptionSearch( $(this),".amount-max_power_consumption0", ".amount-max_power_consumption1" );
		checkOptionSearch( $(this),".amount-weight0", ".amount-weight1" );
		checkOptionSearch( $(this),".amount-width0", ".amount-width1" );
		checkOptionSearch( $(this),".amount-depth0", ".amount-depth1" );
		checkOptionSearch( $(this),".amount-heigth0", ".amount-heigth1" );
		checkOptionSearch( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1" );
		
	});
	
	 /*---- диапазон для цены ----*/   
	rangeSearch(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
	
	/*---- Средняя потребляемая мощность ----*/
	rangeSearch(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 100000); 
	
	/*---- Количество валов ----*/
	rangeSearch(".slider-range-numberOfShafts", ".amount-numberOfShafts0", ".amount-numberOfShafts1", 0, 10); 
	
	/*---- Диаметр вала ----*/
	rangeSearch(".slider-range-shaftDiameter", ".amount-shaftDiameter0", ".amount-shaftDiameter1", 0, 1000);
	
	/*---- Толщина пленки ----*/  
	rangeSearch(".slider-range-filmThickness", ".amount-filmThickness0", ".amount-filmThickness1", 0, 1000); 
	
	/*---- Время разогрева ----*/ 
	rangeSearch(".slider-range-warmUpTime", ".amount-warmUpTime0", ".amount-warmUpTime1", 0, 100); 
	
	/*---- Температура ламинации ----*/
	rangeSearch(".slider-range-laminationTemperature", ".amount-laminationTemperature0", ".amount-laminationTemperature1", 0, 500); 
	
	/*---- Скорость ламинирования ----*/ 
	rangeSearch(".slider-range-laminatingSpeed", ".amount-laminatingSpeed0", ".amount-laminatingSpeed1", 0, 1000);
	
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