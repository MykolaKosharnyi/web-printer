<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page session="true"%>
<html lang="ru">
<head>
	<title>Б/У оборудование</title>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
	<div id="product">
	<br>
	<h3>Список загруженного б/у оборудования</h3>
	<c:if test="${!empty listProducts}">
		<table class="tg">
			<tr>
				<th style="min-width: 31px; max-width: 31px;" class="text-center">ID</th>
				<th style="min-width: 128px; max-width: 128px;" class="text-center">Имя товара</th>
				<th style="min-width: 221px; max-width: 221px;" class="text-center">Изображение</th>
				<th style="min-width: 60px; max-width: 60px;" class="text-center">Тип продукта</th>
				<th style="min-width: 96px; max-width: 96px;" class="text-center">Цена</th>
				<th style="width: 53px;" class="text-center">Показ. на сайте</th>
				<th style="width: 55px;" class="text-center">Показ. на гл. меню</th>
				<th style="width: 54px;" class="text-center">Показ. в левом блоке</th>
				<th width="60" class="text-center">Редактировать</th>
				<th style="width: 58px;" class="text-center">Удалить</th>
			</tr>
			
			<!-- fixed header -->
			<tr class="fixed_header" 
			style="position: fixed;
    			top: 0px;
    			width:899px;
    			display:none;
    			margin-left: -1px;
    			background-color:white;">
				<th style="min-width: 31px; max-width: 31px;" class="text-center">ID</th>
				<th style="min-width: 128px; max-width: 128px;" class="text-center">Имя товара</th>
				<th style="min-width: 221px; max-width: 221px;" class="text-center">Изображение</th>
				<th style="min-width: 60px; max-width: 60px;" class="text-center">Тип продукта</th>
				<th style="min-width: 96px; max-width: 96px;" class="text-center">Цена</th>
				<th style="width: 53px;" class="text-center">Показ. на сайте</th>
				<th style="width: 55px;" class="text-center">Показ. на гл. меню</th>
				<th style="width: 54px;" class="text-center">Показ. в левом блоке</th>
				<th width="60" class="text-center">Редактировать</th>
				<th style="width: 58px;" class="text-center">Удалить</th>
			</tr>
			
			<c:forEach items="${listProducts}" var="product">
				<tr id="${product.id}">
					<td style="min-width: 31px; max-width: 31px;">${product.id}</td>
					<td style="min-width: 128px; max-width: 128px;"><a href="<c:url value='/admin/${product.type}/edit/${product.id}' />">${product.name}</a></td>
					<td style="min-width: 221px; max-width: 221px;">
						<a style="min-width: 221px; max-width: 221px;" href="<c:url value='/admin/${product.type}/edit/${product.id}' />">
							<img style="min-width: 221px; max-width: 221px;" src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt="">
						</a>
					</td>
					<td style="min-width: 60px; max-width: 60px;">${product.type}</td>
					<td style="min-width: 96px; max-width: 96px;">$<fmt:formatNumber type="number" 
           				maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></td>
           				
					<td><input type="checkbox" name="showOnSite" <c:if test="${product.showOnSite}">checked</c:if> 
						onclick="setShowOnSite('${product.type}', ${product.id}, this);"/></td>
						
					<td><input type="checkbox" name="showOnHomePage" <c:if test="${product.showOnHomePage}">checked</c:if>
						onclick="setShowOnHomePage('${product.type}', ${product.id}, this);"/></td>
						
					<td><input type="checkbox" name="showOnLeftSide" <c:if test="${product.showOnLeftSide}">checked</c:if>
						onclick="setShowOnLeftSide('${product.type}', ${product.id}, this);"/></td>
						
					<td><a href="<c:url value='/admin/${product.type}/edit/${product.id}' />"><i class="fa fa-pencil edit" aria-hidden="true"></i></a></td>
					<td><a href="<c:url value='/admin/${product.type}/remove/${product.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a></td>
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
	</script>
</body>
</html>