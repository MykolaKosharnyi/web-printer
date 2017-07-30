<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/product.css"/>
    
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

					<c:if test="${!empty product.typePrinter3D}">
						<tr>
							<td><custom:getDescriptionByLocale description="${search_3d_printer.printer_type}"/>:</td>
							<td><custom:singleProperty productValue="${product.typePrinter3D}" properties="${printer.type_printer_3d}"/></td>
						</tr>
					</c:if>
					
					<c:if test="${!empty product.equipmentModel}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.model}"/>:</td><td>${product.equipmentModel}</td></tr>
					</c:if>
					
					 <c:if test="${product.sizePrintableAreaX > 0 || product.sizePrintableAreaY > 0 || product.sizePrintableAreaZ > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.size_area_printed}"/>:</td><td>${product.sizePrintableAreaX}
   							<c:if test="${product.sizePrintableAreaY > 0}" > x ${product.sizePrintableAreaY}</c:if>
   							<c:if test="${product.sizePrintableAreaZ > 0}" > x ${product.sizePrintableAreaZ}</c:if> <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
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
                       
                       <c:if test="${!empty product.typePrinter3D}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.printer_type}"/>:</td>
   							<td><custom:singleProperty productValue="${product.typePrinter3D}" properties="${printer.type_printer_3d}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.product_code}"/>:</td><td>${product.partNumber}</td></tr>
						</c:if>
                       
                       <c:if test="${product.sizePrintableAreaX > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.size_area_printed}"/> <custom:getDescriptionByLocale description="${search_3d_printer.size_area_printed_x}"/>:</td><td>${product.sizePrintableAreaX} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
						
						<c:if test="${product.sizePrintableAreaY > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.size_area_printed}"/> <custom:getDescriptionByLocale description="${search_3d_printer.size_area_printed_y}"/>:</td><td>${product.sizePrintableAreaY} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       	<c:if test="${product.sizePrintableAreaZ > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.size_area_printed}"/> <custom:getDescriptionByLocale description="${search_3d_printer.size_area_printed_z}"/>:</td><td>${product.sizePrintableAreaZ} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
						
						<c:if test="${!empty product.typeExtruder}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_3d_printer.type_extruder}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeExtruder}" properties="${printer.type_extruder}"/></td></tr>
						</c:if>	
						
						<c:if test="${product.extruderNumber > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.number_extruders}"/>:</td><td>${product.extruderNumber}</td></tr>
						</c:if>
						
						<c:if test="${product.speedOfMovingThePrintHead > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.print_head_speed}"/>:</td><td>${product.speedOfMovingThePrintHead} <custom:getDescriptionByLocale description="${d_search.mm_s}"/></td></tr>
						</c:if>
						
						<c:if test="${product.positioningAccuracyOfThePrintHead > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.printhead_positioning_accuracy}"/>:</td><td>${product.positioningAccuracyOfThePrintHead} <custom:getDescriptionByLocale description="${d_search.mkm}"/></td></tr>
						</c:if>
						
						<c:if test="${!empty product.airflowModels}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_3d_printer.blowing_model}"/>:</td>
   								<td><custom:singleProperty productValue="${product.airflowModels}" properties="${printer.airflow_models}"/></td></tr>
						</c:if>	
						
						<c:if test="${product.numberOfFansForBlowingModels > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.number_fans_blowing_model}"/>:</td><td>${product.numberOfFansForBlowingModels}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/>:</td> 							
   							<td><custom:singleProperty productValue="${product.previouslyUsed}" properties="${printer.previously_used}"/></td></tr>
						</c:if>
						
						<c:if test="${!empty product.printTechnology}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.printing_technology}"/>:</td><td>${product.printTechnology}</td></tr>
						</c:if>
                       
						<c:if test="${!empty product.chromaticity}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_3d_printer.color}"/>:</td>
   								<td><custom:multipleProperty productValues="${product.chromaticity}" properties="${printer.chromaticity}"/></td>
                       		</tr>
						</c:if>
						
                       <c:if test="${!empty product.typeOfPrinthead}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_3d_printer.print_head_type}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeOfPrinthead}" properties="${printer.type_of_printhead}"/></td></tr>
						</c:if>						
						
                       <c:if test="${product.meltingPointOfThePrintingMaterial > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.melting_point_printed_matter}"/>:</td><td>${product.meltingPointOfThePrintingMaterial} C</td></tr>
						</c:if>							
						
                      	<c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.equipment_manufacturer}"/>:</td><td>${product.equipmentManufacturer}</td></tr>
						</c:if>						
					
						<c:if test="${!empty product.media}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_3d_printer.material_printing}"/>:</td>
   								<td><custom:multipleProperty productValues="${product.media}" properties="${printer.media}"/></td></tr>
						</c:if>					
					
                      	<c:if test="${product.sizeExtruder > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.extruder_size}"/>:</td><td>${product.sizeExtruder} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>						
					
                      	<c:if test="${product.speedPrint > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.print_speed}"/>:</td><td>${product.speedPrint} м.кв./ч.</td></tr>
						</c:if>					
					
                      	<c:if test="${product.thicknessOfThePrintingLayer > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.thickness_printing_layer}"/>:</td><td>${product.thicknessOfThePrintingLayer}</td></tr>
						</c:if>						
					
                      	<c:if test="${!empty product.interfaceConnection}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.interface_connection}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.interfaceConnection}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>					
					
                      	<c:if test="${!empty product.typesOfFiles}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.file_types}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.typesOfFiles}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>						
					
                       <c:if test="${!empty product.rip}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_3d_printer.software}"/>:</td>
   								<td>
   									<c:forEach var="tp" items="${product.rip}" varStatus="status">  
	    								${tp}<c:if test="${ ! status.last}" >, </c:if>  
									</c:forEach>
   								</td>
                       		</tr>
						</c:if>					
					
                      	<c:if test="${product.maximumWeightOfThePrintedModel > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_3d_printer.maximum_mass_model_printed}"/>:</td><td>${product.maximumWeightOfThePrintedModel}</td></tr>
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