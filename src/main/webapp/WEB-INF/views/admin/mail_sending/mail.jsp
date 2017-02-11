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


    <link href="/css/admin/datepicker/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<script src="/css/admin/datepicker/bootstrap-datetimepicker.min.js"></script>

<style type="text/css">
.bootstrap-datetimepicker-widget ul{
	padding: 0px;
}

</style>

<c:if test="${empty mailMessage.id}">
	<title>
		<spring:message text="Добавление нового письма рассылки" />
	</title>
</c:if>
<c:if test="${!empty mailMessage.id}">
	<title>
		<spring:message text="Изменение письма рассылки с id = ${mailMessage.id}" />
	</title>
</c:if>
</head>
<body>
	<div id="product">
	
		<c:if test="${empty mailMessage.id}">
			<c:url var="addAction" value="/admin/message/create"></c:url>
		</c:if>
	
		<c:if test="${!empty mailMessage.id}">
			<c:url var="addAction" value="/admin/message/update"></c:url>
		</c:if>
	
		<form:form class="form-horizontal" style="padding: 10px 0px;"  commandName="mailMessage"
		 action="${addAction}" method="post">
		
			<c:if test="${!empty mailMessage.id}">
				<input type="hidden" name="id" value="${mailMessage.id}">	
				<input type="hidden" name="dateCreation" 
					value="<fmt:formatDate value="${mailMessage.dateCreation}" pattern="dd/MM/yyyy hh:mm:ss" />">
			</c:if>
			
		  <div class="form-group">
			<label for="title" class="col-sm-2 control-label">Заголовок:</label>
			<div class="col-sm-10">
			  <form:input path="title" class="form-control" placeholder="Заголовок письма" value="${mailMessage.title}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label for="message" class="col-sm-2 control-label">Основная часть:</label>
			<div class="col-sm-10">
				<form:textarea path="message" class="form-control" id="description" value="${mailMessage.message}"/>
			</div>
		  </div>
		  <div class="form-group">
			<label class="col-sm-2 control-label">Подписчики:</label>
			<div class="col-sm-10">
				<ul class="list_without_dots" style="list-style-type: none; padding: 0px;">
					<form:checkboxes items="${listSubscription}" path="subscription" element="li"/>
				</ul>
			</div>
		  </div>
		  <div class="form-group">
			<label for="date_sending" class="col-sm-2 control-label">Время рассылки:</label>
			<div class="col-sm-10">
				<div id="datetimepicker" class="input-group input-append date" style="height: 25px;">
					<input data-format="dd/MM/yyyy hh:mm:ss" name="dateSending" value="<fmt:formatDate value="${mailMessage.dateSending}" pattern="dd/MM/yyyy hh:mm:ss" />"
					 class="form-control" type="text"></input>
					<span class="add-on input-group-addon">
					  <span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
			</div>
		  </div>
		  <div class="form-group">
			<label class="col-sm-2 control-label">Статус:</label>
			<div class="col-sm-10">
				<ul class="list_without_dots" style="list-style-type: none; padding: 0px;">
					<form:radiobuttons items="${mailMessage.getStatusesOfSending()}" path="status" element="li"/>
				</ul>
			</div>
		  </div>

		  <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
			  <button type="submit" class="btn btn-primary">
			  	<c:if test="${empty mailMessage.id}">Сохранить</c:if>
			  	<c:if test="${!empty mailMessage.id}">Изменить</c:if>
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
				pickDate: true,
				startDate: new Date()
			});
		});
	</script>

</body>
</html>