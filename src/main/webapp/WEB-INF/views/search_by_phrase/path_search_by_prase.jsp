<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

<link rel="stylesheet" href="/css/search.css">
    
<style>
ul.menu {
    display: block;
}
</style> 
    
<title>Результаты поиска</title>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:if test="${!empty phrase}">
		<p>Результаты поиска по запросу: <b>${phrase}</b></p>
	</c:if>
	
	<c:if test="${empty phrase}">
		<p>Результаты поиска</p>
	</c:if>
</div>