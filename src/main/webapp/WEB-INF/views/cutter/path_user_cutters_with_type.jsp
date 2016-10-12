<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/cutters' />"><spring:message code="head.cutter"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>

	<c:forEach items="${search.typeCutter}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Для обработки дерева')}">		
				<p><spring:message code="head.cutter.for_wood"/></p>
				<title><spring:message code="head.cutter.for_wood"/></title>
			</c:when>
			<c:when test="${tp.equals('Для обработки металла')}">
				<p><spring:message code="head.cutter.for_the_treatment_of_metal"/></p>
				<title><spring:message code="head.cutter.for_the_treatment_of_metal"/></title>
			</c:when>
			<c:when test="${tp.equals('Для обработки камня')}">
				<p><spring:message code="head.cutter.stone_processing"/></p>
				<title><spring:message code="head.cutter.stone_processing"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>