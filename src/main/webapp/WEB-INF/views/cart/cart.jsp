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

.cart .option_product_car{
	height:auto;
	width: 100%;
}
.cart .option_product_car label{
	margin-bottom: 0px;
	font-weight: unset;
	/*min-width: 240px;*/
}


label.add_price_title,.option_product_car label.total_ptice_title{min-width: 200px;}
label.add_price_title{height: auto; max-width: 200px;}

.option_product_car label.total_ptice_title,
.option_product_car label.total_price{
/*min-width: 155px;*/
margin:10px 0px;
text-align: right;
}

.option_product_car .block_product_price{
	padding: 2px;
	height:auto;
}

.option_product_car .block_product_price input,
.option_product_car .block_product_price label{
top: 0px;
position: relative;
}


.option_product_car input[type="checkbox"].add_price{
	margin-left: 5px;
}

.option_product_car .option_description{
height: auto;
width: 215px;
}

.option_product_car label.add_price_value{
	min-width: 60px;
}

.option_product_car label.total_ptice_title{
margin-left: 25px;
padding: 5px;
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
			<th><spring:message code="cart.ownpage.option"/></th>
			<th><spring:message code="cart.ownpage.quantity"/></th>
			<th><spring:message code="cart.ownpage.price"/></th>
			<th></th>
		</thead>
		<c:forEach var="item" items="${cart.contents}">
		<tr>
			<td><img style="height:auto; width:100%;" src="<%=request.getContextPath()%>/${item.key.picturePath}" alt=""></td>
			<td><c:out value="${item.key.name }"/></td>
			<td>
				
				
				<div class="option_product_car">
                 	
	<c:if test="${item.key.optionRIP > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Програмное обеспечение" id="optionRIP_price">
				<label class="add_price_title" for="optionRIP_price">Програмное обеспечение:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${item.key.optionRIP}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionRIP}</label>
		</div>
	</c:if>
                 		
	<c:if test="${item.key.optionSNCP > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="СНЧП" id="optionSNCP_price">
				<label class="add_price_title" for="optionSNCP_price">СНЧП:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${item.key.optionSNCP}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionSNCP}</label>
		</div>
	</c:if>
     
    <c:if test="${item.key.optionVAT > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="НДС" id="optionVAT_price">
				<label class="add_price_title" for="optionVAT_price">НДС:</label>
			</input>
			<label class="add_price_value"><span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${item.key.optionVAT}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionVAT}</label>
		</div>
	</c:if>
                 		
	<c:if test="${item.key.optionDelivery > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Доставка" id="optionDelivery_price">
				<label class="add_price_title" for="optionDelivery_price">Доставка:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${item.key.optionDelivery}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionDelivery}</label>
		</div>
	</c:if>
	
	<c:if test="${item.key.optionInstallation > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Инсталяция" id="optionInstallation_price">
				<label class="add_price_title" for="optionInstallation_price">Инсталяция:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${item.key.optionInstallation}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionInstallation}</label>
		</div>
	</c:if>
                 		
	<c:if test="${item.key.priceAddedOption > 0.01 && (item.key.nameAddedOption!=null && item.key.nameAddedOption!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${item.key.nameAddedOption}" id="priceAddedOption_price">
				<label class="add_price_title" for="priceAddedOption_price">${item.key.nameAddedOption}:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${item.key.priceAddedOption}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionAddedOption}</label>
		</div>
	</c:if>
	
	<c:if test="${item.key.priceAddedOption2 > 0.01 && (item.key.nameAddedOption2!=null && item.key.nameAddedOption2!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${item.key.nameAddedOption2}" id="priceAddedOption2_price">
				<label class="add_price_title" for="priceAddedOption2_price">${item.key.nameAddedOption2}:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${item.key.priceAddedOption2}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionAddedOption2}</label>
		</div>
	</c:if>
	
	<c:if test="${item.key.priceAddedOption3 > 0.01 && (item.key.nameAddedOption3!=null && item.key.nameAddedOption3!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${item.key.nameAddedOption3}" id="priceAddedOption3_price">
				<label class="add_price_title" for="priceAddedOption3_price">${item.key.nameAddedOption3}:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${item.key.priceAddedOption3}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionAddedOption3}</label>
		</div>
	</c:if>
                 		
	<c:if test="${item.key.optionGuarantee > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Гарантия" id="optionGuarantee_price">
				<label class="add_price_title" for="optionGuarantee_price">Гарантия:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${item.key.optionGuarantee}" /></span>
			</label>
			<label class="option_description">${item.key.descriptionOptionGuarantee}</label>
		</div>
	</c:if>
				
				
				
				
				
				
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
	});

$(document).ready(function() {
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
	        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
	            e.preventDefault();
	        }
	    });
	});
</script>
</body>
</html>