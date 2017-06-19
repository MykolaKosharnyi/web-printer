<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/digital_printers' />"><custom:getDescriptionByLocale description="${descriptions.digital_printers}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typePrinter}" var="tp">
		<c:choose>
		
			<c:when test="${tp.equals('Полноцветное лазерное оборудование')}">
				<p><custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_laser_printers}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_laser_printers}"/></title>
			</c:when>
			
			<c:when test="${tp.equals('Монохромное лазерное оборудование')}">
				<p><custom:getDescriptionByLocale description="${descriptions.digital_printers_monochrome_laser_printers}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.digital_printers_monochrome_laser_printers}"/></title>
			</c:when>
			
			<c:when test="${tp.equals('Полноцветное струйное оборудование')}">
				<p><custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_inkjet_printers}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.digital_printers_full_color_inkjet_printers}"/></title>
			</c:when>
			
		</c:choose>
	</c:forEach>
</div>