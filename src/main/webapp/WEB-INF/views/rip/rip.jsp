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
				<!-- inport pictures presentation -->
				<jsp:include page="../product_page/pictures.jsp" />
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
                  
<div class="option_product_with_price">
	
	<c:if test="${product.optionInstallation > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Инсталяция" id="optionInstallation_price">
				<label class="add_price_title" for="optionInstallation_price">Инсталяция</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.optionInstallation}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionInstallation}</label>
		</div>
	</c:if>
                 		
	<c:if test="${product.priceAddedOption > 0.01 && (product.nameAddedOption!=null && product.nameAddedOption!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${product.nameAddedOption}" id="priceAddedOption_price">
				<label class="add_price_title" for="priceAddedOption_price">${product.nameAddedOption}</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionAddedOption}</label>
		</div>
	</c:if>
	
	<c:if test="${product.priceAddedOption2 > 0.01 && (product.nameAddedOption2!=null && product.nameAddedOption2!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${product.nameAddedOption2}" id="priceAddedOption2_price">
				<label class="add_price_title" for="priceAddedOption2_price">${product.nameAddedOption2}</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption2}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionAddedOption2}</label>
		</div>
	</c:if>
	
	<c:if test="${product.priceAddedOption3 > 0.01 && (product.nameAddedOption3!=null && product.nameAddedOption3!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${product.nameAddedOption3}" id="priceAddedOption3_price">
				<label class="add_price_title" for="priceAddedOption3_price">${product.nameAddedOption3}</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption3}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionAddedOption3}</label>
		</div>
	</c:if>
	
	<c:if test="${product.optionVAT > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="НДС" id="optionVAT_price">
				<label class="add_price_title" for="optionVAT_price">НДС</label>
			</input>
			<label class="add_price_value" style="display:none;"><span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.optionVAT}" /></span>
			</label>
			<label class="option_description" style="margin-left:65px;">${product.descriptionOptionVAT}</label>
		</div>
	</c:if>
		                  
	<label class="total_ptice_title">Стоимость:</label>
		                  
	<label class="total_price">$<span><fmt:formatNumber type="number" 
			   	maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></span>
	</label>
		                  
	<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="top: 5px; right: -30px; float: none;"
			onclick="addToCartProductPage('${type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}', getCheckedOption());"></i>                  
							 
</div>
                  
                </div>
            </div>
            <div id="tabs_product">
                <ul id="sub_tabs_product">
                    <li>Описание</li>
                    <li>Технические характеристики</li>
                    <li>Отзывы</li>
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
                </div>            
            </div> 
        </div>
        
        <!-- form for asking about product - give opportunity to user ask question
        and code of javaScript in the end -->
        <jsp:include page="../product_page/callback_ask_and_javascript_code.jsp" />
</body>
</html>