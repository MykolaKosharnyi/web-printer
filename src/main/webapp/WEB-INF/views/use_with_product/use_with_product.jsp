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
				
                	<div id="name_product_head_description">${product.name}</div>
                	
                	<c:if test="${!empty product.partNumber}">
   						<div id="name_product_head_description">Код товара: ${product.partNumber}</div>
					</c:if>
                	
                    <table id="table_in_head">
                       <caption></caption> 
                                          
   					   <!-- set price in table row -->
   					   <c:if test="${!empty product.typeProduct && product.typeProduct!='Чернила для струйной печати'}">
   							<jsp:include page="../product_page/price.jsp" />
					   </c:if>  
					   
                       <c:if test="${!empty product.typeProduct}">
   							<tr><td>Тип товара:</td><td>${product.typeProduct}</td></tr>
					   </c:if> 
					   <c:if test="${product.typeProduct=='Чернила для струйной печати' && !empty product.typeInk}">
   							<tr><td>Тип краски:</td><td>${product.typeInk}</td></tr>
					   </c:if> 
					   
                  </table>
                  
			<!-- import opportunity add to product's price, price for different services -->
			<jsp:include page="../product_page/option_product_with_price_rip_uwp.jsp" />
   	   </div>
	</div>
            <div id="tabs_product">
                <ul id="sub_tabs_product">
                    <li>Описание</li>
                    <li>Отзывы</li>
                    <li>Уточнение описания</li>
                   
                </ul>
                <div>
                    <!-- description on concrete language to this product -->
                    <jsp:include page="../product_page/description.jsp" />
                    
                    <!-- comments to this product -->
                    <jsp:include page="../product_page/comments.jsp" />
                    
                    <!-- import inaccuracy description -->
					<jsp:include page="../product_page/inaccuracy_description.jsp" /> 
                </div>            
            </div> 
</div>

	<!-- code of javaScript in the end -->
	<jsp:include page="../product_page/callback_ask_and_javascript_code.jsp" />
	
</body>
</html>