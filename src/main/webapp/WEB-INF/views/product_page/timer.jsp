<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<script type="text/javascript">
	$(function () {
		var austDay = new Date();
		austDay = new Date(${product.timeShares.getTime()});
		$('#clock').countdown({until: austDay, format: 'D H M'});
	});
</script>