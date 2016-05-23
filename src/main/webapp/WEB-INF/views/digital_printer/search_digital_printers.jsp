<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_digital_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/digital_printer.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					ПРИМЕНИТЬ
				</a>
				<a class="reset" href="<c:url value='/digital_printers' />">
					СБРОСИТЬ
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/digital_printers/search" ></c:url>
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
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип принтера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.type_printer}" path="typePrinter" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Б/У оборудование</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.previously_used}" path="previouslyUsed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Устройство</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.device}" path="device" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.type_of_printing}" path="typeOfPrinting" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Технология печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.print_technology}" path="printTechnology" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Размещение</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.accommodation}" path="accommodation" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Область применения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.application_area}" path="applicationArea" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Количество страниц в месяц</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="numberOfPagesPerMonth0" class="amount-numberOfPagesPerMonth0" value="${search.numberOfPagesPerMonth0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="numberOfPagesPerMonth1" class="amount-numberOfPagesPerMonth1" value="${search.numberOfPagesPerMonth1}" />
				</div>
				<div class="slider-range-numberOfPagesPerMonth"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальный формат</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.maximum_format}" path="maximumFormat" element="li" />
			</ul>
		</div>
		
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Характеристики печати</p>
			</div>
			<ul class="block_check_boxes">
			<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Автоматическая двусторонняя печать</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.yn}" path="automaticTwoSidedPrinting" element="li" />
			</ul>
		</div>
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Время разогрева</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="warmUpTime0" class="amount-warmUpTime0" value="${search.warmUpTime0}" />
					<p>&nbsp;c&nbsp;-&nbsp;</p>
					<form:input path="warmUpTime1" class="amount-warmUpTime1" value="${search.warmUpTime1}" />
					<p>&nbsp;с</p>
				</div>
				<div class="slider-range-warmUpTime"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость печати для ч/б печати, стр/мин</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="speedPrintBW0" class="amount-speedPrintBW0" value="${search.speedPrintBW0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="speedPrintBW1" class="amount-speedPrintBW1" value="${search.speedPrintBW1}" />
				</div>
					<div class="slider-range-speedPrintBW"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость печати для цветной печати, стр/мин</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="speedPrintColor0" class="amount-speedPrintColor0" value="${search.speedPrintColor0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="speedPrintColor1" class="amount-speedPrintColor1" value="${search.speedPrintColor1}" />
				</div>
					<div class="slider-range-speedPrintColor"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость копирования для ч/б печати, стр/мин</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="speedCopyBW0" class="amount-speedCopyBW0" value="${search.speedCopyBW0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="speedCopyBW1" class="amount-speedCopyBW1" value="${search.speedCopyBW1}" />
				</div>
					<div class="slider-range-speedCopyBW"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость копирования для цветной печати, стр/мин</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="speedCopyColor0" class="amount-speedCopyColor0" value="${search.speedCopyColor0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="speedCopyColor1" class="amount-speedCopyColor1" value="${search.speedCopyColor1}" />
				</div>
					<div class="slider-range-speedCopyColor"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Время выхода первого отпечатка color</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="firstPrintColor0" class="amount-firstPrintColor0" value="${search.firstPrintColor0}" />
					<p>&nbsp;с&nbsp;-&nbsp;</p>
					<form:input path="firstPrintColor1" class="amount-firstPrintColor1" value="${search.firstPrintColor1}" />
					<p>&nbsp;с</p>
				</div>
				<div class="slider-range-firstPrintColor"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Время выхода первого отпечатка BW</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="firstPrintBW0" class="amount-firstPrintBW0" value="${search.firstPrintBW0}" />
					<p>&nbsp;с&nbsp;-&nbsp;</p>
					<form:input path="firstPrintBW1" class="amount-firstPrintBW1" value="${search.firstPrintBW1}" />
					<p>&nbsp;с</p>
				</div>
				<div class="slider-range-firstPrintBW"/>
			</ul>
		</div>
			</ul>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Характеристики сканера</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип сканера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.scanner_type}" path="scannerType" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальный формат оригинала</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.maximum_format}" path="theMaximumSizeOfTheOriginal" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Разрешение сканера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.scanner_resolution}" path="scannerResolution" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость сканирования (цветн.), из./мин</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="scanSpeedColor0" class="amount-scanSpeedColor0" value="${search.scanSpeedColor0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="scanSpeedColor1" class="amount-scanSpeedColor1" value="${search.scanSpeedColor1}" />
				</div>
				<div class="slider-range-scanSpeedColor"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость сканирования (ч/б), из./мин</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="scanSpeedBW0" class="amount-scanSpeedBW0" value="${search.scanSpeedBW0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="scanSpeedBW1" class="amount-scanSpeedBW1" value="${search.scanSpeedBW1}" />
				</div>
				<div class="slider-range-scanSpeedBW"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Отправка изображения по e-mail</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.yn}" path="sendingImagesByEmail" element="li" />
			</ul>
		</div>
			</ul>
		</div>


		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Характеристики копира</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальное разрешение копира (ч/б)</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.maximum_resolution_copier_bw}" path="maximumResolutionCopierBW" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Время выхода первой копии</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="firstCopyOutTime0" class="amount-firstCopyOutTime0" value="${search.firstCopyOutTime0}" />
					<p>&nbsp;с&nbsp;-&nbsp;</p>
					<form:input path="firstCopyOutTime1" class="amount-firstCopyOutTime1" value="${search.firstCopyOutTime1}" />
					<p>&nbsp;с</p>
				</div>
				<div class="slider-range-firstCopyOutTime"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Изменение масштаба</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="zooming0" class="amount-zooming0" value="${search.zooming0}" />
					<p>&nbsp;%&nbsp;-&nbsp;</p>
					<form:input path="zooming1" class="amount-zooming1" value="${search.zooming1}" />
					<p>&nbsp;%</p>
				</div>
				<div class="slider-range-zooming"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Шаг масштабирования</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="stepZoom0" class="amount-stepZoom0" value="${search.stepZoom0}" />
					<p>&nbsp;%&nbsp;-&nbsp;</p>
					<form:input path="stepZoom1" class="amount-stepZoom1" value="${search.stepZoom1}" />
					<p>&nbsp;%</p>
				</div>
				<div class="slider-range-stepZoom"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальное количество копий за цикл</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="theMaximumNumberOfCopiesPerCycle0" class="amount-theMaximumNumberOfCopiesPerCycle0" value="${search.theMaximumNumberOfCopiesPerCycle0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="theMaximumNumberOfCopiesPerCycle1" class="amount-theMaximumNumberOfCopiesPerCycle1" value="${search.theMaximumNumberOfCopiesPerCycle1}" />
				</div>
				<div class="slider-range-theMaximumNumberOfCopiesPerCycle"/>
			</ul>
		</div>
			</ul>
		</div>

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Подача материала</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Подача бумаги (стандартная), лист.</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="paperFeedStandart0" class="amount-paperFeedStandart0" value="${search.paperFeedStandart0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="paperFeedStandart1" class="amount-paperFeedStandart1" value="${search.paperFeedStandart1}" />
				</div>
				<div class="slider-range-paperFeedStandart"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Подача бумаги (максимальная), лист.</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="paperFeedMax0" class="amount-paperFeedMax0" value="${search.paperFeedMax0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="paperFeedMax1" class="amount-paperFeedMax1" value="${search.paperFeedMax1}" />
				</div>
				<div class="slider-range-paperFeedMax"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Вывод бумаги (стандартная), лист.</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="paperOutputStandart0" class="amount-paperOutputStandart0" value="${search.paperOutputStandart0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="paperOutputStandart1" class="amount-paperOutputStandart1" value="${search.paperOutputStandart1}" />
				</div>
				<div class="slider-range-paperOutputStandart"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Вывод бумаги (максимальная), лист.</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="paperOutputMax0" class="amount-paperOutputMax0" value="${search.paperOutputMax0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="paperOutputMax1" class="amount-paperOutputMax1" value="${search.paperOutputMax1}" />
				</div>
				<div class="slider-range-paperOutputMax"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Емкость лотка ручной подачи, лист.</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="theCapacityOfTheBypassTray0" class="amount-theCapacityOfTheBypassTray0" value="${search.theCapacityOfTheBypassTray0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="theCapacityOfTheBypassTray1" class="amount-theCapacityOfTheBypassTray1" value="${search.theCapacityOfTheBypassTray1}" />
				</div>
				<div class="slider-range-theCapacityOfTheBypassTray"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Электронная сортировка</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.yn}" path="electronicSorting" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Степлер</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.yn}" path="stapler" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Плотность бумаги</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="paperDensity0" class="amount-paperDensity0" value="${search.paperDensity0}" />
					<p>&nbsp;г/м2&nbsp;-&nbsp;</p>
					<form:input path="paperDensity1" class="amount-paperDensity1" value="${search.paperDensity1}" />
					<p>&nbsp;г/м2</p>
				</div>
				<div class="slider-range-paperDensity"/>
			</ul>
		</div>
			</ul>
		</div>

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Расходные материалы</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ресурс девелопера, с</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="resourceDeveloper0" class="amount-resourceDeveloper0" value="${search.resourceDeveloper0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="resourceDeveloper1" class="amount-resourceDeveloper1" value="${search.resourceDeveloper1}" />
				</div>
				<div class="slider-range-resourceDeveloper"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ресурс фотобарабана, стр.</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="resourceDrum0" class="amount-resourceDrum0" value="${search.resourceDrum0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="resourceDrum1" class="amount-resourceDrum1" value="${search.resourceDrum1}" />
				</div>
				<div class="slider-range-resourceDrum"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ресурс ч/б картриджа/тонера, стр.</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="resourceBWCartridgeToner0" class="amount-resourceBWCartridgeToner0" value="${search.resourceBWCartridgeToner0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="resourceBWCartridgeToner1" class="amount-resourceBWCartridgeToner1" value="${search.resourceBWCartridgeToner1}" />
				</div>
				<div class="slider-range-resourceBWCartridgeToner"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Количество картриджей</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="numberOfCartridges0" class="amount-numberOfCartridges0" value="${search.numberOfCartridges0}" />
					<p>&nbsp;с&nbsp;-&nbsp;</p>
					<form:input path="numberOfCartridges1" class="amount-numberOfCartridges1" value="${search.numberOfCartridges1}" />
					<p>&nbsp;с</p>
				</div>
				<div class="slider-range-numberOfCartridges"/>
			</ul>
		</div>
			</ul>
		</div>

		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Печать на</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.printing_on}" path="printingOn" element="li" />
			</ul>
		</div>
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Интерфейсы</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.interfaces}" path="interfaces" element="li" />
			</ul>
		</div>

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>П/О</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Поддержка ОС</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.os_support}" path="oSSupport" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Прямая печать</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.yn}" path="directPrinting" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Веб-интерфейс</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.yn}" path="webInterface" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Поддержка PostScript</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.yn}" path="supportPostScript" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Поддержка</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.support}" path="support" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Количество установленных шрифтов PostScript</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="theNumberOfInstalledPostScriptFonts0" class="amount-theNumberOfInstalledPostScriptFonts0" value="${search.theNumberOfInstalledPostScriptFonts0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="theNumberOfInstalledPostScriptFonts1" class="amount-theNumberOfInstalledPostScriptFonts1" value="${search.theNumberOfInstalledPostScriptFonts1}" />
				</div>
				<div class="slider-range-theNumberOfInstalledPostScriptFonts"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Количество установленных шрифтов PCL</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="theNumberOfInstalledPCLFonts0" class="amount-theNumberOfInstalledPCLFonts0" value="${search.theNumberOfInstalledPCLFonts0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="theNumberOfInstalledPCLFonts1" class="amount-theNumberOfInstalledPCLFonts1" value="${search.theNumberOfInstalledPCLFonts1}" />
				</div>
				<div class="slider-range-theNumberOfInstalledPCLFonts"/>
			</ul>
		</div>
			</ul>
		</div>	
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Общие характеристики</p>
			</div>
			<ul class="block_check_boxes">
				<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Объем памяти, Мб</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="memory0" class="amount-memory0" value="${search.memory0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="memory1" class="amount-memory1" value="${search.memory1}" />
				</div>
				<div class="slider-range-memory"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Емкость жесткого диска, Гб</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="hardDriveCapacity0" class="amount-hardDriveCapacity0" value="${search.hardDriveCapacity0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="hardDriveCapacity1" class="amount-hardDriveCapacity1" value="${search.hardDriveCapacity1}" />
				</div>
				<div class="slider-range-hardDriveCapacity"/>
			</ul>
		</div>
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Отображение информации</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.display_information}" path="displayInformation" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Диагональ дисплея, дюйм</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="displaySize0" class="amount-displaySize0" value="${search.displaySize0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="displaySize1" class="amount-displaySize1" value="${search.displaySize1}" />
				</div>
				<div class="slider-range-displaySize"/>
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
			</ul>
		</div>			

			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				ПРИМЕНИТЬ
			</a>
			<a class="reset" href="<c:url value='/digital_printers' />">
				СБРОСИТЬ
			</a>
		</form:form>
	</div>