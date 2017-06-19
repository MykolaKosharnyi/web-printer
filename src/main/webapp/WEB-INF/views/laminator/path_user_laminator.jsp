<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">

	 <a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/laminators' />"><custom:getDescriptionByLocale description="${descriptions.laminators}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<c:forEach items="${product.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${product.typeProduct.equals('Горячего ламинирования')}">
				<a href="<c:url value='/laminators/hot_lamination' />"><custom:getDescriptionByLocale description="${descriptions.laminators_hot_lamination}"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Холодного ламинирования')}">
				<a href="<c:url value='/laminators/cold_laminating' />"><custom:getDescriptionByLocale description="${descriptions.laminators_cold_laminating}"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Жидкостные')}">
				<a href="<c:url value='/laminators/liquid' />"><custom:getDescriptionByLocale description="${descriptions.laminators_liquid}"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Планшетный ламинатор')}">
				<a href="<c:url value='/laminators/flatbed_laminating_machine' />"><custom:getDescriptionByLocale description="${descriptions.laminators_flatbed_laminating_machine}"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>