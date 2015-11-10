<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="navigation">

	 <a href="<c:url value='/' />">Главная</a>
	 <span> > </span>
	 <a href="<c:url value='/printers' />">Принтеры</a>
	 <span> > </span>
	<c:forEach items="${printer.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${printer.typePrinter.equals('Сольвентный')}">
				<a href="<c:url value='/printers/dissolving' />">Сольвентные принтера</a>
			</c:when>
			<c:when test="${printer.typePrinter.equals('Экосольвентный')}">
				<a href="<c:url value='/printers/ecosolvent' />">Экосольвентные принтера</a>
			</c:when>
			<c:when test="${printer.typePrinter.equals('UV рулонный')}">
				<a href="<c:url value='/printers/UV_roll' />">UV рулонные принтера</a>
			</c:when>
			<c:when test="${printer.typePrinter.equals('UV плоскопечатный')}">
				<a href="<c:url value='/printers/UV_flatbed' />">UV плоскопечатные принтера</a>
			</c:when>
			<c:when test="${printer.typePrinter.equals('Сублимационный')}">
				<a href="<c:url value='/printers/sublimation' />">Сублимационные принтера</a>
			</c:when>
			<c:when test="${printer.typePrinter.equals('Текстильный')}">
				<a href="<c:url value='/printers/textile' />">Текстильные принтера</a>
			</c:when>
			<c:when test="${printer.typePrinter.equals('Водный/Пигментный')}">
				<a href="<c:url value='/printers/water_pigment' />">Водные/пигментные принтера</a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span> > </span>
	<p>${printer.name}</p>
</div>