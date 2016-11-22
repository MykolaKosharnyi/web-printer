
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
                    	
       	        		if($( this ).has(".amount-scanSpeed0").length>0)
       	       	        	$( this ).find(".amount-scanSpeed0").val() != $( this ).find(".amount-scanSpeed1").val() ?
       	       	        		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
       	                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');    	
                    	
       	       	        	if($( this ).has(".amount-softwareResolution0").length>0)
           	       	        	$( this ).find(".amount-softwareResolution0").val() != $( this ).find(".amount-softwareResolution1").val() ?
           	       	        		$( this ).parent('.search_criteria').css( "background", "#E8F2FE" ).find(".block_title").find("i, p").css('color','#006080'):
           	                	$( this ).parent('.search_criteria').css( "background", "#FFFFFF" ).find(".block_title").find("i, p").css('color','rgb(144, 144, 144)');
           	       	        		
           	       	        	if($( this ).has(".amount-theMaximumThicknessOfTheCarrier0").length>0)
               	       	        	$( this ).find(".amount-theMaximumThicknessOfTheCarrier0").val() != $( this ).find(".amount-theMaximumThicknessOfTheCarrier1").val() ?
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
              max: 1000000,
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
            
/*---- диапазон для Программное разрешение ----*/          
            $(function() {
            $( ".slider-range-softwareResolution" ).slider({
              range: true,
              min: 25,
              max: 19200,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-softwareResolution0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-softwareResolution1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-softwareResolution0" ).val(ui.values[ 0 ]);
                $( ".amount-softwareResolution1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-softwareResolution0" ).val( $( ".slider-range-softwareResolution" ).slider("values", 0 ));             
            $( ".amount-softwareResolution1" ).val( $( ".slider-range-softwareResolution" ).slider("values", 1 ));
                
            $( ".amount-softwareResolution0" ).change(function() {
            $(".slider-range-softwareResolution").slider('values',0,this.value);
                });
                
            $( ".amount-softwareResolution1" ).change(function() {
            $(".slider-range-softwareResolution").slider('values',1,this.value);
                });
            
          });

/*---- диапазон для Скорость сканирования ----*/          
            $(function() {
            $( ".slider-range-scanSpeed" ).slider({
              range: true,
              min: 0,
              max: 20,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-scanSpeed0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-scanSpeed1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-scanSpeed0" ).val(ui.values[ 0 ]);
                $( ".amount-scanSpeed1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-scanSpeed0" ).val( $( ".slider-range-scanSpeed" ).slider("values", 0 ));             
            $( ".amount-scanSpeed1" ).val( $( ".slider-range-scanSpeed" ).slider("values", 1 ));
                
            $( ".amount-scanSpeed0" ).change(function() {
            $(".slider-range-scanSpeed").slider('values',0,this.value);
                });
                
            $( ".amount-scanSpeed1" ).change(function() {
            $(".slider-range-scanSpeed").slider('values',1,this.value);
                });
            
          });

/*---- диапазон для Максимальная толщина  носителя ----*/          
            $(function() {
            $( ".slider-range-theMaximumThicknessOfTheCarrier" ).slider({
              range: true,
              min: 0,
              max: 20,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-theMaximumThicknessOfTheCarrier0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-theMaximumThicknessOfTheCarrier1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-theMaximumThicknessOfTheCarrier0" ).val(ui.values[ 0 ]);
                $( ".amount-theMaximumThicknessOfTheCarrier1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-theMaximumThicknessOfTheCarrier0" ).val( $( ".slider-range-theMaximumThicknessOfTheCarrier" ).slider("values", 0 ));             
            $( ".amount-theMaximumThicknessOfTheCarrier1" ).val( $( ".slider-range-theMaximumThicknessOfTheCarrier" ).slider("values", 1 ));
                
            $( ".amount-theMaximumThicknessOfTheCarrier0" ).change(function() {
            $(".slider-range-theMaximumThicknessOfTheCarrier").slider('values',0,this.value);
                });
                
            $( ".amount-theMaximumThicknessOfTheCarrier1" ).change(function() {
            $(".slider-range-theMaximumThicknessOfTheCarrier").slider('values',1,this.value);
                });
            
          });
            
/*--- для максимальной потребляемой мощности ----*/
          $(function() {
            $( ".slider-range-max_power_consumption" ).slider({
              range: true,
              min: 0,
              max: 100000,
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
                    check_point.addClass('opened');
                }else{
                    check.slideUp();
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
