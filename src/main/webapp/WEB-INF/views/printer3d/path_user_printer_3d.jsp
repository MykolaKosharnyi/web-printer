<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">

	 <a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/3d_printers' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d}"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 
	 <c:forEach items="${product.typePrinter3D}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Экструдные FDM')}">
				<a href="<c:url value='/3d_printers/FDM-extruder' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_FDM_extruder}"/></a>
			</c:when>
			<c:when test="${tp.equals('Фото печать Polyjet')}">
				<a href="<c:url value='/3d_printers/photo_printing_polyjet' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_photo_printing_polyjet}"/></a>
			</c:when>
			<c:when test="${tp.equals('Лазерного спекания LENS')}">
				<a href="<c:url value='/3d_printers/laser_sintering_LENS' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LENS}"/></a>
			</c:when>
			<c:when test="${tp.equals('Ламинация LOM')}">
				<a href="<c:url value='/3d_printers/lamination_LOM' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_lamination_LOM}"/></a>
			</c:when>
			<c:when test="${tp.equals('Стереолитография SL')}">
				<a href="<c:url value='/3d_printers/stereolithography_SL' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_stereolithography_SL}"/></a>
			</c:when>
			<c:when test="${tp.equals('Лазерное спекание LS')}">
				<a href="<c:url value='/3d_printers/laser_sintering_LS' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LS}"/></a>
			</c:when>
			<c:when test="${tp.equals('Порошкового склеивания 3DP')}">
				<a href="<c:url value='/3d_printers/powder_bonding_3DP' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d_powder_bonding_3DP}"/></a>
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