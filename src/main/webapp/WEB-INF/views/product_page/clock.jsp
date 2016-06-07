<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="now" class="java.util.Date" />
<c:if test="${ product.timeShares.getTime() - now.getTime() > 0 && (product.timeSharesText!=null && product.timeSharesText!='')}">
	<div class="outer_div_clock">	
		<div id="clock"></div>
		<div class="description_clock">${product.timeSharesText}</div>
	</div>
</c:if>