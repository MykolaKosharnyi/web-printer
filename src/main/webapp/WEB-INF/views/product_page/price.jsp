<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

<tr>
	<td><custom:getDescriptionByLocale description="${descriptions.price}"/></td>
	<td>
		<c:if test="${product.prise < 0.1}"><a href="javascript:openModalProposalPrise('${type}', ${product.id}, '${product.name}', '${product.pathPictures.get(0)}')">
		<custom:getDescriptionByLocale description="${descriptions.specify}"/></a></c:if>
		<c:if test="${!(product.prise < 0.1)}">						
			<div class="product_price">
				<input name="price_value" value="${product.prise}" type="hidden">				
			   	<div></div>
		    </div>
		</c:if>
	</td>
</tr>