<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	<span> > </span>

	<c:forEach items="${search.typeCutter}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Для обработки дерева')}">
				<a href="<c:url value='/cutters' />"><spring:message code="head.cutter"/></a>
				<span> > </span>
				<p><spring:message code="head.cutter.for_wood"/></p>
			</c:when>
			<c:when test="${tp.equals('Для обработки металла')}">
				<a href="<c:url value='/cutters' />"><spring:message code="head.cutter"/></a>
				<span> > </span>
				<p><spring:message code="head.cutter.for_the_treatment_of_metal"/></p>
			</c:when>
			<c:when test="${tp.equals('Для обработки камня')}">
				<a href="<c:url value='/cutters' />"><spring:message code="head.cutter"/></a>
				<span> > </span>
				<p><spring:message code="head.cutter.stone_processing"/></p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>