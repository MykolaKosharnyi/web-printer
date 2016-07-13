<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/laminators' />"><spring:message code="head.laminator"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<c:forEach items="${product.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${product.typeProduct.equals('Горячего ламинирования')}">
				<a href="<c:url value='/laminators/hot_lamination' />"><spring:message code="head.laminator.hot_lamination"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Холодного ламинирования')}">
				<a href="<c:url value='/laminators/cold_laminating' />"><spring:message code="head.laminator.cold_laminating"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Жидкостные')}">
				<a href="<c:url value='/laminators/liquid' />"><spring:message code="head.laminator.liquid"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>