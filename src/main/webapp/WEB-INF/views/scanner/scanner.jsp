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
                	
                	<c:if test="${!empty product.partNumber}">
   						<div id="name_product_head_description">Код товара: ${product.partNumber}</div>
					</c:if>
                	
                    <table id="table_in_head">
                       <caption></caption> 
                                          
   					   <!-- set price in table row -->
					   <jsp:include page="../product_page/price.jsp" /> 
					   
                       <c:if test="${!empty product.typeProduct}">
   							<tr><td>Тип сканера:</td><td>${product.typeProduct}</td></tr>
					   </c:if>
					   
					   <c:if test="${!empty product.equipmentModel}">
   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
					   </c:if>
					   
					   <c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td>Ширина сканируемой области:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}">x${product.inputSecondWeightPrintMM}</c:if> мм</td></tr>
					   </c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.scanningWidth > 0}">
   							<tr><td>Ширина сканирования:</td><td>${product.scanningWidth} мм</td></tr>
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
            
				<!-- import tabs like description, specification, reviews etc. -->
				<jsp:include page="../product_page/tabs_product_item.jsp" />
				
                <div>
                    <!-- description on concrete language to this product -->
                    <jsp:include page="../product_page/description.jsp" />
                    
                    <div class="descriptions">
					<table>
                       
                       <c:if test="${!empty product.typeProduct}">
   							<tr><td>Тип сканера:</td><td>${product.typeProduct}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td>Код товара:</td><td>${product.partNumber}</td></tr>
						</c:if>

                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td>Ширина сканируемой области:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}">x${product.inputSecondWeightPrintMM}</c:if> мм</td></tr>
						</c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.scanningWidth > 0}">
   							<tr><td>Ширина сканирования:</td><td>${product.scanningWidth} мм</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td>Состояние оборудования:</td><td>${product.previouslyUsed}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.innings}">
   							<tr><td>Подача:</td><td>${product.innings}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.chromaticity}">
   							<tr><td>Цветность:</td><td>${product.chromaticity}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.scanningElement}">
   							<tr><td>Сканирующий элемент:</td><td>${product.scanningElement}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.lightSource}">
   							<tr><td>Источник света:</td><td>${product.lightSource}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.bitColorScanning}">
   							<tr><td>Разрядность цветного сканирования:</td><td>${product.bitColorScanning}</td></tr>
					   </c:if>
					   
					   <c:if test="${!empty product.bitScanningGrayscale}">
   							<tr><td>Разрядность сканирования с оттенками серого:</td><td>${product.bitScanningGrayscale}</td></tr>
					   </c:if>
					   
					   <c:if test="${product.softwareResolution  > 0}">
   							<tr><td>Программное разрешение:</td><td>${product.softwareResolution} dpi</td></tr>
					   </c:if>
                       
                       <c:if test="${product.scanSpeed  > 0}">
   							<tr><td>Скорость сканирования:</td><td>${product.scanSpeed} м.кв./ч.</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.opticalResolution}">
   							<tr><td>Оптическое разрешение:</td><td>${product.opticalResolution}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.connectionInterface}">
   							<tr><td>Интерфейс подключения:</td><td>
	                   			<c:forEach var="tp" items="${product.connectionInterface}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
					   </c:if>
                       
                       <c:if test="${product.theMaximumThicknessOfTheCarrier  > 0}">
   							<tr><td>Максимальная толщина  носителя:</td><td>${product.theMaximumThicknessOfTheCarrier} мм</td></tr>
					   </c:if>
                       
                      <c:if test="${!empty product.software}">
   							<tr><td>П/О:</td><td>
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
                    
                    <!-- import inaccuracy description -->
				    <jsp:include page="../product_page/inaccuracy_description.jsp" /> 
                </div>            
            </div> 
        </div>
        
        <!-- code of javaScript in the end -->
        <jsp:include page="../product_page/timer.jsp" />
        <jsp:include page="../product_page/callback_ask_and_javascript_code.jsp" />
</body>
</html>