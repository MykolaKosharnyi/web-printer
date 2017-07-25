<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
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
 
                <!-- inport timer -->
				<jsp:include page="../product_page/clock.jsp" />    				
				
                	<div id="name_product_head_description">${product.name}</div>
                	
                	<c:if test="${!empty product.partNumber}">
   						<div id="name_product_head_description"><custom:getDescriptionByLocale description="${d_search.product_code}"/>: ${product.partNumber}</div>
					</c:if>
					
                    <table id="table_in_head">
                       <caption></caption> 
                                          
   					   <!-- set price in table row -->
					   <jsp:include page="../product_page/price.jsp" /> 
					   
                       <c:if test="${!empty product.typeProduct}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.type_laminator}"/>:</td><td>${product.typeProduct}</td></tr>
					   </c:if>
					   
					   <c:if test="${!empty product.equipmentModel}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.model}"/>:</td><td>${product.equipmentModel}</td></tr>
						</c:if>
						
						<c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.lamination_area}"/>:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}">x${product.inputSecondWeightPrintMM}</c:if> <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.laminatingWidth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.width_lamination}"/>:</td><td>${product.laminatingWidth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
		
                  </table>
                  
                     <!-- import opportunity add to product's price, price for different services -->
				    <jsp:include page="../product_page/option_product_with_price.jsp" />
                  
                    <!-- import availability of this product -->
				    <jsp:include page="../product_page/availability.jsp" />
				    
				    <!-- import guarantee of this product -->
				    <jsp:include page="../product_page/guarantee.jsp" />
                </div>
            </div>
            <div id="tabs_product">
            
				<!-- import tabs like description, specification, reviews etc. -->
				<jsp:include page="../product_page/tabs_product_item.jsp" />
				
                <div>
                    <!-- description on concrete language to this product -->
                    <jsp:include page="../product_page/description.jsp" />
                    
                    <div class="descriptions">
					<table>
                       
                       <c:if test="${!empty product.typeProduct}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.type_laminator}"/>:</td><td>${product.typeProduct}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.product_code}"/>:</td><td>${product.partNumber}</td></tr>
						</c:if>

                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.lamination_area}"/>:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}">x${product.inputSecondWeightPrintMM}</c:if> <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.laminatingWidth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.width_lamination}"/>:</td><td>${product.laminatingWidth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/>:</td><td>${product.previouslyUsed}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.innings}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.innings}"/>:</td><td>${product.innings}</td></tr>
						</c:if>
                       
                       <c:if test="${product.numberOfShafts  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.number_shafts}"/>:</td><td>${product.numberOfShafts}</td></tr>
						</c:if>

						<c:if test="${product.shaftDiameter  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.shaft_diameter}"/>:</td><td>${product.shaftDiameter} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
						
						<c:if test="${product.filmThickness  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.film_thickness}"/>:</td><td>${product.filmThickness} <custom:getDescriptionByLocale description="${d_search.mkm}"/></td></tr>
						</c:if>
						
						<c:if test="${product.warmUpTime  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.warm_up_time}"/>:</td><td>${product.warmUpTime} <custom:getDescriptionByLocale description="${d_search.minutes}"/></td></tr>
						</c:if>
						
						<c:if test="${product.laminationTemperature  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.lamination_temperature}"/>:</td><td>${product.laminationTemperature} С</td></tr>
						</c:if>
						
						<c:if test="${product.laminatingSpeed  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.laminating_speed}"/>:</td><td>${product.laminatingSpeed} <custom:getDescriptionByLocale description="${d_search.mm_s}"/></td></tr>
						</c:if>
						
						
						<c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laminator.equipment_manufacturer}"/>:</td><td>${product.equipmentManufacturer}</td></tr>
						</c:if>
                       
                       <c:if test="${product.averagePowerConsumption > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.averagePowerConsumption}"/>:</td><td>${product.averagePowerConsumption} <custom:getDescriptionByLocale description="${d_search.w}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.maxPowerConsumption > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.maxPowerConsumption}"/>:</td><td>${product.maxPowerConsumption} <custom:getDescriptionByLocale description="${d_search.w}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.weight > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.weight}"/>:</td><td>${product.weight} <custom:getDescriptionByLocale description="${d_search.kg}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.width > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.width}"/>:</td><td>${product.width} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.depth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.depth}"/>:</td><td>${product.depth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.heigth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.height}"/>:</td><td>${product.heigth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
 
                  </table>
                  </div>
                    
					<!-- comments to this product -->
                    <jsp:include page="../product_page/comments.jsp" />
                    
                    <!-- products with use with this product -->
                    <jsp:include page="../product_page/product_use_with.jsp" />
                    
                    <!-- import inaccuracy description -->
				    <jsp:include page="../product_page/inaccuracy_description.jsp" />
                </div>            
            </div> 
        </div>
        
        <!-- code of javaScript in the end -->
        <jsp:include page="../product_page/timer.jsp" />
        <jsp:include page="../product_page/callback_ask_and_javascript_code.jsp" />
</body>
</html>