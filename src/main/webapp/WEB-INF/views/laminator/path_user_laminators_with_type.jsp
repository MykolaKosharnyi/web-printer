<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/laminators' />"><custom:getDescriptionByLocale description="${descriptions.laminators}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>

	<c:forEach items="${search.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Горячего ламинирования')}">	
				<p><custom:getDescriptionByLocale description="${descriptions.laminators_hot_lamination}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.laminators_hot_lamination}"/></title>
			</c:when>
			<c:when test="${tp.equals('Холодного ламинирования')}">
				<p><custom:getDescriptionByLocale description="${descriptions.laminators_cold_laminating}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.laminators_cold_laminating}"/></title>
			</c:when>
			<c:when test="${tp.equals('Жидкостные')}">
				<p><custom:getDescriptionByLocale description="${descriptions.laminators_liquid}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.laminators_liquid}"/></title>
			</c:when>
			<c:when test="${tp.equals('Планшетный ламинатор')}">
				<p><custom:getDescriptionByLocale description="${descriptions.laminators_flatbed_laminating_machine}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.laminators_flatbed_laminating_machine}"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>