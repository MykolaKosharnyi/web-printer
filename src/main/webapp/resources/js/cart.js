// FUNCTION TO WORK WITH CART

$(document).ready(function() {
	
	setStylesForCheckedOptions();

	//set value and name of delivery
	$("#cart input.add_price_delivery:checked").each(function(){

		//save current name
		$('#cart input.delivery_radio_name').val($(this).val());
			
		//save current price
		$('#cart input.delivery_radio_value').val(new Number($(this).parent('td').parent('tr').find('td label.add_price_value span')
				.text().replace(/\s/ig, '').replace(",", ".")));
		
	});
	
	//setQuantityInCart();
	
});

function createTRInTableForProduct(product){
	var headTr = $('<tr/>');
	var tableOptionDeliveryPaint = $('<table/>').addClass('table table-hover').css( "width", "355px" );
	
	$(productOptions(product.options, product.typeProduct, product.idProduct)).each(function(i, option){
		tableOptionDeliveryPaint.append(option);
	});
	
	if(product.deliveries.length > 0){
		tableOptionDeliveryPaint.append($('<tr/>').addClass('delivery_options')
				.append($('<td/>').attr("colspan", 3)
						.append($('<i/>').addClass('fa fa-arrow-right'))
						.append($('<p/>').addClass('delivery_options_title').text("Доставка"))));
		
		tableOptionDeliveryPaint.find('tbody')
				.append($('<input/>').attr("type", "hidden").attr("name", "delivery_radio_name").addClass('delivery_radio_name').val(""))
				.append($('<input/>').attr("type", "hidden").attr("name", "delivery_radio_value").addClass('delivery_radio_value').val(0));
	}
	
	$(productDeliveries(product.deliveries, product.typeProduct, product.idProduct)).each(function(i, delivery){
		tableOptionDeliveryPaint.append(delivery);
	});
	
	if(product.paints.length > 0){
		tableOptionDeliveryPaint.append($('<tr/>').addClass('paint_options')
				.append($('<td/>').attr("colspan", 3)
						.append($('<i/>').addClass('fa fa-arrow-right'))
						.append($('<p/>').addClass('paint_options_title').text("Краска"))));
	}
	
	$(productPaints(product.paints, product.typeProduct, product.idProduct)).each(function(i, paint){
		tableOptionDeliveryPaint.append(paint);
	});
	
	headTr.append($('<td/>').css( "width", "220px" ).append(
			$('<a/>').attr("href", '/' + product.typeProduct + '/' + product.idProduct)
				.append(
						$('<img/>').attr("src", "/" + product.picturePath).css('height','auto').css('width','100%'))))
		  .append($('<td/>').css( "max-width", "300px" ).append($('<a/>').css( "color", "black" )
							  .attr("href", '/' + product.typeProduct + '/' + product.idProduct)
							  .text(product.name)))
		  .append($('<td/>').css("padding","0px").css("width","350px").addClass('option_product_car').append(tableOptionDeliveryPaint))
		  .append($('<td/>')
				    .append($('<input/>')
						  .attr("type", "hidden")
						  .attr("name", "type")
						  .addClass('type')
						  .val(product.typeProduct)
						  )
				    .append($('<input/>')
						.attr("type", "hidden")
						.attr("name", "id")
						.addClass('id')
						.val(product.idProduct)
						)
					.append($('<span/>').addClass('dec_value').append($('<i/>').addClass('fa fa-minus').attr("aria-hidden", true)))
					.append($('<input/>').addClass('quantity quantity_' + product.typeProduct + '_' + product.idProduct).val(1).css('margin','0px 5px'))
					.append($('<span/>').addClass('inc_value').append($('<i/>').addClass('fa fa-plus').attr("aria-hidden", true)))
				)
		  .append($('<td/>').addClass('price').html("$ <span>" + checkPriseCart(product.priceWithOptionAndDeivery) + "<span/>")
				  							 	.append($('<input/>').attr("type", "hidden").attr("name", "price_ellement").val(product.price)))
		  .append($('<td/>').addClass('delte_item').append($('<i/>').addClass('fa fa-trash-o')));

	return headTr;
}

	function productOptions(options, typeProduct, idProduct){
		var TRs = [];
		$(options).each(function(i, option){
			if(option.price > 0.01){
				var tr = $('<tr/>').addClass('block_product_price');
				if(option.name!='НДС'){
					var checkedInput = $('<input/>')
						.addClass('add_price')
						.attr("type", "checkbox")
						.val(option.name)
						.attr("id", "" + option.name + "_" + typeProduct + "_" + idProduct);
					
					if(option.checked)
						checkedInput.prop("checked", true );
					
					tr.append($('<td/>').attr("colspan", 2)
							.append(checkedInput)
							.append($('<label/>')
									.addClass('add_price_title')
									.attr("for", "" + option.name + "_" + typeProduct + "_" + idProduct)
									.text(option.name)))
					  .append($('<td/>')
							  .append($('<label/>')
									  .addClass('add_price_value')
									  .html("$ <span>" + checkPriseCart(option.price) + "<span/>")));
					
				} else {
					
					var checkedInput = $('<input/>')
					.addClass('add_price')
					.attr("type", "checkbox")
					.val(option.name)
					.attr("id", "" + option.name + "_" + typeProduct + "_" + idProduct);
				
				if(option.checked)
					checkedInput.prop("checked", true );
				
				//add first TD element
				tr.append($('<td/>').attr("colspan", 3).css('padding','8px 0px')
						.append(checkedInput)
						.append($('<label/>')
								.addClass('add_price_title')
								.attr("for", "" + option.name + "_" + typeProduct + "_" + idProduct)
								.text(option.name)))
				  .append($('<td/>').css('display','none')
						  .append($('<label/>')
								  .addClass('add_price_value')
								  .html("$ <span>" + checkPriseCart(option.price) + "<span/>")));
				}
				
			}
			TRs.push(tr);
		});
		
		return TRs;
	}
	
	function productDeliveries(deliveries, typeProduct, idProduct){
		var TRs = [];
		$(deliveries).each(function(i, delivery){
			if(((delivery.priceSize > 0) || (delivery.priceWeight > 0)) &&
					((delivery.name!=null) && (delivery.name!=''))){
				var tr = $('<tr/>').addClass('block_product_price delivery_options_body');

					var checkedInput = $('<input/>')
						.addClass('add_price_delivery')
						.attr("type", "radio")
						.attr("name", "delivery")
						.val(delivery.name)
						.attr("id", "" + delivery.name + "_" + typeProduct + "_" + idProduct);
					
					if(delivery.checked)
						checkedInput.prop("checked", true );
					
					tr.append($('<td/>').attr("colspan", 2)
							.append(checkedInput)
							.append($('<label/>')
									.addClass('add_price_title')
									.attr("for", "" + delivery.name + "_" + typeProduct + "_" + idProduct)
									.text(delivery.name)))
					  .append($('<td/>')
							  .append($('<label/>')
									  .addClass('add_price_value')
									  .html("$ <span>" + checkPriseCart(delivery.priceSize + delivery.priceWeight) + "<span/>")));
				
			}
			TRs.push(tr);
		});
		
		return TRs;
	}
	
	function productPaints(paints, typeProduct, idProduct){
		var TRs = [];
		$(paints).each(function(i, paint){
			if(paint.price > 0){
				var tr = $('<tr/>').addClass('block_product_price paint_options_body');

					var checkedInput = $('<input/>')
						.addClass('add_price_paint')
						.attr("type", "checkbox")
						.val(paint.name)
						.attr("id", "" + paint.name + "_" + typeProduct + "_" + idProduct);
					
					if(paint.checked)
						checkedInput.prop("checked", true );
					
					tr.append($('<td/>')
							.append(checkedInput)
							.append($('<label/>')
									.addClass('add_price_title')
									.attr("for", "" + paint.name + "_" + typeProduct + "_" + idProduct)
									.text(paint.name)))
					  .append($('<td/>').css('padding','0px 15px')
							.append($('<span/>').addClass('dec_value_paint').append($('<i/>').addClass('fa fa-minus').attr("aria-hidden", true)))
							.append($('<input/>').addClass('quantity_paint').val(paint.quantity).css('margin','0px 5px'))
							.append($('<span/>').addClass('inc_value_paint').append($('<i/>').addClass('fa fa-plus').attr("aria-hidden", true))))
					  .append($('<td/>')
							 .append($('<label/>')
									  .addClass('add_price_value')
									  .html("$ <span>" + checkPriseCart(paint.quantity*paint.price) + "<span/>")));
				
			}
			TRs.push(tr);
		});
		
		return TRs;
	}
	
	function checkExistProduct(typeProduct, idProduct){
		//in case if this product did not added previously
		//method search in the future (maybe)
//		var result= ($('#cart form table.table_option tbody tr td input.type[value="' + typeProduct + '"]').length > 0 &&
//		$('#cart form table.table_option tbody tr td input.type[value="' + typeProduct + '"]').next('input.id[value="' + idProduct + '"]').length > 0) ?
//				 true : false;
		
		var quantity = $("#cart form table.table_option tbody tr td input.quantity_" + typeProduct + "_" + idProduct );
		if(quantity.length > 0){
			var quantity_numb = new Number(quantity.val());
			//set new price of this product
			var price_with_quantity = quantity.parent('td').parent('tr').find('td.price').find('span');		
			var price_n = new Number(price_with_quantity.text().replace(/\s/ig, '').replace(",", "."));
			price_with_quantity.text(checkPriseCart((price_n/quantity_numb) * (quantity_numb + 1)));
			
			//set new quantity of this product
			quantity.val(quantity_numb + 1);
			
			return true;
		} else {
			return false;
		}
		
	}
	
	function addProductAfterAJAXcall(product){
		if($("#cart form table.table_option").length == 0){
			var headTable = $('<table/>').addClass('table table-hover table-striped table-bordered table_option')
				.append($('<thead/>').append($("<tr/>")
						.append($('<th/>').text('Изображение'))
						.append($('<th/>').text('Наименование товара'))
						.append($('<th/>').text('Опции'))
						.append($('<th/>').text('Количество'))
						.append($('<th/>').text('Цена'))))
				.append($('<tbody/>'));
			
			$("#cart form").empty().append(headTable);//add table
			$("#cart form table.table_option tbody").first().append(createTRInTableForProduct(product));//add new product to cart
			//Add button to take everything from cart
			$('.modal-content .modal-footer').append($('<button/>').addClass('btn btn-primary').attr("type", "button").html('Оформить заказ'));
			//add total cart price
			$('.modal-content .modal-footer').prepend($('<div/>').attr("id", "div_total_price")
					.html("$ <span id='total_price'>" + checkPriseCart(product.priceWithOptionAndDeivery) + "<span/>")
					.prepend($('<span/>').text('Общая стоимость: ')));
		}else {
			//in case if this type of product already added to cart
			if(!checkExistProduct(product.typeProduct, product.idProduct)){
				$("#cart form table.table_option tbody").first().append(createTRInTableForProduct(product));
			}
		}
		
		setStylesForCheckedOptions();

		totalPrice();
	}
	
	//set new quantity on cart icon
	function setQuantityInCart(){
		var quantity = new Number(0);
		$("#cart form table.table_option tbody tr td input.quantity").each(function(){
			quantity += new Number($(this).val());
		});
		$('i#quantity_products_in_cart').empty().text(quantity);
	}
	
	function addToCart(typeProduct, idProduct, name, price, picturePath){
		
		var dataToSend = {
				'price':price,
				'pathToPicture':picturePath,
				'arrayOfCheckedOption':[],
				'checkedDelivery':null,
				'mapOfPaint':{}
		};
		
		$.ajax({
			  type: 'POST',
			  url: "/cart/add/" + typeProduct + "/" + idProduct + "/" + name,
			  data: JSON.stringify(dataToSend),
			  beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        }
		      
		}).done(function( product ){
			addProductAfterAJAXcall(product);
			
			setQuantityInCart();
			
			$(".cart-modal-window").click();
			
		});

		}
	
	function addToCartProductPageRIPaUWP(typeProduct, idProduct, name, price, 
			picturePath, arrayOfChekedOption, checkedDelivery, mapOfPaint){
		
		var dataToSend = {
				'price':price,
				'pathToPicture':picturePath,
				'arrayOfCheckedOption':arrayOfChekedOption,
				'checkedDelivery':checkedDelivery,
				'mapOfPaint':mapOfPaint
		};
		
		$.ajax({
			  type: 'POST',
			  url: "/cart/add/" + typeProduct + "/" + idProduct + "/" + name,
			  data: JSON.stringify(dataToSend),
			  beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        }
			  }).done(function( product ){
				  addProductAfterAJAXcall(product);
				  
				  setQuantityInCart();
				});	
		}
	
	function addToCartProductPage(typeProduct, idProduct, name, price,
								picturePath, arrayOfChekedOption, checkedDelivery){
		
		var dataToSend = {
				'price':price,
				'pathToPicture':picturePath,
				'arrayOfCheckedOption':arrayOfChekedOption,
				'checkedDelivery':checkedDelivery,
				'mapOfPaint':{}
		};
		
		$.ajax({
			  type: 'POST',
			  url: "/cart/add/" + typeProduct + "/" + idProduct + "/" + name,
			  data: JSON.stringify(dataToSend),
			  beforeSend: function(xhr) {
		            xhr.setRequestHeader("Accept", "application/json");
		            xhr.setRequestHeader("Content-Type", "application/json");
		        }
			  }).done(function( product ){
				  addProductAfterAJAXcall(product);
				  
				  setQuantityInCart();
				});	
		}
	
	/* Use in products pages for setting another picture after hovering on product current picture */
	function checkPicture(array){
		if(array.length > 1){
			return array[1];
		} else {
			return array[0];
		}
	}
	
