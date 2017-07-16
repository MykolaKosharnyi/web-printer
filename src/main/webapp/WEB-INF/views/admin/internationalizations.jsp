<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
<html lang="ru">
<head>
	<title>${title}</title>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>	
</head>
<body>
	<div id="product">
		<a href="<c:url value='/admin/internationalization/common' />">Общие надписи</a>
		<br>
		<a href="<c:url value='/admin/internationalization/inaccuracy_in_description' />">Неточность в описании</a>
		<br>
		<a href="<c:url value='/admin/internationalization/comments' />">Надписи в добавлениях комментариев</a>
		<br>
		<a href="<c:url value='/admin/internationalization/search' />">Общие характеристики для поиска/сокращенные физические величины</a>
		<br>
		<a href="<c:url value='/admin/internationalization/search_printer' />">Характеристики для поиска, принтеры</a>
		<br>
	</div>
</body>
</html>