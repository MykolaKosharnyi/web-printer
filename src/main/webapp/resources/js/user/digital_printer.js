/*----  Для вывода новых принтеров при поиске  -----*/        
		$(document).ready(function() {
			
			$('#search').ajaxForm( {
				type: 'post',
				success: function(products) { 
					$("#out_result_of_search").html('');
					
	                $(products).each(function(i, product) {
	                	var outerDiv = $('<div/>');

	                	var slidePrice = $('<p/>').addClass("products_price").append($('<div/>').text("Цена:").css(
        						{
        							"float":"left",
        							"margin-right": "5px"
        						}));
        				if(product.prise < 0.1){
        					slidePrice.append($('<a/>').attr("href","#callback_reklam").addClass('fancybox').text("\u0443\u0442\u043E\u0447\u043D\u044F\u0439\u0442\u0435"));
        				} else {
        					slidePrice.append($('<div/>').text(checkPrise(product.prise)));
        				}
	                	
	                	outerDiv.addClass("products")
	                				.append($('<a/>').attr("id", "/images/digital_printers/" + product.id + "/" + checkPicture(product.pathPictures))
           								 			 .addClass("link")
	                								 .attr("href", "/digital_printer/" + product.id)
	                								 .append($('<div/>').addClass("outer_a_img").append($('<img/>')
	                										 .attr("src", "/images/digital_printers/" + product.id + "/" + product.pathPictures[0]))))
	                				.append($('<div/>').addClass("name_price_cart_block")
	    	                				.append($('<a/>').attr("href", "/digital_printer/" + product.id).addClass("products_title").text(product.name))
	    	    	                		.append(slidePrice)
	    	    	                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
	            			                			addToCart('digital_printer', product.id, product.name, product.prise+'', product.pathPictures[0]);
	            			                		})))						 

	    	                				if(product.leftSharesLink!=null && product.leftSharesLink!=""){
	    	                	        		outerDiv.append($('<div/>').addClass("ribbon-search-wrapper-left")
	    	                										.append($('<div/>').addClass("ribbon-search-left")
	    	                														   .text(product.leftSharesLink)
	    	                														   .css( "color", product.leftSharesLinkColorText )
	    	                														   .css( "background", product.leftSharesLinkColorFone )
	    	                														   ))
	    	                				}
	    	                	        	
	    	                	        	if(product.rightSharesLink!=null && product.rightSharesLink!=""){
	    	                	        		outerDiv.append($('<div/>').addClass("ribbon-search-wrapper-right")
	    	                										.append($('<div/>').addClass("ribbon-search-right")
	    	                														   .text(product.rightSharesLink)
	    	                														   .css( "color", product.rightSharesLinkColorText )
	    	                														   .css( "background", product.rightSharesLinkColorFone )
	    	                														   ))
	    	                				}
	    	                				
	    	                				
	                	$("#out_result_of_search").append(outerDiv)
	                });
				}
				
				}); 
		});