/* CODE FOR DISPLAYING CART ELEMENT */

	function setStylesForCheckedOptions(){
		$("#cart input.add_price:checked, #cart input.add_price_delivery:checked, #cart input.add_price_paint:checked")
		.each(function(){
			$(this).parent('td').parent('tr.block_product_price').css('color', '#006080');
			$(this).parent('td').parent('tr.block_product_price').css('background', '#b5d9f0');
		});
	}

$(document).on("keydown", '"#cart input.quantity"', function(e){
/*$("#cart input.quantity").keydown(function (e) {*/
    // Allow: backspace, delete.
    if ($.inArray(e.keyCode, [46, 8]) !== -1 ||
         // Allow: Ctrl+A
        (e.keyCode == 65 && e.ctrlKey === true) ||
         // Allow: Ctrl+C
        (e.keyCode == 67 && e.ctrlKey === true) ||
         // Allow: Ctrl+X
        (e.keyCode == 88 && e.ctrlKey === true) ||
         // Allow: home, end, left, right
        (e.keyCode >= 35 && e.keyCode <= 39)) {
             // let it happen, don't do anything
             return;
    }
    // Ensure that it is a number and stop the keypress
    if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105) ) {
        e.preventDefault();
    }
});

		/* CHECKING ON OPTION PRODUCT */
		$(document).on("click", '#cart .add_price', function(){
			// component with contain price including quantity and option for product in price
			var price_element = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
				.parent('td.option_product_car').parent('tr').find('td.price').find('span');
			// price with quatntity and option
			var price_with_quantity_and_option = new Number(price_element.text().replace(/\s/ig, '').replace(",", "."));
			
			// quantity of this product
			var quantity_numb = new Number($(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
					.parent('td.option_product_car').parent('tr').find('td input.quantity').val());
			
			// TYPE and ID of this product to send AJAX request for changing option product on sever
			var type = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
				.parent('tr').find('td input.type').val();
			var id = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
				.parent('tr').find('td input.id').val();
			
			// VAT coeficient
			var valueVAT = $('input#НДС_' + type + "_" + id ).prop( "checked" ) ?
					new Number($('input#НДС_' + type + "_" + id).parent('td').parent('tr.block_product_price')
							.find('td label.add_price_value span').text().replace(/\s/ig, '').replace(",", ".")) : new Number(1);				
			
			// for changing style outer block if option checked
	        var change_style = $(this).parent('td').parent('.block_product_price');
			// value wich will be added or substraction from all price for the product
			var addPrice = new Number($(this).parent('td').parent('tr.block_product_price').find('td label.add_price_value span')
					.text().replace(/\s/ig, '').replace(",", "."));
			
	        if ($(this).prop( "checked" )) {
	        	/* check if it not checked VAT option; because for VAT option different way to calculate price */
	        	if($(this).val()!="НДС"){
	            	price_element.text(checkPriseCart( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, true) ));
	        	} else {
	        		price_element.text(checkPriseCart(price_with_quantity_and_option * addPrice));
	        	}
	        	// show changes on server
	        	changeOptionProductInCart(type, id, $(this).val(), true);
	        	// change presentaion on user page
	        	change_style.css('color', '#006080');
	        	change_style.css('background', '#b5d9f0');
	        	/* set new price for all products */
				totalPrice();
	        	
	        }else{
	        	/* check if it not checked VAT option; because for VAT option different way to calculate price */
	        	if($(this).val()!="НДС"){
	        		price_element.text(checkPriseCart( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, false) ));
	        	} else {
	        		price_element.text(checkPriseCart(price_with_quantity_and_option / addPrice));
	        	}
	        	// show changes on server
	        	changeOptionProductInCart(type, id, $(this).val(), false);
	        	// change presentaion on user page
	        	change_style.css('color', '#333');
	        	change_style.css('background', 'none');
	        	/* set new price for all products */
				totalPrice();
	        }
	        
	    });
		
		/* checking delivery option */
		$(document).on("click", '#cart .add_price_delivery', function(){
			// component with contain price including quantity and option for product in price
			var price_element = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
				.parent('td.option_product_car').parent('tr').find('td.price').find('span');
			// price with quatntity and option
			var price_with_quantity_and_option = new Number(price_element.text().replace(/\s/ig, '').replace(",", "."));
			
			// quantity of this product
			var quantity_numb = new Number($(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
					.parent('td.option_product_car').parent('tr').find('input.quantity').val());
			
			// TYPE and ID of this product to send AJAX request for changing option product on sever
			var type = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
				.parent('tr').find('td input.type').val();
			var id = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
				.parent('tr').find('td input.id').val();
			
			// VAT coeficient
			var valueVAT = $('input#НДС_' + type + "_" + id ).prop( "checked" ) ?
					new Number($('input#НДС_' + type + "_" + id).parent('td').parent('tr.block_product_price')
							.find('td label.add_price_value span').text().replace(/\s/ig, '').replace(",", ".")) : new Number(1);				
			
			// for changing style outer block if option checked
			var change_style = $(this).parent('td').parent('.block_product_price');
			// value wich will be added or substraction from all price for the product
			var addPrice = new Number($(this).parent('td').parent('tr.block_product_price').find('td label.add_price_value span')
				.text().replace(/\s/ig, '').replace(",", "."));
			
			//previous checked element
			var deliveryNameContainer = $('#cart input.delivery_radio_name');
			
			//value wich caries previous value of delivery price
			var deliveryValueContainer = $('#cart input.delivery_radio_value');
			
			 if ($(this).val()!=deliveryNameContainer.val()) {
	      
	            	//erase old style
	            	if(deliveryNameContainer.val()!=''){
	            		var oldCheckedDelivery = deliveryNameContainer.parent('tbody').parent('table')
						.find('tbody tr.delivery_options_body td input:radio[value="' + deliveryNameContainer.val() +'"].add_price_delivery')
						.parent('td').parent('tr.delivery_options_body')
						oldCheckedDelivery.css('color', '#333');
			        	oldCheckedDelivery.css('background', 'none');
	            	}
	            	
	            	// show changes on server
		        	changeDeliveryProductInCart(type, id, $(this).val(), true);//set new value
		        	changeDeliveryProductInCart(type, id, deliveryNameContainer.val(), false);//erase old value
	            	
	            	//set new name delivery
	            	deliveryNameContainer.val($(this).val());

	            	//first sub old checked radio value and than add new checked radio value	
	            	price_element.text(checkPriseCart( 
	            			calculatePriceIncludingVAT(
	            				calculatePriceIncludingVAT(price_with_quantity_and_option,new Number(deliveryValueContainer.val()),quantity_numb,valueVAT,false), 
	            				addPrice, 
	            				quantity_numb, 
	            				valueVAT, 
	            				true) 
	            			));

	            	// change presentaion on user page
		        	change_style.css('color', '#006080');
		        	change_style.css('background', '#b5d9f0');
		        	/* set new price for all products */
					totalPrice();
					
					//set new value delivery container
					deliveryValueContainer.val(addPrice);
	            	
	            } else {
	            	
	            	price_element.text(checkPriseCart( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, false) ));

		        	// show changes on server
		        	changeDeliveryProductInCart(type, id, $(this).val(), false);
		        	
		        	//erase old style
		        	var oldCheckedDelivery = deliveryNameContainer.parent('table')
					.find('tr.delivery_options_body td input:radio[value="' + deliveryNameContainer.val() +'"]')
					.parent('td').parent('tr.delivery_options_body')
					oldCheckedDelivery.css('color', '#333');
		        	oldCheckedDelivery.css('background', 'none');
		        	
		        	// change presentaion on user page
		        	change_style.css('color', '#333');
		        	change_style.css('background', 'none');
		        	
		        	/* set new price for all products */
					totalPrice();
	            	
	            	//set new name delivery
	            	deliveryNameContainer.val('');

	            	//set new value delivery container
					deliveryValueContainer.val(new Number(0));
	            	
	            	//clean this radio
					$(this).prop('checked', false);
	            }
	    });
		
		/* checking paint option */
		$(document).on("click", '#cart  .add_price_paint', function(){
			// component with contain price including quantity and option for product in price
			var price_element = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
				.parent('td.option_product_car').parent('tr').find('td.price').find('span');
			// price with quatntity and option
			var price_with_quantity_and_option = new Number(price_element.text().replace(/\s/ig, '').replace(",", "."));
			
			// quantity of this product
			var quantity_numb = new Number($(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
					.parent('td.option_product_car').parent('tr').find('input.quantity').val());
			
			// TYPE and ID of this product to send AJAX request for changing option product on sever
			var type = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
				.parent('tr').find('td input.type').val();
			var id = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
				.parent('tr').find('td input.id').val();
			
			// VAT coeficient
			var valueVAT = $('input#НДС_' + type + "_" + id ).prop( "checked" ) ?
					new Number($('input#НДС_' + type + "_" + id).parent('td').parent('tr.block_product_price')
							.find('td label.add_price_value span').text().replace(/\s/ig, '').replace(",", ".")) : new Number(1);				
			
			// for changing style outer block if option checked
			var change_style = $(this).parent('td').parent('.block_product_price');
			// value wich will be added or substraction from all price for the product
			var addPrice = new Number($(this).parent('td').parent('tr.block_product_price').find('td label.add_price_value span')
				.text().replace(/\s/ig, '').replace(",", "."));
			
	        if ($(this).prop( "checked" )) {
	            price_element.text(checkPriseCart( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, true) ));

	        	// show changes on server
	        	changePaintProductInCart(type, id, $(this).val(), true);
	        	// change presentaion on user page
	        	change_style.css('color', '#006080');
	        	change_style.css('background', '#b5d9f0');
	        	/* set new price for all products */
				totalPrice();
	        	
	        }else{
	        	price_element.text(checkPriseCart( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, false) ));

	        	// show changes on server
	        	changePaintProductInCart(type, id, $(this).val(), false);
	        	// change presentaion on user page
	        	change_style.css('color', '#333');
	        	change_style.css('background', 'none');
	        	/* set new price for all products */
				totalPrice();
	        }
	        
	    });
		
		function changeOptionProductInCart(typeProduct, idProduct, optionName, stateOption){
			/* change option on server */
			$.ajax({
				  type: 'POST',
				  url: "/cart/change_option/" + typeProduct + "/" + idProduct + "/" + optionName + "/" + stateOption,
				  contentType: "application/json; charset=utf-8",
	              dataType: "json"
				  });
		}
		
		function changeDeliveryProductInCart(typeProduct, idProduct, deliveryName, stateOption){
			/* change delivery on server */
			$.ajax({
				  type: 'POST',
				  url: "/cart/change_delivery/" + typeProduct + "/" + idProduct + "/" + deliveryName + "/" + stateOption,
				  contentType: "application/json; charset=utf-8",
	              dataType: "json"
				  });
		}
		
		function changePaintProductInCart(typeProduct, idProduct, paintName, stateOption){
			/* change delivery on server */
			$.ajax({
				  type: 'POST',
				  url: "/cart/change_paint/" + typeProduct + "/" + idProduct + "/" + paintName + "/" + stateOption,
				  contentType: "application/json; charset=utf-8",
	              dataType: "json"
				  });
		}
		
		/* calculating price include value of VAT; in the last operand boolead value: true for adding, false for substraction */
		function calculatePriceIncludingVAT(allOldPrice, addPrice, quantity, valueVATOption, typeOfOperation){
			return typeOfOperation ? 
					(((allOldPrice/quantity)/valueVATOption + addPrice) * valueVATOption) * quantity : 
				    (((allOldPrice/quantity)/valueVATOption - addPrice) * valueVATOption) * quantity;
		}
		
		/* get value of ckecked VAT option if it not return '1' */
		function valueVAT(idVat){
			if($('#cart input#' + idVat ).prop( "checked" )){
				return new Number($('#cart input#' + idVat).parent('td').parent('tr.block_product_price')
						.find('td label.add_price_value span').text().replace(/\s/ig, '').replace(",", "."));
			} else {
				return new Number(1);
			}
		}
		
		
		/* BUTTONS FOR INCREASING AND DECREASING QUANTITY ON PRODUCT */
		$(document).on("click", '#cart .dec_value', function(){
            var quantity_element_val = $(this).parent('td').find('input.quantity').val();
			var price_with_quantity =  $(this).parent('td').parent('tr').find('td.price').find('span');
			var price = $(this).parent('td').parent('tr').find('td.price').find('input').val();
			var quantity_numb = new Number(quantity_element_val);
			
			var type = $(this).parent('td').find('input.type').val();
			var id = $(this).parent('td').find('input.id').val();
			
			if (quantity_numb==1) {
				$(this).css('color','grey');

				$(this).hover(function() {
						$(this).css('color','grey');
					  }, function() {
						$(this).css('color','grey');
					  }
				);

			} else {
				$(this).parent('td').find('input.quantity').val(quantity_numb-1);
				//var price_n = new Number(price.replace(/\s/ig, '').replace(",", "."));
				//price_with_quantity.text(checkPriseCart(price_n * (quantity_numb - 1)));
				var price_n = new Number(price_with_quantity.text().replace(/\s/ig, '').replace(",", "."));
				price_with_quantity.text(checkPriseCart((price_n/quantity_numb) * (quantity_numb - 1)));
				
				/* set new price for all products */
				totalPrice();
				
				//set new quantity on cart icon
				setQuantityInCart();
				
				/* change quantity on server */
				changeQuantityProductInCart(type, id, quantity_numb - 1);
			}
 			
        });
		
		$(document).on("click", '#cart .inc_value', function(){

			var quantity_element_val = $(this).parent('td').find('input.quantity').val();
			var quantity_numb = new Number(quantity_element_val);

			var price_with_quantity = $(this).parent('td').parent('tr').find('td.price').find('span');
			var price = $(this).parent('td').parent('tr').find('td.price').find('input').val();
			
			if(quantity_numb==1){
				var dec_v = $(this).parent('td').find('.dec_value');
				dec_v.css('color','#006080');
				dec_v.hover(function() {
						$(this).css('color','red');
					  }, function() {
						$(this).css('color','#006080');
					  }
				);
			} 

            $(this).parent('td').find('input.quantity').val(quantity_numb+1);
			
          //  getPrice($(this));
            
			//var price_n = new Number(price.replace(/\s/ig, '').replace(",", "."));
			//price_with_quantity.text(checkPriseCart(price_n * (quantity_numb + 1)));
			
			var price_n = new Number(price_with_quantity.text().replace(/\s/ig, '').replace(",", "."));
			price_with_quantity.text(checkPriseCart((price_n/quantity_numb) * (quantity_numb + 1)));
			
			/* set new price for all products */
			totalPrice();
			
			//set new quantity on cart icon
			setQuantityInCart();
			
			/* change quantity on server */
			var type = $(this).parent('td').find('input.type').val();
			var id = $(this).parent('td').find('input.id').val();
			changeQuantityProductInCart(type, id, quantity_numb + 1);
        });
		
		/* BUTTONS FOR INCREASING AND DECREASING QUANTITY ON PAINT */
		$(document).on("click", '#cart .dec_value_paint', function(){
			// current quantity paint
			var quantity_node = $(this).parent('td').find('input.quantity_paint');
			var quantity = new Number(quantity_node.val());// quantity of paint
			
			if (quantity==1) {
				$(this).css('color','grey');

				$(this).hover(function() {
						$(this).css('color','grey');
					  }, function() {
						$(this).css('color','grey');
					  }
				);

			} else {
				
				//all price for current paint
				var paint_price_node = $(this).parent('td').parent('.block_product_price').find('td label.add_price_value  span');
				
				/* change quantity paint on server */
				var type = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
					.parent('tr').find('td input.type').val();
				var id = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
					.parent('tr').find('td input.id').val();
				var namePaint = $(this).parent('td').parent('.block_product_price').find('td input.add_price_paint').val();
				changeQuantityPaintProductInCart(type, id, namePaint, quantity - 1);	
				
				// VAT coeficient
				var valueVAT = $('input#НДС_' + type + "_" + id ).prop( "checked" ) ?
						new Number($('input#НДС_' + type + "_" + id).parent('td').parent('tr.block_product_price')
								.find('td label.add_price_value span').text().replace(/\s/ig, '').replace(",", ".")) : new Number(1);
				
				
				quantity_node.val(quantity-1);
				
				var oldPaintPrice = new Number( paint_price_node.text().replace(/\s/ig, '').replace(",", ".") );
				var newPaintPrice = new Number( (oldPaintPrice/quantity) * (quantity-1) );
				
				//set new value in 
				paint_price_node.text(checkPriseCart(newPaintPrice));
				
				/* set new price for all products */
				/* first check if our input checked, after it we will know add price to allPrice or not */
				if ($(this).parent('td').parent('.block_product_price').find('td input.add_price_paint').prop( "checked" )) {
					//quantity of product
					var quantity_product = new Number($(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
							.parent('td.option_product_car').parent('tr').find('input.quantity').val());
					
					//product for this product with all checked options
					var price_product_node = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
						.parent('td.option_product_car').parent('tr').find('td.price span');
					
					//set new value to product
					price_product_node.text(checkPriseCart( calculatePriceIncludingVAT(new Number(price_product_node.text().replace(/\s/ig, '').replace(",", ".")),
							oldPaintPrice - newPaintPrice, quantity_product, valueVAT, false) ));
					
					/* set new total price including all products price */
					totalPrice();
	            }
			}
				
	    });
		
		$(document).on("click", '#cart .inc_value_paint', function(){
			// current quantity paint
			var quantity_node = $(this).parent('td').find('input.quantity_paint');
			var quantity = new Number(quantity_node.val());// quantity of paint
			
			//all price for current paint
			var paint_price_node = $(this).parent('td').parent('.block_product_price').find('td label.add_price_value  span');
			
			/* change quantity paint on server */
			var type = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
				.parent('tr').find('td input.type').val();
			var id = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table').parent('td.option_product_car')
				.parent('tr').find('td input.id').val();
			var namePaint = $(this).parent('td').parent('.block_product_price').find('td input.add_price_paint').val();
			changeQuantityPaintProductInCart(type, id, namePaint, quantity + 1);	
			
			// VAT coeficient
			var valueVAT = $('input#НДС_' + type + "_" + id ).prop( "checked" ) ?
					new Number($('input#НДС_' + type + "_" + id).parent('td').parent('tr.block_product_price')
							.find('td label.add_price_value span').text().replace(/\s/ig, '').replace(",", ".")) : new Number(1);
			
			if(quantity==1){
				var dec_v = $(this).parent('td').parent('.block_product_price').find('td .dec_value_paint');
				dec_v.css('color','#006080');
				dec_v.hover(function() {
						$(this).css('color','red');
					}, function() {
						$(this).css('color','#006080');
					}
				);
			} 		
					
				quantity_node.val(quantity+1);
				
				var oldPaintPrice = new Number( paint_price_node.text().replace(/\s/ig, '').replace(",", ".") );
				var newPaintPrice = new Number( (oldPaintPrice/quantity) * (quantity+1) );
				
				//set new value in 
				paint_price_node.text(checkPriseCart(newPaintPrice));
				
				/* set new price for all products */
				/* first check if our input checked, after it we will know add price to allPrice or not */
				if ($(this).parent('td').parent('.block_product_price').find('td input.add_price_paint').prop( "checked" )) {
					//quantity of product
					var quantity_product = new Number($(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
							.parent('td.option_product_car').parent('tr').find('input.quantity').val());
					
					//product for this product with all checked options
					var price_product_node = $(this).parent('td').parent('tr.block_product_price').parent('tbody').parent('table')
						.parent('td.option_product_car').parent('tr').find('td.price span');
					
					//set new value to product
					price_product_node.text(checkPriseCart( calculatePriceIncludingVAT(new Number(price_product_node.text().replace(/\s/ig, '').replace(",", ".")),
							newPaintPrice - oldPaintPrice, quantity_product, valueVAT, true) ));
					
					/* set new total price including all products price */
					totalPrice();
	            }
				
	    });
		
		function totalPrice(){
			$('span#total_price' ).text(allPrice());
		}

		/* method return all sum product item + return it in presentable form */
		function allPrice(){
			var total_price = new Number();
			$('#cart td.price span').each(function(i, price_el){
				total_price += new Number($(price_el).text().replace(/\s/ig, '').replace(",", "."));
			});	
			return checkPriseCart(total_price);
		}
		
		$(document).on("click", '#cart td.delte_item i', function(){
			
			var typeProduct = $(this).parent('td').parent('tr').find('td input.type').val();
			var idProduct = $(this).parent('td').parent('tr').find('td  input.id').val();

			/* first of all sent request on server to delete this item from buffer */
			$.ajax({
				  type: 'POST',
				  url: "/cart/delete/" + typeProduct + "/" + idProduct,
				  contentType: "application/json; charset=utf-8",
	              dataType: "json"
				  });
			
			/* delete on user side. Deleting without refreshing page */
			$(this).parent('td').parent('tr').hide('slow', function(){ 
				var cartBody = $(this).parent('tbody');
				$(this).remove(); 
				
				/* set new price for all products */
				totalPrice();
				
				//set new quantity on cart icon
				setQuantityInCart();

				if(cartBody.find( "tr" ).length == 0){
					cartBody.parent('table.table_option').parent('form').empty().append("Корзина пуста.");
					//Delete button to take everything from cart
					$('.modal-content .modal-footer button.btn-primary').remove();
					$('.modal-content .modal-footer #div_total_price').remove();
				}
				
				
			});
        });
		
		function changeQuantityProductInCart(typeProduct, idProduct, quantity){
			/* change quantity on server */
			$.ajax({
				  type: 'POST',
				  url: "/cart/change_quantity/" + typeProduct + "/" + idProduct + "/" + quantity,
				  contentType: "application/json; charset=utf-8",
	              dataType: "json"
			});
		}
		
		function changeQuantityPaintProductInCart(typeProduct, idProduct, namePaint, quantity){
			/* change quantity on server */
			$.ajax({
				  type: 'POST',
				  url: "/cart/change_quantity_paint/" + typeProduct + "/" + idProduct + "/" + namePaint + "/" + quantity,
				  contentType: "application/json; charset=utf-8",
	              dataType: "json"
			});
		}
	
	/* for opening delivery option on product page */
	$(document).on("click", '#cart .delivery_options', function(){
		var icon = $(this).find('i');
		var body = $(this).parent('tbody').find('.delivery_options_body');		
		
		if(icon.hasClass( 'fa-arrow-right' )){
			icon.removeClass('fa fa-arrow-right').addClass('fa fa-arrow-down');
			body.each(function(i){	
				$(this).show(i*500);
			});
		} else {
			icon.removeClass('fa fa-arrow-down').addClass('fa fa-arrow-right');
			body.each(function(i){	
				$(this).hide(i*100);
			});
		}
	});
	
	/* for opening paint option on product page */
	$(document).on("click", '#cart .paint_options', function(){
		var icon = $(this).find('i');
		var body = $(this).parent('tbody').find('.paint_options_body');		
		
		if(icon.hasClass( 'fa-arrow-right' )){
			icon.removeClass('fa fa-arrow-right').addClass('fa fa-arrow-down');
			body.each(function(i){	
				$(this).show(i*500);
			});
		} else {
			icon.removeClass('fa fa-arrow-down').addClass('fa fa-arrow-right');
			body.each(function(i){	
				$(this).hide(i*100);
			});
		}
	});	
	
	/* return price in presentable to user form */
	function checkPriseCart(num){
			  num = Math.round( num / 0.01 ) * 0.01;
			  num = new Number(num).toFixed(2);   // особенности счета JavaScript ( x/100 не всегда = x*0.01 )
			  var s = 0;
			  var str = '';
			  for( var i=num.toString().length-1; i>=0; i-- ) {
			    s++;
			    str = num.toString().charAt(i) + str;
			    if(num.toString().charAt(i)=='.') s=0;
			    if( s > 0 && !(s % 3) ) str  = " " + str;
			  }   
			  return str.replace(".", ",");
	}

	
	function checkPrise(num){
		if(num > 0.1){
			  num = Math.round( num / 0.01 ) * 0.01;
			  num = new Number(num).toFixed(2);   // особенности счета JavaScript ( x/100 не всегда = x*0.01 )
			  var s = 0;
			  var str = '';
			  for( var i=num.toString().length-1; i>=0; i-- ) {
			    s++;
			    str = num.toString().charAt(i) + str;
			    if(num.toString().charAt(i)=='.') s=0;
			    if( s > 0 && !(s % 3) ) str  = " " + str;
			  }   
			  return "$" + str.replace(".", ",");
		} else {
			return "\u0443\u0442\u043E\u0447\u043D\u044F\u0439\u0442\u0435";
		}
	}
