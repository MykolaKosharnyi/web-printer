<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>
<!DOCTYPE>
<html>
<head>
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="/css/admin/add_change_printer.css">
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_printer.js"></script>

<c:if test="${empty mailMessage.id}">
	<title>
		<spring:message text="Добавление нового письма рассылки" />
	</title>
</c:if>
<c:if test="${!empty mailMessage.id}">
	<title>
		<spring:message text="Изменение писька рассылки с id = ${mailMessage.id}" />
	</title>
</c:if>
</head>
<body>
	

	
</body>
</html>