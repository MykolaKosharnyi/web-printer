<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/product.css"/>
	
	<script src="<%=request.getContextPath()%>/resources/js/user/product.js"></script>
	<title>${product.name}</title>
</head>
<body>   
         <div class="product">
            <div id="pictures_and_descriptions">
            
				<div class="pictures-and-rating">
            	
            		<!-- import pictures presentation -->
					<jsp:include page="../product_page/pictures.jsp" />

            	</div>
            	
                <div class="descriptions">
 
                <!-- import timer -->
				<jsp:include page="../product_page/clock.jsp" />    				
				
                	<div id="name_product_head_description">${product.name}</div>
                	<div id="name_product_head_description">Код товара: ${product.partNumber}</div>
                    <table id="table_in_head">
                       <caption></caption> 
                                          
   					   <!-- set price in table row -->
					   <jsp:include page="../product_page/price.jsp" /> 
					   
                       <c:if test="${!empty product.typePrinter}">
   							<tr><td>Тип принтера:</td><td>${product.typePrinter}</td></tr>
					   </c:if>
					   
					   <c:if test="${!empty product.equipmentModel}">
   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
						</c:if>
                  </table>
                  
                    <!-- import opportunity add to product's price, price for different services -->
				    <jsp:include page="../product_page/option_product_with_price.jsp" />
                  
                    <!-- import availability of this product -->
				    <jsp:include page="../product_page/availability.jsp" />
				    
				    <!-- import guarantee of this product -->
				    <jsp:include page="../product_page/guarantee.jsp" />
                </div>
            </div>
            <div id="tabs_product">
                <ul id="sub_tabs_product">
                    <li>Описание</li>
                    <li>Технические характеристики</li>
                    <li>Отзывы</li>
                    <li>С этим товаром используется</li>
                </ul>
                <div>
                    <div id="output_description">${product.description}</div>
                    
                    <div class="descriptions">
					<table>
                       
                       <c:if test="${!empty product.typePrinter}">
   							<tr><td>Тип принтера:</td><td>${product.typePrinter}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td>Код товара:</td><td>${product.partNumber}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.previouslyUsed}">
   							<tr><td>Состояние оборудования:</td><td>${product.previouslyUsed}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td>Производитель оборудования:</td><td>${product.equipmentManufacturer}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.device}">
   							<tr><td>Устройство:</td><td>${product.device}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeOfPrinting}">
   							<tr><td>Тип печати:</td><td>${product.typeOfPrinting}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.printTechnology}">
   							<tr><td>Технология печати:</td><td>${product.printTechnology}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.accommodation}">
   							<tr><td>Размещение:</td><td>${product.accommodation}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.applicationArea}">
   							<tr><td>Область применения:</td><td>${product.applicationArea}</td></tr>
						</c:if>
                       
                       <c:if test="${(product.speedPrintBWA4 != 0) || (product.speedPrintBWA3 != 0) || 
                      					(product.speedPrintBWA2 != 0) || (product.speedPrintBWA1 != 0) ||
                      						(product.speedPrintBWA0 != 0)}">
   							<tr><td>Скорость печати для ч/б печати:</td>
   								<td>
   								
   								<c:if test="${product.speedPrintBWA4 != 0}">
   									A4: ${product.speedPrintBWA4} стр/мин 
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedPrintBWA3 != 0}">
   									A3: ${product.speedPrintBWA3} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintBWA2 != 0}">
   									A2: ${product.speedPrintBWA2} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintBWA1 != 0}">
   									A1: ${product.speedPrintBWA1} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintBWA0 != 0}">
   									A0: ${product.speedPrintBWA0} стр/мин 
								</c:if>
								
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${(product.speedPrintColorA4 != 0) || (product.speedPrintColorA3 != 0) || 
                      					(product.speedPrintColorA2 != 0) || (product.speedPrintColorA1 != 0) ||
                      						(product.speedPrintColorA0 != 0)}">
   							<tr><td>Скорость печати для цветной печати:</td>
   								<td>
   								
   								<c:if test="${product.speedPrintColorA4 != 0}">
   									A4: ${product.speedPrintColorA4} стр/мин 
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedPrintColorA3 != 0}">
   									A3: ${product.speedPrintColorA3} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintColorA2 != 0}">
   									A2: ${product.speedPrintColorA2} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintColorA1 != 0}">
   									A1: ${product.speedPrintColorA1} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintColorA0 != 0}">
   									A0: ${product.speedPrintColorA0} стр/мин 
								</c:if>
								
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${(product.speedCopyBWA4 != 0) || (product.speedCopyBWA3 != 0) || 
                      					(product.speedCopyBWA2 != 0) || (product.speedCopyBWA1 != 0) ||
                      						(product.speedCopyBWA0 != 0)}">
   							<tr><td>Скорость копирования для ч/б печати:</td>
   								<td>
   								
   								<c:if test="${product.speedCopyBWA4 != 0}">
   									A4: ${product.speedCopyBWA4} стр/мин 
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedCopyBWA3 != 0}">
   									A3: ${product.speedCopyBWA3} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyBWA2 != 0}">
   									A2: ${product.speedCopyBWA2} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyBWA1 != 0}">
   									A1: ${product.speedCopyBWA1} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyBWA0 != 0}">
   									A0: ${product.speedCopyBWA0} стр/мин 
								</c:if>
								
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${(product.speedCopyColorA4 != 0) || (product.speedCopyColorA3 != 0) || 
                      					(product.speedCopyColorA2 != 0) || (product.speedCopyColorA1 != 0) ||
                      						(product.speedCopyColorA0 != 0)}">
   							<tr><td>Скорость копирования для цветной печати:</td>
   								<td>
   								
   								<c:if test="${product.speedCopyColorA4 != 0}">
   									A4: ${product.speedCopyColorA4} стр/мин 
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedCopyColorA3 != 0}">
   									A3: ${product.speedCopyColorA3} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyColorA2 != 0}">
   									A2: ${product.speedCopyColorA2} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyColorA1 != 0}">
   									A1: ${product.speedCopyColorA1} стр/мин 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyColorA0 != 0}">
   									A0: ${product.speedCopyColorA0} стр/мин 
								</c:if>
								
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${product.numberOfPagesPerMonth > 0}">
   							<tr><td>Количество страниц в месяц:</td><td>${product.numberOfPagesPerMonth}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.maximumFormat}">
   							<tr><td>Максимальный формат:</td><td>${product.maximumFormat}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.automaticTwoSidedPrinting}">
   							<tr><td>Автоматическая двусторонняя печать:</td><td>${product.automaticTwoSidedPrinting}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.theMaximumResolutionForColorPrinting && product.theMaximumResolutionForColorPrinting!=''}">
   							<tr><td>Максимальное разрешение для цветной печати(0000x0000):</td><td>${product.theMaximumResolutionForColorPrinting}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.theMaximumResolutionForBWPrinting && product.theMaximumResolutionForBWPrinting!=''}">
   							<tr><td>Максимальное разрешение для ч/б печати(0000x0000):</td><td>${product.theMaximumResolutionForBWPrinting}</td></tr>
						</c:if>
                       
                       <c:if test="${product.warmUpTime > 0}">
   							<tr><td>Время разогрева:</td><td>${product.warmUpTime} с</td></tr>
						</c:if>
                       
                       <c:if test="${product.firstPrintColor > 0}">
   							<tr><td>Время выхода первого отпечатка color:</td><td>${product.firstPrintColor} с</td></tr>
						</c:if>
                       
                       <c:if test="${product.firstPrintBW > 0}">
   							<tr><td>Время выхода первого отпечатка ч/б:</td><td>${product.firstPrintBW} с</td></tr>
						</c:if>
						
						<c:if test="${!empty product.scannerType}">
   							<tr><td>Тип сканера:</td><td>
	                   			<c:forEach var="tp" items="${product.scannerType}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.theMaximumSizeOfTheOriginal}">
   							<tr><td>Максимальный формат оригинала:</td><td>${product.theMaximumSizeOfTheOriginal}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.maximumScanSize}">
   							<tr><td>Максимальный размер сканирования:</td><td>${product.maximumScanSize}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.scannerResolution}">
   							<tr><td>Разрешение сканера:</td><td>${product.scannerResolution}</td></tr>
						</c:if>
                       
                       <c:if test="${product.scanSpeedColor > 0}">
   							<tr><td>Скорость сканирования (цветн.):</td><td>До ${product.scanSpeedColor} изобр/мин</td></tr>
						</c:if>
                       
                       <c:if test="${product.scanSpeedBW > 0}">
   							<tr><td>Скорость сканирования (ч/б):</td><td>До ${product.scanSpeedBW} изобр/мин</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.sendingImagesByEmail}">
   							<tr><td>Отправка изображения по e-mail:</td><td>${product.sendingImagesByEmail}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.maximumResolutionCopierBW}">
   							<tr><td>Максимальное разрешение копира (ч/б):</td><td>${product.maximumResolutionCopierBW}</td></tr>
						</c:if>
                       
                       <c:if test="${product.firstCopyOutTime > 0}">
   							<tr><td>Время выхода первой копии:</td><td>${product.firstCopyOutTime} с</td></tr>
						</c:if>
                       
                       <c:if test="${product.zooming > 0}">
   							<tr><td>Изменение масштаба:</td><td>${product.zooming}%</td></tr>
						</c:if>
                       
                       <c:if test="${product.stepZoom > 0}">
   							<tr><td>Шаг масштабирования:</td><td>${product.stepZoom}%</td></tr>
						</c:if>
                       
                       <c:if test="${product.theMaximumNumberOfCopiesPerCycle > 0}">
   							<tr><td>Максимальное количество копий за цикл:</td><td>${product.theMaximumNumberOfCopiesPerCycle}</td></tr>
						</c:if>
                       
                       <c:if test="${product.paperFeedStandart > 0}">
   							<tr><td>Подача бумаги (стандартная):</td><td>${product.paperFeedStandart} листов</td></tr>
						</c:if>
                       
                       <c:if test="${product.paperFeedMax > 0}">
   							<tr><td>Подача бумаги (максимальная):</td><td>${product.paperFeedMax} листов</td></tr>
						</c:if>
                       
                       <c:if test="${product.paperOutputStandart > 0}">
   							<tr><td>Вывод бумаги (стандартная):</td><td>${product.paperOutputStandart} листов</td></tr>
						</c:if>
                       
                       <c:if test="${product.paperOutputMax > 0}">
   							<tr><td>Вывод бумаги (максимальная):</td><td>${product.paperOutputMax} листов</td></tr>
						</c:if>
                       
                       <c:if test="${product.theCapacityOfTheBypassTray > 0}">
   							<tr><td>Емкость лотка ручной подачи:</td><td>${product.theCapacityOfTheBypassTray} листов</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.electronicSorting}">
   							<tr><td>Электронная сортировка:</td><td>${product.electronicSorting}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.stapler}">
   							<tr><td>Степлер:</td><td>${product.stapler}</td></tr>
						</c:if>
                       
                       <c:if test="${product.paperDensity > 0}">
   							<tr><td>Плотность бумаги:</td><td>${product.paperDensity} г/м2</td></tr>
						</c:if>
                                            
                       <c:if test="${!empty product.printingOn}">
   							<tr><td>Печать на:</td><td>
	                   			<c:forEach var="tp" items="${product.printingOn}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.resourceDeveloper > 0}">
   							<tr><td>Ресурс девелопера:</td><td>${product.resourceDeveloper} страниц</td></tr>
						</c:if>
                       
                       <c:if test="${product.resourceDrum > 0}">
   							<tr><td>Ресурс фотобарабана:</td><td>${product.resourceDrum} страниц</td></tr>
						</c:if>
                       
                       <c:if test="${product.resourceBWCartridgeToner > 0}">
   							<tr><td>Ресурс ч/б картриджа/тонера:</td><td>${product.resourceBWCartridgeToner} страниц</td></tr>
						</c:if>
                       
                       <c:if test="${product.numberOfCartridges > 0}">
   							<tr><td>Количество картриджей:</td><td>${product.numberOfCartridges}</td></tr>
						</c:if>
                       
                       <c:if test="${product.memory > 0}">
   							<tr><td>Объем памяти:</td><td>${product.memory} Мб</td></tr>
						</c:if>
                       
                       <c:if test="${product.hardDriveCapacity > 0}">
   							<tr><td>Емкость жесткого диска:</td><td>${product.hardDriveCapacity} Гб</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.interfaces}">
   							<tr><td>Интерфейс подключения:</td><td>
	                   			<c:forEach var="tp" items="${product.interfaces}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if> 
                       
						<c:if test="${!empty product.directPrinting}">
   							<tr><td>Прямая печать:</td><td>${product.directPrinting}</td></tr>
						</c:if>

						<c:if test="${!empty product.webInterface}">
   							<tr><td>Веб-интерфейс:</td><td>${product.webInterface}</td></tr>
						</c:if>

						<c:if test="${!empty product.supportPostScript}">
   							<tr><td>Поддержка PostScript:</td><td>${product.supportPostScript}</td></tr>
						</c:if>

						<c:if test="${!empty product.support}">
   							<tr><td>Поддержка:</td><td>
	                   			<c:forEach var="tp" items="${product.support}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if> 

						<c:if test="${product.theNumberOfInstalledPostScriptFonts > 0}">
   							<tr><td>Количество установленных шрифтов PostScript:</td><td>${product.theNumberOfInstalledPostScriptFonts}</td></tr>
						</c:if>

						<c:if test="${product.theNumberOfInstalledPCLFonts > 0}">
   							<tr><td>Количество установленных шрифтов PCL:</td><td>${product.theNumberOfInstalledPCLFonts}</td></tr>
						</c:if>

						<c:if test="${!empty product.oSSupport}">
   							<tr><td>Поддержка ОС:</td><td>
	                   			<c:forEach var="tp" items="${product.oSSupport}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if> 

						<c:if test="${!empty product.displayInformation}">
   							<tr><td>Отображение информации:</td><td>${product.displayInformation}</td></tr>
						</c:if>

						<c:if test="${product.displaySize > 0}">
   							<tr><td>Диагональ дисплея:</td><td>${product.displaySize} дюйм</td></tr>
						</c:if>
 
 						<c:if test="${product.averagePowerConsumption > 0}">
   							<tr><td>Средняя потребляемая мощность:</td><td>${product.averagePowerConsumption} Вт</td></tr>
						</c:if>
 
                       <c:if test="${product.maxPowerConsumption > 0}">
   							<tr><td>Максимальная потребляемая мощность:</td><td>${product.maxPowerConsumption} Вт</td></tr>
						</c:if>
                       
                       <c:if test="${product.weight > 0}">
   							<tr><td>Вес:</td><td>${product.weight} кг</td></tr>
						</c:if>
                       
                       <c:if test="${product.width > 0}">
   							<tr><td>Ширина:</td><td>${product.width} мм</td></tr>
						</c:if>
                       
                       <c:if test="${product.depth > 0}">
   							<tr><td>Глубина:</td><td>${product.depth} мм</td></tr>
						</c:if> 
                       
                       <c:if test="${product.heigth > 0}">
   							<tr><td>Высота:</td><td>${product.heigth} мм</td></tr>
						</c:if>
                         
                  </table>
                  </div>
                    
                    <!-- comments to this product -->
                    <jsp:include page="../product_page/comments.jsp" />
                    
                    <!-- products use with this product -->
                    <jsp:include page="../product_page/product_use_with.jsp" />
                </div>            
            </div> 
        </div>
        
        <!-- code of javaScript in the end -->
        <jsp:include page="../product_page/timer.jsp" />
        <jsp:include page="../product_page/callback_ask_and_javascript_code.jsp" />
</body>
</html>