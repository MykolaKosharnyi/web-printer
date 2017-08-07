<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

    <link rel="stylesheet" href="/css/user/search_digital_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/pue.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p><custom:getDescriptionByLocale description="${d_search.filter_items}"/></p>
	</div>
	<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
		<custom:getDescriptionByLocale description="${d_search.apply}"/>
	</a>
	<a class="reset" href="<c:url value='/previous_use_equipments' />">
		<custom:getDescriptionByLocale description="${d_search.reset}"/>
	</a>
	<div id="search_product">
	<c:url var="product_search" value="/previous_use_equipments/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
		
		<jsp:include page="../search/price.jsp" />

		<div class="block_search_criteria">
			<div class="block_block_title">		
				<input class="input_pue" type="checkbox" name="type" value="printer" id="printer_98"/>			
				<p class="p_pue" for="printer_98"><custom:getDescriptionByLocale description="${descriptions.printers}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.printer_type}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="typePrinter" properties="${typePrinter}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.manufacturer}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printerEquipment}" path="printerEquipment" element="li" />
					</ul>
				</div>
			</div>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<input class="input_pue" type="checkbox" name="type" value="3d_printer" id="3d_printer_98">
				<p class="p_pue" for="3d_printer_98"><custom:getDescriptionByLocale description="${descriptions.printers_3d}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.printer_type}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="type3dPrinter" properties="${type3dPrinter}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.manufacturer}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${d3PrinterEquipment}" path="d3PrinterEquipment" element="li" />
					</ul>
				</div>
			</div>
		</div>

		<div class="block_search_criteria">
			<div class="block_block_title">
				<input class="input_pue" type="checkbox" name="type" value="digital_printer" id="digital_printer_98">
					<p class="p_pue" for="digital_printer_98"><custom:getDescriptionByLocale description="${descriptions.digital_printers}"/></p>
				</input>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.type_equipment}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="typeDigitalPrinter" properties="${typeDigitalPrinter}"/>
					</ul>
				</div>
				<!--  <div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.manufacturer}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${d3PrinterEquipment}" path="d3PrinterEquipment" element="li" />
					</ul>
				</div>-->
			</div>
		</div>		

		<div class="block_search_criteria">
			<div class="block_block_title">
				<input class="input_pue" type="checkbox" name="type" value="laminator" id="laminator_98">
					<p class="p_pue" for="laminator_98"><custom:getDescriptionByLocale description="${descriptions.laminators}"/></p>
				</input>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.type_laminator}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="typeLaminator" properties="${typeLaminator}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.manufacturer}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${laminatorEquipment}" path="laminatorEquipment" element="li" />
					</ul>
				</div>
			</div>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<input class="input_pue" type="checkbox" name="type" value="laser" id="laser_98">
					<p class="p_pue" for="laser_98"><custom:getDescriptionByLocale description="${descriptions.lasers}"/></p>
				</input>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.laser_type}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="typeLaser" properties="${typeLaser}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.manufacturer}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${laserEquipment}" path="laserEquipment" element="li" />
					</ul>
				</div>
			</div>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<input class="input_pue" type="checkbox" name="type" value="cutter" id="cutter_98">
					<p class="p_pue" for="cutter_98"><custom:getDescriptionByLocale description="${descriptions.cutters}"/></p>
				</input>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.type_router_engraver}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="typeCutter" properties="${typeCutter}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.manufacturer}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${cutterEquipment}" path="cutterEquipment" element="li" />
					</ul>
				</div>
			</div>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<input class="input_pue" type="checkbox" name="type" value="scanner" id="scanner_98">
					<p class="p_pue" for="scanner_98"><custom:getDescriptionByLocale description="${descriptions.scanners}"/></p>
				</input>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.scanner_type}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="typeScanner" properties="${typeScanner}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_pue.manufacturer}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${scannerEquipment}" path="scannerEquipment" element="li" />
					</ul>
				</div>
			</div>
		</div>

			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				<custom:getDescriptionByLocale description="${d_search.apply}"/>
			</a>
			<a class="reset" href="<c:url value='/previous_use_equipments' />">
				<custom:getDescriptionByLocale description="${d_search.reset}"/>
			</a>
		</form:form>
	</div>