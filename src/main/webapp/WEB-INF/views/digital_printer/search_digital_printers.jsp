<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

    <link rel="stylesheet" href="/css/user/search_digital_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/digital_printer.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user/search.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p><custom:getDescriptionByLocale description="${d_search.filter_items}"/></p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					<custom:getDescriptionByLocale description="${d_search.apply}"/>
				</a>
				<a class="reset" href="<c:url value='/digital_printers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/digital_printers/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
		
		<jsp:include page="../search/price.jsp" />
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.printer_type}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="typePrinter" properties="${digital_printer.type_printer}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="previouslyUsed" properties="${digital_printer.previously_used}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.device}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="device" properties="${digital_printer.device}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.print_type}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="typeOfPrinting" properties="${digital_printer.type_of_printing}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.printing_technology}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="printTechnology" properties="${digital_printer.print_technology}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.accommodation}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="accommodation" properties="${digital_printer.accommodation}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.application_area}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="applicationArea" properties="${digital_printer.application_area}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.number_pages_per_month}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="numberOfPagesPerMonth0" class="amount-numberOfPagesPerMonth0" value="${search.numberOfPagesPerMonth0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="numberOfPagesPerMonth1" class="amount-numberOfPagesPerMonth1" value="${search.numberOfPagesPerMonth1}" />
				</div>
				<div class="slider-range-numberOfPagesPerMonth"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.maximum_format}"/></p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.maximum_format}" path="maximumFormat" element="li" />
			</ul>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.print_specifications}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.automatic_2_sided_printing}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="automaticTwoSidedPrinting" properties="${digital_printer.yn}"/>
					</ul>
				</div>
		
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.warm_up_time}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="warmUpTime0" class="amount-warmUpTime0" value="${search.warmUpTime0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.s}"/>&nbsp;-&nbsp;</p>
							<form:input path="warmUpTime1" class="amount-warmUpTime1" value="${search.warmUpTime1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.s}"/></p>
						</div>
						<div class="slider-range-warmUpTime"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.print_speed_b_w_printing}"/>, <custom:getDescriptionByLocale description="${d_search.page_min}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="speedPrintBW0" class="amount-speedPrintBW0" value="${search.speedPrintBW0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="speedPrintBW1" class="amount-speedPrintBW1" value="${search.speedPrintBW1}" />
						</div>
						<div class="slider-range-speedPrintBW"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.print_speed_color_printing}"/>, <custom:getDescriptionByLocale description="${d_search.page_min}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="speedPrintColor0" class="amount-speedPrintColor0" value="${search.speedPrintColor0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="speedPrintColor1" class="amount-speedPrintColor1" value="${search.speedPrintColor1}" />
						</div>
						<div class="slider-range-speedPrintColor"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.copy_speed_b_w_printing}"/>, <custom:getDescriptionByLocale description="${d_search.page_min}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="speedCopyBW0" class="amount-speedCopyBW0" value="${search.speedCopyBW0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="speedCopyBW1" class="amount-speedCopyBW1" value="${search.speedCopyBW1}" />
						</div>
						<div class="slider-range-speedCopyBW"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.copy_speed_color_printing}"/>, <custom:getDescriptionByLocale description="${d_search.page_min}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="speedCopyColor0" class="amount-speedCopyColor0" value="${search.speedCopyColor0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="speedCopyColor1" class="amount-speedCopyColor1" value="${search.speedCopyColor1}" />
						</div>
						<div class="slider-range-speedCopyColor"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.time_first_fingerprint_output}"/> color</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="firstPrintColor0" class="amount-firstPrintColor0" value="${search.firstPrintColor0}" />
							<p>&nbsp;с&nbsp;-&nbsp;</p>
							<form:input path="firstPrintColor1" class="amount-firstPrintColor1" value="${search.firstPrintColor1}" />
							<p>&nbsp;с</p>
						</div>
						<div class="slider-range-firstPrintColor"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.time_first_fingerprint_output}"/> BW</p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="firstPrintBW0" class="amount-firstPrintBW0" value="${search.firstPrintBW0}" />
							<p>&nbsp;с&nbsp;-&nbsp;</p>
							<form:input path="firstPrintBW1" class="amount-firstPrintBW1" value="${search.firstPrintBW1}" />
							<p>&nbsp;с</p>
						</div>
						<div class="slider-range-firstPrintBW"></div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.characteristics_scanner}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.scanner_type}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="scannerType" properties="${digital_printer.scanner_type}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.maximum_original_size}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${digital_printer.maximum_format}" path="theMaximumSizeOfTheOriginal" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.scanner_resolution}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${digital_printer.scanner_resolution}" path="scannerResolution" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.scanning_speed_color}"/>, <custom:getDescriptionByLocale description="${d_search.images_min}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="scanSpeedColor0" class="amount-scanSpeedColor0" value="${search.scanSpeedColor0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="scanSpeedColor1" class="amount-scanSpeedColor1" value="${search.scanSpeedColor1}" />
						</div>
						<div class="slider-range-scanSpeedColor"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.scanning_speed_b_w}"/>, <custom:getDescriptionByLocale description="${d_search.images_min}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="scanSpeedBW0" class="amount-scanSpeedBW0" value="${search.scanSpeedBW0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="scanSpeedBW1" class="amount-scanSpeedBW1" value="${search.scanSpeedBW1}" />
						</div>
						<div class="slider-range-scanSpeedBW"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.sending_images_e_mail}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="sendingImagesByEmail" properties="${digital_printer.yn}"/>
					</ul>
				</div>
			</div>
		</div>


		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.characteristics_copier}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.maximum_resolution_copier_b_w}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${digital_printer.maximum_resolution_copier_bw}" path="maximumResolutionCopierBW" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.time_first_copy}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="firstCopyOutTime0" class="amount-firstCopyOutTime0" value="${search.firstCopyOutTime0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.s}"/>&nbsp;-&nbsp;</p>
							<form:input path="firstCopyOutTime1" class="amount-firstCopyOutTime1" value="${search.firstCopyOutTime1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.s}"/></p>
						</div>
						<div class="slider-range-firstCopyOutTime"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.zoom_in}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="zooming0" class="amount-zooming0" value="${search.zooming0}" />
							<p>&nbsp;%&nbsp;-&nbsp;</p>
							<form:input path="zooming1" class="amount-zooming1" value="${search.zooming1}" />
							<p>&nbsp;%</p>
						</div>
						<div class="slider-range-zooming"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.zoom_step}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="stepZoom0" class="amount-stepZoom0" value="${search.stepZoom0}" />
							<p>&nbsp;%&nbsp;-&nbsp;</p>
							<form:input path="stepZoom1" class="amount-stepZoom1" value="${search.stepZoom1}" />
							<p>&nbsp;%</p>
						</div>
						<div class="slider-range-stepZoom"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.maximum_number_copies_per_cycle}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="theMaximumNumberOfCopiesPerCycle0" class="amount-theMaximumNumberOfCopiesPerCycle0" value="${search.theMaximumNumberOfCopiesPerCycle0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="theMaximumNumberOfCopiesPerCycle1" class="amount-theMaximumNumberOfCopiesPerCycle1" value="${search.theMaximumNumberOfCopiesPerCycle1}" />
						</div>
						<div class="slider-range-theMaximumNumberOfCopiesPerCycle"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.submission_material}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.paper_feed_standard}"/>, <custom:getDescriptionByLocale description="${d_search.sheets}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="paperFeedStandart0" class="amount-paperFeedStandart0" value="${search.paperFeedStandart0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="paperFeedStandart1" class="amount-paperFeedStandart1" value="${search.paperFeedStandart1}" />
						</div>
						<div class="slider-range-paperFeedStandart"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.paper_feed_maximum}"/>, <custom:getDescriptionByLocale description="${d_search.sheets}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="paperFeedMax0" class="amount-paperFeedMax0" value="${search.paperFeedMax0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="paperFeedMax1" class="amount-paperFeedMax1" value="${search.paperFeedMax1}" />
						</div>
						<div class="slider-range-paperFeedMax"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.paper_output_standard}"/>, <custom:getDescriptionByLocale description="${d_search.sheets}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="paperOutputStandart0" class="amount-paperOutputStandart0" value="${search.paperOutputStandart0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="paperOutputStandart1" class="amount-paperOutputStandart1" value="${search.paperOutputStandart1}" />
						</div>
						<div class="slider-range-paperOutputStandart"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.paper_output_maximum}"/>, <custom:getDescriptionByLocale description="${d_search.sheets}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="paperOutputMax0" class="amount-paperOutputMax0" value="${search.paperOutputMax0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="paperOutputMax1" class="amount-paperOutputMax1" value="${search.paperOutputMax1}" />
						</div>
						<div class="slider-range-paperOutputMax"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.capacity_bypass_tray}"/>, <custom:getDescriptionByLocale description="${d_search.sheets}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="theCapacityOfTheBypassTray0" class="amount-theCapacityOfTheBypassTray0" value="${search.theCapacityOfTheBypassTray0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="theCapacityOfTheBypassTray1" class="amount-theCapacityOfTheBypassTray1" value="${search.theCapacityOfTheBypassTray1}" />
						</div>
						<div class="slider-range-theCapacityOfTheBypassTray"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.electronic_sorting}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="electronicSorting" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.stapler}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="stapler" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.paper_density}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="paperDensity0" class="amount-paperDensity0" value="${search.paperDensity0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.g_m2}"/>&nbsp;-&nbsp;</p>
							<form:input path="paperDensity1" class="amount-paperDensity1" value="${search.paperDensity1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.g_m2}"/></p>
						</div>
						<div class="slider-range-paperDensity"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.consumables}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.resource_developer}"/>, <custom:getDescriptionByLocale description="${d_search.pages}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="resourceDeveloper0" class="amount-resourceDeveloper0" value="${search.resourceDeveloper0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="resourceDeveloper1" class="amount-resourceDeveloper1" value="${search.resourceDeveloper1}" />
						</div>
						<div class="slider-range-resourceDeveloper"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.resource_photoconductor_drum}"/>, <custom:getDescriptionByLocale description="${d_search.pages}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="resourceDrum0" class="amount-resourceDrum0" value="${search.resourceDrum0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="resourceDrum1" class="amount-resourceDrum1" value="${search.resourceDrum1}" />
						</div>
						<div class="slider-range-resourceDrum"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.resource_b_w_cartridge_toner}"/>, <custom:getDescriptionByLocale description="${d_search.pages}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="resourceBWCartridgeToner0" class="amount-resourceBWCartridgeToner0" value="${search.resourceBWCartridgeToner0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="resourceBWCartridgeToner1" class="amount-resourceBWCartridgeToner1" value="${search.resourceBWCartridgeToner1}" />
						</div>
						<div class="slider-range-resourceBWCartridgeToner"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.number_cartridges}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="numberOfCartridges0" class="amount-numberOfCartridges0" value="${search.numberOfCartridges0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.pc}"/>&nbsp;-&nbsp;</p>
							<form:input path="numberOfCartridges1" class="amount-numberOfCartridges1" value="${search.numberOfCartridges1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.pc}"/></p>
						</div>
						<div class="slider-range-numberOfCartridges"></div>
					</div>
				</div>
			</div>
		</div>

		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.printing_on}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="printingOn" properties="${digital_printer.printing_on}"/>
			</ul>
		</div>
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.interfaces}"/></p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${digital_printer.interfaces}" path="interfaces" element="li" />
			</ul>
		</div>

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_d_printer.software}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.os_support}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${digital_printer.os_support}" path="oSSupport" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.direct_printing}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="directPrinting" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.web_interface}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="webInterface" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.post_script_support}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="supportPostScript" properties="${digital_printer.yn}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.support}"/></p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${digital_printer.support}" path="support" element="li" />
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.number_installed_PostScript_fonts}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="theNumberOfInstalledPostScriptFonts0" class="amount-theNumberOfInstalledPostScriptFonts0" value="${search.theNumberOfInstalledPostScriptFonts0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="theNumberOfInstalledPostScriptFonts1" class="amount-theNumberOfInstalledPostScriptFonts1" value="${search.theNumberOfInstalledPostScriptFonts1}" />
						</div>
						<div class="slider-range-theNumberOfInstalledPostScriptFonts"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.number_installed_PCL_fonts}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="theNumberOfInstalledPCLFonts0" class="amount-theNumberOfInstalledPCLFonts0" value="${search.theNumberOfInstalledPCLFonts0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="theNumberOfInstalledPCLFonts1" class="amount-theNumberOfInstalledPCLFonts1" value="${search.theNumberOfInstalledPCLFonts1}" />
						</div>
						<div class="slider-range-theNumberOfInstalledPCLFonts"></div>
					</div>
				</div>
			</div>
		</div>	
		
		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${d_search.general_characteristics}"/></p>
			</div>
			<div class="block_check_boxes">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.memory}"/>, <custom:getDescriptionByLocale description="${d_search.MB}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="memory0" class="amount-memory0" value="${search.memory0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="memory1" class="amount-memory1" value="${search.memory1}" />
						</div>
						<div class="slider-range-memory"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.hard_drive_capacity}"/>, <custom:getDescriptionByLocale description="${d_search.GB}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="hardDriveCapacity0" class="amount-hardDriveCapacity0" value="${search.hardDriveCapacity0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="hardDriveCapacity1" class="amount-hardDriveCapacity1" value="${search.hardDriveCapacity1}" />
						</div>
						<div class="slider-range-hardDriveCapacity"></div>
					</div>
				</div>
		
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.displaying_information}"/></p>
					</div>
					<ul class="check_boxes">
						<custom:searchByLocale nameOfAttribyte="displayInformation" properties="${digital_printer.display_information}"/>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${search_d_printer.diagonal_display}"/>, <custom:getDescriptionByLocale description="${d_search.inch}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="displaySize0" class="amount-displaySize0" value="${search.displaySize0}" />
							<p>&nbsp;-&nbsp;</p>
							<form:input path="displaySize1" class="amount-displaySize1" value="${search.displaySize1}" />
						</div>
						<div class="slider-range-displaySize"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${d_search.averagePowerConsumption}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="averagePowerConsumption0" class="amount-averagePowerConsumption0" value="${search.averagePowerConsumption0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.w}"/> -&nbsp;</p>
							<form:input path="averagePowerConsumption1" class="amount-averagePowerConsumption1" value="${search.averagePowerConsumption1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.w}"/></p>
						</div>
						<div class="slider-range-averagePowerConsumption"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${d_search.maxPowerConsumption}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="maxPowerConsumption0" class="amount-max_power_consumption0" value="${search.maxPowerConsumption0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.w}"/> -&nbsp;</p>
							<form:input path="maxPowerConsumption1" class="amount-max_power_consumption1" value="${search.maxPowerConsumption1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.w}"/></p>
						</div>
						<div class="slider-range-max_power_consumption"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${d_search.weight}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="weight0" class="amount-weight0" value="${search.weight0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.kg}"/> -&nbsp;</p>
							<form:input path="weight1" class="amount-weight1" value="${search.weight1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.kg}"/></p>
						</div>
						<div class="slider-range-weight"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${d_search.width}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="width0" class="amount-width0" value="${search.width0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/> -&nbsp;</p>
							<form:input path="width1" class="amount-width1" value="${search.width1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/></p>
						</div>
						<div class="slider-range-width"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${d_search.height}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="heigth0" class="amount-heigth0" value="${search.heigth0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/> -&nbsp;</p>
							<form:input path="heigth1" class="amount-heigth1" value="${search.heigth1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/></p>
						</div>
						<div class="slider-range-heigth"></div>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p><custom:getDescriptionByLocale description="${d_search.depth}"/></p>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="depth0" class="amount-depth0" value="${search.depth0}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/> -&nbsp;</p>
							<form:input path="depth1" class="amount-depth1" value="${search.depth1}" />
							<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/></p>
						</div>
						<div class="slider-range-depth"></div>
					</div>
				</div>
			</div>
		</div>			

			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				<custom:getDescriptionByLocale description="${d_search.apply}"/>
			</a>
			<a class="reset" href="<c:url value='/digital_printers' />">
				<custom:getDescriptionByLocale description="${d_search.reset}"/>
			</a>
		</form:form>
	</div>