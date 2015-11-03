<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/style_admin.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
    <script src="http://malsup.github.com/jquery.form.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/addPrinter.js"></script>

<c:if test="${empty printer.name}">
	<title>
		<spring:message text="Добавление нового принтера" />
	</title>
</c:if>
<c:if test="${!empty printer.name}">
	<title>
		<spring:message text="Изменение" />
	</title>
</c:if>
  <script>
  $(function() {
    $( "#file-list" ).sortable({
    	axis: "y",
    	cursor: "move",
    	opacity: 1
    });
    $( "#file-list" ).disableSelection();
  });
  </script>
</head>
<body>
	<c:url var="addAction" value="/printer/add" ></c:url>
	<c:url var="addPictures" value="/admin/printer/upload_pictures" ></c:url>
	
	<div id="product">
	
			<c:if test="${empty printer.name}">
					<label id="head_of_page"><spring:message text="Добавление нового принтера" /></label>
			</c:if>
			
			<c:if test="${!empty printer.name}">
					<label id="head_of_page"><spring:message text="Изменение ${printer.name} " /></label>
					<input type="hidden" name="id" value="${printer.id}">
			</c:if>
			
			<div id="pictures">
				<h3>Выберите файл(ы) для загрузки</h3>
				
		<form:form method="POST" commandName="add_picture" action="${addPictures}" enctype="multipart/form-data">
				<p><input id="files-upload" type="file" id="files" name="files" accept="image/*" multiple></p>
		
				<p id="drop-area">
					<span class="drop-instructions">или перетащите файлы сюда!</span>
					<span class="drop-over"></span>
				</p>
		</form:form>
				<ul id="file-list">
					<li class="no-items">(ни одного файла еще не загружено)</li>
				</ul>
			</div>

	<form:form method="POST" commandName="printer" action="${addAction}">

			<div id="printer_characteristic">
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
						<p>Тип принтера</p>
					</div>
					<ul class="check_boxes">
						<form:radiobuttons items="${typePrinter}" path="typePrinter" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цена</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>$</p><form:input path="prise" class="amount-prise" value="${printer.prise}"/>
							<form:errors path="prise" cssclass="error"></form:errors>
						</div>
							<div class="slider-range-prise"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Партийный номер принтера</p>
					</div>
					<div class="check_boxes">
						<form:input path="partNumber" />
						<form:errors path="partNumber" cssclass="error"></form:errors>
					</div>
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
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер капли</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${sizeDrops}" path="sizeDrops" element="li"/>
					</ul>
				</div>
			</div>

			<div id="printer_characteristic">
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Скорость печати</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="speedPrint" class="amount-speed-print" value="${printer.speedPrint}"/>
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
						<form:radiobuttons items="${interfaceConnection}" path="interfaceConnection" element="li"/>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная толщина носителя</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<form:input path="maximumMediaThickness" class="amount-maximum_media_thickness" value="${printer.maximumMediaThickness}"/>
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
							<form:input path="maximumWeightOfVehicle" class="amount-maximum_weight_of_vehicle" value="${printer.maximumWeightOfVehicle}"/>
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
							<form:input path="maxPowerConsumption" class="amount-max_power_consumption" value="${printer.maxPowerConsumption}"/>
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
							<form:input path="weight" class="amount-weight" value="${printer.weight}"/>
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
							<form:input path="width" class="amount-width" value="${printer.width}"/>
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
							<form:input path="heigth" class="amount-heigth" value="${printer.heigth}"/>
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
							<form:input path="depth" class="amount-depth" value="${printer.depth}"/>
							<p>&nbsp;м</p>
							<form:errors path="depth" cssclass="error"></form:errors>
						</div>
						<div class="slider-range-depth"></div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Описание</p>
					</div>
					<ul class="check_boxes">
						<form:textarea rows="4" cols="29" path="description" value="${printer.depth}"></form:textarea>
					</ul>
				</div>
			</div>
			
			<input type="submit" value="загрузить" />
		</form:form>
	</div>
