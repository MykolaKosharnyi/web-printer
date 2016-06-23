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
				
                	<div id="name_product_head_description">${product.name}</div>
                	<div id="name_product_head_description">Код товара: ${product.partNumber}</div>
                    <table id="table_in_head">
                       <caption></caption> 
                                          
   					   <!-- set price in table row -->
					   <jsp:include page="../product_page/price.jsp" /> 
					   
                       <c:if test="${!empty product.typeProduct}">
   							<tr><td>Тип товара:</td><td>${product.typeProduct}</td></tr>
					   </c:if> 
					   
                  </table>
                  
				<div class="option_product_with_price">
					                  
					<label class="total_ptice_title">Стоимость:</label>
						                  
					<label class="total_price">$<span><fmt:formatNumber type="number" 
							   	maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></span>
					</label>
						                  
					<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="top: 5px; right: -30px; float: none;"
			onclick="addToCart('${type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}');"></i>	                  
					
				</div>
             </div>
          </div>
            <div id="tabs_product">
                <ul id="sub_tabs_product">
                    <li>Описание</li>
                </ul>
                <div>
                    <div id="output_description">${product.description}</div>
                </div>            
            </div> 
        </div>

		<!-- form for asking about product - give opportunity to user ask question -->
<div class="hidden">
	<form id="callback" class="pop_form">
		<h5 style="max-width: 300px;">Пожалуйста оставьте координаты, через некоторое время мы с вами свяжемся</h5>
		<input type="hidden" name="id" value="${product.id}">
		<input type="hidden" name="typeProduct" value="${type}">
		<input type="text" name="name" placeholder="Ваше имя..." required />
		<input type="text" name="phone" placeholder="Ваше телефон..." required />
		<button class="button" type="submit">Уточнить</button>
	</form>
</div>
</body>
</html>