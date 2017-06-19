<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/use_with_products' />"><custom:getDescriptionByLocale description="${descriptions.useWithProducts}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Чернила для струйной печати')}">
				<p><custom:getDescriptionByLocale description="${descriptions.useWithProducts_ink_for_inkjet}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.useWithProducts_ink_for_inkjet}"/></title>
			</c:when>
			<c:when test="${tp.equals('Расходные материалы для цифрового оборудования')}">
				<p><custom:getDescriptionByLocale description="${descriptions.useWithProducts_consumables_for_digital_equipment}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.useWithProducts_consumables_for_digital_equipment}"/></title>
			</c:when>
			<c:when test="${tp.equals('Расходные материалы для 3D оборудования')}">
				<p><custom:getDescriptionByLocale description="${descriptions.useWithProducts_consumables_for_3D_equipment}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.useWithProducts_consumables_for_3D_equipment}"/></title>
			</c:when>
			<c:when test="${tp.equals('Товары для обслуживания')}">
				<p><custom:getDescriptionByLocale description="${descriptions.useWithProducts_products_for_maintenance}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.useWithProducts_products_for_maintenance}"/></title>
			</c:when>
			<c:when test="${tp.equals('Запчасти и комплектующие')}">
				<p><custom:getDescriptionByLocale description="${descriptions.useWithProducts_parts_and_accessories}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.useWithProducts_parts_and_accessories}"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>