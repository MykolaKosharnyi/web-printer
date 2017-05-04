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
					   
                       <c:if test="${!empty product.typeEquipment}">
   							<tr><td>Тип ПО:</td><td>${product.typeEquipment}</td></tr>
					   </c:if>
					   
                  </table>
                  
			<!-- import opportunity add to product's price, price for different services -->
			<jsp:include page="../product_page/option_product_with_price_rip_uwp.jsp" />
                  
          </div>
		</div>
            <div id="tabs_product">
                <ul id="sub_tabs_product">
                    <li>Описание</li>
                    <li>Технические характеристики</li>
                    <li>Отзывы</li>
                    <li>Уточнение описания</li>
                    
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
                    
                    <!-- comments to this product -->
                    <jsp:include page="../product_page/comments.jsp" />
                    
                    <!-- import inaccuracy description -->
				    <jsp:include page="../product_page/inaccuracy_description.jsp" /> 

                </div>            
            </div> 
        </div>
        
        <!-- javaScript in the end -->
        <jsp:include page="../product_page/timer.jsp" />
        <jsp:include page="../product_page/callback_ask_and_javascript_code.jsp" />
</body>
</html>