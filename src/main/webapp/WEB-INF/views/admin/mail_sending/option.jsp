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

<c:if test="${empty option.id || option.id==0}">
	<title>
		<spring:message text="Добавление новой опции к письму рассылки" />
	</title>
</c:if>
<c:if test="${!empty option.id && option.id!=0}">
	<title>
		<spring:message text="Изменение опции рассылки с id = ${option.id}" />
	</title>
</c:if>
</head>
<body>
	<div id="product">
	
		<c:if test="${empty option.id || option.id==0}">
			<c:url var="action" value="/admin/message/option/new"></c:url>
		</c:if>
	
		<c:if test="${!empty option.id && option.id!=0}">
			<c:url var="action" value="/admin/message/option"></c:url>
		</c:if>
	
		<form:form style="padding: 10px 0px;" commandName="option" action="${action}" method="post">
		
			<c:if test="${empty option.id || option.id==0}">
				<input type="hidden" name="optionType" value="HEADER">
			</c:if>
		
			<c:if test="${!empty option.id && option.id!=0}">
				<input type="hidden" name="id" value="${option.id}">
				<input type="hidden" name="optionType" value="${option.optionType}">	
			</c:if>
	  
		  <div class="form-group">
			<label for="description">Тело опции:</label>
			<form:textarea path="text" class="form-control" id="description" value="${option.text}"/>
		  </div>
		  	
		  	
		  <div class="form-group">			 
		  		<label for="status_button">Тип опции (header/footer):</label> 
			  	<c:if test="${empty option.id || option.id==0}">
				  	<button type="button" id="status_button" class="btn btn-warning">HEADER</button>
			  	</c:if>
			  	
			  	<c:if test="${!empty option.id && option.id!=0}">
			  		<c:if test="${option.optionType.toString() eq 'HEADER'}">
						<button type="button" id="status_button" class="btn btn-warning">HEADER</button>
					</c:if>
	
					<c:if test="${option.optionType.toString() eq 'FOOTER'}">
						<button type="button" id="status_button" class="btn btn-info">FOOTER</button>
					</c:if>
			  	</c:if>
		  </div>

			<div class="form-group">
				<label for="description">Отображать на форме создания письма рассылки:</label>
				<form:checkbox path="showOnMailLetter"/>
		 	 </div>

			<div class="form-group">			  
		  	<c:if test="${empty option.id || option.id==0}">
				<button type="submit" class="btn btn-primary">Сохранить</button>
			</c:if>
			  	
			<c:if test="${!empty option.id && option.id!=0}">
				<button type="submit" class="btn btn-primary">Изменить</button>
			</c:if>
		  </div>

		</form:form>
	</div>

    <script type="text/javascript">
		$(function() {
			
			$('#status_button').click(function(){				
				if($(this).hasClass("btn-warning")){
					$(this).removeClass("btn-warning").addClass("btn-info").html('FOOTER');
					$("input[name='optionType']").val("FOOTER");
				} else {
					$(this).removeClass("btn-info").addClass("btn-warning").html('HEADER');
					$("input[name='optionType']").val("HEADER");
				}
			});
			
		});
	</script>

</body>
</html>