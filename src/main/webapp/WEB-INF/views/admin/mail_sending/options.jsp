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
		<spring:message text="Список опций для письма" />
	</title>

</head>
<body>	
	<div id="product">
		<a href="<c:url value='/admin/message/option/new' />">Создать опцию для письма рассылки (header/footer of letter)</a>
	
	<h3>Таблица раннее созданных опций для письма</h3>
	
	<c:if test="${!empty options}">
		<table class="tg">
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">Тип опции</th>
				<th class="text-center">Отображать на форме создания письма рассылки</th>
				<th class="text-center">Время последнего изменения</th>		
				<th class="text-center">Удалить</th>
			</tr>

			<c:forEach items="${options}" var="option">
				<tr>
					<td>${option.id}</td>					
					<c:if test="${option.optionType.toString() eq 'HEADER'}">
						<td><a class="btn btn-warning" href="<c:url value='/admin/message/option/${option.id}' />">HEADER</a></td>
					</c:if>
	
					<c:if test="${option.optionType.toString() eq 'FOOTER'}">
						<td><a class="btn btn-info" href="<c:url value='/admin/message/option/${option.id}' />">FOOTER</a></td>
					</c:if>
					
					<td><input type="checkbox" name="showOnMailLetter" onclick="setShowOnMailForm('${productType}', ${product.id}, this);"
					 	<c:if test="${option.showOnMailLetter}">checked</c:if> /></td>
					
					<td>
						<fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${option.dateLastChanging}" />
					</td> 
	
					<td><a href="<c:url value='/admin/message/option/remove/${option.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a></td>
				</tr>
				<tr>
					<td colspan="5">
						 <div style="background:white; display: block; padding: 10px; border-radius: 10px;">${option.text}</div>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>	
	
	<script type="text/javascript">
		function setShowOnMailForm(type, id, element){		
			$.ajax({
				type: 'post',
				url: "/admin/message/option/showOnMailLetter/" + id,
				data: JSON.stringify(element.checked),
				contentType: "application/json; charset=utf-8",
	        	dataType: "json"
			});	
		}
	</script>
</body>
</html>