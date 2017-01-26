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

	<title>
		<spring:message text="Список рассылок" />
	</title>

</head>
<body>	
	<div id="product">
		<a href="<c:url value='/admin/message/new' />">Создать новое сообщение рассылки</a>
	</div>	
	<h3>Таблица раннее созданных рассылок</h3>
	
	<c:if test="${!empty allMessages}">
		<table class="tg">
			<tr>
				<th style="width:40px;">ID</th>
				<th style="width:120px;">Заголовок сообщения</th>
				<th style="width:200px;">Время заполнения формы</th>
				<th style="width:100px;">Время последнего изменения формы</th>
				<th style="width:100px;">Время отправки формы</th>
				<th style="width:60px;">Статус</th>
				<th style="width:60px;">Копировать сообщение</th>
				<th style="width:60px;">Отмена рассылки</th>			
				<th style="width:60px;">Удалить</th>
			</tr>

			<c:forEach items="${allMessages}" var="message">
				<tr id="${message.id}" class="output_pruduct">
					<td>${message.id}</td>
					<td><a href="<c:url value='/admin/message/${message.id}' />">${message.title}</a></td>
					<td>
						<fmt:formatDate type="date" dateStyle="long" timeStyle="short" 
								value="${message.dateCreation}" />
					</td>
					<td>
						<fmt:formatDate type="date" dateStyle="long" timeStyle="short" 
								value="${message.dateLastChanging}" />
					</td> 
					<td>
						<fmt:formatDate type="date" dateStyle="long" timeStyle="short" 
								value="${message.dateSending}" />
					</td>
					<td>${message.status.toString()}</td>
					<td width="60px"><a href="<c:url value='/admin/message/copy/${message.id}' />"><i class="fa fa-clone clone" aria-hidden="true"></i></a></td>
					<td width="60px"><a href="<c:url value='/admin/message/deny/${message.id}' />"><i class="fa fa-ban" aria-hidden="true"></i></a></td>		
					<td width="60px"><a href="<c:url value='/admin/message/remove/${message.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>