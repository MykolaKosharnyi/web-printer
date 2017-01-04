<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>

<div id="product">
	<br>
	<h3>Список пользователей</h3>

		<table class="tg">
			<tr>
				<th>ID</th>
				<th>Логин</th>
				<th>Изображение</th>
				<th>Имя</th>
				<th>Фамилия</th>
				<th>Телефон</th>
				<th>Почта</th>
				<th>Компания</th>
				<th>Дата рождения</th>
				<th>Дата регистрации</th>
				<th>Удалить</th>
			</tr>
			
			<!-- fixed header 
			<tr class="fixed_header" 
			style="position: fixed;
    			top: 0px;
    			width:899px;
    			display:none;
    			background-color:white;">
				<th style="width:35px;">ID</th>
				<th style="width:130px;">Логин</th>
				<th style="width:214px;">Изображение</th>
				<th style="width:101px;">Имя</th>
				<th style="width:101px;">Фамилия</th>
				<th style="width:101px;">Телефон</th>
				<th style="width:101px;">Почта</th>
				<th style="width:101px;">Компания</th>
				<th style="width:101px;">Дата рождения</th>
				<th style="width:101px;">Дата регистрации</th>
				<th style="width:59px;">Удалить</th>
			</tr>
			-->
			<c:forEach items="${userList}" var="user">
				<tr id="${user.id}" class="output_pruduct">
					<td width="40px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.id}</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>
						<a href="<c:url value='/admin/user/edit/${user.id}' />">${user.username}</a>
					</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>
						<a href="<c:url value='/admin/user/edit/${user.id}' />">
							<img style="width: 150px;" src="/images/users/${user.id}/${user.nameUserPicture}" alt="">
						</a>
					</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.firstName}</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.lastname}</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.telephone}</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.email}</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.company}</td>
					
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>
						<fmt:formatDate type="date" dateStyle="long" timeStyle="short" value="${user.dateOfBirthDay}" />
					</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>
						<fmt:formatDate type="date" dateStyle="long" timeStyle="short" value="${user.timeRegistration}" />
					</td>
	           		
	           		
					<td width="60px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>
						<c:if test="${user.role != 'ROLE_ADMIN'}">
							<a href="<c:url value='/admin/user/remove/${user.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a>
						</c:if>
					</td>
					
				</tr>
			</c:forEach>
		</table>
</div>

<script type="text/javascript">
/*	
	var tableOffset = $("table").offset().top;
	var $header = $("table tbody tr.fixed_header");
	
	$(window).bind("scroll", function() {
	    var offset = $(this).scrollTop();
	
	    if (offset >= tableOffset) {
	    	$header.show();
	    }
	    else if (offset < tableOffset) {
	    	$header.hide();
	    }
	});
*/
</script>