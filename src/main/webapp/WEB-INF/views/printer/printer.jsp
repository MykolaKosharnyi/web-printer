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
				<!-- import pictures presentation -->
				<jsp:include page="../product_page/pictures.jsp" />
				
                <div class="descriptions">
 			
 				<!-- import timer -->
				<jsp:include page="../product_page/clock.jsp" />
					
                <div id="name_product_head_description">${product.name}</div>
                	
                <c:if test="${!empty product.partNumber}">
                	<div id="name_product_head_description">Код товара: ${product.partNumber}</div>
				</c:if>
					<div class="outer_table_in_head">
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
						   
	                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
	   							<tr><td>Ширина печати:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}"> x ${product.inputSecondWeightPrintMM}</c:if> мм</td></tr>
							</c:if>
	                       
	                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.weightPrintMM > 0}">
	   							<tr><td>Ширина печати:</td><td>${product.weightPrintMM} мм</td></tr>
							</c:if>
	                  </table>
                  </div>
                  
                <!-- import opportunity add to product's price, price for different services -->
				<jsp:include page="../product_page/option_product_with_price.jsp" />
                  
                 <c:if test="${!empty product.availability && empty product.availabilitySpecialCase}">
                 	<div id="commom_information"><em>Наличие:</em> ${product.availability}</div>
                 </c:if>
                 
                 <c:if test="${!empty product.availabilitySpecialCase}">
                 	<div id="commom_information"><em>Наличие:</em> ${product.availabilitySpecialCase}</div>
                 </c:if>
                 
                 <c:if test="${!empty product.guarantee}">
                 	<div id="commom_information"><em>Гарантия:</em> ${product.guarantee} месяцев официальной гарантии от производителя.</div>
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
                       
                       <c:if test="${!empty product.typePrinter}">
   							<tr><td>Тип принтера:</td><td>${product.typePrinter}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td>Код товара:</td><td>${product.partNumber}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.equipmentModel}">
   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
					   </c:if>
                       
                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td>Ширина печати:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}"> x ${product.inputSecondWeightPrintMM}</c:if> мм</td></tr>
					   </c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.weightPrintMM > 0}">
   							<tr><td>Ширина печати:</td><td>${product.weightPrintMM} мм</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td>Состояние оборудования:</td><td>${product.previouslyUsed}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.typePrint}">
   							<tr><td>Тип печати:</td><td>${product.typePrint}</td></tr>
						</c:if>
						
						<c:if test="${(product.lengthWaveUVlamp > 0) || (product.powerUVlamp > 0) || 
                      					(product.lengthWaveLEDmodule > 0) || (product.powerLEDmodule > 0) }">
   							<tr><td>UV Блок:</td>
   								<td>
   								
   								<c:if test="${(product.lengthWaveUVlamp > 0) || (product.powerUVlamp > 0)}">
   									UV лампа:
   									<br/>
   									<c:if test="${product.lengthWaveUVlamp > 0}">длинна волны ${product.lengthWaveUVlamp} нм;</c:if>
   									<br/>
   									<c:if test="${product.powerUVlamp > 0}">мощность UV излучения ${product.powerUVlamp} Вт;</c:if>
   									<br/>
   									<c:if test="${product.quantityUVlamp > 0}">количество ${product.quantityUVlamp} шт;</c:if>
   									<br/>
								</c:if>
								
								<c:if test="${(product.lengthWaveLEDmodule > 0) || (product.powerLEDmodule > 0)}">
   									LED модуль:
   									<br/>
   									<c:if test="${product.lengthWaveLEDmodule > 0}">длинна волны ${product.lengthWaveLEDmodule} нм;</c:if>
   									<br/>
   									<c:if test="${product.powerLEDmodule > 0}">мощность UV излучения ${product.powerLEDmodule} Вт;</c:if>
   									<br/>
   									<c:if test="${product.quantityLEDmodule > 0}">количество ${product.quantityLEDmodule} шт;</c:if>
								</c:if>
   							
   								</td>
   							</tr>
						</c:if>
						
                       <c:if test="${!empty product.feed}">
   							<tr><td>Подача материала:</td><td>
		                   		<c:forEach var="tp" items="${product.feed}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
						
						<c:if test="${!empty product.chromaticity}">
   							<tr><td>Цветовая схема:</td><td>
		                   		<c:forEach var="tp" items="${product.chromaticity}" varStatus="status">  
		                   		
		                   			<c:if test="${tp.equals('CMYK')}">
										${tp}<c:if test="${product.chromaticityCMYK!=''}" > + ${product.chromaticityCMYK}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
									</c:if>
									
									<c:if test="${tp.equals('CMYK x 2')}">
										${tp}<c:if test="${product.chromaticityCMYKx2!=''}" > + ${product.chromaticityCMYKx2}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
									</c:if>
									
									<c:if test="${tp.equals('CMYKLcLm')}">
										${tp}<c:if test="${product.chromaticityCMYKLcLm!=''}" > + ${product.chromaticityCMYKLcLm}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
									</c:if>
									
									<c:if test="${tp.equals('CMYKLcLmOG')}">
										${tp}<c:if test="${product.chromaticityCMYKLcLmOG!=''}" > + ${product.chromaticityCMYKLcLmOG}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
									</c:if>
		    						
								</c:forEach>
                       		</td></tr>
						</c:if>

						<c:if test="${!empty product.manufacturerPrinthead}">
   							<tr><td>Производитель печатающей головки:</td><td>${product.manufacturerPrinthead}</td></tr>
						</c:if>

                       <c:if test="${!empty product.typeOfPrinthead}">
   							<tr><td>Тип печатающей головки:</td><td>${product.typeOfPrinthead}</td></tr>
						</c:if>
						
						<c:if test="${ (product.numberOfPrintheads > 0) || (product.onEachColorNumberOfPrintheads > 0) ||
						       (product.whiteColorNumberOfPrintheads > 0) || (product.varnishNumberOfPrintheads > 0) || 
						       (product.firstTypeNumberOfPrintheads > 0) || (product.secondTypeNumberOfPrintheads > 0) }">
   							<tr>
   								<td>Количество печатающих головок:</td>
   								<td>
   									<c:if test="${product.numberOfPrintheads > 0}">
   										${product.numberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.onEachColorNumberOfPrintheads > 0}">
   										На каждый цвет - ${product.onEachColorNumberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.whiteColorNumberOfPrintheads > 0}">
   										Белый цвет - ${product.whiteColorNumberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.varnishNumberOfPrintheads > 0}">
   										Лак - ${product.varnishNumberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.firstTypeNumberOfPrintheads > 0}">
   										${product.firstEmptyNameTypeNumberOfPrintheads} - ${product.firstTypeNumberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.secondTypeNumberOfPrintheads > 0}">
   										${product.secondEmptyNameTypeNumberOfPrintheads} - ${product.secondTypeNumberOfPrintheads} шт
										<br/>
									</c:if>
   								</td>
   							</tr>
						</c:if>
						
						<c:if test="${ (product.averageConsumptionOfCMYKink > 0) || (product.averageConsumptionOfWhiteInk > 0) ||
						       (product.averageDischarge1 > 0) || (product.averageDischarge2 > 0) || (product.averageDischarge3 > 0) }">
   							<tr>
   								<td>Расход чернил:</td>
   								<td>
   									<c:if test="${product.averageConsumptionOfCMYKink > 0}">
   										Средний расход чернил CMYK - ${product.averageConsumptionOfCMYKink} мл./м.кв.
										<br/>
									</c:if>
									<c:if test="${product.averageConsumptionOfWhiteInk > 0}">
   										Средний расход белых чернил - ${product.averageConsumptionOfWhiteInk} мл./м.кв.
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge1 > 0}">
   										Средний расход ${product.nameOfAverageDischarge1} - ${product.averageDischarge1} мл./м.кв.
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge2 > 0}">
   										Средний расход ${product.nameOfAverageDischarge2} - ${product.averageDischarge2} мл./м.кв.
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge3 > 0}">
   										Средний расход ${product.nameOfAverageDischarge3} - ${product.averageDischarge3} мл./м.кв.
									</c:if>
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.compatibleInk}">
   							<tr><td>Совместимые чернила:</td><td>
	                   			<c:forEach var="tp" items="${product.compatibleInk}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeDrops}">
   							<tr><td>Тип капли:</td><td>
	                   			<c:forEach var="tp" items="${product.typeDrops}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.sizeDropStatic > 0}">
   							<tr><td>Размер капли (постоянная):</td><td>${product.sizeDropStatic} pl</td></tr>
						</c:if>
						
						<c:if test="${product.valueOfNewTypeDrop > 0}">
   							<tr><td>Размер капли (product.nameOfNewTypeDrop):</td><td>${product.valueOfNewTypeDrop} pl</td></tr>
						</c:if>
                       
                       <c:if test="${(product.sizeDropRangeFrom > 0) && (product.sizeDropRangeUntil > 0) &&
                       					(product.sizeDropRangeFrom < product.sizeDropRangeUntil)}">
   								<tr><td>Размер капли:</td><td>
	                   			Переменная от ${product.sizeDropRangeFrom} pl до ${product.sizeDropRangeUntil} pl                     
                       			</td></tr>
						</c:if>
						
						<c:if test="${(product.sizeDropRangeFrom < 0.001) || (product.sizeDropRangeUntil < 0.001) ||
                       					(product.sizeDropRangeFrom > product.sizeDropRangeUntil)}">
                       		<c:if test="${!empty product.sizeDrops}">
   								<tr><td>Размер капли:</td><td>
	                   			<c:forEach var="tp" items="${product.sizeDrops}" varStatus="status">  
	    								${tp} pl<c:if test="${ ! status.last}" >, </c:if>  
									</c:forEach>                        
                       			</td></tr>
							</c:if>
						</c:if>
                      
                      	<c:if test="${(product.speedPrintDraft > 0.001) || (product.speedPrintFast > 0.001) || 
                      					(product.speedPrintNormal > 0.001) || (product.speedPrintQuality > 0.001) ||
                      						(product.speedPrintHiQual > 0.001) || (product.speedPrint1 > 0.001) ||
                      						(product.speedPrint2 > 0.001) || (product.speedPrint3 > 0.001) ||
                      						(product.speedPrint4 > 0.001) || (product.speedPrint5 > 0.001)}">
   							<tr><td>Скорость печати:</td>
   								<td>
   								
   								<c:if test="${product.speedPrintDraft > 0.001}">
   									Draft Speed:<c:if test="${product.speedPrintDraftPass > 0}"> ${product.speedPrintDraftPass} pass</c:if><c:if test="${product.speedPrintDraftResolution!='None'}"> ${product.speedPrintDraftResolution} dpi -</c:if> ${product.speedPrintDraft} м.кв./ч.
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedPrintFast > 0.001}">
   									Fast Speed:<c:if test="${product.speedPrintFastPass > 0}"> ${product.speedPrintFastPass} pass</c:if><c:if test="${product.speedPrintFastResolution!='None'}"> ${product.speedPrintFastResolution} dpi -</c:if> ${product.speedPrintFast} м.кв./ч.
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintNormal > 0.001}">
   									Normal Speed:<c:if test="${product.speedPrintNormalPass > 0}"> ${product.speedPrintNormalPass} pass</c:if><c:if test="${product.speedPrintNormalResolution!='None'}"> ${product.speedPrintNormalResolution} dpi -</c:if> ${product.speedPrintNormal} м.кв./ч.
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintQuality > 0.001}">
   									Quality Speed:<c:if test="${product.speedPrintQualityPass > 0}"> ${product.speedPrintQualityPass} pass</c:if><c:if test="${product.speedPrintQualityResolution!='None'}"> ${product.speedPrintQualityResolution} dpi -</c:if> ${product.speedPrintQuality} м.кв./ч.
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintHiQual > 0.001}">
   									Hi-Quality Speed:<c:if test="${product.speedPrintHiqualPass > 0}"> ${product.speedPrintHiqualPass} pass</c:if><c:if test="${product.speedPrintHiqualResolution!='None'}"> ${product.speedPrintHiqualResolution} dpi -</c:if> ${product.speedPrintHiQual} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint1 > 0.001}">
   									<c:if test="${product.speedPrintPass1 > 0}">${product.speedPrintPass1} pass </c:if><c:if test="${product.speedPrintResolution1!='None'}"> ${product.speedPrintResolution1} dpi -</c:if> ${product.speedPrint1} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint2 > 0.001}">
   									<c:if test="${product.speedPrintPass2 > 0}">${product.speedPrintPass2} pass </c:if><c:if test="${product.speedPrintResolution2!='None'}"> ${product.speedPrintResolution2} dpi -</c:if> ${product.speedPrint2} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint3 > 0.001}">
   									<c:if test="${product.speedPrintPass3 > 0}">${product.speedPrintPass3} pass </c:if><c:if test="${product.speedPrintResolution3!='None'}"> ${product.speedPrintResolution3} dpi -</c:if> ${product.speedPrint3} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint4 > 0.001}">
   									<c:if test="${product.speedPrintPass4 > 0}">${product.speedPrintPass4} pass </c:if><c:if test="${product.speedPrintResolution4!='None'}"> ${product.speedPrintResolution4} dpi -</c:if> ${product.speedPrint4} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint5 > 0.001}">
   									<c:if test="${product.speedPrintPass5 > 0}">${product.speedPrintPass5} pass </c:if><c:if test="${product.speedPrintResolution5!='None'}"> ${product.speedPrintResolution5} dpi -</c:if> ${product.speedPrint5} м.кв./ч.
								</c:if>
   								</td>
   							</tr>
						</c:if>
                      
                      <c:if test="${product.inputFirstPrintResolution != 0 && product.inputSecondPrintResolution != 0}">
   							<tr><td>Разрешение печати:</td><td>${product.inputFirstPrintResolution}x${product.inputSecondPrintResolution}dpi</td></tr>
						</c:if>
                      
                      	<c:if test="${(product.inputFirstPrintResolution == 0 || product.inputSecondPrintResolution == 0) && !empty product.printResolution}">
   							<tr><td>Разрешение печати:</td><td>
	                   			<c:forEach var="tp" items="${product.printResolution}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                      		 </td></tr>
						</c:if>
                      
                      	<c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td>Производитель оборудования:</td><td>${product.equipmentManufacturer}</td></tr>
						</c:if>
                      
                      	<c:if test="${!empty product.interfaceConnection}">
   							<tr><td>Интерфейс подключения:</td><td>
	                   			<c:forEach var="tp" items="${product.interfaceConnection}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.maximumMediaThickness > 0}">
   							<tr><td>Максимальная толщина носителя:</td><td>${product.maximumMediaThickness} мм</td></tr>
						</c:if>
                       
                       <c:if test="${product.maximumWeightOfVehicle > 0}">
   							<tr><td>Максимальный вес носителя:</td><td>${product.maximumWeightOfVehicle} кг</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.rip}">
   							<tr><td>Программное обеспечение:</td><td>
	                   			<c:forEach var="tp" items="${product.rip}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                       		</td></tr>
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