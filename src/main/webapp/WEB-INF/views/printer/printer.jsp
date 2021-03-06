<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/product.css"/>
	
	<script src="<%=request.getContextPath()%>/resources/js/user/product.js"></script>
	<title>
		<c:choose>   
	         <c:when test = "${localeCode == 'en' && !empty product.engNameProduct}">
	            ${product.engNameProduct}
	         </c:when>
	         
	         <c:otherwise>
	            ${product.name}
	         </c:otherwise>
		</c:choose>
	</title>
</head>
<body>   
         <div class="product">
            <div id="pictures_and_descriptions">
            
            	<div class="pictures-and-rating">
            	
            		<!-- import pictures presentation -->
					<jsp:include page="../product_page/pictures.jsp" />
					
					<div class="rating">
					
						<c:if test="${product.ratingPrintQuality > 0}">
							<!-- Качество печати -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_print_quality}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingPrintQuality"></label>
								
								    <input id="star-4-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingPrintQuality"></label>
								
								    <input id="star-3-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingPrintQuality"></label>
								
								    <input id="star-2-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingPrintQuality"></label>
								
								    <input id="star-1-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingPrintQuality"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingPrintSpeed > 0}">
							<!-- Скорость печати -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_print_speed}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingPrintSpeed"></label>
								
								    <input id="star-4-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingPrintSpeed"></label>
								
								    <input id="star-3-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingPrintSpeed"></label>
								
								    <input id="star-2-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingPrintSpeed"></label>
								
								    <input id="star-1-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingPrintSpeed"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingStablePerformance > 0}">
							<!-- Стабильность работы -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_stability_work}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingStablePerformance"></label>
								
								    <input id="star-4-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingStablePerformance"></label>
								
								    <input id="star-3-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingStablePerformance"></label>
								
								    <input id="star-2-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingStablePerformance"></label>
								
								    <input id="star-1-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingStablePerformance"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingEaseOfUse > 0}">
							<!-- Простота эксплуатации -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_ease_operation}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingEaseOfUse"></label>
								
								    <input id="star-4-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingEaseOfUse"></label>
								
								    <input id="star-3-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingEaseOfUse"></label>
								
								    <input id="star-2-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingEaseOfUse"></label>
								
								    <input id="star-1-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingEaseOfUse"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingReliabilityAssembly > 0}">
							<!-- Надёжность сборки -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_reliability_assembly}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingReliabilityAssembly"></label>
								
								    <input id="star-4-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingReliabilityAssembly"></label>
								
								    <input id="star-3-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingReliabilityAssembly"></label>
								
								    <input id="star-2-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingReliabilityAssembly"></label>
								
								    <input id="star-1-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingReliabilityAssembly"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingLifetime > 0}">
							<!-- Срок эксплуатации -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_lifetime}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingLifetime"></label>
								
								    <input id="star-4-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingLifetime"></label>
								
								    <input id="star-3-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingLifetime"></label>
								
								    <input id="star-2-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingLifetime"></label>
								
								    <input id="star-1-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingLifetime"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingPreventiveMaintenanceCost > 0}">
							<!-- Стоимость профилактического обслуживания -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_сost_preventive_maintenance}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingPreventiveMaintenanceCost"></label>
								
								    <input id="star-4-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingPreventiveMaintenanceCost"></label>
								
								    <input id="star-3-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingPreventiveMaintenanceCost"></label>
								
								    <input id="star-2-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingPreventiveMaintenanceCost"></label>
								
								    <input id="star-1-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingPreventiveMaintenanceCost"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingTheCostOfSpareParts > 0}">
							<!-- Стоимость запчастей -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_сost_spare_parts}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingTheCostOfSpareParts"></label>
								
								    <input id="star-4-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingTheCostOfSpareParts"></label>
								
								    <input id="star-3-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingTheCostOfSpareParts"></label>
								
								    <input id="star-2-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingTheCostOfSpareParts"></label>
								
								    <input id="star-1-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingTheCostOfSpareParts"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingTheCostOfConsumables > 0}">
							<!-- Стоимость расходных материалов -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_сost_consumables}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingTheCostOfConsumables"></label>
								
								    <input id="star-4-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingTheCostOfConsumables"></label>
								
								    <input id="star-3-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingTheCostOfConsumables"></label>
								
								    <input id="star-2-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingTheCostOfConsumables"></label>
								
								    <input id="star-1-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingTheCostOfConsumables"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingTheCostOfOriginalInk > 0}">
							<!-- Стоимость оригинальных чернил -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_сost_original_ink}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingTheCostOfOriginalInk"></label>
								
								    <input id="star-4-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingTheCostOfOriginalInk"></label>
								
								    <input id="star-3-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingTheCostOfOriginalInk"></label>
								
								    <input id="star-2-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingTheCostOfOriginalInk"></label>
								
								    <input id="star-1-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingTheCostOfOriginalInk"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingCostOfPrinting > 0}">
							<!-- Себестоимость печати -->
							<div class="rating_block">
								<p><custom:getDescriptionByLocale description="${descriptions.overall_rating_сost_printing}"/></p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 5}">checked</c:if> value="5"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" for="star-5-ratingCostOfPrinting"></label>
								
								    <input id="star-4-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 4}">checked</c:if> value="4"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>" for="star-4-ratingCostOfPrinting"></label>
								
								    <input id="star-3-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 3}">checked</c:if> value="3"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" for="star-3-ratingCostOfPrinting"></label>
								
								    <input id="star-2-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 2}">checked</c:if> value="2"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" for="star-2-ratingCostOfPrinting"></label>
								
								    <input id="star-1-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 1}">checked</c:if> value="1"/>
								    <label title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>" for="star-1-ratingCostOfPrinting"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingOverallRating > 0}">
							<!-- Общая оценка -->
							<div class="rating_block">
								<p style="font-weight: bold;"><custom:getDescriptionByLocale description="${descriptions.overall_rating}"/></p>
								<div style="width: 100px; float: left;">
									<ul class="rating_average clearfix">
										<li class="current" style="width: ${product.ratingOverallRating * 20}%;"><span class="star1" title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_bad}'/>"></span></li>
										<li><span class="star2" title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_below_the_average}'/>" ></span></li>
										<li><span class="star3" title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_medium}'/>" ></span></li>
										<li><span class="star4" title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_good}'/>"  ></span></li>
										<li><span class="star5" title="<custom:getDescriptionByLocale description='${descriptions.overall_rating_very_good}'/>" ></span></li>
									</ul>
								</div>
							</div>
						</c:if>
						
					</div>
            	</div>
				
                <div class="descriptions">
 			
 				<!-- import timer -->
				<jsp:include page="../product_page/clock.jsp" />
					
                <div id="name_product_head_description">
		<c:choose>   
	         <c:when test = "${localeCode == 'en' && !empty product.engNameProduct}">
	            ${product.engNameProduct}
	         </c:when>
	         
	         <c:otherwise>
	            ${product.name}
	         </c:otherwise>
		</c:choose>
	</div>
                	
                <c:if test="${!empty product.partNumber}">
                	<div id="name_product_head_description"><custom:getDescriptionByLocale description="${d_search.product_code}"/>: ${product.partNumber}</div>
				</c:if>
					
					<div class="outer_table_in_head">
	                    <table id="table_in_head">
	                       <caption></caption> 
	                       <!-- set price in table row -->
						   <jsp:include page="../product_page/price.jsp" />                
						   
	                       <c:if test="${!empty product.typePrinter}">
	   							<tr><td><custom:getDescriptionByLocale description="${search_printer.printer_type}"/>:</td>
	   							<td><custom:singleProperty productValue="${product.typePrinter}" properties="${printer.type_printer}"/></td></tr>
						   </c:if>
						   
	                       <c:if test="${!empty product.equipmentModel}">
	   							<tr><td><custom:getDescriptionByLocale description="${d_search.model}"/>:</td>
	   							<td>${product.equipmentModel}</td></tr>
						   </c:if>
						   
	                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
	   							<tr>
	   								<td><custom:getDescriptionByLocale description="${search_printer.printing_width}"/>:</td>
	   								<td>${product.inputFirstWeightPrintMM}
	   								<c:if test="${product.inputSecondWeightPrintMM!=0}"> x ${product.inputSecondWeightPrintMM}</c:if> <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
							</c:if>
	                       
	                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.weightPrintMM > 0}">
	   							<tr>
	   								<td><custom:getDescriptionByLocale description="${search_printer.printing_width}"/>:</td>
	   								<td>${product.weightPrintMM} <custom:getDescriptionByLocale description="${d_search.mm}"/></td>
	   							</tr>
							</c:if>
	                  </table>
                  </div>
                  
                    <!-- import opportunity add to product's price, price for different services -->
				    <jsp:include page="../product_page/option_product_with_price.jsp" />
				
				    <!-- import availability of this product -->
				    <jsp:include page="../product_page/availability.jsp" />
				    
				    <!-- import guarantee of this product -->
				    <jsp:include page="../product_page/guarantee.jsp" />
                 
                </div>
            </div>
            <div id="tabs_product">
            
            	<!-- import tabs like description, specification, reviews etc. -->
				<jsp:include page="../product_page/tabs_product_item.jsp" />
            
                <div>
                    
                    <!-- description on concrete language to this product -->
                    <jsp:include page="../product_page/description.jsp" />
                    
                    <div class="descriptions">
					<table>
                       
                       <c:if test="${!empty product.typePrinter}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.printer_type}"/>:</td>
   							<td><custom:singleProperty productValue="${product.typePrinter}" properties="${printer.type_printer}"/></td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.product_code}"/>:</td>
   							<td>${product.partNumber}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.equipmentModel}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.model}"/>:</td>
   							<td>${product.equipmentModel}</td></tr>
					   </c:if>
                       
                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.printing_width}"/>:</td>
   							<td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}"> x ${product.inputSecondWeightPrintMM}</c:if> <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
					   </c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.weightPrintMM > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.printing_width}"/>:</td>
   							<td>${product.weightPrintMM} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
					   </c:if>
					   
					   <c:if test="${!empty product.printingExtension}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.printing_extension}"/>:</td>
   							<td>${product.printingExtension} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.сondition_equipment}"/>:</td>
   							<td><custom:singleProperty productValue="${product.previouslyUsed}" properties="${printer.previously_used}"/></td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.typePrint}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.type_print}"/>:</td>
   							<td><custom:singleProperty productValue="${product.typePrint}" properties="${printer.type_print}"/></td></tr>
						</c:if>
						
						<c:if test="${(product.lengthWaveUVlamp > 0) || (product.powerUVlamp > 0) || 
                      					(product.lengthWaveLEDmodule > 0) || (product.powerLEDmodule > 0) }">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.UV_block}"/>:</td>
   								<td>
   								
   								<c:if test="${(product.lengthWaveUVlamp > 0) || (product.powerUVlamp > 0)}">
   									<custom:getDescriptionByLocale description="${search_printer.UV_block_lamp}"/>:
   									<br/>
   									<c:if test="${product.lengthWaveUVlamp > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.UV_block_wave_length}"/> ${product.lengthWaveUVlamp} <custom:getDescriptionByLocale description="${d_search.nm}"/>;</c:if>
   									<br/>
   									<c:if test="${product.powerUVlamp > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.UV_block_UV_radiation}"/> ${product.powerUVlamp} <custom:getDescriptionByLocale description="${d_search.w}"/>;</c:if>
   									<br/>
   									<c:if test="${product.quantityUVlamp > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.UV_block_quantity}"/> ${product.quantityUVlamp} <custom:getDescriptionByLocale description="${d_search.pc}"/>;</c:if>
   									<br/>
								</c:if>
								
								<c:if test="${(product.lengthWaveLEDmodule > 0) || (product.powerLEDmodule > 0)}">
   									<custom:getDescriptionByLocale description="${search_printer.UV_block_LED_module}"/>:
   									<br/>
   									<c:if test="${product.lengthWaveLEDmodule > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.UV_block_wave_length}"/> ${product.lengthWaveLEDmodule} <custom:getDescriptionByLocale description="${d_search.nm}"/>;</c:if>
   									<br/>
   									<c:if test="${product.powerLEDmodule > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.UV_block_UV_radiation}"/> ${product.powerLEDmodule} <custom:getDescriptionByLocale description="${d_search.w}"/>;</c:if>
   									<br/>
   									<c:if test="${product.quantityLEDmodule > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.UV_block_quantity}"/> ${product.quantityLEDmodule} <custom:getDescriptionByLocale description="${d_search.pc}"/>;</c:if>
								</c:if>
   							
   								</td>
   							</tr>
						</c:if>
						
                       <c:if test="${!empty product.feed}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.feeds}"/>:</td>
   							<td><custom:multipleProperty productValues="${product.feed}" properties="${printer.feeds}"/></td></tr>
						</c:if>
						
						<c:if test="${!empty product.chromaticity}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.chromaticity}"/>:</td><td>
		                   		<c:forEach var="tp" items="${product.chromaticity}" varStatus="status">  
		                   		
		                   			<c:if test="${tp.equals('CMYK')}">
										${tp}<c:if test="${product.chromaticityCMYK!=''}" > + ${product.chromaticityCMYK}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
									</c:if>
									
									<c:if test="${tp.equals('CMYK x 2')}">
										${tp}<c:if test="${product.chromaticityCMYKx2!=''}" > + ${product.chromaticityCMYKx2}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
									</c:if>
									
									<c:if test="${tp.equals('CMYKLcLm')}">
										${tp}<c:if test="${product.chromaticityCMYKLcLm!=''}" > + ${product.chromaticityCMYKLcLm}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
									</c:if>
									
									<c:if test="${tp.equals('CMYKLcLmOG')}">
										${tp}<c:if test="${product.chromaticityCMYKLcLmOG!=''}" > + ${product.chromaticityCMYKLcLmOG}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
									</c:if>
		    						
								</c:forEach>
                       		</td></tr>
						</c:if>

						<c:if test="${!empty product.manufacturerPrinthead}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.manufacturer_printhead}"/>:</td>
   							<td>${product.manufacturerPrinthead}</td></tr>
						</c:if>

                       <c:if test="${!empty product.typeOfPrinthead}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.type_of_printhead}"/>:</td><td>${product.typeOfPrinthead}</td></tr>
						</c:if>
						
						<c:if test="${ (product.numberOfPrintheads > 0) || (product.onEachColorNumberOfPrintheads > 0) ||
						       (product.whiteColorNumberOfPrintheads > 0) || (product.varnishNumberOfPrintheads > 0) || 
						       (product.firstTypeNumberOfPrintheads > 0) || (product.secondTypeNumberOfPrintheads > 0) }">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_printer.number_of_printheads}"/>:</td>
   								<td>
   									<c:if test="${product.numberOfPrintheads > 0}">
   										${product.numberOfPrintheads} <custom:getDescriptionByLocale description="${d_search.pc}"/>
										<br/>
									</c:if>
									<c:if test="${product.onEachColorNumberOfPrintheads > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.number_of_printheads_each_color}"/> - ${product.onEachColorNumberOfPrintheads} <custom:getDescriptionByLocale description="${d_search.pc}"/>
										<br/>
									</c:if>
									<c:if test="${product.whiteColorNumberOfPrintheads > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.number_of_printheads_white_color}"/> - ${product.whiteColorNumberOfPrintheads} <custom:getDescriptionByLocale description="${d_search.pc}"/>
										<br/>
									</c:if>
									<c:if test="${product.varnishNumberOfPrintheads > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.number_of_printheads_lacquer}"/> - ${product.varnishNumberOfPrintheads} <custom:getDescriptionByLocale description="${d_search.pc}"/>
										<br/>
									</c:if>
									<c:if test="${product.firstTypeNumberOfPrintheads > 0}">
   										${product.firstEmptyNameTypeNumberOfPrintheads} - ${product.firstTypeNumberOfPrintheads} <custom:getDescriptionByLocale description="${d_search.pc}"/>
										<br/>
									</c:if>
									<c:if test="${product.secondTypeNumberOfPrintheads > 0}">
   										${product.secondEmptyNameTypeNumberOfPrintheads} - ${product.secondTypeNumberOfPrintheads} <custom:getDescriptionByLocale description="${d_search.pc}"/>
										<br/>
									</c:if>
   								</td>
   							</tr>
						</c:if>
						
						<c:if test="${ (product.averageConsumptionOfCMYKink > 0) || (product.averageConsumptionOfWhiteInk > 0) ||
						       (product.averageDischarge1 > 0) || (product.averageDischarge2 > 0) || (product.averageDischarge3 > 0) }">
   							<tr>
   								<td><custom:getDescriptionByLocale description="${search_printer.ink_consumption}"/>:</td>
   								<td>
   									<c:if test="${product.averageConsumptionOfCMYKink > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.ink_consumption_average_CMYK}"/> - ${product.averageConsumptionOfCMYKink} <custom:getDescriptionByLocale description="${d_search.ml_sq_m}"/>
										<br/>
									</c:if>
									<c:if test="${product.averageConsumptionOfWhiteInk > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.ink_consumption_average_white}"/> - ${product.averageConsumptionOfWhiteInk} <custom:getDescriptionByLocale description="${d_search.ml_sq_m}"/>
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge1 > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.ink_consumption_average_consumption}"/> ${product.nameOfAverageDischarge1} - ${product.averageDischarge1} <custom:getDescriptionByLocale description="${d_search.ml_sq_m}"/>
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge2 > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.ink_consumption_average_consumption}"/> ${product.nameOfAverageDischarge2} - ${product.averageDischarge2} <custom:getDescriptionByLocale description="${d_search.ml_sq_m}"/>
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge3 > 0}">
   										<custom:getDescriptionByLocale description="${search_printer.ink_consumption_average_consumption}"/> ${product.nameOfAverageDischarge3} - ${product.averageDischarge3} <custom:getDescriptionByLocale description="${d_search.ml_sq_m}"/>
									</c:if>
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.compatibleInk}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.compatible_ink}"/>:</td>
   							<td><custom:multipleProperty productValues="${product.compatibleInk}" properties="${printer.compatible_ink}"/>                    
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeDrops}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.type_drops}"/>:</td>
   							<td><custom:multipleProperty productValues="${product.typeDrops}" properties="${printer.type_drops}"/>                     
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.sizeDropStatic > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.size_drops_constant}"/>:</td><td>${product.sizeDropStatic} pl</td></tr>
						</c:if>
						
						<c:if test="${product.valueOfNewTypeDrop > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.size_drops}"/> (product.nameOfNewTypeDrop):</td><td>${product.valueOfNewTypeDrop} pl</td></tr>
						</c:if>
                       
                       <c:if test="${(product.sizeDropRangeFrom > 0) && (product.sizeDropRangeUntil > 0) &&
                       					(product.sizeDropRangeFrom < product.sizeDropRangeUntil)}">
   								<tr><td><custom:getDescriptionByLocale description="${search_printer.size_drops}"/>:</td><td>
	                   			<custom:getDescriptionByLocale description="${search_printer.size_drops_from}"/> ${product.sizeDropRangeFrom} pl <custom:getDescriptionByLocale description="${search_printer.size_drops_to}"/> ${product.sizeDropRangeUntil} pl                     
                       			</td></tr>
						</c:if>
						
						<c:if test="${(product.sizeDropRangeFrom < 0.001) || (product.sizeDropRangeUntil < 0.001) ||
                       					(product.sizeDropRangeFrom > product.sizeDropRangeUntil)}">
                       		<c:if test="${!empty product.sizeDrops}">
   								<tr><td><custom:getDescriptionByLocale description="${search_printer.size_drops}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.sizeDrops}" varStatus="status">  
	    								${tp} pl<c:if test="${ ! status.last}" >, </c:if>  
									</c:forEach>                        
                       			</td></tr>
							</c:if>
						</c:if>
                      
                      	<c:if test="${(product.speedPrintDraft > 0.001) || (product.speedPrintFast > 0.001) || 
                      					(product.speedPrintNormal > 0.001) || (product.speedPrintQuality > 0.001) ||
                      						(product.speedPrintHiQual > 0.001) || (product.speedPrint1 > 0.001) ||
                      						(product.speedPrint2 > 0.001) || (product.speedPrint3 > 0.001) ||
                      						(product.speedPrint4 > 0.001) || (product.speedPrint5 > 0.001)}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.speedPrint}"/>:</td>
   								<td>
   								
   								<c:if test="${product.speedPrintDraft > 0.001}">
   									Draft Speed:<c:if test="${product.speedPrintDraftPass > 0}"> ${product.speedPrintDraftPass} pass</c:if><c:if test="${product.speedPrintDraftResolution!='None'}"> ${product.speedPrintDraftResolution} dpi -</c:if> ${product.speedPrintDraft} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedPrintFast > 0.001}">
   									Fast Speed:<c:if test="${product.speedPrintFastPass > 0}"> ${product.speedPrintFastPass} pass</c:if><c:if test="${product.speedPrintFastResolution!='None'}"> ${product.speedPrintFastResolution} dpi -</c:if> ${product.speedPrintFast} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintNormal > 0.001}">
   									Normal Speed:<c:if test="${product.speedPrintNormalPass > 0}"> ${product.speedPrintNormalPass} pass</c:if><c:if test="${product.speedPrintNormalResolution!='None'}"> ${product.speedPrintNormalResolution} dpi -</c:if> ${product.speedPrintNormal} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintQuality > 0.001}">
   									Quality Speed:<c:if test="${product.speedPrintQualityPass > 0}"> ${product.speedPrintQualityPass} pass</c:if><c:if test="${product.speedPrintQualityResolution!='None'}"> ${product.speedPrintQualityResolution} dpi -</c:if> ${product.speedPrintQuality} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintHiQual > 0.001}">
   									Hi-Quality Speed:<c:if test="${product.speedPrintHiqualPass > 0}"> ${product.speedPrintHiqualPass} pass</c:if><c:if test="${product.speedPrintHiqualResolution!='None'}"> ${product.speedPrintHiqualResolution} dpi -</c:if> ${product.speedPrintHiQual} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint1 > 0.001}">
   									<c:if test="${product.speedPrintPass1 > 0}">${product.speedPrintPass1} pass </c:if><c:if test="${product.speedPrintResolution1!='None'}"> ${product.speedPrintResolution1} dpi -</c:if> ${product.speedPrint1} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint2 > 0.001}">
   									<c:if test="${product.speedPrintPass2 > 0}">${product.speedPrintPass2} pass </c:if><c:if test="${product.speedPrintResolution2!='None'}"> ${product.speedPrintResolution2} dpi -</c:if> ${product.speedPrint2} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint3 > 0.001}">
   									<c:if test="${product.speedPrintPass3 > 0}">${product.speedPrintPass3} pass </c:if><c:if test="${product.speedPrintResolution3!='None'}"> ${product.speedPrintResolution3} dpi -</c:if> ${product.speedPrint3} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint4 > 0.001}">
   									<c:if test="${product.speedPrintPass4 > 0}">${product.speedPrintPass4} pass </c:if><c:if test="${product.speedPrintResolution4!='None'}"> ${product.speedPrintResolution4} dpi -</c:if> ${product.speedPrint4} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint5 > 0.001}">
   									<c:if test="${product.speedPrintPass5 > 0}">${product.speedPrintPass5} pass </c:if><c:if test="${product.speedPrintResolution5!='None'}"> ${product.speedPrintResolution5} dpi -</c:if> ${product.speedPrint5} <custom:getDescriptionByLocale description="${d_search.sq_m_hour}"/>
								</c:if>
   								</td>
   							</tr>
						</c:if>
                      
                      <c:if test="${product.inputFirstPrintResolution != 0 && product.inputSecondPrintResolution != 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.print_resolution}"/>:</td><td>${product.inputFirstPrintResolution}x${product.inputSecondPrintResolution}dpi</td></tr>
						</c:if>
                      
                      	<c:if test="${(product.inputFirstPrintResolution == 0 || product.inputSecondPrintResolution == 0) && !empty product.printResolution}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.print_resolution}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.printResolution}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                      		 </td></tr>
						</c:if>
                      
                      	<c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.equipment_manufacturer}"/>:</td><td>${product.equipmentManufacturer}</td></tr>
						</c:if>
                      
                      	<c:if test="${!empty product.interfaceConnection}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.interface_connection}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.interfaceConnection}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.maximumMediaThickness > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.maximumMediaThickness}"/>:</td><td>${product.maximumMediaThickness} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.maximumWeightOfVehicle > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.maximumWeightOfVehicle}"/>:</td><td>${product.maximumWeightOfVehicle} <custom:getDescriptionByLocale description="${d_search.kg}"/></td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.rip}">
   							<tr><td><custom:getDescriptionByLocale description="${search_printer.rip}"/>:</td><td>
	                   			<c:forEach var="tp" items="${product.rip}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.averagePowerConsumption > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.averagePowerConsumption}"/>:</td><td>${product.averagePowerConsumption} <custom:getDescriptionByLocale description="${d_search.w}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.maxPowerConsumption > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.maxPowerConsumption}"/>:</td><td>${product.maxPowerConsumption} <custom:getDescriptionByLocale description="${d_search.w}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.weight > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.weight}"/>:</td><td>${product.weight} <custom:getDescriptionByLocale description="${d_search.kg}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.width > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.width}"/>:</td><td>${product.width} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.depth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.depth}"/>:</td><td>${product.depth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
                       
                       <c:if test="${product.heigth > 0}">
   							<tr><td><custom:getDescriptionByLocale description="${d_search.height}"/>:</td><td>${product.heigth} <custom:getDescriptionByLocale description="${d_search.mm}"/></td></tr>
						</c:if>
  
                  </table>
                  	</div>
                    
                    <!-- comments to this product -->
                    <jsp:include page="../product_page/comments.jsp" />
                    
                    <!-- products with use with this product -->
                    <jsp:include page="../product_page/product_use_with.jsp" />
                    
                    <!-- import inaccuracy description -->
				    <jsp:include page="../product_page/inaccuracy_description.jsp" /> 
                </div>            
            </div> 
        </div>
        
        <!-- code of javaScript in the end -->
        <jsp:include page="../product_page/timer.jsp" />
        <jsp:include page="../product_page/callback_ask_and_javascript_code.jsp" />
        
</body>
</html>