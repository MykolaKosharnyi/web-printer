<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<!DOCTYPE>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="/css/admin/add_change_printer.css">
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_printer.js"></script>

<c:if test="${empty product.id}">
	<title>
		<spring:message text="Добавление нового гравера/фрезера" />
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
			<label id="head_of_page"><spring:message text="Добавление нового гравера/фрезера" /></label>
			<c:url var="addAction" value="/admin/${type}/add" ></c:url>
		</c:if>
			
		<c:if test="${!empty product.id}">
			<label id="head_of_page"><spring:message text="Изменение ${product.name}, код товара: ${product.partNumber} " /></label>
			<c:url var="addAction" value="/admin/${type}/update" ></c:url>
		</c:if>
		
		<jsp:include page="product/pictures.jsp" />

	<form:form method="POST" commandName="product" action="${addAction}">
		<div class="save_button_keeper">	
			<c:if test="${empty product.id}">
				<c:url value="/admin/cutter/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/cutter/save_update" var="saveUpdate" />
				<input id="submit" type="submit" formaction="${saveUpdate}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="изменить" style="background:blue; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
					<input type="hidden" name="id" value="${product.id}">
			</c:if>
		</div>
			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Название гравера/фрезера</p>
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
						<p>Тип гравера/фрезера</p>
						<form:errors path="typeCutter" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${cutter.type_cutter}" path="typeCutter" element="li"/>
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
						<form:radiobuttons items="${cutter.previously_used}" path="previouslyUsed" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Акции. Ярлык слева(цвет текста/фона)</p>
					</div>
					<div class="check_boxes">
						<form:input path="leftSharesLink" style="width: 100px;"/>
						<input type="color" name="leftSharesLinkColorText" value="${product.leftSharesLinkColorText}"/>
						<input type="color" name="leftSharesLinkColorFone" value="${product.leftSharesLinkColorFone}"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Акции. Ярлык справа(цвет текста/фона)</p>
					</div>
					<div class="check_boxes">
						<form:input path="rightSharesLink" style="width: 100px;"/>
						<input type="color" name="rightSharesLinkColorText" value="${product.rightSharesLinkColorText}"/>
						<input type="color" name="rightSharesLinkColorFone" value="${product.rightSharesLinkColorFone}"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Таймер на акции, в формате "дд.мм.гггг"</p>
						<form:errors path="timeShares" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<input type="text" class= "date" name = "timeShares" 
						value = "<fmt:formatDate value="${product.timeShares}" pattern="dd.MM.yyyy" />"/>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер рабочей области</p>
						<form:errors path="sizeWorkAreaX" cssClass="error"></form:errors>
						<form:errors path="sizeWorkAreaY" cssClass="error"></form:errors>
						<form:errors path="sizeWorkAreaZ" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
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
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип гравировки</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${cutter.engraving_style}" path="engravingStyle" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип охлаждения</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${cutter.type_of_cooling}" path="typeOfCooling" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Количество шпинделей, шт</p>
						<form:errors path="numberOfSpindles" cssClass="error"></form:errors>
					</div>
					<div class="check_boxes">
						<form:input path="numberOfSpindles" />
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
						<p>Тип двигателей</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${cutter.type_engine}" path="typeEngine" element="li"/>
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
						<p>Частота вращения шпинделя, об/мин</p>
						<form:errors path="frequencySpindle" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="frequencySpindle"/>
					</ul>
				</div>
				
			</div>

			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость обработки(XY), мм/с</p>
						<form:errors path="processingSpeedXY" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="processingSpeedXY"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость обработки(Z), мм/с</p>
						<form:errors path="processingSpeedZ" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:input path="processingSpeedZ"/>						
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Крепление инструмента</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${cutter.mounting_tool}" path="mountingTool" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${cutter.connection_interface}" path="connectionInterface" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Програмное обеспечение</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${cutter.software}" path="software" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${cutter.equipment_manufacturer}" path="equipmentManufacturer" element="li"/>
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
					<ul class="check_boxes">
						<form:radiobuttons items="${cutter.availability}" path="availability" element="li"/>
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