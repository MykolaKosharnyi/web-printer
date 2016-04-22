<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/printer.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					ПРИМЕНИТЬ
					<!--<img src="/images/Accept.gif" alt="" />-->
				</a>
				<a class="reset" href="<c:url value='/printers' />">
					СБРОСИТЬ
					<!--<img src="/images/Reset.gif" alt="" />-->
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/printers/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
		<div class="search_criteria">
			<div class="block_title">
				<i class="opened"></i>
				<p>Цена</p>
			</div>
			<ul class="check_boxes" style="display: block;">
				<div class="text_output">
					<p>$</p>
					<form:input path="prise0" class="amount-prise0" value="${search.prise0}" />
					<p>&nbsp;-&nbsp; $</p>
					<form:input path="prise1" class="amount-prise1" value="${search.prise1}" />
				</div>
				<div class="slider-range-prise"/>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип принтера</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typePrinter}" path="typePrinter" element="li" />
			</ul>
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
							<form:checkboxes items="${weightPrintMM}" path="weightPrintMM" element="li" />
						</div>
					    <div>
							<li><input type="checkbox" name="weightPrintMM" value="305" id="weightPrintMM_12"><label for="weightPrintMM_12">12"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="457" id="weightPrintMM_18"><label for="weightPrintMM_18">18"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="610" id="weightPrintMM_24"><label for="weightPrintMM_24">24"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="914" id="weightPrintMM_36"><label for="weightPrintMM_36">36"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1070" id="weightPrintMM_42"><label for="weightPrintMM_42">42"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1524" id="weightPrintMM_60"><label for="weightPrintMM_60">60"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1550" id="weightPrintMM_61"><label for="weightPrintMM_61">61"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1600" id="weightPrintMM_63"><label for="weightPrintMM_63">63"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1800" id="weightPrintMM_71"><label for="weightPrintMM_71">71"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="1900" id="weightPrintMM_75"><label for="weightPrintMM_75">75"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="2500" id="weightPrintMM_98"><label for="weightPrintMM_98">98"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="2540" id="weightPrintMM_100"><label for="weightPrintMM_100">100"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="2600" id="weightPrintMM_102"><label for="weightPrintMM_102">102"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="3200" id="weightPrintMM_126"><label for="weightPrintMM_126">126"</label></input></li>
							<li><input type="checkbox" name="weightPrintMM" value="3300" id="weightPrintMM_130"><label for="weightPrintMM_130">130"</label></input></li>
						</div>
						<!--<div>
							<li><input type="checkbox" name="weightPrintMM">A0</input></li>
							<li><input type="checkbox" name="weightPrintMM">A1</input></li>
							<li><input type="checkbox" name="weightPrintMM">A2</input></li>
							<li><input type="checkbox" name="weightPrintMM">A3</input></li>
							<li><input type="checkbox" name="weightPrintMM">A3+</input></li>
							<li><input type="checkbox" name="weightPrintMM">B0</input></li>
							<li><input type="checkbox" name="weightPrintMM">B1</input></li>
						</div> 
						  -->
					</div>
				</div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Б/У оборудование</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${previouslyUsed}" path="previouslyUsed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typePrint}" path="typePrint" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Подача метериала</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${feeds}" path="feed" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Цветность</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${chromaticity}" path="chromaticity" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель печатающей головки</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${manufacturerPrinthead}" path="manufacturerPrinthead" element="li" />
			</ul>
		</div> 

		<div class="block_search_criteria">
			<div class="block_block_title">
				<i></i>
				<p>Тип печатающей головки</p>
			</div>
			<ul class="block_check_boxes">
		
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Dimatix Spectra</p>
			</div>
			<ul class="check_boxes">
				<li><input type="checkbox" name="typeOfPrinthead" value="Spectra Nova 256" id="typeOfPrinthead_1"><label for="typeOfPrinthead_1">Spectra Nova 256</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Spectra Galaxy 256" id="typeOfPrinthead_2"><label for="typeOfPrinthead_2">Spectra Galaxy 256</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Spectra Polyaris 512" id="typeOfPrinthead_3"><label for="typeOfPrinthead_3">Spectra Polyaris 512</label></input></li>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>XAAR</p>
			</div>
			<ul class="check_boxes">
				<li><input type="checkbox" name="typeOfPrinthead" value="XAAR 126/50" id="typeOfPrinthead_4"><label for="typeOfPrinthead_4">XAAR 126/50</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="XAAR 126/80" id="typeOfPrinthead_5"><label for="typeOfPrinthead_5">XAAR 126/80</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="XAAR 128/40" id="typeOfPrinthead_6"><label for="typeOfPrinthead_6">XAAR 128/40</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="XAAR 128/80" id="typeOfPrinthead_7"><label for="typeOfPrinthead_7">XAAR 128/80</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="XAAR 500" id="typeOfPrinthead_8"><label for="typeOfPrinthead_8">XAAR 500</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="XAAR 318 CA4W" id="typeOfPrinthead_9"><label for="typeOfPrinthead_9">XAAR 318 CA4W</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="XAAR Proton 382/35" id="typeOfPrinthead_10"><label for="typeOfPrinthead_10">XAAR Proton 382/35</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="XAAR Proton 382/60" id="typeOfPrinthead_11"><label for="typeOfPrinthead_11">XAAR Proton 382/60</label></input></li>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Seiko SPT</p>
			</div>
			<ul class="check_boxes">
				<li><input type="checkbox" name="typeOfPrinthead" value="SPT 255" id="typeOfPrinthead_12"><label for="typeOfPrinthead_12">SPT 255</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="SPT 508 GS" id="typeOfPrinthead_13"><label for="typeOfPrinthead_13">SPT 508 GS</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="SPT 510" id="typeOfPrinthead_14"><label for="typeOfPrinthead_14">SPT 510</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="SPT 1020" id="typeOfPrinthead_15"><label for="typeOfPrinthead_15">SPT 1020</label></input></li>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Konica Minolta</p>
			</div>
			<ul class="check_boxes">
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 256" id="typeOfPrinthead_16"><label for="typeOfPrinthead_16">KM 256</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 256 LN" id="typeOfPrinthead_17"><label for="typeOfPrinthead_17">KM 256 LN</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 256 MN" id="typeOfPrinthead_18"><label for="typeOfPrinthead_18">KM 256 MN</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 512" id="typeOfPrinthead_19"><label for="typeOfPrinthead_19">KM 512</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 512 LN" id="typeOfPrinthead_20"><label for="typeOfPrinthead_20">KM 512 LN</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 512 LNX" id="typeOfPrinthead_21"><label for="typeOfPrinthead_21">KM 512 LNX</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 512 MN" id="typeOfPrinthead_22"><label  for="typeOfPrinthead_22">KM 512 MN</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 512 MH" id="typeOfPrinthead_23"><label for="typeOfPrinthead_23">KM 512 MH</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 512 LH" id="typeOfPrinthead_24"><label for="typeOfPrinthead_24">KM 512 LH</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 1024" id="typeOfPrinthead_25"><label for="typeOfPrinthead_25">KM 1024</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 1024 LH" id="typeOfPrinthead_26"><label for="typeOfPrinthead_26">KM 1024 LH</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 1024 LN" id="typeOfPrinthead_27"><label for="typeOfPrinthead_27">KM 1024 LN</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 1024 MB" id="typeOfPrinthead_28"><label for="typeOfPrinthead_28">KM 1024 MB</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 1024 MN" id="typeOfPrinthead_29"><label for="typeOfPrinthead_29">KM 1024 MN</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 1024 SHB" id="typeOfPrinthead_30"><label for="typeOfPrinthead_30">KM 1024 SHB</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 1024i" id="typeOfPrinthead_31"><label for="typeOfPrinthead_31">KM 1024i</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="KM 1024i MHE" id="typeOfPrinthead_32"><label for="typeOfPrinthead_32">KM 1024i MHE</label></input></li>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Toshiba</p>
			</div>
			<ul class="check_boxes">
				<li><input type="checkbox" name="typeOfPrinthead" value="CA3W" id="typeOfPrinthead_33"><label for="typeOfPrinthead_33">CA3W</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="CA4W" id="typeOfPrinthead_34"><label for="typeOfPrinthead_34">CA4W</label></input></li>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>RICOH</p>
			</div>
			<ul class="check_boxes">
				<li><input type="checkbox" name="typeOfPrinthead" value="Gen4" id="typeOfPrinthead_35"><label for="typeOfPrinthead_35">Gen4</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Gen5" id="typeOfPrinthead_36"><label for="typeOfPrinthead_36">Gen5</label></input></li>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Epson</p>
			</div>
			<ul class="check_boxes">
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson DX2 Series" id="typeOfPrinthead_37"><label for="typeOfPrinthead_37">Epson DX2 Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson DX4 Series" id="typeOfPrinthead_38"><label for="typeOfPrinthead_38">Epson DX4 Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson DX5 Series" id="typeOfPrinthead_39"><label for="typeOfPrinthead_39">Epson DX5 Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson DX6 Series" id="typeOfPrinthead_40"><label for="typeOfPrinthead_40">Epson DX6 Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson DX7 Series" id="typeOfPrinthead_41"><label for="typeOfPrinthead_41">Epson DX7 Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson DX8 Series" id="typeOfPrinthead_42"><label for="typeOfPrinthead_42">Epson DX8 Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson DX9 Series" id="typeOfPrinthead_43"><label for="typeOfPrinthead_43">Epson DX9 Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson DX10 Series" id="typeOfPrinthead_44"><label for="typeOfPrinthead_44">Epson DX10 Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson Sure Color Series" id="typeOfPrinthead_45"><label for="typeOfPrinthead_45">Epson Sure Color Series</label></input></li>
				<li><input type="checkbox" name="typeOfPrinthead" value="Epson Stylus Series" id="typeOfPrinthead_46"><label for="typeOfPrinthead_46">Epson Stylus Series</label></input></li>
			</ul>
		</div>
			</ul>
		</div>
	
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Совместимые чернила</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${compatibleInk}" path="compatibleInk" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип капли</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${typeDrops}" path="typeDrops" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Размер капли</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${sizeDrops}" path="sizeDrops" element="li" />
				<div class="text_output">
					<form:input path="sizeDropRangeFrom" class="amount-sizeDropRangeFrom" value="${search.sizeDropRangeFrom}" />
					<p>&nbsp;pl -&nbsp;</p>
					<form:input path="sizeDropRangeUntil" class="amount-sizeDropRangeUntil" value="${search.sizeDropRangeUntil}" />
					<p>&nbsp;pl</p>
				</div>
					<div class="slider-range-size-drop"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Скорость печати</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="speedPrint0" class="amount-speed-print0" value="${search.speedPrint0}" />
					<p>&nbsp;м.кв./ч. -&nbsp;</p>
					<form:input path="speedPrint1" class="amount-speed-print1" value="${search.speedPrint1}" />
					<p>&nbsp;м.кв./ч.</p>
				</div>
					<div class="slider-range-speed-print"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Разрешение печати</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${printResolution}" path="printResolution"
					element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Производитель оборудования</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${equipmentManufacturer}" path="equipmentManufacturer" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Интерфейс подключения</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${interfaceConnection}"
					path="interfaceConnection" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная толщина носителя</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maximumMediaThickness60_0" class="amount-maximum_media_thickness60_0" value="${search.maximumMediaThickness60_0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="maximumMediaThickness60_1" class="amount-maximum_media_thickness60_1" value="${search.maximumMediaThickness60_1}" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider-range-maximum_media_thickness60"></div>
				<br>
				<div class="text_output">
					<form:input path="maximumMediaThickness500_0" class="amount-maximum_media_thickness500_0" value="${search.maximumMediaThickness500_0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="maximumMediaThickness500_1" class="amount-maximum_media_thickness500_1" value="${search.maximumMediaThickness500_1}" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider-range-maximum_media_thickness500"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальный вес носителя</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maximumWeightOfVehicle0" class="amount-maximum_weight_of_vehicle0" value="${search.maximumWeightOfVehicle0}" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="maximumWeightOfVehicle1" class="amount-maximum_weight_of_vehicle1" value="${search.maximumWeightOfVehicle1}" />
					<p>&nbsp;кг</p>
				</div>
					<div class="slider-range-maximum_weight_of_vehicle"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>П/О RIP</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${rip}" path="rip" element="li" />
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Средняя потребляемая мощность</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="averagePowerConsumption0" class="amount-averagePowerConsumption0" value="${search.averagePowerConsumption0}" />
					<p>&nbsp;Вт -&nbsp;</p>
					<form:input path="averagePowerConsumption1" class="amount-averagePowerConsumption1" value="${search.averagePowerConsumption1}" />
					<p>&nbsp;Вт</p>
				</div>
					<div class="slider-range-averagePowerConsumption"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Максимальная потребляемая мощность</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="maxPowerConsumption0" class="amount-max_power_consumption0" value="${search.maxPowerConsumption0}" />
					<p>&nbsp;Вт -&nbsp;</p>
					<form:input path="maxPowerConsumption1" class="amount-max_power_consumption1" value="${search.maxPowerConsumption1}" />
					<p>&nbsp;Вт</p>
				</div>
					<div class="slider-range-max_power_consumption"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Вес</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="weight0" class="amount-weight0" value="${search.weight0}" />
					<p>&nbsp;кг -&nbsp;</p>
					<form:input path="weight1" class="amount-weight1" value="${search.weight1}" />
					<p>&nbsp;кг</p>
				</div>
					<div class="slider-range-weight"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Ширина</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="width0" class="amount-width0" value="${search.width0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="width1" class="amount-width1" value="${search.width1}" />
					<p>&nbsp;мм</p>
				</div>
				<div class="slider-range-width"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Высота</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="heigth0" class="amount-heigth0" value="${search.heigth0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="heigth1" class="amount-heigth1" value="${search.heigth1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-heigth"></div>
			</ul>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Глубина</p>
			</div>
			<ul class="check_boxes">
				<div class="text_output">
					<form:input path="depth0" class="amount-depth0" value="${search.depth0}" />
					<p>&nbsp;мм -&nbsp;</p>
					<form:input path="depth1" class="amount-depth1" value="${search.depth1}" />
					<p>&nbsp;мм</p>
				</div>
					<div class="slider-range-depth"></div>
			</ul>
		</div>
			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				ПРИМЕНИТЬ
				<!--<img src="/images/Accept.gif" alt="" />-->
			</a>
			<a class="reset" href="<c:url value='/printers' />">
				СБРОСИТЬ
				<!--<img src="/images/Reset.gif" alt="" />-->
			</a>
		</form:form>
	</div>