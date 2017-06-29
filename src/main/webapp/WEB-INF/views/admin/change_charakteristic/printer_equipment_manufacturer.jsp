<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
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
		
		<hr>
		<h4>Добавление нового производителя</h4>
			
		<c:url var="add_equipment_manufacturer" value="/admin/printer/add_equipment_manufacturer"></c:url>
		<form class="form-horizontal" style="padding: 0px 10px;" action="${add_equipment_manufacturer}" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

			<div class="form-group has-feedback">
			  <input type="text" class="form-control" name="new_equipment" id="new_equipment">
			  <span class="glyphicon form-control-feedback" aria-hidden="true"></span>
			  <p class="bg-success info_of_adding">Введенное значение удовлетворяет требованиям (нет повторения)!</p>
			  <p class="bg-danger info_of_adding">Есть повторение с раннее введенным производителем!</p>
			</div>		

			<button class="btn btn-default" disabled>Добавить производителя</button>
		</form>			
		
		<hr>
			<h4>Изменение вывода производителей для принтеров</h4>
	
		<c:url var="change_property" value="/admin/printer/equipment_manufacturer"></c:url>
	
		<form class="form-horizontal" style="padding: 0px 10px;" action="${change_property}" method="post">	
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
	
	<script>
	 
	$(function() {
		$("#new_equipment").keyup(function() {

			var ourElement = $(this);
			var dataToSend = $(this).val();
			
			if(dataToSend.trim()!=""){
			$.ajax({
				  type: 'post',
				  url: "/admin/printer/check_name_manufacture",
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