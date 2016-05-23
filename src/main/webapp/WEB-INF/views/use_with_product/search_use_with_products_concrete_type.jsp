<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_cutter.css">
    <link rel="stylesheet" href="/css/search.css">
    
    <script src="<%=request.getContextPath()%>/resources/js/user/use_with_product.js"></script>

	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">ПРИМЕНИТЬ</a>
				
			<c:if test="${search.typeProduct[0].equals('Чернила для струйной печати')}">
				<a class="reset" href="<c:url value='/use_with_products/ink_for_inkjet' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typeProduct[0].equals('Расходные материалы для цифрового оборудования')}">
				<a class="reset" href="<c:url value='/use_with_products/consumables_for_digital_equipment' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typeProduct[0].equals('Расходные материалы для 3D оборудования')}">
				<a class="reset" href="<c:url value='/use_with_products/consumables_for_3D_equipment' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typeProduct[0].equals('Товары для обслуживания')}">
				<a class="reset" href="<c:url value='/use_with_products/products_for_maintenance' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typeProduct[0].equals('Запчасти и комплектующие')}">
				<a class="reset" href="<c:url value='/use_with_products/parts_and_accessories' />">СБРОСИТЬ</a>
			</c:if>
			
	<div id="search_product">
	<c:url var="product_search" value="/use_with_products/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
		<div class="search_criteria">
			<div class="block_title">
				<i class="opened"></i>
				<p>Цена</p>
			</div>
			<ul class="check_boxes" style="display: block;">
				<div class="text_output">
					<p>$</p>
					<form:input path="prise0" class="amount-prise0" value="${search.prise0}" />
					<p>&nbsp;-&nbsp; $</p>
					<form:input path="prise1" class="amount-prise1" value="${search.prise1}" />
				</div>
				<div class="slider-range-prise"/>
			</ul>
		</div>
		<div class="search_criteria" style="display: none;">
			<div class="block_title">
				<i></i>
				<p>Тип товара</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${use_with_product.type_product}" path="typeProduct" element="li" />
			</ul>
		</div>
		
			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">ПРИМЕНИТЬ</a>
				
			<c:if test="${search.typeProduct[0].equals('Чернила для струйной печати')}">
				<a class="reset" href="<c:url value='/use_with_products/ink_for_inkjet' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typeProduct[0].equals('Расходные материалы для цифрового оборудования')}">
				<a class="reset" href="<c:url value='/use_with_products/consumables_for_digital_equipment' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typeProduct[0].equals('Расходные материалы для 3D оборудования')}">
				<a class="reset" href="<c:url value='/use_with_products/consumables_for_3D_equipment' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typeProduct[0].equals('Товары для обслуживания')}">
				<a class="reset" href="<c:url value='/use_with_products/products_for_maintenance' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typeProduct[0].equals('Запчасти и комплектующие')}">
				<a class="reset" href="<c:url value='/use_with_products/parts_and_accessories' />">СБРОСИТЬ</a>
			</c:if>
			
		</form:form>
	</div>