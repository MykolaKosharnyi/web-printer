<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typeLaser}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Газовые лазеры СО2')}">
				<p><spring:message code="head.laser.CO2_gas_lasers"/></p>
			</c:when>
			<c:when test="${tp.equals('Твердотельные лазеры')}">
				<p><spring:message code="head.laser.solid_state_lasers"/></p>
			</c:when>
			<c:when test="${tp.equals('Для обработки метала')}">
				<p><spring:message code="head.laser.for_the_treatment_of_metal"/></p>
			</c:when>
			<c:when test="${tp.equals('С диодной накачкой')}">
				<p><spring:message code="head.laser.diode_pumped"/></p>
			</c:when>
			<c:when test="${tp.equals('Оптоволоконные лазеры')}">
				<p><spring:message code="head.laser.fiber_lasers"/></p>
			</c:when>
			<c:when test="${tp.equals('Плазменные лазеры')}">
				<p><spring:message code="head.laser.plasma_lasers"/></p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>