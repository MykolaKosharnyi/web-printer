<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_scanner.css">
    <link rel="stylesheet" href="/css/search.css">
    
    <script src="<%=request.getContextPath()%>/resources/js/user/scanner.js"></script>

	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">ПРИМЕНИТЬ</a>
				
			<c:if test="${search.typeProduct[0].equals('Широкоформатные сканеры')}">
				<a class="reset" href="<c:url value='/scanners/large_format_scanners' />">СБРОСИТЬ</a>
			</c:if>
			
			<c:if test="${search.typeProduct[0].equals('3D Сканеры')}">
				<a class="reset" href="<c:url value='/scanners/3d_scanners' />">СБРОСИТЬ</a>
			</c:if>
			
	<div id="search_product">
	<c:url var="product_search" value="/scanners/search" ></c:url>
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
				<p>Тип сканера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typeProduct}" path="typeProduct" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина сканирования</p>
			</div>
			<ul class="check_boxes">
				<div id="tabs">
					<ul>
						<li>миллиметр</li>
						<li>дюйм</li>
						<li>формат</li>
					</ul>
					<div>
						<div>
							<form:checkboxes items="${scanningWidth}" path="scanningWidth" element="li" />
						</div>
					    <div>
							<li><input type="checkbox" name="weightPrintMM" value="305" id="weightPrintMM_12"><label for="weightPrintMM_12">12"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="457" id="weightPrintMM_18"><label for="weightPrintMM_18">18"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="610" id="weightPrintMM_24"><label for="weightPrintMM_24">24"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="914" id="weightPrintMM_36"><label for="weightPrintMM_36">36"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1070" id="weightPrintMM_42"><label for="weightPrintMM_42">42"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1524" id="weightPrintMM_60"><label for="weightPrintMM_60">60"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1550" id="weightPrintMM_61"><label for="weightPrintMM_61">61"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1600" id="weightPrintMM_63"><label for="weightPrintMM_63">63"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1800" id="weightPrintMM_71"><label for="weightPrintMM_71">71"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="2500" id="weightPrintMM_98"><label for="weightPrintMM_98">98"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="2540" id="weightPrintMM_100"><label for="weightPrintMM_100">100"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="2600" id="weightPrintMM_102"><label for="weightPrintMM_102">102"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="3200" id="weightPrintMM_126"><label for="weightPrintMM_126">126"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="3300" id="weightPrintMM_130"><label for="weightPrintMM_130">130"</label></input></li>
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
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Б/У оборудование</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${previouslyUsed}" path="previouslyUsed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Подача</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${innings}" path="innings" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Цветность</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${chromaticity}" path="chromaticity" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Сканирующий элемент</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${scanningElement}" path="scanningElement" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Источник света</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${lightSource}" path="lightSource" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Разрядность цветного сканирования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${bitColorScanning}" path="bitColorScanning" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Разрядность сканирования с оттенками серого</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${bitScanningGrayscale}" path="bitScanningGrayscale" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Программное разрешение, dpi</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="softwareResolution0" class="amount-softwareResolution0" value="${search.softwareResolution0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="softwareResolution1" class="amount-softwareResolution1" value="${search.softwareResolution1}" />
				</div>
					<div class="slider-range-softwareResolution"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость сканирования, м.кв./ч.</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="scanSpeed0" class="amount-scanSpeed0" value="${search.scanSpeed0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="scanSpeed1" class="amount-scanSpeed1" value="${search.scanSpeed1}" />
				</div>
					<div class="slider-range-scanSpeed"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Оптическое разрешение</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${opticalResolution}" path="opticalResolution" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Интерфейс подключения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${connectionInterface}" path="connectionInterface" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная толщина  носителя, мм</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="theMaximumThicknessOfTheCarrier0" class="amount-theMaximumThicknessOfTheCarrier0" value="${search.theMaximumThicknessOfTheCarrier0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="theMaximumThicknessOfTheCarrier1" class="amount-theMaximumThicknessOfTheCarrier1" value="${search.theMaximumThicknessOfTheCarrier1}" />
				</div>
					<div class="slider-range-theMaximumThicknessOfTheCarrier"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>П/О</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${software}" path="software" element="li" />
			</ul>
		</div>			
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${equipmentManufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Средняя потребляемая мощность</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="averagePowerConsumption0" class="amount-averagePowerConsumption0" value="${search.averagePowerConsumption0}" />
					<p>&nbsp;Вт -&nbsp;</p>
					<form:input path="averagePowerConsumption1" class="amount-averagePowerConsumption1" value="${search.averagePowerConsumption1}" />
					<p>&nbsp;Вт</p>
				</div>
					<div class="slider-range-averagePowerConsumption"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная потребляемая мощность</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maxPowerConsumption0" class="amount-max_power_consumption0" value="${search.maxPowerConsumption0}" />
					<p>&nbsp;Вт -&nbsp;</p>
					<form:input path="maxPowerConsumption1" class="amount-max_power_consumption1" value="${search.maxPowerConsumption1}" />
					<p>&nbsp;Вт</p>
				</div>
					<div class="slider-range-max_power_consumption"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Вес</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="weight0" class="amount-weight0" value="${search.weight0}" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="weight1" class="amount-weight1" value="${search.weight1}" />
					<p>&nbsp;кг</p>
				</div>
					<div class="slider-range-weight"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="width0" class="amount-width0" value="${search.width0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="width1" class="amount-width1" value="${search.width1}" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider-range-width"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Высота</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="heigth0" class="amount-heigth0" value="${search.heigth0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="heigth1" class="amount-heigth1" value="${search.heigth1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-heigth"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Глубина</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="depth0" class="amount-depth0" value="${search.depth0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="depth1" class="amount-depth1" value="${search.depth1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-depth"></div>
			</ul>
		</div>
				<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">ПРИМЕНИТЬ</a>
				
			<c:if test="${search.typeProduct[0].equals('Широкоформатные сканеры')}">
				<a class="reset" href="<c:url value='/scanners/large_format_scanners' />">СБРОСИТЬ</a>
			</c:if>
			
			<c:if test="${search.typeProduct[0].equals('3D Сканеры')}">
				<a class="reset" href="<c:url value='/scanners/3d_scanners' />">СБРОСИТЬ</a>
			</c:if>
			
		</form:form>
	</div>