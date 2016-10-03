
		/* Для обозначения заполненных полей в поиске */
$(function() {
	$('.check_boxes')
			.click(
					function() {

						$(this).has(':checked').length ? $(this).parent(
								'.search_criteria')
								.css("background", "#E8F2FE").find(
										".block_title").find("i, p").css(
										'color', '#006080') : $(this).parent(
								'.search_criteria')
								.css("background", "#FFFFFF").find(
										".block_title").find("i, p").css(
										'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-prise0").length > 0)
							$(this).find(".amount-prise0").val() != $(this)
									.find(".amount-prise1").val() ? $(this)
									.parent('.search_criteria').css(
											"background", "#E8F2FE").find(
											".block_title").find("i, p").css(
											'color', '#006080') : $(this)
									.parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-numberOfShafts0").length > 0)
							$(this).find(".amount-numberOfShafts0").val() != $(
									this).find(".amount-numberOfShafts1").val() ? $(
									this).parent('.search_criteria').css(
									"background", "#E8F2FE").find(
									".block_title").find("i, p").css('color',
									'#006080')
									: $(this).parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-shaftDiameter0").length > 0)
							$(this).find(".amount-shaftDiameter0").val() != $(
									this).find(".amount-shaftDiameter1").val() ? $(
									this).parent('.search_criteria').css(
									"background", "#E8F2FE").find(
									".block_title").find("i, p").css('color',
									'#006080')
									: $(this).parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-filmThickness0").length > 0)
							$(this).find(".amount-filmThickness0").val() != $(
									this).find(".amount-filmThickness1").val() ? $(
									this).parent('.search_criteria').css(
									"background", "#E8F2FE").find(
									".block_title").find("i, p").css('color',
									'#006080')
									: $(this).parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-warmUpTime0").length > 0)
							$(this).find(".amount-warmUpTime0").val() != $(this)
									.find(".amount-warmUpTime1").val() ? $(this)
									.parent('.search_criteria').css(
											"background", "#E8F2FE").find(
											".block_title").find("i, p").css(
											'color', '#006080')
									: $(this).parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-laminationTemperature0").length > 0)
							$(this).find(".amount-laminationTemperature0")
									.val() != $(this).find(
									".amount-laminationTemperature1").val() ? $(
									this).parent('.search_criteria').css(
									"background", "#E8F2FE").find(
									".block_title").find("i, p").css('color',
									'#006080')
									: $(this).parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-laminatingSpeed0").length > 0)
							$(this).find(".amount-laminatingSpeed0").val() != $(
									this).find(".amount-laminatingSpeed1")
									.val() ? $(this).parent('.search_criteria')
									.css("background", "#E8F2FE").find(
											".block_title").find("i, p").css(
											'color', '#006080') : $(this)
									.parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-max_power_consumption0").length > 0)
							$(this).find(".amount-max_power_consumption0")
									.val() != $(this).find(
									".amount-max_power_consumption1").val() ? $(
									this).parent('.search_criteria').css(
									"background", "#E8F2FE").find(
									".block_title").find("i, p").css('color',
									'#006080')
									: $(this).parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-weight0").length > 0)
							$(this).find(".amount-weight0").val() != $(this)
									.find(".amount-weight1").val() ? $(this)
									.parent('.search_criteria').css(
											"background", "#E8F2FE").find(
											".block_title").find("i, p").css(
											'color', '#006080') : $(this)
									.parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-width0").length > 0)
							$(this).find(".amount-width0").val() != $(this)
									.find(".amount-width1").val() ? $(this)
									.parent('.search_criteria').css(
											"background", "#E8F2FE").find(
											".block_title").find("i, p").css(
											'color', '#006080') : $(this)
									.parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-depth0").length > 0)
							$(this).find(".amount-depth0").val() != $(this)
									.find(".amount-depth1").val() ? $(this)
									.parent('.search_criteria').css(
											"background", "#E8F2FE").find(
											".block_title").find("i, p").css(
											'color', '#006080') : $(this)
									.parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

						if ($(this).has(".amount-heigth0").length > 0)
							$(this).find(".amount-heigth0").val() != $(this)
									.find(".amount-heigth1").val() ? $(this)
									.parent('.search_criteria').css(
											"background", "#E8F2FE").find(
											".block_title").find("i, p").css(
											'color', '#006080') : $(this)
									.parent('.search_criteria').css(
											"background", "#FFFFFF").find(
											".block_title").find("i, p").css(
											'color', 'rgb(144, 144, 144)');

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
            
/*---- Количество валов ----*/          
            $(function() {
            $( ".slider-range-numberOfShafts" ).slider({
              range: true,
              min: 0,
              max: 10,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-numberOfShafts0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-numberOfShafts1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-numberOfShafts0" ).val(ui.values[ 0 ]);
                $( ".amount-numberOfShafts1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-numberOfShafts0" ).val( $( ".slider-range-numberOfShafts" ).slider("values", 0 ));             
            $( ".amount-numberOfShafts1" ).val( $( ".slider-range-numberOfShafts" ).slider("values", 1 ));
                
            $( ".amount-numberOfShafts0" ).change(function() {
            $(".slider-range-numberOfShafts").slider('values',0,this.value);
                });
                
            $( ".amount-numberOfShafts1" ).change(function() {
            $(".slider-range-numberOfShafts").slider('values',1,this.value);
                });
            
          });
            
/*---- Диаметр вала ----*/          
            $(function() {
            $( ".slider-range-shaftDiameter" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-shaftDiameter0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-shaftDiameter1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-shaftDiameter0" ).val(ui.values[ 0 ]);
                $( ".amount-shaftDiameter1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-shaftDiameter0" ).val( $( ".slider-range-shaftDiameter" ).slider("values", 0 ));             
            $( ".amount-shaftDiameter1" ).val( $( ".slider-range-shaftDiameter" ).slider("values", 1 ));
                
            $( ".amount-shaftDiameter0" ).change(function() {
            $(".slider-range-shaftDiameter").slider('values',0,this.value);
                });
                
            $( ".amount-shaftDiameter1" ).change(function() {
            $(".slider-range-shaftDiameter").slider('values',1,this.value);
                });
            
          });
            
            
/*---- Толщина пленки ----*/          
            $(function() {
            $( ".slider-range-filmThickness" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-filmThickness0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-filmThickness1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-filmThickness0" ).val(ui.values[ 0 ]);
                $( ".amount-filmThickness1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-filmThickness0" ).val( $( ".slider-range-filmThickness" ).slider("values", 0 ));             
            $( ".amount-filmThickness1" ).val( $( ".slider-range-filmThickness" ).slider("values", 1 ));
                
            $( ".amount-filmThickness0" ).change(function() {
            $(".slider-range-filmThickness").slider('values',0,this.value);
                });
                
            $( ".amount-filmThickness1" ).change(function() {
            $(".slider-range-filmThickness").slider('values',1,this.value);
                });
            
          });     
            
/*---- Время разогрева ----*/          
            $(function() {
            $( ".slider-range-warmUpTime" ).slider({
              range: true,
              min: 0,
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
 
/*---- Температура ламинации ----*/          
            $(function() {
            $( ".slider-range-laminationTemperature" ).slider({
              range: true,
              min: 0,
              max: 500,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-laminationTemperature0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-laminationTemperature1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-laminationTemperature0" ).val(ui.values[ 0 ]);
                $( ".amount-laminationTemperature1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-laminationTemperature0" ).val( $( ".slider-range-laminationTemperature" ).slider("values", 0 ));             
            $( ".amount-laminationTemperature1" ).val( $( ".slider-range-laminationTemperature" ).slider("values", 1 ));
                
            $( ".amount-laminationTemperature0" ).change(function() {
            $(".slider-range-laminationTemperature").slider('values',0,this.value);
                });
                
            $( ".amount-laminationTemperature1" ).change(function() {
            $(".slider-range-laminationTemperature").slider('values',1,this.value);
                });
            
          });             
 
/*---- Скорость ламинирования ----*/          
            $(function() {
            $( ".slider-range-laminatingSpeed" ).slider({
              range: true,
              min: 0,
              max: 1000,
              create: function () {
          	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find('.amount-laminatingSpeed0').val() );
          	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find('.amount-laminatingSpeed1').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-laminatingSpeed0" ).val(ui.values[ 0 ]);
                $( ".amount-laminatingSpeed1" ).val(ui.values[ 1 ]);
              }
            });
                
            $( ".amount-laminatingSpeed0" ).val( $( ".slider-range-laminatingSpeed" ).slider("values", 0 ));             
            $( ".amount-laminatingSpeed1" ).val( $( ".slider-range-laminatingSpeed" ).slider("values", 1 ));
                
            $( ".amount-laminatingSpeed0" ).change(function() {
            $(".slider-range-laminatingSpeed").slider('values',0,this.value);
                });
                
            $( ".amount-laminatingSpeed1" ).change(function() {
            $(".slider-range-laminatingSpeed").slider('values',1,this.value);
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
