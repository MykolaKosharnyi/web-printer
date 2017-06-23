<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_scanner.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/scanner.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user/search.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					ПРИМЕНИТЬ
				</a>
				<a class="reset" href="<c:url value='/scanners' />">
					СБРОСИТЬ
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/scanners/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
		
		<jsp:include page="../search/price.jsp" />
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип сканера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.type_product}" path="typeProduct" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина сканирования</p>
			</div>
			<div class="check_boxes">
				<div id="tabs">
					<ul>
						<li>миллиметр</li>
						<li>дюйм</li>
						<!--<li>формат</li>-->
					</ul>
					<div>
						<div>
							<form:checkboxes items="${scanner.scanning_width}" path="scanningWidth" element="li" />
						</div>
					    <div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="305" id="weightPrintMM_12"></input>
								<label for="weightPrintMM_12">12"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="457" id="weightPrintMM_18"></input>
								<label for="weightPrintMM_18">18"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="610" id="weightPrintMM_24"></input>
								<label for="weightPrintMM_24">24"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="914" id="weightPrintMM_36"></input>
								<label for="weightPrintMM_36">36"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="1070" id="weightPrintMM_42"></input>
								<label for="weightPrintMM_42">42"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="1524" id="weightPrintMM_60"></input>
								<label for="weightPrintMM_60">60"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="1550" id="weightPrintMM_61"></input>
								<label for="weightPrintMM_61">61"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="1600" id="weightPrintMM_63"></input>
								<label for="weightPrintMM_63">63"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="1800" id="weightPrintMM_71"></input>
								<label for="weightPrintMM_71">71"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="2500" id="weightPrintMM_98"></input>
								<label for="weightPrintMM_98">98"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="2540" id="weightPrintMM_100"></input>
								<label for="weightPrintMM_100">100"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="2600" id="weightPrintMM_102"></input>
								<label for="weightPrintMM_102">102"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="3200" id="weightPrintMM_126"></input>
								<label for="weightPrintMM_126">126"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="scanningWidth" value="3300" id="weightPrintMM_130"></input>
								<label for="weightPrintMM_130">130"</label>
							</div>
						</div>
						<!--<div>
							<li><input type="checkbox" name="weightPrintMM">A0</input></li>
							<li><input type="checkbox" name="weightPrintMM">A1</input></li>
							<li><input type="checkbox" name="weightPrintMM">A2</input></li>
							<li><input type="checkbox" name="weightPrintMM">A3</input></li>
							<li><input type="checkbox" name="weightPrintMM">A3+</input></li>
							<li><input type="checkbox" name="weightPrintMM">B0</input></li>
							<li><input type="checkbox" name="weightPrintMM">B1</input></li>
						</div> 
						  -->
					</div>
				</div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Б/У оборудование</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.previously_used}" path="previouslyUsed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Подача</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.innings}" path="innings" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Цветность</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.chromaticity}" path="chromaticity" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Сканирующий элемент</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.scanning_element}" path="scanningElement" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Источник света</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.light_source}" path="lightSource" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Разрядность цветного сканирования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.bit_color_scanning}" path="bitColorScanning" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Разрядность сканирования с оттенками серого</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.bit_scanning_grayscale}" path="bitScanningGrayscale" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Программное разрешение, dpi</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="softwareResolution0" class="amount-softwareResolution0" value="${search.softwareResolution0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="softwareResolution1" class="amount-softwareResolution1" value="${search.softwareResolution1}" />
				</div>
				<div class="slider-range-softwareResolution"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость сканирования, м.кв./ч.</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="scanSpeed0" class="amount-scanSpeed0" value="${search.scanSpeed0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="scanSpeed1" class="amount-scanSpeed1" value="${search.scanSpeed1}" />
				</div>
				<div class="slider-range-scanSpeed"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Оптическое разрешение</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.optical_resolution}" path="opticalResolution" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Интерфейс подключения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.connection_interface}" path="connectionInterface" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная толщина  носителя, мм</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="theMaximumThicknessOfTheCarrier0" class="amount-theMaximumThicknessOfTheCarrier0" value="${search.theMaximumThicknessOfTheCarrier0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="theMaximumThicknessOfTheCarrier1" class="amount-theMaximumThicknessOfTheCarrier1" value="${search.theMaximumThicknessOfTheCarrier1}" />
				</div>
				<div class="slider-range-theMaximumThicknessOfTheCarrier"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Програмное обеспечение</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.software}" path="software" element="li" />
			</ul>
		</div>			
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanner.equipment_manufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>
		
		<jsp:include page="../search/general_characteristics.jsp" />

			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				ПРИМЕНИТЬ
			</a>
			<a class="reset" href="<c:url value='/scanners' />">
				СБРОСИТЬ
			</a>
		</form:form>
	</div>
