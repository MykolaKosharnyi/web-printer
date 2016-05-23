<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div>
	<c:if test="${!empty uwp}">			  
		<c:forEach items="${uwp}" var="uwProduct">
			<div class="use_with_product">

				<a class="link" href="<c:url value='/use_with_product/${uwProduct.id}' />">
					<img src="/images/use_with_products/${uwProduct.id}/${uwProduct.pathPictures[0]}"alt="">
				</a>

				<div class="infrotamaton_about_uwp">
					<a href="<c:url value='/use_with_product/${uwProduct.id}' />">${uwProduct.name}</a>
					<p><span>Предназначение:</span> ${uwProduct.typeProduct}</p>
					<p><span>Цена:</span>
						
						<c:if test="${uwProduct.prise < 0.1}"> уточняйте</c:if>
						<c:if test="${!(uwProduct.prise < 0.1)}">					
							   					$<fmt:formatNumber type="number" maxFractionDigits="2"
								minFractionDigits="2" value="${uwProduct.prise}" />
						</c:if>
					</p>
					
				</div>
				<a href="javascript:void(0)" onclick="addToCart('use_with_product', ${uwProduct.id});" class="button fancybox">Добавить в корзину</a>
			</div>
		</c:forEach>
	 </c:if>
	 
	 <c:if test="${empty uwp}">С этим продуктом нету используемых товаров.</c:if>	
</div>