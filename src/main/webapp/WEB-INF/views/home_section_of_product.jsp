<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>

<div class="col-md-9 col-lg-9">
	<div class="row">
		<div class="sider_container">
			<div class="next_button_${param.type}"><i class="fa fa-angle-right"></i></div>
			<div class="pause_button_${param.type}" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			<div class="play_button_${param.type}"><i class="fa fa-play" aria-hidden="true"></i></div>
			<div class="prev_button_${param.type}"><i class="fa fa-angle-left"></i></div>
			<div class="carousel_${param.type}">

				
	<c:choose>   
         <c:when test = "${param.type == 'printer'}">
            <c:set value="${printers}" var="products" />
         </c:when>
         
         <c:when test = "${param.type == '3d_printer'}">
            <c:set value="${printers3D}" var="products" />
         </c:when>

		 <c:when test = "${param.type == 'digital_printer'}">
            <c:set value="${digitalPrinters}" var="products" />
         </c:when>

		 <c:when test = "${param.type == 'laminator'}">
            <c:set value="${laminators}" var="products" />
         </c:when>

		 <c:when test = "${param.type == 'laser'}">
            <c:set value="${lasers}" var="products" />
         </c:when>

		 <c:when test = "${param.type == 'cutter'}">
            <c:set value="${cutters}" var="products" />
         </c:when>

		 <c:when test = "${param.type == 'scanner'}">
            <c:set value="${scanners}" var="products" />
         </c:when>

		 <c:when test = "${param.type == 'rip'}">
            <c:set value="${rips}" var="products" />
         </c:when>

	</c:choose>

				<c:forEach items="${products}" var="product">
					<div class="slide-item">
						<a class="slider_image" href="<c:url value='/${param.type}/${product.id}' />">
							<div class="outer_a_img"><img src="/images/${param.type}s/${product.id}/${product.pathPictures.get(0)}" alt="" /></div>
						</a>
                                                                    
						<div class="name_price_cart_block">                                               
							<a href="<c:url value='/${param.type}/${product.id}' />" class="slide-title">${product.name}</a>         
                                                                    
							<div class="product_price"><span style="float: left; margin-right: 5px;"><custom:getDescriptionByLocale description="${descriptions.price}"/></span> 
								<input type="hidden" name="price_value" value="${product.prise}">
							    <c:if test="${product.prise < 0.1}">
							    	<a href="#callback" class="fancybox"><custom:getDescriptionByLocale description="${descriptions.specify}"/></a></c:if>
								<c:if test="${!(product.prise < 0.1)}">					
						   			<div></div>
								</c:if>
							</div>
					           		 
					        <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
							onclick="addToCart('${param.type}', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');"></i>					
						</div>

					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>