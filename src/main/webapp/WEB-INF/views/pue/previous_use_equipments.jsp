<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div id="out_result_of_search">
	<c:forEach items="${listProducts}" var="product">
		<div class="products">
			<a id="/images/${product.type}s/${product.id}/${product.pathPictures.get(1)}" class="link" href="<c:url value='/${product.type}/${product.id}' />">	
					<div class="outer_a_img"><img src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
			</a>
			<a href="javascript:void(0)" onclick="addToCart(${product.type}, ${product.id});" class="products_buy">
				<img src="/images/button_buy.png" alt="" />
			</a>
			<a href="<c:url value='/${product.type}/${product.id}' />" class="products_title">${product.name}</a>
			<p class="products_price">Цена: 
           		<c:if test="${product.prise < 0.1}"> уточняйте</c:if>
				<c:if test="${!(product.prise < 0.1)}">					
   					$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
				</c:if>
           	</p>
			
			<c:if test="${!empty product.leftSharesLink}">
				<div class="ribbon-search-wrapper-left">
					<div class="ribbon-search-left" style="color:${product.leftSharesLinkColorText}; background:${product.leftSharesLinkColorFone};">
						${product.leftSharesLink}
					</div>
				</div>
			</c:if>
			
			<c:if test="${!empty product.rightSharesLink}">
				<div class="ribbon-search-wrapper-right">
					<div class="ribbon-search-right" style="color:${product.rightSharesLinkColorText}; background:${product.rightSharesLinkColorFone};">
						${product.rightSharesLink}
					</div>
				</div>
			</c:if>
			
		</div>
	</c:forEach>
</div>
<script type="text/javascript">

$(function(){
	$("#out_result_of_search").on('mouseenter', '.products a.link', function() {
		var currImg = $(this).find('img').attr('src');
	  	var needImg = $(this).attr('id');
	  
	  $(this).find('img')
		.attr('src', needImg);
	  $(this).attr('id', currImg);
	});
	
	$("#out_result_of_search").on('mouseleave', '.products a.link', function() {
		var currImg = $(this).find('img').attr('src');
	   	var needImg = $(this).attr('id');
		  
	   $(this).find('img')
		 .attr('src', needImg);
	   $(this).attr('id', currImg);
	});
});

</script>