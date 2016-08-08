<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<title><spring:message code="user.title"/></title>

<div class="user_page">
	<div class="photo_and_information_about_user">
		<div class="col-md-4">
			<div class="row">
				<img src="/images/user_image.png" alt="alt" />
			</div>
		</div>
		<div class="col-md-8">
			<div class="row">
				 <c:if test="${user.role == 'ROLE_ADMIN'}">
   					<a href="<c:url value='/admin' />">Перейти в админку</a><br/>
				</c:if>
    
			    <span class="bold_user_description">Имя в базе данных: </span><span>${user.username}</span><br/>
			    
			    <span class="bold_user_description">Пароль в базе данных: </span><span>${user.password}</span><br/>
			    
			    <span class="bold_user_description">Компания: </span><span>${user.company}</span><br/>
			    
			    <span class="bold_user_description">E-mail: </span><span>${user.email}</span><br/>
			    
			    <span class="bold_user_description">Номер телефона: </span><span>${user.telephone}</span><br/>
			    
			    <span class="bold_user_description">Дата рождения: </span><span>${user.dateOfBirthDay}</span><br/>
			    
			    <span class="bold_user_description">Дата регистрации: </span><span>${user.timeRegistration}</span><br/>
			</div>
		</div>
	</div>
	
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
	
</div>