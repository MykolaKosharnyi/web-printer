<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<div id="navigation">
	<a href="<c:url value='/' />"><custom:getDescriptionByLocale description="${descriptions.path_head_page}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/3d_printers' />"><custom:getDescriptionByLocale description="${descriptions.printers_3d}"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typePrinter3D}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Экструдные FDM')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printers_3d_FDM_extruder}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printers_3d_FDM_extruder}"/></title>
			</c:when>
			<c:when test="${tp.equals('Фото печать Polyjet')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printers_3d_photo_printing_polyjet}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printers_3d_photo_printing_polyjet}"/></title>
			</c:when>
			<c:when test="${tp.equals('Лазерного спекания LENS')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LENS}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LENS}"/></title>
			</c:when>
			<c:when test="${tp.equals('Ламинация LOM')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printers_3d_lamination_LOM}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printers_3d_lamination_LOM}"/></title>
			</c:when>
			<c:when test="${tp.equals('Стереолитография SL')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printers_3d_stereolithography_SL}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printers_3d_stereolithography_SL}"/></title>
			</c:when>
			<c:when test="${tp.equals('Лазерное спекание LS')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LS}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printers_3d_laser_sintering_LS}"/></title>
			</c:when>
			<c:when test="${tp.equals('Порошкового склеивания 3DP')}">
				<p><custom:getDescriptionByLocale description="${descriptions.printers_3d_powder_bonding_3DP}"/></p>
				<title><custom:getDescriptionByLocale description="${descriptions.printers_3d_powder_bonding_3DP}"/></title>
			</c:when>
		</c:choose>
	</c:forEach>
</div>