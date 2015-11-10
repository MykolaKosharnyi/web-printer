<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html lang="ru">
<head>
<title>Принтеры</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #ccc;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #fff;
	text-align:center;
}

.tg td img{
	hight: 200px;
	width: 200px;
}
.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #ccc;
	color: #333;
	background-color: #f0f0f0;
}

.tg .tg-4eph {
	background-color: #f9f9f9
}
</style>
</head>
<body>
	<a href="<c:url value='/admin/printer/new' />">Добавить принтер</a>
	<br>
	<h3>Список загруженных принтеров</h3>
	<c:if test="${!empty listPrinters}">
		<table class="tg">
			<tr>
				<th width="40">ID</th>
				<th width="120">Имя принтера</th>
				<th width="200">Изображение</th>
				<th width="80">Цена</th>
				<th width="80">Ярлык слева</th>
				<th width="80">Ярлык справа</th>
				<th width="80">Таймер</th>
				<th width="60">Редактировать</th>
				<th width="60">Удалить</th>
			</tr>
			<c:forEach items="${listPrinters}" var="printer">
				<tr>
					<td>${printer.id}</td>
					<td>${printer.name}</td>
					<td><img src="<%=request.getContextPath()%>/resources/images/printers/${printer.id}/${printer.pathPictures.get(0)}" alt=""></td>
					<td>${printer.prise} $</td>
					<td>. </td>
					<td>. </td>
					<td>. </td>
					<td><a href="<c:url value='/admin/printer/edit/${printer.id}' />">Изменить</a></td>
					<td><a href="<c:url value='/admin/printer/remove/${printer.id}' />">Удалить</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>