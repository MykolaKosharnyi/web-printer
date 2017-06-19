<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/user' />"><spring:message code="path.user"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p><spring:message code="path.user.subscription"/></p>
</div>