<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div class="hidden">
	<form id="callback" class="pop_form">
		<h5 style="max-width: 300px;">Пожалуйста оставьте координаты, через некоторое время мы с вами свяжемся</h5>
		<input type="hidden" name="id" value="${product.id}">
		<input type="hidden" name="typeProduct" value="${type}">
		<input type="text" name="name" placeholder="Ваше имя..." required />
		<input type="text" name="phone" placeholder="Ваше телефон..." required />
		<button class="button" type="submit">Уточнить</button>
	</form>
</div>
<script type="text/javascript">
	$(function () {
		var austDay = new Date();
		austDay = new Date(${product.timeShares.getTime()});
		$('#clock').countdown({until: austDay});
	});
</script>