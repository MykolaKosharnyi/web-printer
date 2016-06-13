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
			<td>$ <fmt:formatNumber type="number" 
           		maxFractionDigits="2" minFractionDigits="2" value="${item.key.prise * item.value }" /></td>
			<td><a href="cart/delete/${item.key.partNumber }"><i class="fa fa-trash-o" aria-hidden="true"></i></a></td>
		</tr>
		</c:forEach>
		
		<tr></tr>
		<tr>
			<td><spring:message code="cart.ownpage.total"/>:</td>
			<td></td>
			<td></td>
			<td>$ <fmt:formatNumber type="number" 
           		maxFractionDigits="2" minFractionDigits="2" value="${cart.totalCost }" /></td>
			<td></td>
		</tr>
	</table>
	<input type="submit" value="<spring:message code="cart.ownpage.placeorder"/>"></input>
	</form>
</div>

<script type="text/javascript">
	
	$(function(){
		$('.cart table .dec_value').click(function(){
            var price_element = $(this).parent('td').find('input').val();
			var element = new Number(price_element);
			if(element!=0){
				$(this).parent('td').find('input').val(element-1);
				$(this).css('color','grey');
			}
 
        });
		
		$('.inc_value').click(function(){

			var price_element = $(this).parent('td').find('input').val();
			var element = new Number(price_element);
            $(this).parent('td').find('input').val(element+1);
/*
            var current_count = $(this).parent('.block_product_price').parent('.option_product_with_price').find('label.total_price span');
			var currentPrice = new Number(price_element.text().replace(/\s/ig, '').replace(",", "."));
            var change_style = $(this).parent('.block_product_price');
            var value_add_price = $(this).parent('.block_product_price').find('label.add_price_value span').text();
			var addPrice = new Number(value_add_price.replace(/\s/ig, '').replace(",", "."));

            if ($(this).prop( "checked" )) {
            	change_style.css('color', '#006080');

				price_element.text(checkPrise(currentPrice+addPrice));
            }else{
            	change_style.css('color', '#333');
				price_element.text(checkPrise(currentPrice-addPrice));
            }
          */  
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
	});
</script>
</body>
</html>