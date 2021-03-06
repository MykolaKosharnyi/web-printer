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
			   		 		<c:when test="${fn:length(product.pathPictures) > 1}">/images/${product.type}s/${product.id}/${product.pathPictures.get(1)}</c:when>    
			    			<c:otherwise>/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}</c:otherwise>
						</c:choose>
			
						
						" onmouseover="" class="link" href="<c:url value='/${product.type}/${product.id}' />">	
								<div class="outer_a_img"><img src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
					</a>
		
					<div class="name_price_cart_block">
						<c:if test="${product.typeProduct!='Чернила для струйной печати'}">
							<a href="<c:url value='/${product.type}/${product.id}' />" class="products_title">${product.name}</a>
							<div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
								<input type="hidden" name="price_value" value="${product.prise}">
				       			<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
								<c:if test="${!(product.prise < 0.1)}">					
			   						<div>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></div>
								</c:if>
		           			</div>
		           		</c:if>
		           		<c:if test="${product.typeProduct=='Чернила для струйной печати'}">
		           			<a style="white-space: normal; overflow: unset;" href="<c:url value='/${product.type}/${product.id}' />" class="products_title">${product.name}</a>
		           			<p class="products_price"></p>
		           		</c:if>
		
						<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="padding-right: 5px; top: 2px; right: 10px; position: absolute;"
							onclick="addToCart('${product.type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}');"></i>
					</div>	
					
					<div class="name_price_cart_block_hidden">
						<c:if test="${product.type=='printer' && product.ratingOverallRating > 0}">
							<!-- Общая оценка -->
								<div class="rating_block">
									<p style="font-weight: bold;">Общая оценка:</p>
									<div style="width: 100px; float: left;">
										<ul class="rating_average clearfix">
											<li class="current" style="width: ${product.ratingOverallRating * 20}%;"><span class="star1" title="Плохо"></span></li>
											<li><span class="star2" title="Ниже среднего" ></span></li>
											<li><span class="star3" title="Средне" ></span></li>
											<li><span class="star4" title="Хорошо"  ></span></li>
											<li><span class="star5" title="Очень хорошо" ></span></li>
										</ul>
									</div>
								</div>
						</c:if>
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
	   		 		<c:when test="${fn:length(product.pathPictures) > 1}">/images/${product.type}s/${product.id}/${product.pathPictures.get(1)}</c:when>    
	    			<c:otherwise>/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}</c:otherwise>
				</c:choose>
	
				
				" onmouseover="" class="link" href="<c:url value='/${product.type}/${product.id}' />">	
						<div class="outer_a_img"><img src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
				</a>
	
				<div class="name_price_cart_block">
					<c:if test="${product.typeProduct!='Чернила для струйной печати'}">
						<a href="<c:url value='/${product.type}/${product.id}' />" class="products_title">${product.name}</a>
						<div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
							<input type="hidden" name="price_value" value="${product.prise}">
				       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
							<c:if test="${!(product.prise < 0.1)}">					
			   					<div>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></div>
							</c:if>
		           		</div>
	           		</c:if>
	           		<c:if test="${product.typeProduct=='Чернила для струйной печати'}">
	           			<a style="white-space: normal; overflow: unset;" href="<c:url value='/${product.type}/${product.id}' />" class="products_title">${product.name}</a>
	           			<p class="products_price"></p>
	           		</c:if>
	
					<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="padding-right: 5px; top: 2px; right: 10px; position: absolute;"
						onclick="addToCart('${product.type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}');"></i>
				</div>	
				
				<div class="name_price_cart_block_hidden">
					<c:if test="${product.type=='printer' && product.ratingOverallRating > 0}">
						<!-- Общая оценка -->
							<div class="rating_block">
								<p style="font-weight: bold;">Общая оценка:</p>
								<div style="width: 100px; float: left;">
									<ul class="rating_average clearfix">
										<li class="current" style="width: ${product.ratingOverallRating * 20}%;"><span class="star1" title="Плохо"></span></li>
										<li><span class="star2" title="Ниже среднего" ></span></li>
										<li><span class="star3" title="Средне" ></span></li>
										<li><span class="star4" title="Хорошо"  ></span></li>
										<li><span class="star5" title="Очень хорошо" ></span></li>
									</ul>
								</div>
							</div>
					</c:if>
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
		name_and_price_block.outerHeight(name_and_price_block.find('a.products_title').outerHeight(true) + name_and_price_block.find('.product_price').outerHeight(true) + 15);
		name_and_price_block.css('min-height','54px');
	});
	
	$("#top_result_of_search, #out_result_of_search").on('mouseleave', '.products', function() {
		var name_and_price_block = $(this).find('.name_price_cart_block');
		name_and_price_block.outerHeight(54);
	});
});

</script>