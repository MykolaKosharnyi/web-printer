<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_laser.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/laser.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user/search.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					ПРИМЕНИТЬ
				</a>
				<a class="reset" href="<c:url value='/lasers' />">
					СБРОСИТЬ
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/lasers/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
	
		<jsp:include page="../search/price.jsp" />
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип лазерa</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.type_laser}" path="typeLaser" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Б/У оборудование</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.previously_used}" path="previouslyUsed" element="li" />
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
				<p>Тип охлаждения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.type_of_cooling}" path="typeOfCooling" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Цветоделение</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.color_separation}" path="colorSeparation" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип выводимого изображения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.type_the_displayed_image}" path="typeTheDisplayedImage" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальное разрешение, DPI</p>
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
				<p>Регулировка мощности лазера, %</p>
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
				<p>Мощность лазера</p>
			</div>
			<div class="check_boxes">
				<div class="text_output">
					<form:input path="powerOfLaser0" class="amount-powerOfLaser0" value="${search.powerOfLaser0}" />
					<p>&nbsp;Вт -&nbsp;</p>
					<form:input path="powerOfLaser1" class="amount-powerOfLaser1" value="${search.powerOfLaser1}" />
					<p>&nbsp;Вт</p>
				</div>
				<div class="slider-range-powerOfLaser"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Длинна волны лазера, nm</p>
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
				<p>Импульс лазера, Hz</p>
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
				<p>Диаметр лазера, мм</p>
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
				<p>Глубина гравировки, мм</p>
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
				<p>Ресурс лазера, часов</p>
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
				<p>Целевое назначение</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.special_purpose}" path="specialPurpose" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип двигателей</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.type_engine}" path="typeEngine" element="li" />
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
				<p>Минимальная толщина реза, мкм</p>
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
				<p>Скорость гравировки, мм/мин</p>
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
				<p>Скорость резки, мм/мин</p>
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
				<p>Интерфейс подключения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.connection_interface}" path="connectionInterface" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Типы файлов</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.file_types}" path="fileTypes" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Програмное обеспечение</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.software}" path="software" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${laser.equipment_manufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>
		
		<jsp:include page="../search/general_characteristics.jsp" />
		
			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">ПРИМЕНИТЬ</a>
			<a class="reset" href="<c:url value='/lasers' />">СБРОСИТЬ</a>
		</form:form>
	</div>
