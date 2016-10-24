<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--[if lt IE 7]><html lang="ru" class="lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html lang="ru" class="lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html lang="ru" class="lt-ie9"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="ru">
<!--<![endif]-->
<head>
<meta charset="utf-8" />
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

	<meta name="description" content="широкоформатная печать" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="shortcut icon" href="/images/logo.jpg" />

	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
	<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

	<link rel="stylesheet" href="/css/jquery-ui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/font-awesome-4.2.0/css/font-awesome.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/fancybox/jquery.fancybox.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/owl-carousel/owl.carousel.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/countdown/jquery.countdown.css" />
	<link rel="stylesheet" href="/css/fonts.css" />
	<link rel="stylesheet" href="/css/main.css" />
	<link rel="stylesheet" href="/css/media.css" />

    	<link rel="stylesheet" href="/css/title.css"/>	
	<link rel="stylesheet" href="/css/home.css"/>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	
<!--  	

<link rel="stylesheet" href="/css/flipclock.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
-->

</head>
<body>

	<tiles:insertAttribute name="header" />

	<div class="container">
		<div class="col-md-12">
			<div class="row">
				<tiles:insertAttribute name="path" />
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 140px;">
		<div class="col-md-2" style="max-width: 207px;">
			<div class="row">
				<div class="left_field">
					<tiles:insertAttribute name="left-menu" />
					<tiles:insertAttribute name="search" />
					<tiles:insertAttribute name="reklam" />
				</div>		
			</div>
		</div>
		<div class="col-md-10">
			<div class="row" style="padding-left: 5px;">
				<tiles:insertAttribute name="body" />	
			</div>
		</div>
	</div>
	
	<tiles:insertAttribute name="footer" />




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
		<tr>
			<td style="width: 220px;">
				<a href="<c:url value='/${item.key.typeProduct}/${item.key.idProduct}' />">
					<img style="height:auto; width:100%;" src="<%=request.getContextPath()%>/${item.key.picturePath}" alt="">
				</a>
			</td>
			<td style="max-width: 235px;"><a style="color:black;" href="<c:url value='/${item.key.typeProduct}/${item.key.idProduct}' />">${item.key.name }</a></td>
			<td style="padding: 0px; width:350px;" class="option_product_car">
				
				<table class="table table-hover" style="width:355px;">
				
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
			<td class="price">$<span>
				<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${item.key.getPriceWithOptionAndDeivery() * item.value }" />
					</span>
					<input type="hidden" name="price_ellement" value="${item.key.price}">
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
						<span>Общая стоимость: </span>$<span id="total_price"><fmt:formatNumber type="number" 
				   		maxFractionDigits="2" minFractionDigits="2" value="${cart.getTotalCost()}" /></span>
					</div>
				</c:if>
				
                <button type="button" class="btn btn-default" data-dismiss="modal">Продолжить просмотр товара</button>
                <c:if test="${!empty cart.contents}">
                	<button type="button" class="btn btn-primary"><spring:message code="cart.ownpage.placeorder"/></button>
                </c:if>	
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->







<!--[if lt IE 9]>
	<script src="libs/html5shiv/es5-shim.min.js"></script>
	<script src="libs/html5shiv/html5shiv.min.js"></script>
	<script src="libs/html5shiv/html5shiv-printshiv.min.js"></script>
	<script src="libs/respond/respond.min.js"></script>
	<![endif]-->
	
	<!--<script src="<%=request.getContextPath()%>/resources/js/jquery.sticky-kit.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/flipclock.min.js"></script>-->

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

	<script src="<%=request.getContextPath()%>/resources/libs/jquery-mousewheel/jquery.mousewheel.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/fancybox/jquery.fancybox.pack.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/waypoints/waypoints-1.6.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/scrollto/jquery.scrollTo.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/owl-carousel/owl.carousel.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/countdown/jquery.plugin.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/countdown/jquery.countdown.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/countdown/jquery.countdown-ru.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/landing-nav/navigation.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/js.cookie.js"></script>
	
	<script src="<%=request.getContextPath()%>/resources/js/cart.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user/title.js"></script>

	<!-- Yandex.Metrika counter --><!-- /Yandex.Metrika counter -->
	<!-- Google Analytics counter --><!-- /Google Analytics counter -->		
	
	<%-- callback for reklam in left menu --%>
	<div class="hidden">
		<form id="callback_reklam" class="pop_form">
			<h5 style="max-width: 300px;">Пожалуйста оставьте координаты, через некоторое время мы с вами свяжемся</h5>
			<input type="text" name="name" placeholder="Ваше имя..." required />
			<input type="text" name="phone" placeholder="Ваше телефон..." required />
			<button class="button" type="submit">Уточнить</button>
		</form>
	</div>
	
	<%-- callback on all site --%>
	<div class="hidden">
		<form id="callback" class="pop_form">
			<h5 style="max-width: 300px;">Пожалуйста оставьте координаты, через некоторое время мы с вами свяжемся</h5>
			<input type="hidden" name="id" value="${product.id}">
			<input type="hidden" name="typeProduct" value="${product.id}">
			<input type="text" name="name" placeholder="Ваше имя..." required />
			<input type="text" name="phone" placeholder="Ваше телефон..." required />
			<button class="button" type="submit">Уточнить</button>
			<button class="button button-close">Закрыть</button>
		</form>
	</div>
<script type="text/javascript">
function checkPrise(num){
	if(num > 0.1){
		  var priceDollarInGrivna = new Number("${ constants.dollar_in_grivna }");
		  var priceEuroInGrivna = new Number("${ constants.euro_in_grivna }");
		
		  //return name of currency
		  var currency = readCookie('check_name_currency');
		  
		  //&#8364; - euro
		  //&#8372; - gryvna
		  if(currency==="grinva"){
			  return '\u20B4' + convernPriceToString(num*priceDollarInGrivna).replace(".", ",") + " UAH";
		  } else if (currency==="euro"){
			  return '\u20ac' + convernPriceToString(num*priceDollarInGrivna/priceEuroInGrivna).replace(".", ",");
		  } else if (currency==="dollar"){
			  return "$" + convernPriceToString(num).replace(".", ",");
		  } else {
			  return '\u20B4' + convernPriceToString(num*priceDollarInGrivna).replace(".", ",") + " UAH";
		  }

	} else {
		return "\u0443\u0442\u043E\u0447\u043D\u044F\u0439\u0442\u0435";
	}
}

function convernPriceToString(num){
	  num = Math.round( num / 0.01 ) * 0.01;
	  num = new Number(num).toFixed(2);   // особенности счета JavaScript ( x/100 не всегда = x*0.01 )
	  var s = 0;
	  var str = '';
	  for( var i=num.toString().length-1; i>=0; i-- ) {
	    s++;
	    str = num.toString().charAt(i) + str;
	    if(num.toString().charAt(i)=='.') s=0;
	    if( s > 0 && !(s % 3) ) str  = " " + str;
	  }   
	  return str.indexOf(" ") == 0 ? str.substring(1) : str;
}
</script>
</body>
</html>