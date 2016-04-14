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
	width: 900px;
	margin: 0 auto;
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
                font: 1em sans-serif;
                top: 0;
                float: left;
                border: none;
                margin-bottom: 15px;
}

.cart table td{
		padding-left: 5px;
            	padding-top: 5px;
            	padding-bottom: 5px;
                height: auto;
                width: auto;
                text-align: center;
                top: 0;
                border: 1px #E7EAED solid;
}


.cart table td:first-child{
	padding:0px;
	height:80px; 
	width:80px;
}

.cart table tr:last-child td{
	border: none;
	font-weight: bold;
	height:auto; 
	width:auto;
}

</style>
</head>
<body>
<div class="cart">
	<form action="cart/pleaceOrder" method="post">
	${cartMessage}
	<table class="table">
		<tr>
			<th><spring:message code="cart.ownpage.picture"/></th>
			<th><spring:message code="cart.ownpage.item"/></th>
			<th><spring:message code="cart.ownpage.typeproduct"/></th>
			<th><spring:message code="cart.ownpage.partnumber"/></th>
			<th><spring:message code="cart.ownpage.quantity"/></th>
			<th><spring:message code="cart.ownpage.price"/></th>
			<th></th>
		</tr>
		<c:forEach var="item" items="${cart.contents}">
		<tr>
			<td><img style="height:80px; width:80px;" src="<%=request.getContextPath()%>/images/${item.key.picturePath}" alt=""></td>
			<td><c:out value="${item.key.name }"/></td>
			<td><c:out value="${item.key.typeProduct }"/></td>
			<td><c:out value="${item.key.partNumber }"/></td>
			<td><c:out value="${item.value }"/></td>
			<td>$ <fmt:formatNumber type="number" 
           		maxFractionDigits="2" minFractionDigits="2" value="${item.key.prise * item.value }" /></td>
			<td><a href="cart/delete/${item.key.partNumber }"><spring:message code="cart.ownpage.delete"/></a></td>
		</tr>
		</c:forEach>
		
		<tr></tr>
		<tr>
			<td><spring:message code="cart.ownpage.total"/>:</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>$ <fmt:formatNumber type="number" 
           		maxFractionDigits="2" minFractionDigits="2" value="${cart.totalCost }" /></td>
		</tr>
	</table>
	<input type="submit" value="<spring:message code="cart.ownpage.placeorder"/>"></input>
	</form>
</div>
</body>
</html>