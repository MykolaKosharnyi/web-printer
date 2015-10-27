<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="POST" commandName="searchPrintersCriteria" action="<c:url value='/printers/searching' />">
	<div id="display_search">
		<i class="opened"></i>
		<p>Критерии поиска</p>
	</div>

	<div id="search_printer">
		<div class="search_criteria">
			<div class="block_title">
				<i class="opened"></i>
				<p>Цена</p>
			</div>
			<ul class="check_boxes" style="display: block;">
				<div class="text_output">
					<p>$</p>
					<form:input path="prise0" class="amount-prise0" value="0" />
					<p>-&nbsp; $</p>
					<form:input path="prise1" class="amount-prise1" value="100000" />
				</div>

				<div class="slider">
					<div class="slider-range-prise"></div>
				</div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип принтера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typePrinter}" path="typePrinter"
					element="li" />
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
						<!-- 					<div>
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
				<form:checkboxes items="${previouslyUsed}" path="previouslyUsed"
					element="li" />
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
				<form:checkboxes items="${chromaticity}" path="chromaticity"
					element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель печатающей головки</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${manufacturerPrinthead}"
					path="manufacturerPrinthead" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип печатающей головки</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typeOfPrinthead}" path="typeOfPrinthead"
					element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Совместимые чернила</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${compatibleInk}" path="compatibleInk"
					element="li" />
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
					<form:input path="speedPrint0" class="amount-speed-print0"
						value="0" />
					<p>&nbsp;м.кв./ч. -&nbsp;</p>
					<form:input path="speedPrint1" class="amount-speed-print1" value="" />
					<p>&nbsp;м.кв./ч.</p>
				</div>

				<div class="slider">
					<div class="slider-range-speed-print"></div>
				</div>
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
				<form:checkboxes items="${equipmentManufacturer}"
					path="equipmentManufacturer" element="li" />
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
					<form:input path="maximumMediaThickness60_0"
						class="amount-maximum_media_thickness60_0" value="0" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="maximumMediaThickness60_1"
						class="amount-maximum_media_thickness60_1" value="60" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider">
					<div class="slider-range-maximum_media_thickness60"></div>
				</div>
				<br>
				<div class="text_output">
					<form:input path="maximumMediaThickness500_0"
						class="amount-maximum_media_thickness500_0" value="60" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="maximumMediaThickness500_1"
						class="amount-maximum_media_thickness500_1" value="500" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider">
					<div class="slider-range-maximum_media_thickness500"></div>
				</div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальный вес носителя</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maximumWeightOfVehicle0"
						class="amount-maximum_weight_of_vehicle0" value="5" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="maximumWeightOfVehicle1"
						class="amount-maximum_weight_of_vehicle1" value="500" />
					<p>&nbsp;кг</p>
				</div>
				<div class="slider">
					<div class="slider-range-maximum_weight_of_vehicle"></div>
				</div>
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
					<form:input path="maxPowerConsumption0"
						class="amount-max_power_consumption0" value="1" />
					<p>&nbsp;кВт -&nbsp;</p>
					<form:input path="maxPowerConsumption1"
						class="amount-max_power_consumption1" value="100" />
					<p>&nbsp;кВт</p>
				</div>
				<div class="slider">
					<div class="slider-range-max_power_consumption"></div>
				</div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Вес</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="weight0" class="amount-weight0" value="50" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="weight1" class="amount-weight1" value="5000" />
					<p>&nbsp;кг</p>
				</div>
				<div class="slider">
					<div class="slider-range-weight"></div>
				</div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="width0" class="amount-width0" value="0" />
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="width1" class="amount-width1" value="10" />
					<p>&nbsp;м</p>
				</div>
				<div class="slider">
					<div class="slider-range-width"></div>
				</div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Высота</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="heigth0" class="amount-heigth0" value="0" />
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="heigth1" class="amount-heigth1" value="10" />
					<p>&nbsp;м</p>
				</div>
				<div class="slider">
					<div class="slider-range-heigth"></div>
				</div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Глубина</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="depth0" class="amount-depth0" value="0" />
					<p>&nbsp;м -&nbsp;</p>
					<form:input path="depth1" class="amount-depth1" value="10" />
					<p>&nbsp;м</p>
				</div>
				<div class="slider">
					<div class="slider-range-depth"></div>
				</div>
			</ul>
		</div>
	</div>
	<input type="submit" value="показать" />
</form:form>