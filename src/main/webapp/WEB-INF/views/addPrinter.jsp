<%@ page contentType="text/html; charset=UTF-8"%>
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
		<form method="POST" action="/maven-web/product"
			enctype="multipart/form-data">

			<div id="pictures">

				<p id="add_new_photo">Добавить фотографию</p>
				<p>Выберете файл для загрузки:</p>
				<div class="load_photos">
					<div><input type="file" name="file" value="Выбрать фотографию" /><p>&times;</p></div>
				</div>



				<!-- <div class="image_container"></div> -->
			</div>

			<div id="search_printer">
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Название принтера</p>
					</div>
					<div class="check_boxes">
						<input type="text" name="name" />
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Партийный номер принтера</p>
					</div>
					<div class="check_boxes">
						<input type="text" name="partNumber" />
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Модель</p>
					</div>
					<div class="check_boxes">
						<input type="text" name="model" />
					</div>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Ширина печати</p>
					</div>
					<ul class="check_boxes">
						<div id="tabs">
							<ul>
								<li>миллиметр</li>
								<li>дюйм</li>
								<li>формат</li>
							</ul>
							<div>
								<div>
									<li><input type="checkbox" name="radio_weight_print_sm"
										checked>600</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">900</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">1070</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">1300</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">1600</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">1800</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">2500</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">2600</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">32000</input></li>
									<li><input type="checkbox" name="radio_weight_print_sm">50000</input></li>
								</div>
								<div>
									<li><input type="checkbox" name="radio_weight_print_inch"
										checked>24</input></li>
									<li><input type="checkbox" name="radio_weight_print_inch">36</input></li>
									<li><input type="checkbox" name="radio_weight_print_inch">42</input></li>
									<li><input type="checkbox" name="radio_weight_print_inch">60</input></li>
									<li><input type="checkbox" name="radio_weight_print_inch">70</input></li>
									<li><input type="checkbox" name="radio_weight_print_inch">100</input></li>
								</div>
								<div>
									<li><input type="checkbox"
										name="radio_weight_print_format" checked>A0</input></li>
									<li><input type="checkbox"
										name="radio_weight_print_format">A1</input></li>
									<li><input type="checkbox"
										name="radio_weight_print_format">A2</input></li>
									<li><input type="checkbox"
										name="radio_weight_print_format">A3</input></li>
									<li><input type="checkbox"
										name="radio_weight_print_format">A3+</input></li>
									<li><input type="checkbox"
										name="radio_weight_print_format">B0</input></li>
									<li><input type="checkbox"
										name="radio_weight_print_format">B1</input></li>
								</div>
							</div>
						</div>
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
							<input type="text" class="amount-prise">
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
						<li><input type="checkbox"
							name="checkbox_former_use_equipment">новое</input></li>
						<li><input type="checkbox"
							name="checkbox_former_use_equipment">Б/У</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип печати</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox" name="checkbox_type_print">Термо-струйная</input></li>
						<li><input type="checkbox" name="checkbox_type_print">Пьезо-струйная</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Подача метериала</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox" name="checkbox_feed">Рулонный</input></li>
						<li><input type="checkbox" name="checkbox_feed">Плоскопечатный</input></li>
						<li><input type="checkbox" name="checkbox_feed">Гибридный</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Цветность</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox" name="checkbox_chromaticity">CMYK</input></li>
						<li><input type="checkbox" name="checkbox_chromaticity">CMYK
							X 2</input></li>
						<li><input type="checkbox" name="checkbox_chromaticity">CMYKLcLm</input></li>
						<li><input type="checkbox" name="checkbox_chromaticity">CMYKLcLmOG</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox"
							name="checkbox_manufacturer_printhead">Spectra</input></li>
						<li><input type="checkbox"
							name="checkbox_manufacturer_printhead">XAAR</input></li>
						<li><input type="checkbox"
							name="checkbox_manufacturer_printhead">SPT</input></li>
						<li><input type="checkbox"
							name="checkbox_manufacturer_printhead">Konika-Minolta</input></li>
						<li><input type="checkbox"
							name="checkbox_manufacturer_printhead">Toshiba</input></li>
						<li><input type="checkbox"
							name="checkbox_manufacturer_printhead">Ricoh</input></li>
						<li><input type="checkbox"
							name="checkbox_manufacturer_printhead">Epson</input></li>
						<li><input type="checkbox"
							name="checkbox_manufacturer_printhead">Lexmark</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип печатающей головки</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox" name="checkbox_type_printhead">Nova
							256</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">Galaxy
							256</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">Polyaris
							512</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">126/50</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">126/80</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">128/40</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">128/80</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">255</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">256</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">500</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">510</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">512</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">512KN</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">1020</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">1024</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">1024I</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">CA3</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">CA4</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">Gen4</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">Gen5</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">DX2</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">DX4</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">DX5</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">DX6</input></li>
						<li><input type="checkbox" name="checkbox_type_printhead">DX7</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Совместимые чернила</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox" name="checkbox_compatible_ink">Водные</input></li>
						<li><input type="checkbox" name="checkbox_compatible_ink">Пигментные</input></li>
						<li><input type="checkbox" name="checkbox_compatible_ink">Сублимационные
							</input></li>
						<li><input type="checkbox" name="checkbox_compatible_ink">Экосольвентные</input></li>
						<li><input type="checkbox" name="checkbox_compatible_ink">Сольвентные</input></li>
						<li><input type="checkbox" name="checkbox_compatible_ink">UV-чернила</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Тип капли</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox" name="checkbox_type_drops">Постоянная</input></li>
						<li><input type="checkbox" name="checkbox_type_drops">Переменная</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Размер капли</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox" name="checkbox_size_drops">1,5</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">2</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">4</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">8</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">12</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">15</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">20</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">30</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">35</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">40</input></li>
						<li><input type="checkbox" name="checkbox_size_drops">80</input></li>
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
							<input type="text" class="amount-speed-print">
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
						<li><input type="checkbox" name="checkbox_print_resolution">360dpi</input></li>
						<li><input type="checkbox" name="checkbox_print_resolution">600dpi</input></li>
						<li><input type="checkbox" name="checkbox_print_resolution">720dpi</input></li>
						<li><input type="checkbox" name="checkbox_print_resolution">1200dpi</input></li>
						<li><input type="checkbox" name="checkbox_print_resolution">1440dpi</input></li>
						<li><input type="checkbox" name="checkbox_print_resolution">2880dpi</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Производитель оборудования</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">Mimaki</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">Roland</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">Mutoh</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">HP</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">OCE</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">Agfa</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">LIYU</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">Infinity</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">Gonzeng</input></li>
						<li><input type="checkbox"
							name="checkbox_equipment_manufacturer">Jong Ye</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Интерфейс подключения</p>
					</div>
					<ul class="check_boxes">
						<li><input type="checkbox"
							name="checkbox_interface_connection">SCSI</input></li>
						<li><input type="checkbox"
							name="checkbox_interface_connection">PCI Adapter</input></li>
						<li><input type="checkbox"
							name="checkbox_interface_connection">USB</input></li>
						<li><input type="checkbox"
							name="checkbox_interface_connection">Fire-Wire</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Максимальная толщина носителя</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" class="amount-maximum_media_thickness">
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
							<input type="text" class="amount-maximum_weight_of_vehicle">
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
						<li><input type="checkbox" name="checkbox_RIP">ONYX
							Graphics</input></li>
						<li><input type="checkbox" name="checkbox_RIP">SA
							International/PhotoPRINT™ Family</input></li>
						<li><input type="checkbox" name="checkbox_RIP">Wasatch SOFTRIP</input></li>
						<li><input type="checkbox" name="checkbox_RIP">ColorGATE
							Productionserver</input></li>
						<li><input type="checkbox" name="checkbox_RIP">Poster
							Print</input></li>
					</ul>
				</div>
				<div class="search_criteria">
					<div class="block_title">
						<i></i>
						<p>Максимальная потребляемая мощность</p>
					</div>
					<ul class="check_boxes">
						<div class="text_output">
							<input type="text" class="amount-max_power_consumption">
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
							<input type="text" class="amount-weight">
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
							<input type="text" class="amount-width">
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
							<input type="text" class="amount-heigth">
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
							<input type="text" class="amount-depth">
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
		</form>
	</div>

</body>
</html>