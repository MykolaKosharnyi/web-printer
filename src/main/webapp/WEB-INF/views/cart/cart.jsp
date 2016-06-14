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
			<td><img style="height:auto; width:inherit;" src="<%=request.getContextPath()%>/images/${item.key.picturePath}" alt=""></td>
			<td><c:out value="${item.key.name }"/></td>
			<td>

				<span class="dec_value">
					<i class="fa fa-minus" aria-hidden="true"></i>
				</span>

				<input value="<c:out value="${item.value }"/>"></input>

				<span class="inc_value">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</span>

			</td>
			<td class="price">$ <span>
						<fmt:formatNumber type="number" 
           					maxFractionDigits="2" minFractionDigits="2" value="${item.key.prise * item.value }" />
					</span><input type="hidden" name="price_ellement" value="${item.key.prise}"></td>
			<td><a href="cart/delete/${item.key.partNumber }"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
		</tr>
		</c:forEach>
		
		<tr></tr>
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
	
	$(function(){
		$('.dec_value').click(function(){
            var quantity_element_val = $(this).parent('td').find('input').val();
			var price_with_quantity =  $(this).parent('td').parent('tr').find('td.price').find('span');
			var price = $(this).parent('td').parent('tr').find('td.price').find('input').val();
			var quantity_numb = new Number(quantity_element_val);
			var total_price = $('tr td.total_price span' );
			if(quantity_numb==0){
				$(this).css('color','grey');
			} else if (quantity_numb==1) {
				$(this).css('color','grey');
				$(this).parent('td').find('input').val(quantity_numb-1);

				$(this).hover(function() {
						$(this).css('color','grey');
					  }, function() {
						$(this).css('color','grey');
					  }
				);

				var price_n = new Number(price.replace(/\s/ig, '').replace(",", "."));
				price_with_quantity.text(checkPrise(price_n * (quantity_numb - 1)));
				total_price.text(allPrice());
			} else {
				$(this).parent('td').find('input').val(quantity_numb-1);
				var price_n = new Number(price.replace(/\s/ig, '').replace(",", "."));
				price_with_quantity.text(checkPrise(price_n * (quantity_numb - 1)));
				total_price.text(allPrice());
			}
 			
        });
		
		$('.inc_value').click(function(){

			var quantity_element_val = $(this).parent('td').find('input').val();
			var quantity_numb = new Number(quantity_element_val);

			var price_with_quantity = $(this).parent('td').parent('tr').find('td.price').find('span');
			var price = $(this).parent('td').parent('tr').find('td.price').find('input').val();
			var total_price = $('tr td.total_price span' );
			if(quantity_numb==0){
				var dec_v = $(this).parent('td').find('.dec_value');
				dec_v.css('color','#006080');
				dec_v.hover(function() {
						$(this).css('color','red');
					  }, function() {
						$(this).css('color','#006080');
					  }
				);
			} 

            $(this).parent('td').find('input').val(quantity_numb+1);
			
			var price_n = new Number(price.replace(/\s/ig, '').replace(",", "."));
			price_with_quantity.text(checkPrise(price_n * (quantity_numb + 1)));
 			total_price.text(allPrice());
        });
		
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

		function allPrice(){
			var total_price = new Number();
			$('td.price span').each(function(i, price_el){
				total_price += new Number($(price_el).text().replace(/\s/ig, '').replace(",", "."));
			});	
			return checkPrise(total_price);
		}
	});
</script>
</body>
</html>