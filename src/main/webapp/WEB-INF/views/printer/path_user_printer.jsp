<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="navigation">

	 <a href="<c:url value='/' />">Главная</a>
	 <span> > </span>
	 <a href="<c:url value='/printers' />">Принтеры</a>
	 <span> > </span>
	<c:forEach items="${product.typePrinter}" var="tp">
		<c:choose>
			<c:when test="${product.typePrinter.equals('Сольвентный')}">
				<a href="<c:url value='/printers/dissolving' />">Сольвентные принтеры</a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Экосольвентный')}">
				<a href="<c:url value='/printers/ecosolvent' />">Экосольвентные принтеры</a>
			</c:when>
			<c:when test="${product.typePrinter.equals('UV рулонный')}">
				<a href="<c:url value='/printers/UV_roll' />">UV рулонные принтеры</a>
			</c:when>
			<c:when test="${product.typePrinter.equals('UV плоскопечатный')}">
				<a href="<c:url value='/printers/UV_flatbed' />">UV плоскопечатные принтеры</a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Сублимационный')}">
				<a href="<c:url value='/printers/sublimation' />">Сублимационные принтеры</a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Текстильный')}">
				<a href="<c:url value='/printers/textile' />">Текстильные принтеры</a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Водный/Пигментный')}">
				<a href="<c:url value='/printers/water_pigment' />">Водные/пигментные принтеры</a>
			</c:when>
			<c:when test="${product.typePrinter.equals('Цифровый')}">
				<a href="<c:url value='/printers/digital' />">Цифровые принтеры</a>
			</c:when>
			<c:when test="${product.typePrinter.equals('САПР/ГИС')}">
				<a href="<c:url value='/printers/SAPR-GIS' />">САПР/ГИС принтеры</a>
			</c:when>
		</c:choose>
	</c:forEach>
	<span> > </span>
	<p>${product.name}</p>
</div>