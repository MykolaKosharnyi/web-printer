<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/scanners' />"><spring:message code="head.scanner"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
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
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>