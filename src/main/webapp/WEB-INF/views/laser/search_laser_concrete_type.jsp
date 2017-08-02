<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

    <link rel="stylesheet" href="/css/user/search_laser.css">
    <link rel="stylesheet" href="/css/search.css">
    
    <script src="<%=request.getContextPath()%>/resources/js/user/laser.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/user/search.js"></script>

	<div id="display_search">
		<i class="opened"></i>
		<p><custom:getDescriptionByLocale description="${d_search.filter_items}"/></p>
	</div>
			<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				<custom:getDescriptionByLocale description="${d_search.apply}"/>
			</a>
				
			<c:if test="${search.typeLaser[0].equals('Газовые лазеры СО2')}">
				<a class="reset" href="<c:url value='/laser/CO2_gas_lasers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('Твердотельные лазеры')}">
				<a class="reset" href="<c:url value='/laser/solid_state_lasers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('Для обработки метала')}">
				<a class="reset" href="<c:url value='/laser/for_the_treatment_of_metal' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('С диодной накачкой')}">
				<a class="reset" href="<c:url value='/laser/diode_pumped' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('Оптоволоконные лазеры')}">
				<a class="reset" href="<c:url value='/laser/fiber_lasers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('Плазменные лазеры')}">
				<a class="reset" href="<c:url value='/laser/plasma_lasers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			
	<div id="search_product">
	<c:url var="product_search" value="/lasers/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
	
		<jsp:include page="../search/price.jsp" />
		
		<div class="search_criteria" style="display: none;">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.type_laser}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="typeLaser" properties="${laser.type_laser}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="previouslyUsed" properties="${laser.previously_used}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.size_working_area}"/></p>
			</div>
			<div class="check_boxes">
				<p style="float: none; margin: 10px auto 0px;"> <custom:getDescriptionByLocale description="${search_laser.size_working_area_x}"/>:</p>
				<div class="text_output">
					<form:input path="sizeWorkAreaX0" class="amount-sizeWorkAreaX0" value="${search.sizeWorkAreaX0}"/>
					<p >&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/> -&nbsp;</p>
					<form:input path="sizeWorkAreaX1" class="amount-sizeWorkAreaX1" value="${search.sizeWorkAreaX1}" />
					<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/></p>
				</div>
					<div class="slider-range-sizeWorkAreaX"></div>

				<p style="float: none; margin: 10px auto 0px;"> <custom:getDescriptionByLocale description="${search_laser.size_working_area_x}"/>:</p>
				<div class="text_output">
					<form:input path="sizeWorkAreaY0" class="amount-sizeWorkAreaY0" value="${search.sizeWorkAreaY0}" />
					<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/> -&nbsp;</p>
					<form:input path="sizeWorkAreaY1" class="amount-sizeWorkAreaY1" value="${search.sizeWorkAreaY1}" />
					<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/></p>
				</div>
					<div class="slider-range-sizeWorkAreaY"></div>

				<p style="float: none; margin: 10px auto 0px;"> <custom:getDescriptionByLocale description="${search_laser.size_working_area_x}"/>:</p>
				<div class="text_output">
					<form:input path="sizeWorkAreaZ0" class="amount-sizeWorkAreaZ0" value="${search.sizeWorkAreaZ0}" />
					<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/> -&nbsp;</p>
					<form:input path="sizeWorkAreaZ1" class="amount-sizeWorkAreaZ1" value="${search.sizeWorkAreaZ1}" />
					<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.mm}"/></p>
				</div>
					<div class="slider-range-sizeWorkAreaZ"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.type_cooling}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="typeOfCooling" properties="${laser.type_of_cooling}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.color_separation}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="colorSeparation" properties="${laser.color_separation}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.type_output_image}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="typeTheDisplayedImage" properties="${laser.type_the_displayed_image}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.maximum_resolution}"/>, DPI</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="maximumResolution0" class="amount-maximumResolution0" value="${search.maximumResolution0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="maximumResolution1" class="amount-maximumResolution1" value="${search.maximumResolution1}" />
				</div>
				<div class="slider-range-maximumResolution"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.laser_power_adjustment}"/>, %</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="firstPartAdjustingTheLaserPower" class="amount-firstPartAdjustingTheLaserPower" value="${search.firstPartAdjustingTheLaserPower}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="secondPartAdjustingTheLaserPower" class="amount-secondPartAdjustingTheLaserPower" value="${search.secondPartAdjustingTheLaserPower}" />
				</div>
				<div class="slider-range-adjustingTheLaserPower"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.laser_power}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="powerOfLaser0" class="amount-powerOfLaser0" value="${search.powerOfLaser0}" />
					<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.w}"/> -&nbsp;</p>
					<form:input path="powerOfLaser1" class="amount-powerOfLaser1" value="${search.powerOfLaser1}" />
					<p>&nbsp;<custom:getDescriptionByLocale description="${d_search.w}"/></p>
				</div>
				<div class="slider-range-powerOfLaser"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.laser_wave_length}"/>, nm</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="laserWavelength0" class="amount-laserWavelength0" value="${search.laserWavelength0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="laserWavelength1" class="amount-laserWavelength1" value="${search.laserWavelength1}" />
				</div>
				<div class="slider-range-laserWavelength"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.laser_pulse}"/>, Hz</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="laserPulse0" class="amount-laserPulse0" value="${search.laserPulse0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="laserPulse1" class="amount-laserPulse1" value="${search.laserPulse1}" />
				</div>
				<div class="slider-range-laserPulse"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.diameter_laser}"/>, <custom:getDescriptionByLocale description="${d_search.mm}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="theDiameterOfTheLaser0" class="amount-theDiameterOfTheLaser0" value="${search.theDiameterOfTheLaser0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="theDiameterOfTheLaser1" class="amount-theDiameterOfTheLaser1" value="${search.theDiameterOfTheLaser1}" />
				</div>
				<div class="slider-range-theDiameterOfTheLaser"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.engraving_depth}"/>, <custom:getDescriptionByLocale description="${d_search.mm}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="engravingDepth0" class="amount-engravingDepth0" value="${search.engravingDepth0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="engravingDepth1" class="amount-engravingDepth1" value="${search.engravingDepth1}" />
				</div>
				<div class="slider-range-engravingDepth"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.laser_resource}"/>, <custom:getDescriptionByLocale description="${d_search.hours}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="laserSource0" class="amount-laserSource0" value="${search.laserSource0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="laserSource1" class="amount-laserSource1" value="${search.laserSource1}" />
				</div>
				<div class="slider-range-laserSource"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.special_purpose}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="specialPurpose" properties="${laser.special_purpose}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.type_engine}"/></p>
			</div>
			<ul class="check_boxes">
				<custom:searchByLocale nameOfAttribyte="typeEngine" properties="${laser.type_engine}"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.mechanical_resolution}"/>, <custom:getDescriptionByLocale description="${d_search.mm_step}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="mechanicalResolution0" class="amount-mechanicalResolution0" value="${search.mechanicalResolution0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="mechanicalResolution1" class="amount-mechanicalResolution1" value="${search.mechanicalResolution1}" />
				</div>
				<div class="slider-range-mechanicalResolution"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.software_permission}"/>, <custom:getDescriptionByLocale description="${d_search.mm_step}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="softwareResolution0" class="amount-softwareResolution0" value="${search.softwareResolution0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="softwareResolution1" class="amount-softwareResolution1" value="${search.softwareResolution1}" />
				</div>
				<div class="slider-range-softwareResolution"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.minimum_thickness_cut}"/>, <custom:getDescriptionByLocale description="${d_search.mkm}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="minimumThicknessOfCut0" class="amount-minimumThicknessOfCut0" value="${search.minimumThicknessOfCut0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="minimumThicknessOfCut1" class="amount-minimumThicknessOfCut1" value="${search.minimumThicknessOfCut1}" />
				</div>
				<div class="slider-range-minimumThicknessOfCut"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.engraving_speed}"/>, <custom:getDescriptionByLocale description="${d_search.mm_min}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="engravingSpeed0" class="amount-engravingSpeed0" value="${search.engravingSpeed0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="engravingSpeed1" class="amount-engravingSpeed1" value="${search.engravingSpeed1}" />
				</div>
				<div class="slider-range-engravingSpeed"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.cutting_speed}"/>, <custom:getDescriptionByLocale description="${d_search.mm_min}"/></p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="cuttingSpeed0" class="amount-cuttingSpeed0" value="${search.cuttingSpeed0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="cuttingSpeed1" class="amount-cuttingSpeed1" value="${search.cuttingSpeed1}" />
				</div>
				<div class="slider-range-cuttingSpeed"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.interface_connection}"/></p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.connection_interface}" path="connectionInterface" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.file_types}"/></p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.file_types}" path="fileTypes" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.software}"/></p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.software}" path="software" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${search_laser.equipment_manufacturer}"/></p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.equipment_manufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>
		
		<jsp:include page="../search/general_characteristics.jsp" />
		
			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				<custom:getDescriptionByLocale description="${d_search.apply}"/>
			</a>
				
			<c:if test="${search.typeLaser[0].equals('Газовые лазеры СО2')}">
				<a class="reset" href="<c:url value='/laser/CO2_gas_lasers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('Твердотельные лазеры')}">
				<a class="reset" href="<c:url value='/laser/solid_state_lasers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('Для обработки метала')}">
				<a class="reset" href="<c:url value='/laser/for_the_treatment_of_metal' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('С диодной накачкой')}">
				<a class="reset" href="<c:url value='/laser/diode_pumped' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('Оптоволоконные лазеры')}">
				<a class="reset" href="<c:url value='/laser/fiber_lasers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			<c:if test="${search.typeLaser[0].equals('Плазменные лазеры')}">
				<a class="reset" href="<c:url value='/laser/plasma_lasers' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
			</c:if>
			
		</form:form>
	</div>