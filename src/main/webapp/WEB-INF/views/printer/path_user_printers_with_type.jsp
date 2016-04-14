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
				<p>Сольвентные принтеры</p>
			</c:when>
			<c:when test="${tp.equals('Экосольвентный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Экосольвентные принтеры</p>
			</c:when>
			<c:when test="${tp.equals('UV рулонный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>UV рулонные принтеры</p>
			</c:when>
			<c:when test="${tp.equals('UV плоскопечатный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>UV плоскопечатные принтеры</p>
			</c:when>
			<c:when test="${tp.equals('Сублимационный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Сублимационные принтеры</p>
			</c:when>
			<c:when test="${tp.equals('Текстильный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Текстильные принтеры</p>
			</c:when>
			<c:when test="${tp.equals('Водный/Пигментный')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Водные/пигментные принтеры</p>
			</c:when>
			<c:when test="${tp.equals('Цифровый')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>Цифровые принтеры</p>
			</c:when>
			<c:when test="${tp.equals('САПР/ГИС')}">
				<a href="<c:url value='/printers' />">Принтеры</a>
				<span> > </span>
				<p>САПР/ГИС принтеры</p>
			</c:when>
		</c:choose>
	</c:forEach>
</div>