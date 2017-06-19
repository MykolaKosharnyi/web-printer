<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/printers' />"><custom:getDescriptionByLocale description="${descriptions.printers}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Сольвентный')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printer_dissolving}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printer_dissolving}"/></title>
			</c:when>
			<c:when test="${tp.equals('Экосольвентный')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printer_ecosolvent}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printer_ecosolvent}"/></title>
			</c:when>
			<c:when test="${tp.equals('UV рулонный')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printer_uv_roll}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printer_uv_roll}"/></title>
			</c:when>
			<c:when test="${tp.equals('UV плоскопечатный')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printer_flatbed}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printer_flatbed}"/></title>
			</c:when>
			<c:when test="${tp.equals('Сублимационный')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printer_sublimation}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printer_sublimation}"/></title>
			</c:when>
			<c:when test="${tp.equals('Текстильный')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printer_textile}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printer_textile}"/></title>
			</c:when>
			<c:when test="${tp.equals('Водный/Пигментный')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printer_water_pigment}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printer_water_pigment}"/></title>
			</c:when>
			<c:when test="${tp.equals('САПР/ГИС')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printer_SAPR_GIS}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printer_SAPR_GIS}"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>