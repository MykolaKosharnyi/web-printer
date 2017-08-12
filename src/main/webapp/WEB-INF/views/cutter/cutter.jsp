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
	<title>
		<c:choose>   
	         <c:when test = "${localeCode == 'en' && !empty product.engNameProduct}">
	            ${product.engNameProduct}
	         </c:when>
	         
	         <c:otherwise>
	            ${product.name}
	         </c:otherwise>
		</c:choose>
	</title>
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
				
     <div id="name_product_head_description">
		<c:choose>   
	         <c:when test = "${localeCode == 'en' && !empty product.engNameProduct}">
	            ${product.engNameProduct}
	         </c:when>
	         
	         <c:otherwise>
	            ${product.name}
	         </c:otherwise>
		</c:choose>
	</div>
                	
                	<c:if test="${!empty product.partNumber}">
   						<div id="name_product_head_description"><custom:getDescriptionByLocale description="${d_search.product_code}"/>: ${product.partNumber}</div>
					</c:if>
                	
                    <table id="table_in_head">
                       <caption></caption> 
                                          
   					   <!-- set price in table row -->
					   <jsp:include page="../product_page/price.jsp" /> 
					   
                       <c:if test="${!empty product.typeCutter}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_cutter.type_engraver_router}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeCutter}" properties="${cutter.type_cutter}"/></td>
   							</tr>
					   </c:if>
					   
					   <c:if test="${!empty product.equipmentModel}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.model}"/>:</td><td>${product.equipmentModel}</td></tr>
						</c:if>
						
						<c:if test="${product.sizeWorkAreaX > 0 || product.sizeWorkAreaY > 0 || product.sizeWorkAreaZ > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.size_working_area}"/>:</td><td>${product.sizeWorkAreaX}
   							<c:if test="${product.sizeWorkAreaY > 0}" > x ${product.sizeWorkAreaY}</c:if>
   							<c:if test="${product.sizeWorkAreaZ > 0}" > x ${product.sizeWorkAreaZ}</c:if> <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
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
                       
                       <c:if test="${!empty product.typeCutter}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_cutter.type_engraver_router}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeCutter}" properties="${cutter.type_cutter}"/></td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.product_code}"/>:</td><td>${product.partNumber}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.previouslyUsed}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/>:</td>
   								<td><custom:singleProperty productValue="${product.previouslyUsed}" properties="${cutter.previously_used}"/></td></tr>
						</c:if>
						
                       <c:if test="${product.sizeWorkAreaX > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.size_working_area}"/> <custom:getDescriptionByLocale description="${search_cutter.size_working_area_x}"/>:</td><td>${product.sizeWorkAreaX} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
						
                       <c:if test="${product.sizeWorkAreaY > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.size_working_area}"/> <custom:getDescriptionByLocale description="${search_cutter.size_working_area_y}"/>:</td><td>${product.sizeWorkAreaY} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.sizeWorkAreaZ > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.size_working_area}"/> <custom:getDescriptionByLocale description="${search_cutter.size_working_area_z}"/>:</td><td>${product.sizeWorkAreaZ} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeOfCooling}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_cutter.type_cooling}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeOfCooling}" properties="${cutter.type_of_cooling}"/></td>
   							</tr>
						</c:if>
						
						<c:if test="${product.numberOfSpindles > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.number_spindles}"/>:</td><td>${product.numberOfSpindles} <custom:getDescriptionByLocale description="${d_search.pc}"/></td></tr>
						</c:if>
						
						<c:if test="${product.positioningSpeed > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.positioning_speed}"/>:</td><td>${product.positioningSpeed} <custom:getDescriptionByLocale description="${d_search.m_min}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeEngine}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_cutter.type_engine}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeEngine}" properties="${cutter.type_engine}"/></td>
   							</tr>
						</c:if>
						
						<c:if test="${!empty product.engravingStyle}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_cutter.engraving_type}"/>:</td>
   								<td><custom:singleProperty productValue="${product.engravingStyle}" properties="${cutter.engraving_style}"/></td>
   							</tr>
						</c:if>
                       
                       <c:if test="${product.mechanicalResolution > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.mechanical_resolution}"/>:</td><td>${product.mechanicalResolution} <custom:getDescriptionByLocale description="${d_search.mm_step}"/></td></tr>
						</c:if>
						
						<c:if test="${product.softwareResolution > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.software_permission}"/>:</td><td>${product.softwareResolution} <custom:getDescriptionByLocale description="${d_search.mm_step}"/></td></tr>
						</c:if>
						
						<c:if test="${product.frequencySpindle > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.rotational_speed_spindle}"/>:</td><td>${product.frequencySpindle} <custom:getDescriptionByLocale description="${d_search.rpm}"/></td></tr>
						</c:if>
						
						<c:if test="${product.processingSpeedXY > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.processing_speed_XY}"/>:</td><td>${product.processingSpeedXY} <custom:getDescriptionByLocale description="${d_search.mm_s}"/></td></tr>
						</c:if>
						
						<c:if test="${product.processingSpeedZ > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.processing_speed_Z}"/>:</td><td>${product.processingSpeedZ} <custom:getDescriptionByLocale description="${d_search.mm_s}"/></td></tr>
						</c:if>
						
						<c:if test="${!empty product.mountingTool}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_cutter.tool_holder}"/>:</td>
   								<td><custom:singleProperty productValue="${product.mountingTool}" properties="${cutter.mounting_tool}"/></td>
   							</tr>
						</c:if>

                        <c:if test="${!empty product.connectionInterface}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.interface_connection}"/>:</td><td>
		                   		<c:forEach var="tp" items="${product.connectionInterface}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
						
						<c:if test="${!empty product.software}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.software}"/>:</td><td>
		                   		<c:forEach var="tp" items="${product.software}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>

                       <c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td><custom:getDescriptionByLocale description="${search_cutter.equipment_manufacturer}"/>:</td><td>${product.equipmentManufacturer}</td></tr>
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