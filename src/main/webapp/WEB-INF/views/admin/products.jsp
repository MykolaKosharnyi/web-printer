<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page session="true"%>
<html lang="ru">
<head>
	<title>${title}</title>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
	<div id="product">
	<a href="<c:url value='/admin/${productType}/new' />">${addProduct}</a>
	<br>
	<h3>${titleOfTable}</h3>
	
	<c:if test="${productType == 'printer'}">
		<a href="<c:url value='/admin/${productType}/properties/equipment_manufacturer' />">Добавление/Изменение производителей принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/rip' />">Добавление/Изменение программного обеспечения для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/manufacturer_printhead' />">Добавление/Изменение производителя печатающей головки для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/printing_extension' />">Добавление/Изменение расширения печати для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/weight_print_mm' />">Добавление/Изменение ширины печати для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/chromaticity' />">Добавление/Изменение цветовой схемы для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/size_drops' />">Добавление/Изменение размера капли для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/resolution' />">Добавление/Изменение разрешения в скорости печати для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/interface_connection' />">Добавление/Изменение интерфейса подключения для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/print_resolution' />">Добавление/Изменение разрешения печати для принтеров</a><br>
		<br>
		<a href="<c:url value='/admin/${productType}/properties_i/compatible_ink' />">Добавление/Изменение совместимых чернил для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/feeds' />">Добавление/Изменение подачи метериала для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_drops' />">Добавление/Изменение типа капли для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/previously_used' />">Добавление/Изменение состояния оборудования для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_printer' />">Добавление/Изменение типа принтеров для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_print' />">Добавление/Изменение типа печати для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/delivery' />">Добавление/Изменение доставки для принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/availability' />">Добавление/Изменение наличия для принтеров</a><br>
	
	</c:if>
	
	<c:if test="${productType == '3d_printer'}">
		
		<a href="<c:url value='/admin/${productType}/properties/print_technology' />">Добавление/Изменение технологии печати 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/equipment_manufacturer' />">Добавление/Изменение производителя оборудования 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/interface_connection' />">Добавление/Изменение интерфейсов подключения 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/types_of_files' />">Добавление/Изменение типов файлов 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/rip' />">Добавление/Изменение программного обеспечения 3Д принтеров</a><br>		
		<a href="<c:url value='/admin/${productType}/properties/extruder_number' />">Добавление/Изменение колличество экструдеров 3Д принтеров</a><br>		
		<br>		
		<a href="<c:url value='/admin/${productType}/properties_i/type_printer_3d' />">Добавление/Изменение типов 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/previously_used' />">Добавление/Изменение состояния оборудования для 3D принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/chromaticity' />">Добавление/Изменение цветовой схемы 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_of_printhead' />">Добавление/Изменение типа печатающей головки 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/media' />">Добавление/Изменение материала для печати 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_extruder' />">Добавление/Изменение типа экструдера 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/airflow_models' />">Добавление/Изменение обдува модели 3Д принтеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/availability' />">Добавление/Изменение наличия для 3D принтеров</a><br>

	</c:if>
	
	<c:if test="${productType == 'digital_printer'}">
		<a href="<c:url value='/admin/${productType}/properties/interfaces' />">Добавление/Изменение интерфейсов подключения для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties/maximum_format' />">Добавление/Изменение максимального формата для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties/scanner_resolution' />">Добавление/Изменение разрешения сканера для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties/maximum_resolution_copier_bw' />">Добавление/Изменение разрешения копира для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties/support' />">Добавление/Изменение поддержки для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties/os_support' />">Добавление/Изменение поддержки ОС для цифрового оборудования</a><br>
		<br>		
		<a href="<c:url value='/admin/${productType}/properties_i/availability' />">Добавление/Изменение наличия для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/previously_used' />">Добавление/Изменение состояния оборудования для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_printer' />">Добавление/Изменение типа цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/device' />">Добавление/Изменение устройств для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_of_printing' />">Добавление/Изменение типа печати для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/print_technology' />">Добавление/Изменение технологии печати для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/accommodation' />">Добавление/Изменение размещения для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/application_area' />">Добавление/Изменение области применения для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/yn' />">Добавление/Изменение есть/нет для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/scanner_type' />">Добавление/Изменение типа сканера для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/printing_on' />">Добавление/Изменение 'печати на' для цифрового оборудования</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/display_information' />">Добавление/Изменение отображения информации для цифрового оборудования</a><br>
	</c:if>
	
	<c:if test="${productType == 'laminator'}">
		<a href="<c:url value='/admin/${productType}/properties/laminating_width' />">Добавление/Изменение ширины ламинирования</a><br>
		<a href="<c:url value='/admin/${productType}/properties/equipment_manufacturer' />">Добавление/Изменение производителя оборудования для ламинаторов</a><br>		
		<br>		
		<a href="<c:url value='/admin/${productType}/properties_i/availability' />">Добавление/Изменение наличия для ламинаторов</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/previously_used' />">Добавление/Изменение состояния оборудования для ламинаторов</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_product' />">Добавление/Изменение типа для ламинаторов</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/innings' />">Добавление/Изменение подачи для ламинаторов</a><br>
	</c:if>
	
	<c:if test="${productType == 'laser'}">
		<a href="<c:url value='/admin/${productType}/properties/equipment_manufacturer' />">Добавление/Изменение производителей для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/connection_interface' />">Добавление/Изменение интерфейса подключения для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/file_types' />">Добавление/Изменение типов файлов для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/software' />">Добавление/Изменение програмного обеспечения для лазеров</a><br>		
		<br>		
		<a href="<c:url value='/admin/${productType}/properties_i/availability' />">Добавление/Изменение наличия для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/previously_used' />">Добавление/Изменение состояния оборудования для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_of_cooling' />">Добавление/Изменение типа охлаждения для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_engine' />">Добавление/Изменение типа двигателей для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_laser' />">Добавление/Изменение типа лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/color_separation' />">Добавление/Изменение цветоделения для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/special_purpose' />">Добавление/Изменение целевое назначение для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_the_displayed_image' />">Добавление/Изменение типа выводимого изображения для лазеров</a><br>
	</c:if>
	
	<c:if test="${productType == 'cutter'}">
		<a href="<c:url value='/admin/${productType}/properties/equipment_manufacturer' />">Добавление/Изменение производителей оборудования для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/connection_interface' />">Добавление/Изменение интерфейсов подключения для лазеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/software' />">Добавление/Изменение програмного обеспечения для лазеров</a><br>
		<br>		
		<a href="<c:url value='/admin/${productType}/properties_i/availability' />">Добавление/Изменение наличия для фрезеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/previously_used' />">Добавление/Изменение состояния оборудования для фрезеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_of_cooling' />">Добавление/Изменение типа охлаждений для фрезеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_cutter' />">Добавление/Изменение типа фрезеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/engraving_style' />">Добавление/Изменение типа гравировки</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_engine' />">Добавление/Изменение типа двигателей</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/mounting_tool' />">Добавление/Изменение креплений инструментов</a><br>
	</c:if>
	
	<c:if test="${productType == 'scanner'}">
		<a href="<c:url value='/admin/${productType}/properties/scanning_width' />">Добавление/Изменение ширины сканирования для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/scanning_element' />">Добавление/Изменение сканирующих елементов для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/optical_resolution' />">Добавление/Изменение оптического разрешения для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/equipment_manufacturer' />">Добавление/Изменение производителей оборудования для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/connection_interface' />">Добавление/Изменение интерфейсов подключения для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties/software' />">Добавление/Изменение програмного обеспечения для сканеров</a><br>
		<br>		
		<a href="<c:url value='/admin/${productType}/properties_i/availability' />">Добавление/Изменение наличия для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/previously_used' />">Добавление/Изменение состояния оборудования для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/type_product' />">Добавление/Изменение типов сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/innings' />">Добавление/Изменение подачи для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/chromaticity' />">Добавление/Изменение цветности для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/light_source' />">Добавление/Изменение источника света для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/bit_color_scanning' />">Добавление/Изменение разрядности цветного сканирования для сканеров</a><br>
		<a href="<c:url value='/admin/${productType}/properties_i/bit_scanning_grayscale' />">Добавление/Изменение разрядности сканирования c оттенком серого для сканеров</a><br>
	</c:if>
	
	<div style="right:0px;position: relative;">
		Сортировка 
		<select id="sorting_parameter">
	    	<option value="id">по id</option>
	    	<option value="name">по имени</option>
	    	<option value="prise">по цене</option>
	    	<option value="top">топ вверх</option>
	    	<c:if test="${productType != 'use_with_product' && productType != 'rip'}">
				<option value="equipmentManufacturer">по производителю</option>
			</c:if>	    	
  		</select>
  	</div>
	<c:if test="${!empty listProducts}">
		<table class="tg" style="
		<c:if test="${productType != 'use_with_product' && productType != 'rip'}">width: 933px;</c:if>	 
				<c:if test="${productType == 'use_with_product' || productType == 'rip'}">width: 822px;</c:if>">
			<tr>
				<th style="min-width: 24px; max-width: 24px;" class="text-center">ID</th>
				<th style="min-width: 128px; max-width: 128px;" class="text-center">Имя принтера</th>
				<c:if test="${productType != 'use_with_product' && productType != 'rip'}">
					<th style="min-width: 100px;max-width: 100px;" class="text-center">Производитель</th>
				</c:if>	 	 
				<th style="min-width: 180px;max-width: 180px;" class="text-center">Изображение</th>
				<th style="min-width: 100px;max-width: 100px;" class="text-center">Цена</th>
				<th style="width: 24px !important;" class="text-center">Топ</th>
				<th style="width: 42px !important;" class="text-center">Показ. на сайте</th>
				<th style="width: 42px !important;" class="text-center">Показ. на гл. меню</th>
				<th style="width: 42px !important;" class="text-center">Показ. в левом блоке</th>
				<th style="width:60px !important;" class="text-center">Копировать товар</th>
				<th style="width: 54px !important;" class="text-center">Удалить</th>
			</tr>
			
			<!-- fixed header -->
			<tr class="fixed_header" style="position: fixed; top: 0px; 
				<c:if test="${productType != 'use_with_product' && productType != 'rip'}">width: 933px;</c:if>	 
				<c:if test="${productType == 'use_with_product' || productType == 'rip'}">width: 822px;</c:if>
			 background-color: white; display: none;margin-left: -1px;">
				<th style="min-width: 24px; max-width: 24px;" class="text-center">ID</th>
				<th style="min-width: 128px;max-width: 128px;" class="text-center">Имя принтера</th>
				<c:if test="${productType != 'use_with_product' && productType != 'rip'}">
					<th style="min-width: 100px;max-width: 100px;" class="text-center">Производитель</th>
				</c:if>	 	 
				<th style="min-width: 180px;max-width: 180px;" class="text-center">Изображение</th>
				<th style="min-width: 100px;max-width: 100px;" class="text-center">Цена</th>
				<th style="width: 24px !important;" class="text-center">Топ</th>
				<th style="width: 42px !important;" class="text-center">Показ. на сайте</th>
				<th style="width: 42px !important;" class="text-center">Показ. на гл. меню</th>
				<th style="width: 42px !important;" class="text-center">Показ. в левом блоке</th>
				<th style="width:60px !important;" class="text-center">Копировать товар</th>
				<th style="width: 53px !important;" class="text-center">Удалить</th>
			</tr>
			
			<c:forEach items="${listProducts}" var="product">
				<tr id="${product.id}" class="output_pruduct">
					<td style="min-width: 24px; max-width: 24px;">${product.id}</td>
					<td style="min-width: 128px;max-width: 128px;"><a href="<c:url value='/admin/${productType}/edit/${product.id}' />">${product.name}</a></td>
					<c:if test="${productType != 'use_with_product' && productType != 'rip'}">
						<td style="min-width: 100px;max-width: 100px;">${product.equipmentManufacturer}</td>
					</c:if>	
					<td style="min-width: 180px;max-width: 180px;">
						<a style="min-width: 180px;max-width: 180px;" href="<c:url value='/admin/${productType}/edit/${product.id}' />">
							<img style="min-width: 180px;max-width: 180px;" src="/images/${productType}s/${product.id}/${product.pathPictures.get(0)}" alt="">
						</a>
					</td>
					<td style="min-width: 100px;max-width: 100px;">
						<c:if test="${product.prise > 0}">
							$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
						</c:if>				
	           		</td>
	           		
	           		<td style="width: 24px !important;">
	           			<input type="checkbox" name="top" <c:if test="${product.top}">checked</c:if> 
						onclick="setTop('${productType}', ${product.id}, this);"/>
					</td>
	           				
					<td style="width: 42px !important;"><input type="checkbox" name="showOnSite" <c:if test="${product.showOnSite}">checked</c:if> 
						onclick="setShowOnSite('${productType}', ${product.id}, this);"/></td>
							
					<td style="width: 42px !important;"><input type="checkbox" name="showOnHomePage" <c:if test="${product.showOnHomePage}">checked</c:if>
						onclick="setShowOnHomePage('${productType}', ${product.id}, this);"/></td>
							
					<td style="width: 42px !important;"><input type="checkbox" name="showOnLeftSide" <c:if test="${product.showOnLeftSide}">checked</c:if>
						onclick="setShowOnLeftSide('${productType}', ${product.id}, this);"/></td>
					
					<td style="width:60px !important;"><a href="<c:url value='/admin/${productType}/copy/${product.id}' />"><i class="fa fa-clone clone" aria-hidden="true"></i></a></td>		
					<td style="width: 53px !important;"><a href="<c:url value='/admin/${productType}/remove/${product.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	<script type="text/javascript">
	
	var tableOffset = $("table").offset().top;
	var $header = $("table tbody tr.fixed_header");
	
	$(window).bind("scroll", function() {
	    var offset = $(this).scrollTop();
	
	    if (offset >= tableOffset) {
	    	$header.show();
	    }
	    else if (offset < tableOffset) {
	    	$header.hide();
	    }
	});
	
	
	$('#sorting_parameter').change(function(){ 
	    var value = $(this).val();
	    $.ajax({
			  type: 'post',
			  url: "/admin/${productType}/${productSubType}/sorting/" + value,
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			  }).done(function(data) {
				  $('.output_pruduct').remove();
				  
				  $(data).each(function(i, product) {
	                	var outerTR = $('<tr/>').attr("id", product.id).addClass("output_pruduct");
	                	
	                	var setTopProduct = $('<input/>').attr("type", "checkbox").attr("name", "top").click(function(){
	                		setTop('${productType}', product.id, this);
	                	});
		                	
		                if(product.top){
		                	setTopProduct.prop("checked", true );
		                }

	                	var showOnSite = $('<input/>').attr("type", "checkbox").attr("name", "showOnSite").click(function(){
     					   setShowOnSite('${productType}', product.id, this);
                		});
	                	
	                	if(product.showOnSite){
	                		showOnSite.prop("checked", true );
	                	}
	                	
	                	var showOnHomePage = $('<input/>').attr("type", "checkbox").attr("name", "showOnHomePage").click(function(){
	     					setShowOnHomePage('${productType}', product.id, this);
	                	});
		                	
		                if(product.showOnHomePage){
		                	showOnHomePage.prop("checked", true );
		                }
		                
		                var showOnLeftSide = $('<input/>').attr("type", "checkbox").attr("name", "showOnLeftSide").click(function(){
	     					   setShowOnLeftSide('${productType}', product.id, this);
	                	});
		                	
		                if(product.showOnLeftSide){
		                	showOnLeftSide.prop("checked", true );
		                }

	                	outerTR.append($('<td/>').css("width","40px").text(product.id))
	                		   .append($('<td/>').css("width","120px")
	                				   .append($('<a/>')
	                						   .attr("href", "/admin/${productType}/edit/" + product.id).text(product.name)))
	                	var productType = '${productType}';
	                	if(productType != 'use_with_product' && productType != 'rip'){
	                		outerTR.append($('<td/>').css("width","40px").text(product.equipmentManufacturer))
	                	}
	                						   
	                   outerTR.append($('<td/>').css("width","200px")
	                				   .append($('<a/>').attr("href", "/admin/${productType}/edit/" + product.id)
	                				   .append($('<img/>').attr("src", "/images/${productType}s/" + product.id + "/" + product.pathPictures[0]))))
	                		   .append($('<td/>').css("width","100px").text(checkPrise(product.prise)))
	                		   .append($('<td/>').css("width","60px").append(setTopProduct))
	                		   .append($('<td/>').css("width","60px").append(showOnSite))
	                		   .append($('<td/>').css("width","60px").append(showOnHomePage))
	                		   .append($('<td/>').css("width","60px").append(showOnLeftSide))
	                		   .append($('<td/>').css("width","60px")
	                				   .append($('<a/>')
	                						   .attr("href", "/admin/${productType}/copy/" + product.id)
	                						   .append($('<i/>').addClass('fa fa-clone'))))
	                		   .append($('<td/>').css("width","60px")
	                				   .append($('<a/>')
	                						   .attr("href", "/admin/${productType}/remove/" + product.id)
	                						   .append($('<i/>').addClass('fa fa-trash-o'))))
	                		   	
	                	$('.tg tr:last').after(outerTR);
	                });
				    });	
	});
	
	function setTop(type, id, element){
		
		$.ajax({
			  type: 'post',
			  url: "/admin/" + type + "/setTop/" + id,
			  data: JSON.stringify(element.checked),
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			});	
		}
	
	function setShowOnSite(type, id, element){
		
		$.ajax({
			  type: 'post',
			  url: "/admin/" + type + "/showOnSite/" + id,
			  data: JSON.stringify(element.checked),
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			});	
		}
	
	function setShowOnHomePage(type, id, element){
		$.ajax({
			  type: 'post',
			  url: "/admin/" + type + "/showOnHomePage/" + id,
			  data: JSON.stringify(element.checked),
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			  });	
		}
	
	function setShowOnLeftSide(type, id, element){
		$.ajax({
			  type: 'post',
			  url: "/admin/" + type + "/showOnLeftSide/" + id,
			  data: JSON.stringify(element.checked),
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			  });	
		}

	function checkPrise(num){
			  num = Math.round( num / 0.01 ) * 0.01;
			  num = new Number(num).toFixed(2);   // особенности счета JavaScript ( x/100 не всегда = x*0.01 )
			  var s = 0;
			  var str = '';
			  for( var i=num.toString().length-1; i>=0; i-- ) {
			    s++;
			    str = num.toString().charAt(i) + str;
			    if(num.toString().charAt(i)=='.') s=0;
			    if( s > 0 && !(s % 3) ) str  = " " + str;
			  }   
			  return "$" + str.replace(".", ",");
	}

	</script>
</body>
</html>