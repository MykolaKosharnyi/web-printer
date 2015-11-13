<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ru">
	<head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/admin/admin_head_page.css">
		<title>Admin</title>
	</head>
<body>
	<div id="content">
	    <a href="<c:url value='/admin/printers' />">Принтеры</a>
	    <a href="<c:url value='/admin/printers_3d' />">3D Принтеры</a>
	    <a href="">Ламинаторы</a>
	    <a href="">Лазеры</a>
	    <a href="">Фрезеры</a>
	    <a href="">Сканеры</a>
	    <a href="">ПО</a>
	    <a href="">Реклама</a>
    </div>
</body>
</html>