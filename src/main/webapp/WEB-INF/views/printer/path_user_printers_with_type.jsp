<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/printers' />"><spring:message code="head.printer"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Сольвентный')}">
				<p><spring:message code="head.printer.dissolving"/></p>
				<title><spring:message code="head.printer.dissolving"/></title>
			</c:when>
			<c:when test="${tp.equals('Экосольвентный')}">
				<p><spring:message code="head.printer.ecosolvent"/></p>
				<title><spring:message code="head.printer.ecosolvent"/></title>
			</c:when>
			<c:when test="${tp.equals('UV рулонный')}">
				<p><spring:message code="head.printer.uv_roll"/></p>
				<title><spring:message code="head.printer.uv_roll"/></title>
			</c:when>
			<c:when test="${tp.equals('UV плоскопечатный')}">
				<p><spring:message code="head.printer.flatbed"/></p>
				<title><spring:message code="head.printer.flatbed"/></title>
			</c:when>
			<c:when test="${tp.equals('Сублимационный')}">
				<p><spring:message code="head.printer.sublimation"/></p>
				<title><spring:message code="head.printer.sublimation"/></title>
			</c:when>
			<c:when test="${tp.equals('Текстильный')}">
				<p><spring:message code="head.printer.textile"/></p>
				<title><spring:message code="head.printer.textile"/></title>
			</c:when>
			<c:when test="${tp.equals('Водный/Пигментный')}">
				<p><spring:message code="head.printer.water_pigment"/></p>
				<title><spring:message code="head.printer.water_pigment"/></title>
			</c:when>
			<c:when test="${tp.equals('САПР/ГИС')}">
				<p><spring:message code="head.printer.SAPR-GIS"/></p>
				<title><spring:message code="head.printer.SAPR-GIS"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>