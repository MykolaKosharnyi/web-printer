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
				
						<input class="input_pue" type="checkbox" name="type" value="printer" id="printer_98">
							<p class="p_pue" for="printer_98">Принтер</p>
						</input>
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
				<input class="input_pue" type="checkbox" name="type" value="3d_printer" id="3d_printer_98">
					<p class="p_pue" for="3d_printer_98">3D Принтер</p>
				</input>
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
				<input class="input_pue" type="checkbox" name="type" value="digital_printer" id="digital_printer_98">
					<p class="p_pue" for="digital_printer_98">Цыфровое оборудование</p>
				</input>
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
				<input class="input_pue" type="checkbox" name="type" value="laminator" id="laminator_98">
					<p class="p_pue" for="laminator_98">Ламинатор</p>
				</input>
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
				<input class="input_pue" type="checkbox" name="type" value="laser" id="laser_98">
					<p class="p_pue" for="laser_98">Лазер</p>
				</input>
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
				<input class="input_pue" type="checkbox" name="type" value="cutter" id="cutter_98">
					<p class="p_pue" for="cutter_98">Фрезер/Гравер</p>
				</input>
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
				<input class="input_pue" type="checkbox" name="type" value="scanner" id="scanner_98">
					<p class="p_pue" for="scanner_98">Сканер</p>
				</input>
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