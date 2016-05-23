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
	<c:url var="addPictures" value="/admin/laser/upload_pictures" ></c:url>
	
	<div id="product">
	
		<c:if test="${empty product.id}">
			<label id="head_of_page"><spring:message text="Добавление нового лазера" /></label>
			<c:url var="addAction" value="/admin/laser/add" ></c:url>
		</c:if>
			
		<c:if test="${!empty product.id}">
			<label  id="head_of_page"><spring:message text="Изменение ${product.name}, код товара: ${product.partNumber} " /></label>
			<c:url var="addAction" value="/admin/laser/update" ></c:url>
		</c:if>
		
		<div id="pictures">
			<h3>Выберите файл(ы) для загрузки (800х600pdi)</h3>
				
		<form:form method="POST" commandName="add_picture" action="${addPictures}" enctype="multipart/form-data">
			<p><input id="files-upload" type="file" id="files" name="files" accept="image/*" ></p>
		
			<p id="drop-area">
				<span class="drop-instructions">или перетащите файлы сюда!</span>
				<span class="drop-over"></span>
			</p>
		</form:form>
			<ul id="file-list">
				<c:if test="${empty product.id}">
					<li class="no-items">(ни одного файла еще не загружено)</li>
				</c:if>
				<c:if test="${!empty product.id}">
					<c:forEach items="${product.pathPictures}" var="pathPicture">
						<li class="ui-state-default" id="${pathPicture}">
							<div>
								<p class="delete_img">Удалить</p>
							</div>
							<img src="/images/lasers/${product.id}/${pathPicture}" alt="">
						</li>
					</c:forEach>
				</c:if>
			</ul>
		</div>

	<form:form method="POST" commandName="product" action="${addAction}">
		<div class="save_button_keeper">	
			<c:if test="${empty product.id}">
				<c:url value="/admin/laser/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green; color: azure;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/laser/save_update" var="saveUpdate" />
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
						<p>Тип лазера</p>
						<form:errors path="typeLaser" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${laser.type_laser}" path="typeLaser" element="li"/>
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
						<form:radiobuttons items="${laser.previously_used}" path="previouslyUsed" element="li"/>
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
						<form:radiobuttons items="${laser.type_of_cooling}" path="typeOfCooling" element="li"/>
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
						<form:radiobuttons items="${laser.color_separation}" path="colorSeparation" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип выводимого изображения</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${laser.type_the_displayed_image}" path="typeTheDisplayedImage" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Минимальный размер символа</p>
						<form:errors path="firstPartTheMinimumCharacterSize" cssClass="error"></form:errors>
						<form:errors path="secondPartTheMinimumCharacterSize" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="firstPartTheMinimumCharacterSize" />
							<form:errors path="firstPartTheMinimumCharacterSize" cssClass="error"></form:errors>	 
				    		<p>&nbsp;X&nbsp;</p><form:input style="width: 33px;" path="secondPartTheMinimumCharacterSize" />
				    		<form:errors path="secondPartTheMinimumCharacterSize" cssClass="error"></form:errors>
				    		<p>&nbsp; мм</p>
						</div>
					</ul>
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
					<ul class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="firstPartAdjustingTheLaserPower" />
							<form:errors path="firstPartAdjustingTheLaserPower" cssClass="error"></form:errors>	 
				    		<p>&nbsp;-&nbsp;</p><form:input style="width: 33px;" path="secondPartAdjustingTheLaserPower" />
				    		<form:errors path="secondPartAdjustingTheLaserPower" cssClass="error"></form:errors>
				    		<p>&nbsp;%</p>
						</div>
					</ul>
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
						<form:checkboxes items="${laser.special_purpose}" path="specialPurpose" element="li"/>
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
					<ul class="check_boxes">
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
					</ul>
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
					<ul class="check_boxes">
						<div class="text_output">
							<form:input style="width: 33px;" path="laserPulse0" />
							<form:errors path="laserPulse0" cssClass="error"></form:errors>	 
				    		<p>&nbsp;-&nbsp;</p><form:input style="width: 33px;" path="laserPulse1" />
				    		<form:errors path="laserPulse1" cssClass="error"></form:errors>
						</div>
					</ul>
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
						<form:radiobuttons items="${laser.type_engine}" path="typeEngine" element="li"/>
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
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Доставка</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${laser.delivery}" path="delivery" element="li"/>
					</ul>
				</div>
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
						<form:radiobuttons items="${laser.availability}" path="availability" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Опции</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${laser.availability}" path="availability" element="li"/>
					</ul>
				</div>
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
</body>
</html>