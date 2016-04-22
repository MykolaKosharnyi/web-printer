<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

	<div class="container" style="margin-top: 133px;">
		<div class="col-md-2">
			<div class="row">
				<div class="left_field">
					<tiles:insertAttribute name="left-menu" />
					<tiles:insertAttribute name="search" />
					<tiles:insertAttribute name="reklam" />
				</div>		
			</div>
		</div>
		<div class="col-md-10">
			<div class="row">
				<tiles:insertAttribute name="body" />	
			</div>
		</div>
	</div>
	
	<tiles:insertAttribute name="footer" />

	<div class="hidden">
		<form id="callback" class="pop_form">
			<h3>Заказать разработку</h3>
			<input type="text" name="name" placeholder="Ваше имя..." required />
			<input type="text" name="phone" placeholder="Ваше телефон..." required />
			<button class="button" type="submit">Заказать</button>
		</form>
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
	<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>

	<script src="<%=request.getContextPath()%>/resources/js/user/title.js"></script>

	<script>
	function addToCart(typeProduct, idProduct){
		$.ajax({
			  type: 'POST',
			  url: "/cart/add/" + typeProduct + "/" + idProduct,
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			  });	
		}

	function checkPrise(num){
		if(num > 0.1){
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
			  return "$" + str.replace(".", ",");
		} else {
			return "\u0443\u0442\u043E\u0447\u043D\u044F\u0439\u0442\u0435";
		}
	}

	</script>

	<!-- Yandex.Metrika counter --><!-- /Yandex.Metrika counter -->
	<!-- Google Analytics counter --><!-- /Google Analytics counter -->		
</body>
</html>