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
					   
                       <c:if test="${!empty product.typeLaser}">
   							<tr><td>Тип лазера:</td><td>${product.typeLaser}</td></tr>
					   </c:if>
					   
					   <c:if test="${!empty product.equipmentModel}">
   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
						</c:if>
						
						<c:if test="${product.sizeWorkAreaX > 0 || product.sizeWorkAreaY > 0 || product.sizeWorkAreaZ > 0}">
   							<tr><td>Размер рабочей области:</td><td>${product.sizeWorkAreaX}
   							<c:if test="${product.sizeWorkAreaY > 0}" > x ${product.sizeWorkAreaY}</c:if>
   							<c:if test="${product.sizeWorkAreaZ > 0}" > x ${product.sizeWorkAreaZ}</c:if> мм</td></tr>
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
                       
                       <c:if test="${!empty product.typeLaser}">
   							<tr><td>Тип лазера:</td><td>${product.typeLaser}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td>Код товара:</td><td>${product.partNumber}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.previouslyUsed}">
   							<tr><td>Состояние оборудования:</td><td>${product.previouslyUsed}</td></tr>
						</c:if>
						
                       <c:if test="${product.sizeWorkAreaX > 0}">
   							<tr><td>Размер рабочей области по оси Х:</td><td>${product.sizeWorkAreaX} мм</td></tr>
						</c:if>
						
                       <c:if test="${product.sizeWorkAreaY > 0}">
   							<tr><td>Размер рабочей области по оси Y:</td><td>${product.sizeWorkAreaY} мм</td></tr>
						</c:if>
                       
                       <c:if test="${product.sizeWorkAreaZ > 0}">
   							<tr><td>Размер рабочей области по оси Z:</td><td>${product.sizeWorkAreaZ} мм</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeOfCooling}">
   							<tr><td>Тип охлаждения:</td><td>${product.typeOfCooling}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.colorSeparation}">
   							<tr><td>Цветоделение:</td><td>${product.colorSeparation}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.typeTheDisplayedImage}">
   							<tr><td>Тип выводимого изображения:</td><td>
		                   		<c:forEach var="tp" items="${product.typeTheDisplayedImage}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
						
						<c:if test="${product.firstPartTheMinimumCharacterSize > 0 && product.secondPartTheMinimumCharacterSize > 0}">
   							<tr><td>Минимальный размер символа:</td><td>${product.firstPartTheMinimumCharacterSize}x${product.secondPartTheMinimumCharacterSize} мм</td></tr>
						</c:if>
                       
                       <c:if test="${product.maximumResolution > 0}">
   							<tr><td>Максимальное разрешение:</td><td>${product.maximumResolution} DPI</td></tr>
						</c:if>
						
						<c:if test="${product.maximumPositioningAccuracy > 0}">
   							<tr><td>Предельная точность позиционирования:</td><td>${product.maximumPositioningAccuracy} мм</td></tr>
						</c:if>
						
						<c:if test="${product.firstPartAdjustingTheLaserPower > 0 && product.secondPartAdjustingTheLaserPower > 0}">
   							<tr><td>Регулировка мощности лазера:</td><td>${product.firstPartAdjustingTheLaserPower} - ${product.secondPartAdjustingTheLaserPower}%</td></tr>
						</c:if>
						
						<c:if test="${!empty product.specialPurpose || !empty product.specialPurpose1 ||
									 !empty product.specialPurpose2 || !empty product.specialPurpose3}">
   							<tr><td>Целевое назначение:</td><td>
		                   		<c:forEach var="tp" items="${product.specialPurpose}">  
		    						${tp}; 
		    						<br/>
								</c:forEach>
								
								<c:if test="${!empty product.specialPurpose1}">
   									${product.specialPurpose1};
   									<br/>
								</c:if>
								
								<c:if test="${!empty product.specialPurpose2}">
   									${product.specialPurpose2};
   									<br/>
								</c:if>
								
								<c:if test="${!empty product.specialPurpose3}">
   									${product.specialPurpose3};
								</c:if>
                       		</td></tr>
						</c:if>

						<c:if test="${product.laserWavelength > 0}">
   							<tr><td>Длинна волны лазера:</td><td>${product.laserWavelength} nm</td></tr>
						</c:if>
						
						<c:if test="${product.laserPulse0 > 0 && product.laserPulse1 > 0}">
   							<tr><td>Импульс лазера:</td><td>${product.laserPulse0}-${product.laserPulse1} Hz</td></tr>
						</c:if>
						
						<c:if test="${product.theDiameterOfTheLaser > 0}">
   							<tr><td>Диаметр лазера:</td><td>${product.theDiameterOfTheLaser} мм</td></tr>
						</c:if>
						
						<c:if test="${product.engravingDepth > 0}">
   							<tr><td>Глубина гравировки:</td><td>${product.engravingDepth} мм</td></tr>
						</c:if>
						
						<c:if test="${product.laserSource > 0}">
   							<tr><td>Ресурс лазера:</td><td>${product.laserSource} часов</td></tr>
						</c:if>
                       
                       <c:if test="${product.numberOfHeads > 0}">
   							<tr><td>Количество головок:</td><td>${product.numberOfHeads} шт</td></tr>
						</c:if>
						
						<c:if test="${product.positioningSpeed > 0}">
   							<tr><td>Скорость позиционирования:</td><td>${product.positioningSpeed} м/мин</td></tr>
						</c:if>
                       
                       <c:if test="${product.powerOfLaser > 0}">
   							<tr><td>Мощность лазера:</td><td>${product.powerOfLaser} Вт</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeEngine}">
   							<tr><td>Тип двигателя:</td><td>${product.typeEngine}</td></tr>
						</c:if>
                       
                       <c:if test="${product.mechanicalResolution > 0}">
   							<tr><td>Механическое разрешение:</td><td>${product.mechanicalResolution} мм/шаг</td></tr>
						</c:if>
                       
                       <c:if test="${product.softwareResolution > 0}">
   							<tr><td>Программное разрешение:</td><td>${product.softwareResolution} мм/шаг</td></tr>
						</c:if>
                       
                       <c:if test="${product.minimumThicknessOfCut > 0}">
   							<tr><td>Минимальная толщина реза:</td><td>${product.minimumThicknessOfCut} мм</td></tr>
						</c:if>
                       
                       <c:if test="${product.engravingSpeed > 0}">
   							<tr><td>Скорость гравировки:</td><td>${product.engravingSpeed} мм/мин</td></tr>
						</c:if>
                       
                       <c:if test="${product.cuttingSpeed > 0}">
   							<tr><td>Скорость резки:</td><td>${product.cuttingSpeed} мм/мин</td></tr>
						</c:if>
                       
                        <c:if test="${!empty product.connectionInterface}">
   							<tr><td>Интерфейс подключения:</td><td>
		                   		<c:forEach var="tp" items="${product.connectionInterface}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.fileTypes}">
   							<tr><td>Типы файлов:</td><td>
		                   		<c:forEach var="tp" items="${product.fileTypes}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
						
						<c:if test="${!empty product.software}">
   							<tr><td>Програмное обеспечение:</td><td>
		                   		<c:forEach var="tp" items="${product.software}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td>Производитель оборудования:</td><td>${product.equipmentManufacturer}</td></tr>
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