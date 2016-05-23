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

<a class="fancybox" data-fancybox-group="group" href="/images/use_with_products/${product.id}/${product.pathPictures.get(0)}">
<img src="/images/use_with_products/${product.id}/${product.pathPictures.get(0)}" alt="alt" /></a>
							
						</div>
					</div>

					<div class="col-md-2 col-sm-2 col-xs-2">
						<div class="row">
							<div class="small_pictures">
								<c:forEach items="${product.pathPictures}" var="pathPicture">
									<a class="fancybox" data-fancybox-group="group" href="/images/use_with_products/${product.id}/${pathPicture}">
<img src="/images/use_with_products/${product.id}/${pathPicture}" alt="alt" /></a>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
                <div class="descriptions">			
				
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