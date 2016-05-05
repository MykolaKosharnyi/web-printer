<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
    <script src="<%=request.getContextPath()%>/resources/js/user/printer.js"></script>

	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">ПРИМЕНИТЬ</a>
				
			<c:if test="${search.typePrinter[0].equals('Сольвентный')}">
				<a class="reset" href="<c:url value='/printers/dissolving' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Экосольвентный')}">
				<a class="reset" href="<c:url value='/printers/ecosolvent' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('UV рулонный')}">
				<a class="reset" href="<c:url value='/printers/UV_roll' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('UV плоскопечатный')}">
				<a class="reset" href="<c:url value='/printers/UV_flatbed' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Сублимационный')}">
				<a class="reset" href="<c:url value='/printers/sublimation' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Текстильный')}">
				<a class="reset" href="<c:url value='/printers/textile' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Водный/Пигментный')}">
				<a class="reset" href="<c:url value='/printers/water_pigment' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Цифровый')}">
				<a class="reset" href="<c:url value='/printers/digital' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('САПР/ГИС')}">
				<a class="reset" href="<c:url value='/printers/SAPR-GIS' />">СБРОСИТЬ</a>
			</c:if>
			
	<div id="search_product">
	<c:url var="product_search" value="/printers/search" ></c:url>
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
				<p>Тип принтера</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.type_printer}" var="type">
					<li>
						<input type="checkbox" name="typePrinter" value="${type}" id="${type}_type"><label for="${type}_type">${type}</label></input>
					</li>
	  			</c:forEach>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина печати</p>
			</div>
			<ul class="check_boxes">
				<div id="tabs">
					<ul>
						<li>миллиметр</li>
						<li>дюйм</li>
						<!--<li>формат</li>-->
					</ul>
					<div>
						<div>
						<c:forEach items="${printer.weight_print_mm}" var="item">
							<li>
								<input type="checkbox" name="weightPrintMM" value="${item}"
								 id="${item}_weight_print"><label for="${item}_weight_print">${item}</label></input>
							</li>
	  					</c:forEach>

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
							<li><input type="checkbox" name="weightPrintMM" value="1900" id="weightPrintMM_75"><label for="weightPrintMM_75">75"</label></input></li>
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
				<c:forEach items="${printer.previously_used}" var="item">
					<li>
						<input type="checkbox" name="previouslyUsed" value="${item}" id="${item}_previously_used"><label for="${item}_previously_used">${item}</label></input>
					</li>
	  			</c:forEach>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип печати</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.type_print}" var="item">
					<li>
						<input type="checkbox" name="typePrint" value="${item}" id="${item}_type_print"><label for="${item}_type_print">${item}</label></input>
					</li>
	  			</c:forEach>			
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Подача метериала</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.feeds}" var="item">
					<li>
						<input type="checkbox" name="feed" value="${item}" id="${item}_feeds"><label for="${item}_feeds">${item}</label></input>
					</li>
	  			</c:forEach>			
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Цветность</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.chromaticity}" var="item">
					<li>
						<input type="checkbox" name="chromaticity" value="${item}" id="${item}_chromaticity"><label for="${item}_chromaticity">${item}</label></input>
					</li>
	  			</c:forEach>			
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель печатающей головки</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.manufacturer_printhead}" var="item">
					<li>
						<input type="checkbox" name="manufacturerPrinthead" value="${item}" id="${item}_manufacturer_printhead"><label for="${item}_manufacturer_printhead">${item}</label></input>
					</li>
	  			</c:forEach>
			</ul>
		</div> 

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Тип печатающей головки</p>
			</div>
			<ul class="block_check_boxes">
		
				<c:forEach items="${printer.type_of_printhead}" var="item">
				
					<div class="search_criteria">
						<div class="block_title">
							<i></i>
							<p>${item.name}</p>
						</div>
						<ul class="check_boxes">
						
							<c:forEach items="${item.values}" var="value">
								<c:if test="${value.getClass().simpleName != 'String'}">
									<div class="outer_type_print_head">
										
										<input class="check_print_head" type="checkbox" name="typeOfPrinthead" value="${value.series}"
										 id="${value.series}_${item.name}">
										<label class="print_series" for="${value.series}_${item.name}">${value.series}</label></input>
										
										
									<div class="inner_block_print_head" style="display: none; left:10px; position: relative;">
					
										<c:forEach items="${value.values}" var="value">
	  										<li>
												<input type="checkbox" name="typeOfPrinthead" value="${value}"
											 	id="${value}_${item.name}"><label for="${value}_${item.name}">${value}</label></input>
											</li>
	  									</c:forEach>

									</div>
									
									</div>
								</c:if>
								
								<c:if test="${value.getClass().simpleName == 'String'}">
									<li>
										<input type="checkbox" name="typeOfPrinthead" value="${value}"
										 id="${value}_${item.name}"><label for="${value}_${item.name}">${value}</label></input>
									</li>
								</c:if>
	  						</c:forEach>
	  						
						</ul>
					</div>				
				
	  			</c:forEach>
		
			</ul>
		</div>
	
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Совместимые чернила</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.compatible_ink}" var="item">
					<li>
						<input type="checkbox" name="compatibleInk" value="${item}" id="${item}_compatible_ink"><label for="${item}_compatible_ink">${item}</label></input>
					</li>
	  			</c:forEach>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип капли</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.type_drops}" var="item">
					<li>
						<input type="checkbox" name="typeDrops" value="${item}" id="${item}_type_drops"><label for="${item}_type_drops">${item}</label></input>
					</li>
	  			</c:forEach>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Размер капли</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${sizeDrops}" path="sizeDrops" element="li" />
				<div class="text_output">
					<form:input path="sizeDropRangeFrom" class="amount-sizeDropRangeFrom" value="${search.sizeDropRangeFrom}" />
					<p>&nbsp;pl -&nbsp;</p>
					<form:input path="sizeDropRangeUntil" class="amount-sizeDropRangeUntil" value="${search.sizeDropRangeUntil}" />
					<p>&nbsp;pl</p>
				</div>
					<div class="slider-range-size-drop"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость печати</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="speedPrint0" class="amount-speed-print0" value="${search.speedPrint0}" />
					<p>&nbsp;м.кв./ч. -&nbsp;</p>
					<form:input path="speedPrint1" class="amount-speed-print1" value="${search.speedPrint1}" />
					<p>&nbsp;м.кв./ч.</p>
				</div>
					<div class="slider-range-speed-print"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Разрешение печати</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.print_resolution}" var="item">
					<li>
						<input type="checkbox" name="printResolution" value="${item}" id="${item}_print_resolution"><label for="${item}_print_resolution">${item}</label></input>
					</li>
	  			</c:forEach>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.equipment_manufacturer}" var="item">
					<li>
						<input type="checkbox" name="equipmentManufacturer" value="${item}" id="${item}_equipment_manufacturer"><label for="${item}_equipment_manufacturer">${item}</label></input>
					</li>
	  			</c:forEach>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Интерфейс подключения</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.interface_connection}" var="item">
					<li>
						<input type="checkbox" name="interfaceConnection" value="${item}" id="${item}_interface_connection"><label for="${item}_interface_connection">${item}</label></input>
					</li>
	  			</c:forEach>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная толщина носителя</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maximumMediaThickness60_0" class="amount-maximum_media_thickness60_0" value="${search.maximumMediaThickness60_0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="maximumMediaThickness60_1" class="amount-maximum_media_thickness60_1" value="${search.maximumMediaThickness60_1}" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider-range-maximum_media_thickness60"></div>
				<br>
				<div class="text_output">
					<form:input path="maximumMediaThickness500_0" class="amount-maximum_media_thickness500_0" value="${search.maximumMediaThickness500_0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="maximumMediaThickness500_1" class="amount-maximum_media_thickness500_1" value="${search.maximumMediaThickness500_1}" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider-range-maximum_media_thickness500"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальный вес носителя</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maximumWeightOfVehicle0" class="amount-maximum_weight_of_vehicle0" value="${search.maximumWeightOfVehicle0}" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="maximumWeightOfVehicle1" class="amount-maximum_weight_of_vehicle1" value="${search.maximumWeightOfVehicle1}" />
					<p>&nbsp;кг</p>
				</div>
					<div class="slider-range-maximum_weight_of_vehicle"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>П/О RIP</p>
			</div>
			<ul class="check_boxes">
				<c:forEach items="${printer.rip}" var="item">
					<li>
						<input type="checkbox" name="rip" value="${item}" id="${item}_rip"><label for="${item}_rip">${item}</label></input>
					</li>
	  			</c:forEach>
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
				
			<c:if test="${search.typePrinter[0].equals('Сольвентный')}">
				<a class="reset" href="<c:url value='/printers/dissolving' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Экосольвентный')}">
				<a class="reset" href="<c:url value='/printers/ecosolvent' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('UV рулонный')}">
				<a class="reset" href="<c:url value='/printers/UV_roll' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('UV плоскопечатный')}">
				<a class="reset" href="<c:url value='/printers/UV_flatbed' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Сублимационный')}">
				<a class="reset" href="<c:url value='/printers/sublimation' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Текстильный')}">
				<a class="reset" href="<c:url value='/printers/textile' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Водный/Пигментный')}">
				<a class="reset" href="<c:url value='/printers/water_pigment' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('Цифровый')}">
				<a class="reset" href="<c:url value='/printers/digital' />">СБРОСИТЬ</a>
			</c:if>
			<c:if test="${search.typePrinter[0].equals('САПР/ГИС')}">
				<a class="reset" href="<c:url value='/printers/SAPR-GIS' />">СБРОСИТЬ</a>
			</c:if>
			
		</form:form>
	</div>