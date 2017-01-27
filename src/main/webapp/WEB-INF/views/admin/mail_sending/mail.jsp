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
		<spring:message text="Изменение писька рассылки с id = ${mailMessage.id}" />
	</title>
</c:if>
</head>
<body>
	<div id="product">
		<form class="form-horizontal" style="padding: 10px 0px;">
		  <div class="form-group">
			<label for="title_message" class="col-sm-2 control-label">Заголовок:</label>
			<div class="col-sm-10">
			  <input type="text" class="form-control" id="title_message" placeholder="Заголовок письма">
			</div>
		  </div>
		  <div class="form-group">
			<label for="description" class="col-sm-2 control-label">Основная часть:</label>
			<div class="col-sm-10">
				<textarea class="form-control" id="description" rows="10"></textarea>
			</div>
		  </div>
		  <div class="form-group">
			<label class="col-sm-2 control-label">Подписчики:</label>
			<div class="col-sm-10">

				<c:forEach var="subscr" items="${listSubscription}" varStatus="status">
					<div class="checkbox">
					  <label>
						<input type="checkbox" value="${subscr}">
						${subscr}
					  </label>
					</div>
				</c:forEach>

			</div>
		  </div>

		  <div class="form-group">
			<label for="date_sending" class="col-sm-2 control-label">Время рассылки:</label>
			<div class="col-sm-10">

				<div id="datetimepicker" class="input-group input-append date" style="height: 25px;">
					<input data-format="dd/MM/yyyy hh:mm:ss" class="form-control" type="datetime"></input>
					<span class="add-on input-group-addon">
					  <span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>

			</div>
		  </div>

		  <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
			  <button type="submit" class="btn btn-primary">Отправить</button>
			</div>
		  </div>

		</form>
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