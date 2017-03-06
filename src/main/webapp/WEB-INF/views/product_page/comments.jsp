<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div id="comments_block">

	<c:forEach items="${comments}" var="comment">
		<div class="users_comment">
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<input type="hidden" name="commentId" value="${comment.id}">
				<div class="remove_comment"><i class="fa fa-trash-o" aria-hidden="true"></i></div>
				<div class="edit_comment"><i class="fa fa-pencil"></i></div>
			</c:if>
				
			<img src="/images/users/${comment.userId}/${comment.pathUserPicture}" class="col-sm-2 img-circle" />
			<div class="col-sm-10">
				<h5 style="margin: 5px;">${comment.nameUser} ${comment.secondName}, <small><fmt:formatDate type="both" dateStyle="long" timeStyle="short" 
								value="${comment.dateWriting}" /></small></h5>
				<blockquote>
					<p style="text-indent: 0em;">${comment.message}</p>
				</blockquote>

			</div>
		</div>
	</c:forEach>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<c:url var="addCommentLink" value="/comment/add"></c:url>
		<form:form class="form-horizontal" commandName="addComment" action="${addCommentLink}" method="post">
			<input type="hidden" name="productType" value="${type}">
			<input type="hidden" name="productId" value="${product.id}">
		
			<form:textarea path="message" class="form-control" rows="3" placeholder="Здесь Вы можете оставить свой отзыв..."/>
			<a class="btn btn-success" href="javascript:void(0)" onclick="addUserComment();" style="margin: 10px;">Добавить комментарий</a>
		</form:form>
	</c:if>
	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<p class="bg-info text-center" style="padding: 25px;">Чтобы оставить комментарий нужно <a href="<c:url value='/login' />">войти</a> в систему.</p>
	</c:if>
	
	
	
	
</div>

<script>

	function addUserComment(){
		
		$('form#addComment').ajaxForm({
			type: 'post',
			success: function(comment){
				 $('<div/>').addClass('users_comment')
				.append($('<input/>').attr("type", "hidden").attr("name", "commentId").val(comment.id))
				.append($('<div/>').addClass('remove_comment').append($('<i/>').addClass('fa fa-trash-o')))
				.append($('<div/>').addClass('edit_comment').append($('<i/>').addClass('fa fa-pencil')))
				.append($('<img/>')
						.attr("src", "/images/users/" + comment.userId + "/" + comment.pathUserPicture)
						.addClass('col-sm-2 img-circle'))
				.append($('<div/>').addClass("col-sm-10")
						.append($('<h5/>').css("margin","5px")
								.html(comment.nameUser + ' ' + comment.secondName + ', <small>' + formatDate( new Date(comment.dateWriting) ) + '</small>'))
						.append($('<blockquote/>').append($('<p/>').css("text-indent","0em").text(comment.message))))
						.insertBefore( $('#comments_block').find('form') );
		
				$('#comments_block').find('form').find('textarea#message').val('');
			}
		}).submit();
	}
	
	$(document).on("click", '.remove_comment i', function(){
		var parentDiv = $(this).parent('.remove_comment').parent("div");
		var commentId = parentDiv.find("input[name='commentId']").val();
		$.ajax({
			type: 'post',
			url: "/comment/delete",
			data: commentId,
			contentType: "text/plain; charset=utf-8",			        
	        success: function (data) {
	        	if(data.result){
	        		parentDiv.remove();
				} else {
					alert('У Вас нет прав на удаление этого комментария!');
				}
	        },
		  error: function(xhr, status, error) {
			  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
		  }
		});	
		
	});
	
function formatDate(date) {
	  var monthNames = [
	    "Январь", "Февраль", "Март",
	    "Апрель", "Май", "Июнь", "Июль",
	    "Август", "Сентябрь", "Октябрь",
	    "Ноябрь", "Декабрь"
	  ];

	  var day = date.getDate();
	  var monthIndex = date.getMonth();
	  var year = date.getFullYear();
	  var hours = date.getHours();
	  var minutes = date.getMinutes();
	  if(minutes!=0 && minutes<10){
		  minutes = '0'+ minutes;
	  }

	  return day + ' ' + monthNames[monthIndex] + ' ' + year + ' г.' + ' ' + hours + ':' + minutes;
	}

</script>