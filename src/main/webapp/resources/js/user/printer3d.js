/* Для обозначения заполненных полей в поиске */       
$(function() {
    	
    $('.check_boxes').click(function(){
        		
                $( this ).has(':checked').length ? ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) );
                
                checkOptionSearch( $(this),".amount-prise0", ".amount-prise1");
                checkOptionSearch( $(this),".amount-meltingPointOfThePrintingMaterial0", ".amount-meltingPointOfThePrintingMaterial1");
                checkOptionSearch( $(this),".amount-sizeExtruder0", ".amount-sizeExtruder1");
                checkOptionSearch( $(this),".amount-speedPrint0", ".amount-speedPrint1");
                checkOptionSearch( $(this),".amount-maxPowerConsumption0", ".amount-maxPowerConsumption1");
                checkOptionSearch( $(this),".amount-thicknessOfThePrintingLayer0", ".amount-thicknessOfThePrintingLayer1");
                checkOptionSearch( $(this),".amount-maximumWeightOfThePrintedModel0", ".amount-maximumWeightOfThePrintedModel1");
                checkOptionSearch( $(this),".amount-weight0", ".amount-weight1");
                checkOptionSearch( $(this),".amount-width0", ".amount-width1");
                checkOptionSearch( $(this),".amount-depth0", ".amount-depth1");
                checkOptionSearch( $(this),".amount-heigth0", ".amount-heigth1");
                checkOptionSearch( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");
                checkOptionSearch( $(this),".amount-speedOfMovingThePrintHead0", ".amount-speedOfMovingThePrintHead1");
                checkOptionSearch( $(this),".amount-positioningAccuracyOfThePrintHead0", ".amount-positioningAccuracyOfThePrintHead1");
                checkOptionSearch( $(this),".amount-numberOfFansForBlowingModels0", ".amount-numberOfFansForBlowingModels1");   

             	if( $( this ).has(".amount-sizePrintableAreaX0").length>0 )
                	($( this ).find(".amount-sizePrintableAreaX0").val() != $( this ).find(".amount-sizePrintableAreaX1").val())
                	|| ($( this ).find(".amount-sizePrintableAreaY0").val() != $( this ).find(".amount-sizePrintableAreaY1").val())
                	|| ($( this ).find(".amount-sizePrintableAreaZ0").val() != $( this ).find(".amount-sizePrintableAreaZ1").val()) ?
                			ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) );

        	});

/*--- пошли слайдеры ---*/
    
    rangeSearch(".slider-range-speedOfMovingThePrintHead", ".amount-speedOfMovingThePrintHead0", ".amount-speedOfMovingThePrintHead1", 0, 1000);
    rangeSearch(".slider-range-positioningAccuracyOfThePrintHead", ".amount-positioningAccuracyOfThePrintHead0",
			".amount-positioningAccuracyOfThePrintHead1", 0, 1000);
    rangeSearch(".slider-range-numberOfFansForBlowingModels", ".amount-numberOfFansForBlowingModels0", ".amount-numberOfFansForBlowingModels1", 0, 100);
    rangeSearch(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
    rangeSearch(".slider-range-sizePrintableAreaX", ".amount-sizePrintableAreaX0", ".amount-sizePrintableAreaX1", 1, 1000);
    rangeSearch(".slider-range-sizePrintableAreaY", ".amount-sizePrintableAreaY0", ".amount-sizePrintableAreaY1", 1, 1000);
    rangeSearch(".slider-range-sizePrintableAreaZ", ".amount-sizePrintableAreaZ0", ".amount-sizePrintableAreaZ1", 1, 1000);
	
	/*---- Средняя потребляемая мощность ----*/ 
    rangeSearch(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 1000);
	
    rangeSearch(".slider-range-meltingPointOfThePrintingMaterial", ".amount-meltingPointOfThePrintingMaterial0", ".amount-meltingPointOfThePrintingMaterial1", 1, 500);
    rangeSearch(".slider-range-sizeExtruder", ".amount-sizeExtruder0", ".amount-sizeExtruder1", 0, 2);
    rangeSearch(".slider-range-speedPrint", ".amount-speedPrint0", ".amount-speedPrint1", 1, 1000);
    rangeSearch(".slider-range-thicknessOfThePrintingLayer", ".amount-thicknessOfThePrintingLayer0", ".amount-thicknessOfThePrintingLayer1", 1, 500);
    rangeSearch(".slider-range-maximumWeightOfThePrintedModel", ".amount-maximumWeightOfThePrintedModel0", ".amount-maximumWeightOfThePrintedModel1", 0, 100);
    rangeSearch(".slider-range-maxPowerConsumption", ".amount-maxPowerConsumption0", ".amount-maxPowerConsumption1", 0, 100000);
	/*--- для веса ----*/
    rangeSearch(".slider-range-weight", ".amount-weight0", ".amount-weight1", 0, 5000);
	/*--- для ширины ---*/
    rangeSearch(".slider-range-width", ".amount-width0", ".amount-width1", 0, 10000);
	/*--- для высоты ---*/
    rangeSearch(".slider-range-heigth", ".amount-heigth0", ".amount-heigth1", 0, 10000);
	/*--- для глубины ---*/
    rangeSearch(".slider-range-depth", ".amount-depth0", ".amount-depth1", 0, 10000);
  	
});