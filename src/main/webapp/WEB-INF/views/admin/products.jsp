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
	<div style="right:0px;position: relative;">
		Сортировка 
		<select id="sorting_parameter">
	    	<option value="id">по id</option>
	    	<option value="name">по имени</option>
	    	<option value="prise">по цене</option>
  		</select>
  	</div>
	<c:if test="${!empty listProducts}">
		<table class="tg">
			<tr>
				<th width="40">ID</th>
				<th width="120">${nameProduct}</th>
				<th width="200">Изображение</th>
				<th width="100">Цена</th>
				<th width="60">Показ. на сайте</th>
				<th width="60">Показ. на гл. меню</th>
				<th width="60">Показ. в левом блоке</th>
				<th width="60">Редактировать</th>
				<th width="60">Удалить</th>
			</tr>
			<c:forEach items="${listProducts}" var="product">
				<tr id="${product.id}" class="output_pruduct">
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td><img src="/images/${productType}s/${product.id}/${product.pathPictures.get(0)}" alt=""></td>
					<td>$<fmt:formatNumber type="number" 
	           			maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></td>
	           				
					<td><input type="checkbox" name="showOnSite" <c:if test="${product.showOnSite}">checked</c:if> 
						onclick="setShowOnSite('${productType}', ${product.id}, this);"/></td>
							
					<td><input type="checkbox" name="showOnHomePage" <c:if test="${product.showOnHomePage}">checked</c:if>
						onclick="setShowOnHomePage('${productType}', ${product.id}, this);"/></td>
							
					<td><input type="checkbox" name="showOnLeftSide" <c:if test="${product.showOnLeftSide}">checked</c:if>
						onclick="setShowOnLeftSide('${productType}', ${product.id}, this);"/></td>
							
					<td><a href="<c:url value='/admin/${productType}/edit/${product.id}' />">Изменить</a></td>
					<td><a href="<c:url value='/admin/${productType}/remove/${product.id}' />">Удалить</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	<script type="text/javascript">
	$('#sorting_parameter').change(function(){ 
	    var value = $(this).val();
	    $.ajax({
			  type: 'post',
			  url: "/admin/${productType}/${productSubType}/sorting/" + value,
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			  }).done(function( data ) {
				  $('.output_pruduct').remove();
				  
				  $(data).each(function(i, product) {
	                	var outerTR = $('<tr/>').attr("id", product.id).addClass("output_pruduct");
	                	
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

	                	outerTR.append($('<td/>').text(product.id))
	                		   .append($('<td/>').text(product.name))
	                		   .append($('<td/>').append($('<img/>').attr("src", "/images/${productType}s/" + product.id + "/" + product.pathPictures[0])))
	                		   .append($('<td/>').text(checkPrise(product.prise)))
	                		   .append($('<td/>').append(showOnSite))
	                		   .append($('<td/>').append(showOnHomePage))
	                		   .append($('<td/>').append(showOnLeftSide))
	                		   .append($('<td/>').append($('<a/>').attr("href", "/admin/${productType}/edit/" + product.id).text("Изменить")))
	                		   .append($('<td/>').append($('<a/>').attr("href", "/admin/${productType}/remove/" + product.id).text("Удалить")))
	                		   	
	                	$('.tg tr:last').after(outerTR);
	                });
				    });	
	});
	
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