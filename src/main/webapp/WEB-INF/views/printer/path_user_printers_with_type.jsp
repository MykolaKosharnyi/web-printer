<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="navigation">
	<a href="<c:url value='/' />">Главная</a>
	<span> > </span>

	<c:forEach items="${search.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${tp.equals('Сольвентный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Сольвентные принтера</p>
			</c:when>
			<c:when test="${tp.equals('Экосольвентный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Экосольвентные принтера</p>
			</c:when>
			<c:when test="${tp.equals('UV рулонный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>UV рулонные принтера</p>
			</c:when>
			<c:when test="${tp.equals('UV плоскопечатный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>UV плоскопечатные принтера</p>
			</c:when>
			<c:when test="${tp.equals('Сублимационный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Сублимационные принтера</p>
			</c:when>
			<c:when test="${tp.equals('Текстильный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Текстильные принтера</p>
			</c:when>
			<c:when test="${tp.equals('Водный/Пигментный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Водные/пигментные принтера</p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>