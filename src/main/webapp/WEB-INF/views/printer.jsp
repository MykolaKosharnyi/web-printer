<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/product.css"/>
	
	<title>${printer.name}</title>
</head>
<body>   
         <div class="product">
           <p>${printer.name}</p>
            <div id="pictures_and_descriptions">
				<div id="pictures">
				<div class="image_container">
					<img src="<%=request.getContextPath()%>/resources/images/printers/${printer.id}/${printer.pathPictures.get(0)}" alt="">
				</div>
					<div class="small_pictures">
						<c:forEach items="${printer.pathPictures}" var="pathPicture">
							<div>
								<img src="<%=request.getContextPath()%>/resources/images/printers/${printer.id}/${pathPicture}" alt="">
							</div>
						</c:forEach>
					</div>
				</div>
                <div class="descriptions">
                	<!--  <div><p class="key">Цена:</p> <p class="value">$ ${printer.prise}</p></div>
                	<div><p class="key">Тип принтера:</p> <p class="value">${printer.typePrinter}</p></div>
                	<div><p class="key">Партный номер принтера:</p> <p class="value">${printer.partNumber}</p></div>
                	<div><p class="key">Модель:</p> <p class="value">${printer.equipmentModel}</p></div>
                	<div><p class="key">Ширина печати в миллиметрах:</p> <p class="value">${printer.weightPrintMM} mm</p></div>
                	<div><p class="key">Предыдущее использование:</p> <p class="value">${printer.previouslyUsed}</p></div>-->
                    <table>
                       <caption></caption> 
                       <tr><td>Цена:</td><td>$ ${printer.prise}.</td></tr>
                       <tr><td>Тип принтера:</td><td>${printer.typePrinter}</td></tr>
                       <tr><td>Партный номер принтера:</td><td>${printer.partNumber}</td></tr>
                       <tr><td>Модель:</td><td>${printer.equipmentModel}</td></tr>
                       <tr><td>Ширина печати в миллиметрах:</td><td>${printer.weightPrintMM} mm</td></tr>
                       <tr><td>Предыдущее использование:</td><td>${printer.previouslyUsed}</td></tr>
                  </table>
                </div>
            </div>
            <div id="tabs">
                <ul>
                    <li>Описание</li>
                    <li>Технические характеристики</li>
                    <li>Отзывы</li>
                    <li>Используется с другими товарами</li>
                </ul>
                <div>
                    <div>${printer.description}</div>
                    <div>
                    <div class="descriptions">
					<table>
                       <caption></caption> 
                       <tr><td>Цена:</td><td>$ ${printer.prise}.</td></tr>
                       <tr><td>Тип принтера:</td><td>${printer.typePrinter}</td></tr>
                       <tr><td>Партный номер принтера:</td><td>${printer.partNumber}</td></tr>
                       <tr><td>Модель:</td><td>${printer.equipmentModel}</td></tr>
                       <tr><td>Ширина печати в миллиметрах:</td><td>${printer.weightPrintMM} mm</td></tr>
                       <tr><td>Предыдущее использование:</td><td>${printer.previouslyUsed}</td></tr>
                       <tr><td>Тип печати:</td><td>
	                   		<c:forEach var="tp" items="${printer.typePrint}">  
	    						${tp}<br>  
							</c:forEach>
                       </td></tr>
                       <tr><td>Подача материала:</td><td>
	                   		<c:forEach var="tp" items="${printer.feed}">  
	    						${tp}<br>  
							</c:forEach>
                       </td></tr>
                       <tr><td>Цветность:</td><td>
	                   		<c:forEach var="tp" items="${printer.chromaticity}">  
	    						${tp}<br>  
							</c:forEach>                       
                       </td></tr>
                       <tr><td>Производитель печатающей головки:</td><td>${printer.manufacturerPrinthead}</td></tr>
                       <tr><td>Тип печатающей головки:</td><td>${printer.typeOfPrinthead}</td></tr>
                       <tr><td>Совместимые чернила:</td><td>
	                   		<c:forEach var="tp" items="${printer.compatibleInk}">  
	    						${tp}<br>  
							</c:forEach>                       
                       </td></tr>
                       <tr><td>Тип капли:</td><td>
	                   		<c:forEach var="tp" items="${printer.typeDrops}">  
	    						${tp}<br>  
							</c:forEach>                        
                       </td></tr>
                       <tr><td>Размер капли:</td><td>
	                   		<c:forEach var="tp" items="${printer.sizeDrops}">  
	    						${tp} мм<br>  
							</c:forEach>                        
                       </td></tr>
                       <tr><td>Скорость печати:</td><td>${printer.speedPrint} м.кв./ч.</td></tr>
                       <tr><td>Разрешение печати:</td><td>
	                   		<c:forEach var="tp" items="${printer.printResolution}">  
	    						${tp}<br>  
							</c:forEach>                        
                       </td></tr>
                       <tr><td>Производитель оборудования:</td><td>${printer.equipmentManufacturer}</td></tr>
                       <tr><td>Интерфейс подключения:</td><td>
	                   		<c:forEach var="tp" items="${printer.interfaceConnection}">  
	    						${tp}<br>  
							</c:forEach>                       
                       </td></tr>
                       <tr><td>Максимальная толщина носителя:</td><td>${printer.maximumMediaThickness} мм</td></tr>
                       <tr><td>Максимальный вес носителя:</td><td>${printer.maximumWeightOfVehicle} кг</td></tr>
                       <tr><td>П/О RIP:</td><td>
	                   		<c:forEach var="tp" items="${printer.rip}">  
	    						${tp}<br>  
							</c:forEach>                        
                       </td></tr>
                       <tr><td>Максимальная потребляемая мощность:</td><td>${printer.maxPowerConsumption} кВт</td></tr>
                       <tr><td>Вес:</td><td>${printer.weight} кг</td></tr>
                       <tr><td>Ширина:</td><td>${printer.width} м</td></tr>
                       <tr><td>Высота:</td><td>${printer.heigth} м</td></tr>
                       <tr><td>Глубина:</td><td>${printer.depth} м</td></tr>
                  </table>
                  </div>
                    </div>
                    <div>Третье содержимое</div>
                    <div>Четвертое содержимое</div>
                </div>            
            </div> 
        </div>
    <script>
(function($){				
    jQuery.fn.lightTabs = function(options){
        
        var createTabs = function(){
            tabs = this;
            i = 0;
            
            showPage = function(i){
                $(tabs).children("div").children("div").hide();
                $(tabs).children("div").children("div").eq(i).show();
                $(tabs).children("ul").children("li").removeClass("active");
                $(tabs).children("ul").children("li").eq(i).addClass("active");
            }
            
            showPage(0);				
            
            $(tabs).children("ul").children("li").each(function(index, element){
                $(element).attr("data-page", i);
                i++;                        
            });
            
            $(tabs).children("ul").children("li").click(function(){
                showPage(parseInt($(this).attr("data-page")));
            });				
        };		
        return this.each(createTabs);
    };	
})(jQuery);
$(document).ready(function(){
    $("#tabs").lightTabs();
});
    </script>
	<script>
		$('.small_pictures div').on('click', function(e) {

			var currImg = $(this).find('img').attr('src');
			$('.image_container img').attr('src', currImg);

		});
		$(".small_pictures div").hover(function() {
			var currImg = $(this).find('img').attr('src');
			$('.image_container img').attr('src', currImg);
		});
	</script>
</body>
</html>