<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

    <link rel="stylesheet" href="/css/user/search_cutter.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/use_with_product.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p><custom:getDescriptionByLocale description="${d_search.filter_items}"/></p>
	</div>
	<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
		<custom:getDescriptionByLocale description="${d_search.apply}"/>
	</a>
	<a class="reset" href="<c:url value='/use_with_products' />">
		<custom:getDescriptionByLocale description="${d_search.reset}"/>
	</a>
<div id="search_product">
	<c:url var="product_search" value="/use_with_products/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
		<div class="search_criteria">
			<div class="block_title">
				<i class="opened"></i>
				<p><custom:getDescriptionByLocale description="${d_search.price}"/></p>
			</div>
			<div class="check_boxes" style="display: block;">
				<div class="text_output">
					<p>$</p>
					<form:input path="prise0" class="amount-prise0" value="${search.prise0}" />
					<p>&nbsp;-&nbsp; $</p>
					<form:input path="prise1" class="amount-prise1" value="${search.prise1}" />
				</div>
				<div class="slider-range-prise"></div>
			</div>
		</div>
		<div class="search_criteria">
			<div class="block_title">
				<i></i>
				<p>Тип товара</p>
			</div>
			<ul class="check_boxes">
				<form:checkboxes items="${use_with_product.type_product}" path="typeProduct" element="li" />
			</ul>
		</div>
		
		<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
			<custom:getDescriptionByLocale description="${d_search.apply}"/>
		</a>
		<a class="reset" href="<c:url value='/use_with_products' />">
			<custom:getDescriptionByLocale description="${d_search.reset}"/>
		</a>
	</form:form>
</div>
