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
	
	.block_concrete_subsctiption{
		width: 25%;
		float: left;
	}
	
	.head_name_of_block_subscription{
		cursor: pointer;
	}
</style>

<c:if test="${empty mailMessage.id || mailMessage.id==0}">
	<title>
		<spring:message text="Добавление нового письма рассылки" />
	</title>
</c:if>
<c:if test="${!empty mailMessage.id && mailMessage.id!=0}">
	<title>
		<spring:message text="Изменение письма рассылки с id = ${mailMessage.id}" />
	</title>
</c:if>
</head>
<body>
	<div id="product">
	
		<c:if test="${empty mailMessage.id || mailMessage.id==0}">
			<c:url var="addAction" value="/admin/message/create"></c:url>
		</c:if>
	
		<c:if test="${!empty mailMessage.id && mailMessage.id!=0}">
			<c:url var="addAction" value="/admin/message/update"></c:url>
		</c:if>
	
		<form:form style="padding: 10px 0px;"  commandName="mailMessage"
		 action="${addAction}" method="post">
		 
		 <div class="form-group">
			  
			  	<c:if test="${empty mailMessage.id || mailMessage.id==0}">
			  		<button type="submit" class="btn btn-primary">Сохранить</button>
			  	</c:if>
			  	
			  	<c:if test="${!empty mailMessage.id && mailMessage.id!=0}">
			  		<c:if test="${mailMessage.status.toString() eq 'WAITING' ||
			  		 mailMessage.status.toString() eq 'MODIFICATION_PROCESS'}">
			  			<button type="submit" class="btn btn-primary">Изменить</button>
			  		</c:if>
			  	</c:if>
			  	
			  	<a class="btn btn-success" href="javascript:void(0)" onclick="getBlackVersion();">Получить черновой вариант письма</a>
		  </div>
		
			<c:if test="${!empty mailMessage.id && mailMessage.id!=0}">
				<input type="hidden" name="id" value="${mailMessage.id}">	
				<input type="hidden" name="status" value="${mailMessage.status}">
				<input type="hidden" name="dateCreation" 
					value="<fmt:formatDate value="${mailMessage.dateCreation}" pattern="dd/MM/yyyy hh:mm:ss" />">
			</c:if>
			
		  <div class="form-group">
			<label for="title">Заголовок:</label>
			<form:input path="title" class="form-control" placeholder="Заголовок письма" value="${mailMessage.title}"/>
		  </div>

			<c:if test="${!empty listHeaderOption}">
				<div class="form-group">
					<label for="message">Header of message:</label>
					
					<c:forEach items="${listHeaderOption}" var="headerOption" varStatus="status">
						<div class="radio" style="<c:if test="${mailMessage.headerOption==0 && status.first}">background: #006080;</c:if>
						<c:if test="${mailMessage.headerOption!=0 && mailMessage.headerOption==headerOption.id}">background: #006080;</c:if> padding: 10px; border-radius: 10px;">
							<label> <input type="radio" class="radio_mail_option"
								name=headerOption value="${headerOption.id}"
								style="padding: 5px; border-radius: 10px;" <c:if test="${mailMessage.headerOption==0 && status.first}">checked</c:if>
						<c:if test="${mailMessage.headerOption!=0 && mailMessage.headerOption==headerOption.id}">checked</c:if>>
								<div style="background: white; display: block; padding: 10px; border-radius: 10px;">${headerOption.text}</div>
							</label>
						</div>
					</c:forEach>
				</div>
			</c:if>
			
		  
		  <div class="form-group">
			<label for="message">Основная часть:</label>
			<form:textarea path="message" class="form-control" id="description" value="${mailMessage.message}"/>
		  </div>
		  
			<c:if test="${!empty listFooterOption}">
				<div class="form-group">
					<label for="message">Footer of message:</label>
					
					<c:forEach items="${listFooterOption}" var="footerOption" varStatus="status">
						<div class="radio" style="<c:if test="${mailMessage.footerOption==0 && status.first}">background: #006080;</c:if>
						<c:if test="${mailMessage.footerOption!=0 && mailMessage.footerOption==footerOption.id}">background: #006080;</c:if> padding: 10px; border-radius: 10px;">
							<label> <input type="radio" class="radio_mail_option"
								name="footerOption" value="${footerOption.id}"
								style="padding: 5px; border-radius: 10px;" <c:if test="${mailMessage.footerOption==0 && status.first}">checked</c:if>
						<c:if test="${mailMessage.footerOption!=0 && mailMessage.footerOption==footerOption.id}">checked</c:if>>
								<div style="background: white; display: block; padding: 10px; border-radius: 10px;">${footerOption.text}</div>
							</label>
						</div>
					</c:forEach>
				</div>
			</c:if>		  
		  
		  <div class="form-group">
			<label style="display: block;">Подписчики:</label>
				<c:forEach var="subscr" items="${listSubscription}">
					<div class="block_concrete_subsctiption">
						<h4 class="head_name_of_block_subscription">${subscr.key}</h4>
						<c:forEach var="val" items="${subscr.value}">
							<div class="checkbox">
								<label> <input type="checkbox" name="subscription"
									value="${val}"
									<c:forEach items="${mailMessage.subscription}" var="tp"> <c:if test="${val eq tp}">checked</c:if> </c:forEach>>
									${val}
								</label>
							</div>
						</c:forEach>
					</div>
				</c:forEach>
		  </div>
		  <div class="form-group">
			<label for="date_sending" >Время рассылки:</label>
				<div id="datetimepicker" class="input-group input-append date" style="height: 25px;">
					<input data-format="dd/MM/yyyy hh:mm:ss" name="dateSending" value="<fmt:formatDate value="${mailMessage.dateSending}" pattern="dd/MM/yyyy hh:mm:ss" />"
					 class="form-control" type="text"></input>
					<span class="add-on input-group-addon">
					  <span class="glyphicon glyphicon-calendar"></span>
					</span>
				</div>
		  </div>
		  
		  <c:if test="${mailMessage.status.toString() eq 'WAITING' ||
			  		 mailMessage.status.toString() eq 'MODIFICATION_PROCESS'}">
			  <div class="form-group">
				<label for="date_sending">Статус:</label>
					<c:if test="${mailMessage.status.toString() eq 'WAITING'}">
			  		 	<button type="button" id="status_button" class="btn btn-warning">Oжидание отправки</button>
			  		 </c:if>
					
					<c:if test="${mailMessage.status.toString() eq 'MODIFICATION_PROCESS'}">
			  		 	<button type="button" id="status_button" class="btn btn-info">Режим модификации</button>
			  		</c:if>
			  </div>
			  
		  </c:if>

		  <div class="form-group">			  
		  	<c:if test="${empty mailMessage.id || mailMessage.id==0}">
				<button type="submit" class="btn btn-primary">Сохранить</button>
			</c:if>
			  	
			<c:if test="${!empty mailMessage.id && mailMessage.id!=0}">
				<c:if test="${mailMessage.status.toString() eq 'WAITING' ||
			  		 mailMessage.status.toString() eq 'MODIFICATION_PROCESS'}">
			  			<button type="submit" class="btn btn-primary">Изменить</button>
			  	</c:if>
			</c:if>
			<a class="btn btn-success" href="javascript:void(0)" onclick="getBlackVersion();">Получить черновой вариант письма</a>
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
			
			$('.radio_mail_option').on( "click", function() {
				$('.radio_mail_option').each(function(i, option){
					if(option.checked){
						$(this).parent('label').parent('div.radio').css('background', '#006080');
					} else {
						$(this).parent('label').parent('div.radio').css('background', 'transparent');
					}
				});
			});
			

			$('.head_name_of_block_subscription').click(function(){
				if($(this).hasClass("all-checked")){
					$(this).removeClass("all-checked");
					$(this).parent('.block_concrete_subsctiption').find('input[type=checkbox]').prop('checked', false);
				}else{
					$(this).addClass("all-checked");
					$(this).parent('.block_concrete_subsctiption').find('input[type=checkbox]').prop('checked', true);
				}

			});
			
			$('#status_button').click(function(){
				
				if($(this).hasClass("btn-warning")){
					$(this).removeClass("btn-warning").addClass("btn-info").html('Режим модификации');
					$("input[name='status']").val("MODIFICATION_PROCESS");
				} else {
					$(this).removeClass("btn-info").addClass("btn-warning").html('Oжидание отправки');
					$("input[name='status']").val("WAITING");
				}
			});

		});
    
    function getBlackVersion(){
    	var outerForm = $("form#mailMessage");

    	var letter = {
    			"id": new Number("${mailMessage.id}"),
    			"status":"${mailMessage.status}",
    			"subscription":[],
    			"dateCreation": null,
    			"dateSending": null,
    			"dateLastChanging": null,
    			"title":outerForm.find("input#title").val(),
    			"message":outerForm.find("textarea#description").val(),
    			"headerOption": new Number("${mailMessage.headerOption}") == 0 ? 0:outerForm.find('input[name=headerOption]:checked').val(),
    			"footerOption": new Number("${mailMessage.footerOption}") == 0 ? 0:outerForm.find('input[name=footerOption]:checked').val()
    	};
    	$.ajax({
			type: 'post',
			url: "/admin/message/black_version_of_letter",
			data: JSON.stringify(letter),
			contentType: "application/json; charset=utf-8",		
			dataType: "json"
		});	
    }

	</script>

</body>
</html>