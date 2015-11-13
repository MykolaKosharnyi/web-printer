<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/search.css">

	<div id="display_search">
		<i class="opened"></i>
		<p>Критерии поиска</p>
	</div>

	<div id="search_product">
	<form:form method="POST" commandName="search" action="/nk/printers/search">
			<input type="submit" value="показать" />
		<div class="search_criteria">
			<div class="block_title">
				<i class="opened"></i>
				<p>Цена</p>
			</div>
			<ul class="check_boxes" style="display: block;">
				<div class="text_output">
					<p>$</p>
					<form:input path="prise0" class="amount-prise0" value="${search.prise0}" />
					<p>-&nbsp; $</p>
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
				<form:checkboxes items="${typePrinter}" path="typePrinter" element="li" />
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
						<li>формат</li>
					</ul>
					<div>
						<div>
							<form:checkboxes items="${weightPrintMM}" path="weightPrintMM"
								element="li" />
						</div>
					<!--<div>
							<li><input type="checkbox" name="radio_weight_print_inch">24</input></li>
							<li><input type="checkbox" name="radio_weight_print_inch">36</input></li>
							<li><input type="checkbox" name="radio_weight_print_inch">42</input></li>
							<li><input type="checkbox" name="radio_weight_print_inch">60</input></li>
							<li><input type="checkbox" name="radio_weight_print_inch">70</input></li>
							<li><input type="checkbox" name="radio_weight_print_inch">100</input></li>
						</div>
						<div>
							<li><input type="checkbox" name="radio_weight_print_format">A0</input></li>
							<li><input type="checkbox" name="radio_weight_print_format">A1</input></li>
							<li><input type="checkbox" name="radio_weight_print_format">A2</input></li>
							<li><input type="checkbox" name="radio_weight_print_format">A3</input></li>
							<li><input type="checkbox" name="radio_weight_print_format">A3+</input></li>
							<li><input type="checkbox" name="radio_weight_print_format">B0</input></li>
							<li><input type="checkbox" name="radio_weight_print_format">B1</input></li>
						</div> -->
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
				<p>Тип печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typePrint}" path="typePrint" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Подача метериала</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${feeds}" path="feed" element="li" />
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
				<p>Производитель печатающей головки</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${manufacturerPrinthead}" path="manufacturerPrinthead" element="li" />
			</ul>
		</div> 
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип печатающей головки</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typeOfPrinthead}" path="typeOfPrinthead" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Совместимые чернила</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${compatibleInk}" path="compatibleInk" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип капли</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typeDrops}" path="typeDrops" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Размер капли</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${sizeDrops}" path="sizeDrops" element="li" />
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
				<form:checkboxes items="${printResolution}" path="printResolution"
					element="li" />
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
				<p>Интерфейс подключения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${interfaceConnection}"
					path="interfaceConnection" element="li" />
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
				<form:checkboxes items="${rip}" path="rip" element="li" />
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
					<p>&nbsp;кВт -&nbsp;</p>
					<form:input path="maxPowerConsumption1" class="amount-max_power_consumption1" value="${search.maxPowerConsumption1}" />
					<p>&nbsp;кВт</p>
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
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="width1" class="amount-width1" value="${search.width1}" />
					<p>&nbsp;м</p>
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
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="heigth1" class="amount-heigth1" value="${search.heigth1}" />
					<p>&nbsp;м</p>
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
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="depth1" class="amount-depth1" value="${search.depth1}" />
					<p>&nbsp;м</p>
				</div>
					<div class="slider-range-depth"></div>
			</ul>
		</div>
		</form:form>
	</div>
 	<script>	
		$(document).ready(function() {
			
			$('#search').ajaxForm( {
				type: 'post',
				success: function(products) { 
					$("#out_result_of_search").empty();
					
	                $(products).each(function(i, product) {
	                	$("#out_result_of_search").append(
	                			$('<a/>').addClass("products").attr("href", "/nk/printer/" + product.id)
	                				.append($('<div/>').addClass("products_image").append($('<img/>')
	                						.attr("src", "/nk/resources/images/printers/" + product.id + "/" + product.pathPictures[0])))
	                				.append($('<p/>').addClass("products_title").text(product.name))
	                				.append($('<p/>').addClass("products_price").text(product.prise))
	                                .append($('<div/>').addClass("products_buy").append($('<img/>')
	                                		.attr("src", "/nk/resources/images/button_buy.jpg")))		
	                            )//end $("#out_result_of_search").append()
	                });
				}
				
				}); 
		});
		</script> 