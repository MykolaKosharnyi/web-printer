<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<!DOCTYPE html>
<html lang="ru">
	<head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="/css/admin/common.css">
		<title>Admin</title>
	</head>
<body>
<div style="width: 1100px; margin: 0 auto;">
	<jsp:include page="admin/admin_login_in_out.jsp" />

	<div id="content">
	    <a href="<c:url value='/admin/printers' />">Принтеры</a>
	    <a href="<c:url value='/admin/3d_printers' />">3D Принтеры</a>
	    <a href="<c:url value='/admin/digital_printers' />">Цыфровые принтеры</a>
	    <a href="<c:url value='/admin/laminators' />">Ламинаторы</a>
	    <a href="<c:url value='/admin/lasers' />">Лазеры</a>
	    <a href="<c:url value='/admin/cutters' />">Фрезеры</a>
	    <a href="<c:url value='/admin/scanners' />">Сканеры</a>
	    <a href="<c:url value='/admin/previous_use_equipments' />">Б/У Оборудование</a>
	    <a href="<c:url value='/admin/rips' />">ПО</a>
	    <a href="<c:url value='/admin/use_with_products' />">Cопутствующие товары</a>
		<a href="<c:url value='/admin/users' />" style="background: lightgreen;">Пользователи</a>
	    <a href="<c:url value='/admin/all_sended_messages' />" style="background: lightpink;">Рассылки</a>	
	    <a href="<c:url value='/admin/comments' />">Комментарии</a>
	    <a href="<c:url value='/admin/pictures' />">Изменение изображений главного меню/домашней страницы</a>
	    <a href="<c:url value='/admin/video_on_home_page' />">Видео на главной странице</a>
	    <a href="<c:url value='/admin/constants' />">КОНСТАНТЫ</a>    
	    <a href="<c:url value='/admin/user_proposals' />">Список присланных вопросов на уточнение</a> 
    </div>
</div>
</body>
</html>