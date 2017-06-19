<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">

	 <a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/digital_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<c:forEach items="${product.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${product.typePrinter.equals('Полноцветное лазерное оборудование')}">
				<a href="<c:url value='/digital_printers/full_color_laser_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_laser_printers}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Монохромное лазерное оборудование')}">
				<a href="<c:url value='/digital_printers/monochrome_laser_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers_monochrome_laser_printers}"/></a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Полноцветное струйное оборудование')}">
				<a href="<c:url value='/digital_printers/full-color_inkjet_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_inkjet_printers}"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>