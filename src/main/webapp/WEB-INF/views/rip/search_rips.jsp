<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <link rel="stylesheet" href="/css/user/search_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/rip.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p>Фильтр товаров</p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					ПРИМЕНИТЬ
				</a>
				<a class="reset" href="<c:url value='/rips' />">
					СБРОСИТЬ
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/rips/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
		<div class="search_criteria">
			<div class="block_title">
				<i class="opened"></i>
				<p>Цена</p>
			</div>
			<ul class="check_boxes" style="display: block;">
				<div class="text_output">
					<p>$</p>
					<form:input path="prise0" class="amount-prise0" value="${search.prise0}" />
					<p>&nbsp;-&nbsp; $</p>
					<form:input path="prise1" class="amount-prise1" value="${search.prise1}" />
				</div>
				<div class="slider-range-prise"/>
			</ul>
		</div>


		<c:forEach items="${rip}" var="software">		
		
	  		<div class="block_search_check">

				<input class="input_check" type="checkbox" name="typeEquipment" value="${software.type_equipment}"></input>

			<div class="block_title_check">
				<p>${software.type_equipment}</p>
			</div>
				
				<ul class="block_check_boxes">
				
				<c:forEach items="${software.software_maker}" var="soft_marker">	
	  			
					<input class="input_check_block" type="checkbox" name="softwareMaker" value="${soft_marker.name}"></input>
				
				<div class="search_criteria_check">
					<div class="block_title_check_check">
						<p>${soft_marker.name}</p>
					</div>
						
					<ul class="check_boxes">
					
						<c:forEach items="${soft_marker.software_class}" var="soft_class">
	  						<li>
	  							<input type="checkbox" name="softwareClass" value="${soft_class}" id="${soft_class}_17">
									<label for="${soft_class}_17">${soft_class}</label>
								</input>
							</li>	
	  					</c:forEach>

					</ul>
				</div>
	
	  			</c:forEach>
		

			</ul>

		</div>


		</c:forEach>


		
	








			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				ПРИМЕНИТЬ
			</a>
			<a class="reset" href="<c:url value='/rips' />">
				СБРОСИТЬ
			</a>
		</form:form>
	</div>