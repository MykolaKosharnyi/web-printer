<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div id="top_result_of_search">
	<c:forEach items="${listProducts}" var="product">
		<c:if test="${product.top}">
			<div class="products">
				<div class="inner_div_product">
					<a id="
					
						<c:choose>
			   		 		<c:when test="${fn:length(product.pathPictures) > 1}">/images/${type}s/${product.id}/${product.pathPictures.get(1)}</c:when>    
			    			<c:otherwise>/images/${type}s/${product.id}/${product.pathPictures.get(0)}</c:otherwise>
						</c:choose>
			
						
						" onmouseover="" class="link" href="<c:url value='/${type}/${product.id}' />">	
								<div class="outer_a_img"><img src="/images/${type}s/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
					</a>
		
					<div class="name_price_cart_block">
						<a href="<c:url value='/${type}/${product.id}' />" class="products_title">${product.name}</a>
						<p class="products_price">Цена: 
				       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
							<c:if test="${!(product.prise < 0.1)}">					
			   					$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
							</c:if>
		           		</p>
		
						<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="padding-right: 5px; top: 5px; right: 10px; position: absolute;"
							onclick="addToCart('${type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}');"></i>
					</div>	
					
					<div class="name_price_cart_block_hidden">

					</div>	
		
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
			</div>
		</c:if>
	</c:forEach>
</div>

<div id="out_result_of_search">
	<c:forEach items="${listProducts}" var="product">
		<c:if test="${!product.top}">
		<div class="products">
			<div class="inner_div_product">
				<a id="
				
				<c:choose>
	   		 		<c:when test="${fn:length(product.pathPictures) > 1}">/images/${type}s/${product.id}/${product.pathPictures.get(1)}</c:when>    
	    			<c:otherwise>/images/${type}s/${product.id}/${product.pathPictures.get(0)}</c:otherwise>
				</c:choose>
	
				
				" onmouseover="" class="link" href="<c:url value='/${type}/${product.id}' />">	
						<div class="outer_a_img"><img src="/images/${type}s/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
				</a>
	
				<div class="name_price_cart_block">
					<a href="<c:url value='/${type}/${product.id}' />" class="products_title">${product.name}</a>
					<p class="products_price">Цена: 
			       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
						<c:if test="${!(product.prise < 0.1)}">					
		   					$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
						</c:if>
	           		</p>
	
					<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="padding-right: 5px; top: 5px; right: 10px; position: absolute;"
						onclick="addToCart('${type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}');"></i>
				</div>	
				
				<div class="name_price_cart_block_hidden">
	
				</div>	
	
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
		</div>
		</c:if>
	</c:forEach>
</div>

<script type="text/javascript">
jQuery(document).ready(function($) {
	var topResult = $('#top_result_of_search');
	topResult.height( Math.ceil(topResult.find('.products').length/3 ) * (topResult.find('.products').first().height() + 6 ));
}); // ready()

$(function(){
	/* for changing background picture */
	$("#top_result_of_search, #out_result_of_search").on('mouseenter', '.products a.link', function() {
		var currImg = $(this).find('img').attr('src');
	  	var needImg = $(this).attr('id');
	  
	  $(this).find('img')
		.attr('src', needImg);
	  $(this).attr('id', currImg);
	});
	
	$("#top_result_of_search, #out_result_of_search").on('mouseleave', '.products a.link', function() {
		var currImg = $(this).find('img').attr('src');
	   	var needImg = $(this).attr('id');
		  
	   $(this).find('img')
		 .attr('src', needImg);
	   $(this).attr('id', currImg);
	});
	
	/* for changing height of name and price after hovering on product field */
	$("#top_result_of_search, #out_result_of_search").on('mouseenter', '.products', function() {
		var name_and_price_block = $(this).find('.name_price_cart_block');
		name_and_price_block.outerHeight(name_and_price_block.find('a.products_title').outerHeight(true) + name_and_price_block.find('p.products_price').outerHeight(true) + 15);
		name_and_price_block.css('min-height','60px');
	});
	
	$("#top_result_of_search, #out_result_of_search").on('mouseleave', '.products', function() {
		var name_and_price_block = $(this).find('.name_price_cart_block');
		name_and_price_block.outerHeight(60);
	});
});

</script>