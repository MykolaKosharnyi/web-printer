<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/user/search_printer_3d.css">
    <link rel="stylesheet" href="/css/search.css">
    
    <script src="<%=request.getContextPath()%>/resources/js/user/printer3d.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/user/search.js"></script>

	<div id="display_search">
		<i class="opened"></i>
		<p><custom:getDescriptionByLocale description="${d_search.filter_items}"/></p>
	</div>
		<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
			<custom:getDescriptionByLocale description="${d_search.apply}"/>
		</a>
		<a class="reset" href="<c:url value='/3d_printers' />">
			<custom:getDescriptionByLocale description="${d_search.reset}"/>
		</a>
	<div id="search_product">
	<form:form method="POST" commandName="search" action="/3d_printers/search">
	
		<jsp:include page="../search/price.jsp" />
		
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
			<div class="check_boxes">
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
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип Экструдера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.type_extruder}" path="typeExtruder" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Количество экструдеров</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.extruder_number}" path="extruderNumber" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость перемещения печатной головки, мм/с</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="speedOfMovingThePrintHead0" class="amount-speedOfMovingThePrintHead0" value="${search.speedOfMovingThePrintHead0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="speedOfMovingThePrintHead1" class="amount-speedOfMovingThePrintHead1" value="${search.speedOfMovingThePrintHead1}" />
				</div>
				<div class="slider-range-speedOfMovingThePrintHead"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Точность позиционирования печатной головки, мкм</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="positioningAccuracyOfThePrintHead0" class="amount-positioningAccuracyOfThePrintHead0" value="${search.positioningAccuracyOfThePrintHead0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="positioningAccuracyOfThePrintHead1" class="amount-positioningAccuracyOfThePrintHead1" value="${search.positioningAccuracyOfThePrintHead1}" />
				</div>
				<div class="slider-range-positioningAccuracyOfThePrintHead"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Обдув модели</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printer.airflow_models}" path="airflowModels" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Кол-во вентиляторов для обдува модели</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="numberOfFansForBlowingModels0" class="amount-numberOfFansForBlowingModels0" value="${search.numberOfFansForBlowingModels0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="numberOfFansForBlowingModels1" class="amount-numberOfFansForBlowingModels1" value="${search.numberOfFansForBlowingModels1}" />
				</div>
				<div class="slider-range-numberOfFansForBlowingModels"></div>
			</div>
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
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="meltingPointOfThePrintingMaterial0" class="amount-meltingPointOfThePrintingMaterial0" value="${search.meltingPointOfThePrintingMaterial0}" />
					<p>&nbsp;С -&nbsp;</p>
					<form:input path="meltingPointOfThePrintingMaterial1" class="amount-meltingPointOfThePrintingMaterial1" value="${search.meltingPointOfThePrintingMaterial1}" />
					<p>&nbsp;С</p>
				</div>
				<div class="slider-range-meltingPointOfThePrintingMaterial"></div>
			</div>
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
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="sizeExtruder0" class="amount-sizeExtruder0" value="${search.sizeExtruder0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizeExtruder1" class="amount-sizeExtruder1" value="${search.sizeExtruder1}" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider-range-sizeExtruder"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость печати</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="speedPrint0" class="amount-speedPrint0" value="${search.speedPrint0}" />
					<p>&nbsp;мм/с -&nbsp;</p>
					<form:input path="speedPrint1" class="amount-speedPrint1" value="${search.speedPrint1}" />
					<p>&nbsp;мм/с</p>
				</div>
				<div class="slider-range-speedPrint"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Толщина слоя печати</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="thicknessOfThePrintingLayer0" class="amount-thicknessOfThePrintingLayer0" value="${search.thicknessOfThePrintingLayer0}" />
					<p>&nbsp;мкм -&nbsp;</p>
					<form:input path="thicknessOfThePrintingLayer1" class="amount-thicknessOfThePrintingLayer1" value="${search.thicknessOfThePrintingLayer1}" />
					<p>&nbsp;мкм</p>
				</div>
				<div class="slider-range-thicknessOfThePrintingLayer"></div>
			</div>
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
				<p>Програмное обеспечение</p>
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
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="maximumWeightOfThePrintedModel0" class="amount-maximumWeightOfThePrintedModel0" value="${search.maximumWeightOfThePrintedModel0}" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="maximumWeightOfThePrintedModel1" class="amount-maximumWeightOfThePrintedModel1" value="${search.maximumWeightOfThePrintedModel1}" />
					<p>&nbsp;кг</p>
				</div>
				<div class="slider-range-maximumWeightOfThePrintedModel"></div>
			</div>
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
		
		<jsp:include page="../search/general_characteristics.jsp" />
		
			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				<custom:getDescriptionByLocale description="${d_search.apply}"/>
			</a>
			<a class="reset" href="<c:url value='/3d_printers' />">
				<custom:getDescriptionByLocale description="${d_search.reset}"/>
			</a>
		</form:form>
	</div>
