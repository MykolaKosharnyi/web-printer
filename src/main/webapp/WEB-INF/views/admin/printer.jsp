<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/style_admin.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">
    
    <script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
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
</head>
<body>

	<div id="product">

			<div id="pictures">
				<h3>Выберите файл(ы) для загрузки</h3>

				<p>
					<input id="files-upload" type="file" id="files" name="files" accept="image/*" multiple>
				</p>

				<p id="drop-area">
					<span class="drop-instructions">or drag and drop files here</span>
					<span class="drop-over">Drop files here!</span>
				</p>

				<ul id="file-list">
					<li class="no-items">(no files uploaded yet)</li>
				</ul>
			</div>
			<!-- <div id="pictures">
 				File to upload: <input type="file" name="file"><br /> 
        		Name: <input type="text" name="namePicture"><br /> <br />
			 	<input type="file" id="files" name="files" />
				<output id="list"></output>
			</div>
					 
	<script>
    function handleFileSelect(evt) {
        var files = evt.target.files; // FileList object

        // Loop through the FileList and render image files as thumbnails.
        for (var i = 0, f; f = files[i]; i++) {

          // Only process image files.
          if (!f.type.match('image.*')) {
            continue;
          }

          var reader = new FileReader();

          // Closure to capture the file information.
          reader.onload = (function(theFile) {
            return function(e) {
              // Render thumbnail.
              var span = document.createElement('span');
              span.innerHTML = ['<a href="">&times;</a><img class="thumb" src="', e.target.result,
                                '" title="', escape(theFile.name), '"/>'].join('');
              document.getElementById('list').insertBefore(span, null);
            };
          })(f);

          // Read in the image file as a data URL.
          reader.readAsDataURL(f);
        }
      }

      document.getElementById('files').addEventListener('change', handleFileSelect, false);
	</script>-->
	
	<c:url var="addAction" value="/printer/added" ></c:url>
	<form:form method="POST" commandName="printer" action="${addAction}" enctype="multipart/form-data">
	
				<c:if test="${empty printer.name}">
					<form:label path="id" id="head_of_page"><spring:message text="Добавление нового принтера" /></form:label>
			</c:if>
			
			<c:if test="${!empty printer.name}">
					<form:label path="id" id="head_of_page"><spring:message text="Изменение ${printer.name} " /></form:label>
					<input type="hidden" name="id" value="${printer.id}">
			</c:if>
	
	
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
						<li><form:radiobutton path="weightPrintMM" value="600"/>600</li>
						<li><form:radiobutton path="weightPrintMM" value="900"/>900</li>
						<li><form:radiobutton path="weightPrintMM" value="1070"/>1070</li>
						<li><form:radiobutton path="weightPrintMM" value="1300"/>1300</li>
						<li><form:radiobutton path="weightPrintMM" value="1600"/>1600</li>
						<li><form:radiobutton path="weightPrintMM" value="1800"/>1800</li>
						<li><form:radiobutton path="weightPrintMM" value="2500"/>2500</li>
						<li><form:radiobutton path="weightPrintMM" value="2600"/>2600</li>
						<li><form:radiobutton path="weightPrintMM" value="32000"/>32000</li>
						<li><form:radiobutton path="weightPrintMM" value="50000"/>50000</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цена</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>$</p><form:input path="prise" class="amount-prise"/>
							<form:errors path="prise" cssclass="error"></form:errors>
						</div>
						<div class="slider">
							<div class="slider-range-prise"></div>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Б/У оборудование</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="previouslyUsed"></form:checkbox>&nbsp;Бывшего употребления</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печати</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="typePrint" value="Термо-струйная"></form:checkbox>&nbsp;Термо-струйная</li>
						<li><form:checkbox path="typePrint" value="Пьезо-струйная"></form:checkbox>&nbsp;Пьезо-струйная</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Подача метериала</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${feeds}" path="feed" />
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Цветность</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="chromaticity" value="CMYK"></form:checkbox>&nbsp;CMYK</li>
						<li><form:checkbox path="chromaticity" value="CMYKX 2"></form:checkbox>&nbsp;CMYKX 2</li>
						<li><form:checkbox path="chromaticity" value="CMYKLcLm"></form:checkbox>&nbsp;CMYKLcLm</li>
						<li><form:checkbox path="chromaticity" value="CMYKLcLmOG"></form:checkbox>&nbsp;CMYKLcLmOG</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<li><form:radiobutton path="manufacturerPrinthead" value="Spectra"/>Spectra</li>
						<li><form:radiobutton path="manufacturerPrinthead" value="XAAR"/>XAAR</li>
						<li><form:radiobutton path="manufacturerPrinthead" value="SPT"/>SPT</li>
						<li><form:radiobutton path="manufacturerPrinthead" value="Konika-Minolta"/>Konika-Minolta</li>
						<li><form:radiobutton path="manufacturerPrinthead" value="Toshiba"/>Toshiba</li>
						<li><form:radiobutton path="manufacturerPrinthead" value="Ricoh"/>Ricoh</li>
						<li><form:radiobutton path="manufacturerPrinthead" value="Epson"/>Epson</li>
						<li><form:radiobutton path="manufacturerPrinthead" value="Lexmark"/>Lexmark</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<li><form:radiobutton path="typeOfPrinthead" value="Nova256"/>Nova256</li>
						<li><form:radiobutton path="typeOfPrinthead" value="Galaxy256"/>Galaxy256</li>
						<li><form:radiobutton path="typeOfPrinthead" value="Polyaris512"/>Polyaris512</li>
						<li><form:radiobutton path="typeOfPrinthead" value="126/50"/>126/50</li>
						<li><form:radiobutton path="typeOfPrinthead" value="126/80"/>126/80</li>
						<li><form:radiobutton path="typeOfPrinthead" value="128/40"/>128/40</li>
						<li><form:radiobutton path="typeOfPrinthead" value="128/80"/>128/80</li>
						<li><form:radiobutton path="typeOfPrinthead" value="255"/>255</li>
						<li><form:radiobutton path="typeOfPrinthead" value="256"/>256</li>
						<li><form:radiobutton path="typeOfPrinthead" value="500"/>500</li>
						<li><form:radiobutton path="typeOfPrinthead" value="510"/>510</li>
						<li><form:radiobutton path="typeOfPrinthead" value="512"/>512</li>
						<li><form:radiobutton path="typeOfPrinthead" value="512KN"/>512KN</li>
						<li><form:radiobutton path="typeOfPrinthead" value="1020"/>1020</li>
						<li><form:radiobutton path="typeOfPrinthead" value="1024"/>1024</li>
						<li><form:radiobutton path="typeOfPrinthead" value="1024I"/>1024I</li>
						<li><form:radiobutton path="typeOfPrinthead" value="CA3"/>CA3</li>
						<li><form:radiobutton path="typeOfPrinthead" value="CA4"/>CA4</li>
						<li><form:radiobutton path="typeOfPrinthead" value="Gen4"/>Gen4</li>
						<li><form:radiobutton path="typeOfPrinthead" value="Gen5"/>Gen5</li>
						<li><form:radiobutton path="typeOfPrinthead" value="DX2"/>DX2</li>
						<li><form:radiobutton path="typeOfPrinthead" value="DX4"/>DX4</li>
						<li><form:radiobutton path="typeOfPrinthead" value="DX5"/>DX5</li>
						<li><form:radiobutton path="typeOfPrinthead" value="DX6"/>DX6</li>
						<li><form:radiobutton path="typeOfPrinthead" value="DX7"/>DX7</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Совместимые чернила</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="compatibleInk" value="Водные"></form:checkbox>&nbsp;Водные</li>
						<li><form:checkbox path="compatibleInk" value="Пигментные"></form:checkbox>&nbsp;Пигментные</li>
						<li><form:checkbox path="compatibleInk" value="Сублимационные"></form:checkbox>&nbsp;Сублимационные</li>
						<li><form:checkbox path="compatibleInk" value="Экосольвентные"></form:checkbox>&nbsp;Экосольвентные</li>
						<li><form:checkbox path="compatibleInk" value="Сольвентные"></form:checkbox>&nbsp;Сольвентные</li>
						<li><form:checkbox path="compatibleInk" value="UV-чернила"></form:checkbox>&nbsp;UV-чернила</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Тип капли</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="typeDrops" value="Постоянная"></form:checkbox>&nbsp;Постоянная</li>
						<li><form:checkbox path="typeDrops" value="Переменная"></form:checkbox>&nbsp;Переменная</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Размер капли</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="sizeDrops" value="1,5"></form:checkbox>&nbsp;1,5</li>
						<li><form:checkbox path="sizeDrops" value="2"></form:checkbox>&nbsp;2</li>
						<li><form:checkbox path="sizeDrops" value="4"></form:checkbox>&nbsp;4</li>
						<li><form:checkbox path="sizeDrops" value="8"></form:checkbox>&nbsp;8</li>
						<li><form:checkbox path="sizeDrops" value="12"></form:checkbox>&nbsp;12</li>
						<li><form:checkbox path="sizeDrops" value="15"></form:checkbox>&nbsp;15</li>
						<li><form:checkbox path="sizeDrops" value="20"></form:checkbox>&nbsp;20</li>
						<li><form:checkbox path="sizeDrops" value="30"></form:checkbox>&nbsp;30</li>
						<li><form:checkbox path="sizeDrops" value="35"></form:checkbox>&nbsp;35</li>
						<li><form:checkbox path="sizeDrops" value="40"></form:checkbox>&nbsp;40</li>
						<li><form:checkbox path="sizeDrops" value="80"></form:checkbox>&nbsp;80</li>
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
							<input type="text" name="speedPrint" class="amount-speed-print">
							<p>&nbsp;м.кв./ч.</p>
						</div>

						<div class="slider">
							<div class="slider-range-speed-print"></div>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Разрешение печати</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="printResolution" value="360dpi"></form:checkbox>&nbsp;360dpi</li>
						<li><form:checkbox path="printResolution" value="600dpi"></form:checkbox>&nbsp;600dpi</li>
						<li><form:checkbox path="printResolution" value="720dpi"></form:checkbox>&nbsp;720dpi</li>
						<li><form:checkbox path="printResolution" value="1200dpi"></form:checkbox>&nbsp;1200dpi</li>
						<li><form:checkbox path="printResolution" value="1440dpi"></form:checkbox>&nbsp;1440dpi</li>
						<li><form:checkbox path="printResolution" value="2880dpi"></form:checkbox>&nbsp;2880dpi</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">
						<li><form:radiobutton path="equipmentManufacturer" value="Mimaki"/>Mimaki</li>
						<li><form:radiobutton path="equipmentManufacturer" value="Roland"/>Roland</li>
						<li><form:radiobutton path="equipmentManufacturer" value="HP"/>HP</li>
						<li><form:radiobutton path="equipmentManufacturer" value="OCE"/>OCE</li>
						<li><form:radiobutton path="equipmentManufacturer" value="Agfa"/>Agfa</li>
						<li><form:radiobutton path="equipmentManufacturer" value="LIYU"/>LIYU</li>
						<li><form:radiobutton path="equipmentManufacturer" value="Infinity"/>Infinity</li>
						<li><form:radiobutton path="equipmentManufacturer" value="Gonzeng"/>Gonzeng</li>
						<li><form:radiobutton path="equipmentManufacturer" value="Jong Ye"/>Jong Ye</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="interfaceConnection" value="SCSI"></form:checkbox>&nbsp;SCSI</li>
						<li><form:checkbox path="interfaceConnection" value="PCI Adapter"></form:checkbox>&nbsp;PCI Adapter</li>
						<li><form:checkbox path="interfaceConnection" value="USB"></form:checkbox>&nbsp;USB</li>
						<li><form:checkbox path="interfaceConnection" value="Fire-Wire"></form:checkbox>&nbsp;Fire-Wire</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная толщина носителя</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" name="maximumMediaThickness" class="amount-maximum_media_thickness">
							<p>&nbsp;мм</p>
						</div>
						<div class="slider">
							<div class="slider-range-maximum_media_thickness"></div>
						</div>
						<br>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальный вес носителя</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" name="maximumWeightOfVehicle" class="amount-maximum_weight_of_vehicle">
							<p>&nbsp;кг</p>
						</div>
						<div class="slider">
							<div class="slider-range-maximum_weight_of_vehicle"></div>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>П/О RIP</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="rip" value="ONYX Graphics"></form:checkbox>&nbsp;ONYX Graphics</li>
						<li><form:checkbox path="rip" value="SA International/PhotoPRINT™ Family"></form:checkbox>&nbsp;SA International/PhotoPRINT™ Family</li>
						<li><form:checkbox path="rip" value="Wasatch SOFTRIP"></form:checkbox>&nbsp;Wasatch SOFTRIP</li>
						<li><form:checkbox path="rip" value="ColorGATE Productionserver"></form:checkbox>&nbsp;ColorGATE Productionserver</li>
						<li><form:checkbox path="rip" value="Poster Print"></form:checkbox>&nbsp;Poster Print</li>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Максимальная потребляемая мощность</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" name="maxPowerConsumption" class="amount-max_power_consumption">
							<p>&nbsp;кВт</p>
						</div>
						<div class="slider">
							<div class="slider-range-max_power_consumption"></div>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Вес</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" name="weight" class="amount-weight">
							<p>&nbsp;кг</p>
						</div>
						<div class="slider">
							<div class="slider-range-weight"></div>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Ширина</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" name="width" class="amount-width">
							<p>&nbsp;м</p>
						</div>
						<div class="slider">
							<div class="slider-range-width"></div>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Высота</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" name="heigth" class="amount-heigth">
							<p>&nbsp;м</p>
						</div>
						<div class="slider">
							<div class="slider-range-heigth"></div>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Глубина</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" name="depth" class="amount-depth">
							<p>&nbsp;м</p>
						</div>
						<div class="slider">
							<div class="slider-range-depth"></div>
						</div>
					</ul>
				</div>
				<div class="characteristic">
					<div class="block_title">
						<i></i>
						<p>Описание</p>
					</div>
					<ul class="check_boxes">
						<textarea rows="4" cols="29" name="description"></textarea>
					</ul>
				</div>
			</div>
			
			<input type="submit" value="загрузить" />
		</form:form>
	</div>
