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
		<a href="<c:url value='/admin/recipient_notification/comment' />">Список e-mail, получающих уведомления когда кто-то оставит комментарий на сайте</a>
		<br>
		<a href="<c:url value='/admin/recipient_notification/comment_inaccuracy' />">Список e-mail, получающих уведомления когда кто-то оставит комментарий на уточнение описания</a>
	
	<h3>Таблица оставленных комментариев</h3>
	
	<c:if test="${!empty comments}">
		<table class="tg">
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">Комментарий</th>				
				<th class="text-center">Кем оставлен коммент</th>				
				<th class="text-center">Время создания</th>			
				<th class="text-center">Тип комментария</th>
				<th class="text-center">Удалить</th>
			</tr>

			<c:forEach items="${comments}" var="comment">
				<tr id="${comment.id}" class="output_pruduct">
					<td>${comment.id}</td>
					
					<c:if test="${comment.typeComment.toString() eq 'COMMENT'}">					
						<td><a href="javascript:openInNewTabWinBrowser('/${comment.productType}/${comment.productId}?option=2')">${comment.message}</a></td>
					</c:if>
						
					<c:if test="${comment.typeComment.toString() eq 'INACCURACY_IN_DESCRIPTION'}">						
						<td><a href="javascript:openInNewTabWinBrowser('/${comment.productType}/${comment.productId}?option=4')">${comment.message}</a></td>
					</c:if>
										
					
					<td>${comment.nameUser} ${comment.secondName}</td>

					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${comment.dateWriting}" />
					</td>
					
					<c:if test="${comment.typeComment.toString() eq 'COMMENT'}">					
						<td><button type="button" class="btn btn-warning">обычный комментарий</button></td>
					</c:if>
						
					<c:if test="${comment.typeComment.toString() eq 'INACCURACY_IN_DESCRIPTION'}">						
						<td><button type="button" class="btn btn-info">уточнение описания</button></td>
					</c:if>
					
					<td width="60px">
						<a href="<c:url value='/admin/comment/remove/${comment.id}' />">
							<i class="fa fa-trash-o remove" aria-hidden="true"></i>
						</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>	
	<script type="text/javascript">
		function openInNewTabWinBrowser(url) {
			var win = window.open(url, '_blank');
			win.focus();
		}
	</script>
</body>
</html>