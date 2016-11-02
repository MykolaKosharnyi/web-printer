<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<title><spring:message code="login.title"/></title>

<div class="login-container">

    <form:form method="POST" modelAttribute="userForm" action="/login" class="form-horizontal">
        <h2 class="form-heading"><spring:message code="login.head"/></h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <div class="input-group input-sm">
                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                <spring:message code='login.login' var="loginLogin"/>
            	<form:input path="username" type="text" class="form-control" placeholder="${loginLogin}" autofocus="true"/>
            </div>
            <div class="input-group input-sm">
                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                <spring:message code='login.password' var="loginPassword"/>
            	<form:input path="password" type="password" class="form-control" placeholder="${loginPassword}"/>
            </div>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="login.log_in"/></button>
            <h4 class="text-center"><a href="${contextPath}/registration"><spring:message code="login.create_an_account"/></a></h4>
        </div>

    </form:form>
 </div>