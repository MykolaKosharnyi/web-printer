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

		<c:url var="addAction" value="/admin/internationalization/${subType}/update" ></c:url>
		<form action="${addAction}" method="POST">		
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<table class="table">
				<c:forEach var="item" items="${descriptions}">
				
					<c:if test="${item.value.id % 10 == 0}">
						 <tr style="height: 70px;">
							<td></td>
						</tr>
					</c:if>
					
					<tr>
						<td><label>${item.value.ru}</label></td>
						<td><input name="${item.key}" type="text" class="form-control" value="${item.value.en}"/></td>
					</tr>
				</c:forEach>
			</table>
					
			<input type="submit" class="btn btn-default" value="Сохранить изменения" />
		</form>
	</div>
</body>
</html>