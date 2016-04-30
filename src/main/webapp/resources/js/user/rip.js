/*----  Для вывода новых принтеров при поиске  -----*/        
		$(document).ready(function() {
			
			$('#search').ajaxForm( {
				type: 'post',
				success: function(products) { 
					$("#out_result_of_search").html('');
					
	                $(products).each(function(i, product) {
	                	var outerDiv = $('<div/>');

	                	outerDiv.addClass("products")
	                				.append($('<a/>').attr("id", "/images/rips/" + product.id + "/" + product.pathPictures[1])
           								 			 .addClass("link")
	                								 .attr("href", "/rip/" + product.id)
	                								 .append($('<div/>').addClass("outer_a_img").append($('<img/>')
	                										 .attr("src", "/images/rips/" + product.id + "/" + product.pathPictures[0]))))
	                				.append($('<a/>').attr("href", "javascript:void(0)").addClass("products_buy").click(function(){
	    	                			addToCart('rip', product.id);
	    	                		}).append($('<img/>').attr("src", "/images/button_buy.png")))
	    	                		.append($('<a/>').attr("href", "/rip/" + product.id).addClass("products_title").text(product.name))
	    	                		.append($('<p/>').addClass("products_price").text("Цена: " + checkPrise(product.prise)))		
	    	                				
	                	
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
                    $(".block_search_check .block_title_check").click(function(){
                        var check = $(this).parent('.block_search_check').find(".block_check_boxes");
                        var check_point = $(this).find("i").first();
        				var description = $(this).find("p").first();
                        if (check.css('display') == 'none') {
                            check.slideDown();
        		    		/*description.css('color', '#006080');*/
                            check_point.addClass('opened');
                        }else{
                            check.slideUp();
                            /*description.css('color', 'rgb(144, 144, 144)');*/
                            check_point.removeClass('opened');
                        }
                    });
                } ); 

            /* for head in rip */
        	$( function(){
                    $(".block_search_check .input_check").click(function(){
                        var checkTitle = $(this).parent('.block_search_check').find(".block_title_check");
						var checkBody = $(this).parent('.block_search_check').find(".block_check_boxes");
                        if ($(this).prop( "checked" )) {
                            checkTitle.slideDown();
                        }else{
                            checkTitle.slideUp();
							checkTitle.find("p").css('color', 'rgb(144, 144, 144)');
							checkBody.slideUp();
							checkTitle.find("i").first().removeClass('opened');
                        }
                    });
                } ); 

			/* for body in rip */
        	$( function(){
                    $(".sub_rip_section .input_check_block").click(function(){
                        var checkTitle = $(this).parent('.sub_rip_section').find(".block_title_check_check");
						var checkBody = $(this).parent('.sub_rip_section').find(".check_boxes");
                        if ($(this).prop( "checked" )) {
                            checkTitle.slideDown();
                        }else{
                            checkTitle.slideUp();
							checkTitle.find("p").css('color', 'rgb(144, 144, 144)');
							checkBody.slideUp();
							checkTitle.find("i").first().removeClass('opened');
                        }
                    });
                } ); 

		$( function(){
                $(".search_criteria_check .block_title_check_check").click(function(){
                    var check = $(this).parent('.search_criteria_check').find(".check_boxes");
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