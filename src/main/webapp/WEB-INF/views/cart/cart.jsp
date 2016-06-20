<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Корзина</title>
<style type="text/css">

.cart{
	width: auto;
	margin: 0px 0px 0px 5px;
	font: 15px "RobotoRegular";
}

.cart h2 {
	width: 200px;
	hidth: auto;
	margin: 0 auto;
	color: #006080;
}

.cart table{
	position: relative;
	height: auto;
	width: 100%;
	/*font: 1.3em sans-serif;*/
	top: 0;
	text-align: center;
	/*border: none;*/
	margin-bottom: 15px;
}

.table > thead:first-child > tr:first-child > th{
text-align: center;
vertical-align: middle;
}

.table-bordered > tbody > tr > td{
vertical-align: middle;
padding: 5px;
}

.cart table td{
	height: auto;
	width: auto;

	border: 1px #E7EAED solid;
}

.cart table td.price{
	min-width: 117px;
}

.cart table td.delte_item i {
	color:#006080;
	cursor: pointer;
}

.cart table td.delte_item i:hover {
	color:red;
}

.cart table td:first-child{
	padding:1px;
	height:auto; 
	width:160px;
}

.cart table tr:last-child td{
	border: none;
	font-weight: bold;
	height:auto; 
	width:auto;
}

.cart table td:last-child{
	font-size: 35px;
}

.dec_value,
.inc_value{
	color: #006080;
	cursor: pointer;
}

.dec_value:hover,
.inc_value:hover{
	color: red;
}

.cart table input{
	text-align: center;
	width: 30px;
}

</style>
</head>
<body>
<div class="cart">
<c:if test="${!empty cart.contents}">
	<form action="cart/pleaceOrder" method="post">
	${cartMessage}
	<table class="table table-hover table-striped table-bordered">
		<thead>
			<th><spring:message code="cart.ownpage.picture"/></th>
			<th><spring:message code="cart.ownpage.item"/></th>
			<th><spring:message code="cart.ownpage.quantity"/></th>
			<th><spring:message code="cart.ownpage.price"/></th>
			<th></th>
		</thead>
		<c:forEach var="item" items="${cart.contents}">
		<tr>
			<td><img style="height:auto; width:100%;" src="<%=request.getContextPath()%>/${item.key.picturePath}" alt=""></td>
			<td><c:out value="${item.key.name }"/></td>
			<td>
	
				<input type="hidden" name="type" class="type" value="${item.key.typeProduct}">
				
				<input type="hidden" name="id" class="id" value="${item.key.idProduct}">
	
				<span class="dec_value">
					<i class="fa fa-minus" aria-hidden="true"></i>
				</span>

				<input class="quantity" value="<c:out value="${item.value }"/>"></input>

				<span class="inc_value">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</span>

			</td>
			<td class="price">$ <span>
				<fmt:formatNumber type="number" 
           					maxFractionDigits="2" minFractionDigits="2" value="${item.key.price * item.value }" />
					</span><input type="hidden" name="price_ellement" value="${item.key.price}"></td>
			<td class="delte_item"><i class="fa fa-trash-o" aria-hidden="true"></i></td>
		</tr>
		</c:forEach>
		
		<tr>
			<td><spring:message code="cart.ownpage.total"/>:</td>
			<td></td>
			<td></td>
			<td class="total_price">$ <span><fmt:formatNumber type="number" 
           		maxFractionDigits="2" minFractionDigits="2" value="${cart.totalCost }" /></span></td>
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
/*$( document ).ready(function() {
	var cartDiv = $('div.cart');
	if (typeof(Cookies.get('cart')) == "undefined"){
		cartDiv.append("Корзина пуста, Вы еще не добавляли товары в корзину.");
	} else {
		var cartJSON = new Array(Cookies.getJSON('cart'));
		var table = $('<table/>').addClass('table table-hover table-striped table-bordered');
		table.append($('<thead/>')
				.append($('<th/>').text("Изображение"))
				.append($('<th/>').text("Название"))
				.append($('<th/>').text("Количество"))
				.append($('<th/>').text("Цена"))
				.append($('<th/>'))
			);
		
			
		$.each(Cookies.getJSON('cart'), function( index, product ) {
		  table.append(
				$('<tr/>')
					.append($('<td/>').append($('<img/>').attr("src", product.picturePath)))
					.append($('<td/>').text(product.name))
					.append($('<td/>')
							.append($('<span/>').addClass('dec_value').append($('<i/>').addClass('fa fa-minus')))
							.append($('<input/>').val(product.quantity))
							.append($('<span/>').addClass('inc_value').append($('<i/>').addClass('fa fa-plus'))))	
					.append($('<td/>').addClass('price')
							.text('$ ')
							.append($('<span/>').text(product.price * product.quantity))
							.append($('<input/>').attr("type", "hidden").attr("id", "price_ellement").val(product.price)))
					.append($('<td/>').append($('<a/>')
												.attr("href", "cart/delete/" + product.typeProduct + "/" + product.idProduct)
												.append($('<i/>').addClass('fa fa-trash-o'))))
							
			);
		});
		
		table.append($('<tr/>')
				 .append($('<td/>').text("Общая стоимость"))
				 .append($('<td/>'))
				 .append($('<td/>'))
				 .append($('<td/>').addClass('total_price')
								.text('$ ')
								.append($('<span/>').text("1234567")))
				 .append($('<td/>'))
			);
		
		cartDiv.append(table);
	}
});	
	*/
	$(function(){
		$('.dec_value').click(function(){
            var quantity_element_val = $(this).parent('td').find('input.quantity').val();
			var price_with_quantity =  $(this).parent('td').parent('tr').find('td.price').find('span');
			var price = $(this).parent('td').parent('tr').find('td.price').find('input').val();
			var quantity_numb = new Number(quantity_element_val);
			
			var type = $(this).parent('td').find('input.type').val();
			var id = $(this).parent('td').find('input.id').val();
			
			/*if(quantity_numb==0){
				$(this).css('color','grey');
			} else*/ if (quantity_numb==1) {
				$(this).css('color','grey');
			/*	$(this).parent('td').find('input').val(quantity_numb-1);*/

				$(this).hover(function() {
						$(this).css('color','grey');
					  }, function() {
						$(this).css('color','grey');
					  }
				);

				/*var price_n = new Number(price.replace(/\s/ig, '').replace(",", "."));*/
				/*price_with_quantity.text(checkPrise(price_n * (quantity_numb - 1)));*/
				/* set new price for all products */
				/*totalPrice();*/
			} else {
				$(this).parent('td').find('input.quantity').val(quantity_numb-1);
				var price_n = new Number(price.replace(/\s/ig, '').replace(",", "."));
				price_with_quantity.text(checkPrise(price_n * (quantity_numb - 1)));
				
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
			
			var price_n = new Number(price.replace(/\s/ig, '').replace(",", "."));
			price_with_quantity.text(checkPrise(price_n * (quantity_numb + 1)));
			/* set new price for all products */
			totalPrice();
			
			/* change quantity on server */
			var type = $(this).parent('td').find('input.type').val();
			var id = $(this).parent('td').find('input.id').val();
			changeQuantityProductInCart(type, id, quantity_numb + 1);
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
	});
</script>
</body>
</html>