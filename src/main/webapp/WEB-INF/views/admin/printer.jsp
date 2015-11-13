<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/add_change_printer.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script  src="<%=request.getContextPath()%>/resources/js/tiny_mce/tinymce.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin/common.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_printer.js"></script>

<c:if test="${empty product.name}">
	<title>
		<spring:message text="Добавление нового принтера" />
	</title>
</c:if>
<c:if test="${!empty product.name}">
	<title>
		<spring:message text="Изменение" />
	</title>
</c:if>
</head>
<body>
	<c:url var="addPictures" value="/admin/printer/upload_pictures" ></c:url>
	
	<div id="product">
	
			<c:if test="${empty product.name}">
					<label id="head_of_page"><spring:message text="Добавление нового принтера" /></label>
					<c:url var="addAction" value="/admin/printer/add" ></c:url>
			</c:if>
			
			<c:if test="${!empty product.name}">
					<label id="head_of_page"><spring:message text="Изменение ${product.name}, партномер: ${product.partNumber} " /></label>
					<c:url var="addAction" value="/admin/printer/update" ></c:url>
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
					<c:if test="${empty product.name}">
						<li class="no-items">(ни одного файла еще не загружено)</li>
					</c:if>
					<c:if test="${!empty product.name}">
						<c:forEach items="${printer.pathPictures}" var="pathPicture">
							<li class="ui-state-default" id="${pathPicture}">
								<div>
									<p class="delete_img">Удалить</p>
								</div>
								<img src="<%=request.getContextPath()%>/resources/images/printers/${product.id}/${pathPicture}" alt="">
							</li>
						</c:forEach>
					</c:if>
				</ul>
			</div>

	<form:form method="POST" commandName="product" action="${addAction}">
			
			<c:if test="${!empty product.name}">
					<input type="hidden" name="id" value="${product.id}">
			</c:if>
			
			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Название принтера</p>
					</div>
					<div class="check_boxes">
						<form:input path="name" />
						<form:errors path="name" cssclass="error"></form:errors>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Партномер принтера</p>
					</div>
					<div class="check_boxes">
						<form:input path="partNumber" />
						<form:errors path="partNumber" cssclass="error"></form:errors>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цена</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>$</p><form:input path="prise" class="amount-prise" value="${product.prise}"/>
							<form:errors path="prise" cssclass="error"></form:errors>
						</div>
							<div class="slider-range-prise"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип принтера</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${typePrinter}" path="typePrinter" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Модель</p>
					</div>
					<div class="check_boxes">
						<form:input path="equipmentModel" />
						<form:errors path="equipmentModel" cssclass="error"></form:errors>
					</div>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина печати в миллиметрах</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${weightPrintMM}" path="weightPrintMM" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Предыдущее использование</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${previouslyUsed}" path="previouslyUsed" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печати</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typePrint}" path="typePrint" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Подача метериала</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${feeds}" path="feed" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цветность</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${chromaticity}" path="chromaticity" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${manufacturerPrinthead}" path="manufacturerPrinthead" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${typeOfPrinthead}" path="typeOfPrinthead" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Совместимые чернила</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${compatibleInk}" path="compatibleInk" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип капли</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typeDrops}" path="typeDrops" element="li"/>
					</ul>
				</div>
			</div>

			<div class="product_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер капли</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${sizeDrops}" path="sizeDrops" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость печати</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="speedPrint" class="amount-speed-print" value="${product.speedPrint}"/>
							<p>&nbsp;м.кв./ч.</p>
							<form:errors path="speedPrint" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-speed-print"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Разрешение печати</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${printResolution}" path="printResolution" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${equipmentManufacturer}" path="equipmentManufacturer" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${interfaceConnection}" path="interfaceConnection" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная толщина носителя</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maximumMediaThickness" class="amount-maximum_media_thickness" value="${product.maximumMediaThickness}"/>
							<p>&nbsp;мм</p>
							<form:errors path="maximumMediaThickness" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-maximum_media_thickness"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальный вес носителя</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maximumWeightOfVehicle" class="amount-maximum_weight_of_vehicle" value="${product.maximumWeightOfVehicle}"/>
							<p>&nbsp;кг</p>
							<form:errors path="maximumWeightOfVehicle" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-maximum_weight_of_vehicle"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>П/О RIP</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${rip}" path="rip" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная потребляемая мощность</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maxPowerConsumption" class="amount-max_power_consumption" value="${product.maxPowerConsumption}"/>
							<p>&nbsp;кВт</p>
							<form:errors path="maxPowerConsumption" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-max_power_consumption"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вес</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="weight" class="amount-weight" value="${product.weight}"/>
							<p>&nbsp;кг</p>
							<form:errors path="weight" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-weight"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="width" class="amount-width" value="${product.width}"/>
							<p>&nbsp;м</p>
							<form:errors path="width" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-width"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Высота</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="heigth" class="amount-heigth" value="${product.heigth}"/>
							<p>&nbsp;м</p>
							<form:errors path="heigth" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-heigth"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Глубина</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="depth" class="amount-depth" value="${product.depth}"/>
							<p>&nbsp;м</p>
							<form:errors path="depth" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-depth"></div>
					</ul>
				</div>
			</div>

		  	<div class="textarea_description">
			<div class="characteristic">
					<div class="block_title">
						<i class="opened"></i>
						<p>Описание</p>
					</div>
					<ul class="check_boxes" style="display: block;">
						<form:textarea name="content" path="description" value="${product.description}"></form:textarea>
					</ul>
				</div>
			</div>
			
			<div class="textarea_description">
			<div class="characteristic">
					<div class="block_title">
						<i class="opened"></i>
						<p>Description(отображение при выборе английского языка на сайте)</p>
					</div>
					<ul class="check_boxes" style="display: block;">
						<form:textarea name="content" path="descriptionEng" value="${product.descriptionEng}"></form:textarea>
					</ul>
				</div>
			</div>
			<c:if test="${empty product.name}">
					<input id="submit" type="submit" value="загрузить" />
			</c:if>
			
			<c:if test="${!empty product.name}">
					<input id="submit" type="submit" value="изменить" />
			</c:if>

		</form:form>
	</div>
</body>
</html>