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

    <link rel="stylesheet" href="/css/admin/add_change_3d_printer.css">
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_3d_printer.js"></script>

<c:if test="${empty product.id}">
	<title>
		<spring:message text="Добавление нового 3D принтера" />
	</title>
</c:if>
<c:if test="${!empty product.id}">
	<title>
		<spring:message text="Изменение 3D принтера" />
	</title>
</c:if>
</head>
<body>
	<c:url var="addPictures" value="/admin/3d_printer/upload_pictures" ></c:url>
	
	<div id="product">
	
			<c:if test="${empty product.id}">
					<label id="head_of_page"><spring:message text="Добавление нового 3D принтера" /></label>
					<c:url var="addAction" value="/admin/3d_printer/add" ></c:url>
			</c:if>
			
			<c:if test="${!empty product.id}">
					<label id="head_of_page"><spring:message text="Изменение ${product.name}, код товара: ${product.partNumber} " /></label>
					<c:url var="addAction" value="/admin/3d_printer/update" ></c:url>
			</c:if>
			
			<div id="pictures">
				<h3>Выберите файл(ы) для загрузки</h3>
				
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
								<img src="<%=request.getContextPath()%>/images/3d_printers/${product.id}/${pathPicture}" alt="">
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</div>

	<form:form method="POST" commandName="product" action="${addAction}">
			
			<c:if test="${empty product.id}">
				<c:url value="/admin/3d_printer/save_add" var="saveLoad" />
				<input id="submit" type="submit" formaction="${saveLoad}" onclick="return false;" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="загрузить" style="background: green;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<c:url value="/admin/3d_printer/save_update" var="saveUpdate" />
				<input id="submit" type="submit" formaction="${saveUpdate}" onclick="return false;" value="сохранить" style="background: gold; color: black;"/>
				<input id="submit" type="submit" value="изменить" style="background:blue;"/>
			</c:if>
		
			<c:if test="${!empty product.id}">
					<input type="hidden" name="id" value="${product.id}">
			</c:if>
			
			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Название принтера</p>
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
							<p>$</p>
							<form:input path="prise" class="amount-prise" value="${product.prise}" />
							<p>&nbsp;$</p>
						</div>
						<div class="slider-range-prise"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип принтера</p>
						<form:errors path="typePrinter3D" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${typePrinter3D}" path="typePrinter3D" element="li"/>
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
						<p>Размер запечатываемой области</p>
						<form:errors path="sizePrintableAreaX" cssClass="error"></form:errors>
						<form:errors path="sizePrintableAreaY" cssClass="error"></form:errors>
						<form:errors path="sizePrintableAreaZ" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<p style="float: none; margin: 10px auto 0px;"> По оси Х:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaX" class="amount-sizePrintableAreaX" value="${product.sizePrintableAreaX}"/>
							<p >&nbsp;мм</p>
							<form:errors path="sizePrintableAreaX" cssClass="error"></form:errors>
						</div>
							<div class="slider-range-sizePrintableAreaX"></div>
		
						<p style="float: none; margin: 10px auto 0px;"> По оси Y:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaY" class="amount-sizePrintableAreaY" value="${product.sizePrintableAreaY}" />
							<p>&nbsp;мм</p>
							<form:errors path="sizePrintableAreaY" cssClass="error"></form:errors>
						</div>
							<div class="slider-range-sizePrintableAreaY"></div>
		
						<p style="float: none; margin: 10px auto 0px;"> По оси Z:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaZ" class="amount-sizePrintableAreaZ" value="${product.sizePrintableAreaZ}" />
							<p>&nbsp;мм</p>
							<form:errors path="sizePrintableAreaZ" cssClass="error"></form:errors>
						</div>
							<div class="slider-range-sizePrintableAreaZ"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Технология печати</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${printTechnology}" path="printTechnology" element="li" />
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Состояние оборудования</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${previouslyUsed}" path="previouslyUsed" element="li" />
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цветовая схема</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${chromaticity}" path="chromaticity" element="li" />
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${typeOfPrinthead}" path="typeOfPrinthead" element="li" />
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Температура плавления печатного материала</p>
						<form:errors path="meltingPointOfThePrintingMaterial" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="meltingPointOfThePrintingMaterial" class="amount-meltingPointOfThePrintingMaterial" value="${product.meltingPointOfThePrintingMaterial}" />
							<p>&nbsp;С</p>
						</div>
							<div class="slider-range-meltingPointOfThePrintingMaterial"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Материал для печати</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${media}" path="media" element="li"/>
					</ul>
				</div> 
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер эктрудера</p>
						<form:errors path="sizeExtruder" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="sizeExtruder" class="amount-sizeExtruder" value="${product.sizeExtruder}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-sizeExtruder"></div>
					</ul>
				</div>			
			</div>
			
			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость печати</p>
						<form:errors path="speedPrint" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="speedPrint" class="amount-speedPrint" value="${product.speedPrint}" />
							<p>&nbsp;мм/с</p>
						</div>
							<div class="slider-range-speedPrint"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Толщина слоя печати</p>
						<form:errors path="thicknessOfThePrintingLayer" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="thicknessOfThePrintingLayer" class="amount-thicknessOfThePrintingLayer" value="${product.thicknessOfThePrintingLayer}" />
							<p>&nbsp;микрон</p>
						</div>
							<div class="slider-range-thicknessOfThePrintingLayer"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${interfaceConnection}" path="interfaceConnection" element="li" />
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тыпы файлов</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typesOfFiles}" path="typesOfFiles" element="li" />
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Программное обеспечение</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${rip}" path="rip" element="li" />
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная масса распечатываемой модели</p>
						<form:errors path="maximumWeightOfThePrintedModel" cssClass="error"></form:errors>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maximumWeightOfThePrintedModel" class="amount-maximumWeightOfThePrintedModel" value="${product.maximumWeightOfThePrintedModel}" />
							<p>&nbsp;кг</p>
						</div>
							<div class="slider-range-maximumWeightOfThePrintedModel"></div>
					</ul>
				</div>		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${equipmentManufacturer}" path="equipmentManufacturer" element="li" />
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
							<form:input path="maxPowerConsumption" class="amount-maxPowerConsumption" value="${product.maxPowerConsumption}" />
							<p>&nbsp;Вт</p>
						</div>
							<div class="slider-range-maxPowerConsumption"></div>
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
							<form:input path="weight" class="amount-weight" value="${product.weight}" />
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
							<form:input path="width" class="amount-width" value="${product.width}" />
							<p>&nbsp;мм</p>
						</div>
						<div class="slider-range-width"></div>
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
							<form:input path="heigth" class="amount-heigth" value="${product.heigth}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-heigth"></div>
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
							<form:input path="depth" class="amount-depth" value="${product.depth}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-depth"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Доставка</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${delivery}" path="delivery" element="li"/>
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
						<form:radiobuttons items="${availability}" path="availability" element="li"/>
					</ul>
				</div>
			</div>

			<div class="textarea_description">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Служебная информация</p>
					</div>
					<ul class="box_text_area">
						<form:textarea path="serviceInformation" value="${product.serviceInformation}"></form:textarea>
					</ul>
				</div>
			</div>

		  	<div class="textarea_description">
			<div class="characteristic">
					<div class="block_title">
						<i class="opened"></i>
						<p>Описание</p>
					</div>
					<ul class="box_text_area" style="display: block;">
						<form:textarea path="description" value="${product.description}"></form:textarea>
					</ul>
				</div>
			</div>
			
			<div class="textarea_description">
			<div class="characteristic">
					<div class="block_title">
						<i class="opened"></i>
						<p>Description(отображение при выборе английского языка на сайте)</p>
					</div>
					<ul class="box_text_area" style="display: block;">
						<form:textarea path="descriptionEng" value="${product.descriptionEng}"></form:textarea>
					</ul>
				</div>
			</div>
			
			<c:if test="${empty product.id}">
				<input id="submit" type="submit" value="загрузить" style="background:green;"/>
			</c:if>
			
			<c:if test="${!empty product.id}">
				<input id="submit" type="submit" value="изменить" style="background:blue;"/>
			</c:if>

		</form:form>
	</div>
</body>
</html>