<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="navigation">
	<a href="<c:url value='/' />">Главная</a>
	<span> > </span>
	<a href="<c:url value='/3d_printers' />">3D Принтеры</a>
	<span> > </span>
	
	<c:forEach items="${search.typePrinter3D}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Экструдные FDM')}">
				<p>Экструдные FDM (fused deposition modeling) 3D принтера</p>
			</c:when>
			<c:when test="${tp.equals('Фото печать Polyjet')}">
				<p>Фото печать Polyjet</p>
			</c:when>
			<c:when test="${tp.equals('Лазерного спекания LENS')}">
				<p>3D принтеры лазерного спекания LENS (LASER ENGINEERED NET SHAPING)</p>
			</c:when>
			<c:when test="${tp.equals('Ламинация LOM')}">
				<p>Ламинация LOM (laminated object manufacturing)</p>
			</c:when>
			<c:when test="${tp.equals('Стереолитография SL')}">
				<p>Стереолитография SL (Stereolithography)</p>
			</c:when>
			<c:when test="${tp.equals('Лазерное спекание LS')}">
				<p>Лазерное спекание LS (laser sintering)</p>
			</c:when>
			<c:when test="${tp.equals('Порошкового склеивания 3DP')}">
				<p>Порошкового склеивания 3DP (three dimensional printing)</p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>