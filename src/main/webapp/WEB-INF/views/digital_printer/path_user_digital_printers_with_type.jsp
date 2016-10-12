<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/digital_printers' />"><spring:message code="head.digital_printer"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typePrinter}" var="tp">
		<c:choose>
		
			<c:when test="${tp.equals('Полноцветное лазерное оборудование')}">
				<p><spring:message code="head.digital_printer.full_color_laser_printers"/></p>
				<title><spring:message code="head.digital_printer.full_color_laser_printers"/></title>
			</c:when>
			
			<c:when test="${tp.equals('Монохромное лазерное оборудование')}">
				<p><spring:message code="head.digital_printer.monochrome_laser_printers"/></p>
				<title><spring:message code="head.digital_printer.monochrome_laser_printers"/></title>
			</c:when>
			
			<c:when test="${tp.equals('Полноцветное струйное оборудование')}">
				<p><spring:message code="head.digital_printer.full_color_inkjet_printers"/></p>
				<title><spring:message code="head.digital_printer.full_color_inkjet_printers"/></title>
			</c:when>
			
		</c:choose>
	</c:forEach>
</div>