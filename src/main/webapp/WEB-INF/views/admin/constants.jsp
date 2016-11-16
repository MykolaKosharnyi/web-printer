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
</head>
<body>
	<div id="product">
	
		<c:url var="addAction" value="/admin/constants/update" ></c:url>
		<form:form method="POST" commandName="constantsChange" action="${addAction}">
			<p>Цена за доллар в гривнах</p><form:input path="dollarInGrivna"/>
			<form:errors path="dollarInGrivna" cssClass="error"></form:errors>
			<hr>
			<p>Цена за евро в гривнах</p><form:input path="euroInGrivna"/>
			<form:errors path="euroInGrivna" cssClass="error"></form:errors>
			<hr>
			<p>Цена за авиа доставку учитывая габариты, в долларах</p><form:input path="priceAviaSize"/>
			<form:errors path="priceAviaSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за авиа доставку учитывая вес, в долларах</p><form:input path="priceAviaWeight"/>
			<form:errors path="priceAviaWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку морем учитывая габариты, в долларах</p><form:input path="priceSeaSize"/>
			<form:errors path="priceSeaSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку морем учитывая вес, в долларах</p><form:input path="priceSeaWeight"/>
			<form:errors path="priceSeaWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по украине учитывая габариты, в долларах</p><form:input path="priceUkraineSize"/>
			<form:errors path="priceUkraineSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по украине учитывая вес, в долларах</p><form:input path="priceUkraineWeight"/>
			<form:errors path="priceUkraineWeight" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по Киеву учитывая габариты, в долларах</p><form:input path="priceKyivSize"/>
			<form:errors path="priceKyivSize" cssClass="error"></form:errors>
			<hr>
			<p>Цена за доставку по Киеву учитывая вес, в долларах</p><form:input path="priceKyivWeight"/>
			<form:errors path="priceKyivWeight" cssClass="error"></form:errors>
			<hr>
			<p>Страхование груза по Украине (указывать процент от 1 до 100%)</p><form:input path="percentInsuranceUkraine"/>
			<form:errors path="percentInsuranceUkraine" cssClass="error"></form:errors>
			<hr>
			<p>Страхование груза международная перевозка (указывать процент от 1 до 100%)</p><form:input path="percentInsuranceInternational"/>
			<form:errors path="percentInsuranceInternational" cssClass="error"></form:errors>
		
			<!-- <input id="submit" type="submit" formaction="${saveUpdate}" value="сохранить" style="background: gold; color: black;"/> -->
			<input id="submit" type="submit" value="изменить" style="background:blue; color: azure; margin-bottom: 40px;"/>
		</form:form>
	</div>
</body>
</html>