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
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

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
					<tiles:insertAttribute name="user-menu" />
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

<!-- include cart on pages -->
<jsp:include page="modal_cart_window.jsp" />

<!-- modal window for showing where office on map -->
<div id="myAdress" class="modal fade">
    <div class="modal-dialog" style="width:600px;height: auto;">
        <div class="modal-content">
			<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Офис на карте</h4>
            </div>
            <div class="modal-body" >
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d635.477901903038!2d30.384235388132957!3d50.42411849871069!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cb928eb049e1%3A0x8fac369d19f70638!2sKartvelishvili+St%2C+7%2C+Kyiv%2C+Ukraine!5e0!3m2!1sen!2sua!4v1484153860942" style="border:0; width: 100%; height:420px;" ></iframe>
            </div>

        </div>
    </div>
</div>

<!--[if lt IE 9]>
	<script src="libs/html5shiv/es5-shim.min.js"></script>
	<script src="libs/html5shiv/html5shiv.min.js"></script>
	<script src="libs/html5shiv/html5shiv-printshiv.min.js"></script>
	<script src="libs/respond/respond.min.js"></script>
	<![endif]-->
	
	<!--<script src="<%=request.getContextPath()%>/resources/js/jquery.sticky-kit.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/flipclock.min.js"></script>-->

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

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
		<form id="callback_reklam" action="/ask/product" method="POST" class="pop_form">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<h5 style="max-width: 300px;">Пожалуйста оставьте координаты, через некоторое время мы с вами свяжемся</h5>
			<input type="text" name="name" placeholder="Ваше имя..." required />
			<input type="text" name="subject" placeholder="subject..." required />
			<input type="text" name="message" placeholder="message..." required />
			<button class="button" type="submit">Уточнить</button>
		</form>
	</div>
	
<div id="callback_reklam" class="modal fade">
	<div class="modal-dialog" style="width:300px;">
		<div class="modal-content">
			<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                
                <c:if test="${pageContext.request.userPrincipal.name != null}">
					<h5 class="modal-title">Пожалуйста оставьте цену за товар, через некоторое время мы с вами свяжемся</h5>
				</c:if>
                
                <c:if test="${pageContext.request.userPrincipal.name == null}">
					<h5 class="modal-title">Пожалуйста оставьте Ваши координаты и цену за товар, через некоторое время мы с вами свяжемся</h5>
				</c:if>
                
            </div>
            <div class="modal-body" style="padding: 5px 5px 0px 5px;">

					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<input type="hidden" name="logined" value="true"></input>
					</c:if>
					
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<input type="hidden" name="logined" value="false"></input>

						<div class="form-group">
							<label style="font-size: 13px; margin: 5px;">Введите имя:</label>
							<input type="text" class="form-control" name="name"></input>
						</div>

						<div class="form-group">
							<label style="font-size: 13px; margin: 5px;">Введите e-mail:</label>
							<input type="email" class="form-control" name="email"></input>
						</div>

						<div class="form-group">
							<label style="font-size: 13px; margin: 5px;">Введите номер телефона:</label>
							<input type="text" class="form-control" name="phonenumber"></input>
						</div>
						
						<div class="form-group">
							<hr style="border: 0.5px solid rgb(0, 96, 128);">
						</div>
					</c:if>
					
					<div id="proposal_product_link" class="form-group">
						<input type="hidden" name="typeProduct" value=""></input>
						<input type="hidden" name="idProduct" value=""></input>
						<img src="" class="col-sm-6 img-rounded" />
						<div class="col-sm-6" style="font-size: 14px;">
							<a href=""></a>
						</div>
					</div>
					
					<div class="form-group">
						<label style="font-size: 13px; margin: 5px;">Ваша цена за товар:</label> 
						<input type="text" class="form-control" name="price"></input>
					</div>					
			</div>
            <div class="modal-footer">
            	<button class="btn btn-success">Уточнить</button>
				<button class="btn btn-danger button-close" data-dismiss="modal">Закрыть</button>
            </div>
		</div>
	</div>	
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
			<button class="button button-close" data-dismiss="modal">Закрыть</button>
		</form>
	</div>
<script type="text/javascript">

function openModalProposalPrise(type, idProduct, nameProduct, pathToPicture){
	var proposalProduct = $('#callback_reklam').find("#proposal_product_link");
	proposalProduct.find("img").attr("src", "/images/" + type + "s/" + idProduct + "/" + pathToPicture);
	proposalProduct.find("a").attr("href", type + "/" + idProduct).text(nameProduct);
	proposalProduct.find("input[name=typeProduct]").val(type);
	proposalProduct.find("input[name=idProduct]").val(idProduct);
	
    $('#callback_reklam').modal();
} 

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