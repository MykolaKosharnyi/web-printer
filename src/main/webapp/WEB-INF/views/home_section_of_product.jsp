<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-md-9 col-lg-9">
	<div class="row">
		<div class="sider_container">
			<div class="next_button_${param.type}"><i class="fa fa-angle-right"></i></div>
			<div class="pause_button_${param.type}" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			<div class="play_button_${param.type}"><i class="fa fa-play" aria-hidden="true"></i></div>
			<div class="prev_button_${param.type}"><i class="fa fa-angle-left"></i></div>
			<div class="carousel_${param.type}">
				<c:forEach items="${param.arrayOfProduct}" var="product">
					<div class="slide-item">
						<a class="slider_image" href="<c:url value='/${param.type}/${param.product.id}' />">
							<div class="outer_a_img"><img src="/images/${param.type}s/${param.product.id}/${param.product.pathPictures.get(0)}" alt="" /></div>
						</a>
                                                                    
						<div class="name_price_cart_block">                                               
							<a href="<c:url value='/${param.type}/${param.product.id}' />" class="slide-title">${param.product.name}</a>         
                                                                    
							<div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
								<input type="hidden" name="price_value" value="${param.product.prise}">
							    <c:if test="${param.product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
								<c:if test="${!(param.product.prise < 0.1)}">					
						   			<div></div>
								</c:if>
							</div>
					           		 
					        <i class="fa fa-cart-plus add_to_cart" aria-hidden="true" 
					           	style="padding-right: 5px; top: 3px; right: 5px; position: absolute; font-size: 40px;"
							onclick="addToCart('${param.type}', ${param.product.id}, '${param.product.name}', '${param.product.prise}','${param.product.pathPictures.get(0)}');"></i>					
						</div>

					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>