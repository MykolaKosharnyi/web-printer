<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
.menu {
	display: none;
}

.admin_link {
	border: 1px solid rgb(0, 96, 128);
	border-radius: 5px;
	padding: 6px;
	margin: 6px;
	position: relative;
	display: block;
	max-width: 200px;
	box-sizing: content-box;
	text-align: center;
	font-weight: bold;
	font-size: 16px;
}

.user_table {
	
}

.user_table tr td:first-child {
	font-weight: bold;
}

.user_image {
	width: 100%;
	border: 1px #006080 solid;
	padding: 2px;
	border-radius: 4px;
}

.user_image img {
	width: inherit;
}

.new_user_picture_loader {
	position: absolute;
	bottom: 3px;
	background: #006080;
	padding: 10px;
	right: 18px;
	left: 18px;
	cursor: pointer;
	text-align: center;
	opacity: 0.65;
	color: white;
	font-weight: bold;
	display:none;
}
</style>

<title><spring:message code="user.title"/></title>

<div class="user_page">
	<div class="photo_and_information_about_user">
		<div class="col-md-3">
			<div class="user_image">
				<img src="/images/user_image.png" alt="alt" />
				<div class="new_user_picture_loader">Загрузить новое изображение</div>
			</div>
		</div>
		<div class="col-md-9">
			<div class="row">
				<c:if test="${user.role == 'ROLE_ADMIN'}">
					<a class="admin_link" href="<c:url value='/admin' />">Перейти в админку</a>
				</c:if>

				<table class="table table-striped user_table">
					<tr>
						<td>Никнейм</td>
						<td>${user.username}</td>
					</tr>

					<c:if test="${!empty user.firstName}">
						<tr>
							<td>Имя</td>
							<td>${user.firstName}</td>
						</tr>
					</c:if>

					<c:if test="${!empty user.company}">
						<tr>
							<td>Компания</td>
							<td>${user.company}</td>
						</tr>
					</c:if>

					<c:if test="${!empty user.email}">
						<tr>
							<td>E-mail</td>
							<td>${user.email}</td>
						</tr>
					</c:if>

					<c:if test="${ user.telephone != 0 }">
						<tr>
							<td>Номер телефона</td>
							<td>${user.telephone}</td>
						</tr>
					</c:if>

					<c:if test="${!empty user.dateOfBirthDay}">
						<tr>
							<td>Дата рождения</td>
							<td>
								<fmt:formatDate type="date" dateStyle="long" timeStyle="short" 
								value="${user.dateOfBirthDay}" />						
							</td>
						</tr>
					</c:if>

					<c:if test="${!empty user.timeRegistration}">
						<tr>
							<td>Дата регистрации</td>							
							<td>
								<fmt:formatDate type="date" dateStyle="long" timeStyle="short" 
								value="${user.timeRegistration}" /></td>
						</tr>
					</c:if>				  
				</table>
				
			</div>
		</div>
	</div>
	
	<!--  
	<div class="user_block_products">
		<span class="title_block">Товары в корзине: </span>
	
			<div class="product">

				<img src="/images/user_image.png"alt="">
				
				<div class="infrotamaton_product">
					<a href="<c:url value='/use_with_products' />">Товар</a>
					<p><span>Цена:</span>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="34000" /></p>
				</div>
			</div>
			
			<div class="product">

				<img src="/images/user_image.png"alt="">
				
				<div class="infrotamaton_product">
					<a href="<c:url value='/use_with_products' />">Товар</a>
					<p><span>Цена:</span>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="34000" /></p>
				</div>
			</div>
			
			<div class="product">

				<img src="/images/user_image.png"alt="">
				
				<div class="infrotamaton_product">
					<a href="<c:url value='/use_with_products' />">Товар</a>
					<p><span>Цена:</span>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="34000" /></p>
				</div>
			</div>
			
			<div class="product">

				<img src="/images/user_image.png"alt="">
				
				<div class="infrotamaton_product">
					<a href="<c:url value='/use_with_products' />">Товар</a>
					<p><span>Цена:</span>$<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="34000" /></p>
				</div>
			</div>

	</div>
	-->
</div>

<script>
	$(function() {
		$('.user_image').hover(function() {
			$(this).find(".new_user_picture_loader").slideDown(500);
		}, function() {
			$(this).find(".new_user_picture_loader").slideUp(500);
		});
	});
</script>