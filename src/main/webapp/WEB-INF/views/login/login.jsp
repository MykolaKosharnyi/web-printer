<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<title><spring:message code="login.title"/></title>
<style>
.error {
	width: 100%;
	margin: 0 auto;
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	width: 100%;
	margin: 0 auto;
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 0px auto;
	margin-top:0px;
		background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}

</style>
<body onload='document.loginForm.userId.focus();'>
	<div id="login-box">
		
		<h3><spring:message code="login.head"/></h3>

		<c:if test="${not empty loginError}">
			<div class="error">${loginError}</div>
		</c:if>
		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>

		<form name='loginForm' action="<c:url value='login' />" method='POST'>

		  <table>
			<tr>
				<td><spring:message code="login.login"/>:</td>
				<td><input type='text' id="username" name='username' placeholder="user name"></td>
			</tr>
			<tr>
				<td><spring:message code="login.password"/>:</td>
				<td><input type='password' id="password" name='password' placeholder="password" /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="<spring:message code="login.log_in"/>" /></td>
			</tr>
		  </table>

		  <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />

		</form>
		</div>
	</body>