<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />">Главная</a>
	 <span> > </span>
	 <a href="<c:url value='/scanners' />"><spring:message code="head.scanner"/></a>
	 <span> > </span>
	<c:forEach items="${product.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${product.typeProduct.equals('Широкоформатные сканеры')}">
				<a href="<c:url value='/scanners/large_format_scanners' />"><spring:message code="head.scanner.large_format_scanners"/></a>
			</c:when>
			
			<c:when test="${product.typeProduct.equals('3D Сканеры')}">
				<a href="<c:url value='/scanners/3d_scanners' />"><spring:message code="head.scanner.3d_scanners"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span> > </span>
	<p>${product.name}</p>
</div>