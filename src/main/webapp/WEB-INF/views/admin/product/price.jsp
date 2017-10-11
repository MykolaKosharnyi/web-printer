<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="characteristic">
	<div class="block_title">
		<i></i>
		<p>Цена</p>
		<form:errors path="prise" cssClass="error"></form:errors>
	</div>
	<div class="check_boxes">
		<div class="text_output">
			<p>$</p><form:input path="prise" class="amount-prise" value="${product.prise}"/>
		</div>
		<div class="slider-range-prise"></div>
	</div>
</div>
<div class="characteristic">
	<div class="block_title">
		<i></i>
		<p>Коефициент цены при покупке online</p>
		<form:errors path="buyOnlineCoefficient" cssClass="error"></form:errors>
	</div>
	<div class="check_boxes">
		<div class="text_output">
			<form:input path="buyOnlineCoefficient" value="${product.buyOnlineCoefficient}"/>
		</div>			
	</div>
</div>