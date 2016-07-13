<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">
	<a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<a href="<c:url value='/3d_printers' />"><spring:message code="head.3dprinter"/></a>
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	
	<c:forEach items="${search.typePrinter3D}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Экструдные FDM')}">
				<p><spring:message code="head.3dprinter.FDM-extruder"/></p>
			</c:when>
			<c:when test="${tp.equals('Фото печать Polyjet')}">
				<p><spring:message code="head.3dprinter.photo_printing_polyjet"/></p>
			</c:when>
			<c:when test="${tp.equals('Лазерного спекания LENS')}">
				<p><spring:message code="head.3dprinter.laser_sintering_LENS"/></p>
			</c:when>
			<c:when test="${tp.equals('Ламинация LOM')}">
				<p><spring:message code="head.3dprinter.lamination_LOM"/></p>
			</c:when>
			<c:when test="${tp.equals('Стереолитография SL')}">
				<p><spring:message code="head.3dprinter.stereolithography_SL"/></p>
			</c:when>
			<c:when test="${tp.equals('Лазерное спекание LS')}">
				<p><spring:message code="head.3dprinter.laser_sintering_LS"/></p>
			</c:when>
			<c:when test="${tp.equals('Порошкового склеивания 3DP')}">
				<p><spring:message code="head.3dprinter.powder_bonding_3DP"/></p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>