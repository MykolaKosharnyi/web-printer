<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<title><spring:message code="path.user.subscription"/></title>

<style>
#user label,
#user_scope_activities label{
	font-size: 16px;
}

#user tr:first-child td,
#user_scope_activities tr:first-child td{
	border-top: none;
}

#user .checkbox,
#user_scope_activities .checkbox{
	margin:0px;
}

#user .checkbox label input[type=checkbox],
#user_scope_activities .checkbox label input[type=checkbox]{
	margin-top: 4px;
}

#subscription_result_post{
	display: none;
	color: green;
	margin: 20px;
	font-size: 18px;
	margin-bottom: 0px;
}
</style>

<div id="subscription_result_post"></div>

<table class="table table-hover" id="user_scope_activities">

	<tr>
		<td><h3>Сфера деятельности</h3></td>
	</tr>

	<c:forEach var="scope" items="${listScopeOfActivities}">

			<tr>
				<td>
					<div class="checkbox">
						<label> <input type="checkbox" name="listScopeOfActivities" value="${scope}"
							<c:forEach items="${u_listScopeOfActivities}" var="tp"> <c:if test="${scope eq tp}">checked</c:if> </c:forEach>>
							${scope}
						</label>
					</div>
				</td>
			</tr>

	</c:forEach>
</table>

<table class="table table-hover" id="user">
	<c:forEach var="subscr" items="${listSubscription}">

		<tr>
			<td><h3>${subscr.key}</h3></td>
		</tr>

		<c:forEach var="val" items="${subscr.value}">
			<tr>
				<td>
					<div class="checkbox">
						<label> <input type="checkbox" name="subscription" value="${val}"
							<c:forEach items="${subscriptions}" var="tp"> <c:if test="${val eq tp}">checked</c:if> </c:forEach>>
							${val}
						</label>
					</div>
				</td>
			</tr>
		</c:forEach>

	</c:forEach>
</table>
	
<script>

$(document).ready(function() {
	
	$("#user input:checked").each(function(){
		$(this).parent("label").parent("div.checkbox").parent("td").css({
			'color':'#006080',
			'background':'#b5d9f0'
		});	
	});
	
	$("#user_scope_activities input:checked").each(function(){
		$(this).parent("label").parent("div.checkbox").parent("td").css({
			'color':'#006080',
			'background':'#b5d9f0'
		});	
	});
	
});


$("#user input[type=checkbox]").click(function() {
	
	//set color and background
	if($(this).is(':checked')){
		$(this).parent("label").parent("div.checkbox").parent("td").css({
			'color':'#006080',
			'background':'#b5d9f0'
		});	
	}else{
		$(this).parent("label").parent("div.checkbox").parent("td").css({
			'color':'black',
			'background':'white'
		});	
	}
	
	var result = new Array();

	$("#user input:checked").each(function(){
		result.push($(this).val());	
	});

	var cur = $(this).val();
	
	$.ajax({
		  type: 'POST',
		  url: "/subscription/${userId}",
		  data: JSON.stringify(result),
		  contentType: "application/json; charset=utf-8"
	}).done(function() {
		$("#subscription_result_post").text("Ваши изменения были сохранены!").css("display","block").delay(2000).fadeOut("slow");
	  })
	  .fail(function(xhr, status, error) {
		  //alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
		  $("#subscription_result_post")
		  	.text("К сожалению, Ваши изменения не были сохранены. Попробуйте изменить подписки немного позднее")
		  	.css({"display":"block", "color":"red"}).delay(2000).fadeOut("slow");
	  });
	
	});
	
	
$("#user_scope_activities input[type=checkbox]").click(function() {
	
	//set color and background
	if($(this).is(':checked')){
		$(this).parent("label").parent("div.checkbox").parent("td").css({
			'color':'#006080',
			'background':'#b5d9f0'
		});	
	}else{
		$(this).parent("label").parent("div.checkbox").parent("td").css({
			'color':'black',
			'background':'white'
		});	
	}
	
	var result = new Array();

	$("#user_scope_activities input:checked").each(function(){
		result.push($(this).val());	
	});

	var cur = $(this).val();
	
	$.ajax({
		  type: 'POST',
		  url: "/scope_activities/${userId}",
		  data: JSON.stringify(result),
		  contentType: "application/json; charset=utf-8"
	}).done(function() {
		$("#subscription_result_post").text("Ваши изменения были сохранены!").css("display","block").delay(2000).fadeOut("slow");
	  })
	  .fail(function(xhr, status, error) {
		  //alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
		  $("#subscription_result_post")
		  	.text("К сожалению, Ваши изменения не были сохранены. Попробуйте изменить подписки немного позднее")
		  	.css({"display":"block", "color":"red"}).delay(2000).fadeOut("slow");
	  });
	
	});

</script>