<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<c:forEach items="${product.typeLaser}" var="tp">
		<c:choose>
			<c:when test="${product.typeLaser.equals('Газовые лазеры СО2')}">
				<a href="<c:url value='/lasers/CO2_gas_lasers' />"><spring:message code="head.laser.CO2_gas_lasers"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('Твердотельные лазеры')}">
				<a href="<c:url value='/lasers/solid_state_lasers' />"><spring:message code="head.laser.solid_state_lasers"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('Для обработки метала')}">
				<a href="<c:url value='/lasers/for_the_treatment_of_metal' />"><spring:message code="head.laser.for_the_treatment_of_metal"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('С диодной накачкой')}">
				<a href="<c:url value='/lasers/diode_pumped' />"><spring:message code="head.laser.diode_pumped"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('Оптоволоконные лазеры')}">
				<a href="<c:url value='/lasers/fiber_lasers' />"><spring:message code="head.laser.fiber_lasers"/></a>
			</c:when>
			<c:when test="${product.typeLaser.equals('Плазменные лазеры')}">
				<a href="<c:url value='/lasers/plasma_lasers' />"><spring:message code="head.laser.plasma_lasers"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>