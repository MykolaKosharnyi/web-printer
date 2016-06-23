<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="out_result_of_search">
	<c:forEach items="${listProducts}" var="product">
		<div class="products">
			<a id="
			
			<c:choose>
   		 		<c:when test="${fn:length(product.pathPictures) > 1}">/images/${type}s/${product.id}/${product.pathPictures.get(1)}</c:when>    
    			<c:otherwise>/images/${type}s/${product.id}/${product.pathPictures.get(0)}</c:otherwise>
			</c:choose>

			
			" onmouseover="" class="link" href="<c:url value='/${type}/${product.id}' />">	
					<div class="outer_a_img"><img src="/images/${type}s/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
			</a>


			<a href="<c:url value='/${type}/${product.id}' />" class="products_title">${product.name}</a>
			<p class="products_price">Цена: 
           		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
				<c:if test="${!(product.prise < 0.1)}">					
   					$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
				</c:if>
           	</p>

			<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
			onclick="addToCart('${type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}');"></i>
			
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

	<div class="hidden">
		<form id="callback" class="pop_form">
			<h5 style="max-width: 300px;">Пожалуйста оставьте координаты, через некоторое время мы с вами свяжемся</h5>
			<input type="hidden" name="id" value="${product.id}">
			<input type="hidden" name="typeProduct" value="${product.id}">
			<input type="text" name="name" placeholder="Ваше имя..." required />
			<input type="text" name="phone" placeholder="Ваше телефон..." required />
			<button class="button" type="submit">Уточнить</button>
		</form>
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