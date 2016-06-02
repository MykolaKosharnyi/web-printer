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

</body>
</html>