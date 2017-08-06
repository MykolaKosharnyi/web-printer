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
 
                <!-- import timer -->
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
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_scanner.scanner_type}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeProduct}" properties="${scanner.type_product}"/></td>
   							</tr>
					   </c:if>
					   
					   <c:if test="${!empty product.equipmentModel}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.model}"/>:</td><td>${product.equipmentModel}</td></tr>
					   </c:if>
					   
					   <c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.scan_width}"/>:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}">x${product.inputSecondWeightPrintMM}</c:if> <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
					   </c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.scanningWidth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.scan_width}"/>:</td><td>${product.scanningWidth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
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
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_scanner.scanner_type}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeProduct}" properties="${scanner.type_product}"/></td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.product_code}"/>:</td><td>${product.partNumber}</td></tr>
						</c:if>

                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.scan_width}"/>:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}">x${product.inputSecondWeightPrintMM}</c:if> <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.scanningWidth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.scan_width}"/>:</td><td>${product.scanningWidth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/>:</td>
   								<td><custom:singleProperty productValue="${product.previouslyUsed}" properties="${scanner.previously_used}"/></td>
   							</tr>
					   </c:if>
                       
                       <c:if test="${!empty product.innings}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_scanner.innings}"/>:</td>
   								<td><custom:singleProperty productValue="${product.innings}" properties="${scanner.innings}"/></td>
   							</tr>
					   </c:if>
                       
                       <c:if test="${!empty product.chromaticity}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_scanner.color}"/>:</td>
   								<td><custom:singleProperty productValue="${product.chromaticity}" properties="${scanner.chromaticity}"/></td>
   							</tr>
					   </c:if>
                       
                       <c:if test="${!empty product.scanningElement}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.scanning_element}"/>:</td><td>${product.scanningElement}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.lightSource}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_scanner.light_source}"/>:</td>
   								<td><custom:singleProperty productValue="${product.lightSource}" properties="${scanner.light_source}"/></td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.bitColorScanning}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_scanner.color_scanning_resolution}"/>:</td>
   								<td><custom:singleProperty productValue="${product.bitColorScanning}" properties="${scanner.bit_color_scanning}"/></td>
   							</tr>
					   </c:if>
					   
					   <c:if test="${!empty product.bitScanningGrayscale}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_scanner.scan_depth_with_grayscale}"/>:</td>
   								<td><custom:singleProperty productValue="${product.bitScanningGrayscale}" properties="${scanner.bit_scanning_grayscale}"/></td>
   							</tr>
					   </c:if>
					   
					   <c:if test="${product.softwareResolution  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.software_permission}"/>:</td><td>${product.softwareResolution} dpi</td></tr>
					   </c:if>
                       
                       <c:if test="${product.scanSpeed  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.scanning_speed}"/>:</td><td>${product.scanSpeed} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/></td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.opticalResolution}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.optical_resolution}"/>:</td><td>${product.opticalResolution}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.connectionInterface}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.interface_connection}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.connectionInterface}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
					   </c:if>
                       
                       <c:if test="${product.theMaximumThicknessOfTheCarrier  > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.maximum_carrier_thickness}"/>:</td><td>${product.theMaximumThicknessOfTheCarrier} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
					   </c:if>
                       
                      <c:if test="${!empty product.software}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.software}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.software}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
					  </c:if> 	
						
					   <c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td><custom:getDescriptionByLocale description="${search_scanner.equipment_manufacturer}"/>:</td><td>${product.equipmentManufacturer}</td></tr>
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
                    
                    <!-- products use with this product -->
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