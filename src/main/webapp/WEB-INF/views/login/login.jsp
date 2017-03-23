<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<title><spring:message code="login.title"/></title>

<div class="login-container">

    <form method="POST" action="/login" class="form-horizontal">
        <h2 class="form-heading"><spring:message code="login.head"/></h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <div class="input-group input-sm">
                <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                <spring:message code='login.login' var="loginLogin"/>
            	<input name="username" type="text" class="form-control" placeholder="${loginLogin}" autofocus/>
            </div>
            <div class="input-group input-sm">
                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label> 
                <spring:message code='login.password' var="loginPassword"/>
            	<input name="password" type="password" class="form-control" placeholder="${loginPassword}"/>
            </div>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit"><spring:message code="login.log_in"/></button>
            <h4 class="text-center"><a href="${contextPath}/registration"><spring:message code="login.create_an_account"/></a></h4>
        </div>

    </form>
 </div>