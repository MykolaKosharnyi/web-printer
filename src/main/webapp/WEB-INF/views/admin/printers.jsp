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
	<a href="<c:url value='/printer/new' />">Добавить принтер</a>
	<br>
	<h3>Список загруженных принтеров</h3>
	<c:if test="${!empty listPrinters}">
		<table class="tg">
			<tr>
				<th width="80">Printer ID</th>
				<th width="120">Printer Name</th>
				<th width="120">Printer Prise</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${listPrinters}" var="printer">
				<tr>
					<td>${printer.id}</td>
					<td>${printer.name}</td>
					<td>${printer.prise}</td>
					<td><a href="<c:url value='printer/edit/${printer.id}' />">Изменить</a></td>
					<td><a href="<c:url value='printer/remove/${printer.id}' />">Удалить</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>