<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="custom" uri="/WEB-INF/custom.tld"%>
<%@page session="true"%>
<!DOCTYPE>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_printer.js"></script>

	<c:if test="${empty product.id}">
		<title>
			<spring:message text="Добавление нового принтера" />
		</title>
	</c:if>
	<c:if test="${!empty product.id}">
		<title>
			<spring:message text="Изменение" />
		</title>
	</c:if>
</head>
<body>
	
	<div id="product">
	
		<c:if test="${empty product.id}">
			<label id="head_of_page"><spring:message text="Добавление нового принтера" /></label>
			<c:url var="addAction" value="/admin/${type}/add" ></c:url>
		</c:if>
			
		<c:if test="${!empty product.id}">
			<label id="head_of_page"><spring:message text="Изменение: ${product.name}" /></label>
				
			<c:if test="${!empty product.partNumber}">	
				<div>
					<div style="font-weight:bold; float: left; padding-right: 15px;">Код товара: </div>${product.partNumber}
				</div>
			</c:if>
				
			<jsp:include page="product/last_changing.jsp" />
			<c:url var="addAction" value="/admin/${type}/update" ></c:url>
		</c:if>
		
		<jsp:include page="product/pictures.jsp" />

	<form:form method="POST" commandName="product" action="${addAction}">
		<div class="save_button_keeper">	
			<c:if test="${empty product.id}">
				<c:url value="/admin/${type}/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/${type}/save_update" var="saveUpdate" />
				<input id="submit" type="submit" formaction="${saveUpdate}" value="сохранить" style="background: gold; color: black;"/>
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
						<form:errors path="typePrinter" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="typePrinter" productValue="${product.typePrinter}" properties="${digital_printer.type_printer}"/>
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
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Состояние оборудования</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="previouslyUsed" productValue="${product.previouslyUsed}" properties="${digital_printer.previously_used}"/>
					</ul>
				</div>
				
				<!-- import actions -->
				<jsp:include page="product/actions.jsp" />
			
				<!-- import time shares action -->
				<jsp:include page="product/time_shares.jsp" />
				
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Устройство</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="device" productValue="${product.device}" properties="${digital_printer.device}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печати</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="typeOfPrinting" productValue="${product.typeOfPrinting}" properties="${digital_printer.type_of_printing}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Технология печати</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="printTechnology" productValue="${product.printTechnology}" properties="${digital_printer.print_technology}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размещение</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="accommodation" productValue="${product.accommodation}" properties="${digital_printer.accommodation}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Область применения</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="applicationArea" productValue="${product.applicationArea}" properties="${digital_printer.application_area}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Количество страниц в месяц</p>
						<form:errors path="numberOfPagesPerMonth" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="numberOfPagesPerMonth" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальный формат</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${digital_printer.maximum_format}" path="maximumFormat" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Автоматическая двусторонняя печать</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="automaticTwoSidedPrinting" productValue="${product.automaticTwoSidedPrinting}" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальное разрешение для цветной печати(0000x0000)</p>
						<form:errors path="theMaximumResolutionForColorPrinting" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="theMaximumResolutionForColorPrinting" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальное разрешение для ч/б печати(0000x0000)</p>
						<form:errors path="theMaximumResolutionForBWPrinting" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="theMaximumResolutionForBWPrinting" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Время разогрева</p>
						<form:errors path="warmUpTime" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="warmUpTime" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Время выхода первого отпечатка color</p>
						<form:errors path="firstPrintColor" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="firstPrintColor" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Время выхода первого отпечатка ч/б</p>
						<form:errors path="firstPrintBW" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="firstPrintBW" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип сканера</p>
					</div>
					<ul class="check_boxes">
						<custom:check nameOfAttribyte="scannerType" productValues="${product.scannerType}" properties="${digital_printer.scanner_type}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальный формат оригинала</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${digital_printer.maximum_format}" path="theMaximumSizeOfTheOriginal" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальный размер сканирования</p>
						<form:errors path="maximumScanSize" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="maximumScanSize" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Разрешение сканера</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${digital_printer.scanner_resolution}" path="scannerResolution" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость сканирования (цветн.)</p>
						<form:errors path="scanSpeedColor" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="scanSpeedColor" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость сканирования (ч/б)</p>
						<form:errors path="scanSpeedBW" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="scanSpeedBW" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Отправка изображения по e-mail</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="sendingImagesByEmail" productValue="${product.sendingImagesByEmail}" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальное разрешение копира (ч/б)</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${digital_printer.maximum_resolution_copier_bw}" path="maximumResolutionCopierBW" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Время выхода первой копии</p>
						<form:errors path="firstCopyOutTime" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="firstCopyOutTime" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Изменение масштаба</p>
						<form:errors path="zooming" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="zooming" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Шаг масштабирования</p>
						<form:errors path="stepZoom" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="stepZoom" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальное количество копий за цикл</p>
						<form:errors path="theMaximumNumberOfCopiesPerCycle" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="theMaximumNumberOfCopiesPerCycle" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость печати для ч/б печати</p>
						<form:errors path="speedPrintBWA4" cssClass="error"></form:errors>
						<form:errors path="speedPrintBWA3" cssClass="error"></form:errors>
						<form:errors path="speedPrintBWA2" cssClass="error"></form:errors>
						<form:errors path="speedPrintBWA1" cssClass="error"></form:errors>
						<form:errors path="speedPrintBWA0" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>A4</p>
							<form:input path="speedPrintBWA4" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintBWA4" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A3</p>
							<form:input path="speedPrintBWA3" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintBWA3" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A2</p>
							<form:input path="speedPrintBWA2" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintBWA2" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A1</p>
							<form:input path="speedPrintBWA1" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintBWA1" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A0</p>
							<form:input path="speedPrintBWA0" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintBWA0" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость печати для цветной печати</p>
						<form:errors path="speedPrintColorA4" cssClass="error"></form:errors>
						<form:errors path="speedPrintColorA3" cssClass="error"></form:errors>
						<form:errors path="speedPrintColorA2" cssClass="error"></form:errors>
						<form:errors path="speedPrintColorA1" cssClass="error"></form:errors>
						<form:errors path="speedPrintColorA0" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>A4</p>
							<form:input path="speedPrintColorA4" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintColorA4" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A3</p>
							<form:input path="speedPrintColorA3" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintColorA3" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A2</p>
							<form:input path="speedPrintColorA2" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintColorA2" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A1</p>
							<form:input path="speedPrintColorA1" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintColorA1" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A0</p>
							<form:input path="speedPrintColorA0" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedPrintColorA0" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
			</div>






			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость копирования для ч/б печати</p>
						<form:errors path="speedCopyBWA4" cssClass="error"></form:errors>
						<form:errors path="speedCopyBWA3" cssClass="error"></form:errors>
						<form:errors path="speedCopyBWA2" cssClass="error"></form:errors>
						<form:errors path="speedCopyBWA1" cssClass="error"></form:errors>
						<form:errors path="speedCopyBWA0" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>A4</p>
							<form:input path="speedCopyBWA4" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyBWA4" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A3</p>
							<form:input path="speedCopyBWA3" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyBWA3" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A2</p>
							<form:input path="speedCopyBWA2" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyBWA2" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A1</p>
							<form:input path="speedCopyBWA1" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyBWA1" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A0</p>
							<form:input path="speedCopyBWA0" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyBWA0" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость копирования для цветной печати</p>
						<form:errors path="speedCopyColorA4" cssClass="error"></form:errors>
						<form:errors path="speedCopyColorA3" cssClass="error"></form:errors>
						<form:errors path="speedCopyColorA2" cssClass="error"></form:errors>
						<form:errors path="speedCopyColorA1" cssClass="error"></form:errors>
						<form:errors path="speedCopyColorA0" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>A4</p>
							<form:input path="speedCopyColorA4" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyColorA4" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A3</p>
							<form:input path="speedCopyColorA3" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyColorA3" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A2</p>
							<form:input path="speedCopyColorA2" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyColorA2" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A1</p>
							<form:input path="speedCopyColorA1" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyColorA1" cssClass="error"></form:errors>
						</div>

						<div class="text_output">
							<p>A0</p>
							<form:input path="speedCopyColorA0" class="amount-speed-print-d"/>
							<p>&nbsp;стр/мин</p>
							<form:errors path="speedCopyColorA0" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Подача бумаги (стандартная)</p>
						<form:errors path="paperFeedStandart" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="paperFeedStandart" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Подача бумаги (максимальная)</p>
						<form:errors path="paperFeedMax" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="paperFeedMax" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вывод бумаги (стандартная)</p>
						<form:errors path="paperOutputStandart" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="paperOutputStandart" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вывод бумаги (максимальная)</p>
						<form:errors path="paperOutputMax" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="paperOutputMax" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Емкость лотка ручной подачи</p>
						<form:errors path="theCapacityOfTheBypassTray" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="theCapacityOfTheBypassTray" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Электронная сортировка</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="electronicSorting" productValue="${product.electronicSorting}" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Степлер</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="stapler" productValue="${product.stapler}" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Плотность бумаги</p>
						<form:errors path="paperDensity" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="paperDensity" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Печать на</p>
					</div>
					<ul class="check_boxes">
						<custom:check nameOfAttribyte="printingOn" productValues="${product.printingOn}" properties="${digital_printer.printing_on}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ресурс девелопера</p>
						<form:errors path="resourceDeveloper" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="resourceDeveloper" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ресурс фотобарабана</p>
						<form:errors path="resourceDrum" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="resourceDrum" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ресурс ч/б картриджа/тонера</p>
						<form:errors path="resourceBWCartridgeToner" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="resourceBWCartridgeToner" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Количество картриджей</p>
						<form:errors path="numberOfCartridges" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="numberOfCartridges" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Объем памяти</p>
						<form:errors path="memory" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="memory" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Емкость жесткого диска</p>
						<form:errors path="hardDriveCapacity" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="hardDriveCapacity" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${digital_printer.interfaces}" path="interfaces" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Прямая печать</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="directPrinting" productValue="${product.directPrinting}" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Веб-интерфейс</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="webInterface" productValue="${product.webInterface}" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Поддержка PostScript</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="supportPostScript" productValue="${product.supportPostScript}" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Поддержка</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${digital_printer.support}" path="support" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Количество установленных шрифтов PostScript</p>
						<form:errors path="theNumberOfInstalledPostScriptFonts" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="theNumberOfInstalledPostScriptFonts" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Количество установленных шрифтов PCL</p>
						<form:errors path="theNumberOfInstalledPCLFonts" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="theNumberOfInstalledPCLFonts" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Поддержка ОС</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${digital_printer.os_support}" path="oSSupport" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Отображение информации</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="displayInformation" productValue="${product.displayInformation}" properties="${digital_printer.display_information}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Диагональ дисплея</p>
						<form:errors path="displaySize" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="displaySize" />
					</div>
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
							<form:input path="maxPowerConsumption" class="amount-max_power_consumption" value="${product.maxPowerConsumption}"/>
							<p>&nbsp;Вт</p>
						</div>
						<div class="slider-range-max_power_consumption"></div>
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
							<form:input path="weight" class="amount-weight"/>
							<p>&nbsp;кг</p>
						</div>
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
							<form:input path="width" class="amount-width" value="${product.width}"/>
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
							<form:input path="depth" class="amount-depth" value="${product.depth}"/>
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
							<form:input path="heigth" class="amount-heigth" value="${product.heigth}"/>
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
						<custom:radio nameOfAttribyte="availability" productValue="${product.availability}" properties="${digital_printer.availability}"/>
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
	<script type="text/javascript">
	
	function SubmitForm(action) {
		var form = this.parent("form#product");
		form.attr("action", action);
		form.submit();
		
      	/*$( "form#product" ).submit(function( event ) {
        	  event.preventDefault();
        	});*/
      	  return false;
      	}
	
	</script>
	
	<jsp:include page="product/js_code.jsp" />
	
</body>
</html>