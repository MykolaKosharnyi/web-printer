<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<html lang="ru">
<head>
	<title>3D принтеры</title>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body>
	<div id="product">
	<a href="<c:url value='/admin/3d_printer/new' />">Добавить 3D принтер</a>
	<br>
	<h3>${titleOfTable}</h3>
	<c:if test="${!empty listProducts}">
		<table class="tg">
			<tr>
				<th width="40">ID</th>
				<th width="120">Имя принтера</th>
				<th width="200">Изображение</th>
				<th width="120">Цена</th>
				<th width="60">Показ. на сайте</th>
				<th width="60">Показ. на гл. меню</th>
				<th width="60">Показ. в левом блоке</th>
				<th width="60">Редактировать</th>
				<th width="60">Удалить</th>
			</tr>
			<c:forEach items="${listProducts}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td><img src="/images/3d_printers/${product.id}/${product.pathPictures.get(0)}" alt=""></td>
					<td>$<fmt:formatNumber type="number" 
           				maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></td>
           				
           			<td><input type="checkbox" name="showOnSite" <c:if test="${product.showOnSite}">checked</c:if> 
						onclick="setShowOnSite(${product.id}, this);"/></td>
						
					<td><input type="checkbox" name="showOnHomePage" <c:if test="${product.showOnHomePage}">checked</c:if>
						onclick="setShowOnHomePage(${product.id}, this);"/></td>
						
					<td><input type="checkbox" name="showOnLeftSide" <c:if test="${product.showOnLeftSide}">checked</c:if>
						onclick="setShowOnLeftSide(${product.id}, this);"/></td>
						
					<td><a href="<c:url value='/admin/3d_printer/edit/${product.id}' />">Изменить</a></td>
					<td><a href="<c:url value='/admin/3d_printer/remove/${product.id}' />">Удалить</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	
	<script type="text/javascript">
	function setShowOnSite(id, element){
		$.ajax({
			  type: 'post',
			  url: "/admin/3d_printer/showOnSite/" + id,
			  data: JSON.stringify(element.checked),
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			  });	
		}
	
	function setShowOnHomePage(id, element){
		$.ajax({
			  type: 'post',
			  url: "/admin/3d_printer/showOnHomePage/" + id,
			  data: JSON.stringify(element.checked),
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			  });	
		}
	
function setShowOnLeftSide(id, element){
		$.ajax({
			  type: 'post',
			  url: "/admin/3d_printer/showOnLeftSide/" + id,
			  data: JSON.stringify(element.checked),
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
			  });	
		}
	</script>
	
</body>
</html>