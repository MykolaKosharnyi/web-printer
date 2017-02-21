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
	<script src="<%=request.getContextPath()%>/resources/js/admin/add_change_printer.js"></script>

	<title>
		<spring:message text="Изменение вывода производителей для принтеров" />
	</title>
</head>
<body>
	<div id="product">
		
		<h3>Изменение вывода производителей для принтеров</h3>
	
		<c:url var="change_equipment_manufacturer" value="/admin/printer/equipment_manufacturer"></c:url>
	
		<form class="form-horizontal" style="padding: 10px 0px;" action="${change_equipment_manufacturer}" method="post">	
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<c:forEach items="${printer.equipment_manufacturer}" var="equipment">
				<div class="checkbox">
					<label>
						<input type="checkbox" <c:if test="${ equipment.show eq true }">checked</c:if>
					       name="equipment_manufacturer" value="${ equipment.name }"> ${ equipment.name }
					</label>
				</div>	
			</c:forEach>
			
			<button type="submit" class="btn btn-default" style="margin: 20px;">Сохранить</button>
		</form>

	</div>
</body>
</html>