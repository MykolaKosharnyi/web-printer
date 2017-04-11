<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div id="reklam">
		
		<c:forEach items="${reklam}" var="value">  
			<div class="slide-item">
				<a href="/${value.type}/${value.id}" class="slider_image">
					<div class="outer_a_img">
						<img src='/images/${value.type}s/${value.id}/${value.pathToPicture}'>
					</div>
				</a>
				<div class="block_title_and_price">
					<a href="/${value.type}/${value.id}" class="slide-title">${value.nameProduct}</a>
					
					<div class="product_price">
			    		<span style="float:left; margin-right: 5px;">Цена:</span>
			    		<c:if test="${value.priceProduct < 0.1}">
			    			<a href="#callback_reklam" class="fancybox">уточняйте</a>
			    		</c:if>
			    		<c:if test="${value.priceProduct >= 0.1}">
			    			<input type="hidden" value="${value.priceProduct}">
			    			<div></div>
			    		</c:if>
		    		</div> 
		    		
		    		<a class="reklam_add_to_cart"
		    		 onclick="addToCart('${ value.type}', '${value.id}', '${value.nameProduct}', '${value.priceProduct}', '${value.pathToPicture}');"
		    		 >Добавить в корзину</a>
				</div>
				
				<c:if test="${!empty value.leftSharesLink}">
					<div class="ribbon-wrapper-left" style="color:${value.leftSharesLinkColorText}; background:${value.leftSharesLinkColorFone};">
						<div class="ribbon-left">
							${value.leftSharesLink}
						</div>
					</div>
				</c:if>
					
				<c:if test="${!empty value.rightSharesLink}">
					<div class="ribbon-wrapper-right" style="color:${value.rightSharesLinkColorText}; background:${value.rightSharesLinkColorFone};">
						<div class="ribbon-right">
							${value.rightSharesLink}
						</div>
					</div>
				</c:if>
				
			</div>
	    	 
		</c:forEach>   
		
	</div>