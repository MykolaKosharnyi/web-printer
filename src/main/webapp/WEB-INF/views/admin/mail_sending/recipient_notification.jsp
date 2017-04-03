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
		<spring:message text="${headerOfNotification}" />
	</title>

	<style>
		.email_block_recipient{
			float: left;
		}
		
		.email_block_deleting{
			margin-left: 20px; 
			font-size: 18px;
			cursor:pointer;
		}
		
		.email_block_deleting:hover{
			color:red;
		}
		
	</style>
</head>
<body>
	<div id="product">
		<h3><spring:message text="${headerOfNotification}" /></h3>
		<div class="early_added_mails">
			<ol>
				<c:forEach items="${emails}" var="email">				
			    	<li><div class="email_block_recipient">${email}</div>
			    		<i class="fa fa-trash-o remove email_block_deleting" aria-hidden="true"></i>
			    	</li>				
				</c:forEach>
			</ol>
		</div>
		
		<hr/>
		
		
		<c:url var="add_email" value="/admin/recipient_notification/add/${typeNotification}"></c:url>
		<form class="form-horizontal" style="padding: 0px 10px;" action="${add_email}" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

			<div class="form-group has-feedback">
			  <input type="text" class="form-control" name="new_email" id="new_email">
			  <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
			  <p class="bg-success info_of_adding">Введенное значение удовлетворяет требованиям!</p>
			  <p class="bg-danger info_of_adding">Есть повторение с раннее введенным e-mail или он не корректен!</p>
			</div>		

			<button class="btn btn-default" disabled>Добавить e-mail</button>
		</form>	
	</div>

    <script type="text/javascript">
    $(".email_block_deleting").click(function(){
    	var parent = $(this).parent('li');
    	$.ajax({
			  type: 'post',
			  url: "/admin/recipient_notification/remove/${typeNotification}",
			  contentType: "text/plain; charset=utf-8",
			  data: parent.find("div.email_block_recipient").text(),			        
		        success: function () {
		        	parent.remove();
		        },
			  error: function(xhr, status, error) {
				  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
			  }
			});
    });
    
	$(function() {
		$("#new_email").keyup(function() {

			var ourElement = $(this);
			var dataToSend = $(this).val();
			
			if(dataToSend.trim()!=""){
			$.ajax({
				  type: 'post',
				  url: "/admin/recipient_notification/check_email/${typeNotification}",
				  contentType: "text/plain; charset=utf-8",
				  data: dataToSend,			        
			        success: function (data) {
			        	if(data.result){
			        		ourElement.parent('div').removeClass('has-error').addClass('has-success');
			        		ourElement.parent('div').find('span').removeClass('glyphicon-remove').addClass('glyphicon-ok');
			        		ourElement.parent('div').find('.bg-success').css('display','block');
			        		ourElement.parent('div').find('.bg-danger').css('display','none');
			        		ourElement.parent('div').parent('form').find('button').removeProp('disabled');
						} else {
							ourElement.parent('div').removeClass('has-success').addClass('has-error');
							ourElement.parent('div').find('span').removeClass('glyphicon-ok').addClass('glyphicon-remove');
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
				ourElement.parent('div').find('span').removeClass('glyphicon-ok').removeClass('glyphicon-remove');
				ourElement.parent('div').parent('form').find('button').prop("disabled", true);
			}
			
		});
	});
	</script>
</body>
</html>