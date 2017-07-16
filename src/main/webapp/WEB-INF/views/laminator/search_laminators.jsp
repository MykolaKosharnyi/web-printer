<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>.
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

    <link rel="stylesheet" href="/css/user/search_laminator.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/laminator.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user/search.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p><custom:getDescriptionByLocale description="${d_search.filter_items}"/></p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					<custom:getDescriptionByLocale description="${d_search.apply}"/>
				</a>
				<a class="reset" href="<c:url value='/laminators' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/laminators/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
	
		<jsp:include page="../search/price.jsp" />
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип ламинатора</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laminator.type_product}" path="typeProduct" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина ламинирования</p>
			</div>
			<div class="check_boxes">
				<div id="tabs">
					<ul>
						<li>миллиметр</li>
						<li>дюйм</li>
						<!--<li>формат</li>-->
					</ul>
					<div>
						<div>
							<form:checkboxes items="${laminator.laminating_width}" path="laminatingWidth" element="li" />
						</div>
					    <div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="305" id="weightPrintMM_12"></input>
								<label for="weightPrintMM_12">12"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="457" id="weightPrintMM_18"></input>
								<label for="weightPrintMM_18">18"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="610" id="weightPrintMM_24"></input>
								<label for="weightPrintMM_24">24"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="914" id="weightPrintMM_36"></input>
								<label for="weightPrintMM_36">36"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="1070" id="weightPrintMM_42"></input>
								<label for="weightPrintMM_42">42"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="1524" id="weightPrintMM_60"></input>
								<label for="weightPrintMM_60">60"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="1550" id="weightPrintMM_61"></input>
								<label for="weightPrintMM_61">61"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="1600" id="weightPrintMM_63"></input>
								<label for="weightPrintMM_63">63"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="1800" id="weightPrintMM_71"></input>
								<label for="weightPrintMM_71">71"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="2500" id="weightPrintMM_98"></input>
								<label for="weightPrintMM_98">98"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="2540" id="weightPrintMM_100"></input>
								<label for="weightPrintMM_100">100"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="2600" id="weightPrintMM_102"></input>
								<label for="weightPrintMM_102">102"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="3200" id="weightPrintMM_126"></input>
								<label for="weightPrintMM_126">126"</label>
							</div>
							<div class="weightPrint_inch">
								<input type="checkbox" name="laminatingWidth" value="3300" id="weightPrintMM_130"></input>
								<label for="weightPrintMM_130">130"</label>
							</div>
						</div>
						<!--<div>
							<li><input type="checkbox" name="weightPrintMM">A0</input></li>
							<li><input type="checkbox" name="weightPrintMM">A1</input></li>
							<li><input type="checkbox" name="weightPrintMM">A2</input></li>
							<li><input type="checkbox" name="weightPrintMM">A3</input></li>
							<li><input type="checkbox" name="weightPrintMM">A3+</input></li>
							<li><input type="checkbox" name="weightPrintMM">B0</input></li>
							<li><input type="checkbox" name="weightPrintMM">B1</input></li>
						</div> 
						  -->
					</div>
				</div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Б/У оборудование</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laminator.previously_used}" path="previouslyUsed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Подача</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laminator.innings}" path="innings" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Количество валов</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="numberOfShafts0" class="amount-numberOfShafts0" value="${search.numberOfShafts0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="numberOfShafts1" class="amount-numberOfShafts1" value="${search.numberOfShafts1}" />
				</div>
					<div class="slider-range-numberOfShafts"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Диаметр вала, мм</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="shaftDiameter0" class="amount-shaftDiameter0" value="${search.shaftDiameter0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="shaftDiameter1" class="amount-shaftDiameter1" value="${search.shaftDiameter1}" />
				</div>
				<div class="slider-range-shaftDiameter"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Толщина пленки, мкм</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="filmThickness0" class="amount-filmThickness0" value="${search.filmThickness0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="filmThickness1" class="amount-filmThickness1" value="${search.filmThickness1}" />
				</div>
				<div class="slider-range-filmThickness"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Время разогрева, мин</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="warmUpTime0" class="amount-warmUpTime0" value="${search.warmUpTime0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="warmUpTime1" class="amount-warmUpTime1" value="${search.warmUpTime1}" />
				</div>
				<div class="slider-range-warmUpTime"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Температура ламинации, С</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="laminationTemperature0" class="amount-laminationTemperature0" value="${search.laminationTemperature0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="laminationTemperature1" class="amount-laminationTemperature1" value="${search.laminationTemperature1}" />
				</div>
					<div class="slider-range-laminationTemperature"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость ламинирования, мм/с</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="laminatingSpeed0" class="amount-laminatingSpeed0" value="${search.laminatingSpeed0}" />
					<p>&nbsp;-&nbsp;</p>
					<form:input path="laminatingSpeed1" class="amount-laminatingSpeed1" value="${search.laminatingSpeed1}" />
				</div>
					<div class="slider-range-laminatingSpeed"></div>
			</div>
		</div>		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laminator.equipment_manufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>
		
		<jsp:include page="../search/general_characteristics.jsp" />

			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				<custom:getDescriptionByLocale description="${d_search.apply}"/>
			</a>
			<a class="reset" href="<c:url value='/laminators' />">
				<custom:getDescriptionByLocale description="${d_search.reset}"/>
			</a>
		</form:form>
	</div>
