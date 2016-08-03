<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<title><spring:message code="user.title"/></title>

    <span>Роль: ${user.role.name}</span><br/>
    
    <span>Username в базе данных: ${user.username}</span><br/>
    
    <span>Пароль в базе данных: ${user.password}</span><br/>


