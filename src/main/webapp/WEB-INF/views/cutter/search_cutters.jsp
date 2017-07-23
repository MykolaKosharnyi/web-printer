<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

    <link rel="stylesheet" href="/css/user/search_cutter.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/cutter.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user/search.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p><custom:getDescriptionByLocale description="${d_search.filter_items}"/></p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					<custom:getDescriptionByLocale description="${d_search.apply}"/>
				</a>
				<a class="reset" href="<c:url value='/cutters' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/cutters/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
	
		<jsp:include page="../search/price.jsp" />

		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип гравера/фрезера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.type_cutter}" path="typeCutter" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/></p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.previously_used}" path="previouslyUsed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Размер рабочей области</p>
			</div>
			<div class="check_boxes">
				<p style="float: none; margin: 10px auto 0px;"> По оси Х:</p>
				<div class="text_output">
					<form:input path="sizeWorkAreaX0" class="amount-sizeWorkAreaX0" value="${search.sizeWorkAreaX0}"/>
					<p >&nbsp;мм -&nbsp;</p>
					<form:input path="sizeWorkAreaX1" class="amount-sizeWorkAreaX1" value="${search.sizeWorkAreaX1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizeWorkAreaX"></div>

				<p style="float: none; margin: 10px auto 0px;"> По оси Y:</p>
				<div class="text_output">
					<form:input path="sizeWorkAreaY0" class="amount-sizeWorkAreaY0" value="${search.sizeWorkAreaY0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizeWorkAreaY1" class="amount-sizeWorkAreaY1" value="${search.sizeWorkAreaY1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizeWorkAreaY"></div>

				<p style="float: none; margin: 10px auto 0px;"> По оси Z:</p>
				<div class="text_output">
					<form:input path="sizeWorkAreaZ0" class="amount-sizeWorkAreaZ0" value="${search.sizeWorkAreaZ0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="sizeWorkAreaZ1" class="amount-sizeWorkAreaZ1" value="${search.sizeWorkAreaZ1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-sizeWorkAreaZ"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип двигателей</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.type_engine}" path="typeEngine" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип гравировки</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.engraving_style}" path="engravingStyle" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип охлаждения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.type_of_cooling}" path="typeOfCooling" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Механическое разрешение, мкм/шаг</p>
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
				<p>Программное разрешение, мкм/шаг</p>
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
				<p>Частота вращения шпинделя, об/мин</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="frequencySpindle0" class="amount-frequencySpindle0" value="${search.frequencySpindle0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="frequencySpindle1" class="amount-frequencySpindle1" value="${search.frequencySpindle1}" />
				</div>
					<div class="slider-range-frequencySpindle"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость обработки(XY), мм/с</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="processingSpeedXY0" class="amount-processingSpeedXY0" value="${search.processingSpeedXY0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="processingSpeedXY1" class="amount-processingSpeedXY1" value="${search.processingSpeedXY1}" />
				</div>
					<div class="slider-range-processingSpeedXY"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость обработки(Z), мм/с</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="processingSpeedZ0" class="amount-processingSpeedZ0" value="${search.processingSpeedZ0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="processingSpeedZ1" class="amount-processingSpeedZ1" value="${search.processingSpeedZ1}" />
				</div>
					<div class="slider-range-processingSpeedZ"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Крепление инструмента</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.mounting_tool}" path="mountingTool" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Интерфейс подключения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.connection_interface}" path="connectionInterface" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Програмное обеспечение</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.software}" path="software" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${cutter.equipment_manufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>
		
		<jsp:include page="../search/general_characteristics.jsp" />
		
			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				<custom:getDescriptionByLocale description="${d_search.apply}"/>
			</a>
			<a class="reset" href="<c:url value='/cutters' />">
				<custom:getDescriptionByLocale description="${d_search.reset}"/>
			</a>
		</form:form>
	</div>
