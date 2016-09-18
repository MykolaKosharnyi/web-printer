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
					<p><span>Целевое назначение:</span> ${uwProduct.typeProduct}</p>
					<c:if test="${uwProduct.typeProduct!='Чернила для струйной печати'}">
						<p><span>Цена:</span>
							
							<c:if test="${uwProduct.prise < 0.1}"> уточняйте</c:if>
							<c:if test="${!(uwProduct.prise < 0.1)}">					
								   					$<fmt:formatNumber type="number" maxFractionDigits="2"
									minFractionDigits="2" value="${uwProduct.prise}" />
							</c:if>
						</p>
					</c:if>
					<i style="right:0px; float: right;" class="fa fa-cart-plus add_to_cart" aria-hidden="true" onclick="addToCart('use_with_product', ${uwProduct.id}, '${uwProduct.name}', '${uwProduct.prise}', '${uwProduct.pathPictures.get(0)}');"></i>
				</div>
				
			</div>
		</c:forEach>
	 </c:if>
	 
	<!--  <c:if test="${empty uwp}">С этим продуктом нету используемых товаров.</c:if>	 -->
</div>