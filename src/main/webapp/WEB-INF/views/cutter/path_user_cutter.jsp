<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">

	 <a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/cutters' />"><custom:getDescriptionByLocale description="${descriptions.cutters}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<c:forEach items="${product.typeCutter}" var="tp">
		<c:choose>
			<c:when test="${product.typeCutter.equals('Для обработки дерева')}">
				<a href="<c:url value='/cutters/for_wood' />"><custom:getDescriptionByLocale description="${descriptions.cutters_for_wood}"/></a>
			</c:when>
			<c:when test="${product.typeCutter.equals('Для обработки металла')}">
				<a href="<c:url value='/cutters/for_the_treatment_of_metal' />"><custom:getDescriptionByLocale description="${descriptions.cutters_for_the_treatment_of_metal}"/></a>
			</c:when>
			<c:when test="${product.typeCutter.equals('Для обработки камня')}">
				<a href="<c:url value='/cutters/stone_processing' />"><custom:getDescriptionByLocale description="${descriptions.cutters_stone_processing}"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>