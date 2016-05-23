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
				<div id="pictures">
					<div class="col-md-10 col-sm-10 col-xs-10">
						<div class="row bigImage">

<a class="fancybox" data-fancybox-group="group" href="/images/3d_printers/${product.id}/${product.pathPictures.get(0)}">
<img src="/images/3d_printers/${product.id}/${product.pathPictures.get(0)}" alt="alt" /></a>
							
						</div>
					</div>

					<div class="col-md-2 col-sm-2 col-xs-2">
						<div class="row">
							<div class="small_pictures">
								<c:forEach items="${product.pathPictures}" var="pathPicture">
									<a class="fancybox" data-fancybox-group="group" href="/images/3d_printers/${product.id}/${pathPicture}">
<img src="/images/3d_printers/${product.id}/${pathPicture}" alt="alt" /></a>
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
				<div id="name_product_head_description">Код товара:
					${product.partNumber}</div>
				<table id="table_in_head">
					<caption></caption>

					<tr>
						<td>Цена:</td>
						<td><c:if test="${product.prise < 0.1}"> уточняйте</c:if> <c:if
								test="${!(product.prise < 0.1)}">					
   											$<fmt:formatNumber type="number" maxFractionDigits="2"
									minFractionDigits="2" value="${product.prise}" />
							</c:if></td>
					</tr>

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
                    
                    <jsp:include page="../product_use_with.jsp" />
                </div>            
            </div> 
        </div>
    <script type="text/javascript">
		var current = new Date();
		var miliseconds = ${product.timeShares.getTime()};
		var toDate = new Date(miliseconds);
		var clock = $('.your-clock').FlipClock((toDate.getTime()-current.getTime())/1000, {
		clockFace: 'DailyCounter',
		countdown: true,
		language: 'ru',
		showSeconds: false
		});
	</script>
</body>
</html>