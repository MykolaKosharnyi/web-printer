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
				<th width="40">ID</th>
				<th width="120">Имя товара</th>
				<th width="200">Изображение</th>
				<th width="60">Тип продукта</th>
				<th width="100">Цена</th>
				<th width="60">Показ. на сайте</th>
				<th width="60">Показ. на гл. меню</th>
				<th width="60">Показ. в левом блоке</th>
				<th width="60">Редактировать</th>
				<th width="60">Удалить</th>
			</tr>
			<c:forEach items="${listProducts}" var="product">
				<tr id="${product.id}">
					<td>${product.id}</td>
					<td><a href="<c:url value='/admin/${product.type}/edit/${product.id}' />">${product.name}</a></td>
					<td>
						<a href="<c:url value='/admin/${product.type}/edit/${product.id}' />">
							<img src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt="">
						</a>
					</td>
					<td>${product.type}</td>
					<td>$<fmt:formatNumber type="number" 
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