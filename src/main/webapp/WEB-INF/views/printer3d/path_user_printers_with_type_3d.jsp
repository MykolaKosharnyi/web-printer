<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="navigation">
	<a href="<c:url value='/' />">Главная</a>
	<span> > </span>
	<a href="<c:url value='/printers_3d' />">3D Принтеры</a>
	<span> > </span>
	
	<c:forEach items="${search.typePrinter3D}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Экструдные FDM')}">
				<p>Экструдные FDM 3D принтера</p>
			</c:when>
			<c:when test="${tp.equals('Фото печать Polyjet')}">
				<p>Фото печать Polyjet</p>
			</c:when>
			<c:when test="${tp.equals('Лазерного спекания LENS')}">
				<p>3D принтеры лазерного спекания LENS</p>
			</c:when>
			<c:when test="${tp.equals('Ламинация LOM')}">
				<p>Ламинация LOM</p>
			</c:when>
			<c:when test="${tp.equals('Стереолитография SL')}">
				<p>Стереолитография SL</p>
			</c:when>
			<c:when test="${tp.equals('Лазерное спекание LS')}">
				<p>Лазерное спекание LS</p>
			</c:when>
			<c:when test="${tp.equals('Порошкового склеивания 3DP')}">
				<p>Порошкового склеивания 3DP</p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>