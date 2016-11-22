/*---- диапазон для цены ----*/          
            $(function() {
            $( ".slider-range-prise" ).slider({
              range: "min",
              min: 0,
              max: 1000000,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-prise').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-prise" ).val(ui.value);
              }
            });
                
            $( ".amount-prise" ).val( $( ".slider-range-prise" ).slider("value"));             
                
            $( ".amount-prise" ).change(function() {
            	$(".slider-range-prise").slider('value',this.value);
            });

          });

/*--- для максимальной потребляемой мощности ----*/
          $(function() {
            $( ".slider-range-max_power_consumption" ).slider({
              range: "min",
              min: 0,
              max: 100000,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-max_power_consumption').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-max_power_consumption" ).val( ui.value);
              }
            });
              
            $( ".amount-max_power_consumption" ).val($( ".slider-range-max_power_consumption" ).slider( "value"));
              
            $( ".amount-max_power_consumption" ).change(function() {
            $(".slider-range-max_power_consumption").slider('value',this.value);
                });
            
          });
/*--- для веса ----
          $(function() {
            $( ".slider-range-weight" ).slider({
              range: "min",
              min: 0,
              max: 5000,
              create: function () {
          	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-weight').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-weight" ).val( ui.value);
              }
            });
              
            $( ".amount-weight" ).val($( ".slider-range-weight" ).slider( "value"));
              
            $( ".amount-weight" ).change(function() {
            $(".slider-range-weight").slider('value', this.value);
                });
              
          });*/
/*--- для ширины ---*/
          $(function() {
            $( ".slider-range-width" ).slider({
              range: "min",
              min: 0,
              max: 10000,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-width').val() );
            	},
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
              min: 0,
              max: 10000,
              create: function () {
          	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-heigth').val() );
          	},
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
              min: 0,
              max: 10000,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-depth').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-depth" ).val( ui.value);
              }
            });
              
            $( ".amount-depth" ).val($( ".slider-range-depth" ).slider( "value"));
              
            $( ".amount-depth" ).change(function() {
            $(".slider-range-depth").slider('value', this.value);
                });
              
          });
       