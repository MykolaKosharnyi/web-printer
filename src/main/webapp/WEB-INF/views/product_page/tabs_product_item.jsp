<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
	<ul id="sub_tabs_product">
		<li><custom:getDescriptionByLocale description="${descriptions.description}"/></li>
		<li><custom:getDescriptionByLocale description="${descriptions.specifications}"/></li>
		<li><custom:getDescriptionByLocale description="${descriptions.reviews}"/></li>
		<li><custom:getDescriptionByLocale description="${descriptions.product_is_used}"/></li>
		<li><custom:getDescriptionByLocale description="${descriptions.specification_refinement}"/></li>                                      
	</ul>