/* Для обозначения заполненных полей в поиске */       
        $(function() {
        	$('.check_boxes').click(function(){
        		
                $( this ).has(':checked').length ? 
                		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');		
                		
       	        if($( this ).has(".amount-prise0").length>0)
       	        	$( this ).find(".amount-prise0").val() != $( this ).find(".amount-prise1").val() ?
       	        		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                                         	
                if($( this ).has(".amount-numberOfPagesPerMonth0").length>0)
                	$( this ).find(".amount-numberOfPagesPerMonth0").val() != $( this ).find(".amount-numberOfPagesPerMonth1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	                       
                if($( this ).has(".amount-warmUpTime0").length>0)
               		$( this ).find(".amount-warmUpTime0").val() != $( this ).find(".amount-warmUpTime1").val() ?
               	    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
               	    	                       
                if($( this ).has(".amount-speedPrintBW0").length>0)
                	$( this ).find(".amount-speedPrintBW0").val() != $( this ).find(".amount-speedPrintBW1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-maxPowerConsumption0").length>0)
                	$( this ).find(".amount-maxPowerConsumption0").val() != $( this ).find(".amount-maxPowerConsumption1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	                   
                if($( this ).has(".amount-speedPrintColor0").length>0)
                	$( this ).find(".amount-speedPrintColor0").val() != $( this ).find(".amount-speedPrintColor1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	                    
                if($( this ).has(".amount-speedCopyBW0").length>0)
                	$( this ).find(".amount-speedCopyBW0").val() != $( this ).find(".amount-speedCopyBW1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');   
                    	
                if($( this ).has(".amount-speedCopyColor0").length>0)
                	$( this ).find(".amount-speedCopyColor0").val() != $( this ).find(".amount-speedCopyColor1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
               
                if($( this ).has(".amount-firstPrintColor0").length>0)
                	$( this ).find(".amount-firstPrintColor0").val() != $( this ).find(".amount-firstPrintColor1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                
                if($( this ).has(".amount-firstPrintBW0").length>0)
                	$( this ).find(".amount-firstPrintBW0").val() != $( this ).find(".amount-firstPrintBW1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                 
                if($( this ).has(".amount-scanSpeedColor0").length>0)
                	$( this ).find(".amount-scanSpeedColor0").val() != $( this ).find(".amount-scanSpeedColor1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
               
                if($( this ).has(".amount-scanSpeedBW0").length>0)
                	$( this ).find(".amount-scanSpeedBW0").val() != $( this ).find(".amount-scanSpeedBW1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                      
                if($( this ).has(".amount-firstCopyOutTime0").length>0)
                	$( this ).find(".amount-firstCopyOutTime0").val() != $( this ).find(".amount-firstCopyOutTime1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                
                if($( this ).has(".amount-zooming0").length>0)
                	$( this ).find(".amount-zooming0").val() != $( this ).find(".amount-zooming1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-stepZoom0").length>0)
                	$( this ).find(".amount-stepZoom0").val() != $( this ).find(".amount-stepZoom1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                      
                if($( this ).has(".amount-theMaximumNumberOfCopiesPerCycle0").length>0)
               		$( this ).find(".amount-theMaximumNumberOfCopiesPerCycle0").val() != $( this ).find(".amount-theMaximumNumberOfCopiesPerCycle1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                      
                if($( this ).has(".amount-paperFeedStandart0").length>0)
                	$( this ).find(".amount-paperFeedStandart0").val() != $( this ).find(".amount-paperFeedStandart1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-paperFeedMax0").length>0)
                	$( this ).find(".amount-paperFeedMax0").val() != $( this ).find(".amount-paperFeedMax1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-paperOutputStandart0").length>0)
                	$( this ).find(".amount-paperOutputStandart0").val() != $( this ).find(".amount-paperOutputStandart1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-paperOutputMax0").length>0)
                	$( this ).find(".amount-paperOutputMax0").val() != $( this ).find(".amount-paperOutputMax1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-theCapacityOfTheBypassTray0").length>0)
                	$( this ).find(".amount-theCapacityOfTheBypassTray0").val() != $( this ).find(".amount-theCapacityOfTheBypassTray1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                      
                if($( this ).has(".amount-paperDensity0").length>0)
                	$( this ).find(".amount-paperDensity0").val() != $( this ).find(".amount-paperDensity1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-resourceDeveloper0").length>0)
                	$( this ).find(".amount-resourceDeveloper0").val() != $( this ).find(".amount-resourceDeveloper1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-resourceDrum0").length>0)
                	$( this ).find(".amount-resourceDrum0").val() != $( this ).find(".amount-resourceDrum1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-resourceBWCartridgeToner0").length>0)
                	$( this ).find(".amount-resourceBWCartridgeToner0").val() != $( this ).find(".amount-resourceBWCartridgeToner1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-numberOfCartridges0").length>0)
                	$( this ).find(".amount-numberOfCartridges0").val() != $( this ).find(".amount-numberOfCartridges1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-memory0").length>0)
                	$( this ).find(".amount-memory0").val() != $( this ).find(".amount-memory1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-hardDriveCapacity0").length>0)
                	$( this ).find(".amount-hardDriveCapacity0").val() != $( this ).find(".amount-hardDriveCapacity1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-theNumberOfInstalledPostScriptFonts0").length>0)
                	$( this ).find(".amount-theNumberOfInstalledPostScriptFonts0").val() != $( this ).find(".amount-theNumberOfInstalledPostScriptFonts1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-theNumberOfInstalledPCLFonts0").length>0)
                	$( this ).find(".amount-theNumberOfInstalledPCLFonts0").val() != $( this ).find(".amount-theNumberOfInstalledPCLFonts1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                       
                if($( this ).has(".amount-displaySize0").length>0)
                	$( this ).find(".amount-displaySize0").val() != $( this ).find(".amount-displaySize1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');

                if($( this ).has(".amount-weight0").length>0)
                	$( this ).find(".amount-weight0").val() != $( this ).find(".amount-weight1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-width0").length>0)
                	$( this ).find(".amount-width0").val() != $( this ).find(".amount-width1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-depth0").length>0)		
                    $( this ).find(".amount-depth0").val() != $( this ).find(".amount-depth1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                            
               if($( this ).has(".amount-heigth0").length>0)
               		$( this ).find(".amount-heigth0").val() != $( this ).find(".amount-heigth1").val() ?
               			$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    
               			if($( this ).has(".amount-averagePowerConsumption0").length>0)
                       		$( this ).find(".amount-averagePowerConsumption0").val() != $( this ).find(".amount-averagePowerConsumption1").val() ?
                       			$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                        	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
             });
        	
        });		
		
