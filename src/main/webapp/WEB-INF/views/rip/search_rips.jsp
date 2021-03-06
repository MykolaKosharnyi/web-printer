<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

    <link rel="stylesheet" href="/css/user/search_printer.css">
    <link rel="stylesheet" href="/css/search.css">
    
	<script src="<%=request.getContextPath()%>/resources/js/user/rip.js"></script>
	
	<div id="display_search">
		<i class="opened"></i>
		<p><custom:getDescriptionByLocale description="${d_search.filter_items}"/></p>
	</div>
				<a style="margin-left:10px;" class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
					<custom:getDescriptionByLocale description="${d_search.apply}"/>
				</a>
				<a class="reset" href="<c:url value='/rips' />">
					<custom:getDescriptionByLocale description="${d_search.reset}"/>
				</a>
	<div id="search_product">
	<c:url var="product_search" value="/rips/search" ></c:url>
	<form:form method="POST" commandName="search" action="${product_search}">
		
		<jsp:include page="../search/price.jsp" />

		<c:forEach items="${rip}" var="software">		
		
	  		<div class="block_search_check">

				<input class="input_check" type="checkbox" name="typeEquipment" value="${software.type_equipment}" id="${software.type_equipment}_98">
					<label class="head_title_rip" for="${software.type_equipment}_98">${software.type_equipment}</label>
				</input>

			<div class="block_title_check" style="display: none;">
				<i></i><p><custom:getDescriptionByLocale description="${search_rip.software_manufacturer}"/>:</p>
			</div>
				
				<ul class="block_check_boxes">
					
				<c:forEach items="${software.software_maker}" var="soft_marker">	
	  				<div class="sub_rip_section">
					<input class="input_check_block" type="checkbox" name="softwareMaker" value="${soft_marker.name}" id="${software.type_equipment}_${soft_marker.name}_99">
						<label class="head_body_rip" for="${software.type_equipment}_${soft_marker.name}_99">${soft_marker.name}</label>
					</input>

				<div class="search_criteria_check">
					<div class="block_title_check_check" style="display: none;">
						<i></i><p><custom:getDescriptionByLocale description="${search_rip.software_class}"/>:</p>
					</div>
						
					<ul class="check_boxes">
					
						<c:forEach items="${soft_marker.software_class}" var="soft_class">
	  						<li>
	  							<input type="checkbox" name="softwareClass" value="${soft_class}" id="${software.type_equipment}_${soft_marker.name}_${soft_class}_17">
									<label for="${software.type_equipment}_${soft_marker.name}_${soft_class}_17">${soft_class}</label>
								</input>
							</li>	
	  					</c:forEach>

					</ul>
				  </div>
				 </div>
	  			</c:forEach>
		
			</ul>
			

		</div>


		</c:forEach>



			<a class="accept" href="javascript:void(0)" onclick="$('#search').submit();">
				<custom:getDescriptionByLocale description="${d_search.apply}"/>
			</a>
			<a class="reset" href="<c:url value='/rips' />">
				<custom:getDescriptionByLocale description="${d_search.reset}"/>
			</a>
		</form:form>
	</div>