<script>
$(document).ready(function() {
	var filesUpload = document.getElementById("files-upload"),
		dropArea = document.getElementById("drop-area"),
		fileList = document.getElementById("file-list");

	function uploadFile(file) {
		var li = document.createElement("li"),
			div = document.createElement("div"),
			img,
			progressBarContainer = document.createElement("div"),
			progressBar = document.createElement("div"),
			reader,
			idLI,
			fileInfo="";

		li.appendChild(div);
		li.setAttribute("class", "ui-state-default");

		progressBarContainer.className = "progress-bar-container";
		progressBar.className = "progress-bar";
		progressBarContainer.appendChild(progressBar);
		li.appendChild(progressBarContainer);

		/*
		If the file is an image and the web browser supports FileReader,
		present a preview in the file list
		 */
		if (typeof FileReader !== "undefined"
				&& (/image/i).test(file.type)) {
			img = document.createElement("img");
			li.appendChild(img);
			reader = new FileReader();
			reader.onload = (function(theImg) {
				return function(evt) {
					theImg.src = evt.target.result;
				};
			}(img));
			reader.readAsDataURL(file);
		}

		$('#add_picture').ajaxForm( {
			type: 'post',
			success: function(result){
				li.id = result;
			}
			}).submit(); 
		
		
		
	/*	// Uploading - for Firefox, Google Chrome and Safari
		xhr = new XMLHttpRequest();

		// Update progress bar
		xhr.upload.addEventListener("progress", function(evt) {
			if (evt.lengthComputable) {
				progressBar.style.width = (evt.loaded / evt.total)
						* 100 + "%";
			} else {
				// No data to calculate on
			}
		}, false);

		// File uploaded
		xhr.addEventListener("load", function() {
			progressBarContainer.className += " uploaded";
			progressBar.innerHTML = "Uploaded!";
		}, false);*/

	/*	xhr.open("post", "http://localhost:8080/nk/printer/upload_pictures", true);

		// Set appropriate headers
		xhr.setRequestHeader("Content-Type", "multipart/form-data");
		xhr.setRequestHeader("X-File-Name", file.name);
		xhr.setRequestHeader("X-File-Size", file.size);
		xhr.setRequestHeader("X-File-Type", file.type);

		// Send the file (doh)
		xhr.send(file);*/

		// Present file info and append it to the list of files
	/*	fileInfo = "<div><strong>Name:</strong> " + file.name
				+ "</div>";
		fileInfo += "<div><strong>Size:</strong> "
				+ parseInt(file.size / 1024, 10) + " kb</div>";
		fileInfo += "<div><strong>Type:</strong> " + file.type
				+ "</div>";*/
		fileInfo += "<p class=\"delete_img\">Удалить</p>";
		div.innerHTML = fileInfo;

		fileList.appendChild(li);
	}

	function traverseFiles(files) {
		if (typeof files !== "undefined") {
			for (var i = 0, l = files.length; i < l; i++) {
				uploadFile(files[i]);
				/*if(i==files.length){
					resetFormElement(filesUpload);
				}*/
			}
		} else {
			fileList.innerHTML = "No support for the File API in this web browser";
		}
	}

	filesUpload.addEventListener("change", function() {
		traverseFiles(this.files);
		jQuery(".no-items").remove();
	}, false);

	dropArea.addEventListener("dragleave", function(evt) {
		var target = evt.target;

		if (target && target === dropArea) {
			this.className = "";
		}
		jQuery(".no-items").remove();
		evt.preventDefault();
		evt.stopPropagation();
	}, false);

	dropArea.addEventListener("dragenter", function(evt) {
		this.className = "over";
		jQuery(".no-items").remove();
		evt.preventDefault();
		evt.stopPropagation();
	}, false);

	dropArea.addEventListener("dragover", function(evt) {
		jQuery(".no-items").remove();
		evt.preventDefault();
		evt.stopPropagation();
	}, false);

	dropArea.addEventListener("drop", function(evt) {
		traverseFiles(evt.dataTransfer.files);
		this.className = "";
		jQuery(".no-items").remove();
		evt.preventDefault();
		evt.stopPropagation();
	}, false);
	
/*	function resetFormElement(e) {
		  e.wrap('<form>').closest('form').get(0).reset();
		  e.unwrap();

		  // Prevent form submission
		  e.stopPropagation();
		  e.preventDefault();
		}*/
});

$(document).ready(function(){
	$('#file-list').sortable({
		update: function(event, ui) {
			var pictureOrder = $(this).sortable('toArray');
			var data = JSON.stringify(pictureOrder);
			$.ajax({
				  type: 'POST',
				  url: "/nk/admin/printer/change_order_pictures",
				  data: data,
				  contentType: "application/json; charset=utf-8",
		          dataType: "json"
				  });
			/*$.post('/nk/admin/printer/change_order_pictures', JSON.stringify(data), function() {}, 'json');*/
		}
	});
});

jQuery(document).on('click', '.delete_img', function(){
	  jQuery(this).closest('li').remove();
	});
</script>
</body>
</html>