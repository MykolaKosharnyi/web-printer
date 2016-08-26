<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Корзина</title>
</head>
<body>
<div id="cart">
<c:if test="${!empty cart.contents}">
	<form action="cart/pleaceOrder" method="post">
	${cartMessage}
	<table class="table table-hover table-striped table-bordered table_option">
		<thead>
			<th><spring:message code="cart.ownpage.picture"/></th>
			<th><spring:message code="cart.ownpage.item"/></th>
			<th><spring:message code="cart.ownpage.option"/></th>
			<th><spring:message code="cart.ownpage.quantity"/></th>
			<th><spring:message code="cart.ownpage.price"/></th>
			<th></th>
		</thead>
		<c:forEach var="item" items="${cart.contents}">
		<tr>
			<td><img style="height:auto; width:100%;" src="<%=request.getContextPath()%>/${item.key.picturePath}" alt=""></td>
			<td style="max-width: 235px;"><a style="color:black;" href="<c:url value='/${item.key.typeProduct}/${item.key.idProduct}' />">${item.key.name }</a></td>
			<td style="padding: 0px; width:350px;" class="option_product_car">
				
				<table class="table table-hover" style="width:350px;">
				
					<c:forEach items="${item.key.options}" var="option">
						<c:if test="${option.price > 0.01}">
							<tr class="block_product_price">
								<c:if test="${option.name!='НДС'}">
									<td colspan="2">
										<input class="add_price" type="checkbox" value="${option.name}" 
											id="${option.name}_${item.key.typeProduct}_${item.key.idProduct}"
											<c:if test="${option.checked}">checked</c:if>>
										<label class="add_price_title"
												 for="${option.name}_${item.key.typeProduct}_${item.key.idProduct}">${option.name}</label>
									</td>
									<td>
										<label class="add_price_value">
											$<span><fmt:formatNumber type="number" 
													maxFractionDigits="2" minFractionDigits="2" value="${option.price}" /></span>
										</label>
									</td>
									<%-- <label class="option_description">${option.description}</label>--%>
								</c:if>
								
								<c:if test="${option.name=='НДС'}">
									<td colspan="3" style="padding: 8px 0px;">
										<input class="add_price" type="checkbox" value="${option.name}" 
											id="${option.name}_${item.key.typeProduct}_${item.key.idProduct}"
											<c:if test="${option.checked}">checked</c:if>>
										<label class="add_price_title"
												 for="${option.name}_${item.key.typeProduct}_${item.key.idProduct}">${option.name}</label>
									</td>
									<td style="display:none;">
										<label class="add_price_value">
											$<span><fmt:formatNumber type="number" 
													maxFractionDigits="2" minFractionDigits="2" value="${option.price}" /></span>
										</label>
									</td>
									<%-- <label class="option_description">${option.description}</label>--%>
								</c:if>
							</tr>
						</c:if>
					</c:forEach>		
					
					<c:if test="${fn:length(item.key.deliveries) > 0}">
						<tr class="delivery_options">
							<td colspan="3">
								<i class="fa fa-arrow-right"></i>
								<p class="delivery_options_title">Доставка</p>
							</td>
						</tr>
					</c:if>
					
					<c:forEach items="${item.key.deliveries}" var="delivery">
						<c:if test="${((delivery.priceSize > 0) || (delivery.priceWeight > 0)) &&
									((delivery.name!=null) && (delivery.name!=''))}">
							<tr class="block_product_price delivery_options_body">
								<td colspan="2">
									<input class="add_price_delivery" type="checkbox" value="${delivery.name}" 
										id="${delivery.name}_${item.key.typeProduct}_${item.key.idProduct}_delivery"
										<c:if test="${delivery.checked}">checked</c:if>>
									<label class="add_price_title"
											 for="${delivery.name}_${item.key.typeProduct}_${item.key.idProduct}_delivery">${delivery.name}</label>
								</td>
								<td>
									<label class="add_price_value">
										$<span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${delivery.priceSize + delivery.priceWeight}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
					</c:forEach>	
					
					<c:if test="${fn:length(item.key.paints) > 0}">
						<tr class="paint_options">
							<td colspan="3">
								<i class="fa fa-arrow-right"></i>
								<p class="paint_options_title">Краска</p>
							</td>
						</tr>
					</c:if>
					
					<c:forEach items="${item.key.paints}" var="paint">
						<c:if test="${ paint.price > 0 }">
							<tr class="block_product_price paint_options_body">
								<td>
									<input class="add_price_paint" type="checkbox" value="${paint.name}" 
										id="${paint.name}_${item.key.typeProduct}_${item.key.idProduct}_paint"
										<c:if test="${paint.checked}">checked</c:if>>
									<label class="add_price_title"
											 for="${paint.name}_${item.key.typeProduct}_${item.key.idProduct}_paint">${paint.name}</label>
								</td>		
								<td style="padding: 0px 15px;"> 
									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="${paint.quantity}"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>		 
								</td>
								<td>		 
									<label class="add_price_value">
										$<span><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${paint.quantity*paint.price}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
					</c:forEach>
					
				</table>				
		
			</td>
			<td>
	
				<input type="hidden" name="type" class="type" value="${item.key.typeProduct}">
				
				<input type="hidden" name="id" class="id" value="${item.key.idProduct}">
	
				<span class="dec_value">
					<i class="fa fa-minus" aria-hidden="true"></i>
				</span>

				<input class="quantity"  value="<c:out value="${item.value }"/>"></input>

				<span class="inc_value">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</span>

			</td>
			<td class="price">$ <span>
				<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.key.getPriceWithOptionAndDeivery() * item.value }" />
					</span>
					<input type="hidden" name="price_ellement" value="${item.key.price}">
			</td>
			<td class="delte_item"><i class="fa fa-trash-o" aria-hidden="true"></i></td>
		</tr>
		</c:forEach>
		
		<tr>
			<td><spring:message code="cart.ownpage.total"/>:</td>
			<td></td>
			<td></td>
			<td></td>
			<td class="total_price">$ <span><fmt:formatNumber type="number" 
           		maxFractionDigits="2" minFractionDigits="2" value="${cart.getTotalCost()}" /></span></td>
			<td></td>
		</tr>
	</table>
		<input class="button" type="submit" value="<spring:message code="cart.ownpage.placeorder"/>"></input>
	</form>
	</c:if>
	<c:if test="${empty cart.contents}">
		Корзина пуста, Вы еще не добавляли товары в корзину.
	</c:if>
	
