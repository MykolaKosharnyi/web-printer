<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	 <span> > </span>
	 <a href="<c:url value='/digital_printers' />"><spring:message code="head.digital_printer"/></a>
	 <span> > </span>
	<c:forEach items="${product.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${product.typePrinter.equals('Полноцветное лазерное оборудование')}">
				<a href="<c:url value='/digital_printers/full_color_laser_printers' />"><spring:message code="head.digital_printer.full_color_laser_printers"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Монохромное лазерное оборудование')}">
				<a href="<c:url value='/digital_printers/monochrome_laser_printers' />"><spring:message code="head.digital_printer.monochrome_laser_printers"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Полноцветное струйное оборудование')}">
				<a href="<c:url value='/digital_printers/full-color_inkjet_printers' />"><spring:message code="head.digital_printer.full_color_inkjet_printers"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span> > </span>
	<p>${product.name}</p>
</div>