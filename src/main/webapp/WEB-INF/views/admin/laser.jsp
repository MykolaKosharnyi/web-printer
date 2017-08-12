<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<%@page session="true"%>
<!DOCTYPE>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_printer.js"></script>
	
	<c:if test="${empty product.id}">
		<title>
			<spring:message text="Добавление нового лазера" />
		</title>
	</c:if>
	<c:if test="${!empty product.id}">
		<title>
			<spring:message text="Изменение" />
		</title>
	</c:if>
</head>
<body>
	
	<div id="product">
	
		<c:if test="${empty product.id}">
			<label id="head_of_page"><spring:message text="Добавление нового лазера" /></label>
			<c:url var="addAction" value="/admin/${type}/add" ></c:url>
		</c:if>
			
		<c:if test="${!empty product.id}">
			<label id="head_of_page"><spring:message text="Изменение: ${product.name}" /></label>
				
			<c:if test="${!empty product.partNumber}">	
				<div>
					<div style="font-weight:bold; float: left; padding-right: 15px;">Код товара: </div>${product.partNumber}
				</div>
			</c:if>
				
			<jsp:include page="product/last_changing.jsp" />
			<c:url var="addAction" value="/admin/${type}/update" ></c:url>
		</c:if>
		
		<jsp:include page="product/pictures.jsp" />

	<form:form method="POST" commandName="product" action="${addAction}">
		<div class="save_button_keeper">	
			<c:if test="${empty product.id}">
				<c:url value="/admin/${type}/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/${type}/save_update" var="saveUpdate" />
				<input id="submit" type="submit" formaction="${saveUpdate}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="изменить" style="background:blue; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<jsp:include page="product/hidden_characteristic.jsp" />
			</c:if>
		</div>
			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Название лазера</p>
						<form:errors path="name" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="name"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Название товара(ENGLISH)</p>
						<form:errors path="engNameProduct" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="engNameProduct"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Код товара</p>
						<form:errors path="partNumber" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="partNumber" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цена</p>
						<form:errors path="prise" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<p>$</p><form:input path="prise" class="amount-prise" value="${product.prise}"/>
						</div>
							<div class="slider-range-prise"></div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип лазера</p>
						<form:errors path="typeLaser" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="typeLaser" productValue="${product.typeLaser}" properties="${laser.type_laser}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Модель</p>
						<form:errors path="equipmentModel" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="equipmentModel" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Состояние оборудования</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="previouslyUsed" productValue="${product.previouslyUsed}" properties="${laser.previously_used}"/>
					</ul>
				</div>
				
				<!-- import actions -->
				<jsp:include page="product/actions.jsp" />
				
				<!-- import time shares action -->
				<jsp:include page="product/time_shares.jsp" />
				
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер рабочей области</p>
						<form:errors path="sizeWorkAreaX" cssClass="error"></form:errors>
						<form:errors path="sizeWorkAreaY" cssClass="error"></form:errors>
						<form:errors path="sizeWorkAreaZ" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<p>По оси Х:</p>
							<form:input path="sizeWorkAreaX" class="amount-speed-print-d"/>
							<p>&nbsp;мм</p>
							<form:errors path="sizeWorkAreaX" cssClass="error"></form:errors>
						</div>
						<div class="text_output">
							<p>По оси Y:</p>
							<form:input path="sizeWorkAreaY" class="amount-speed-print-d"/>
							<p>&nbsp;мм</p>
							<form:errors path="sizeWorkAreaY" cssClass="error"></form:errors>
						</div>
						<div class="text_output">
							<p>По оси Z:</p>
							<form:input path="sizeWorkAreaZ" class="amount-speed-print-d"/>
							<p>&nbsp;мм</p>
							<form:errors path="sizeWorkAreaZ" cssClass="error"></form:errors>
						</div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Мощность лазера, Вт</p>
						<form:errors path="powerOfLaser" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
							<form:input path="powerOfLaser" class="amount-powerOfLaser"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип охлаждения</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="typeOfCooling" productValue="${product.typeOfCooling}" properties="${laser.type_of_cooling}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Количество головок, шт</p>
						<form:errors path="numberOfHeads" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="numberOfHeads" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость позиционирования, м/мин</p>
						<form:errors path="positioningSpeed" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="positioningSpeed" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цветоделение</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="colorSeparation" productValue="${product.colorSeparation}" properties="${laser.color_separation}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип выводимого изображения</p>
					</div>
					<ul class="check_boxes">
						<custom:check nameOfAttribyte="feed" productValues="${product.typeTheDisplayedImage}" properties="${laser.type_the_displayed_image}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Минимальный размер символа</p>
						<form:errors path="firstPartTheMinimumCharacterSize" cssClass="error"></form:errors>
						<form:errors path="secondPartTheMinimumCharacterSize" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="firstPartTheMinimumCharacterSize" />
							<form:errors path="firstPartTheMinimumCharacterSize" cssClass="error"></form:errors>	 
				    		<p>&nbsp;X&nbsp;</p><form:input style="width: 33px;" path="secondPartTheMinimumCharacterSize" />
				    		<form:errors path="secondPartTheMinimumCharacterSize" cssClass="error"></form:errors>
				    		<p>&nbsp; мм</p>
						</div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальное разрешение, DPI</p>
						<form:errors path="maximumResolution" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="maximumResolution"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Предельная точность позиционирования, мм</p>
						<form:errors path="maximumPositioningAccuracy" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="maximumPositioningAccuracy"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Регулировка мощности лазера</p>
						<form:errors path="firstPartAdjustingTheLaserPower" cssClass="error"></form:errors>
						<form:errors path="secondPartAdjustingTheLaserPower" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="firstPartAdjustingTheLaserPower" />
							<form:errors path="firstPartAdjustingTheLaserPower" cssClass="error"></form:errors>	 
				    		<p>&nbsp;-&nbsp;</p><form:input style="width: 33px;" path="secondPartAdjustingTheLaserPower" />
				    		<form:errors path="secondPartAdjustingTheLaserPower" cssClass="error"></form:errors>
				    		<p>&nbsp;%</p>
						</div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Длинна волны лазера, nm</p>
						<form:errors path="laserWavelength" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="laserWavelength"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Диаметр лазера, мм</p>
						<form:errors path="theDiameterOfTheLaser" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="theDiameterOfTheLaser"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Целевое назначение (для выбора с уже заданных)</p>
					</div>
					<ul class="check_boxes">
						<custom:check nameOfAttribyte="specialPurpose" productValues="${product.specialPurpose}" properties="${laser.special_purpose}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Целевое назначение (присущи только этому лазеру)</p>
						<form:errors path="specialPurpose1" cssClass="error"></form:errors>	 
						<form:errors path="specialPurpose2" cssClass="error"></form:errors>	 
						<form:errors path="specialPurpose3" cssClass="error"></form:errors>	 
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="specialPurpose1" />
							<form:errors path="specialPurpose1" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<form:input path="specialPurpose2" />
							<form:errors path="specialPurpose2" cssClass="error"></form:errors>	 
						</div>
						<div class="text_output">
							<form:input path="specialPurpose3" />
							<form:errors path="specialPurpose3" cssClass="error"></form:errors>	 
						</div>
					</div>
				</div>
			</div>

			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Импульс лазера, Hz</p>
						<form:errors path="laserPulse0" cssClass="error"></form:errors>
						<form:errors path="laserPulse1" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="laserPulse0" />
							<form:errors path="laserPulse0" cssClass="error"></form:errors>	 
				    		<p>&nbsp;-&nbsp;</p><form:input style="width: 33px;" path="laserPulse1" />
				    		<form:errors path="laserPulse1" cssClass="error"></form:errors>
						</div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Глубина гравировки, мм</p>
						<form:errors path="engravingDepth" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="engravingDepth"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ресурс лазера, часов</p>
						<form:errors path="laserSource" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="laserSource"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип двигателей</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="typeEngine" productValue="${product.typeEngine}" properties="${laser.type_engine}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Механическое разрешение, мм/шаг</p>
						<form:errors path="mechanicalResolution" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
							<form:input path="mechanicalResolution" class="amount-mechanicalResolution"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Программное разрешение, мм/шаг</p>
						<form:errors path="softwareResolution" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="softwareResolution" class="amount-softwareResolution"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Минимальная толщина реза, мм</p>
						<form:errors path="minimumThicknessOfCut" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="minimumThicknessOfCut" class="amount-minimumThicknessOfCut"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость гравировки, мм/мин</p>
						<form:errors path="engravingSpeed" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="engravingSpeed" class="amount-engravingSpeed"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость резки, мм/мин</p>
						<form:errors path="cuttingSpeed" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="cuttingSpeed" class="amount-cuttingSpeed"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${laser.connection_interface}" path="connectionInterface" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Типы файлов</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${laser.file_types}" path="fileTypes" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Програмное обеспечение</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${laser.software}" path="software" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${laser.equipment_manufacturer}" path="equipmentManufacturer" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Средняя потребляемая мощность, Вт</p>
						<form:errors path="averagePowerConsumption" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="averagePowerConsumption"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная потребляемая мощность</p>
						<form:errors path="maxPowerConsumption" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="maxPowerConsumption" class="amount-max_power_consumption" value="${product.maxPowerConsumption}"/>
							<p>&nbsp;Вт</p>
						</div>
						<div class="slider-range-max_power_consumption"></div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вес</p>
						<form:errors path="weight" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="weight" class="amount-weight" value="${product.weight}"/>
							<p>&nbsp;кг</p>
						</div>
						<div class="slider-range-weight"></div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина</p>
						<form:errors path="width" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="width" class="amount-width" value="${product.width}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-width"></div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Глубина</p>
						<form:errors path="depth" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="depth" class="amount-depth" value="${product.depth}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-depth"></div>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Высота</p>
						<form:errors path="heigth" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<div class="text_output">
							<form:input path="heigth" class="amount-heigth" value="${product.heigth}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-heigth"></div>
					</div>
				</div>
				
				<!-- import delivery and insurance option -->
				<jsp:include page="product/delivery_and_insurance.jsp" />
				
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Гарантия, месяцев</p>
						<form:errors path="guarantee" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="guarantee" />
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Наличие (информация для пользователя)</p>
					</div>
					<div class="check_boxes">
						<custom:radio nameOfAttribyte="availability" productValue="${product.availability}" properties="${laser.availability}"/>
						<div class="text_output">
							<form:input path="availabilitySpecialCase"/>
						</div>
					</div>
				</div>
				
				<!-- import option characteristic -->
				<jsp:include page="product/characteristic_option.jsp" />
			</div>

			<jsp:include page="product/textarea_descriptions.jsp" />
		
			<c:if test="${empty product.id}">
				<input id="submit" type="submit" value="загрузить" style="background:green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<input id="submit" type="submit" value="изменить" style="background:blue; color: azure;"/>
			</c:if>

		</form:form>
	</div>
	
	<jsp:include page="product/js_code.jsp" />
	
</body>
</html>