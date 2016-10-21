<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<tr>
	<td>Цена:</td>
	<td>
		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
		<c:if test="${!(product.prise < 0.1)}">						
			<div class="product_price">
				<input name="price_value" value="20000.0" type="hidden">				
			   	<div>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></div>
		    </div>
		</c:if>
	</td>
</tr>