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


    <link href="/css/admin/datepicker/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<script src="/css/admin/datepicker/bootstrap-datetimepicker.min.js"></script>

<style type="text/css">
ul.list_without_dots input{
	margin-right: 5px;
}

</style>

<c:if test="${empty user.id}">
	<title>
		<spring:message text="Добавление нового пользователя" />
	</title>
</c:if>
<c:if test="${!empty user.id}">
	<title>
		<spring:message text="Изменение пользователя с id = ${user.id}" />
	</title>
</c:if>
</head>
<body>
<div id="product">
	<c:if test="${empty user.id}">
		<c:url var="addAction" value="/admin/user/create"></c:url>
	</c:if>

	<c:if test="${!empty user.id}">
		<c:url var="addAction" value="/admin/user/update"></c:url>
	</c:if>

		<form:form class="form-horizontal" style="padding: 10px 0px;" commandName="user" action="${addAction}" method="post">
		
			<c:if test="${!empty user.id}">
				<input type="hidden" name="id" value="${user.id}">
				<input type="hidden" name="timeRegistration" 
					value="<fmt:formatDate value="${user.timeRegistration}" pattern="dd/MM/yyyy hh:mm:ss" />">	
			</c:if>
		
		  <div class="form-group">
			<label for="firstName" class="col-sm-2 control-label">Имя:</label>
			<div class="col-sm-10">
			  <form:input path="firstName" class="form-control" value="${user.firstName}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">Фамилия:</label>
			<div class="col-sm-10">
			  <form:input path="lastname" class="form-control" value="${user.lastname}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="county" class="col-sm-2 control-label">Страна:</label>
			<div class="col-sm-10">
			  <form:input path="county" class="form-control" value="${user.county}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="city" class="col-sm-2 control-label">Город:</label>
			<div class="col-sm-10">
			  <form:input path="city" class="form-control" value="${user.city}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="telephone" class="col-sm-2 control-label">Номер телефона:</label>
			<div class="col-sm-10">
			  <form:input path="telephone" class="form-control" value="${user.telephone}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="company" class="col-sm-2 control-label">Компания:</label>
			<div class="col-sm-10">
			  <form:input path="company" class="form-control" value="${user.company}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="email" class="col-sm-2 control-label">E-mail:</label>
			<div class="col-sm-10">
			  <form:input path="email" class="form-control" value="${user.email}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="date_sending" class="col-sm-2 control-label">День рождения:</label>
			<div class="col-sm-10">
				<div id="datetimepicker" class="input-group input-append date" style="height: 25px;">
					<input data-format="dd/MM/yyyy hh:mm:ss" name="dateOfBirthDay" value="<fmt:formatDate value="${user.dateOfBirthDay}" pattern="dd/MM/yyyy hh:mm:ss" />"
					 class="form-control" type="text"></input>
					<span class="add-on input-group-addon">
					  <span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		  </div>
		  <div class="form-group">
			<label class="col-sm-2 control-label">Сфера деятельности:</label>
			<div class="col-sm-10">
				<ul class="list_without_dots" style="list-style-type: none; padding: 0px;">
					<form:checkboxes items="${listScopeOfActivities}" path="scopeOfActivities" element="li"/>
				</ul>
			</div>
		  </div>
		  <div class="form-group">
			<label class="col-sm-2 control-label">Подписки:</label>
			<div class="col-sm-10">
				<ul class="list_without_dots" style="list-style-type: none; padding: 0px;">
					<form:checkboxes items="${listSubscription}" path="subscription" element="li"/>
				</ul>
			</div>
		  </div>
		  
		  <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
			  <button type="submit" class="btn btn-primary">
			  	<c:if test="${empty user.id}">Сохранить</c:if>
			  	<c:if test="${!empty user.id}">Изменить</c:if>
			  </button>
			</div>
		  </div>

		</form:form>
	</div>

    <script type="text/javascript">
    /*
    http://tarruda.github.io/bootstrap-datetimepicker/
    */
		$(function() {
			$('#datetimepicker').datetimepicker({
				language: 'ru',
				pickTime: true,
				pickDate: true
			});
		});
	</script>

</body>
</html>