/*---- диапазон для цены ----*/          
            $(function() {
            $( ".slider-range-prise" ).slider({
              range: true,
              min: 0,
              max: 50000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-prise0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-prise1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-prise0" ).val(ui.values[ 0 ]);
                $( ".amount-prise1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-prise0" ).val( $( ".slider-range-prise" ).slider("values", 0 ));             
            $( ".amount-prise1" ).val( $( ".slider-range-prise" ).slider("values", 1 ));
                
            $( ".amount-prise0" ).change(function() {
            $(".slider-range-prise").slider('values',0,this.value);
                });
                
            $( ".amount-prise1" ).change(function() {
            $(".slider-range-prise").slider('values',1,this.value);
                });
          });
  
/*---- Средняя потребляемая мощность ----*/          
            $(function() {
            $( ".slider-range-averagePowerConsumption" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-averagePowerConsumption0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-averagePowerConsumption1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-averagePowerConsumption0" ).val(ui.values[ 0 ]);
                $( ".amount-averagePowerConsumption1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-averagePowerConsumption0" ).val( $( ".slider-range-averagePowerConsumption" ).slider("values", 0 ));             
            $( ".amount-averagePowerConsumption1" ).val( $( ".slider-range-averagePowerConsumption" ).slider("values", 1 ));
                
            $( ".amount-averagePowerConsumption0" ).change(function() {
            $(".slider-range-averagePowerConsumption").slider('values',0,this.value);
                });
                
            $( ".amount-averagePowerConsumption1" ).change(function() {
            $(".slider-range-averagePowerConsumption").slider('values',1,this.value);
                });
           
          });            
            
            /*---- Количество страниц в месяц ----*/          
            $(function() {
            $( ".slider-range-numberOfPagesPerMonth" ).slider({
              range: true,
              min: 1,
              max: 1000000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-numberOfPagesPerMonth0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-numberOfPagesPerMonth1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-numberOfPagesPerMonth0" ).val(ui.values[ 0 ]);
                $( ".amount-numberOfPagesPerMonth1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-numberOfPagesPerMonth0" ).val( $( ".slider-range-numberOfPagesPerMonth" ).slider("values", 0 ));             
            $( ".amount-numberOfPagesPerMonth1" ).val( $( ".slider-range-numberOfPagesPerMonth" ).slider("values", 1 ));
                
            $( ".amount-numberOfPagesPerMonth0" ).change(function() {
            $(".slider-range-numberOfPagesPerMonth").slider('values',0,this.value);
                });
                
            $( ".amount-numberOfPagesPerMonth1" ).change(function() {
            $(".slider-range-numberOfPagesPerMonth").slider('values',1,this.value);
                });
          });           
            
            /*---- Время разогрева ----*/          
            $(function() {
            $( ".slider-range-warmUpTime" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-warmUpTime0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-warmUpTime1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-warmUpTime0" ).val(ui.values[ 0 ]);
                $( ".amount-warmUpTime1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-warmUpTime0" ).val( $( ".slider-range-warmUpTime" ).slider("values", 0 ));             
            $( ".amount-warmUpTime1" ).val( $( ".slider-range-warmUpTime" ).slider("values", 1 ));
                
            $( ".amount-warmUpTime0" ).change(function() {
            $(".slider-range-warmUpTime").slider('values',0,this.value);
                });
                
            $( ".amount-warmUpTime1" ).change(function() {
            $(".slider-range-warmUpTime").slider('values',1,this.value);
                });
          });          
            
            /*---- Скорость печати для ч/б печати ----*/          
            $(function() {
            $( ".slider-range-speedPrintBW" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrintBW0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrintBW1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-speedPrintBW0" ).val(ui.values[ 0 ]);
                $( ".amount-speedPrintBW1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-speedPrintBW0" ).val( $( ".slider-range-speedPrintBW" ).slider("values", 0 ));             
            $( ".amount-speedPrintBW1" ).val( $( ".slider-range-speedPrintBW" ).slider("values", 1 ));
                
            $( ".amount-speedPrintBW0" ).change(function() {
            $(".slider-range-speedPrintBW").slider('values',0,this.value);
                });
                
            $( ".amount-speedPrintBW1" ).change(function() {
            $(".slider-range-speedPrintBW").slider('values',1,this.value);
                });
          });      
            
            /*---- Скорость печати для цветной печати ----*/          
            $(function() {
            $( ".slider-range-speedPrintColor" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrintColor0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrintColor1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-speedPrintColor0" ).val(ui.values[ 0 ]);
                $( ".amount-speedPrintColor1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-speedPrintColor0" ).val( $( ".slider-range-speedPrintColor" ).slider("values", 0 ));             
            $( ".amount-speedPrintColor1" ).val( $( ".slider-range-speedPrintColor" ).slider("values", 1 ));
                
            $( ".amount-speedPrintColor0" ).change(function() {
            $(".slider-range-speedPrintColor").slider('values',0,this.value);
                });
                
            $( ".amount-speedPrintColor1" ).change(function() {
            $(".slider-range-speedPrintColor").slider('values',1,this.value);
                });
          });      
            
            /*---- Скорость копирования для ч/б печати ----*/          
            $(function() {
            $( ".slider-range-speedCopyBW" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedCopyBW0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedCopyBW1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-speedCopyBW0" ).val(ui.values[ 0 ]);
                $( ".amount-speedCopyBW1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-speedCopyBW0" ).val( $( ".slider-range-speedCopyBW" ).slider("values", 0 ));             
            $( ".amount-speedCopyBW1" ).val( $( ".slider-range-speedCopyBW" ).slider("values", 1 ));
                
            $( ".amount-speedCopyBW0" ).change(function() {
            $(".slider-range-speedCopyBW").slider('values',0,this.value);
                });
                
            $( ".amount-speedCopyBW1" ).change(function() {
            $(".slider-range-speedCopyBW").slider('values',1,this.value);
                });
          });      
            
            /*---- Скорость копирования для цветной печати ----*/          
            $(function() {
            $( ".slider-range-speedCopyColor" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedCopyColor0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedCopyColor1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-speedCopyColor0" ).val(ui.values[ 0 ]);
                $( ".amount-speedCopyColor1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-speedCopyColor0" ).val( $( ".slider-range-speedCopyColor" ).slider("values", 0 ));             
            $( ".amount-speedCopyColor1" ).val( $( ".slider-range-speedCopyColor" ).slider("values", 1 ));
                
            $( ".amount-speedCopyColor0" ).change(function() {
            $(".slider-range-speedCopyColor").slider('values',0,this.value);
                });
                
            $( ".amount-speedCopyColor1" ).change(function() {
            $(".slider-range-speedCopyColor").slider('values',1,this.value);
                });
          });   
            
            /*---- Время выхода первого отпечатка color ----*/          
            $(function() {
            $( ".slider-range-firstPrintColor" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-firstPrintColor0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-firstPrintColor1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-firstPrintColor0" ).val(ui.values[ 0 ]);
                $( ".amount-firstPrintColor1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-firstPrintColor0" ).val( $( ".slider-range-firstPrintColor" ).slider("values", 0 ));             
            $( ".amount-firstPrintColor1" ).val( $( ".slider-range-firstPrintColor" ).slider("values", 1 ));
                
            $( ".amount-firstPrintColor0" ).change(function() {
            $(".slider-range-firstPrintColor").slider('values',0,this.value);
                });
                
            $( ".amount-firstPrintColor1" ).change(function() {
            $(".slider-range-firstPrintColor").slider('values',1,this.value);
                });
          });         
            
            /*---- Время выхода первого отпечатка BW ----*/          
            $(function() {
            $( ".slider-range-firstPrintBW" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-firstPrintBW0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-firstPrintBW1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-firstPrintBW0" ).val(ui.values[ 0 ]);
                $( ".amount-firstPrintBW1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-firstPrintBW0" ).val( $( ".slider-range-firstPrintBW" ).slider("values", 0 ));             
            $( ".amount-firstPrintBW1" ).val( $( ".slider-range-firstPrintBW" ).slider("values", 1 ));
                
            $( ".amount-firstPrintBW0" ).change(function() {
            $(".slider-range-firstPrintBW").slider('values',0,this.value);
                });
                
            $( ".amount-firstPrintBW1" ).change(function() {
            $(".slider-range-firstPrintBW").slider('values',1,this.value);
                });
          });  
            
            /*---- Скорость сканирования (цветн.) ----*/          
            $(function() {
            $( ".slider-range-scanSpeedColor" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-scanSpeedColor0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-scanSpeedColor1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-scanSpeedColor0" ).val(ui.values[ 0 ]);
                $( ".amount-scanSpeedColor1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-scanSpeedColor0" ).val( $( ".slider-range-scanSpeedColor" ).slider("values", 0 ));             
            $( ".amount-scanSpeedColor1" ).val( $( ".slider-range-scanSpeedColor" ).slider("values", 1 ));
                
            $( ".amount-scanSpeedColor0" ).change(function() {
            $(".slider-range-scanSpeedColor").slider('values',0,this.value);
                });
                
            $( ".amount-scanSpeedColor1" ).change(function() {
            $(".slider-range-scanSpeedColor").slider('values',1,this.value);
                });
          });   
            
            /*---- Скорость сканирования (ч/б) ----*/          
            $(function() {
            $( ".slider-range-scanSpeedBW" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-scanSpeedBW0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-scanSpeedBW1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-scanSpeedBW0" ).val(ui.values[ 0 ]);
                $( ".amount-scanSpeedBW1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-scanSpeedBW0" ).val( $( ".slider-range-scanSpeedBW" ).slider("values", 0 ));             
            $( ".amount-scanSpeedBW1" ).val( $( ".slider-range-scanSpeedBW" ).slider("values", 1 ));
                
            $( ".amount-scanSpeedBW0" ).change(function() {
            $(".slider-range-scanSpeedBW").slider('values',0,this.value);
                });
                
            $( ".amount-scanSpeedBW1" ).change(function() {
            $(".slider-range-scanSpeedBW").slider('values',1,this.value);
                });
          }); 
            
            /*---- Время выхода первой копии ----*/          
            $(function() {
            $( ".slider-range-firstCopyOutTime" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-firstCopyOutTime0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-firstCopyOutTime1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-firstCopyOutTime0" ).val(ui.values[ 0 ]);
                $( ".amount-firstCopyOutTime1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-firstCopyOutTime0" ).val( $( ".slider-range-firstCopyOutTime" ).slider("values", 0 ));             
            $( ".amount-firstCopyOutTime1" ).val( $( ".slider-range-firstCopyOutTime" ).slider("values", 1 ));
                
            $( ".amount-firstCopyOutTime0" ).change(function() {
            $(".slider-range-firstCopyOutTime").slider('values',0,this.value);
                });
                
            $( ".amount-firstCopyOutTime1" ).change(function() {
            $(".slider-range-firstCopyOutTime").slider('values',1,this.value);
                });
          });    
            
            /*---- Изменение масштаба ----*/          
            $(function() {
            $( ".slider-range-zooming" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-zooming0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-zooming1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-zooming0" ).val(ui.values[ 0 ]);
                $( ".amount-zooming1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-zooming0" ).val( $( ".slider-range-zooming" ).slider("values", 0 ));             
            $( ".amount-zooming1" ).val( $( ".slider-range-zooming" ).slider("values", 1 ));
                
            $( ".amount-zooming0" ).change(function() {
            $(".slider-range-zooming").slider('values',0,this.value);
                });
                
            $( ".amount-zooming1" ).change(function() {
            $(".slider-range-zooming").slider('values',1,this.value);
                });
          });    
            
            /*---- Шаг масштабирования ----*/          
            $(function() {
            $( ".slider-range-stepZoom" ).slider({
              range: true,
              min: 1,
              max: 10,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-stepZoom0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-stepZoom1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-stepZoom0" ).val(ui.values[ 0 ]);
                $( ".amount-stepZoom1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-stepZoom0" ).val( $( ".slider-range-stepZoom" ).slider("values", 0 ));             
            $( ".amount-stepZoom1" ).val( $( ".slider-range-stepZoom" ).slider("values", 1 ));
                
            $( ".amount-stepZoom0" ).change(function() {
            $(".slider-range-stepZoom").slider('values',0,this.value);
                });
                
            $( ".amount-stepZoom1" ).change(function() {
            $(".slider-range-stepZoom").slider('values',1,this.value);
                });
          });      
            
            /*---- Максимальное количество копий за цикл ----*/          
            $(function() {
            $( ".slider-range-theMaximumNumberOfCopiesPerCycle" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-theMaximumNumberOfCopiesPerCycle0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-theMaximumNumberOfCopiesPerCycle1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-theMaximumNumberOfCopiesPerCycle0" ).val(ui.values[ 0 ]);
                $( ".amount-theMaximumNumberOfCopiesPerCycle1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-theMaximumNumberOfCopiesPerCycle0" ).val( $( ".slider-range-theMaximumNumberOfCopiesPerCycle" ).slider("values", 0 ));             
            $( ".amount-theMaximumNumberOfCopiesPerCycle1" ).val( $( ".slider-range-theMaximumNumberOfCopiesPerCycle" ).slider("values", 1 ));
                
            $( ".amount-theMaximumNumberOfCopiesPerCycle0" ).change(function() {
            $(".slider-range-theMaximumNumberOfCopiesPerCycle").slider('values',0,this.value);
                });
                
            $( ".amount-theMaximumNumberOfCopiesPerCycle1" ).change(function() {
            $(".slider-range-theMaximumNumberOfCopiesPerCycle").slider('values',1,this.value);
                });
          });      
            
            /*---- Подача бумаги (стандартная) ----*/          
            $(function() {
            $( ".slider-range-paperFeedStandart" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperFeedStandart0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperFeedStandart1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-paperFeedStandart0" ).val(ui.values[ 0 ]);
                $( ".amount-paperFeedStandart1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-paperFeedStandart0" ).val( $( ".slider-range-paperFeedStandart" ).slider("values", 0 ));             
            $( ".amount-paperFeedStandart1" ).val( $( ".slider-range-paperFeedStandart" ).slider("values", 1 ));
                
            $( ".amount-paperFeedStandart0" ).change(function() {
            $(".slider-range-paperFeedStandart").slider('values',0,this.value);
                });
                
            $( ".amount-paperFeedStandart1" ).change(function() {
            $(".slider-range-paperFeedStandart").slider('values',1,this.value);
                });
          });      
            
            /*---- Подача бумаги (максимальная) ----*/          
            $(function() {
            $( ".slider-range-paperFeedMax" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperFeedMax0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperFeedMax1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-paperFeedMax0" ).val(ui.values[ 0 ]);
                $( ".amount-paperFeedMax1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-paperFeedMax0" ).val( $( ".slider-range-paperFeedMax" ).slider("values", 0 ));             
            $( ".amount-paperFeedMax1" ).val( $( ".slider-range-paperFeedMax" ).slider("values", 1 ));
                
            $( ".amount-paperFeedMax0" ).change(function() {
            $(".slider-range-paperFeedMax").slider('values',0,this.value);
                });
                
            $( ".amount-paperFeedMax1" ).change(function() {
            $(".slider-range-paperFeedMax").slider('values',1,this.value);
                });
          });        
            
            /*---- Вывод бумаги (стандартная) ----*/          
            $(function() {
            $( ".slider-range-paperOutputStandart" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperOutputStandart0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperOutputStandart1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-paperOutputStandart0" ).val(ui.values[ 0 ]);
                $( ".amount-paperOutputStandart1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-paperOutputStandart0" ).val( $( ".slider-range-paperOutputStandart" ).slider("values", 0 ));             
            $( ".amount-paperOutputStandart1" ).val( $( ".slider-range-paperOutputStandart" ).slider("values", 1 ));
                
            $( ".amount-paperOutputStandart0" ).change(function() {
            $(".slider-range-paperOutputStandart").slider('values',0,this.value);
                });
                
            $( ".amount-paperOutputStandart1" ).change(function() {
            $(".slider-range-paperOutputStandart").slider('values',1,this.value);
                });
          });      
            
            /*---- Вывод бумаги (максимальная) ----*/          
            $(function() {
            $( ".slider-range-paperOutputMax" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperOutputMax0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperOutputMax1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-paperOutputMax0" ).val(ui.values[ 0 ]);
                $( ".amount-paperOutputMax1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-paperOutputMax0" ).val( $( ".slider-range-paperOutputMax" ).slider("values", 0 ));             
            $( ".amount-paperOutputMax1" ).val( $( ".slider-range-paperOutputMax" ).slider("values", 1 ));
                
            $( ".amount-paperOutputMax0" ).change(function() {
            $(".slider-range-paperOutputMax").slider('values',0,this.value);
                });
                
            $( ".amount-paperOutputMax1" ).change(function() {
            $(".slider-range-paperOutputMax").slider('values',1,this.value);
                });
          });   
            
            /*---- Емкость лотка ручной подачи ----*/          
            $(function() {
            $( ".slider-range-theCapacityOfTheBypassTray" ).slider({
              range: true,
              min: 1,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-theCapacityOfTheBypassTray0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-theCapacityOfTheBypassTray1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-theCapacityOfTheBypassTray0" ).val(ui.values[ 0 ]);
                $( ".amount-theCapacityOfTheBypassTray1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-theCapacityOfTheBypassTray0" ).val( $( ".slider-range-theCapacityOfTheBypassTray" ).slider("values", 0 ));             
            $( ".amount-theCapacityOfTheBypassTray1" ).val( $( ".slider-range-theCapacityOfTheBypassTray" ).slider("values", 1 ));
                
            $( ".amount-theCapacityOfTheBypassTray0" ).change(function() {
            $(".slider-range-theCapacityOfTheBypassTray").slider('values',0,this.value);
                });
                
            $( ".amount-theCapacityOfTheBypassTray1" ).change(function() {
            $(".slider-range-theCapacityOfTheBypassTray").slider('values',1,this.value);
                });
          });    
            
            /*---- Плотность бумаги ----*/          
            $(function() {
            $( ".slider-range-paperDensity" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperDensity0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-paperDensity1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-paperDensity0" ).val(ui.values[ 0 ]);
                $( ".amount-paperDensity1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-paperDensity0" ).val( $( ".slider-range-paperDensity" ).slider("values", 0 ));             
            $( ".amount-paperDensity1" ).val( $( ".slider-range-paperDensity" ).slider("values", 1 ));
                
            $( ".amount-paperDensity0" ).change(function() {
            $(".slider-range-paperDensity").slider('values',0,this.value);
                });
                
            $( ".amount-paperDensity1" ).change(function() {
            $(".slider-range-paperDensity").slider('values',1,this.value);
                });
          }); 
            
            /*---- Ресурс девелопера ----*/          
            $(function() {
            $( ".slider-range-resourceDeveloper" ).slider({
              range: true,
              min: 1,
              max: 10000000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-resourceDeveloper0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-resourceDeveloper1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-resourceDeveloper0" ).val(ui.values[ 0 ]);
                $( ".amount-resourceDeveloper1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-resourceDeveloper0" ).val( $( ".slider-range-resourceDeveloper" ).slider("values", 0 ));             
            $( ".amount-resourceDeveloper1" ).val( $( ".slider-range-resourceDeveloper" ).slider("values", 1 ));
                
            $( ".amount-resourceDeveloper0" ).change(function() {
            $(".slider-range-resourceDeveloper").slider('values',0,this.value);
                });
                
            $( ".amount-resourceDeveloper1" ).change(function() {
            $(".slider-range-resourceDeveloper").slider('values',1,this.value);
                });
          });     
            
            /*---- Ресурс фотобарабана ----*/          
            $(function() {
            $( ".slider-range-resourceDrum" ).slider({
              range: true,
              min: 1,
              max: 10000000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-resourceDrum0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-resourceDrum1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-resourceDrum0" ).val(ui.values[ 0 ]);
                $( ".amount-resourceDrum1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-resourceDrum0" ).val( $( ".slider-range-resourceDrum" ).slider("values", 0 ));             
            $( ".amount-resourceDrum1" ).val( $( ".slider-range-resourceDrum" ).slider("values", 1 ));
                
            $( ".amount-resourceDrum0" ).change(function() {
            $(".slider-range-resourceDrum").slider('values',0,this.value);
                });
                
            $( ".amount-resourceDrum1" ).change(function() {
            $(".slider-range-resourceDrum").slider('values',1,this.value);
                });
          });         
            
            /*---- Ресурс ч/б картриджа/тонера ----*/          
            $(function() {
            $( ".slider-range-resourceBWCartridgeToner" ).slider({
              range: true,
              min: 1,
              max: 10000000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-resourceBWCartridgeToner0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-resourceBWCartridgeToner1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-resourceBWCartridgeToner0" ).val(ui.values[ 0 ]);
                $( ".amount-resourceBWCartridgeToner1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-resourceBWCartridgeToner0" ).val( $( ".slider-range-resourceBWCartridgeToner" ).slider("values", 0 ));             
            $( ".amount-resourceBWCartridgeToner1" ).val( $( ".slider-range-resourceBWCartridgeToner" ).slider("values", 1 ));
                
            $( ".amount-resourceBWCartridgeToner0" ).change(function() {
            $(".slider-range-resourceBWCartridgeToner").slider('values',0,this.value);
                });
                
            $( ".amount-resourceBWCartridgeToner1" ).change(function() {
            $(".slider-range-resourceBWCartridgeToner").slider('values',1,this.value);
                });
          });   
            
            /*---- Количество картриджей ----*/          
            $(function() {
            $( ".slider-range-numberOfCartridges" ).slider({
              range: true,
              min: 1,
              max: 10,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-numberOfCartridges0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-numberOfCartridges1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-numberOfCartridges0" ).val(ui.values[ 0 ]);
                $( ".amount-numberOfCartridges1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-numberOfCartridges0" ).val( $( ".slider-range-numberOfCartridges" ).slider("values", 0 ));             
            $( ".amount-numberOfCartridges1" ).val( $( ".slider-range-numberOfCartridges" ).slider("values", 1 ));
                
            $( ".amount-numberOfCartridges0" ).change(function() {
            $(".slider-range-numberOfCartridges").slider('values',0,this.value);
                });
                
            $( ".amount-numberOfCartridges1" ).change(function() {
            $(".slider-range-numberOfCartridges").slider('values',1,this.value);
                });
          });      
            
            /*---- Объем памяти ----*/          
            $(function() {
            $( ".slider-range-memory" ).slider({
              range: true,
              min: 1,
              max: 100000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-memory0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-memory1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-memory0" ).val(ui.values[ 0 ]);
                $( ".amount-memory1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-memory0" ).val( $( ".slider-range-memory" ).slider("values", 0 ));             
            $( ".amount-memory1" ).val( $( ".slider-range-memory" ).slider("values", 1 ));
                
            $( ".amount-memory0" ).change(function() {
            $(".slider-range-memory").slider('values',0,this.value);
                });
                
            $( ".amount-memory1" ).change(function() {
            $(".slider-range-memory").slider('values',1,this.value);
                });
          });        
            
            /*---- Емкость жесткого диска ----*/          
            $(function() {
            $( ".slider-range-hardDriveCapacity" ).slider({
              range: true,
              min: 1,
              max: 10000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-hardDriveCapacity0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-hardDriveCapacity1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-hardDriveCapacity0" ).val(ui.values[ 0 ]);
                $( ".amount-hardDriveCapacity1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-hardDriveCapacity0" ).val( $( ".slider-range-hardDriveCapacity" ).slider("values", 0 ));             
            $( ".amount-hardDriveCapacity1" ).val( $( ".slider-range-hardDriveCapacity" ).slider("values", 1 ));
                
            $( ".amount-hardDriveCapacity0" ).change(function() {
            $(".slider-range-hardDriveCapacity").slider('values',0,this.value);
                });
                
            $( ".amount-hardDriveCapacity1" ).change(function() {
            $(".slider-range-hardDriveCapacity").slider('values',1,this.value);
                });
          });       
            
            /*---- Количество установленных шрифтов PostScript ----*/          
            $(function() {
            $( ".slider-range-theNumberOfInstalledPostScriptFonts" ).slider({
              range: true,
              min: 1,
              max: 10000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-theNumberOfInstalledPostScriptFonts0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-theNumberOfInstalledPostScriptFonts1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-theNumberOfInstalledPostScriptFonts0" ).val(ui.values[ 0 ]);
                $( ".amount-theNumberOfInstalledPostScriptFonts1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-theNumberOfInstalledPostScriptFonts0" ).val( $( ".slider-range-theNumberOfInstalledPostScriptFonts" ).slider("values", 0 ));             
            $( ".amount-theNumberOfInstalledPostScriptFonts1" ).val( $( ".slider-range-theNumberOfInstalledPostScriptFonts" ).slider("values", 1 ));
                
            $( ".amount-theNumberOfInstalledPostScriptFonts0" ).change(function() {
            $(".slider-range-theNumberOfInstalledPostScriptFonts").slider('values',0,this.value);
                });
                
            $( ".amount-theNumberOfInstalledPostScriptFonts1" ).change(function() {
            $(".slider-range-theNumberOfInstalledPostScriptFonts").slider('values',1,this.value);
                });
          });     
            
            /*---- Количество установленных шрифтов PCL ----*/          
            $(function() {
            $( ".slider-range-theNumberOfInstalledPCLFonts" ).slider({
              range: true,
              min: 1,
              max: 10000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-theNumberOfInstalledPCLFonts0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-theNumberOfInstalledPCLFonts1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-theNumberOfInstalledPCLFonts0" ).val(ui.values[ 0 ]);
                $( ".amount-theNumberOfInstalledPCLFonts1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-theNumberOfInstalledPCLFonts0" ).val( $( ".slider-range-theNumberOfInstalledPCLFonts" ).slider("values", 0 ));             
            $( ".amount-theNumberOfInstalledPCLFonts1" ).val( $( ".slider-range-theNumberOfInstalledPCLFonts" ).slider("values", 1 ));
                
            $( ".amount-theNumberOfInstalledPCLFonts0" ).change(function() {
            $(".slider-range-theNumberOfInstalledPCLFonts").slider('values',0,this.value);
                });
                
            $( ".amount-theNumberOfInstalledPCLFonts1" ).change(function() {
            $(".slider-range-theNumberOfInstalledPCLFonts").slider('values',1,this.value);
                });
          });     
            
            /*---- Диагональ дисплея ----*/          
            $(function() {
            $( ".slider-range-displaySize" ).slider({
              range: true,
              min: 1,
              max: 30,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-displaySize0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-displaySize1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-displaySize0" ).val(ui.values[ 0 ]);
                $( ".amount-displaySize1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-displaySize0" ).val( $( ".slider-range-displaySize" ).slider("values", 0 ));             
            $( ".amount-displaySize1" ).val( $( ".slider-range-displaySize" ).slider("values", 1 ));
                
            $( ".amount-displaySize0" ).change(function() {
            $(".slider-range-displaySize").slider('values',0,this.value);
                });
                
            $( ".amount-displaySize1" ).change(function() {
            $(".slider-range-displaySize").slider('values',1,this.value);
                });
          });     
            
/*--- для максимальной потребляемой мощности ----*/
          $(function() {
            $( ".slider-range-maxPowerConsumption" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-maxPowerConsumption0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-maxPowerConsumption1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-maxPowerConsumption0" ).val( ui.values[ 0 ] );
                $( ".amount-maxPowerConsumption1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-maxPowerConsumption0" ).val($( ".slider-range-maxPowerConsumption" ).slider( "values", 0 ));
            $( ".amount-maxPowerConsumption1" ).val($( ".slider-range-maxPowerConsumption" ).slider( "values", 1 ));
              
            $( ".amount-maxPowerConsumption0" ).change(function() {
            $(".slider-range-maxPowerConsumption").slider('values',0,this.value);
                });
                
            $( ".amount-maxPowerConsumption1" ).change(function() {
            $(".slider-range-maxPowerConsumption").slider('values',1,this.value);
                });   
            
          });
          
/*--- для веса ----*/
          $(function() {
            $( ".slider-range-weight" ).slider({
              range: true,
              min: 0,
              max: 5000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-weight0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-weight1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-weight0" ).val( ui.values[ 0 ] );
                $( ".amount-weight1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-weight0" ).val($( ".slider-range-weight" ).slider( "values", 0 ));
            $( ".amount-weight1" ).val($( ".slider-range-weight" ).slider( "values", 1 ));
              
            $( ".amount-weight0" ).change(function() {
            $(".slider-range-weight").slider('values',0,this.value);
                });
                
            $( ".amount-weight1" ).change(function() {
            $(".slider-range-weight").slider('values',1,this.value);
                });  
              
          });
          
/*--- для ширины ---*/
          $(function() {
            $( ".slider-range-width" ).slider({
              range: true,
              min: 0,
              max: 10000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-width0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-width1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-width0" ).val( ui.values[ 0 ] );
                $( ".amount-width1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-width0" ).val($( ".slider-range-width" ).slider( "values", 0 ));
            $( ".amount-width1" ).val($( ".slider-range-width" ).slider( "values", 1 ));
              
            $( ".amount-width0" ).change(function() {
            $(".slider-range-width").slider('values',0,this.value);
                });
                
            $( ".amount-width1" ).change(function() {
            $(".slider-range-width").slider('values',1,this.value);
                }); 
              
          });
          
/*--- для высоты ---*/
          $(function() {
            $( ".slider-range-heigth" ).slider({
              range: true,
              min: 0,
              max: 10000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-heigth0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-heigth1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-heigth0" ).val( ui.values[ 0 ] );
                $( ".amount-heigth1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-heigth0" ).val($( ".slider-range-heigth" ).slider( "values", 0 ));
            $( ".amount-heigth1" ).val($( ".slider-range-heigth" ).slider( "values", 1 ));
              
            $( ".amount-heigth0" ).change(function() {
            $(".slider-range-heigth").slider('values',0,this.value);
                });
                
            $( ".amount-heigth1" ).change(function() {
            $(".slider-range-heigth").slider('values',1,this.value);
                }); 
              
          });
          
/*--- для глубины ---*/
          $(function() {
            $( ".slider-range-depth" ).slider({
              range: true,
              min: 0,
              max: 10000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-depth0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-depth1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-depth0" ).val( ui.values[ 0 ] );
                $( ".amount-depth1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-depth0" ).val($( ".slider-range-depth" ).slider( "values", 0 ));
            $( ".amount-depth1" ).val($( ".slider-range-depth" ).slider( "values", 1 ));
              
            $( ".amount-depth0" ).change(function() {
            $(".slider-range-depth").slider('values',0,this.value);
                });
                
            $( ".amount-depth1" ).change(function() {
            $(".slider-range-depth").slider('values',1,this.value);
                }); 
              
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