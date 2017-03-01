<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<div id="comments_block">

	<c:forEach items="${comments}" var="comment">
		<div style="display: table;">
			<img src="/images/users/${comment.userId}/${comment.pathUserPicture}" class="col-sm-2 img-circle" style="margin-bottom: 15px;" />
			<div class="col-sm-10">
				<h5 style="margin: 5px;">${comment.nameUser} ${comment.secondName}, <small><fmt:formatDate type="both" dateStyle="long" timeStyle="short" 
								value="${comment.dateWriting}" /></small></h5>
				<blockquote>
					<p style="text-indent: 0em;">${comment.message}</p>
				</blockquote>

			</div>
		</div>
	</c:forEach>
	
	<c:url var="addCommentLink" value="/comment/add"></c:url>
	<form:form class="form-horizontal" commandName="addComment" action="${addCommentLink}" method="post">
		<input type="hidden" name="productType" value="${type}">
		<input type="hidden" name="productId" value="${product.id}">
	
		<form:textarea path="message" class="form-control" rows="3" placeholder="Здесь Вы можете оставить свой отзыв..."/>
		<a class="btn btn-success" href="javascript:void(0)" onclick="addUserComment();" style="margin: 10px;">Добавить комментарий</a>
	</form:form>
	
</div>

<script>

	function addUserComment(){
		
		$('form#addComment').ajaxForm({
			type: 'post',
			success: function(comment){
				 $('<div/>').css("display","table")
				.append($('<img/>')
						.attr("src", "/images/users/" + comment.userId + "/" + comment.pathUserPicture)
						.addClass('col-sm-2 img-circle')
						.css("margin-bottom","15px"))
				.append($('<div/>').addClass("col-sm-10")
						.append($('<h5/>').css("margin","5px")
								.html(comment.nameUser + ' ' + comment.secondName + ', <small>' + formatDate( new Date(comment.dateWriting) ) + '</small>'))
						.append($('<blockquote/>').append($('<p/>').css("text-indent","0em").text(comment.message))))
						.insertBefore( $('#comments_block').find('form') );
		
				$('#comments_block').find('form').find('textarea#message').val('');
			}
		}).submit();
	}
	
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