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
				<div id="pictures">
					<div class="col-md-10 col-sm-10 col-xs-10">
						<div class="row bigImage">

<a class="fancybox" data-fancybox-group="group" href="/images/cutters/${product.id}/${product.pathPictures.get(0)}">
<img src="/images/cutters/${product.id}/${product.pathPictures.get(0)}" alt="alt" /></a>
							
						</div>
					</div>

					<div class="col-md-2 col-sm-2 col-xs-2">
						<div class="row">
							<div class="small_pictures">
								<c:forEach items="${product.pathPictures}" var="pathPicture">
									<a class="fancybox" data-fancybox-group="group" href="/images/cutters/${product.id}/${pathPicture}">
<img src="/images/cutters/${product.id}/${pathPicture}" alt="alt" /></a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
                <div class="descriptions">
 
                         <c:if test="${!empty product.timeShares}">					
   							<div class="your-clock"></div>
						</c:if>     				
				
                	<div id="name_product_head_description">${product.name}</div>
                	<div id="name_product_head_description">Код товара: ${product.partNumber}</div>
                    <table id="table_in_head">
                       <caption></caption> 
                                          
   							<tr>
   								<td>Цена:</td>
   								<td><c:if test="${product.prise < 0.1}"> уточняйте</c:if>
										<c:if test="${!(product.prise < 0.1)}">					
   											$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
										</c:if>
           						</td>
           					</tr>
					   
                       <c:if test="${!empty product.typeCutter}">
   							<tr><td>Тип фрезера:</td><td>${product.typeCutter}</td></tr>
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
                       
                       <c:if test="${!empty product.typeCutter}">
   							<tr><td>Тип фрезера:</td><td>${product.typeCutter}</td></tr>
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
						
						<c:if test="${product.numberOfSpindles > 0}">
   							<tr><td>Количество шпинделей:</td><td>${product.numberOfSpindles} шт</td></tr>
						</c:if>
						
						<c:if test="${product.positioningSpeed > 0}">
   							<tr><td>Скорость позиционирования:</td><td>${product.positioningSpeed} м/мин</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeEngine}">
   							<tr><td>Тип двигателя:</td><td>${product.typeEngine}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.engravingStyle}">
   							<tr><td>Тип гравировки:</td><td>${product.engravingStyle}</td></tr>
						</c:if>
                       
                       <c:if test="${product.mechanicalResolution > 0}">
   							<tr><td>Механическое разрешение:</td><td>${product.mechanicalResolution} мм/шаг</td></tr>
						</c:if>
						
						<c:if test="${product.softwareResolution > 0}">
   							<tr><td>Программное разрешение:</td><td>${product.softwareResolution} мм/шаг</td></tr>
						</c:if>
						
						<c:if test="${product.frequencySpindle > 0}">
   							<tr><td>Частота вращения шпинделя:</td><td>${product.frequencySpindle} об/мин</td></tr>
						</c:if>
						
						<c:if test="${product.processingSpeedXY > 0}">
   							<tr><td>Скорость обработки(XY):</td><td>${product.processingSpeedXY} мм/с</td></tr>
						</c:if>
						
						<c:if test="${product.processingSpeedZ > 0}">
   							<tr><td>Скорость обработки(Z):</td><td>${product.processingSpeedZ} мм/с</td></tr>
						</c:if>
						
						<c:if test="${!empty product.mountingTool}">
   							<tr><td>Крепление инструмента:</td><td>${product.mountingTool}</td></tr>
						</c:if>

                        <c:if test="${!empty product.connectionInterface}">
   							<tr><td>Интерфейс подключения:</td><td>
		                   		<c:forEach var="tp" items="${product.connectionInterface}" varStatus="status">  
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
                       
                       <c:if test="${product.heigth > 0}">
   							<tr><td>Высота:</td><td>${product.heigth} мм</td></tr>
						</c:if>
                       
                        <c:if test="${product.depth > 0}">
   							<tr><td>Глубина:</td><td>${product.depth} мм</td></tr>
						</c:if>   
                  </table>
                  </div>
                    
                    <div>Третье содержимое</div>
                    
                    <jsp:include page="../product_use_with.jsp" />
                </div>            
            </div> 
        </div>

</body>
</html>