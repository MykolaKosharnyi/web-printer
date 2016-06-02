<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	 <span> > </span>
	 <a href="<c:url value='/cutters' />"><spring:message code="head.cutter"/></a>
	 <span> > </span>
	<c:forEach items="${product.typeCutter}" var="tp">
		<c:choose>
			<c:when test="${product.typeCutter.equals('Для обработки дерева')}">
				<a href="<c:url value='/cutters/for_wood' />"><spring:message code="head.cutter.for_wood"/></a>
			</c:when>
			<c:when test="${product.typeCutter.equals('Для обработки металла')}">
				<a href="<c:url value='/cutters/for_the_treatment_of_metal' />"><spring:message code="head.cutter.for_the_treatment_of_metal"/></a>
			</c:when>
			<c:when test="${product.typeCutter.equals('Для обработки камня')}">
				<a href="<c:url value='/cutters/stone_processing' />"><spring:message code="head.cutter.stone_processing"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span> > </span>
	<p>${product.name}</p>
</div>