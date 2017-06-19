<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">

	 <a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/printers' />"><custom:getDescriptionByLocale description="${descriptions.printers}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<c:forEach items="${product.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${product.typePrinter.equals('Сольвентный')}">
				<a href="<c:url value='/printers/dissolving' />"><custom:getDescriptionByLocale description="${descriptions.printer_dissolving}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Экосольвентный')}">
				<a href="<c:url value='/printers/ecosolvent' />"><custom:getDescriptionByLocale description="${descriptions.printer_ecosolvent}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('UV рулонный')}">
				<a href="<c:url value='/printers/UV_roll' />"><custom:getDescriptionByLocale description="${descriptions.printer_uv_roll}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('UV плоскопечатный')}">
				<a href="<c:url value='/printers/UV_flatbed' />"><custom:getDescriptionByLocale description="${descriptions.printer_flatbed}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Сублимационный')}">
				<a href="<c:url value='/printers/sublimation' />"><custom:getDescriptionByLocale description="${descriptions.printer_sublimation}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Текстильный')}">
				<a href="<c:url value='/printers/textile' />"><custom:getDescriptionByLocale description="${descriptions.printer_textile}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Водный/Пигментный')}">
				<a href="<c:url value='/printers/water_pigment' />"><custom:getDescriptionByLocale description="${descriptions.printer_water_pigment}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('САПР/ГИС')}">
				<a href="<c:url value='/printers/SAPR-GIS' />"><custom:getDescriptionByLocale description="${descriptions.printer_SAPR_GIS}"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>