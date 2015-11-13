<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/product.css"/>
	
	<script src="<%=request.getContextPath()%>/resources/js/user/product.js"></script>
	<title>${product.name}</title>
</head>
<body>   
         <div class="product">
            <div id="pictures_and_descriptions">
				<div id="pictures">
				<div class="image_container">
					<img src="<%=request.getContextPath()%>/resources/images/printers/${product.id}/${product.pathPictures.get(0)}" alt="">
				</div>
					<div class="small_pictures">
						<c:forEach items="${product.pathPictures}" var="pathPicture">
							<div>
								<img src="<%=request.getContextPath()%>/resources/images/printers/${product.id}/${pathPicture}" alt="">
							</div>
						</c:forEach>
					</div>
				</div>
                <div class="descriptions">
                	<div id="name_product_head_description">${product.name}, партный номер ${product.partNumber}</div>
                    <table id="table_in_head">
                       <caption></caption> 
                       
                       <c:if test="${!empty product.prise}">
   							<tr><td>Цена:</td><td>$ ${product.prise}.</td></tr>
						</c:if>
                       <c:if test="${!empty product.typePrinter}">
   							<tr><td>Тип принтера:</td><td>${product.typePrinter}</td></tr>
						</c:if>
                       <c:if test="${!empty product.equipmentModel}">
   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
						</c:if>
                       <c:if test="${!empty product.weightPrintMM}">
   							<tr><td>Ширина печати в миллиметрах:</td><td>${product.weightPrintMM} mm</td></tr>
						</c:if>
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td>Предыдущее использование:</td><td>${product.previouslyUsed}</td></tr>
					    </c:if>
                  </table>
                  <div id="commom_information"><em>Гарантия:</em> 12 месяцев официальной гарантии от производителя, обмен/возврат товара в течение 14 дней.</div>
                </div>
            </div>
            <div id="tabs_product">
                <ul>
                    <li>Описание</li>
                    <li>Технические характеристики</li>
                    <li>Отзывы</li>
                    <li>Используется с другими товарами</li>
                </ul>
                <div>
                    <div id="output_description">${product.description}</div>
                    <div>
                    <div class="descriptions">
					<table>
                       <caption></caption> 

                       <c:if test="${!empty product.prise}">
   							<tr><td>Цена:</td><td>$ ${product.prise}.</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typePrinter}">
   							<tr><td>Тип принтера:</td><td>${product.typePrinter}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td>Партный номер принтера:</td><td>${product.partNumber}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.equipmentModel}">
   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.weightPrintMM}">
   							<tr><td>Ширина печати в миллиметрах:</td><td>${product.weightPrintMM} mm</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td>Предыдущее использование:</td><td>${product.previouslyUsed}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typePrint}">
   							<tr><td>Тип печати:</td><td>
		                   		<c:forEach var="tp" items="${product.typePrint}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>
								</c:forEach>
                       		</td></tr>
						</c:if>
						
                       <c:if test="${!empty product.feed}">
   							<tr><td>Подача материала:</td><td>
		                   		<c:forEach var="tp" items="${product.feed}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
						
						<c:if test="${!empty product.chromaticity}">
   							<tr><td>Цветность:</td><td>
		                   		<c:forEach var="tp" items="${product.chromaticity}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if> 
								</c:forEach>
                       		</td></tr>
						</c:if>

						<c:if test="${!empty product.manufacturerPrinthead}">
   							<tr><td>Производитель печатающей головки:</td><td>${product.manufacturerPrinthead}</td></tr>
						</c:if>

                       <c:if test="${!empty product.typeOfPrinthead}">
   							<tr><td>Тип печатающей головки:</td><td>${product.typeOfPrinthead}</td></tr>
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
                       
                       <c:if test="${!empty product.sizeDrops}">
   							<tr><td>Размер капли:</td><td>
	                   			<c:forEach var="tp" items="${product.sizeDrops}" varStatus="status">  
	    							${tp} mm<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                       		</td></tr>
						</c:if>
                      
                      	<c:if test="${!empty product.speedPrint}">
   							<tr><td>Скорость печати:</td><td>${product.speedPrint} м.кв./ч.</td></tr>
						</c:if>
                      
                      	<c:if test="${!empty product.printResolution}">
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
                       
                       <c:if test="${!empty product.maximumMediaThickness}">
   							<tr><td>Максимальная толщина носителя:</td><td>${product.maximumMediaThickness} мм</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.maximumWeightOfVehicle}">
   							<tr><td>Максимальный вес носителя:</td><td>${product.maximumWeightOfVehicle} кг</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.rip}">
   							<tr><td>П/О RIP:</td><td>
	                   			<c:forEach var="tp" items="${product.rip}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.maxPowerConsumption}">
   							<tr><td>Максимальная потребляемая мощность:</td><td>${product.maxPowerConsumption} кВт</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.weight}">
   							<tr><td>Вес:</td><td>${product.weight} кг</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.width}">
   							<tr><td>Ширина:</td><td>${product.width} м</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.heigth}">
   							<tr><td>Высота:</td><td>${product.heigth} м</td></tr>
						</c:if>
                       
                        <c:if test="${!empty product.depth}">
   							<tr><td>Глубина:</td><td>${product.depth} м</td></tr>
						</c:if>   
                  </table>
                  </div>
                    </div>
                    <div>Третье содержимое</div>
                    <div>Четвертое содержимое</div>
                </div>            
            </div> 
        </div>
</body>
</html>