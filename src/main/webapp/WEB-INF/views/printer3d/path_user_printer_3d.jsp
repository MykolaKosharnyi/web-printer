<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="navigation">

	 <a href="<c:url value='/' />">Главная</a>
	 <span> > </span>
	 <a href="<c:url value='/3d_printers' />">3D Принтеры</a>
	 <span> > </span>
	 
	 <c:forEach items="${product.typePrinter3D}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Экструдные FDM')}">
				<a href="<c:url value='/3d_printers/FDM-extruder' />">Экструдные FDM (fused deposition modeling) 3D принтера</a>
			</c:when>
			<c:when test="${tp.equals('Фото печать Polyjet')}">
				<a href="<c:url value='/3d_printers/photo_printing_polyjet' />">Фото печать Polyjet</a>
			</c:when>
			<c:when test="${tp.equals('Лазерного спекания LENS')}">
				<a href="<c:url value='/3d_printers/laser_sintering_LENS' />">3D принтеры лазерного спекания LENS (LASER ENGINEERED NET SHAPING)</a>
			</c:when>
			<c:when test="${tp.equals('Ламинация LOM')}">
				<a href="<c:url value='/3d_printers/lamination_LOM' />">Ламинация LOM (laminated object manufacturing)</a>
			</c:when>
			<c:when test="${tp.equals('Стереолитография SL')}">
				<a href="<c:url value='/3d_printers/stereolithography_SL' />">Стереолитография SL (Stereolithography)</a>
			</c:when>
			<c:when test="${tp.equals('Лазерное спекание LS')}">
				<a href="<c:url value='/3d_printers/laser_sintering_LS' />">Лазерное спекание LS (laser sintering)</a>
			</c:when>
			<c:when test="${tp.equals('Порошкового склеивания 3DP')}">
				<a href="<c:url value='/3d_printers/powder_bonding_3DP' />">Порошкового склеивания 3DP (three dimensional printing)</a>
			</c:when>
		</c:choose>
	</c:forEach>
	
	<span> > </span>
	<p>${product.name}</p>
</div>