</div>

<script type="text/javascript">
	$(document).ready(function() {
		
		$("input.add_price:checked, input.add_price_delivery:checked, input.add_price_paint:checked").each(function(){
			$(this).parent('td').parent('tr.block_product_price').css('color', '#006080');
			$(this).parent('td').parent('tr.block_product_price').css('background', '#b5d9f0');
		});
		
	
	    $("input.quantity").keydown(function (e) {
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
	});

	$(function(){
		/* CHECKING ON OPTION PRODUCT */
		$('.add_price').click(function(){
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
	            	price_element.text(checkPrise( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, true) ));
	        	} else {
	        		price_element.text(checkPrise(price_with_quantity_and_option * addPrice));
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
	        		price_element.text(checkPrise( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, false) ));
	        	} else {
	        		price_element.text(checkPrise(price_with_quantity_and_option / addPrice));
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
		$('.add_price_delivery').click(function(){
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
	            price_element.text(checkPrise( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, true) ));

	        	// show changes on server
	        	changeDeliveryProductInCart(type, id, $(this).val(), true);
	        	// change presentaion on user page
	        	change_style.css('color', '#006080');
	        	change_style.css('background', '#b5d9f0');
	        	/* set new price for all products */
				totalPrice();
	        	
	        }else{
	        	price_element.text(checkPrise( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, false) ));

	        	// show changes on server
	        	changeDeliveryProductInCart(type, id, $(this).val(), false);
	        	// change presentaion on user page
	        	change_style.css('color', '#333');
	        	change_style.css('background', 'none');
	        	/* set new price for all products */
				totalPrice();
	        }
	        
	    });
		
		/* checking paint option */
		$('.add_price_paint').click(function(){
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
	            price_element.text(checkPrise( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, true) ));

	        	// show changes on server
	        	changePaintProductInCart(type, id, $(this).val(), true);
	        	// change presentaion on user page
	        	change_style.css('color', '#006080');
	        	change_style.css('background', '#b5d9f0');
	        	/* set new price for all products */
				totalPrice();
	        	
	        }else{
	        	price_element.text(checkPrise( calculatePriceIncludingVAT(price_with_quantity_and_option, addPrice, quantity_numb, valueVAT, false) ));

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
			if($('input#' + idVat ).prop( "checked" )){
				return new Number($('input#' + idVat).parent('td').parent('tr.block_product_price')
						.find('td label.add_price_value span').text().replace(/\s/ig, '').replace(",", "."));
			} else {
				return new Number(1);
			}
		}
		
		
		/* BUTTONS FOR INCREASING AND DECREASING QUANTITY ON PRODUCT */
		$('.dec_value').click(function(){
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
				//price_with_quantity.text(checkPrise(price_n * (quantity_numb - 1)));
				var price_n = new Number(price_with_quantity.text().replace(/\s/ig, '').replace(",", "."));
				price_with_quantity.text(checkPrise((price_n/quantity_numb) * (quantity_numb - 1)));
				
				/* set new price for all products */
				totalPrice();
				
				/* change quantity on server */
				changeQuantityProductInCart(type, id, quantity_numb - 1);
			}
 			
        });
		
		$('.inc_value').click(function(){

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
			//price_with_quantity.text(checkPrise(price_n * (quantity_numb + 1)));
			
			var price_n = new Number(price_with_quantity.text().replace(/\s/ig, '').replace(",", "."));
			price_with_quantity.text(checkPrise((price_n/quantity_numb) * (quantity_numb + 1)));
			/* set new price for all products */
			totalPrice();
			
			/* change quantity on server */
			var type = $(this).parent('td').find('input.type').val();
			var id = $(this).parent('td').find('input.id').val();
			changeQuantityProductInCart(type, id, quantity_numb + 1);
        });
		
		/* BUTTONS FOR INCREASING AND DECREASING QUANTITY ON PAINT */
		$('.dec_value_paint').click(function(){
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
			changeQuantityPaintProductInCart(type, id, namePaint, quantity - 1);	
			
			// VAT coeficient
			var valueVAT = $('input#НДС_' + type + "_" + id ).prop( "checked" ) ?
					new Number($('input#НДС_' + type + "_" + id).parent('td').parent('tr.block_product_price')
							.find('td label.add_price_value span').text().replace(/\s/ig, '').replace(",", ".")) : new Number(1);
			
			if (quantity==1) {
				$(this).css('color','grey');

				$(this).hover(function() {
						$(this).css('color','grey');
					  }, function() {
						$(this).css('color','grey');
					  }
				);

			} else {
				quantity_node.val(quantity-1);
				
				var oldPaintPrice = new Number( paint_price_node.text().replace(/\s/ig, '').replace(",", ".") );
				var newPaintPrice = new Number( (oldPaintPrice/quantity) * (quantity-1) );
				
				//set new value in 
				paint_price_node.text(checkPrise(newPaintPrice));
				
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
					price_product_node.text(checkPrise( calculatePriceIncludingVAT(new Number(price_product_node.text().replace(/\s/ig, '').replace(",", ".")),
							oldPaintPrice - newPaintPrice, quantity_product, valueVAT, false) ));
					
					/* set new total price including all products price */
					totalPrice();
	            }
			}
				
	    });
		
		$('.inc_value_paint').click(function(){
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
				paint_price_node.text(checkPrise(newPaintPrice));
				
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
					price_product_node.text(checkPrise( calculatePriceIncludingVAT(new Number(price_product_node.text().replace(/\s/ig, '').replace(",", ".")),
							newPaintPrice - oldPaintPrice, quantity_product, valueVAT, true) ));
					
					/* set new total price including all products price */
					totalPrice();
	            }
				
	    });
		
		function totalPrice(){
			$('tr td.total_price span' ).text(allPrice());
		}
		
		/* return price in presentable to user form */
		function checkPrise(num){
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

		/* method return all sum product item + return it in presentable form */
		function allPrice(){
			var total_price = new Number();
			$('td.price span').each(function(i, price_el){
				total_price += new Number($(price_el).text().replace(/\s/ig, '').replace(",", "."));
			});	
			return checkPrise(total_price);
		}
		
		$('td.delte_item i').click(function(){
			
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
				$(this).remove(); 
				
				/* set new price for all products */
				totalPrice();
				
				($( ".cart table tbody tr" ).length == 1) ? $( "div.cart" ).html("").append("Корзина пуста."): "";
	
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
	});
	
	/* for opening delivery option on product page */
	$('.delivery_options').click(function(){
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
	$('.paint_options').click(function(){
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

</script>
</body>
</html>