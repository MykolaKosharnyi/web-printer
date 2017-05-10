<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<title><spring:message code="login.registration.title"/></title>

<div class="login-container">

     <form:form method="POST" modelAttribute="userForm" class="form-horizontal">
        <h2 class="form-signin-heading"><spring:message code="login.registration.head"/></h2>
        
       	<spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<div class="input-group input-sm neccessary_for_registration">
	                <label class="input-group-addon" for="email"><i class="fa fa-envelope-o"></i></label>
	                <spring:message code='login.email' var="email"/>
	                <form:input type="text" path="email" class="form-control" placeholder="${email}"></form:input>
	            </div>
	            <form:errors path="email"></form:errors>
	            <p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
				<p class="bg-success info_of_checking_email">Введенный e-mail корректен!</p>
			  	<p class="bg-danger info_of_checking_email">E-mail не корректен!</p>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<div class="input-group input-sm neccessary_for_registration">
	                <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
	            	<spring:message code='login.password' var="loginPassword"/>
	                <form:input type="password" path="password" class="form-control" placeholder="${loginPassword}"></form:input>
	            </div>
	            <form:errors path="password"></form:errors>
	            <p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<div class="input-group input-sm neccessary_for_registration">
	                <label class="input-group-addon" for="passwordConfirm"><i class="fa fa-lock"></i></label>
	            	<spring:message code='login.password_confirm' var="loginPasswordConfirm"/>
	                <form:input type="password" path="passwordConfirm" class="form-control" placeholder="${loginPasswordConfirm}"></form:input>
	            </div>
	            <form:errors path="passwordConfirm"></form:errors>
	            <p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
            </div>        
        </spring:bind>
        
        <hr>
        
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<div class="input-group input-sm neccessary_for_registration">
	                <label class="input-group-addon" for="firstName"><i class="fa fa-user"></i></label>
	                <spring:message code='login.firstName' var="firstName"/>
	                <form:input type="text" path="firstName" class="form-control" placeholder="${firstName}"></form:input>
	            </div>
	            <form:errors path="firstName"></form:errors>
	            <p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
            </div>
        </spring:bind>
        
        <spring:bind path="lastname">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<div class="input-group input-sm neccessary_for_registration">
	                <label class="input-group-addon" for="lastname"><i class="fa fa-user"></i></label>
	                <spring:message code='login.lastname' var="lastname"/>
	                <form:input type="text" path="lastname" class="form-control" placeholder="${lastname}"></form:input>
	            </div>
	            <form:errors path="lastname"></form:errors>
	            <p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
            </div>
        </spring:bind>
        
        <spring:bind path="telephone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<div class="input-group input-sm neccessary_for_registration">
	                <label class="input-group-addon" for="telephone"><i class="fa fa-phone"></i></label>
	                <spring:message code='login.telephone' var="telephone"/>
	                <form:input type="text" path="telephone" class="form-control" placeholder="${telephone}"></form:input>
	            </div>
	            <form:errors path="telephone"></form:errors>
	            <p class="bg-danger info_of_empty_field">Поле должно быть заполнено.</p>
            </div>
        </spring:bind>
        
        <spring:bind path="company">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<div class="input-group input-sm">
	                <label class="input-group-addon" for="company"><i class="fa fa-building-o"></i></label>
	                <spring:message code='login.company' var="company"/>
	                <form:input type="text" path="company" class="form-control" placeholder="${company}"></form:input>
	            </div>
	            <form:errors path="company"></form:errors>
            </div>
        </spring:bind>    
        
        <spring:bind path="dateOfBirthDay">
            <div class="form-group ${status.error ? 'has-error' : ''}">
            	<div class="input-group input-sm">
	                <label class="input-group-addon" for="dateOfBirthDay"><i class="fa fa-calendar"></i></label>
	                <spring:message code='login.dateOfBirthDay' var="dateOfBirthDay"/>
	                <form:input type="datetime" path="dateOfBirthDay" class="form-control" placeholder="${dateOfBirthDay}"></form:input>
	            </div>
	            <form:errors path="dateOfBirthDay"></form:errors>
            </div>
        </spring:bind>

    </form:form>
    <button class="btn btn-lg btn-primary btn-block" id="submit_registration_button"><spring:message code='login.registration.submit'/></button>
    
 </div>
 
