<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="output_description">
	<c:choose>   
         <c:when test = "${localeCode == 'en' && !empty product.descriptionEng}">
            ${product.descriptionEng}
         </c:when>
         
         <c:when test = "${localeCode == 'ru'}">
            ${product.description}
         </c:when>
         
         <c:otherwise>
            ${product.description}
         </c:otherwise>
	</c:choose>
</div>