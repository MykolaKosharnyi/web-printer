<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />">Главная</a>
	<span> > </span>

	<c:forEach items="${search.typeLaser}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Газовые лазеры СО2')}">
				<a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
				<span> > </span>
				<p><spring:message code="head.laser.CO2_gas_lasers"/></p>
			</c:when>
			<c:when test="${tp.equals('Твердотельные лазеры')}">
				<a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
				<span> > </span>
				<p><spring:message code="head.laser.solid_state_lasers"/></p>
			</c:when>
			<c:when test="${tp.equals('Для обработки метала')}">
				<a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
				<span> > </span>
				<p><spring:message code="head.laser.for_the_treatment_of_metal"/></p>
			</c:when>
			<c:when test="${tp.equals('С диодной накачкой')}">
				<a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
				<span> > </span>
				<p><spring:message code="head.laser.diode_pumped"/></p>
			</c:when>
			<c:when test="${tp.equals('Оптоволоконные лазеры')}">
				<a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
				<span> > </span>
				<p><spring:message code="head.laser.fiber_lasers"/></p>
			</c:when>
			<c:when test="${tp.equals('Плазменные лазеры')}">
				<a href="<c:url value='/lasers' />"><spring:message code="head.laser"/></a>
				<span> > </span>
				<p><spring:message code="head.laser.plasma_lasers"/></p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>