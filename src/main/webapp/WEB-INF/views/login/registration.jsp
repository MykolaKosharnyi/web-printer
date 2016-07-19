<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<title><spring:message code="login.registration.title"/></title>

     <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading"><spring:message code="login.registration.head"/></h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
				<spring:message code='login.login' var="loginLogin"/>
                <form:input type="text" path="username" class="form-control" placeholder="${loginLogin}"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
				<spring:message code='login.password' var="loginPassword"/>
                <form:input type="password" path="password" class="form-control" placeholder="${loginPassword}"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
				<spring:message code='login.password_confirm' var="loginPasswordConfirm"/>
                <form:input type="password" path="passwordConfirm" class="form-control" placeholder="${loginPasswordConfirm}"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code='login.registration.submit'/></button>
    </form:form>