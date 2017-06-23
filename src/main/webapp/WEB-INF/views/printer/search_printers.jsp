<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/printer.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user/search.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					ПРИМЕНИТЬ
				</a>
				<a class="reset" href="<c:url value='/printers' />">
					СБРОСИТЬ
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/printers/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
	
		<jsp:include page="../search/price.jsp" />
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип принтера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.type_printer}" path="typePrinter" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Б/У оборудование</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.previously_used}" path="previouslyUsed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина печати</p>
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
							<form:checkboxes items="${printer.weight_print_mm}" path="weightPrintMM" element="li" />
							
							<div class="text_output">
								<form:input path="weightPrintMMRangeFrom" class="amount-weightPrintMMRangeFrom" value="${search.weightPrintMMRangeFrom}" />
								<p>&nbsp;-&nbsp;</p>
								<form:input path="weightPrintMMRangeUntil" class="amount-weightPrintMMRangeUntil" value="${search.weightPrintMMRangeUntil}" />
							</div>
								<div class="slider-range-weightPrintMMRange"></div>
						</div>
					    					    <div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="305" id="weightPrintMM_12"></input>
								<label for="weightPrintMM_12">12"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="457" id="weightPrintMM_18"></input>
								<label for="weightPrintMM_18">18"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="610" id="weightPrintMM_24"></input>
								<label for="weightPrintMM_24">24"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="914" id="weightPrintMM_36"></input>
								<label for="weightPrintMM_36">36"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="1070" id="weightPrintMM_42"></input>
								<label for="weightPrintMM_42">42"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="1524" id="weightPrintMM_60"></input>
								<label for="weightPrintMM_60">60"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="1550" id="weightPrintMM_61"></input>
								<label for="weightPrintMM_61">61"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="1600" id="weightPrintMM_63"></input>
								<label for="weightPrintMM_63">63"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="1800" id="weightPrintMM_71"></input>
								<label for="weightPrintMM_71">71"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="2500" id="weightPrintMM_98"></input>
								<label for="weightPrintMM_98">98"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="2540" id="weightPrintMM_100"></input>
								<label for="weightPrintMM_100">100"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="2600" id="weightPrintMM_102"></input>
								<label for="weightPrintMM_102">102"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="3200" id="weightPrintMM_126"></input>
								<label for="weightPrintMM_126">126"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="weightPrintMM" value="3300" id="weightPrintMM_130"></input>
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
				<p>Расширение печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.printing_extension}" path="printingExtension" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип печати</p>
			</div>
			<ul class="check_boxes">			
				<form:checkboxes items="${printer.type_print}" path="typePrint" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Цветность</p>
			</div>
			<ul class="check_boxes">			
				<form:checkboxes items="${printer.chromaticity}" path="chromaticity" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Совместимые чернила</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.compatible_ink}" path="compatibleInk" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.equipment_manufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Печатающая головка</p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.manufacturer_printhead}" path="manufacturerPrinthead" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип капли</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.type_drops}" path="typeDrops" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Размер капли</p>
					</div>
					<div class="check_boxes">
						<form:checkboxes items="${printer.size_drops}" path="sizeDrops" element="li" />
						<div class="text_output">
							<form:input path="sizeDropRangeFrom" class="amount-sizeDropRangeFrom" value="${search.sizeDropRangeFrom}" />
							<p>&nbsp;pl -&nbsp;</p>
							<form:input path="sizeDropRangeUntil" class="amount-sizeDropRangeUntil" value="${search.sizeDropRangeUntil}" />
							<p>&nbsp;pl</p>
						</div>
						<div class="slider-range-size-drop"></div>
					</div>
				</div>
			</div>
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
											
										<input class="check_print_head" type="checkbox" name="typeOfPrintheadSeries" value="${value.series}"
											id="${value.series}_${item.name}"/>
										<label class="print_series" for="${value.series}_${item.name}">${value.series}</label>
												
											
										<div class="inner_block_print_head" style="display: none; left:10px; position: relative;">
											<form:checkboxes items="${value.values}" path="typeOfPrinthead" element="li" />
										</div>
										
									</div>
								</c:if>
										
								<c:if test="${value.getClass().simpleName == 'String'}">
									<li>
										<input type="checkbox" name="typeOfPrinthead" value="${value}"
											id="${value}_${item.name}"/>
										<label for="${value}_${item.name}">${value}</label>
									</li>
								</c:if>
		  					</c:forEach>
		  						
						</ul>
					</div>				
						
		  		</c:forEach>
			</ul>
		</div>
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Скорость и разрешение печати</p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Скорость печати, м.кв./ч.</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="speedPrint0" class="amount-speed-print0" value="${search.speedPrint0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="speedPrint1" class="amount-speed-print1" value="${search.speedPrint1}" />
						</div>
						<div class="slider-range-speed-print"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Разрешение печати</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.print_resolution}" path="printResolution" element="li" />
					</ul>
				</div>
			</div>
		</div>
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Материал</p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Подача метериала</p>
					</div>
					<ul class="check_boxes">			
						<form:checkboxes items="${printer.feeds}" path="feed" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Максимальная толщина носителя</p>
					</div>
					<div class="check_boxes">
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
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Максимальный вес носителя</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="maximumWeightOfVehicle0" class="amount-maximum_weight_of_vehicle0" value="${search.maximumWeightOfVehicle0}" />
							<p>&nbsp;кг -&nbsp;</p>
							<form:input path="maximumWeightOfVehicle1" class="amount-maximum_weight_of_vehicle1" value="${search.maximumWeightOfVehicle1}" />
							<p>&nbsp;кг</p>
						</div>
						<div class="slider-range-maximum_weight_of_vehicle"></div>
					</div>
				</div>
			</div>
		</div>
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Характеристики ПО</p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Програмное обеспечение</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.rip}" path="rip" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.interface_connection}" path="interfaceConnection" element="li" />
					</ul>
				</div>
			</div>
		</div>
		
		<jsp:include page="../search/general_characteristics.jsp" />

			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				ПРИМЕНИТЬ
			</a>
			<a class="reset" href="<c:url value='/printers' />">
				СБРОСИТЬ
			</a>
		</form:form>
	</div>
