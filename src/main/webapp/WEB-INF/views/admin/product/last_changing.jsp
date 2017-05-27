<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page session="true"%>

<c:if test="${!empty product.dateLastChanging}">						
	Время последнего изменения: <fmt:formatDate type="both" dateStyle="long" timeStyle="short" value="${product.dateLastChanging}" />
</c:if>


