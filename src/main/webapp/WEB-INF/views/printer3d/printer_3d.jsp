<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/product.css"/>
    
	<script src="<%=request.getContextPath()%>/resources/js/user/product.js"></script>
	<title>${product.name}</title>
</head>
<body>   
         <div class="product">
            <div id="pictures_and_descriptions">
				<!-- inport pictures presentation -->
				<jsp:include page="../product_page/pictures.jsp" />
			<div class="descriptions">

			<!-- import timer -->
			<jsp:include page="../product_page/clock.jsp" />

				<div id="name_product_head_description">${product.name}</div>
				<div id="name_product_head_description">Код товара:
					${product.partNumber}</div>
				<table id="table_in_head">
					<caption></caption>

					<!-- set price in table row -->
					<jsp:include page="../product_page/price.jsp" /> 

					<c:if test="${!empty product.typePrinter3D}">
						<tr>
							<td>Тип принтера:</td>
							<td>${product.typePrinter3D}</td>
						</tr>
					</c:if>
					
					<c:if test="${!empty product.equipmentModel}">
   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
					</c:if>
					
					 <c:if test="${product.sizePrintableAreaX > 0 || product.sizePrintableAreaY > 0 || product.sizePrintableAreaZ > 0}">
   							<tr><td>Размер запечатываемой области:</td><td>${product.sizePrintableAreaX}
   							<c:if test="${product.sizePrintableAreaY > 0}" > x ${product.sizePrintableAreaY}</c:if>
   							<c:if test="${product.sizePrintableAreaZ > 0}" > x ${product.sizePrintableAreaZ}</c:if> мм</td></tr>
					</c:if>

				</table>
				
				<!-- import opportunity add to product's price, price for different services -->
				<jsp:include page="../product_page/option_product_with_price.jsp" />
                  
                 <c:if test="${!empty product.availability && empty product.availabilitySpecialCase}">
                 	<div id="commom_information"><em>Наличие:</em> ${product.availability}</div>
                 </c:if>
                 
                 <c:if test="${!empty product.availabilitySpecialCase}">
                 	<div id="commom_information"><em>Наличие:</em> ${product.availabilitySpecialCase}</div>
                 </c:if>
				
				<c:if test="${!empty product.guarantee}">
					<div id="commom_information">
						<em>Гарантия:</em> ${product.guarantee} месяцев официальной
						гарантии от производителя.
					</div>
				</c:if>
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
                       
                       <c:if test="${!empty product.typePrinter3D}">
   							<tr><td>Тип принтера:</td><td>${product.typePrinter3D}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td>Код товара:</td><td>${product.partNumber}</td></tr>
						</c:if>
                       
                       <c:if test="${product.sizePrintableAreaX > 0}">
   							<tr><td>Размер запечатываемой области по оси Х:</td><td>${product.sizePrintableAreaX} мм</td></tr>
						</c:if>
						
						<c:if test="${product.sizePrintableAreaY > 0}">
   							<tr><td>Размер запечатываемой области по оси Y:</td><td>${product.sizePrintableAreaY} мм</td></tr>
						</c:if>
                       
                       	<c:if test="${product.sizePrintableAreaZ > 0}">
   							<tr><td>Размер запечатываемой области по оси Z:</td><td>${product.sizePrintableAreaZ} мм</td></tr>
						</c:if>
						
						<c:if test="${!empty product.typeExtruder}">
   							<tr><td>Тип Экструдера:</td><td>${product.typeExtruder}</td></tr>
						</c:if>	
						
						<c:if test="${product.extruderNumber > 0}">
   							<tr><td>Количество экструдеров:</td><td>${product.extruderNumber}</td></tr>
						</c:if>
						
						<c:if test="${product.speedOfMovingThePrintHead > 0}">
   							<tr><td>Скорость перемещения печатной головки:</td><td>${product.speedOfMovingThePrintHead} мм/с</td></tr>
						</c:if>
						
						<c:if test="${product.positioningAccuracyOfThePrintHead > 0}">
   							<tr><td>Точность позиционирования печатной головки:</td><td>${product.positioningAccuracyOfThePrintHead} мкм</td></tr>
						</c:if>
						
						<c:if test="${!empty product.airflowModels}">
   							<tr><td>Обдув модели:</td><td>${product.airflowModels}</td></tr>
						</c:if>	
						
						<c:if test="${product.numberOfFansForBlowingModels > 0}">
   							<tr><td>Кол-во вентиляторов для обдува модели:</td><td>${product.numberOfFansForBlowingModels}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td>Состояние оборудования:</td><td>${product.previouslyUsed}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.printTechnology}">
   							<tr><td>Технология печати:</td><td>${product.printTechnology}</td></tr>
						</c:if>
                       
						<c:if test="${!empty product.chromaticity}">
   							<tr><td>Цветовая схема:</td><td>
		                   		<c:forEach var="tp" items="${product.chromaticity}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if> 
								</c:forEach>
                       		</td></tr>
						</c:if>
						
                       <c:if test="${!empty product.typeOfPrinthead}">
   							<tr><td>Тип печатающей головки:</td><td>${product.typeOfPrinthead}</td></tr>
						</c:if>						
						
                       <c:if test="${product.meltingPointOfThePrintingMaterial > 0}">
   							<tr><td>Температура плавления печатного материала:</td><td>${product.meltingPointOfThePrintingMaterial}</td></tr>
						</c:if>							
						
                      	<c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td>Производитель оборудования:</td><td>${product.equipmentManufacturer}</td></tr>
						</c:if>						
					
						<c:if test="${!empty product.media}">
   							<tr><td>Материал для печати:</td><td>
		                   		<c:forEach var="tp" items="${product.media}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>
								</c:forEach>
                       		</td></tr>
						</c:if>					
					
                      	<c:if test="${product.sizeExtruder > 0}">
   							<tr><td>Размер эктрудера:</td><td>${product.sizeExtruder} мм</td></tr>
						</c:if>						
					
                      	<c:if test="${product.speedPrint > 0}">
   							<tr><td>Скорость печати:</td><td>${product.speedPrint} м.кв./ч.</td></tr>
						</c:if>					
					
                      	<c:if test="${product.thicknessOfThePrintingLayer > 0}">
   							<tr><td>Толщина слоя печати:</td><td>${product.thicknessOfThePrintingLayer}</td></tr>
						</c:if>						
					
                      	<c:if test="${!empty product.interfaceConnection}">
   							<tr><td>Интерфейс подключения:</td><td>
	                   			<c:forEach var="tp" items="${product.interfaceConnection}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>					
					
                      	<c:if test="${!empty product.typesOfFiles}">
   							<tr><td>Тыпы файлов:</td><td>
	                   			<c:forEach var="tp" items="${product.typesOfFiles}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>						
					
                       <c:if test="${!empty product.rip}">
   							<tr><td>Программное обеспечение:</td><td>
	                   			<c:forEach var="tp" items="${product.rip}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                       		</td></tr>
						</c:if>					
					
                      	<c:if test="${product.maximumWeightOfThePrintedModel > 0}">
   							<tr><td>Максимальная масса распечатываемой модели:</td><td>${product.maximumWeightOfThePrintedModel}</td></tr>
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
                    <div>Третье содержимое</div>
                    
                    <jsp:include page="../product_page/product_use_with.jsp" />
                </div>            
            </div> 
        </div>
        
        <!-- form for asking about product - give opportunity to user ask question
        and code of javaScript in the end -->
        <jsp:include page="../product_page/callback_ask_and_javascript_code.jsp" />
</body>
</html>