<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">

	 <a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/scanners' />"><custom:getDescriptionByLocale description="${descriptions.scanners}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<c:forEach items="${product.typeProduct}" var="tp">
		<c:choose>
			<c:when test="${product.typeProduct.equals('Широкоформатные сканеры')}">
				<a href="<c:url value='/scanners/large_format_scanners' />"><custom:getDescriptionByLocale description="${descriptions.scanners_large_format_scanners}"/></a>
			</c:when>
			
			<c:when test="${product.typeProduct.equals('3D Сканеры')}">
				<a href="<c:url value='/scanners/3d_scanners' />"><custom:getDescriptionByLocale description="${descriptions.scanners_3d_scanners}"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
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