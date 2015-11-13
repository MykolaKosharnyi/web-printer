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
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/add_change_3d_printer.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/tiny_mce/tinymce.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin/common.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_3d_printer.js"></script>

<c:if test="${empty product.name}">
	<title>
		<spring:message text="Добавление нового 3D принтера" />
	</title>
</c:if>
<c:if test="${!empty product.name}">
	<title>
		<spring:message text="Изменение 3D принтера" />
	</title>
</c:if>
</head>
<body>
	<c:url var="addPictures" value="/admin/printer_3d/upload_pictures" ></c:url>
	
	<div id="product">
	
			<c:if test="${empty product.name}">
					<label id="head_of_page"><spring:message text="Добавление нового 3D принтера" /></label>
					<c:url var="addAction" value="/admin/printer_3d/add" ></c:url>
			</c:if>
			
			<c:if test="${!empty product.name}">
					<label id="head_of_page"><spring:message text="Изменение ${product.name}, партномер: ${product.partNumber} " /></label>
					<c:url var="addAction" value="/admin/printer_3d/update" ></c:url>
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
						<c:forEach items="${product.pathPictures}" var="pathPicture">
							<li class="ui-state-default" id="${pathPicture}">
								<div>
									<p class="delete_img">Удалить</p>
								</div>
								<img src="<%=request.getContextPath()%>/resources/images/printers3d/${product.id}/${pathPicture}" alt="">
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
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${typePrinter3D}" path="typePrinter3D" element="li" value="${product.typePrinter3D}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер запечатываемой области</p>
					</div>
					<ul class="check_boxes">
						<p style="float: none; margin: 10px auto 0px;"> По оси Х:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaX" class="amount-sizePrintableAreaX" value="${product.sizePrintableAreaX}"/>
							<p >&nbsp;мм</p>
						</div>
							<div class="slider-range-sizePrintableAreaX"></div>
		
						<p style="float: none; margin: 10px auto 0px;"> По оси Y:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaY" class="amount-sizePrintableAreaY" value="${product.sizePrintableAreaY}" />
							<p>&nbsp;мм</p>
						</div>
							<div class="slider-range-sizePrintableAreaY"></div>
		
						<p style="float: none; margin: 10px auto 0px;"> По оси Z:</p>
						<div class="text_output">
							<form:input path="sizePrintableAreaZ" class="amount-sizePrintableAreaZ" value="${product.sizePrintableAreaZ}" />
							<p>&nbsp;мм</p>
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
						<form:radiobuttons items="${printTechnology}" path="printTechnology" element="li" value="${product.printTechnology}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Предыдущее использование</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${previouslyUsed}" path="previouslyUsed" element="li" value="${product.previouslyUsed}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цветность</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${chromaticity}" path="chromaticity" element="li" value="${product.chromaticity}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${typeOfPrinthead}" path="typeOfPrinthead" element="li" value="${product.typeOfPrinthead}"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Температура плавления печатного материала</p>
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
						<form:checkboxes items="${media}" path="media" element="li" value="${product.media}"/>
					</ul>
				</div> 
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер эктрудера</p>
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
						<form:checkboxes items="${interfaceConnection}" path="interfaceConnection" element="li" value="${product.interfaceConnection}"/>
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тыпы файлов</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${typesOfFiles}" path="typesOfFiles" element="li" value="${product.typesOfFiles}"/>
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>П/О</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${rip}" path="rip" element="li" value="${product.rip}"/>
					</ul>
				</div> 		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная масса распечатываемой модели</p>
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
						<form:radiobuttons items="${equipmentManufacturer}" path="equipmentManufacturer" element="li" value="${product.equipmentManufacturer}"/>
					</ul>
				</div>		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная потребляемая мощность</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maxPowerConsumption" class="amount-maxPowerConsumption" value="${product.maxPowerConsumption}" />
							<p>&nbsp;кВт</p>
						</div>
							<div class="slider-range-maxPowerConsumption"></div>
					</ul>
				</div>		
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вес</p>
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
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="width" class="amount-width" value="${product.width}" />
							<p>&nbsp;м</p>
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
							<form:input path="heigth" class="amount-heigth" value="${product.heigth}" />
							<p>&nbsp;м</p>
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
							<form:input path="depth" class="amount-depth" value="${product.depth}" />
							<p>&nbsp;м</p>
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