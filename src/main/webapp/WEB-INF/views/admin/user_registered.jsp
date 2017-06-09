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
	
	<script src="<%=request.getContextPath()%>/resources/js/admin/maskinput.js"></script>

	<style type="text/css">
		ul.list_without_dots input{
			margin-right: 5px;
		}
	</style>

	<title>
		<spring:message text="Изменение данных зарегистрированного пользователя с id = ${user.id}" />
	</title>
</head>
<body>
<div id="product">

	<c:url var="addAction" value="/admin/registered_user/update"></c:url>

		<form:form class="form-horizontal" style="padding: 10px 0px;" commandName="user" action="${addAction}" method="post">
		
			<input type="hidden" name="id" value="${user.id}">
			<input type="hidden" name="password" value="${user.password}">
			<input type="hidden" name="role" value="${user.role}">
			<input type="hidden" name="nameUserPicture" value="${user.nameUserPicture}">
			<input type="hidden" name="timeRegistration" 
					value="<fmt:formatDate value="${user.timeRegistration}" pattern="dd/MM/yyyy hh:mm:ss" />">	
		
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
			  <form:input path="telephone" class="form-control" value="${user.telephone}" placeholder="+38(099) 99-99-999"/>
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
			  <p class="bg-success info_of_adding">Введенное значение удовлетворяет требованиям!</p>
			  <p class="bg-danger info_of_adding">Есть повторение с раннее введенным e-mail или он не корректен!</p>
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
					<c:forEach var="subscr" items="${listSubscription}">

						<h4>${subscr.key}</h4>
						<c:forEach var="val" items="${subscr.value}">
							<div class="checkbox">
								<label> <input type="checkbox" name="subscription"
									value="${val}"
									<c:forEach items="${user.subscription}" var="tp"> <c:if test="${val eq tp}">checked</c:if> </c:forEach>>
									${val}
								</label>
							</div>
						</c:forEach>

					</c:forEach>
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
    
		/*
		http://gnatkovsky.com.ua/maska-vvoda-nomera-telefona.html
		*/
		jQuery(function($){
		   $("#telephone").mask("+38(099) 99-99-999");
		});
    
			$(function() {
				$("#email, #email2, #email3").keyup(function() {

					var ourElement = $(this);
					var dataToSend = $(this).val();
					
					if(dataToSend.trim()!=""){
					$.ajax({
						  type: 'post',
						  url: "/admin/user_add_by_admin/check_email",
						  contentType: "text/plain; charset=utf-8",
						  data: dataToSend,			        
					        success: function (data) {
					        	if(data.result){
					        		ourElement.parent('div').removeClass('has-error').addClass('has-success');
					        		ourElement.parent('div').find('.bg-success').css('display','block');
					        		ourElement.parent('div').find('.bg-danger').css('display','none');
					        		ourElement.parent('div').parent('form').find('button').removeProp('disabled');
								} else {
									ourElement.parent('div').removeClass('has-success').addClass('has-error');
									ourElement.parent('div').find('.bg-success').css('display','none');
									ourElement.parent('div').find('.bg-danger').css('display','block');
									ourElement.parent('div').parent('form').find('button').prop("disabled", true);
								}
					        },
						  error: function(xhr, status, error) {
							  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
						  }
						});

					} else {
						ourElement.parent('div').find('.bg-success').css('display','none');
						ourElement.parent('div').find('.bg-danger').css('display','none');
						ourElement.parent('div').removeClass('has-error').removeClass('has-success');
						ourElement.parent('div').parent('form').find('button').prop("disabled", true);
					}
					
				});
			});
    
	</script>

</body>
</html>