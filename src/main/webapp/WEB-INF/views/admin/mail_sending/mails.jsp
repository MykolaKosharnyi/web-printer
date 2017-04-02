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
		<br>
		<a href="<c:url value='/admin/message/options' />">Опции для письма (header/footer)</a>
	
	<h3>Таблица раннее созданных рассылок</h3>
	
	<c:if test="${!empty allMessages}">
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

			<c:forEach items="${allMessages}" var="message">
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

					<c:if test="${message.status.toString() eq 'WAITING'}">					
						<td><button type="button" class="btn btn-warning">Oжидание отправки</button></td>
					</c:if>
					<c:if test="${message.status.toString() eq 'SENDED'}">						
						<td><button type="button" class="btn btn-success">Отправлено</button></td>
					</c:if>
					<c:if test="${message.status.toString() eq 'CANCELED'}">						
						<td><button type="button" class="btn btn-danger">Рассылка отменена</button></td>
					</c:if>
					<c:if test="${message.status.toString() eq 'MODIFICATION_PROCESS'}">						
						<td><button type="button" class="btn btn-info">Режим модификации</button></td>
					</c:if>

					<td width="60px"><a href="<c:url value='/admin/message/copy/${message.id}' />"><i class="fa fa-clone clone" aria-hidden="true"></i></a></td>
					<td width="60px">						
						<c:choose>
						    <c:when test="${message.status.toString() eq 'WAITING'}">
						    	<a href="<c:url value='/admin/message/deny/${message.id}' />">
									<i class="fa fa-ban" aria-hidden="true"></i>
								</a>						       
						    </c:when>
						    <c:otherwise>
						        <i class="fa fa-ban" aria-hidden="true" style="color:grey;"></i>
						    </c:otherwise>
						</c:choose>
					</td>		
					<td width="60px"><a href="<c:url value='/admin/message/remove/${message.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>	
</body>
</html>