<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/search_printer_3d.css">
    <link rel="stylesheet" href="/css/search.css">
    
    <script src="<%=request.getContextPath()%>/resources/js/user/printer3d.js"></script>

	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					ПРИМЕНИТЬ
				</a>
				<a class="reset" href="<c:url value='/3d_printers' />">
					СБРОСИТЬ
				</a>
	<div id="search_product">
	<form:form method="POST" commandName="search" action="/3d_printers/search">
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
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип принтера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.type_printer_3d}" path="typePrinter3D" element="li" />
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
				<p>Размер запечатываемой области</p>
			</div>
			<ul class="check_boxes">
				<p style="float: none; margin: 10px auto 0px;"> По оси Х:</p>
				<div class="text_output">
					<form:input path="sizePrintableAreaX0" class="amount-sizePrintableAreaX0" value="${search.sizePrintableAreaX0}"/>
					<p >&nbsp;мм -&nbsp;</p>
					<form:input path="sizePrintableAreaX1" class="amount-sizePrintableAreaX1" value="${search.sizePrintableAreaX1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizePrintableAreaX"></div>

				<p style="float: none; margin: 10px auto 0px;"> По оси Y:</p>
				<div class="text_output">
					<form:input path="sizePrintableAreaY0" class="amount-sizePrintableAreaY0" value="${search.sizePrintableAreaY0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizePrintableAreaY1" class="amount-sizePrintableAreaY1" value="${search.sizePrintableAreaY1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizePrintableAreaY"></div>

				<p style="float: none; margin: 10px auto 0px;"> По оси Z:</p>
				<div class="text_output">
					<form:input path="sizePrintableAreaZ0" class="amount-sizePrintableAreaZ0" value="${search.sizePrintableAreaZ0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizePrintableAreaZ1" class="amount-sizePrintableAreaZ1" value="${search.sizePrintableAreaZ1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizePrintableAreaZ"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Технология печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.print_technology}" path="printTechnology" element="li" />
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
				<p>Тип печатающей головки</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.type_of_printhead}" path="typeOfPrinthead" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Температура плавления печатного материала</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="meltingPointOfThePrintingMaterial0" class="amount-meltingPointOfThePrintingMaterial0" value="${search.meltingPointOfThePrintingMaterial0}" />
					<p>&nbsp;С -&nbsp;</p>
					<form:input path="meltingPointOfThePrintingMaterial1" class="amount-meltingPointOfThePrintingMaterial1" value="${search.meltingPointOfThePrintingMaterial1}" />
					<p>&nbsp;С</p>
				</div>
					<div class="slider-range-meltingPointOfThePrintingMaterial"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Материал для печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.media}" path="media" element="li" />
			</ul>
		</div> 
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Размер эктрудера</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="sizeExtruder0" class="amount-sizeExtruder0" value="${search.sizeExtruder0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizeExtruder1" class="amount-sizeExtruder1" value="${search.sizeExtruder1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizeExtruder"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость печати</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="speedPrint0" class="amount-speedPrint0" value="${search.speedPrint0}" />
					<p>&nbsp;мм/с -&nbsp;</p>
					<form:input path="speedPrint1" class="amount-speedPrint1" value="${search.speedPrint1}" />
					<p>&nbsp;мм/с</p>
				</div>
					<div class="slider-range-speedPrint"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Толщина слоя печати</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="thicknessOfThePrintingLayer0" class="amount-thicknessOfThePrintingLayer0" value="${search.thicknessOfThePrintingLayer0}" />
					<p>&nbsp;микрон -&nbsp;</p>
					<form:input path="thicknessOfThePrintingLayer1" class="amount-thicknessOfThePrintingLayer1" value="${search.thicknessOfThePrintingLayer1}" />
					<p>&nbsp;микрон</p>
				</div>
					<div class="slider-range-thicknessOfThePrintingLayer"></div>
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
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тыпы файлов</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.types_of_files}" path="typesOfFiles" element="li" />
			</ul>
		</div> 		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>П/О</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.rip}" path="rip" element="li" />
			</ul>
		</div> 		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная масса распечатываемой модели</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maximumWeightOfThePrintedModel0" class="amount-maximumWeightOfThePrintedModel0" value="${search.maximumWeightOfThePrintedModel0}" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="maximumWeightOfThePrintedModel1" class="amount-maximumWeightOfThePrintedModel1" value="${search.maximumWeightOfThePrintedModel1}" />
					<p>&nbsp;кг</p>
				</div>
					<div class="slider-range-maximumWeightOfThePrintedModel"></div>
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
					<form:input path="maxPowerConsumption0" class="amount-maxPowerConsumption0" value="${search.maxPowerConsumption0}" />
					<p>&nbsp;Вт -&nbsp;</p>
					<form:input path="maxPowerConsumption1" class="amount-maxPowerConsumption1" value="${search.maxPowerConsumption1}" />
					<p>&nbsp;Вт</p>
				</div>
					<div class="slider-range-maxPowerConsumption"></div>
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
			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				ПРИМЕНИТЬ
			</a>
			<a class="reset" href="<c:url value='/3d_printers' />">
				СБРОСИТЬ
			</a>
		</form:form>
	</div>
