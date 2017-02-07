<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

    <link href="/css/admin/datepicker/bootstrap-datetimepicker.min.css" rel="stylesheet">
	<script src="/css/admin/datepicker/bootstrap-datetimepicker.min.js"></script>

<div class="characteristic">
	<div class="block_title">
		<i></i>
		<p>Таймер на акции, в формате "dd/MM/yyyy hh:mm:ss"</p>
		<form:errors path="timeShares" cssClass="error"></form:errors>
	</div>
	<div class="check_boxes" style="padding: 5px;">
		<div id="datetimepicker" class="input-group input-append date" style="height: 25px;">
			<input data-format="dd/MM/yyyy hh:mm:ss" name="timeShares" type="text" style="height: 28px; width: 100%;"
				value="<fmt:formatDate value="${product.timeShares}" pattern="dd/MM/yyyy hh:mm:ss" />"></input>
			<span class="add-on input-group-addon"> 
				<span>Выбрать дату на календаре</span>
			</span>
		</div>
	</div>
</div>


<script type="text/javascript">
    /*
    http://tarruda.github.io/bootstrap-datetimepicker/
    */
		$(function() {
			$('#datetimepicker').datetimepicker({
				language: 'ru',
				pickTime: true,
				pickDate: true,
				startDate: new Date()
			});
		});
	</script>