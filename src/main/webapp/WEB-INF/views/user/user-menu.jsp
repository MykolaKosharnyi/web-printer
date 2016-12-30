<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<style>
.user_menu {
	width: 100%;
}

.user_menu a {
	margin: 5px 0px;
	padding: 10px;
	border: 1px grey solid;
	background: #8eff5c;
	color: black;
	display: block;
	border-radius: 5px;
	font: 15px "RobotoRegular";
	font-style: italic;
	transition:0.5s;
	box-shadow: 0 0 1px #006080;
}

.user_menu a:first-child {
	margin-top: 0px;
}

.user_menu a:hover {
	background: #acf88b;
	padding:10px 0px 10px 20px;
}
</style>

<div class="user_menu">
	<a href="<c:url value='/' />">Мой кабинет</a>
	<a href="<c:url value='/' />">Мой кабинет</a>
	<a href="<c:url value='/' />">Личные данные</a>
	<a href="<c:url value='/' />">Корзина</a>
	<a href="<c:url value='/' />">Мои заказы</a>
	<a href="<c:url value='/' />">Мои отзывы</a>
	<a href="<c:url value='/' />">Просмотренные товары</a>
	<a href="<c:url value='/' />">Рассылки</a>
</div>