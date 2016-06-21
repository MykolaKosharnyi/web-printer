<%@ attribute name="type" required="true" %>
<%@ attribute name="arrayOfProduct" required="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="col-md-9 col-lg-9">
	<div class="row">
		<div class="sider_container">
			<div class="next_button_${type}"><i class="fa fa-angle-right"></i></div>
			<div class="pause_button_${type}" style="display: none;"><i class="fa fa-pause" aria-hidden="true"></i></div>
			<div class="play_button_${type}"><i class="fa fa-play" aria-hidden="true"></i></div>
			<div class="prev_button_${type}"><i class="fa fa-angle-left"></i></div>
			<div class="carousel_${type}">
				<c:forEach items="${arrayOfProduct}" var="product">
					<div class="slide-item1">
						<a class="slider_image" href="<c:url value='/${type}/${product.id}' />">
							<div class="outer_a_img">
								<img src="/images/${type}s/${product.id}/${product.pathPictures.get(0)}" alt="" />
							</div>
						</a>
						<a class="slide-buy1" href="javascript:void(0)" onclick="addToCart('${type}', ${product.id}, '${product.name}', '${product.prise}','${product.pathPictures.get(0)}');">
							<img src="/images/button_buy.png" alt="" />
						</a>
						<a href="<c:url value='/${type}/${product.id}' />" class="slide-title1">${product.name}</a>
						<div class="slide-price1">Цена: 
						
                        <c:if test="${product.prise < 0.1}"> уточняйте</c:if>
                        
                    	<c:if test="${!(product.prise < 0.1)}">         
                       		$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
                    	</c:if>
                    	
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>