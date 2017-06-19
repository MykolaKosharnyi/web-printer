<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/cutters' />"><custom:getDescriptionByLocale description="${descriptions.cutters}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>

	<c:forEach items="${search.typeCutter}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Для обработки дерева')}">		
				<p><custom:getDescriptionByLocale description="${descriptions.cutters_for_wood}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.cutters_for_wood}"/></title>
			</c:when>
			<c:when test="${tp.equals('Для обработки металла')}">
				<p><custom:getDescriptionByLocale description="${descriptions.cutters_for_the_treatment_of_metal}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.cutters_for_the_treatment_of_metal}"/></title>
			</c:when>
			<c:when test="${tp.equals('Для обработки камня')}">
				<p><custom:getDescriptionByLocale description="${descriptions.cutters_stone_processing}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.cutters_stone_processing}"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>