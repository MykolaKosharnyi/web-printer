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
					   
                       <c:if test="${!empty product.typeLaser}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_laser.type_laser}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeLaser}" properties="${laser.type_laser}"/></td>
   							</tr>
					   </c:if>
					   
					   <c:if test="${!empty product.equipmentModel}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.model}"/>:</td><td>${product.equipmentModel}</td></tr>
						</c:if>
						
						<c:if test="${product.sizeWorkAreaX > 0 || product.sizeWorkAreaY > 0 || product.sizeWorkAreaZ > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.size_working_area}"/>:</td><td>${product.sizeWorkAreaX}
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
                       
                       <c:if test="${!empty product.typeLaser}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_laser.type_laser}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeLaser}" properties="${laser.type_laser}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.product_code}"/>:</td><td>${product.partNumber}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.previouslyUsed}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/>:</td>
   								<td><custom:singleProperty productValue="${product.previouslyUsed}" properties="${laser.previously_used}"/></td></tr>
						</c:if>
						
                       <c:if test="${product.sizeWorkAreaX > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.size_working_area}"/> <custom:getDescriptionByLocale description="${search_laser.size_working_area_x}"/>:</td><td>${product.sizeWorkAreaX} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
						
                       <c:if test="${product.sizeWorkAreaY > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.size_working_area}"/> <custom:getDescriptionByLocale description="${search_laser.size_working_area_x}"/>:</td><td>${product.sizeWorkAreaY} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.sizeWorkAreaZ > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.size_working_area}"/> <custom:getDescriptionByLocale description="${search_laser.size_working_area_x}"/>:</td><td>${product.sizeWorkAreaZ} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeOfCooling}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_laser.type_cooling}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeOfCooling}" properties="${laser.type_of_cooling}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.colorSeparation}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_laser.color_separation}"/>:</td>
   								<td><custom:singleProperty productValue="${product.colorSeparation}" properties="${laser.color_separation}"/></td>
   							</tr>
						</c:if>
						
						<c:if test="${!empty product.typeTheDisplayedImage}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_laser.type_output_image}"/>:</td>
   								<td><custom:multipleProperty productValues="${product.typeTheDisplayedImage}" properties="${laser.type_the_displayed_image}"/></td>
   							</tr>
						</c:if>
						
						<c:if test="${product.firstPartTheMinimumCharacterSize > 0 && product.secondPartTheMinimumCharacterSize > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.minimum_character_size}"/>:</td><td>${product.firstPartTheMinimumCharacterSize}x${product.secondPartTheMinimumCharacterSize} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.maximumResolution > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.maximum_resolution}"/>:</td><td>${product.maximumResolution} DPI</td></tr>
						</c:if>
						
						<c:if test="${product.maximumPositioningAccuracy > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.limiting_positioning_accuracy}"/>:</td><td>${product.maximumPositioningAccuracy} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
						
						<c:if test="${product.firstPartAdjustingTheLaserPower > 0 && product.secondPartAdjustingTheLaserPower > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.laser_power_adjustment}"/>:</td><td>${product.firstPartAdjustingTheLaserPower} - ${product.secondPartAdjustingTheLaserPower}%</td></tr>
						</c:if>
						
						<c:if test="${!empty product.specialPurpose || !empty product.specialPurpose1 ||
									 !empty product.specialPurpose2 || !empty product.specialPurpose3}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_laser.special_purpose}"/>:</td>
   								<td><custom:multipleProperty productValues="${product.specialPurpose}" properties="${laser.special_purpose}"/>
								
								<c:if test="${!empty product.specialPurpose1}">
   									${product.specialPurpose1};
   									<br/>
								</c:if>
								
								<c:if test="${!empty product.specialPurpose2}">
   									${product.specialPurpose2};
   									<br/>
								</c:if>
								
								<c:if test="${!empty product.specialPurpose3}">
   									${product.specialPurpose3};
								</c:if>
                       		</td></tr>
						</c:if>

						<c:if test="${product.laserWavelength > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.laser_wave_length}"/>:</td><td>${product.laserWavelength} nm</td></tr>
						</c:if>
						
						<c:if test="${product.laserPulse0 > 0 && product.laserPulse1 > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.laser_pulse}"/>:</td><td>${product.laserPulse0}-${product.laserPulse1} Hz</td></tr>
						</c:if>
						
						<c:if test="${product.theDiameterOfTheLaser > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.diameter_laser}"/>:</td><td>${product.theDiameterOfTheLaser} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
						
						<c:if test="${product.engravingDepth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.engraving_depth}"/>:</td><td>${product.engravingDepth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
						
						<c:if test="${product.laserSource > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.laser_resource}"/>:</td><td>${product.laserSource} <custom:getDescriptionByLocale description="${d_search.hours}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.numberOfHeads > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.number_heads}"/>:</td><td>${product.numberOfHeads} <custom:getDescriptionByLocale description="${d_search.pc}"/></td></tr>
						</c:if>
						
						<c:if test="${product.positioningSpeed > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.positioning_speed}"/>:</td><td>${product.positioningSpeed} <custom:getDescriptionByLocale description="${d_search.m_min}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.powerOfLaser > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.laser_power}"/>:</td><td>${product.powerOfLaser} <custom:getDescriptionByLocale description="${d_search.w}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeEngine}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_laser.type_engine}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeEngine}" properties="${laser.type_engine}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.mechanicalResolution > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.mechanical_resolution}"/>:</td><td>${product.mechanicalResolution} <custom:getDescriptionByLocale description="${d_search.mm_step}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.softwareResolution > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.software_permission}"/>:</td><td>${product.softwareResolution} <custom:getDescriptionByLocale description="${d_search.mm_step}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.minimumThicknessOfCut > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.minimum_thickness_cut}"/>:</td><td>${product.minimumThicknessOfCut} <custom:getDescriptionByLocale description="${d_search.mkm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.engravingSpeed > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.engraving_speed}"/>:</td><td>${product.engravingSpeed} <custom:getDescriptionByLocale description="${d_search.mm_min}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.cuttingSpeed > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.cutting_speed}"/>:</td><td>${product.cuttingSpeed} <custom:getDescriptionByLocale description="${d_search.mm_min}"/></td></tr>
						</c:if>
                       
                        <c:if test="${!empty product.connectionInterface}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.interface_connection}"/>:</td><td>
		                   		<c:forEach var="tp" items="${product.connectionInterface}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.fileTypes}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.file_types}"/>:</td><td>
		                   		<c:forEach var="tp" items="${product.fileTypes}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
						
						<c:if test="${!empty product.software}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.software}"/>:</td><td>
		                   		<c:forEach var="tp" items="${product.software}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td><custom:getDescriptionByLocale description="${search_laser.equipment_manufacturer}"/>:</td><td>${product.equipmentManufacturer}</td></tr>
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