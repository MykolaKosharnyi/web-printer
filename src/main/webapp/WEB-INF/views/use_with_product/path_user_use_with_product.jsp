<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/use_with_products' />"><spring:message code="head.useWithProduct"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
		<c:choose>
			<c:when test="${product.typeProduct.equals('Чернила для струйной печати')}">
				<a href="<c:url value='/use_with_products/ink_for_inkjet' />"><spring:message code="head.useWithProduct.ink_for_inkjet"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Расходные материалы для цифрового оборудования')}">
				<a href="<c:url value='/use_with_products/consumables_for_digital_equipment' />"><spring:message code="head.useWithProduct.consumables_for_digital_equipment"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Расходные материалы для 3D оборудования')}">
				<a href="<c:url value='/use_with_products/consumables_for_3D_equipment' />"><spring:message code="head.useWithProduct.consumables_for_3D_equipment"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Товары для обслуживания')}">
				<a href="<c:url value='/use_with_products/products_for_maintenance' />"><spring:message code="head.useWithProduct.products_for_maintenance"/></a>
			</c:when>
			<c:when test="${product.typeProduct.equals('Запчасти и комплектующие')}">
				<a href="<c:url value='/use_with_products/parts_and_accessories' />"><spring:message code="head.useWithProduct.parts_and_accessories"/></a>
			</c:when>
		</c:choose>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>