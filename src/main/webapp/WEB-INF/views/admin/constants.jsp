<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
<html lang="ru">
<head>
	<title>${title}</title>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

<style>
	/*sprite with stars*/
	#reviewStars-input input:checked ~ label, #reviewStars-input label, #reviewStars-input label:hover, #reviewStars-input label:hover ~ label {
	background: url(/images/star.png);
	background-size: 43px 80px;
	}

	#reviewStars-input {
	  
	  /*fix floating problems*/
	  overflow: hidden;
	  *zoom: 1;
	  /*end of fix floating problems*/
	  
	  position: relative;
	  float: left;
	}

	#reviewStars-input input {
	  filter: progid:DXImageTransform.Microsoft.Alpha(Opacity=0);
	  opacity: 0;
	  
	  width: 43px;
	  height: 40px;
	  
	  position: absolute;
	  top: 0;
	  z-index: 0;
	}

	#reviewStars-input input:checked ~ label {
	  background-position: 0 -40px;
	  height: 40px;
	  width: 43px;
	}

	#reviewStars-input label {
	  background-position: 0 0;
	  height: 40px;
	  width: 43px;
	  float: right;
	  cursor: pointer;
	  margin-right: 10px;
	  
	  position: relative;
	  z-index: 1;
	}

	#reviewStars-input label:hover, #reviewStars-input label:hover ~ label {
	  background-position: 0 -40px;
	  height: 40px;
	  width: 43px;
	}

	#reviewStars-input #star-0 {
	  left: 0px;
	}
	#reviewStars-input #star-1 {
	  left: 53px;
	}
	#reviewStars-input #star-2 {
	  left: 106px;
	}
	#reviewStars-input #star-3 {
	  left: 169px;
	}
	#reviewStars-input #star-4 {
	  left: 212px;
	}
	#reviewStars-input #star-5 {
	  left: 265px;
	}
</style>	

</head>
<body>
	<div id="product">
	
		<c:url var="addAction" value="/admin/constants/update" ></c:url>
		<form:form method="POST" commandName="constantsChange" action="${addAction}">
			<p>Цена за доллар в гривнах</p><form:input path="dollarInGrivna"/><form:errors path="dollarInGrivna" cssClass="error"></form:errors>
			<hr>
			<p>Цена за евро в гривнах</p><form:input path="euroInGrivna"/><form:errors path="euroInGrivna" cssClass="error"></form:errors>
			<hr>
			<p>Цена за авиа доставку учитывая габариты, в долларах</p><form:input path="priceAviaSize"/><form:errors path="priceAviaSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за авиа доставку учитывая вес, в долларах</p><form:input path="priceAviaWeight"/><form:errors path="priceAviaWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку морем учитывая габариты, в долларах</p><form:input path="priceSeaSize"/><form:errors path="priceSeaSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку морем учитывая вес, в долларах</p><form:input path="priceSeaWeight"/><form:errors path="priceSeaWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по украине учитывая габариты, в долларах</p><form:input path="priceUkraineSize"/><form:errors path="priceUkraineSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по украине учитывая вес, в долларах</p><form:input path="priceUkraineWeight"/><form:errors path="priceUkraineWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по Киеву учитывая габариты, в долларах</p><form:input path="priceKyivSize"/><form:errors path="priceKyivSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по Киеву учитывая вес, в долларах</p><form:input path="priceKyivWeight"/><form:errors path="priceKyivWeight" cssClass="error"></form:errors>
		
			<!-- <input id="submit" type="submit" formaction="${saveUpdate}" value="сохранить" style="background: gold; color: black;"/> -->
			<input id="submit" type="submit" value="изменить" style="background:blue; color: azure; margin-bottom: 40px;"/>
		</form:form>




<h1>Rating stars with CSS (all new browsers and IE 8+</h1>

<!--[if lte IE 7]><style>#reviewStars-input{display:none}</style><![endif]-->

<div id="reviewStars-input">
    <input id="star-4" type="radio" name="reviewStars"/>
    <label title="gorgeous" for="star-4"></label>

    <input id="star-3" type="radio" name="reviewStars"/>
    <label title="good" for="star-3"></label>

    <input id="star-2" type="radio" checked name="reviewStars"/>
    <label title="regular" for="star-2"></label>

    <input id="star-1" type="radio" name="reviewStars"/>
    <label title="poor" for="star-1"></label>

    <input id="star-0" type="radio" name="reviewStars"/>
    <label title="bad" for="star-0"></label>
</div>




	</div>
</body>
</html>