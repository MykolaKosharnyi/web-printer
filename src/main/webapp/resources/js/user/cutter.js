/*----  Для вывода новых принтеров при поиске  -----*/        
		$(document).ready(function() {
			
			$('#search').ajaxForm( {
				type: 'post',
				success: function(products) { 
					$("#out_result_of_search").html('');
					
	                $(products).each(function(i, product) {
	                	var outerDiv = $('<div/>');

	                	outerDiv.addClass("products")
	                				.append($('<a/>').attr("id", "/images/cutters/" + product.id + "/" + checkPicture(product.pathPictures))
           								 			 .addClass("link")
	                								 .attr("href", "/cutter/" + product.id)
	                								 .append($('<div/>').addClass("outer_a_img").append($('<img/>').attr("src", "/images/cutters/" + product.id + "/" + product.pathPictures[0]))))
	    	                		.append($('<a/>').attr("href", "/cutter/" + product.id).addClass("products_title").text(product.name))
	    	                		.append($('<p/>').addClass("products_price").text("Цена: " + checkPrise(product.prise)))
	    	                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
        			                			addToCart('cutter', product.id, product.name, product.prise+'', product.pathPictures[0]);
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
       	        		
       	         if($( this ).has(".amount-mechanicalResolution0").length>0)
       	        	$( this ).find(".amount-mechanicalResolution0").val() != $( this ).find(".amount-mechanicalResolution1").val() ?
       	       	    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
       	        		
       	       	if($( this ).has(".amount-softwareResolution0").length>0)
         	    	$( this ).find(".amount-softwareResolution0").val() != $( this ).find(".amount-softwareResolution1").val() ?
         	       		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	    $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');	
         	       		
         	    if($( this ).has(".amount-frequencySpindle0").length>0)
             		$( this ).find(".amount-frequencySpindle0").val() != $( this ).find(".amount-frequencySpindle1").val() ?
             	    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	    $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
       	       
             	if($( this ).has(".amount-processingSpeedXY0").length>0)
                	$( this ).find(".amount-processingSpeedXY0").val() != $( this ).find(".amount-processingSpeedXY1").val() ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	    $( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
       	        		
                if($( this ).has(".amount-processingSpeedZ0").length>0)
                	$( this ).find(".amount-processingSpeedZ0").val() != $( this ).find(".amount-processingSpeedZ1").val() ?
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
    		
/*--- Частота вращения шпинделя ----*/
            $(function() {
              $( ".slider-range-frequencySpindle" ).slider({
                range: true,
                min: 100,
                max: 10000,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-frequencySpindle0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-frequencySpindle1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-frequencySpindle0" ).val( ui.values[ 0 ] );
                  $( ".amount-frequencySpindle1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-frequencySpindle0" ).val($( ".slider-range-frequencySpindle" ).slider( "values", 0 ));
              $( ".amount-frequencySpindle1" ).val($( ".slider-range-frequencySpindle" ).slider( "values", 1 ));
                
              $( ".amount-frequencySpindle0" ).change(function() {
              $(".slider-range-frequencySpindle").slider('values',0,this.value);
                  });
                  
              $( ".amount-frequencySpindle1" ).change(function() {
              $(".slider-range-frequencySpindle").slider('values',1,this.value);
                  });   

            });      		
    		
/*--- Скорость обработки(XY) ----*/
            $(function() {
              $( ".slider-range-processingSpeedXY" ).slider({
                range: true,
                min: 0,
                max: 100,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-processingSpeedXY0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-processingSpeedXY1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-processingSpeedXY0" ).val( ui.values[ 0 ] );
                  $( ".amount-processingSpeedXY1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-processingSpeedXY0" ).val($( ".slider-range-processingSpeedXY" ).slider( "values", 0 ));
              $( ".amount-processingSpeedXY1" ).val($( ".slider-range-processingSpeedXY" ).slider( "values", 1 ));
                
              $( ".amount-processingSpeedXY0" ).change(function() {
            	  $(".slider-range-processingSpeedXY").slider('values',0,this.value);
                  });
                  
              $( ".amount-processingSpeedXY1" ).change(function() {
            	  $(".slider-range-processingSpeedXY").slider('values',1,this.value);
                  });   

            });    		
    		
/*--- Скорость обработки(Z) ----*/
            $(function() {
              $( ".slider-range-processingSpeedZ" ).slider({
                range: true,
                min: 0,
                max: 500,
                create: function () {
              	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-processingSpeedZ0').val() );
              	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-processingSpeedZ1').val() );
              	},
                slide: function( event, ui ) {
                  $( ".amount-processingSpeedZ0" ).val( ui.values[ 0 ] );
                  $( ".amount-processingSpeedZ1" ).val( ui.values[ 1 ] );
                }
              });
                
              $( ".amount-processingSpeedZ0" ).val($( ".slider-range-processingSpeedZ" ).slider( "values", 0 ));
              $( ".amount-processingSpeedZ1" ).val($( ".slider-range-processingSpeedZ" ).slider( "values", 1 ));
                
              $( ".amount-processingSpeedZ0" ).change(function() {
              $(".slider-range-processingSpeedZ").slider('values',0,this.value);
                  });
                  
              $( ".amount-processingSpeedZ1" ).change(function() {
              $(".slider-range-processingSpeedZ").slider('values',1,this.value);
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
