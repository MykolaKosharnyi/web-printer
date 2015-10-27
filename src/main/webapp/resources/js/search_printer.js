/*---- диапазон для цены ----*/          
            $(function() {
            $( ".slider-range-prise" ).slider({
              range: true,
              min: 0,
              max: 100000,
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
              min: 0.1,
              max: 100.1,
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
              min: 50,
              max: 5000,
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
              min: 0.1,
              max: 10.1,
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
              min: 0.1,
              max: 10.1,
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
              min: 0.1,
              max: 10.1,
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
              if ( $("#search_printer").css('display') == 'none' ) {
                     $("#search_printer").slideDown(1000);
                     check_point.addClass('opened');
                      } else {
                     $("#search_printer").slideUp(1000);
                     check_point.removeClass('opened');
                     }
              });
        } );  