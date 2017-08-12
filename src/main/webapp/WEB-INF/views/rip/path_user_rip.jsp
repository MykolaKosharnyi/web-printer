<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	 <a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/rips' />"><custom:getDescriptionByLocale description="${descriptions.rips}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <p>
		<c:choose>   
	         <c:when test = "${localeCode == 'en' && !empty product.engNameProduct}">
	            ${product.engNameProduct}
	         </c:when>
	         
	         <c:otherwise>
	            ${product.name}
	         </c:otherwise>
		</c:choose>
	</p>
</div>