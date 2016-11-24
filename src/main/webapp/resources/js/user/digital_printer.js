
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
                
            	checkOption( $(this),".amount-prise0", ".amount-prise1"); 
            	checkOption( $(this),".amount-numberOfPagesPerMonth0", ".amount-numberOfPagesPerMonth1"); 
            	checkOption( $(this),".amount-warmUpTime0", ".amount-warmUpTime1"); 
            	checkOption( $(this),".amount-speedPrintBW0", ".amount-speedPrintBW1"); 
            	checkOption( $(this),".amount-maxPowerConsumption0", ".amount-maxPowerConsumption1"); 
            	checkOption( $(this),".amount-speedPrintColor0", ".amount-speedPrintColor1"); 
            	checkOption( $(this),".amount-speedCopyBW0", ".amount-speedCopyBW1"); 
            	checkOption( $(this),".amount-speedCopyColor0", ".amount-speedCopyColor1"); 
            	checkOption( $(this),".amount-firstPrintColor0", ".amount-firstPrintColor1");                 		
            	checkOption( $(this),".amount-firstPrintBW0", ".amount-firstPrintBW1"); 
            	checkOption( $(this),".amount-scanSpeedColor0", ".amount-scanSpeedColor1"); 
            	checkOption( $(this),".amount-scanSpeedBW0", ".amount-scanSpeedBW1"); 
            	checkOption( $(this),".amount-firstCopyOutTime0", ".amount-firstCopyOutTime1");                     	                    
            	checkOption( $(this),".amount-zooming0", ".amount-zooming1"); 
            	checkOption( $(this),".amount-stepZoom0", ".amount-stepZoom1");    
            	checkOption( $(this),".amount-theMaximumNumberOfCopiesPerCycle0", ".amount-theMaximumNumberOfCopiesPerCycle1"); 
            	checkOption( $(this),".amount-paperFeedStandart0", ".amount-paperFeedStandart1");                     	                    
            	checkOption( $(this),".amount-paperFeedMax0", ".amount-paperFeedMax1"); 
            	checkOption( $(this),".amount-paperOutputStandart0", ".amount-paperOutputStandart1");                 
            	checkOption( $(this),".amount-paperOutputMax0", ".amount-paperOutputMax1"); 
            	checkOption( $(this),".amount-theCapacityOfTheBypassTray0", ".amount-theCapacityOfTheBypassTray1");                     	                    
            	checkOption( $(this),".amount-paperDensity0", ".amount-paperDensity1"); 
            	checkOption( $(this),".amount-resourceDeveloper0", ".amount-resourceDeveloper1");
            	checkOption( $(this),".amount-resourceDrum0", ".amount-resourceDrum1"); 
            	checkOption( $(this),".amount-resourceBWCartridgeToner0", ".amount-resourceBWCartridgeToner1");
            	checkOption( $(this),".amount-numberOfCartridges0", ".amount-numberOfCartridges1"); 
            	checkOption( $(this),".amount-memory0", ".amount-memory1");
            	checkOption( $(this),".amount-hardDriveCapacity0", ".amount-hardDriveCapacity1"); 
            	checkOption( $(this),".amount-theNumberOfInstalledPostScriptFonts0", ".amount-theNumberOfInstalledPostScriptFonts1");            	
            	checkOption( $(this),".amount-theNumberOfInstalledPCLFonts0", ".amount-theNumberOfInstalledPCLFonts1"); 
            	checkOption( $(this),".amount-displaySize0", ".amount-displaySize1");
            	checkOption( $(this),".amount-weight0", ".amount-weight1"); 
            	checkOption( $(this),".amount-width0", ".amount-width1");   
            	checkOption( $(this),".amount-depth0", ".amount-depth1");            	
            	checkOption( $(this),".amount-heigth0", ".amount-heigth1");
            	checkOption( $(this),".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1");

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
        	range(".slider-range-averagePowerConsumption", ".amount-averagePowerConsumption0", ".amount-averagePowerConsumption1", 0, 100000);
        	
        	/*---- Количество страниц в месяц ----*/
        	range(".slider-range-numberOfPagesPerMonth", ".amount-numberOfPagesPerMonth0", ".amount-numberOfPagesPerMonth1", 1, 1000000);
        	
        	/*---- Время разогрева ----*/ 
        	range(".slider-range-warmUpTime", ".amount-warmUpTime0", ".amount-warmUpTime1", 1, 100);  
        	
        	/*---- Скорость печати для ч/б печати ----*/
        	range(".slider-range-speedPrintBW", ".amount-speedPrintBW0", ".amount-speedPrintBW1", 1, 1000);
        	 
        	/*---- Скорость печати для цветной печати ----*/ 
        	range(".slider-range-speedPrintColor", ".amount-speedPrintColor0", ".amount-speedPrintColor1", 1, 1000);
        	
        	/*---- Скорость копирования для ч/б печати ----*/
        	range(".slider-range-speedCopyBW", ".amount-speedCopyBW0", ".amount-speedCopyBW1", 1, 1000);
        	
        	/*---- Скорость копирования для цветной печати ----*/ 
        	range(".slider-range-speedCopyColor", ".amount-speedCopyColor0", ".amount-speedCopyColor1", 1, 1000);
        	
        	/*---- Время выхода первого отпечатка color ----*/
        	range(".slider-range-firstPrintColor", ".amount-firstPrintColor0", ".amount-firstPrintColor1", 1, 100);
        	
        	/*---- Время выхода первого отпечатка BW ----*/
        	range(".slider-range-firstPrintBW", ".amount-firstPrintBW0", ".amount-firstPrintBW1", 1, 100);
        	
        	/*---- Скорость сканирования (цветн.) ----*/
        	range(".slider-range-scanSpeedColor", ".amount-scanSpeedColor0", ".amount-scanSpeedColor1", 1, 1000);
        	
        	/*---- Скорость сканирования (ч/б) ----*/ 
        	range(".slider-range-scanSpeedBW", ".amount-scanSpeedBW0", ".amount-scanSpeedBW1", 1, 1000);
        	
        	/*---- Время выхода первой копии ----*/ 
        	range(".slider-range-firstCopyOutTime", ".amount-firstCopyOutTime0", ".amount-firstCopyOutTime1", 1, 100);
        	
        	/*---- Изменение масштаба ----*/
        	range(".slider-range-zooming", ".amount-zooming0", ".amount-zooming1", 0, 1000);
        	
        	/*---- Шаг масштабирования ----*/
        	range(".slider-range-stepZoom", ".amount-stepZoom0", ".amount-stepZoom1", 1, 10);
        	
        	/*---- Максимальное количество копий за цикл ----*/ 
        	range(".slider-range-theMaximumNumberOfCopiesPerCycle",
        			".amount-theMaximumNumberOfCopiesPerCycle0", ".amount-theMaximumNumberOfCopiesPerCycle1", 1, 100);
        	
        	/*---- Подача бумаги (стандартная) ----*/  
        	range(".slider-range-paperFeedStandart", ".amount-paperFeedStandart0", ".amount-paperFeedStandart1", 1, 100);
        	
        	/*---- Подача бумаги (максимальная) ----*/
        	range(".slider-range-paperFeedMax", ".amount-paperFeedMax0", ".amount-paperFeedMax1", 1, 100);
        	
        	/*---- Вывод бумаги (стандартная) ----*/ 
        	range(".slider-range-paperOutputStandart", ".amount-paperOutputStandart0", ".amount-paperOutputStandart1", 1, 100);
        	
        	/*---- Вывод бумаги (максимальная) ----*/
        	range(".slider-range-paperOutputMax", ".amount-paperOutputMax0", ".amount-paperOutputMax1", 1, 100);
        	
        	/*---- Емкость лотка ручной подачи ----*/
        	range(".slider-range-theCapacityOfTheBypassTray", ".amount-theCapacityOfTheBypassTray0", ".amount-theCapacityOfTheBypassTray1", 1, 100);
        	
        	/*---- Плотность бумаги ----*/
        	range(".slider-range-paperDensity", ".amount-paperDensity0", ".amount-paperDensity1", 1, 1000);
        	
        	/*---- Ресурс девелопера ----*/
        	range(".slider-range-resourceDeveloper", ".amount-resourceDeveloper0", ".amount-resourceDeveloper1", 1, 10000000);
        	
        	/*---- Ресурс фотобарабана ----*/
        	range(".slider-range-resourceDrum", ".amount-resourceDrum0", ".amount-resourceDrum1", 1, 10000000);
        	
        	/*---- Ресурс ч/б картриджа/тонера ----*/
        	range(".slider-range-resourceBWCartridgeToner", ".amount-resourceBWCartridgeToner0", ".amount-resourceBWCartridgeToner1", 1, 10000000);
        	
        	/*---- Количество картриджей ----*/ 
        	range(".slider-range-numberOfCartridges", ".amount-numberOfCartridges0", ".amount-numberOfCartridges1", 1, 10);
        	
        	/*---- Объем памяти ----*/
        	range(".slider-range-memory", ".amount-memory0", ".amount-memory1", 1, 100000);
        	
        	/*---- Емкость жесткого диска ----*/ 
        	range(".slider-range-hardDriveCapacity", ".amount-hardDriveCapacity0", ".amount-hardDriveCapacity1", 1, 10000);
        	
        	/*---- Количество установленных шрифтов PostScript ----*/
        	range(".slider-range-theNumberOfInstalledPostScriptFonts", ".amount-theNumberOfInstalledPostScriptFonts0",
        			".amount-theNumberOfInstalledPostScriptFonts1", 1, 10000);
        	
        	/*---- Количество установленных шрифтов PCL ----*/
        	range(".slider-range-theNumberOfInstalledPCLFonts", ".amount-theNumberOfInstalledPCLFonts0", ".amount-theNumberOfInstalledPCLFonts1", 1, 10000);
        	
        	/*---- Диагональ дисплея ----*/ 
        	range(".slider-range-displaySize", ".amount-displaySize0", ".amount-displaySize1", 1, 30);
        	
        	/*--- для максимальной потребляемой мощности ----*/
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
            $(".search_criteria .block_title").click(function(){
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