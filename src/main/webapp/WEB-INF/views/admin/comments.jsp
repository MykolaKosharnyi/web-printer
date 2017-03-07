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
		<spring:message text="Список оставленных комментрариев" />
	</title>

</head>
<body>	
	<div id="product">
		<a href="<c:url value='/admin/change_comment_recipient_notification' />">Список e-mail, получающих уведомления когда кто-то оставит комментарий на сайте</a>
	
	<h3>Таблица раннее созданных рассылок</h3>
	
	<c:if test="${!empty comments}">
		<table class="tg">
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">Заголовок сообщения</th>
				<th class="text-center">Время заполнения формы</th>
				<th class="text-center">Время последнего изменения формы</th>
				<th class="text-center">Время отправки формы</th>
				<th class="text-center">Статус</th>
				<th class="text-center">Копировать сообщение</th>
				<th class="text-center">Отмена рассылки</th>			
				<th class="text-center">Удалить</th>
			</tr>

			<c:forEach items="${comments}" var="comments">
				<tr id="${message.id}" class="output_pruduct">
					<td>${message.id}</td>
					<td><a href="<c:url value='/admin/message/${message.id}' />">${message.title}</a></td>
					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="short" 
								value="${message.dateCreation}" />
					</td>
					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="short" 
								value="${message.dateLastChanging}" />
					</td> 
					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="short" 
								value="${message.dateSending}" />
					</td>



					<td width="60px"><a href="<c:url value='/admin/message/copy/${message.id}' />"><i class="fa fa-clone clone" aria-hidden="true"></i></a></td>
		
					<td width="60px"><a href="<c:url value='/admin/message/remove/${message.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>	
</body>
</html>