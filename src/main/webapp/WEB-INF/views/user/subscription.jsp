<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<title><spring:message code="path.user.subscription"/></title>

<style>
#user label{
	font-size: 18px;
}

#user tr:first-child td{
	border-top: none;
}

#user .checkbox{
	margin:0px;
}

#user .checkbox label input[type=checkbox]{
	margin-top: 7px;
}
</style>

	<table class="table table-hover" id="user">
		<c:forEach var="subscr" items="${listSubscription}" varStatus="status">
			<tr>
				<td>
					<div class="checkbox">
						<label> <input type="checkbox" name="subscription" value="${subscr}"
							<c:forEach items="${user.subscription}" var="tp"> <c:if test="${subscr eq tp}">checked</c:if> </c:forEach> >
							${subscr}
						</label>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div id="result_post"></div>
	
<script>

$(document).ready(function() {
	
	$("#user input:checked").each(function(){
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
		  url: "/user/subscription",
		  data: JSON.stringify(result),
		  contentType: "application/json; charset=utf-8",
          dataType: "json"
	})/*.done(function(data) {
	   // alert( "success" );
		//$("#result_post").text(data);
	  })
	  .fail(function() {
	 //   alert( "error, when click on:" + cur );
	  })*/;
	
	});

</script>