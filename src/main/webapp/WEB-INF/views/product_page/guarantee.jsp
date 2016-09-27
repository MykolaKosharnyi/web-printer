<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${!empty product.guarantee}">
	<div class="commom_information"><em>Гарантия:</em><p style="padding-top: 10px;"> ${product.guarantee} месяцев официальной гарантии от производителя.</p></div>
</c:if>