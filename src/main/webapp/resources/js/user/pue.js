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
	                				.append($('<a/>').attr("id", "/images/" + product.type + "s/" + product.id + "/" + checkPicture(product.pathPictures))
           								 			 .addClass("link")
	                								 .attr("href", "/" + product.type + "/" + product.id)
	                								 .append($('<div/>').addClass("outer_a_img").append($('<img/>')
	                										 .attr("src", "/images/" + product.type + "s/" + product.id + "/" + product.pathPictures[0]))))
	    	                		.append($('<a/>').attr("href", "/" + product.type + "/" + product.id).addClass("products_title").text(product.name))
	    	                		.append(slidePrice)
	    	                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
        			                			addToCart(product.type, product.id, product.name, product.prise+'', product.pathPictures[0]);
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
                                         	        
             });
        	
        });		
		
/*---- диапазон для цены ----*/          
            $(function() {
            $( ".slider-range-prise" ).slider({
              range: true,
              min: 0,
              max: 50000,
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
            $(".search_criteria .block_title").click(function(){
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

/*------------*/
	$( function(){
        $("p.p_pue").click(function(){
            var check = $(this).parent('.block_block_title').find(".input_pue");
            if (check.prop("checked")) {
                check.prop("checked", false );
            }else{
                check.prop("checked", true );
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