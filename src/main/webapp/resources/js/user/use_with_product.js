/*----  Для вывода новых принтеров при поиске  -----*/        
		$(document).ready(function() {
			
			$('#search').ajaxForm( {
				type: 'post',
				success: function(products) { 
					$("#out_result_of_search").html('');
					$("#top_result_of_search").html('');
					
	                $(products).each(function(i, product) {
	                	var outerDiv = $('<div/>').addClass("products");
	                	var innterDiv = $('<div/>').addClass('inner_div_product');

	                	var productType = $('<a/>').attr("href", "/use_with_product/" + product.id).addClass("products_title").text(product.name);
	                	
	                	var slidePrice = $('<div/>').addClass("product_price");
        				
        				if(product.typeProduct!='Чернила для струйной печати'){
        					slidePrice.append($('<span/>').text("Цена:").css(
            						{
            							"float":"left",
            							"margin-right": "5px"
            						}));
        					
        					if(product.prise < 0.1){
            					slidePrice.append($('<a/>').attr("href","#callback_reklam").addClass('fancybox').text("\u0443\u0442\u043E\u0447\u043D\u044F\u0439\u0442\u0435"));
            				} else {
            					slidePrice.append($('<input/>').attr("type", "hidden").val(product.prise));
            					slidePrice.append($('<div/>').text(checkPrise(product.prise)));
            				}
        				} else {
        					productType.css(
            						{
            							"white-space":"normal",
            							"overflow": "unset"
            						});
        				}
	                	
        				innterDiv.append($('<a/>').attr("id", "/images/use_with_products/" + product.id + "/" + checkPicture(product.pathPictures))
           								 			 .addClass("link")
	                								 .attr("href", "/use_with_product/" + product.id)
	                								 .append($('<div/>').addClass("outer_a_img").append($('<img/>').attr("src", "/images/use_with_products/" + product.id + "/" + product.pathPictures[0]))))
	    	                		.append($('<div/>').addClass("name_price_cart_block")
	    	                				.append(productType)
	    	    	                		.append(slidePrice)
	    	    	                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
	            			                			addToCart('use_with_product', product.id, product.name, product.prise+'', product.pathPictures[0]);
	            			                		}).css(
	            			        						{
	            			        							"padding-right": "5px",
	            			        							"top": "2px",
	            			        							"right": "10px",
	            			        							"position": "absolute"
	            			        						})))	                								 

	    	                				if(product.leftSharesLink!=null && product.leftSharesLink!=""){
	    	                					innterDiv.append($('<div/>').addClass("ribbon-search-wrapper-left")
	    	                										.append($('<div/>').addClass("ribbon-search-left")
	    	                														   .text(product.leftSharesLink)
	    	                														   .css( "color", product.leftSharesLinkColorText )
	    	                														   .css( "background", product.leftSharesLinkColorFone )
	    	                														   ))
	    	                				}
	    	                	        	
	    	                	        	if(product.rightSharesLink!=null && product.rightSharesLink!=""){
	    	                	        		innterDiv.append($('<div/>').addClass("ribbon-search-wrapper-right")
	    	                										.append($('<div/>').addClass("ribbon-search-right")
	    	                														   .text(product.rightSharesLink)
	    	                														   .css( "color", product.rightSharesLinkColorText )
	    	                														   .css( "background", product.rightSharesLinkColorFone )
	    	                														   ))
	    	                				}
	    	                				
	    	                	        	outerDiv.append(innterDiv); 
	    	                				
	    	                	        	if(product.top){
	    	        	    	            	$("#top_result_of_search").append(outerDiv);
	    	        	    	            } else {
	    	        	    	            	$("#out_result_of_search").append(outerDiv);
	    	        	    	            } 
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
