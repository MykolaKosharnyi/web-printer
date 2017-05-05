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
		<spring:message text="Список присланных вопросов на уточнение" />
	</title>

</head>
<body>	
	<div id="product">
		<a href="<c:url value='/admin/recipient_notification/user_proposal_price' />">Емейлы на которые приходят уточняющие вопросы от пользователей</a>
	
		<h3>Список присланных вопросов на уточнение</h3>
	
		<c:if test="${!empty proposals}">
			<table class="tg">
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">Текст уточнения</th>
					<th class="text-center">Время заполнения формы</th>
					<th class="text-center">Уточнение к товару</th>
					<th class="text-center">Залогиненный пользователь оставил комментарий</th>
					<th class="text-center">Имя пользователя</th>
					<th class="text-center">Номер пользователя</th>
					<th class="text-center">E-mail пользователя</th>			
					<th class="text-center">Тип уточнения</th>	
					<th class="text-center">Удалить</th>
				</tr>
	
				<c:forEach items="${proposals}" var="proposal">
					<tr>
						<td>${proposal.id}</td>
						<td>${proposal.description}</td>
						<td>
							<fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${proposal.dateCreation}" />
						</td>
						<td><a href="/${proposal.typeProduct}/${proposal.idProduct}">перейти на страницу товара</a></td>
						
						<td>
							<c:choose>
							    <c:when test="${proposal.logined}">
									ДА (id=${proposal.idUser})
							    </c:when>    
							    <c:otherwise>
									НЕТ
							    </c:otherwise>
							</c:choose>
						</td>
						<td>${proposal.name}</td>
						<td>${proposal.phoneNumber}</td>
						<td>${proposal.email}</td>
						
						<c:if test="${proposal.typeProposal.toString() eq 'SPECIFY'}">					
							<td><button type="button" class="btn btn-warning">уточняйте</button></td>
						</c:if>
						
						<c:if test="${proposal.typeProposal.toString() eq 'SUGGEST_YOUR_PRICE'}">						
							<td><button type="button" class="btn btn-info">Готовы купить за</button></td>
						</c:if>
		
						<td width="60px"><a href="<c:url value='/admin/user_proposals/remove/${proposal.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>	
</body>
</html>