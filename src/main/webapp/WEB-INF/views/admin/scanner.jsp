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

<c:if test="${empty product.id}">
	<title>
		<spring:message text="Добавление нового сканера" />
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
			<label id="head_of_page"><spring:message text="Добавление нового сканера" /></label>
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
				<c:url value="/admin/scanner/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/scanner/save_update" var="saveUpdate" />
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
						<p>Название сканера</p>
						<form:errors path="name" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="name"/>
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
					<ul class="check_boxes">
						<div class="text_output">
							<p>$</p><form:input path="prise" class="amount-prise" value="${product.prise}"/>
						</div>
							<div class="slider-range-prise"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип сканера</p>
						<form:errors path="typeProduct" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="typeProduct" productValue="${product.typeProduct}" properties="${scanner.type_product}"/>
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
				
				<!-- import actions -->
				<jsp:include page="product/actions.jsp" />
				
				<!-- import time shares action -->
				<jsp:include page="product/time_shares.jsp" />
				
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Состояние оборудования</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="previouslyUsed" productValue="${product.previouslyUsed}" properties="${scanner.previously_used}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина сканируемой области (для ввода вручную)</p>
						<form:errors path="inputFirstWeightPrintMM" cssClass="error"></form:errors>
						<form:errors path="inputSecondWeightPrintMM" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="inputFirstWeightPrintMM" />
							<form:errors path="inputFirstWeightPrintMM" cssClass="error"></form:errors>	 
				    		<p>&nbsp;X&nbsp;</p><form:input style="width: 33px;" path="inputSecondWeightPrintMM" />
				    		<p>&nbsp; мм</p>
				    		<form:errors path="inputSecondWeightPrintMM" cssClass="error"></form:errors>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина сканирования</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${scanner.scanning_width}" path="scanningWidth" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Подача</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="innings" productValue="${product.innings}" properties="${scanner.innings}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цветность</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="chromaticity" productValue="${product.chromaticity}" properties="${scanner.chromaticity}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Сканирующий элемент</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${scanner.scanning_element}" path="scanningElement" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Источник света</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="lightSource" productValue="${product.lightSource}" properties="${scanner.light_source}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Разрядность цветного сканирования</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="bitColorScanning" productValue="${product.bitColorScanning}" properties="${scanner.bit_color_scanning}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Разрядность сканирования с оттенками серого</p>
					</div>
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="bitScanningGrayscale" productValue="${product.bitScanningGrayscale}" properties="${scanner.bit_scanning_grayscale}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Программное разрешение</p>
						<form:errors path="softwareResolution" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="softwareResolution" />
					</ul>
				</div>
			</div>
			

			<div class="product_characteristic">
			    <div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость сканирования</p>
						<form:errors path="scanSpeed" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="scanSpeed" />
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Оптическое разрешение</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${scanner.optical_resolution}" path="opticalResolution" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${scanner.connection_interface}" path="connectionInterface" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная толщина  носителя</p>
						<form:errors path="theMaximumThicknessOfTheCarrier" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="theMaximumThicknessOfTheCarrier" />
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>П/О</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${scanner.software}" path="software" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${scanner.equipment_manufacturer}" path="equipmentManufacturer" element="li"/>
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
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maxPowerConsumption" class="amount-max_power_consumption" value="${product.maxPowerConsumption}"/>
							<p>&nbsp;Вт</p>
						</div>
						<div class="slider-range-max_power_consumption"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вес</p>
						<form:errors path="weight" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="weight" class="amount-weight" value="${product.weight}"/>
							<p>&nbsp;кг</p>
						</div>
						<div class="slider-range-weight"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина</p>
						<form:errors path="width" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="width" class="amount-width" value="${product.width}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-width"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Глубина</p>
						<form:errors path="depth" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="depth" class="amount-depth" value="${product.depth}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-depth"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Высота</p>
						<form:errors path="heigth" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="heigth" class="amount-heigth" value="${product.heigth}"/>
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-heigth"></div>
					</ul>
				</div>
				
				<!-- import delivery and insurance option -->
				<jsp:include page="product/delivery_and_insurance.jsp" />
				
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Гарантия, месяцев</p>
						<form:errors path="guarantee" cssclass="error"></form:errors>
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
					<ul class="check_boxes">
						<custom:radio nameOfAttribyte="availability" productValue="${product.availability}" properties="${scanner.availability}"/>
						<div class="text_output">
							<form:input path="availabilitySpecialCase"/>
						</div>
					</ul>
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