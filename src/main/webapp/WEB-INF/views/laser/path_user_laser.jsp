<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">

	 <a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<c:forEach items="${product.typeLaser}" var="tp">
		<c:choose>
			<c:when test="${product.typeLaser.equals('Газовые лазеры СО2')}">
				<a href="<c:url value='/lasers/CO2_gas_lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers_CO2_gas_lasers}"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('Твердотельные лазеры')}">
				<a href="<c:url value='/lasers/solid_state_lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers_solid_state_lasers}"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('Для обработки метала')}">
				<a href="<c:url value='/lasers/for_the_treatment_of_metal' />"><custom:getDescriptionByLocale description="${descriptions.lasers_for_the_treatment_of_metal}"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('С диодной накачкой')}">
				<a href="<c:url value='/lasers/diode_pumped' />"><custom:getDescriptionByLocale description="${descriptions.lasers_diode_pumped}"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('Оптоволоконные лазеры')}">
				<a href="<c:url value='/lasers/fiber_lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers_fiber_lasers}"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('Плазменные лазеры')}">
				<a href="<c:url value='/lasers/plasma_lasers' />"><custom:getDescriptionByLocale description="${descriptions.lasers_plasma_lasers}"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>
		<c:choose>   
	         <c:when test = "${localeCode == 'en' && !empty product.engNameProduct}">
	            ${product.engNameProduct}
	         </c:when>
	         
	         <c:otherwise>
	            ${product.name}
	         </c:otherwise>
		</c:choose>
	</p>
</div>