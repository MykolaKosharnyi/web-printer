<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="output_description">
	<c:set var="localeCode" value="${pageContext.response.locale}" />
					   
	<c:if test="${localeCode == 'en'}">
		${product.descriptionEng}
	</c:if>
	<c:if test="${localeCode == 'ru'}">
		${product.description}
	</c:if>
</div>