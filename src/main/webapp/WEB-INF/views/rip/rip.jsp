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

<a class="fancybox" data-fancybox-group="group" href="/images/rips/${product.id}/${product.pathPictures.get(0)}">
<img src="/images/rips/${product.id}/${product.pathPictures.get(0)}" alt="alt" /></a>
							
						</div>
					</div>

					<div class="col-md-2 col-sm-2 col-xs-2">
						<div class="row">
							<div class="small_pictures">
								<c:forEach items="${product.pathPictures}" var="pathPicture">
<a class="fancybox" data-fancybox-group="group" href="/images/rips/${product.id}/${pathPicture}">
<img src="/images/rips/${product.id}/${pathPicture}" alt="alt" /></a>
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
					   
                       <c:if test="${!empty product.typeEquipment}">
   							<tr><td>Тип ПО:</td><td>${product.typeEquipment}</td></tr>
					   </c:if>
					   
                  </table>
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
                       
                       <c:if test="${!empty product.typeEquipment}">
   							<tr><td>Тип ПО:</td><td>${product.typeEquipment}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td>Код товара:</td><td>${product.partNumber}</td></tr>
					   </c:if>
                       
                        <c:if test="${!empty product.softwareMaker}">
   							<tr><td>Производитель ПО:</td><td>${product.softwareMaker}</td></tr>
						</c:if>   
						
						<c:if test="${!empty product.softwareClass}">
   							<tr><td>Класс ПО:</td><td>${product.softwareClass}</td></tr>
						</c:if> 
						
						<c:if test="${!empty product.softwareVersion}">
   							<tr><td>Версия ПО:</td><td>${product.softwareVersion}</td></tr>
						</c:if> 
                  </table>
                  </div>
                    
                    <div>Третье содержимое</div>
                    <div>Четвертое содержимое</div>
                </div>            
            </div> 
        </div>
	<script type="text/javascript">
		var current = new Date();
		var toDate = new Date(${product.timeShares.getTime()});
		var clock = $('.your-clock').FlipClock((toDate.getTime()-current.getTime())/1000, {
		clockFace: 'DailyCounter',
		countdown: true,
		language: 'ru',
		showSeconds: false
		});
	</script>
</body>
</html>