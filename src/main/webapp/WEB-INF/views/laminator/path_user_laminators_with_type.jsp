<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />">Главная</a>
	<span> > </span>
	<a href="<c:url value='/laminators' />"><spring:message code="head.laminator"/></a>
	<span> > </span>

	<c:forEach items="${search.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Горячего ламинирования')}">	
				<p><spring:message code="head.laminator.hot_lamination"/></p>
			</c:when>
			<c:when test="${tp.equals('Холодного ламинирования')}">
				<p><spring:message code="head.laminator.cold_laminating"/></p>
			</c:when>
			<c:when test="${tp.equals('Жидкостные')}">
				<p><spring:message code="head.laminator.liquid"/></p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>