<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>

<title>Список пользователей</title>
<div id="product">
	<a href="<c:url value='/admin/user/new' />">Добавить нового пользователя в базу данных</a>
	<br>
	<h3>Список зарегистрированных пользователей</h3>

		<table class="tg">
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">Изображение</th>
				<th class="text-center">Имя</th>
				<th class="text-center">Фамилия</th>
				<th class="text-center" style="min-width: 128px;">Телефон</th>
				<th class="text-center">Почта</th>
				<th class="text-center">Дата регистрации</th>
				<th class="text-center">Удалить</th>
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
						<a href="<c:url value='/admin/user/edit/${user.id}' />">
							<img style="width: 150px;" src="/images/users/${user.id}/${user.nameUserPicture}" alt="">
						</a>
					</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>
						<a href="<c:url value='/admin/user/edit/${user.id}' />">${user.firstName}</a>
					</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.lastname}</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.telephone}</td>
					<td width="120px" <c:if test="${user.role == 'ROLE_ADMIN'}">style="background: #ffd6d6;"</c:if>>${user.email}</td>
					
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
		
		
		<h3>Список добавленных пользователей</h3>

		<table class="tg">
			<tr>
				<th class="text-center">ID</th>
				<th class="text-center">Имя</th>
				<th class="text-center">Фамилия</th>
				<th class="text-center">Телефон</th>
				<th class="text-center">Почта</th>
				<th class="text-center">Дата регистрации</th>
				<th class="text-center">Удалить</th>
			</tr>
			
			<c:forEach items="${user_add_by_admin_List}" var="user">
				<tr id="${user.id}" class="output_pruduct">
					<td width="40px">${user.id}</td>
					<td width="120px">
						<a href="<c:url value='/admin/user_add_by_admin/edit/${user.id}' />">${user.firstName}</a>
					</td>
					<td width="120px">
						<a href="<c:url value='/admin/user_add_by_admin/edit/${user.id}' />">${user.lastname}</a>
					</td>
					<td width="120px">${user.telephone}</td>
					<td width="120px">${user.email}</td>
					
					<td width="120px">
						<fmt:formatDate type="date" dateStyle="long" timeStyle="short" value="${user.timeRegistration}" />
					</td>
	           			           		
					<td width="60px">						
						<a href="<c:url value='/admin/user_add_by_admin/remove/${user.id}' />"><i class="fa fa-trash-o remove" aria-hidden="true"></i></a>
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