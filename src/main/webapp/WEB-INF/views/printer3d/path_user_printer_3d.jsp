<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<div id="navigation">

	 <a href="<c:url value='/' />"><spring:message code="path.head_page"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 <a href="<c:url value='/3d_printers' />"><spring:message code="head.3dprinter"/></a>
	 <span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	 
	 <c:forEach items="${product.typePrinter3D}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Экструдные FDM')}">
				<a href="<c:url value='/3d_printers/FDM-extruder' />"><spring:message code="head.3dprinter.FDM-extruder"/></a>
			</c:when>
			<c:when test="${tp.equals('Фото печать Polyjet')}">
				<a href="<c:url value='/3d_printers/photo_printing_polyjet' />"><spring:message code="head.3dprinter.photo_printing_polyjet"/></a>
			</c:when>
			<c:when test="${tp.equals('Лазерного спекания LENS')}">
				<a href="<c:url value='/3d_printers/laser_sintering_LENS' />"><spring:message code="head.3dprinter.laser_sintering_LENS"/></a>
			</c:when>
			<c:when test="${tp.equals('Ламинация LOM')}">
				<a href="<c:url value='/3d_printers/lamination_LOM' />"><spring:message code="head.3dprinter.lamination_LOM"/></a>
			</c:when>
			<c:when test="${tp.equals('Стереолитография SL')}">
				<a href="<c:url value='/3d_printers/stereolithography_SL' />"><spring:message code="head.3dprinter.stereolithography_SL"/></a>
			</c:when>
			<c:when test="${tp.equals('Лазерное спекание LS')}">
				<a href="<c:url value='/3d_printers/laser_sintering_LS' />"><spring:message code="head.3dprinter.laser_sintering_LS"/></a>
			</c:when>
			<c:when test="${tp.equals('Порошкового склеивания 3DP')}">
				<a href="<c:url value='/3d_printers/powder_bonding_3DP' />"><spring:message code="head.3dprinter.powder_bonding_3DP"/></a>
			</c:when>
		</c:choose>
	</c:forEach>
	
	<span><i class="fa fa-long-arrow-right" aria-hidden="true"></i></span>
	<p>${product.name}</p>
</div>