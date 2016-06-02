<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	 <span> > </span>
	 <a href="<c:url value='/printers' />"><spring:message code="head.printer"/></a>
	 <span> > </span>
	<c:forEach items="${product.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${product.typePrinter.equals('Сольвентный')}">
				<a href="<c:url value='/printers/dissolving' />"><spring:message code="head.printer.dissolving"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Экосольвентный')}">
				<a href="<c:url value='/printers/ecosolvent' />"><spring:message code="head.printer.ecosolvent"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('UV рулонный')}">
				<a href="<c:url value='/printers/UV_roll' />"><spring:message code="head.printer.uv_roll"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('UV плоскопечатный')}">
				<a href="<c:url value='/printers/UV_flatbed' />"><spring:message code="head.printer.flatbed"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Сублимационный')}">
				<a href="<c:url value='/printers/sublimation' />"><spring:message code="head.printer.sublimation"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Текстильный')}">
				<a href="<c:url value='/printers/textile' />"><spring:message code="head.printer.textile"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Водный/Пигментный')}">
				<a href="<c:url value='/printers/water_pigment' />"><spring:message code="head.printer.water_pigment"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('САПР/ГИС')}">
				<a href="<c:url value='/printers/SAPR-GIS' />"><spring:message code="head.printer.SAPR-GIS"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span> > </span>
	<p>${product.name}</p>
</div>