<script>
(function() {
	var filesUpload = document.getElementById("files-upload"), dropArea = document
			.getElementById("drop-area"), fileList = document
			.getElementById("file-list");

	function uploadFile(file) {
		var li = document.createElement("li"), div = document
				.createElement("div"), img, progressBarContainer = document
				.createElement("div"), progressBar = document
				.createElement("div"), reader, xhr, fileInfo;

		li.appendChild(div);

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

		// Uploading - for Firefox, Google Chrome and Safari
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
		}, false);

		xhr.open("post", "/nk/printer/upload_pictures", true);

		// Set appropriate headers
		xhr.setRequestHeader("Content-Type", "multipart/form-data");
		xhr.setRequestHeader("file_name", file.name);
		xhr.setRequestHeader("file_size", file.size);
		xhr.setRequestHeader("file_type", file.type);

		// Send the file (doh)
		xhr.send(file);

		// Present file info and append it to the list of files
		fileInfo = "<div><strong>Name:</strong> " + file.name
				+ "</div>";
		fileInfo += "<div><strong>Size:</strong> "
				+ parseInt(file.size / 1024, 10) + " kb</div>";
		fileInfo += "<div><strong>Type:</strong> " + file.type
				+ "</div>";
		fileInfo += "<p class=\"delete_img\">Delete this</p>";
		div.innerHTML = fileInfo;

		fileList.appendChild(li);
	}

	function traverseFiles(files) {
		if (typeof files !== "undefined") {
			for (var i = 0, l = files.length; i < l; i++) {
				uploadFile(files[i]);
			}
		} else {
			fileList.innerHTML = "No support for the File API in this web browser";
		}
	}

	filesUpload.addEventListener("change", function() {
		traverseFiles(this.files);
	}, false);

	dropArea.addEventListener("dragleave", function(evt) {
		var target = evt.target;

		if (target && target === dropArea) {
			this.className = "";
		}
		evt.preventDefault();
		evt.stopPropagation();
	}, false);

	dropArea.addEventListener("dragenter", function(evt) {
		this.className = "over";
		evt.preventDefault();
		evt.stopPropagation();
	}, false);

	dropArea.addEventListener("dragover", function(evt) {
		evt.preventDefault();
		evt.stopPropagation();
	}, false);

	dropArea.addEventListener("drop", function(evt) {
		traverseFiles(evt.dataTransfer.files);
		this.className = "";
		evt.preventDefault();
		evt.stopPropagation();
	}, false);
})();

jQuery(document).on('click', '.delete_img', function(){
	  jQuery(this).closest('li').remove();
	});
</script>
</body>
</html>