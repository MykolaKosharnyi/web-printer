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
		<table class="tg">
			<tr>
				<th style="width:40px;">ID</th>
				<th style="width:120px;">${nameProduct}</th>
				<c:if test="${productType != 'use_with_product' && productType != 'rip'}">
					<th style="width:200px;">Производитель</th>
				</c:if>	 
				<th style="width:200px;">Изображение</th>
				<th style="width:100px;">Цена</th>
				<th style="width:60px;">Топ</th>
				<th style="width:60px;">Показ. на сайте</th>
				<th style="width:60px;">Показ. на гл. меню</th>
				<th style="width:60px;">Показ. в левом блоке</th>
				<th style="width:60px;">Копировать товар</th>
				<th style="width:60px;">Удалить</th>
			</tr>
			
			<!-- fixed header -->
			<tr class="fixed_header" 
			style="position: fixed;
    			top: 0px;
    			width:899px;
    			display:none;
    			background-color:white;">
				<th style="width:35px;">ID</th>
				<th style="width:130px;">${nameProduct}</th>
				<c:if test="${productType != 'use_with_product' && productType != 'rip'}">
					<th style="width:200px;">Производитель</th>
				</c:if>	
				<th style="width:214px;">Изображение</th>
				<th style="width:101px;">Цена</th>
				<th style="width:53px;">Топ</th>
				<th style="width:56px;">Показ. на сайте</th>
				<th style="width:57px;">Показ. на гл. меню</th>
				<th style="width:56px;">Показ. в левом блоке</th>
				<th style="width:60px;">Копировать товар</th>
				<th style="width:59px;">Удалить</th>
			</tr>
			
			<c:forEach items="${listProducts}" var="product">
				<tr id="${product.id}" class="output_pruduct">
					<td width="40px">${product.id}</td>
					<td width="120px"><a href="<c:url value='/admin/${productType}/edit/${product.id}' />">${product.name}</a></td>
					<c:if test="${productType != 'use_with_product' && productType != 'rip'}">
						<td width="40px">${product.equipmentManufacturer}</td>
					</c:if>	
					<td width="200px">
						<a href="<c:url value='/admin/${productType}/edit/${product.id}' />">
							<img src="/images/${productType}s/${product.id}/${product.pathPictures.get(0)}" alt="">
						</a>
					</td>
					<td width="100px">
						<c:if test="${product.prise > 0}">
							$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" />
						</c:if>				
	           		</td>
	           		
	           		<td width="60px"><input type="checkbox" name="top" <c:if test="${product.top}">checked</c:if> 
						onclick="setTop('${productType}', ${product.id}, this);"/></td>
	           				
					<td width="60px"><input type="checkbox" name="showOnSite" <c:if test="${product.showOnSite}">checked</c:if> 
						onclick="setShowOnSite('${productType}', ${product.id}, this);"/></td>
							
					<td width="60px"><input type="checkbox" name="showOnHomePage" <c:if test="${product.showOnHomePage}">checked</c:if>
						onclick="setShowOnHomePage('${productType}', ${product.id}, this);"/></td>
							
					<td width="60px"><input type="checkbox" name="showOnLeftSide" <c:if test="${product.showOnLeftSide}">checked</c:if>
						onclick="setShowOnLeftSide('${productType}', ${product.id}, this);"/></td>
					
					<td width="60px"><a href="<c:url value='/admin/${productType}/copy/${product.id}' />"><i class="fa fa-clone clone" aria-hidden="true"></i></a></td>		
					<td width="60px"><a href="<c:url value='/admin/${productType}/remove/${product.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a></td>
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