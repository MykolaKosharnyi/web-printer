
/* Для обозначения заполненных полей в поиске */       
        $(function() {
    		
        	$('.check_boxes').click(function(){
        		
                $( this ).has(':checked').length ? ifCheckedOptionSearch( $(this) ): ifUnCheckedOptionSearch( $(this) ) ;		
                
            	checkOptionSearch( $(this),".amount-prise0", ".amount-prise1"); 
            	checkOptionSearch( $(this),".amount-numberOfPagesPerMonth0", ".amount-numberOfPagesPerMonth1"); 
            	checkOptionSearch( $(this),".amount-warmUpTime0", ".amount-warmUpTime1"); 
            	checkOptionSearch( $(this),".amount-speedPrintBW0", ".amount-speedPrintBW1"); 
            	checkOptionSearch( $(this),".amount-maxPowerConsumption0", ".amount-maxPowerConsumption1"); 
            	checkOptionSearch( $(this),".amount-speedPrintColor0", ".amount-speedPrintColor1"); 
            	checkOptionSearch( $(this),".amount-speedCopyBW0", ".amount-speedCopyBW1"); 
            	checkOptionSearch( $(this),".amount-speedCopyColor0", ".amount-speedCopyColor1"); 
            	checkOptionSearch( $(this),".amount-firstPrintColor0", ".amount-firstPrintColor1");                 		
            	checkOptionSearch( $(this),".amount-firstPrintBW0", ".amount-firstPrintBW1"); 
            	checkOptionSearch( $(this),".amount-scanSpeedColor0", ".amount-scanSpeedColor1"); 
            	checkOptionSearch( $(this),".amount-scanSpeedBW0", ".amount-scanSpeedBW1"); 
            	checkOptionSearch( $(this),".amount-firstCopyOutTime0", ".amount-firstCopyOutTime1");                     	                    
            	checkOptionSearch( $(this),".amount-zooming0", ".amount-zooming1"); 
            	checkOptionSearch( $(this),".amount-stepZoom0", ".amount-stepZoom1");    
            	checkOptionSearch( $(this),".amount-theMaximumNumberOfCopiesPerCycle0", ".amount-theMaximumNumberOfCopiesPerCycle1"); 
            	checkOptionSearch( $(this),".amount-paperFeedStandart0", ".amount-paperFeedStandart1");                     	                    
            	checkOptionSearch( $(this),".amount-paperFeedMax0", ".amount-paperFeedMax1"); 
            	checkOptionSearch( $(this),".amount-paperOutputStandart0", ".amount-paperOutputStandart1");                 
            	checkOptionSearch( $(this),".amount-paperOutputMax0", ".amount-paperOutputMax1"); 
            	checkOptionSearch( $(this),".amount-theCapacityOfTheBypassTray0", ".amount-theCapacityOfTheBypassTray1");                     	                    
            	checkOptionSearch( $(this),".amount-paperDensity0", ".amount-paperDensity1"); 
            	checkOptionSearch( $(this),".amount-resourceDeveloper0", ".amount-resourceDeveloper1");
            	checkOptionSearch( $(this),".amount-resourceDrum0", ".amount-resourceDrum1"); 
            	checkOptionSearch( $(this),".amount-resourceBWCartridgeToner0", ".amount-resourceBWCartridgeToner1");
            	checkOptionSearch( $(this),".amount-numberOfCartridges0", ".amount-numberOfCartridges1"); 
            	checkOptionSearch( $(this),".amount-memory0", ".amount-memory1");
            	checkOptionSearch( $(this),".amount-hardDriveCapacity0", ".amount-hardDriveCapacity1"); 
            	checkOptionSearch( $(this),".amount-theNumberOfInstalledPostScriptFonts0", ".amount-theNumberOfInstalledPostScriptFonts1");            	
            	checkOptionSearch( $(this),".amount-theNumberOfInstalledPCLFonts0", ".amount-theNumberOfInstalledPCLFonts1"); 
            	checkOptionSearch( $(this),".amount-displaySize0", ".amount-displaySize1");
            	checkOptionSearch( $(this),".amount-weight0", ".amount-weight1"); 
            	checkOptionSearch( $(this),".amount-width0", ".amount-width1");   
            	checkOptionSearch( $(this),".amount-depth0", ".amount-depth1");            	
            	checkOptionSearch( $(this),".amount-heigth0", ".amount-heigth1");
            	checkOptionSearch( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");

             });

        	 /*---- диапазон для цены ----*/   
        	rangeSearch(".slider-range-prise", ".amount-prise0", ".amount-prise1", 0, 1000000);
        	
        	/*---- Средняя потребляемая мощность ----*/
        	rangeSearch(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 100000);
        	
        	/*---- Количество страниц в месяц ----*/
        	rangeSearch(".slider-range-numberOfPagesPerMonth", ".amount-numberOfPagesPerMonth0", ".amount-numberOfPagesPerMonth1", 1, 1000000);
        	
        	/*---- Время разогрева ----*/ 
        	rangeSearch(".slider-range-warmUpTime", ".amount-warmUpTime0", ".amount-warmUpTime1", 1, 100);  
        	
        	/*---- Скорость печати для ч/б печати ----*/
        	rangeSearch(".slider-range-speedPrintBW", ".amount-speedPrintBW0", ".amount-speedPrintBW1", 1, 1000);
        	 
        	/*---- Скорость печати для цветной печати ----*/ 
        	rangeSearch(".slider-range-speedPrintColor", ".amount-speedPrintColor0", ".amount-speedPrintColor1", 1, 1000);
        	
        	/*---- Скорость копирования для ч/б печати ----*/
        	rangeSearch(".slider-range-speedCopyBW", ".amount-speedCopyBW0", ".amount-speedCopyBW1", 1, 1000);
        	
        	/*---- Скорость копирования для цветной печати ----*/ 
        	rangeSearch(".slider-range-speedCopyColor", ".amount-speedCopyColor0", ".amount-speedCopyColor1", 1, 1000);
        	
        	/*---- Время выхода первого отпечатка color ----*/
        	rangeSearch(".slider-range-firstPrintColor", ".amount-firstPrintColor0", ".amount-firstPrintColor1", 1, 100);
        	
        	/*---- Время выхода первого отпечатка BW ----*/
        	rangeSearch(".slider-range-firstPrintBW", ".amount-firstPrintBW0", ".amount-firstPrintBW1", 1, 100);
        	
        	/*---- Скорость сканирования (цветн.) ----*/
        	rangeSearch(".slider-range-scanSpeedColor", ".amount-scanSpeedColor0", ".amount-scanSpeedColor1", 1, 1000);
        	
        	/*---- Скорость сканирования (ч/б) ----*/ 
        	rangeSearch(".slider-range-scanSpeedBW", ".amount-scanSpeedBW0", ".amount-scanSpeedBW1", 1, 1000);
        	
        	/*---- Время выхода первой копии ----*/ 
        	rangeSearch(".slider-range-firstCopyOutTime", ".amount-firstCopyOutTime0", ".amount-firstCopyOutTime1", 1, 100);
        	
        	/*---- Изменение масштаба ----*/
        	rangeSearch(".slider-range-zooming", ".amount-zooming0", ".amount-zooming1", 0, 1000);
        	
        	/*---- Шаг масштабирования ----*/
        	rangeSearch(".slider-range-stepZoom", ".amount-stepZoom0", ".amount-stepZoom1", 1, 10);
        	
        	/*---- Максимальное количество копий за цикл ----*/ 
        	rangeSearch(".slider-range-theMaximumNumberOfCopiesPerCycle",
        			".amount-theMaximumNumberOfCopiesPerCycle0", ".amount-theMaximumNumberOfCopiesPerCycle1", 1, 100);
        	
        	/*---- Подача бумаги (стандартная) ----*/  
        	rangeSearch(".slider-range-paperFeedStandart", ".amount-paperFeedStandart0", ".amount-paperFeedStandart1", 1, 100);
        	
        	/*---- Подача бумаги (максимальная) ----*/
        	rangeSearch(".slider-range-paperFeedMax", ".amount-paperFeedMax0", ".amount-paperFeedMax1", 1, 100);
        	
        	/*---- Вывод бумаги (стандартная) ----*/ 
        	rangeSearch(".slider-range-paperOutputStandart", ".amount-paperOutputStandart0", ".amount-paperOutputStandart1", 1, 100);
        	
        	/*---- Вывод бумаги (максимальная) ----*/
        	rangeSearch(".slider-range-paperOutputMax", ".amount-paperOutputMax0", ".amount-paperOutputMax1", 1, 100);
        	
        	/*---- Емкость лотка ручной подачи ----*/
        	rangeSearch(".slider-range-theCapacityOfTheBypassTray", ".amount-theCapacityOfTheBypassTray0", ".amount-theCapacityOfTheBypassTray1", 1, 100);
        	
        	/*---- Плотность бумаги ----*/
        	rangeSearch(".slider-range-paperDensity", ".amount-paperDensity0", ".amount-paperDensity1", 1, 1000);
        	
        	/*---- Ресурс девелопера ----*/
        	rangeSearch(".slider-range-resourceDeveloper", ".amount-resourceDeveloper0", ".amount-resourceDeveloper1", 1, 10000000);
        	
        	/*---- Ресурс фотобарабана ----*/
        	rangeSearch(".slider-range-resourceDrum", ".amount-resourceDrum0", ".amount-resourceDrum1", 1, 10000000);
        	
        	/*---- Ресурс ч/б картриджа/тонера ----*/
        	rangeSearch(".slider-range-resourceBWCartridgeToner", ".amount-resourceBWCartridgeToner0", ".amount-resourceBWCartridgeToner1", 1, 10000000);
        	
        	/*---- Количество картриджей ----*/ 
        	rangeSearch(".slider-range-numberOfCartridges", ".amount-numberOfCartridges0", ".amount-numberOfCartridges1", 1, 10);
        	
        	/*---- Объем памяти ----*/
        	rangeSearch(".slider-range-memory", ".amount-memory0", ".amount-memory1", 1, 100000);
        	
        	/*---- Емкость жесткого диска ----*/ 
        	rangeSearch(".slider-range-hardDriveCapacity", ".amount-hardDriveCapacity0", ".amount-hardDriveCapacity1", 1, 10000);
        	
        	/*---- Количество установленных шрифтов PostScript ----*/
        	rangeSearch(".slider-range-theNumberOfInstalledPostScriptFonts", ".amount-theNumberOfInstalledPostScriptFonts0",
        			".amount-theNumberOfInstalledPostScriptFonts1", 1, 10000);
        	
        	/*---- Количество установленных шрифтов PCL ----*/
        	rangeSearch(".slider-range-theNumberOfInstalledPCLFonts", ".amount-theNumberOfInstalledPCLFonts0", ".amount-theNumberOfInstalledPCLFonts1", 1, 10000);
        	
        	/*---- Диагональ дисплея ----*/ 
        	rangeSearch(".slider-range-displaySize", ".amount-displaySize0", ".amount-displaySize1", 1, 30);
        	
        	/*--- для максимальной потребляемой мощности ----*/
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
