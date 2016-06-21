/*----  Для вывода новых принтеров при поиске  -----*/        
		$(document).ready(function() {
			
			$('#search').ajaxForm( {
				type: 'post',
				success: function(products) { 
					$("#out_result_of_search").html('');
					
	                $(products).each(function(i, product) {
	                	var outerDiv = $('<div/>');

	                	outerDiv.addClass("products")
	                				.append($('<a/>').attr("id", "/images/lasers/" + product.id + "/" + product.pathPictures[1])
           								 			 .addClass("link")
	                								 .attr("href", "/laser/" + product.id)
	                								 .append($('<div/>').addClass("outer_a_img").append($('<img/>').attr("src", "/images/lasers/" + product.id + "/" + product.pathPictures[0]))))
	    	                		.append($('<a/>').attr("href", "/laser/" + product.id).addClass("products_title").text(product.name))
	    	                		.append($('<p/>').addClass("products_price").text("Цена: " + checkPrise(product.prise)))
	    	                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
        			                			addToCart('laser', product.id, product.name, product.prise+'', product.pathPictures[0]);
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
       	        	       	       		
       	        if($( this ).has(".amount-sizeWorkAreaX0").length>0)
       	        	($( this ).find(".amount-sizeWorkAreaX0").val() != $( this ).find(".amount-sizeWorkAreaX1").val())
       	            	|| ($( this ).find(".amount-sizeWorkAreaY0").val() != $( this ).find(".amount-sizeWorkAreaY1").val())
       	            	|| ($( this ).find(".amount-sizeWorkAreaZ0").val() != $( this ).find(".amount-sizeWorkAreaZ1").val()) ?
       	            		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');		
       	        		
       	        if($( this ).has(".amount-powerOfLaser0").length>0)
       	        	$( this ).find(".amount-powerOfLaser0").val() != $( this ).find(".amount-powerOfLaser1").val() ?
       	        		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');		
       	        
       	        if($( this ).has(".amount-mechanicalResolution0").length>0)
       	        	$( this ).find(".amount-mechanicalResolution0").val() != $( this ).find(".amount-mechanicalResolution1").val() ?
       	       	    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
       	        		
       	       	if($( this ).has(".amount-softwareResolution0").length>0)
         	    	$( this ).find(".amount-softwareResolution0").val() != $( this ).find(".amount-softwareResolution1").val() ?
         	       		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');	
         	       		
         	    if($( this ).has(".amount-minimumThicknessOfCut0").length>0)
             		$( this ).find(".amount-minimumThicknessOfCut0").val() != $( this ).find(".amount-minimumThicknessOfCut1").val() ?
             	    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
       	       
             	if($( this ).has(".amount-engravingSpeed0").length>0)
                	$( this ).find(".amount-engravingSpeed0").val() != $( this ).find(".amount-engravingSpeed1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
       	        		
                if($( this ).has(".amount-cuttingSpeed0").length>0)
                	$( this ).find(".amount-cuttingSpeed0").val() != $( this ).find(".amount-cuttingSpeed1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');			
                    	
                if($( this ).has(".amount-max_power_consumption0").length>0)
                	$( this ).find(".amount-max_power_consumption0").val() != $( this ).find(".amount-max_power_consumption1").val() ?
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
               			
               if($( this ).has(".amount-maximumResolution0").length>0)
               		$( this ).find(".amount-maximumResolution0").val() != $( this ).find(".amount-maximumResolution1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                    $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                       			
               if($( this ).has(".amount-firstPartAdjustingTheLaserPower").length>0)
               		$( this ).find(".amount-firstPartAdjustingTheLaserPower").val() != $( this ).find(".amount-secondPartAdjustingTheLaserPower").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                        $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');

                if($( this ).has(".amount-powerOfLaser0").length>0)
                    $( this ).find(".amount-powerOfLaser0").val() != $( this ).find(".amount-powerOfLaser1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                    	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
    
                if($( this ).has(".amount-laserPulse0").length>0)
                	$( this ).find(".amount-laserPulse0").val() != $( this ).find(".amount-laserPulse1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	    $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                            	
                if($( this ).has(".amount-theDiameterOfTheLaser0").length>0)
                	$( this ).find(".amount-theDiameterOfTheLaser0").val() != $( this ).find(".amount-theDiameterOfTheLaser1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	    $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-engravingDepth0").length>0)
                	$( this ).find(".amount-engravingDepth0").val() != $( this ).find(".amount-engravingDepth1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                        $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-laserSource0").length>0)
                	$( this ).find(".amount-laserSource0").val() != $( this ).find(".amount-laserSource1").val() ?
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
            
/*---- Ресурс лазера ----*/          
            $(function() {
            $( ".slider-range-laserSource" ).slider({
              range: true,
              min: 0,
              max: 10000000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-laserSource0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-laserSource1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-laserSource0" ).val(ui.values[ 0 ]);
                $( ".amount-laserSource1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-laserSource0" ).val( $( ".slider-range-laserSource" ).slider("values", 0 ));             
            $( ".amount-laserSource1" ).val( $( ".slider-range-laserSource" ).slider("values", 1 ));
                
            $( ".amount-laserSource0" ).change(function() {
            $(".slider-range-laserSource").slider('values',0,this.value);
                });
                
            $( ".amount-laserSource1" ).change(function() {
            $(".slider-range-laserSource").slider('values',1,this.value);
                });
            
          });
            
/*---- Глубина гравировки ----*/          
            $(function() {
            $( ".slider-range-engravingDepth" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-engravingDepth0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-engravingDepth1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-engravingDepth0" ).val(ui.values[ 0 ]);
                $( ".amount-engravingDepth1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-engravingDepth0" ).val( $( ".slider-range-engravingDepth" ).slider("values", 0 ));             
            $( ".amount-engravingDepth1" ).val( $( ".slider-range-engravingDepth" ).slider("values", 1 ));
                
            $( ".amount-engravingDepth0" ).change(function() {
            	$(".slider-range-engravingDepth").slider('values',0,this.value);
                });
                
            $( ".amount-engravingDepth1" ).change(function() {
            	$(".slider-range-engravingDepth").slider('values',1,this.value);
                });
            
          });

/*---- Максимальное разрешение ----*/          
            $(function() {
            $( ".slider-range-maximumResolution" ).slider({
              range: true,
              min: 0,
              max: 100000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximumResolution0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximumResolution1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-maximumResolution0" ).val(ui.values[ 0 ]);
                $( ".amount-maximumResolution1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-maximumResolution0" ).val( $( ".slider-range-maximumResolution" ).slider("values", 0 ));             
            $( ".amount-maximumResolution1" ).val( $( ".slider-range-maximumResolution" ).slider("values", 1 ));
                
            $( ".amount-maximumResolution0" ).change(function() {
            $(".slider-range-maximumResolution").slider('values',0,this.value);
                });
                
            $( ".amount-maximumResolution1" ).change(function() {
            $(".slider-range-maximumResolution").slider('values',1,this.value);
                });
            
          });    
            
/*---- Регулировка мощности лазера ----*/          
            $(function() {
            $( ".slider-range-adjustingTheLaserPower" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-firstPartAdjustingTheLaserPower').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-secondPartAdjustingTheLaserPower').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-firstPartAdjustingTheLaserPower" ).val(ui.values[ 0 ]);
                $( ".amount-secondPartAdjustingTheLaserPower" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-firstPartAdjustingTheLaserPower" ).val( $( ".slider-range-adjustingTheLaserPower" ).slider("values", 0 ));             
            $( ".amount-secondPartAdjustingTheLaserPower" ).val( $( ".slider-range-adjustingTheLaserPower" ).slider("values", 1 ));
                
            $( ".amount-firstPartAdjustingTheLaserPower" ).change(function() {
            $(".slider-range-adjustingTheLaserPower").slider('values',0,this.value);
                });
                
            $( ".amount-secondPartAdjustingTheLaserPower" ).change(function() {
            $(".slider-range-adjustingTheLaserPower").slider('values',1,this.value);
                });
            
          });   
            
/*---- Длинна волны лазера ----*/          
            $(function() {
            $( ".slider-range-laserWavelength" ).slider({
              range: true,
              min: 0,
              max: 100000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-laserWavelength0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-laserWavelength1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-laserWavelength0" ).val(ui.values[ 0 ]);
                $( ".amount-laserWavelength1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-laserWavelength0" ).val( $( ".slider-range-laserWavelength" ).slider("values", 0 ));             
            $( ".amount-laserWavelength1" ).val( $( ".slider-range-laserWavelength" ).slider("values", 1 ));
                
            $( ".amount-laserWavelength0" ).change(function() {
            $(".slider-range-laserWavelength").slider('values',0,this.value);
                });
                
            $( ".amount-laserWavelength1" ).change(function() {
            $(".slider-range-laserWavelength").slider('values',1,this.value);
                });
            
          });
            
/*---- Импульс лазера ----*/          
            $(function() {
            $( ".slider-range-laserPulse" ).slider({
              range: true,
              min: 0,
              max: 100000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-laserPulse0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-laserPulse1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-laserPulse0" ).val(ui.values[ 0 ]);
                $( ".amount-laserPulse1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-laserPulse0" ).val( $( ".slider-range-laserPulse" ).slider("values", 0 ));             
            $( ".amount-laserPulse1" ).val( $( ".slider-range-laserPulse" ).slider("values", 1 ));
                
            $( ".amount-laserPulse0" ).change(function() {
            $(".slider-range-laserPulse").slider('values',0,this.value);
                });
                
            $( ".amount-laserPulse1" ).change(function() {
            $(".slider-range-laserPulse").slider('values',1,this.value);
                });
            
          });
            
/*---- Диаметр лазера ----*/          
            $(function() {
            $( ".slider-range-theDiameterOfTheLaser" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-theDiameterOfTheLaser0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-theDiameterOfTheLaser1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-theDiameterOfTheLaser0" ).val(ui.values[ 0 ]);
                $( ".amount-theDiameterOfTheLaser1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-theDiameterOfTheLaser0" ).val( $( ".slider-range-theDiameterOfTheLaser" ).slider("values", 0 ));             
            $( ".amount-theDiameterOfTheLaser1" ).val( $( ".slider-range-theDiameterOfTheLaser" ).slider("values", 1 ));
                
            $( ".amount-theDiameterOfTheLaser0" ).change(function() {
            $(".slider-range-theDiameterOfTheLaser").slider('values',0,this.value);
                });
                
            $( ".amount-theDiameterOfTheLaser1" ).change(function() {
            $(".slider-range-theDiameterOfTheLaser").slider('values',1,this.value);
                });
            
          });
   
/*--- Для рабочей области ---*/
            $(function() {
                $( ".slider-range-sizeWorkAreaX" ).slider({
                  range: true,
                  min: 1,
                  max: 1000,
                  create: function () {
                	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeWorkAreaX0').val() );
                	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeWorkAreaX1').val() );
                	},
                  slide: function( event, ui ) {
                    $( ".amount-sizeWorkAreaX0" ).val( ui.values[ 0 ]);
                    $( ".amount-sizeWorkAreaX1" ).val( ui.values[ 1 ]);
                  }
                });
                  
                $( ".amount-sizeWorkAreaX0" ).val($( ".slider-range-sizeWorkAreaX" ).slider( "values", 0 ));
                $( ".amount-sizeWorkAreaX1" ).val($( ".slider-range-sizeWorkAreaX" ).slider( "values", 1 ));
                  
                  
                $( ".amount-sizeWorkAreaX0" ).change(function() {
                $(".slider-range-sizeWorkAreaX").slider('values',0,this.value);
                    });
                    
                $( ".amount-sizeWorkAreaX1" ).change(function() {
                $(".slider-range-sizeWorkAreaX").slider('values',1,this.value);
                    });  
              });
    		
    		$(function() {
                $( ".slider-range-sizeWorkAreaY" ).slider({
                  range: true,
                  min: 1,
                  max: 1000,
                  create: function () {
                	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeWorkAreaY0').val() );
                	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeWorkAreaY1').val() );
                	},
                  slide: function( event, ui ) {
                    $( ".amount-sizeWorkAreaY0" ).val( ui.values[ 0 ]);
                    $( ".amount-sizeWorkAreaY1" ).val( ui.values[ 1 ]);
                  }
                });
                  
                $( ".amount-sizeWorkAreaY0" ).val($( ".slider-range-sizeWorkAreaY" ).slider( "values", 0 ));
                $( ".amount-sizeWorkAreaY1" ).val($( ".slider-range-sizeWorkAreaY" ).slider( "values", 1 ));
                  
                  
                $( ".amount-sizeWorkAreaY0" ).change(function() {
                $(".slider-range-sizeWorkAreaY").slider('values',0,this.value);
                    });
                    
                $( ".amount-sizeWorkAreaY1" ).change(function() {
                $(".slider-range-sizeWorkAreaY").slider('values',1,this.value);
                    });  
              });
    		
    		$(function() {
                $( ".slider-range-sizeWorkAreaZ" ).slider({
                  range: true,
                  min: 1,
                  max: 1000,
                  create: function () {
                	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeWorkAreaZ0').val() );
                	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeWorkAreaZ1').val() );
                	},
                  slide: function( event, ui ) {
                    $( ".amount-sizeWorkAreaZ0" ).val( ui.values[ 0 ]);
                    $( ".amount-sizeWorkAreaZ1" ).val( ui.values[ 1 ]);
                  }
                });
                  
                $( ".amount-sizeWorkAreaZ0" ).val($( ".slider-range-sizeWorkAreaZ" ).slider( "values", 0 ));
                $( ".amount-sizeWorkAreaZ1" ).val($( ".slider-range-sizeWorkAreaZ" ).slider( "values", 1 ));
                  
                  
                $( ".amount-sizeWorkAreaZ0" ).change(function() {
                $(".slider-range-sizeWorkAreaZ").slider('values',0,this.value);
                    });
                    
                $( ".amount-sizeWorkAreaZ1" ).change(function() {
                $(".slider-range-sizeWorkAreaZ").slider('values',1,this.value);
                    });  
              });

/*--- Мощность лазера ----*/
            $(function() {
              $( ".slider-range-powerOfLaser" ).slider({
                range: true,
                min: 0,
                max: 1000,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-powerOfLaser0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-powerOfLaser1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-powerOfLaser0" ).val( ui.values[ 0 ] );
                  $( ".amount-powerOfLaser1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-powerOfLaser0" ).val($( ".slider-range-powerOfLaser" ).slider( "values", 0 ));
              $( ".amount-powerOfLaser1" ).val($( ".slider-range-powerOfLaser" ).slider( "values", 1 ));
                
              $( ".amount-powerOfLaser0" ).change(function() {
              $(".slider-range-powerOfLaser").slider('values',0,this.value);
                  });
                  
              $( ".amount-powerOfLaser1" ).change(function() {
              $(".slider-range-powerOfLaser").slider('values',1,this.value);
                  });   

            });   		
 
/*--- Механическое разрешение ----*/
            $(function() {
              $( ".slider-range-mechanicalResolution" ).slider({
                range: true,
                min: 0,
                max: 100,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-mechanicalResolution0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-mechanicalResolution1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-mechanicalResolution0" ).val( ui.values[ 0 ] );
                  $( ".amount-mechanicalResolution1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-mechanicalResolution0" ).val($( ".slider-range-mechanicalResolution" ).slider( "values", 0 ));
              $( ".amount-mechanicalResolution1" ).val($( ".slider-range-mechanicalResolution" ).slider( "values", 1 ));
                
              $( ".amount-mechanicalResolution0" ).change(function() {
              $(".slider-range-mechanicalResolution").slider('values',0,this.value);
                  });
                  
              $( ".amount-mechanicalResolution1" ).change(function() {
              $(".slider-range-mechanicalResolution").slider('values',1,this.value);
                  });   

            });      		
    		
/*--- Программное разрешение ----*/
            $(function() {
              $( ".slider-range-softwareResolution" ).slider({
                range: true,
                min: 0,
                max: 100,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-softwareResolution0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-softwareResolution1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-softwareResolution0" ).val( ui.values[ 0 ] );
                  $( ".amount-softwareResolution1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-softwareResolution0" ).val($( ".slider-range-softwareResolution" ).slider( "values", 0 ));
              $( ".amount-softwareResolution1" ).val($( ".slider-range-softwareResolution" ).slider( "values", 1 ));
                
              $( ".amount-softwareResolution0" ).change(function() {
              $(".slider-range-softwareResolution").slider('values',0,this.value);
                  });
                  
              $( ".amount-softwareResolution1" ).change(function() {
              $(".slider-range-softwareResolution").slider('values',1,this.value);
                  });   

            });     		
    		
/*--- Минимальная толщина реза ----*/
            $(function() {
              $( ".slider-range-minimumThicknessOfCut" ).slider({
                range: true,
                min: 0,
                max: 10000,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-minimumThicknessOfCut0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-minimumThicknessOfCut1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-minimumThicknessOfCut0" ).val( ui.values[ 0 ] );
                  $( ".amount-minimumThicknessOfCut1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-minimumThicknessOfCut0" ).val($( ".slider-range-minimumThicknessOfCut" ).slider( "values", 0 ));
              $( ".amount-minimumThicknessOfCut1" ).val($( ".slider-range-minimumThicknessOfCut" ).slider( "values", 1 ));
                
              $( ".amount-minimumThicknessOfCut0" ).change(function() {
              $(".slider-range-minimumThicknessOfCut").slider('values',0,this.value);
                  });
                  
              $( ".amount-minimumThicknessOfCut1" ).change(function() {
              $(".slider-range-minimumThicknessOfCut").slider('values',1,this.value);
                  });   

            });      		
    		
/*--- Скорость гравировки ----*/
            $(function() {
              $( ".slider-range-engravingSpeed" ).slider({
                range: true,
                min: 0,
                max: 10000,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-engravingSpeed0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-engravingSpeed1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-engravingSpeed0" ).val( ui.values[ 0 ] );
                  $( ".amount-engravingSpeed1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-engravingSpeed0" ).val($( ".slider-range-engravingSpeed" ).slider( "values", 0 ));
              $( ".amount-engravingSpeed1" ).val($( ".slider-range-engravingSpeed" ).slider( "values", 1 ));
                
              $( ".amount-engravingSpeed0" ).change(function() {
              $(".slider-range-engravingSpeed").slider('values',0,this.value);
                  });
                  
              $( ".amount-engravingSpeed1" ).change(function() {
              $(".slider-range-engravingSpeed").slider('values',1,this.value);
                  });   

            });    		
    		
/*--- Скорость резки ----*/
            $(function() {
              $( ".slider-range-cuttingSpeed" ).slider({
                range: true,
                min: 0,
                max: 10000,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-cuttingSpeed0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-cuttingSpeed1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-cuttingSpeed0" ).val( ui.values[ 0 ] );
                  $( ".amount-cuttingSpeed1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-cuttingSpeed0" ).val($( ".slider-range-cuttingSpeed" ).slider( "values", 0 ));
              $( ".amount-cuttingSpeed1" ).val($( ".slider-range-cuttingSpeed" ).slider( "values", 1 ));
                
              $( ".amount-cuttingSpeed0" ).change(function() {
              $(".slider-range-cuttingSpeed").slider('values',0,this.value);
                  });
                  
              $( ".amount-cuttingSpeed1" ).change(function() {
              $(".slider-range-cuttingSpeed").slider('values',1,this.value);
                  });   

            });     		

/*--- для максимальной потребляемой мощности ----*/
          $(function() {
            $( ".slider-range-max_power_consumption" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-max_power_consumption0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-max_power_consumption1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-max_power_consumption0" ).val( ui.values[ 0 ] );
                $( ".amount-max_power_consumption1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-max_power_consumption0" ).val($( ".slider-range-max_power_consumption" ).slider( "values", 0 ));
            $( ".amount-max_power_consumption1" ).val($( ".slider-range-max_power_consumption" ).slider( "values", 1 ));
              
            $( ".amount-max_power_consumption0" ).change(function() {
            $(".slider-range-max_power_consumption").slider('values',0,this.value);
                });
                
            $( ".amount-max_power_consumption1" ).change(function() {
            $(".slider-range-max_power_consumption").slider('values',1,this.value);
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
                    check_point.addClass('opened');
                }else{
                    check.slideUp();
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
