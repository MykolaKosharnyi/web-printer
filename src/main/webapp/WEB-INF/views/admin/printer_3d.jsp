<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<%@page session="true"%>
<!DOCTYPE>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

    <link rel="stylesheet" href="/css/admin/add_change_3d_printer.css">
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_3d_printer.js"></script>

	<c:if test="${empty product.id}">
		<title>
			<spring:message text="Добавление нового 3D принтера" />
		</title>
	</c:if>
	<c:if test="${!empty product.id}">
		<title>
			<spring:message text="Изменение 3D принтера" />
		</title>
	</c:if>
</head>
<body>
	
	<div id="product">
	
		<c:if test="${empty product.id}">
			<label id="head_of_page"><spring:message text="Добавление нового 3D принтера" /></label>
			<c:url var="addAction" value="/admin/${type}/add" ></c:url>
		</c:if>

		<c:if test="${!empty product.id}">
			<label id="head_of_page"><spring:message text="Изменение: ${product.name}" /></label>

			<c:if test="${!empty product.partNumber}">
				<div>
					<div style="font-weight: bold; float: left; padding-right: 15px;">Код товара:</div>${product.partNumber}
				</div>
			</c:if>

			<jsp:include page="product/last_changing.jsp" />
			<c:url var="addAction" value="/admin/${type}/update"></c:url>
		</c:if>

		<jsp:include page="product/pictures.jsp" />

	<form:form method="POST" commandName="product" action="${addAction}">
		<div class="save_button_keeper">	
			<c:if test="${empty product.id}">
				<c:url value="/admin/${type}/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" onclick="return false;" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/${type}/save_update" var="saveUpdate" />
				<input id="submit" type="submit" formaction="${saveUpdate}" onclick="return false;" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="изменить" style="background:blue; color: azure;"/>
			</c:if>
		
			<c:if test="${!empty product.id}">
				<jsp:include page="product/hidden_characteristic.jsp" />
			</c:if>
		</div>	
			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Название принтера</p>
						<form:errors path="name" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="name"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Название товара(ENGLISH)</p>
						<form:errors path="engNameProduct" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="engNameProduct"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Код товара</p>
						<form:errors path="partNumber" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="partNumber" />
					</div>
				</div>
				
				<jsp:include page="product/price.jsp" />
				
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип принтера</p>
						<form:errors path="typePrinter3D" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="typePrinter3D" productValue="${product.typePrinter3D}" properties="${printer.type_printer_3d}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Модель</p>
						<form:errors path="equipmentModel" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="equipmentModel" />
					</div>
				</div>
				
				<!-- import actions -->
				<jsp:include page="product/actions.jsp" />
				
				<!-- import time shares action -->
				<jsp:include page="product/time_shares.jsp" />
				
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер запечатываемой области</p>
						<form:errors path="sizePrintableAreaX" cssClass="error"></form:errors>
						<form:errors path="sizePrintableAreaY" cssClass="error"></form:errors>
						<form:errors path="sizePrintableAreaZ" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<p style="float: none; margin: 10px auto 0px;"> По оси Х:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaX" class="amount-sizePrintableAreaX" value="${product.sizePrintableAreaX}"/>
							<p >&nbsp;мм</p>
							<form:errors path="sizePrintableAreaX" cssClass="error"></form:errors>
						</div>
							<div class="slider-range-sizePrintableAreaX"></div>
		
						<p style="float: none; margin: 10px auto 0px;"> По оси Y:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaY" class="amount-sizePrintableAreaY" value="${product.sizePrintableAreaY}" />
							<p>&nbsp;мм</p>
							<form:errors path="sizePrintableAreaY" cssClass="error"></form:errors>
						</div>
							<div class="slider-range-sizePrintableAreaY"></div>
		
						<p style="float: none; margin: 10px auto 0px;"> По оси Z:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaZ" class="amount-sizePrintableAreaZ" value="${product.sizePrintableAreaZ}" />
							<p>&nbsp;мм</p>
							<form:errors path="sizePrintableAreaZ" cssClass="error"></form:errors>
						</div>
							<div class="slider-range-sizePrintableAreaZ"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Технология печати</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${printer.print_technology}" path="printTechnology" element="li" />
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Состояние оборудования</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="previouslyUsed" productValue="${product.previouslyUsed}" properties="${printer.previously_used}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цветовая схема</p>
					</div>
					<ul class="check_boxes">
						<custom:check nameOfAttribyte="chromaticity" productValues="${product.chromaticity}" properties="${printer.chromaticity}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="typeOfPrinthead" productValue="${product.typeOfPrinthead}" properties="${printer.type_of_printhead}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Температура плавления печатного материала</p>
						<form:errors path="meltingPointOfThePrintingMaterial" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="meltingPointOfThePrintingMaterial" class="amount-meltingPointOfThePrintingMaterial" value="${product.meltingPointOfThePrintingMaterial}" />
							<p>&nbsp;С</p>
						</div>
							<div class="slider-range-meltingPointOfThePrintingMaterial"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Материал для печати</p>
					</div>
					<ul class="check_boxes">
						<custom:check nameOfAttribyte="media" productValues="${product.media}" properties="${printer.media}"/>
					</ul>
				</div> 
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер эктрудера</p>
						<form:errors path="sizeExtruder" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="sizeExtruder" class="amount-sizeExtruder" value="${product.sizeExtruder}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-sizeExtruder"></div>
					</ul>
				</div>	
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип Экструдера</p>
					</div>
					<div class="check_boxes">
						<custom:radio nameOfAttribyte="typeExtruder" productValue="${product.typeExtruder}" properties="${printer.type_extruder}"/>
					</div>
				</div>	
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Количество экструдеров</p>
					</div>
					<div class="check_boxes">
						<form:radiobuttons items="${printer.extruder_number}" path="extruderNumber" element="li"/>
					</div>
				</div>		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость перемещения печатной головки, мм/с</p>
						<form:errors path="speedOfMovingThePrintHead" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="speedOfMovingThePrintHead" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Точность позиционирования печатной головки, мкм</p>
						<form:errors path="positioningAccuracyOfThePrintHead" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="positioningAccuracyOfThePrintHead" />
					</div>
				</div>
			</div>
			
			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Обдув модели</p>
					</div>
					<div class="check_boxes">
						<custom:radio nameOfAttribyte="airflowModels" productValue="${product.airflowModels}" properties="${printer.airflow_models}"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Кол-во вентиляторов для обдува модели</p>
						<form:errors path="numberOfFansForBlowingModels" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="numberOfFansForBlowingModels" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость печати</p>
						<form:errors path="speedPrint" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="speedPrint" class="amount-speedPrint" value="${product.speedPrint}" />
							<p>&nbsp;мм/с</p>
						</div>
							<div class="slider-range-speedPrint"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Толщина слоя печати</p>
						<form:errors path="thicknessOfThePrintingLayer" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="thicknessOfThePrintingLayer" class="amount-thicknessOfThePrintingLayer" value="${product.thicknessOfThePrintingLayer}" />
							<p>&nbsp;мкм</p>
						</div>
							<div class="slider-range-thicknessOfThePrintingLayer"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.interface_connection}" path="interfaceConnection" element="li" />
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Типы файлов</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.types_of_files}" path="typesOfFiles" element="li" />
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Программное обеспечение</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printer.rip}" path="rip" element="li" />
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная масса распечатываемой модели</p>
						<form:errors path="maximumWeightOfThePrintedModel" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maximumWeightOfThePrintedModel" class="amount-maximumWeightOfThePrintedModel" value="${product.maximumWeightOfThePrintedModel}" />
							<p>&nbsp;кг</p>
						</div>
							<div class="slider-range-maximumWeightOfThePrintedModel"></div>
					</ul>
				</div>		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${printer.equipment_manufacturer}" path="equipmentManufacturer" element="li" />
					</ul>
				</div>	
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Средняя потребляемая мощность, Вт</p>
						<form:errors path="averagePowerConsumption" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="averagePowerConsumption"/>
					</ul>
				</div>	
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная потребляемая мощность</p>
						<form:errors path="maxPowerConsumption" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maxPowerConsumption" class="amount-maxPowerConsumption" value="${product.maxPowerConsumption}" />
							<p>&nbsp;Вт</p>
						</div>
							<div class="slider-range-maxPowerConsumption"></div>
					</ul>
				</div>		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вес</p>
						<form:errors path="weight" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="weight" class="amount-weight" value="${product.weight}" />
							<p>&nbsp;кг</p>
						</div>
							<div class="slider-range-weight"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина</p>
						<form:errors path="width" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="width" class="amount-width" value="${product.width}" />
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-width"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Глубина</p>
						<form:errors path="depth" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="depth" class="amount-depth" value="${product.depth}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-depth"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Высота</p>
						<form:errors path="heigth" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="heigth" class="amount-heigth" value="${product.heigth}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-heigth"></div>
					</ul>
				</div>
				
				<!-- import delivery and insurance option -->
				<jsp:include page="product/delivery_and_insurance.jsp" />
				
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Гарантия, месяцев</p>
						<form:errors path="guarantee" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="guarantee" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Наличие (информация для пользователя)</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="availability" productValue="${product.availability}" properties="${printer.availability}"/>
						
						<div class="text_output">
							<form:input path="availabilitySpecialCase"/>
						</div>
					</ul>
				</div>
				
				<!-- import option characteristic -->
				<jsp:include page="product/characteristic_option.jsp" />
			</div>

			<jsp:include page="product/textarea_descriptions.jsp" />
			
			<c:if test="${empty product.id}">
				<input id="submit" type="submit" value="загрузить" style="background:green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<input id="submit" type="submit" value="изменить" style="background:blue; color: azure;"/>
			</c:if>

		</form:form>
	</div>
	
	<jsp:include page="product/js_code.jsp" />
	
</body>
</html>