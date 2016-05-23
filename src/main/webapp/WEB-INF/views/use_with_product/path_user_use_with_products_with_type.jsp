<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />">Главная</a>
	<span> > </span>
	<a href="<c:url value='/use_with_products' />"><spring:message code="head.useWithProduct"/></a>
	<span> > </span>
	
	<c:forEach items="${search.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Чернила для струйной печати')}">
				<p><spring:message code="head.useWithProduct.ink_for_inkjet"/></p>
			</c:when>
			<c:when test="${tp.equals('Расходные материалы для цифрового оборудования')}">
				<p><spring:message code="head.useWithProduct.consumables_for_digital_equipment"/></p>
			</c:when>
			<c:when test="${tp.equals('Расходные материалы для 3D оборудования')}">
				<p><spring:message code="head.useWithProduct.consumables_for_3D_equipment"/></p>
			</c:when>
			<c:when test="${tp.equals('Товары для обслуживания')}">
				<p><spring:message code="head.useWithProduct.products_for_maintenance"/></p>
			</c:when>
			<c:when test="${tp.equals('Запчасти и комплектующие')}">
				<p><spring:message code="head.useWithProduct.parts_and_accessories"/></p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>