/*---- диапазон для цены ----*/          
            $(function() {
            $( ".slider-range-prise" ).slider({
              range: "min",
              min: 0,
              max: 100000,
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

$(function() {
    $( ".slider-range-sizePrintableAreaX" ).slider({
      range: "min",
      min: 0,
      max: 1000,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaX').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-sizePrintableAreaX" ).val( ui.value);
      }
    });
      
    $( ".amount-sizePrintableAreaX" ).val($( ".slider-range-sizePrintableAreaX" ).slider( "value"));
      
      
    $( ".amount-sizePrintableAreaX" ).change(function() {
    $(".slider-range-sizePrintableAreaX").slider('value',this.value);
        });
  
  });

$(function() {
    $( ".slider-range-sizePrintableAreaY" ).slider({
      range: "min",
      min: 0,
      max: 1000,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaY').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-sizePrintableAreaY" ).val( ui.value);
      }
    });
      
    $( ".amount-sizePrintableAreaY" ).val($( ".slider-range-sizePrintableAreaY" ).slider( "value"));
      
      
    $( ".amount-sizePrintableAreaY" ).change(function() {
    $(".slider-range-sizePrintableAreaY").slider('value',this.value);
        });
  });

$(function() {
    $( ".slider-range-sizePrintableAreaZ" ).slider({
      range: "min",
      min: 0,
      max: 1000,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-sizePrintableAreaZ').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-sizePrintableAreaZ" ).val( ui.value);
      }
    });
      
    $( ".amount-sizePrintableAreaZ" ).val($( ".slider-range-sizePrintableAreaZ" ).slider( "value" ));
      
    $( ".amount-sizePrintableAreaZ" ).change(function() {
    $(".slider-range-sizePrintableAreaZ").slider('value',this.value);
        });

  });

$(function() {
    $( ".slider-range-meltingPointOfThePrintingMaterial" ).slider({
      range: "min",
      min: 0,
      max: 500,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-meltingPointOfThePrintingMaterial').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-meltingPointOfThePrintingMaterial" ).val( ui.value);
      }
    });
      
    $( ".amount-meltingPointOfThePrintingMaterial" ).val($( ".slider-range-meltingPointOfThePrintingMaterial" ).slider( "value"));    
      
    $( ".amount-meltingPointOfThePrintingMaterial" ).change(function() {
    $(".slider-range-meltingPointOfThePrintingMaterial").slider('value',this.value);
        });
        
  });

$(function() {
    $( ".slider-range-sizeExtruder" ).slider({
      range: "min",
      min: 0,
      max: 2,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-sizeExtruder').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-sizeExtruder" ).val( ui.value);
      }
    });
      
    $( ".amount-sizeExtruder" ).val($( ".slider-range-sizeExtruder" ).slider( "value"));    
      
    $( ".amount-sizeExtruder" ).change(function() {
    $(".slider-range-sizeExtruder").slider('value', this.value);
        });
        
  });

$(function() {
    $( ".slider-range-speedPrint" ).slider({
      range: "min",
      min: 0,
      max: 1000,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-speedPrint').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-speedPrint" ).val( ui.value);
      }
    });
      
    $( ".amount-speedPrint" ).val($( ".slider-range-speedPrint" ).slider( "value"));
      
    $( ".amount-speedPrint" ).change(function() {
    $(".slider-range-speedPrint").slider('value',this.value);
        });

  });

$(function() {
    $( ".slider-range-thicknessOfThePrintingLayer" ).slider({
      range: "min",
      min: 0,
      max: 500,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-thicknessOfThePrintingLayer').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-thicknessOfThePrintingLayer" ).val( ui.value);
      }
    });
      
    $( ".amount-thicknessOfThePrintingLayer" ).val($( ".slider-range-thicknessOfThePrintingLayer" ).slider( "value"));    
      
    $( ".amount-thicknessOfThePrintingLayer" ).change(function() {
    $(".slider-range-thicknessOfThePrintingLayer").slider('value', this.value);
        });
  
  });

$(function() {
    $( ".slider-range-maximumWeightOfThePrintedModel" ).slider({
      range: "min",
      min: 0,
      max: 100,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-maximumWeightOfThePrintedModel').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-maximumWeightOfThePrintedModel" ).val( ui.value);
      }
    });
      
    $( ".amount-maximumWeightOfThePrintedModel" ).val($( ".slider-range-maximumWeightOfThePrintedModel" ).slider( "value"));
      
    $( ".amount-maximumWeightOfThePrintedModel" ).change(function() {
    $(".slider-range-maximumWeightOfThePrintedModel").slider('value', this.value);
        });

  });

$(function() {
    $( ".slider-range-maxPowerConsumption" ).slider({
      range: "min",
      min: 0,
      max: 1000,
      create: function () {
    	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-maxPowerConsumption').val() );
    	},
      slide: function( event, ui ) {
        $( ".amount-maxPowerConsumption" ).val( ui.value);
      }
    });
      
    $( ".amount-maxPowerConsumption" ).val($( ".slider-range-maxPowerConsumption" ).slider( "value"));
      
    $( ".amount-maxPowerConsumption" ).change(function() {
    $(".slider-range-maxPowerConsumption").slider('value', this.value);
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
      $( ".amount-weight" ).val( ui.value );
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
      $( ".amount-width" ).val( ui.value );
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
      $( ".amount-heigth" ).val( ui.value );
    }
  });
    
  $( ".amount-heigth" ).val($( ".slider-range-heigth" ).slider( "value" ));
    
  $( ".amount-heigth" ).change(function() {
  $(".slider-range-heigth").slider('value', this.value);
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
      $( ".amount-depth" ).val( ui.value );
    }
  });
    
  $( ".amount-depth" ).val($( ".slider-range-depth" ).slider( "value"));
    
  $( ".amount-depth" ).change(function() {
  $(".slider-range-depth").slider('value', this.value);
      });
    
});
