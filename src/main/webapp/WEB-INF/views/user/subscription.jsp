<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<table class="table" id="user">
		<c:forEach var="subscr" items="${listSubscription}" varStatus="status">
			<tr>
				<td>
					<div class="checkbox">
						<label> <input type="checkbox" name="subscription"
							<c:forEach items="${user.subscription}" var="tp"><c:if test="${tp eq subscr}">checked</c:if></c:forEach>>
							${subscr}
						</label>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
	
<script>
$(document).on("click", '#user .checkbox tbody tr td label', function(){
	var result = new Array();
//	$("#user div.checkbox input:checked").each(function(){
//		result.push($(this).val());	
//	});
	
	result.push("принтеры ");	
	result.push("3Д принтеры ");
	result.push("ламинаторы ");
	
	$.ajax({
		  type: 'POST',
		  url: "/user/subscription",
		  data: JSON.stringify(result),
		  contentType: "application/json; charset=utf-8",
          dataType: "json",
          error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert("some error");
				console.log(XMLHttpRequest.statusText);
				console.log(textStatus);
				console.log(errorThrown);
			}
	}).done(function() {
	    alert( "success" );
	  })
	  .fail(function() {
	    alert( "error" );
	  });

});

</script>