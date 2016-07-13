<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><spring:message code="path.head_page"/>я</a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/scanners' />"><spring:message code="head.scanner"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>

	<c:forEach items="${search.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Широкоформатные сканеры')}">	
				<p><spring:message code="head.scanner.large_format_scanners"/></p>
			</c:when>
			
			<c:when test="${tp.equals('3D Сканеры')}">	
				<p><spring:message code="head.scanner.3d_scanners"/></p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>