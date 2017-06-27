<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

<c:if test="${!empty product.guarantee}">
	<div class="commom_information"><em><custom:getDescriptionByLocale description="${descriptions.guarantee}"/>:</em>
	<p style="padding-top: 10px;"> ${product.guarantee} <custom:getDescriptionByLocale description="${descriptions.guarantee_month}"/></p></div>
</c:if>