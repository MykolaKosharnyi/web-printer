<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${!empty product.availability && empty product.availabilitySpecialCase}">
	<div class="commom_information"><em>Наличие:</em><p class="value_of_availability"
		<c:choose>
			<c:when test="${product.availability.equals('в наличии')}">style="background: #05f94c; border: 1px #7cc80f solid; width: 96px;"</c:when>
			<c:when test="${product.availability.equals('нет в наличии')}">style="background: rgb(231, 231, 231); border: 1px solid rgb(180, 180, 180);"</c:when>
			<c:when test="${product.availability.equals('заканчивается')}">style="background: rgb(255, 230, 92); border: 1px solid rgb(215, 215, 215);"</c:when>
			<c:when test="${product.availability.equals('под заказ')}">style="background: rgb(9, 191, 252); border: 1px solid rgb(17, 155, 130);"</c:when>
			<c:when test="${product.availability.equals('ожидается')}">style="background: rgb(255, 230, 92); border: 1px solid rgb(215, 215, 215);"</c:when>
		</c:choose>
	> ${product.availability}</p></div>
</c:if>
                 
<c:if test="${!empty product.availabilitySpecialCase}">
	<div class="commom_information"><em>Наличие:</em><p style="padding-top: 10px;"> ${product.availabilitySpecialCase}</p></div>
</c:if>




