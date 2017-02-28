<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div id="comments_block">

	<c:forEach items="${comments}" var="comment">
		<div>
		
		</div>
	</c:forEach>
	
	<div style="display: table;">
		<img src="/images/users/1/9583008.jpg" class="col-sm-1 img-circle"/>
		<div>
			<label class="col-sm-11">Раннее введенное сообщение...</label>
		</div>
	</div>
	
	<div style="display: table;">
		<img src="/images/users/1/9583008.jpg" class="col-sm-1 img-circle"/>
		<div>
			<label class="col-sm-11">Раннее введенное сообщение...</label>
		</div>
	</div>
	
	<c:url var="addCommentLink" value="/comment/add"></c:url>
	<form:form class="form-horizontal" commandName="addComment" action="${addCommentLink}" method="post">
		<input type="hidden" name="productType" value="${type}">
		<input type="hidden" name="productId" value="${product.id}">
	
		<form:textarea path="message" class="form-control" rows="3" placeholder="Здесь Вы можете оставить свой отзыв..."/>
		<button class="btn btn-success" onclick="addComment();" style="margin: 10px;">Добавить комментарий</button>
	</form:form>
	
</div>

<script>

function addComment(){
	$('#addComment').ajaxForm({
		type: 'post',
		success: function(comment){
			$('#comments_block').append($('<div/>').append());
		}
	}).submit();
}

</script>