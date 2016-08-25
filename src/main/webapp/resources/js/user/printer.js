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
	                				.append($('<a/>').attr("id", "/images/printers/" + product.id + "/" + checkPicture(product.pathPictures))
	                						.addClass("link")
	                						.attr("href", "/printer/" + product.id)
	                						.append($('<div/>').addClass("outer_a_img").append($('<img/>').attr("src", "/images/printers/" + product.id + "/" + product.pathPictures[0]))))
	    	                		.append($('<div/>').addClass("name_price_cart_block")
	    	                				.append($('<a/>').attr("href", "/printer/" + product.id).addClass("products_title").text(product.name))
	    	    	                		.append(slidePrice)
	    	    	                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
	            			                			addToCart('printer', product.id, product.name, product.prise+'', product.pathPictures[0]);
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
       	       			
       	       	if($( this ).has(".amount-sizeDropRangeFrom").length>0)
       	       		$( this ).find(".amount-sizeDropRangeFrom").val() != $( this ).find(".amount-sizeDropRangeUntil").val() ?
       	       	    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');

       	        if($( this ).has(".amount-prise0").length>0)
       	        	$( this ).find(".amount-prise0").val() != $( this ).find(".amount-prise1").val() ?
       	        		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
       	        	       	       		
       	        if($( this ).has(".amount-speed-print0").length>0)
             		$( this ).find(".amount-speed-print0").val() != $( this ).find(".amount-speed-print1").val() ?
             	    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
             	    	
             	if($( this ).has(".amount-maximum_media_thickness60_0").length>0)
                	($( this ).find(".amount-maximum_media_thickness60_0").val() != $( this ).find(".amount-maximum_media_thickness60_1").val())
                	|| ($( this ).find(".amount-maximum_media_thickness500_0").val() != $( this ).find(".amount-maximum_media_thickness500_1").val()) ?
                    	$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
                    	
                if($( this ).has(".amount-maximum_weight_of_vehicle0").length>0)
                	$( this ).find(".amount-maximum_weight_of_vehicle0").val() != $( this ).find(".amount-maximum_weight_of_vehicle1").val() ?
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
        
/*---- диапазон для поиска по определенной ширине ----*/          
        $(function() {
        $( ".slider-range-weightPrintMMRange" ).slider({
          range: true,
          min: 1,
          max: 5400,
          create: function () {
      	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-weightPrintMMRangeFrom').val() );
      	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-weightPrintMMRangeUntil').val() );
      	},
          slide: function( event, ui ) {
            $( ".amount-weightPrintMMRangeFrom" ).val(ui.values[ 0 ]);
            $( ".amount-weightPrintMMRangeUntil" ).val(ui.values[ 1 ]);
          }
        });
            
        $( ".amount-weightPrintMMRangeFrom" ).val( $( ".slider-range-weightPrintMMRange" ).slider("values", 0 ));             
        $( ".amount-weightPrintMMRangeUntil" ).val( $( ".slider-range-weightPrintMMRange" ).slider("values", 1 ));
            
        $( ".amount-weightPrintMMRangeFrom" ).change(function() {
        	$(".slider-range-weightPrintMMRange").slider('values',0,this.value);
        });
            
        $( ".amount-weightPrintMMRangeUntil" ).change(function() {
        	$(".slider-range-weightPrintMMRange").slider('values',1,this.value);
        });
       
      });
        
        
        
/*---- диапазон для размера капли ----*/          
        $(function() {
        $( ".slider-range-size-drop" ).slider({
          range: true,
          min: 0,
          max: 100,
          create: function () {
      	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeDropRangeFrom').val() );
      	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeDropRangeUntil').val() );
      	},
          slide: function( event, ui ) {
            $( ".amount-sizeDropRangeFrom" ).val(ui.values[ 0 ]);
            $( ".amount-sizeDropRangeUntil" ).val(ui.values[ 1 ]);
          }
        });
            
        $( ".amount-sizeDropRangeFrom" ).val( $( ".slider-range-size-drop" ).slider("values", 0 ));             
        $( ".amount-sizeDropRangeUntil" ).val( $( ".slider-range-size-drop" ).slider("values", 1 ));
            
        $( ".amount-sizeDropRangeFrom" ).change(function() {
        $(".slider-range-size-drop").slider('values',0,this.value);
            });
            
        $( ".amount-sizeDropRangeUntil" ).change(function() {
        $(".slider-range-size-drop").slider('values',1,this.value);
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
/*---- диапазон для скорости печати----*/ 
          $(function() {
            $( ".slider-range-speed-print" ).slider({
              range: true,
              min: 1,
              max: 300,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-speed-print0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-speed-print1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-speed-print0" ).val( ui.values[ 0 ]);
                $( ".amount-speed-print1" ).val( ui.values[ 1 ]);
              }
            });
              
            $( ".amount-speed-print0" ).val($( ".slider-range-speed-print" ).slider( "values", 0 ));
            $( ".amount-speed-print1" ).val($( ".slider-range-speed-print" ).slider( "values", 1 ));
              
              
            $( ".amount-speed-print0" ).change(function() {
            $(".slider-range-speed-print").slider('values',0,this.value);
                });
                
            $( ".amount-speed-print1" ).change(function() {
            $(".slider-range-speed-print").slider('values',1,this.value);
                });  
            
          });
/*---- диапазон для максимальной толщины носителя ----*/
        /*для диапазона от 1 до 60*/
          $(function() {
            $( ".slider-range-maximum_media_thickness60" ).slider({
              range: true,
              min: 1,
              max: 60,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximum_media_thickness60_0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximum_media_thickness60_1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-maximum_media_thickness60_0" ).val( ui.values[ 0 ] );
                $( ".amount-maximum_media_thickness60_1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-maximum_media_thickness60_0" ).val( $( ".slider-range-maximum_media_thickness60" ).slider( "values", 0 ));    
            $( ".amount-maximum_media_thickness60_1" ).val( $( ".slider-range-maximum_media_thickness60" ).slider( "values", 1 ) );
            
            $( ".amount-maximum_media_thickness60_0" ).change(function() {
            $(".slider-range-maximum_media_thickness60").slider('values',0,this.value);
                });
                
            $( ".amount-maximum_media_thickness60_1" ).change(function() {
            $(".slider-range-maximum_media_thickness60").slider('values',1,this.value);
                });  
            
          });
        /*для диапазона от 60 до 500*/
          $(function() {
            $( ".slider-range-maximum_media_thickness500" ).slider({
              range: true,
              min: 60,
              max: 500,
              create: function () {
            	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximum_media_thickness500_0').val() );
            	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximum_media_thickness500_1').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-maximum_media_thickness500_0" ).val( ui.values[ 0 ] );
                $( ".amount-maximum_media_thickness500_1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-maximum_media_thickness500_0" ).val( $( ".slider-range-maximum_media_thickness500" ).slider( "values", 0 ));    
            $( ".amount-maximum_media_thickness500_1" ).val( $( ".slider-range-maximum_media_thickness500" ).slider( "values", 1 ) );
            
            $( ".amount-maximum_media_thickness500_0" ).change(function() {
            $(".slider-range-maximum_media_thickness500").slider('values',0,this.value);
                });
                
            $( ".amount-maximum_media_thickness500_1" ).change(function() {
            $(".slider-range-maximum_media_thickness500").slider('values',1,this.value);
                });  
          });
/*--- для максимального веса носителя ---*/
          $(function() {
            $( ".slider-range-maximum_weight_of_vehicle" ).slider({
              range: true,
              min: 5,
              max: 500,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximum_weight_of_vehicle0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-maximum_weight_of_vehicle1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-maximum_weight_of_vehicle0" ).val( ui.values[ 0 ] );
                $( ".amount-maximum_weight_of_vehicle1" ).val( ui.values[ 1 ] );
              }
            });
              
            $( ".amount-maximum_weight_of_vehicle0" ).val($( ".slider-range-maximum_weight_of_vehicle" ).slider( "values", 0 )); 
            $( ".amount-maximum_weight_of_vehicle1" ).val($( ".slider-range-maximum_weight_of_vehicle" ).slider( "values", 1 ));
              
            $( ".amount-maximum_weight_of_vehicle0" ).change(function() {
            $(".slider-range-maximum_weight_of_vehicle").slider('values',0,this.value);
                });
                
            $( ".amount-maximum_weight_of_vehicle1" ).change(function() {
            $(".slider-range-maximum_weight_of_vehicle").slider('values',1,this.value);
                });  
              
          });
/*--- для максимальной потребляемой мощности ----*/
          $(function() {
            $( ".slider-range-max_power_consumption" ).slider({
              range: true,
              min: 0,
              max: 2500,
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
            $(".block_title").click(function(){
                var check = $(this).parent('.search_criteria').find(".check_boxes");
                var check_point = $(this).find("i");
                if (check.css('display') == 'none') {
                    check.slideDown();
                  /*  check.css('display', 'block');*/
                    check_point.addClass('opened');
		   /* $(this).find("i, p").css('color','#006080');*/
                }else{
                    check.slideUp();
                 /*   check.css('display', 'none');*/
                    check_point.removeClass('opened');
		   /* $(this).find("i, p").css('color','rgb(144, 144, 144)');*/
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
        
    	
        /* for type print head */
    	$( function(){
                $(".block_search_criteria .block_check_boxes .outer_type_print_head .print_series").click(function(){
                    var check = $(this).parent('.outer_type_print_head').find(".inner_block_print_head");
					var check_input = $(this).parent('.outer_type_print_head').find(".check_print_head");
    		
                    if (check.css('display') == 'none') {
                        check.slideDown();
						check_input.prop("checked", false );
                    }else{
                        check.slideUp();
						check_input.prop("checked", true );
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
