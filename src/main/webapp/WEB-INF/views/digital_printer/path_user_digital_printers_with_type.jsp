<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />">Главная</a>
	<span> > </span>

	<c:forEach items="${search.typePrinter}" var="tp">
		<c:choose>
		
			<c:when test="${tp.equals('Полноцветное лазерное оборудование')}">
				<a href="<c:url value='/digital_printers' />"><spring:message code="head.digital_printer"/></a>
				<span> > </span>
				<p><spring:message code="head.digital_printer.full_color_laser_printers"/></p>
			</c:when>
			
			<c:when test="${tp.equals('Монохромное лазерное оборудование')}">
				<a href="<c:url value='/digital_printers' />"><spring:message code="head.digital_printer"/></a>
				<span> > </span>
				<p><spring:message code="head.digital_printer.monochrome_laser_printers"/></p>
			</c:when>
			
			<c:when test="${tp.equals('Полноцветное струйное оборудование')}">
				<a href="<c:url value='/digital_printers' />"><spring:message code="head.digital_printer"/></a>
				<span> > </span>
				<p><spring:message code="head.digital_printer.full_color_inkjet_printers"/></p>
			</c:when>
			
		</c:choose>
	</c:forEach>
</div>