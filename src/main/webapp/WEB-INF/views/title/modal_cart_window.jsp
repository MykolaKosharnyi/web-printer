<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="myModal" class="modal fade">
    <div class="modal-dialog" style="width:1050px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Корзина</h4>
            </div>
            <div class="modal-body" style="padding: 5px 5px 0px 5px;">
                <div id="cart">
<c:if test="${!empty cart.contents}">
	
    <input type="checkbox" id="button_set_price_online" style="top: 3px; position: relative;">
    <label style="color: lightseagreen;" for="button_set_price_online">показать цену при кокупке онлайн</label> 
                
	<form action="cart/pleaceOrder" method="post">
	<table class="table table-hover table-striped table-bordered table_option">
		<thead>
			<th><spring:message code="cart.ownpage.picture"/></th>
			<th><spring:message code="cart.ownpage.item"/></th>
			<th><spring:message code="cart.ownpage.option"/></th>
			<th><spring:message code="cart.ownpage.quantity"/></th>
			<th><spring:message code="cart.ownpage.price"/></th>
			<th></th>
		</thead>
		<c:forEach var="item" items="${cart.contents}">
		<tr class="content_cart_item">
			<td style="width: 220px;">
				<a href="<c:url value='/${item.key.typeProduct}/${item.key.idProduct}' />">
					<img style="height:auto; width:100%;" src="<%=request.getContextPath()%>/${item.key.picturePath}" alt="">
				</a>
			</td>
			<td style="max-width: 235px;"><a style="color:black;" href="<c:url value='/${item.key.typeProduct}/${item.key.idProduct}' />">${item.key.name }</a></td>
			<td style="padding: 0px; width:390px;" class="option_product_car">
				
				<table class="table table-hover" style="width:inherit;">
				
					<c:forEach items="${item.key.options}" var="option">
						<c:if test="${option.price > 0.01}">
							<tr class="block_product_price">
								<c:if test="${option.name!='НДС'}">
									<td colspan="2">
										<input class="add_price" type="checkbox" value="${option.name}" 
											id="${option.name}_${item.key.typeProduct}_${item.key.idProduct}"
											<c:if test="${option.checked}">checked</c:if>>
										<label class="add_price_title"
												 for="${option.name}_${item.key.typeProduct}_${item.key.idProduct}">${option.name}</label>
									</td>
									<td>
										<div class="product_price">
											<input name="price_value" value="${option.price}" type="hidden">			
										   	<div></div>
									    </div>
									</td>
									<%-- <label class="option_description">${option.description}</label>--%>
								</c:if>
								
								<c:if test="${option.name=='НДС'}">
									<td colspan="3" style="padding: 8px 0px;">
										<input class="add_price" type="checkbox" value="${option.name}" 
											id="${option.name}_${item.key.typeProduct}_${item.key.idProduct}"
											<c:if test="${option.checked}">checked</c:if>>
										<label class="add_price_title"
												 for="${option.name}_${item.key.typeProduct}_${item.key.idProduct}">${option.name}</label>
									</td>
									<td style="display:none;">
										<div class="product_price">
											<input name="price_value" value="${option.price}" type="hidden">				
										   	<div></div>
									    </div>
									</td>
									<%-- <label class="option_description">${option.description}</label>--%>
								</c:if>
							</tr>
						</c:if>
					</c:forEach>		
					
					<c:if test="${fn:length(item.key.deliveries) > 0}">
						<tr class="delivery_options">
							<td colspan="3">
								<i class="fa fa-arrow-right"></i>
								<p class="delivery_options_title">Доставка</p>
							</td>
						</tr>
						
						<input type="hidden" name="delivery_radio_name" class="delivery_radio_name" value="">
						<input type="hidden" name="delivery_radio_value" class="delivery_radio_value" value="0">
						
					</c:if>
					
					<c:forEach items="${item.key.deliveries}" var="delivery">
						<c:if test="${((delivery.priceSize > 0) || (delivery.priceWeight > 0)) &&
									((delivery.name!=null) && (delivery.name!=''))}">
							<tr class="block_product_price delivery_options_body">
								<td colspan="2">
									<input class="add_price_delivery" type="radio" name="delivery" value="${delivery.name}" 
										id="${delivery.name}_${item.key.typeProduct}_${item.key.idProduct}_delivery"
										<c:if test="${delivery.checked}">checked</c:if>>
									<label class="add_price_title"
											 for="${delivery.name}_${item.key.typeProduct}_${item.key.idProduct}_delivery">${delivery.name}</label>
								</td>
								<td>
									<div class="product_price">
										<input name="price_value" value="${delivery.priceSize + delivery.priceWeight}" type="hidden">			
										<div></div>
									</div>
								</td>
							</tr>
						</c:if>
					</c:forEach>	
					
					<c:if test="${fn:length(item.key.paints) > 0}">
						<tr class="paint_options">
							<td colspan="3">
								<i class="fa fa-arrow-right"></i>
								<p class="paint_options_title">Краска</p>
							</td>
						</tr>
					</c:if>
					
					<c:forEach items="${item.key.paints}" var="paint">
						<c:if test="${ paint.price > 0 }">
							<tr class="block_product_price paint_options_body">
								<td>
									<input class="add_price_paint" type="checkbox" value="${paint.name}" 
										id="${paint.name}_${item.key.typeProduct}_${item.key.idProduct}_paint"
										<c:if test="${paint.checked}">checked</c:if>>
									<label class="add_price_title"
											 for="${paint.name}_${item.key.typeProduct}_${item.key.idProduct}_paint">${paint.name}</label>
								</td>		
								<td style="padding: 0px 15px;"> 
									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="${paint.quantity}"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>		 
								</td>
								<td>
									<div class="product_price">
										<input name="price_value" value="${paint.quantity*paint.price}" type="hidden">															
										<div></div>
									</div>
								</td>
							</tr>
						</c:if>
					</c:forEach>
					
				</table>				
		
			</td>
			<td>
	
				<input type="hidden" name="type" class="type" value="${item.key.typeProduct}">
				
				<input type="hidden" name="id" class="id" value="${item.key.idProduct}">
	
				<span class="dec_value">
					<i class="fa fa-minus" aria-hidden="true"></i>
				</span>

				<input class="quantity quantity_${item.key.typeProduct}_${item.key.idProduct}"  value="<c:out value="${item.value }"/>"></input>

				<span class="inc_value">
					<i class="fa fa-plus" aria-hidden="true"></i>
				</span>

			</td>
			<td class="price product_price">
				<input name="price_value" value="${item.key.getPriceWithOptionAndDeivery() * item.value }" type="hidden">	
				<input name="buyOnlineCoefficient" value="${item.key.buyOnlineCoefficient}" type="hidden">			
			   	<div></div>
			</td>
			<td class="delte_item"><i class="fa fa-trash-o" aria-hidden="true"></i></td>
		</tr>
		</c:forEach>

	</table>

	</form>
	</c:if>
	<c:if test="${empty cart.contents}">
		<form action="cart/pleaceOrder" method="post">
			Корзина пуста, Вы еще не добавляли товары в корзину.
		</form>
	</c:if>
	
</div>

            </div>
            <div class="modal-footer">
            	<c:if test="${!empty cart.contents}">
					<div id="div_total_price">
						<span style="float: left;">Общая стоимость: </span>
						<div class="product_price" style="float: left; margin-left: 10px;">
							<input name="price_value" value="${cart.getTotalCost()}" type="hidden">				
						   	<div></div>
					    </div>
					</div>
				</c:if>
				
                <button type="button" class="btn btn-default" data-dismiss="modal">Продолжить просмотр товара</button>
                <c:if test="${!empty cart.contents}">                	
                	<button type="button" class="btn btn-info">Купить онлайн</button>
                	<button type="button" class="btn btn-primary"><spring:message code="cart.ownpage.placeorder"/></button>
                </c:if>	
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->