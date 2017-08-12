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
					   
                       <c:if test="${!empty product.typePrinter}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.printer_type}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typePrinter}" properties="${digital_printer.type_printer}"/></td></tr>
					   </c:if>
					   
					   <c:if test="${!empty product.equipmentModel}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.model}"/>:</td><td>${product.equipmentModel}</td></tr>
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
                       
                       <c:if test="${!empty product.typePrinter}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.printer_type}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typePrinter}" properties="${digital_printer.type_printer}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.product_code}"/>:</td><td>${product.partNumber}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.previouslyUsed}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/>:</td>
   								<td><custom:singleProperty productValue="${product.previouslyUsed}" properties="${digital_printer.previously_used}"/></td>
   							</tr>
						</c:if>
						
						<c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.equipment_manufacturer}"/>:</td><td>${product.equipmentManufacturer}</td></tr>
						</c:if>
						
						<c:if test="${!empty product.device}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.device}"/>:</td>
   								<td><custom:singleProperty productValue="${product.device}" properties="${digital_printer.device}"/></td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeOfPrinting}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.print_type}"/>:</td>
   								<td><custom:singleProperty productValue="${product.typeOfPrinting}" properties="${digital_printer.type_of_printing}"/></td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.printTechnology}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.printing_technology}"/>:</td>
   								<td><custom:singleProperty productValue="${product.printTechnology}" properties="${digital_printer.print_technology}"/></td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.accommodation}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.accommodation}"/>:</td>
   								<td><custom:singleProperty productValue="${product.accommodation}" properties="${digital_printer.accommodation}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.applicationArea}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.application_area}"/>:</td>
   								<td><custom:singleProperty productValue="${product.applicationArea}" properties="${digital_printer.application_area}"/></td></tr>
						</c:if>
                       
                       <c:if test="${(product.speedPrintBWA4 != 0) || (product.speedPrintBWA3 != 0) || 
                      					(product.speedPrintBWA2 != 0) || (product.speedPrintBWA1 != 0) ||
                      						(product.speedPrintBWA0 != 0)}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.print_speed_b_w_printing}"/>:</td>
   								<td>
   								
   								<c:if test="${product.speedPrintBWA4 != 0}">
   									A4: ${product.speedPrintBWA4} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedPrintBWA3 != 0}">
   									A3: ${product.speedPrintBWA3} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintBWA2 != 0}">
   									A2: ${product.speedPrintBWA2} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintBWA1 != 0}">
   									A1: ${product.speedPrintBWA1} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintBWA0 != 0}">
   									A0: ${product.speedPrintBWA0} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
								</c:if>
								
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${(product.speedPrintColorA4 != 0) || (product.speedPrintColorA3 != 0) || 
                      					(product.speedPrintColorA2 != 0) || (product.speedPrintColorA1 != 0) ||
                      						(product.speedPrintColorA0 != 0)}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.print_speed_color_printing}"/>:</td>
   								<td>
   								
   								<c:if test="${product.speedPrintColorA4 != 0}">
   									A4: ${product.speedPrintColorA4} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedPrintColorA3 != 0}">
   									A3: ${product.speedPrintColorA3} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintColorA2 != 0}">
   									A2: ${product.speedPrintColorA2} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintColorA1 != 0}">
   									A1: ${product.speedPrintColorA1} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintColorA0 != 0}">
   									A0: ${product.speedPrintColorA0} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
								</c:if>
								
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${(product.speedCopyBWA4 != 0) || (product.speedCopyBWA3 != 0) || 
                      					(product.speedCopyBWA2 != 0) || (product.speedCopyBWA1 != 0) ||
                      						(product.speedCopyBWA0 != 0)}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.copy_speed_b_w_printing}"/>:</td>
   								<td>
   								
   								<c:if test="${product.speedCopyBWA4 != 0}">
   									A4: ${product.speedCopyBWA4} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedCopyBWA3 != 0}">
   									A3: ${product.speedCopyBWA3} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyBWA2 != 0}">
   									A2: ${product.speedCopyBWA2} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyBWA1 != 0}">
   									A1: ${product.speedCopyBWA1} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyBWA0 != 0}">
   									A0: ${product.speedCopyBWA0} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
								</c:if>
								
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${(product.speedCopyColorA4 != 0) || (product.speedCopyColorA3 != 0) || 
                      					(product.speedCopyColorA2 != 0) || (product.speedCopyColorA1 != 0) ||
                      						(product.speedCopyColorA0 != 0)}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.copy_speed_color_printing}"/>:</td>
   								<td>
   								
   								<c:if test="${product.speedCopyColorA4 != 0}">
   									A4: ${product.speedCopyColorA4} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedCopyColorA3 != 0}">
   									A3: ${product.speedCopyColorA3} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyColorA2 != 0}">
   									A2: ${product.speedCopyColorA2} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyColorA1 != 0}">
   									A1: ${product.speedCopyColorA1} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
   									<br/>
								</c:if>
								
								<c:if test="${product.speedCopyColorA0 != 0}">
   									A0: ${product.speedCopyColorA0} <custom:getDescriptionByLocale description="${d_search.page_min}"/> 
								</c:if>
								
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${product.numberOfPagesPerMonth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.number_pages_per_month}"/>:</td><td>${product.numberOfPagesPerMonth}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.maximumFormat}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.maximum_format}"/>:</td><td>${product.maximumFormat}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.automaticTwoSidedPrinting}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.automatic_2_sided_printing}"/>:</td>
   								<td><custom:singleProperty productValue="${product.automaticTwoSidedPrinting}" properties="${digital_printer.yn}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.theMaximumResolutionForColorPrinting && product.theMaximumResolutionForColorPrinting!=''}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.maximum_resolution_for_color_printing}"/>(0000x0000):</td>
   								<td>${product.theMaximumResolutionForColorPrinting}</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.theMaximumResolutionForBWPrinting && product.theMaximumResolutionForBWPrinting!=''}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.maximum_resolution_for_b_w_printing}"/>(0000x0000):</td>
   								<td>${product.theMaximumResolutionForBWPrinting}</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${product.warmUpTime > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.warm_up_time}"/>:</td><td>${product.warmUpTime} <custom:getDescriptionByLocale description="${d_search.s}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.firstPrintColor > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.time_first_fingerprint_output}"/> color:</td><td>${product.firstPrintColor} с</td></tr>
						</c:if>
                       
                       <c:if test="${product.firstPrintBW > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.time_first_fingerprint_output}"/> BW:</td><td>${product.firstPrintBW} с</td></tr>
						</c:if>
						
						<c:if test="${!empty product.scannerType}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.scanner_type}"/>:</td>
   								<td><custom:multipleProperty productValues="${product.scannerType}" properties="${digital_printer.scanner_type}"/></td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.theMaximumSizeOfTheOriginal}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.maximum_original_size}"/>:</td><td>${product.theMaximumSizeOfTheOriginal}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.maximumScanSize}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.maximum_scan_size}"/>:</td><td>${product.maximumScanSize}</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.scannerResolution}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.scanner_resolution}"/>:</td><td>${product.scannerResolution}</td></tr>
						</c:if>
                       
                       <c:if test="${product.scanSpeedColor > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.scanning_speed_color}"/>:</td><td><custom:getDescriptionByLocale description="${search_d_printer.scanning_speed_until}"/> ${product.scanSpeedColor} <custom:getDescriptionByLocale description="${d_search.images_min}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.scanSpeedBW > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.scanning_speed_b_w}"/>:</td><td><custom:getDescriptionByLocale description="${search_d_printer.scanning_speed_until}"/> ${product.scanSpeedBW} <custom:getDescriptionByLocale description="${d_search.images_min}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.sendingImagesByEmail}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.sending_images_e_mail}"/>:</td>
   								<td><custom:singleProperty productValue="${product.sendingImagesByEmail}" properties="${digital_printer.yn}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.maximumResolutionCopierBW}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.maximum_resolution_copier_b_w}"/>:</td><td>${product.maximumResolutionCopierBW}</td></tr>
						</c:if>
                       
                       <c:if test="${product.firstCopyOutTime > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.time_first_copy}"/>:</td><td>${product.firstCopyOutTime} <custom:getDescriptionByLocale description="${d_search.s}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.zooming > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.zoom_in}"/>:</td><td>${product.zooming}%</td></tr>
						</c:if>
                       
                       <c:if test="${product.stepZoom > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.zoom_step}"/>:</td><td>${product.stepZoom}%</td></tr>
						</c:if>
                       
                       <c:if test="${product.theMaximumNumberOfCopiesPerCycle > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.maximum_number_copies_per_cycle}"/>:</td><td>${product.theMaximumNumberOfCopiesPerCycle}</td></tr>
						</c:if>
                       
                       <c:if test="${product.paperFeedStandart > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.paper_feed_standard}"/>:</td><td>${product.paperFeedStandart} <custom:getDescriptionByLocale description="${d_search.sheets}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.paperFeedMax > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.paper_feed_maximum}"/>:</td><td>${product.paperFeedMax} <custom:getDescriptionByLocale description="${d_search.sheets}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.paperOutputStandart > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.paper_output_standard}"/>:</td><td>${product.paperOutputStandart} <custom:getDescriptionByLocale description="${d_search.sheets}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.paperOutputMax > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.paper_output_maximum}"/>:</td><td>${product.paperOutputMax} <custom:getDescriptionByLocale description="${d_search.sheets}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.theCapacityOfTheBypassTray > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.capacity_bypass_tray}"/>:</td><td>${product.theCapacityOfTheBypassTray} <custom:getDescriptionByLocale description="${d_search.sheets}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.electronicSorting}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.electronic_sorting}"/>:</td>
   								<td><custom:singleProperty productValue="${product.electronicSorting}" properties="${digital_printer.yn}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.stapler}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.stapler}"/>:</td>
   								<td><custom:singleProperty productValue="${product.stapler}" properties="${digital_printer.yn}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.paperDensity > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.paper_density}"/>:</td><td>${product.paperDensity} <custom:getDescriptionByLocale description="${d_search.g_m2}"/></td></tr>
						</c:if>
                                            
                       <c:if test="${!empty product.printingOn}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.printing_on}"/>:</td>
   								<td><custom:multipleProperty productValues="${product.printingOn}" properties="${digital_printer.printing_on}"/></td>
   							</tr>
						</c:if>
                       
                       <c:if test="${product.resourceDeveloper > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.resource_developer}"/>:</td><td>${product.resourceDeveloper} <custom:getDescriptionByLocale description="${d_search.pages}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.resourceDrum > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.resource_photoconductor_drum}"/>:</td><td>${product.resourceDrum} <custom:getDescriptionByLocale description="${d_search.pages}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.resourceBWCartridgeToner > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.resource_b_w_cartridge_toner}"/>:</td><td>${product.resourceBWCartridgeToner} <custom:getDescriptionByLocale description="${d_search.pages}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.numberOfCartridges > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.number_cartridges}"/>:</td><td>${product.numberOfCartridges} <custom:getDescriptionByLocale description="${d_search.pc}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.memory > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.memory}"/>:</td><td>${product.memory} <custom:getDescriptionByLocale description="${d_search.MB}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.hardDriveCapacity > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.hard_drive_capacity}"/>:</td><td>${product.hardDriveCapacity} <custom:getDescriptionByLocale description="${d_search.GB}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.interfaces}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.interfaces}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.interfaces}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if> 
                       
						<c:if test="${!empty product.directPrinting}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.direct_printing}"/>:</td>
   								<td><custom:singleProperty productValue="${product.directPrinting}" properties="${digital_printer.yn}"/></td></tr>
						</c:if>

						<c:if test="${!empty product.webInterface}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.web_interface}"/>:</td>
   								<td><custom:singleProperty productValue="${product.webInterface}" properties="${digital_printer.yn}"/></td></tr>
						</c:if>

						<c:if test="${!empty product.supportPostScript}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.post_script_support}"/>:</td>
   								<td><custom:singleProperty productValue="${product.supportPostScript}" properties="${digital_printer.yn}"/></td></tr>
						</c:if>

						<c:if test="${!empty product.support}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.support}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.support}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if> 

						<c:if test="${product.theNumberOfInstalledPostScriptFonts > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.number_installed_PostScript_fonts}"/>:</td><td>${product.theNumberOfInstalledPostScriptFonts}</td></tr>
						</c:if>

						<c:if test="${product.theNumberOfInstalledPCLFonts > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.number_installed_PCL_fonts}"/>:</td><td>${product.theNumberOfInstalledPCLFonts}</td></tr>
						</c:if>

						<c:if test="${!empty product.oSSupport}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.os_support}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.oSSupport}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if> 

						<c:if test="${!empty product.displayInformation}">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_d_printer.displaying_information}"/>:</td>
   								<td><custom:singleProperty productValue="${product.displayInformation}" properties="${digital_printer.display_information}"/></td></tr>
						</c:if>

						<c:if test="${product.displaySize > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_d_printer.diagonal_display}"/>:</td><td>${product.displaySize} <custom:getDescriptionByLocale description="${d_search.inch}"/></td></tr>
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