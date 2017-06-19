<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typeLaser}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Газовые лазеры СО2')}">
				<p><custom:getDescriptionByLocale description="${descriptions.lasers_CO2_gas_lasers}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.lasers_CO2_gas_lasers}"/></title>
			</c:when>
			<c:when test="${tp.equals('Твердотельные лазеры')}">
				<p><custom:getDescriptionByLocale description="${descriptions.lasers_solid_state_lasers}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.lasers_solid_state_lasers}"/></title>
			</c:when>
			<c:when test="${tp.equals('Для обработки метала')}">
				<p><custom:getDescriptionByLocale description="${descriptions.lasers_for_the_treatment_of_metal}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.lasers_for_the_treatment_of_metal}"/></title>
			</c:when>
			<c:when test="${tp.equals('С диодной накачкой')}">
				<p><custom:getDescriptionByLocale description="${descriptions.lasers_diode_pumped}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.lasers_diode_pumped}"/></title>
			</c:when>
			<c:when test="${tp.equals('Оптоволоконные лазеры')}">
				<p><custom:getDescriptionByLocale description="${descriptions.lasers_fiber_lasers}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.lasers_fiber_lasers}"/></title>
			</c:when>
			<c:when test="${tp.equals('Плазменные лазеры')}">
				<p><custom:getDescriptionByLocale description="${descriptions.lasers_plasma_lasers}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.lasers_plasma_lasers}"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>