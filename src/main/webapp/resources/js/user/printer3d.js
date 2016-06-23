/*----  Для вывода новых принтеров при поиске  -----*/        
		$(document).ready(function() {
			
			$('#search').ajaxForm( {
				type: 'post',
				success: function(products) { 
					$("#out_result_of_search").html('');
					
	                $(products).each(function(i, product) {
	                	var outerDiv = $('<div/>');

	                	outerDiv.addClass("products")
	                				.append($('<a/>').attr("id", "/images/3d_printers/" + product.id + "/" + checkPicture(product.pathPictures))
           								 			 .addClass("link")
           								 			 .attr("href", "/3d_printer/" + product.id)
	                	.append($('<div/>').addClass("outer_a_img").append($('<img/>')
	    	                								.attr("src", "/images/3d_printers/" + product.id + "/" + product.pathPictures[0]))))
	    	                		.append($('<a/>').attr("href", "/3d_printer/" + product.id).addClass("products_title").text(product.name))
	    	                		.append($('<p/>').addClass("products_price").text("Цена: " + checkPrise(product.prise)))
	    	                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
        			                			addToCart('3d_printer', product.id, product.name, product.prise+'', product.pathPictures[0]);
        			                		}))
	    	          
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

             	if($( this ).has(".amount-sizePrintableAreaX0").length>0)
                	($( this ).find(".amount-sizePrintableAreaX0").val() != $( this ).find(".amount-sizePrintableAreaX1").val())
                	|| ($( this ).find(".amount-sizePrintableAreaY0").val() != $( this ).find(".amount-sizePrintableAreaY1").val())
                	|| ($( this ).find(".amount-sizePrintableAreaZ0").val() != $( this ).find(".amount-sizePrintableAreaZ1").val()) ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-meltingPointOfThePrintingMaterial0").length>0)
                	$( this ).find(".amount-meltingPointOfThePrintingMaterial0").val() != $( this ).find(".amount-meltingPointOfThePrintingMaterial1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');

                if($( this ).has(".amount-sizeExtruder0").length>0)
               		$( this ).find(".amount-sizeExtruder0").val() != $( this ).find(".amount-sizeExtruder1").val() ?
               	    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-speedPrint0").length>0)
                	$( this ).find(".amount-speedPrint0").val() != $( this ).find(".amount-speedPrint1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-maxPowerConsumption0").length>0)
                	$( this ).find(".amount-maxPowerConsumption0").val() != $( this ).find(".amount-maxPowerConsumption1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-thicknessOfThePrintingLayer0").length>0)
                	$( this ).find(".amount-thicknessOfThePrintingLayer0").val() != $( this ).find(".amount-thicknessOfThePrintingLayer1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                        
                if($( this ).has(".amount-maximumWeightOfThePrintedModel0").length>0)
                	$( this ).find(".amount-maximumWeightOfThePrintedModel0").val() != $( this ).find(".amount-maximumWeightOfThePrintedModel1").val() ?
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
                       
               if($( this ).has(".amount-speedOfMovingThePrintHead0").length>0)
               		$( this ).find(".amount-speedOfMovingThePrintHead0").val() != $( this ).find(".amount-speedOfMovingThePrintHead1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
            
               if($( this ).has(".amount-positioningAccuracyOfThePrintHead0").length>0)
               		$( this ).find(".amount-positioningAccuracyOfThePrintHead0").val() != $( this ).find(".amount-positioningAccuracyOfThePrintHead1").val() ?
               			$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
               		$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
        	
               if($( this ).has(".amount-numberOfFansForBlowingModels0").length>0)
               		$( this ).find(".amount-numberOfFansForBlowingModels0").val() != $( this ).find(".amount-numberOfFansForBlowingModels1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                    $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');

        	});
        	
        });		
		
/*--- пошли слайдеры ---*/
        $(function() {
            $( ".slider-range-speedOfMovingThePrintHead" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedOfMovingThePrintHead0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedOfMovingThePrintHead1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-speedOfMovingThePrintHead0" ).val(ui.values[ 0 ]);
                $( ".amount-speedOfMovingThePrintHead1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-speedOfMovingThePrintHead0" ).val( $( ".slider-range-speedOfMovingThePrintHead" ).slider("values", 0 ));             
            $( ".amount-speedOfMovingThePrintHead1" ).val( $( ".slider-range-speedOfMovingThePrintHead" ).slider("values", 1 ));
                
            $( ".amount-speedOfMovingThePrintHead0" ).change(function() {
            $(".slider-range-speedOfMovingThePrintHead").slider('values',0,this.value);
                });
                
            $( ".amount-speedOfMovingThePrintHead1" ).change(function() {
            $(".slider-range-speedOfMovingThePrintHead").slider('values',1,this.value);
                });
          });
        
        $(function() {
            $( ".slider-range-positioningAccuracyOfThePrintHead" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-positioningAccuracyOfThePrintHead0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-positioningAccuracyOfThePrintHead1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-positioningAccuracyOfThePrintHead0" ).val(ui.values[ 0 ]);
                $( ".amount-positioningAccuracyOfThePrintHead1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-positioningAccuracyOfThePrintHead0" ).val( $( ".slider-range-positioningAccuracyOfThePrintHead" ).slider("values", 0 ));             
            $( ".amount-positioningAccuracyOfThePrintHead1" ).val( $( ".slider-range-positioningAccuracyOfThePrintHead" ).slider("values", 1 ));
                
            $( ".amount-positioningAccuracyOfThePrintHead0" ).change(function() {
            $(".slider-range-positioningAccuracyOfThePrintHead").slider('values',0,this.value);
                });
                
            $( ".amount-positioningAccuracyOfThePrintHead1" ).change(function() {
            $(".slider-range-positioningAccuracyOfThePrintHead").slider('values',1,this.value);
                });
          });
        
        $(function() {
            $( ".slider-range-numberOfFansForBlowingModels" ).slider({
              range: true,
              min: 0,
              max: 100,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-numberOfFansForBlowingModels0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-numberOfFansForBlowingModels1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-numberOfFansForBlowingModels0" ).val(ui.values[ 0 ]);
                $( ".amount-numberOfFansForBlowingModels1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-numberOfFansForBlowingModels0" ).val( $( ".slider-range-numberOfFansForBlowingModels" ).slider("values", 0 ));             
            $( ".amount-numberOfFansForBlowingModels1" ).val( $( ".slider-range-numberOfFansForBlowingModels" ).slider("values", 1 ));
                
            $( ".amount-numberOfFansForBlowingModels0" ).change(function() {
            $(".slider-range-numberOfFansForBlowingModels").slider('values',0,this.value);
                });
                
            $( ".amount-numberOfFansForBlowingModels1" ).change(function() {
            $(".slider-range-numberOfFansForBlowingModels").slider('values',1,this.value);
                });
          });
        
        $(function() {
            $( ".slider-range-prise" ).slider({
              range: true,
              min: 0,
              max: 100000,
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
        
		$(function() {
            $( ".slider-range-sizePrintableAreaX" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaX0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaX1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-sizePrintableAreaX0" ).val( ui.values[ 0 ]);
                $( ".amount-sizePrintableAreaX1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-sizePrintableAreaX0" ).val($( ".slider-range-sizePrintableAreaX" ).slider( "values", 0 ));
            $( ".amount-sizePrintableAreaX1" ).val($( ".slider-range-sizePrintableAreaX" ).slider( "values", 1 ));
              
              
            $( ".amount-sizePrintableAreaX0" ).change(function() {
            $(".slider-range-sizePrintableAreaX").slider('values',0,this.value);
                });
                
            $( ".amount-sizePrintableAreaX1" ).change(function() {
            $(".slider-range-sizePrintableAreaX").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-sizePrintableAreaY" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaY0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaY1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-sizePrintableAreaY0" ).val( ui.values[ 0 ]);
                $( ".amount-sizePrintableAreaY1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-sizePrintableAreaY0" ).val($( ".slider-range-sizePrintableAreaY" ).slider( "values", 0 ));
            $( ".amount-sizePrintableAreaY1" ).val($( ".slider-range-sizePrintableAreaY" ).slider( "values", 1 ));
              
              
            $( ".amount-sizePrintableAreaY0" ).change(function() {
            $(".slider-range-sizePrintableAreaY").slider('values',0,this.value);
                });
                
            $( ".amount-sizePrintableAreaY1" ).change(function() {
            $(".slider-range-sizePrintableAreaY").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-sizePrintableAreaZ" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaZ0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaZ1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-sizePrintableAreaZ0" ).val( ui.values[ 0 ]);
                $( ".amount-sizePrintableAreaZ1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-sizePrintableAreaZ0" ).val($( ".slider-range-sizePrintableAreaZ" ).slider( "values", 0 ));
            $( ".amount-sizePrintableAreaZ1" ).val($( ".slider-range-sizePrintableAreaZ" ).slider( "values", 1 ));
              
              
            $( ".amount-sizePrintableAreaZ0" ).change(function() {
            $(".slider-range-sizePrintableAreaZ").slider('values',0,this.value);
                });
                
            $( ".amount-sizePrintableAreaZ1" ).change(function() {
            $(".slider-range-sizePrintableAreaZ").slider('values',1,this.value);
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
		
		$(function() {
            $( ".slider-range-meltingPointOfThePrintingMaterial" ).slider({
              range: true,
              min: 1,
              max: 500,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-meltingPointOfThePrintingMaterial0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-meltingPointOfThePrintingMaterial1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-meltingPointOfThePrintingMaterial0" ).val( ui.values[ 0 ]);
                $( ".amount-meltingPointOfThePrintingMaterial1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-meltingPointOfThePrintingMaterial0" ).val($( ".slider-range-meltingPointOfThePrintingMaterial" ).slider( "values", 0 ));
            $( ".amount-meltingPointOfThePrintingMaterial1" ).val($( ".slider-range-meltingPointOfThePrintingMaterial" ).slider( "values", 1 ));
              
              
            $( ".amount-meltingPointOfThePrintingMaterial0" ).change(function() {
            $(".slider-range-meltingPointOfThePrintingMaterial").slider('values',0,this.value);
                });
                
            $( ".amount-meltingPointOfThePrintingMaterial1" ).change(function() {
            $(".slider-range-meltingPointOfThePrintingMaterial").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-sizeExtruder" ).slider({
              range: true,
              min: 0,
              max: 2,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeExtruder0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeExtruder1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-sizeExtruder0" ).val( ui.values[ 0 ]);
                $( ".amount-sizeExtruder1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-sizeExtruder0" ).val($( ".slider-range-sizeExtruder" ).slider( "values", 0 ));
            $( ".amount-sizeExtruder1" ).val($( ".slider-range-sizeExtruder" ).slider( "values", 1 ));
              
              
            $( ".amount-sizeExtruder0" ).change(function() {
            $(".slider-range-sizeExtruder").slider('values',0,this.value);
                });
                
            $( ".amount-sizeExtruder1" ).change(function() {
            $(".slider-range-sizeExtruder").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-speedPrint" ).slider({
              range: true,
              min: 1,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrint0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrint1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-speedPrint0" ).val( ui.values[ 0 ]);
                $( ".amount-speedPrint1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-speedPrint0" ).val($( ".slider-range-speedPrint" ).slider( "values", 0 ));
            $( ".amount-speedPrint1" ).val($( ".slider-range-speedPrint" ).slider( "values", 1 ));
              
              
            $( ".amount-speedPrint0" ).change(function() {
            $(".slider-range-speedPrint").slider('values',0,this.value);
                });
                
            $( ".amount-sizeExtruder1" ).change(function() {
            $(".slider-range-speedPrint").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-thicknessOfThePrintingLayer" ).slider({
              range: true,
              min: 1,
              max: 500,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-thicknessOfThePrintingLayer0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-thicknessOfThePrintingLayer1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-thicknessOfThePrintingLayer0" ).val( ui.values[ 0 ]);
                $( ".amount-thicknessOfThePrintingLayer1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-thicknessOfThePrintingLayer0" ).val($( ".slider-range-thicknessOfThePrintingLayer" ).slider( "values", 0 ));
            $( ".amount-thicknessOfThePrintingLayer1" ).val($( ".slider-range-thicknessOfThePrintingLayer" ).slider( "values", 1 ));
              
              
            $( ".amount-thicknessOfThePrintingLayer0" ).change(function() {
            $(".slider-range-thicknessOfThePrintingLayer").slider('values',0,this.value);
                });
                
            $( ".amount-thicknessOfThePrintingLayer1" ).change(function() {
            $(".slider-range-thicknessOfThePrintingLayer").slider('values',1,this.value);
                });  
          });
		
		$(function() {
            $( ".slider-range-maximumWeightOfThePrintedModel" ).slider({
              range: true,
              min: 0,
              max: 100,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximumWeightOfThePrintedModel0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximumWeightOfThePrintedModel1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-maximumWeightOfThePrintedModel0" ).val( ui.values[ 0 ]);
                $( ".amount-maximumWeightOfThePrintedModel1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-maximumWeightOfThePrintedModel0" ).val($( ".slider-range-maximumWeightOfThePrintedModel" ).slider( "values", 0 ));
            $( ".amount-maximumWeightOfThePrintedModel1" ).val($( ".slider-range-maximumWeightOfThePrintedModel" ).slider( "values", 1 ));
              
              
            $( ".amount-maximumWeightOfThePrintedModel0" ).change(function() {
            $(".slider-range-maximumWeightOfThePrintedModel").slider('values',0,this.value);
                });
                
            $( ".amount-maximumWeightOfThePrintedModel1" ).change(function() {
            $(".slider-range-maximumWeightOfThePrintedModel").slider('values',1,this.value);
                });  
          });
		
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
                $( ".amount-maxPowerConsumption0" ).val( ui.values[ 0 ]);
                $( ".amount-maxPowerConsumption1" ).val( ui.values[ 1 ]);
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
