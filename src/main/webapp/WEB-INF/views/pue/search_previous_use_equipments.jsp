<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_digital_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/pue.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					ПРИМЕНИТЬ
				</a>
				<a class="reset" href="<c:url value='/previous_use_equipments' />">
					СБРОСИТЬ
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/previous_use_equipments/search" ></c:url>
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

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Принтер</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип принтера</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typePrinter}" path="typePrinter" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printerEquipment}" path="printerEquipment" element="li" />
					</ul>
				</div>
			</ul>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>3D Принтер</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип принтера</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${type3dPrinter}" path="type3dPrinter" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${d3PrinterEquipment}" path="d3PrinterEquipment" element="li" />
					</ul>
				</div>
			</ul>
		</div>

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Цыфровое оборудование</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип оборудования</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typeDigitalPrinter}" path="typeDigitalPrinter" element="li" />
					</ul>
				</div>
				<!--  <div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${d3PrinterEquipment}" path="d3PrinterEquipment" element="li" />
					</ul>
				</div>-->
			</ul>
		</div>		

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Ламинатор</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип ламинатора</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typeLaminator}" path="typeLaminator" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${laminatorEquipment}" path="laminatorEquipment" element="li" />
					</ul>
				</div>
			</ul>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Лазер</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип лазера</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typeLaser}" path="typeLaser" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${laserEquipment}" path="laserEquipment" element="li" />
					</ul>
				</div>
			</ul>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Фрезер/Гравер</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип фрезера/гравера</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typeCutter}" path="typeCutter" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${cutterEquipment}" path="cutterEquipment" element="li" />
					</ul>
				</div>
			</ul>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Сканера</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип сканера</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typeScanner}" path="typeScanner" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${scannerEquipment}" path="scannerEquipment" element="li" />
					</ul>
				</div>
			</ul>
		</div>

			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				ПРИМЕНИТЬ
			</a>
			<a class="reset" href="<c:url value='/previous_use_equipments' />">
				СБРОСИТЬ
			</a>
		</form:form>
	</div>