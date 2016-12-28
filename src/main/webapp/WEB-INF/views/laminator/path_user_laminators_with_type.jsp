<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/laminators' />"><spring:message code="head.laminator"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>

	<c:forEach items="${search.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Горячего ламинирования')}">	
				<p><spring:message code="head.laminator.hot_lamination"/></p>
				<title><spring:message code="head.laminator.hot_lamination"/></title>
			</c:when>
			<c:when test="${tp.equals('Холодного ламинирования')}">
				<p><spring:message code="head.laminator.cold_laminating"/></p>
				<title><spring:message code="head.laminator.cold_laminating"/></title>
			</c:when>
			<c:when test="${tp.equals('Жидкостные')}">
				<p><spring:message code="head.laminator.liquid"/></p>
				<title><spring:message code="head.laminator.liquid"/></title>
			</c:when>
			<c:when test="${tp.equals('Планшетный ламинатор')}">
				<p><spring:message code="head.laminator.flatbed_laminating_machine"/></p>
				<title><spring:message code="head.laminator.flatbed_laminating_machine"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>