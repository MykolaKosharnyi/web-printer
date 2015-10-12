<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/style_admin.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">
    
    <script src="<%=request.getContextPath()%>/resources/js/jquery-2.1.4.min.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
    <script src="<%=request.getContextPath()%>/resources/js/addPrinter.js"></script>
    
	<title>Adding new printer</title>
</head>
<body>
	<div id="head_of_page">Добавление нового принтера</div>

	<div id="product">
		<form:form method="POST" commandName="printer" action="/maven-web/product" enctype="multipart/form-data">
 			<div id="pictures">
 				File to upload: <input type="file" name="file"><br /> 
        		Name: <input type="text" name="namePicture"><br /> <br />
			<!-- 	<input type="file" id="files" name="files[]" multiple />
				<output id="list"></output>-->
			</div>
		<!-- 			 
		<form method="POST" action="/maven-web/product"
			enctype="multipart/form-data">

			<div id="pictures">

				<p id="add_new_photo">Добавить фотографию</p>
				<p>Выберете файл для загрузки:</p>
				<div class="load_photos">
					<div><input type="file" name="file" value="Выбрать фотографию" /><p>&times;</p></div>
				</div>

				 <div class="image_container"></div> 
			</div>-->
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
          span.innerHTML = ['<img class="thumb" src="', e.target.result,
                            '" title="', escape(theFile.name), '"/>'].join('');
          document.getElementById('list').insertBefore(span, null);
        };
      })(f);

      // Read in the image file as a data URL.
      reader.readAsDataURL(f);
    }
  }

  document.getElementById('files').addEventListener('change', handleFileSelect, false);
</script>

			<div id="search_printer">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Название принтера</p>
					</div>
					<div class="check_boxes">
						<form:input path="name" />
						<form:errors path="name" cssclass="error"></form:errors>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Партийный номер принтера</p>
					</div>
					<div class="check_boxes">
						<form:input path="partNumber" />
						<form:errors path="partNumber" cssclass="error"></form:errors>
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Модель</p>
					</div>
					<div class="check_boxes">
						<form:input path="equipmentModel" />
						<form:errors path="equipmentModel" cssclass="error"></form:errors>
					</div>
				</div>
				<div class="search_criteria">
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
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Цена</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<p>$</p>
							<input type="text" name="prise" class="amount-prise">
						</div>
						<div class="slider">
							<div class="slider-range-prise"></div>
						</div>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Б/У оборудование</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="previouslyUsed"></form:checkbox>&nbsp;Бывшего употребления</li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип печати</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="typePrint" value="Термо-струйная"></form:checkbox>&nbsp;Термо-струйная</li>
						<li><form:checkbox path="typePrint" value="Пьезо-струйная"></form:checkbox>&nbsp;Пьезо-струйная</li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Подача метериала</p>
					</div>
					<ul class="check_boxes">
						<form:checkboxes items="${feeds}" path="feed" />
					</ul>
				</div>
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип капли</p>
					</div>
					<ul class="check_boxes">
						<li><form:checkbox path="typeDrops" value="Постоянная"></form:checkbox>&nbsp;Постоянная</li>
						<li><form:checkbox path="typeDrops" value="Переменная"></form:checkbox>&nbsp;Переменная</li>
					</ul>
				</div>
				<div class="search_criteria">
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

			<div id="search_printer">
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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
				<div class="search_criteria">
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

</body>
</html>