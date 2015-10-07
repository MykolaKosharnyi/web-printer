/*---- диапазон для цены ----*/          
            $(function() {
            $( ".slider-range-prise" ).slider({
              range: "min",
              min: 1,
              max: 100000,
              value: 10000,
              slide: function( event, ui ) {
                $( ".amount-prise" ).val(ui.value);
              }
            });
                
            $( ".amount-prise" ).val( $( ".slider-range-prise" ).slider("value"));             
                
            $( ".amount-prise" ).change(function() {
            $(".slider-range-prise").slider('value',this.value);
                });

          });
/*---- диапазон для скорости печати----*/ 
          $(function() {
            $( ".slider-range-speed-print" ).slider({
              range: "min",
              min: 1,
              max: 300,
              value: 150,
              slide: function( event, ui ) {
                $( ".amount-speed-print" ).val( ui.value);
              }
            });
              
            $( ".amount-speed-print" ).val($( ".slider-range-speed-print" ).slider( "value"));
              
              
            $( ".amount-speed-print" ).change(function() {
            $(".slider-range-speed-print").slider('value', this.value);
                });
                
          });
/*---- диапазон для максимальной толщины носителя ----*/
          $(function() {
            $( ".slider-range-maximum_media_thickness" ).slider({
              range: "min",
              min: 1,
              max: 500,
              value: 300,
              slide: function( event, ui ) {
                $( ".amount-maximum_media_thickness" ).val( ui.value);
              }
            });
              
            $( ".amount-maximum_media_thickness" ).val( $( ".slider-range-maximum_media_thickness" ).slider( "value"));    
            
            $( ".amount-maximum_media_thickness" ).change(function() {
            $(".slider-range-maximum_media_thickness").slider('value',this.value);
                });
 
          });

/*--- для максимального веса носителя ---*/
          $(function() {
            $( ".slider-range-maximum_weight_of_vehicle" ).slider({
              range: "min",
              min: 5,
              max: 500,
              value: 300,
              slide: function( event, ui ) {
                $( ".amount-maximum_weight_of_vehicle" ).val( ui.value);
              }
            });
              
            $( ".amount-maximum_weight_of_vehicle" ).val($( ".slider-range-maximum_weight_of_vehicle" ).slider( "value")); 
              
            $( ".amount-maximum_weight_of_vehicle" ).change(function() {
            $(".slider-range-maximum_weight_of_vehicle").slider('value',this.value);
                });
              
          });
/*--- для максимальной потребляемой мощности ----*/
          $(function() {
            $( ".slider-range-max_power_consumption" ).slider({
              range: "min",
              min: 1,
              max: 100,
              value: 50,
              slide: function( event, ui ) {
                $( ".amount-max_power_consumption" ).val( ui.value);
              }
            });
              
            $( ".amount-max_power_consumption" ).val($( ".slider-range-max_power_consumption" ).slider( "value"));
              
            $( ".amount-max_power_consumption" ).change(function() {
            $(".slider-range-max_power_consumption").slider('value',this.value);
                });
            
          });
/*--- для веса ----*/
          $(function() {
            $( ".slider-range-weight" ).slider({
              range: "min",
              min: 50,
              max: 5000,
              value: 4000,
              slide: function( event, ui ) {
                $( ".amount-weight" ).val( ui.value);
              }
            });
              
            $( ".amount-weight" ).val($( ".slider-range-weight" ).slider( "value"));
              
            $( ".amount-weight" ).change(function() {
            $(".slider-range-weight").slider('value', this.value);
                });
              
          });
/*--- для ширины ---*/
          $(function() {
            $( ".slider-range-width" ).slider({
              range: "min",
              min: 1,
              max: 10,
              value: 7,
              slide: function( event, ui ) {
                $( ".amount-width" ).val( ui.value);
              }
            });
              
            $( ".amount-width" ).val($( ".slider-range-width" ).slider( "value"));
              
            $( ".amount-width" ).change(function() {
            $(".slider-range-width").slider('value', this.value);
                });
              
          });
/*--- для высоты ---*/
          $(function() {
            $( ".slider-range-heigth" ).slider({
              range: "min",
              min: 1,
              max: 10,
              value: 7,
              slide: function( event, ui ) {
                $( ".amount-heigth" ).val( ui.value);
              }
            });
              
            $( ".amount-heigth" ).val($( ".slider-range-heigth" ).slider( "value"));
              
            $( ".amount-heigth" ).change(function() {
            $(".slider-range-heigth").slider('value',this.value);
                });
              
          });
/*--- для глубины ---*/
          $(function() {
            $( ".slider-range-depth" ).slider({
              range: "min",
              min: 1,
              max: 10,
              value: 7,
              slide: function( event, ui ) {
                $( ".amount-depth" ).val( ui.value);
              }
            });
              
            $( ".amount-depth" ).val($( ".slider-range-depth" ).slider( "value"));
              
            $( ".amount-depth" ).change(function() {
            $(".slider-range-depth").slider('value', this.value);
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
/*--- реализация еще одного поля добавления фотографии ---*/
        $( function(){
            $("#add_new_photo").click(function(){
            	$(".load_photos").append("<div><input type=\"file\" name=\"file\" value=\"Выбрать фотографию\"/><p>&times;</p></div>");
            });
        } ); 
/*--- для удаления поля добавления фотографии ---*/
        $( function(){
            $(".load_photos > div p").click(function(){
            	$(this).parent("div").remove();
            });
        } ); 
