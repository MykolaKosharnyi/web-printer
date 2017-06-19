<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/scanners' />"><custom:getDescriptionByLocale description="${descriptions.scanners}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>

	<c:forEach items="${search.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Широкоформатные сканеры')}">	
				<p><custom:getDescriptionByLocale description="${descriptions.scanners_large_format_scanners}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.scanners_large_format_scanners}"/></title>
			</c:when>
			
			<c:when test="${tp.equals('3D Сканеры')}">	
				<p><custom:getDescriptionByLocale description="${descriptions.scanners_3d_scanners}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.scanners_3d_scanners}"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>