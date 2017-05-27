<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="/css/product.css"/>
	
	<script src="<%=request.getContextPath()%>/resources/js/user/product.js"></script>
	<title>${product.name}</title>
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
								<p>Качество печати:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingPrintQuality"></label>
								
								    <input id="star-4-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingPrintQuality"></label>
								
								    <input id="star-3-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingPrintQuality"></label>
								
								    <input id="star-2-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingPrintQuality"></label>
								
								    <input id="star-1-ratingPrintQuality" type="radio" name="ratingPrintQuality" 
								    	<c:if test="${product.ratingPrintQuality == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingPrintQuality"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingPrintSpeed > 0}">
							<!-- Скорость печати -->
							<div class="rating_block">
								<p>Скорость печати:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingPrintSpeed"></label>
								
								    <input id="star-4-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingPrintSpeed"></label>
								
								    <input id="star-3-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingPrintSpeed"></label>
								
								    <input id="star-2-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingPrintSpeed"></label>
								
								    <input id="star-1-ratingPrintSpeed" type="radio" name="ratingPrintSpeed" 
								    	<c:if test="${product.ratingPrintSpeed == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingPrintSpeed"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingStablePerformance > 0}">
							<!-- Стабильность работы -->
							<div class="rating_block">
								<p>Стабильность работы:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingStablePerformance"></label>
								
								    <input id="star-4-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingStablePerformance"></label>
								
								    <input id="star-3-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingStablePerformance"></label>
								
								    <input id="star-2-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingStablePerformance"></label>
								
								    <input id="star-1-ratingStablePerformance" type="radio" name="ratingStablePerformance" 
								    	<c:if test="${product.ratingStablePerformance == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingStablePerformance"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingEaseOfUse > 0}">
							<!-- Простота эксплуатации -->
							<div class="rating_block">
								<p>Простота эксплуатации:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingEaseOfUse"></label>
								
								    <input id="star-4-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingEaseOfUse"></label>
								
								    <input id="star-3-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingEaseOfUse"></label>
								
								    <input id="star-2-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingEaseOfUse"></label>
								
								    <input id="star-1-ratingEaseOfUse" type="radio" name="ratingEaseOfUse" 
								    	<c:if test="${product.ratingEaseOfUse == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingEaseOfUse"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingReliabilityAssembly > 0}">
							<!-- Надёжность сборки -->
							<div class="rating_block">
								<p>Надёжность сборки:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingReliabilityAssembly"></label>
								
								    <input id="star-4-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingReliabilityAssembly"></label>
								
								    <input id="star-3-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingReliabilityAssembly"></label>
								
								    <input id="star-2-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingReliabilityAssembly"></label>
								
								    <input id="star-1-ratingReliabilityAssembly" type="radio" name="ratingReliabilityAssembly" 
								    	<c:if test="${product.ratingReliabilityAssembly == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingReliabilityAssembly"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingLifetime > 0}">
							<!-- Срок эксплуатации -->
							<div class="rating_block">
								<p>Срок эксплуатации:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingLifetime"></label>
								
								    <input id="star-4-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingLifetime"></label>
								
								    <input id="star-3-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingLifetime"></label>
								
								    <input id="star-2-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingLifetime"></label>
								
								    <input id="star-1-ratingLifetime" type="radio" name="ratingLifetime" 
								    	<c:if test="${product.ratingLifetime == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingLifetime"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingPreventiveMaintenanceCost > 0}">
							<!-- Стоимость профилактического обслуживания -->
							<div class="rating_block">
								<p>Стоимость профилактического обслуживания:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingPreventiveMaintenanceCost"></label>
								
								    <input id="star-4-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingPreventiveMaintenanceCost"></label>
								
								    <input id="star-3-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingPreventiveMaintenanceCost"></label>
								
								    <input id="star-2-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingPreventiveMaintenanceCost"></label>
								
								    <input id="star-1-ratingPreventiveMaintenanceCost" type="radio" name="ratingPreventiveMaintenanceCost" 
								    	<c:if test="${product.ratingPreventiveMaintenanceCost == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingPreventiveMaintenanceCost"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingTheCostOfSpareParts > 0}">
							<!-- Стоимость запчастей -->
							<div class="rating_block">
								<p>Стоимость запчастей:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingTheCostOfSpareParts"></label>
								
								    <input id="star-4-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingTheCostOfSpareParts"></label>
								
								    <input id="star-3-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingTheCostOfSpareParts"></label>
								
								    <input id="star-2-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingTheCostOfSpareParts"></label>
								
								    <input id="star-1-ratingTheCostOfSpareParts" type="radio" name="ratingTheCostOfSpareParts" 
								    	<c:if test="${product.ratingTheCostOfSpareParts == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingTheCostOfSpareParts"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingTheCostOfConsumables > 0}">
							<!-- Стоимость расходных материалов -->
							<div class="rating_block">
								<p>Стоимость расходных материалов:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingTheCostOfConsumables"></label>
								
								    <input id="star-4-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingTheCostOfConsumables"></label>
								
								    <input id="star-3-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingTheCostOfConsumables"></label>
								
								    <input id="star-2-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingTheCostOfConsumables"></label>
								
								    <input id="star-1-ratingTheCostOfConsumables" type="radio" name="ratingTheCostOfConsumables" 
								    	<c:if test="${product.ratingTheCostOfConsumables == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingTheCostOfConsumables"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingTheCostOfOriginalInk > 0}">
							<!-- Стоимость оригинальных чернил -->
							<div class="rating_block">
								<p>Стоимость оригинальных чернил:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingTheCostOfOriginalInk"></label>
								
								    <input id="star-4-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingTheCostOfOriginalInk"></label>
								
								    <input id="star-3-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingTheCostOfOriginalInk"></label>
								
								    <input id="star-2-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingTheCostOfOriginalInk"></label>
								
								    <input id="star-1-ratingTheCostOfOriginalInk" type="radio" name="ratingTheCostOfOriginalInk" 
								    	<c:if test="${product.ratingTheCostOfOriginalInk == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingTheCostOfOriginalInk"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingCostOfPrinting > 0}">
							<!-- Себестоимость печати -->
							<div class="rating_block">
								<p>Себестоимость печати:</p>
								<div class="reviewStars-input">
								    <input id="star-5-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 5}">checked</c:if> value="5"/>
								    <label title="Очень хорошо" for="star-5-ratingCostOfPrinting"></label>
								
								    <input id="star-4-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 4}">checked</c:if> value="4"/>
								    <label title="Хорошо" for="star-4-ratingCostOfPrinting"></label>
								
								    <input id="star-3-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 3}">checked</c:if> value="3"/>
								    <label title="Средне" for="star-3-ratingCostOfPrinting"></label>
								
								    <input id="star-2-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 2}">checked</c:if> value="2"/>
								    <label title="Ниже среднего" for="star-2-ratingCostOfPrinting"></label>
								
								    <input id="star-1-ratingCostOfPrinting" type="radio" name="ratingCostOfPrinting" 
								    	<c:if test="${product.ratingCostOfPrinting == 1}">checked</c:if> value="1"/>
								    <label title="Плохо" for="star-1-ratingCostOfPrinting"></label>
								</div>
							</div>
						</c:if>
						
						<c:if test="${product.ratingOverallRating > 0}">
							<!-- Общая оценка -->
							<div class="rating_block">
								<p style="font-weight: bold;">Общая оценка:</p>
								<div style="width: 100px; float: left;">
									<ul class="rating_average clearfix">
										<li class="current" style="width: ${product.ratingOverallRating * 20}%;"><span class="star1" title="Плохо"></span></li>
										<li><span class="star2" title="Ниже среднего" ></span></li>
										<li><span class="star3" title="Средне" ></span></li>
										<li><span class="star4" title="Хорошо"  ></span></li>
										<li><span class="star5" title="Очень хорошо" ></span></li>
									</ul>
								</div>
							</div>
						</c:if>
						
					</div>
            	</div>
				
                <div class="descriptions">
 			
 				<!-- import timer -->
				<jsp:include page="../product_page/clock.jsp" />
					
                <div id="name_product_head_description">${product.name}</div>
                	
                <c:if test="${!empty product.partNumber}">
                	<div id="name_product_head_description">Код товара: ${product.partNumber}</div>
				</c:if>
					
					<div class="outer_table_in_head">
	                    <table id="table_in_head">
	                       <caption></caption> 
	                       <!-- set price in table row -->
						   <jsp:include page="../product_page/price.jsp" />                
						   
	                       <c:if test="${!empty product.typePrinter}">
	   							<tr><td>Тип принтера:</td><td>${product.typePrinter}</td></tr>
						   </c:if>
						   
	                       <c:if test="${!empty product.equipmentModel}">
	   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
						   </c:if>
						   
	                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
	   							<tr><td>Ширина печати:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}"> x ${product.inputSecondWeightPrintMM}</c:if> мм</td></tr>
							</c:if>
	                       
	                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.weightPrintMM > 0}">
	   							<tr><td>Ширина печати:</td><td>${product.weightPrintMM} мм</td></tr>
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
                <ul id="sub_tabs_product">
                    <li>Описание</li>
                    <li>Технические характеристики</li>
                    <li>Отзывы</li>
                    <li>С этим товаром используется</li>
                    <li>Уточнение описания</li>                                
            
                </ul>
                <div>
                    <div id="output_description">${product.description}</div>
                    
                    <div class="descriptions">
					<table>
                       
                       <c:if test="${!empty product.typePrinter}">
   							<tr><td>Тип принтера:</td><td>${product.typePrinter}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.partNumber}">
   							<tr><td>Код товара:</td><td>${product.partNumber}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.equipmentModel}">
   							<tr><td>Модель:</td><td>${product.equipmentModel}</td></tr>
					   </c:if>
                       
                       <c:if test="${product.inputFirstWeightPrintMM != 0}">
   							<tr><td>Ширина печати:</td><td>${product.inputFirstWeightPrintMM}<c:if test="${product.inputSecondWeightPrintMM!=0}"> x ${product.inputSecondWeightPrintMM}</c:if> мм</td></tr>
					   </c:if>
                       
                       <c:if test="${(product.inputFirstWeightPrintMM == 0) && product.weightPrintMM > 0}">
   							<tr><td>Ширина печати:</td><td>${product.weightPrintMM} мм</td></tr>
					   </c:if>
					   
					   <c:if test="${!empty product.printingExtension}">
   							<tr><td>Расширение печати:</td><td>${product.printingExtension} мм</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.previouslyUsed}">
   							<tr><td>Состояние оборудования:</td><td>${product.previouslyUsed}</td></tr>
					   </c:if>
                       
                       <c:if test="${!empty product.typePrint}">
   							<tr><td>Тип печати:</td><td>${product.typePrint}</td></tr>
						</c:if>
						
						<c:if test="${(product.lengthWaveUVlamp > 0) || (product.powerUVlamp > 0) || 
                      					(product.lengthWaveLEDmodule > 0) || (product.powerLEDmodule > 0) }">
   							<tr><td>UV Блок:</td>
   								<td>
   								
   								<c:if test="${(product.lengthWaveUVlamp > 0) || (product.powerUVlamp > 0)}">
   									UV лампа:
   									<br/>
   									<c:if test="${product.lengthWaveUVlamp > 0}">длинна волны ${product.lengthWaveUVlamp} нм;</c:if>
   									<br/>
   									<c:if test="${product.powerUVlamp > 0}">мощность UV излучения ${product.powerUVlamp} Вт;</c:if>
   									<br/>
   									<c:if test="${product.quantityUVlamp > 0}">количество ${product.quantityUVlamp} шт;</c:if>
   									<br/>
								</c:if>
								
								<c:if test="${(product.lengthWaveLEDmodule > 0) || (product.powerLEDmodule > 0)}">
   									LED модуль:
   									<br/>
   									<c:if test="${product.lengthWaveLEDmodule > 0}">длинна волны ${product.lengthWaveLEDmodule} нм;</c:if>
   									<br/>
   									<c:if test="${product.powerLEDmodule > 0}">мощность UV излучения ${product.powerLEDmodule} Вт;</c:if>
   									<br/>
   									<c:if test="${product.quantityLEDmodule > 0}">количество ${product.quantityLEDmodule} шт;</c:if>
								</c:if>
   							
   								</td>
   							</tr>
						</c:if>
						
                       <c:if test="${!empty product.feed}">
   							<tr><td>Подача материала:</td><td>
		                   		<c:forEach var="tp" items="${product.feed}" varStatus="status">  
		    						${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>
                       		</td></tr>
						</c:if>
						
						<c:if test="${!empty product.chromaticity}">
   							<tr><td>Цветовая схема:</td><td>
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
   							<tr><td>Производитель печатающей головки:</td><td>${product.manufacturerPrinthead}</td></tr>
						</c:if>

                       <c:if test="${!empty product.typeOfPrinthead}">
   							<tr><td>Тип печатающей головки:</td><td>${product.typeOfPrinthead}</td></tr>
						</c:if>
						
						<c:if test="${ (product.numberOfPrintheads > 0) || (product.onEachColorNumberOfPrintheads > 0) ||
						       (product.whiteColorNumberOfPrintheads > 0) || (product.varnishNumberOfPrintheads > 0) || 
						       (product.firstTypeNumberOfPrintheads > 0) || (product.secondTypeNumberOfPrintheads > 0) }">
   							<tr>
   								<td>Количество печатающих головок:</td>
   								<td>
   									<c:if test="${product.numberOfPrintheads > 0}">
   										${product.numberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.onEachColorNumberOfPrintheads > 0}">
   										На каждый цвет - ${product.onEachColorNumberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.whiteColorNumberOfPrintheads > 0}">
   										Белый цвет - ${product.whiteColorNumberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.varnishNumberOfPrintheads > 0}">
   										Лак - ${product.varnishNumberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.firstTypeNumberOfPrintheads > 0}">
   										${product.firstEmptyNameTypeNumberOfPrintheads} - ${product.firstTypeNumberOfPrintheads} шт
										<br/>
									</c:if>
									<c:if test="${product.secondTypeNumberOfPrintheads > 0}">
   										${product.secondEmptyNameTypeNumberOfPrintheads} - ${product.secondTypeNumberOfPrintheads} шт
										<br/>
									</c:if>
   								</td>
   							</tr>
						</c:if>
						
						<c:if test="${ (product.averageConsumptionOfCMYKink > 0) || (product.averageConsumptionOfWhiteInk > 0) ||
						       (product.averageDischarge1 > 0) || (product.averageDischarge2 > 0) || (product.averageDischarge3 > 0) }">
   							<tr>
   								<td>Расход чернил:</td>
   								<td>
   									<c:if test="${product.averageConsumptionOfCMYKink > 0}">
   										Средний расход чернил CMYK - ${product.averageConsumptionOfCMYKink} мл./м.кв.
										<br/>
									</c:if>
									<c:if test="${product.averageConsumptionOfWhiteInk > 0}">
   										Средний расход белых чернил - ${product.averageConsumptionOfWhiteInk} мл./м.кв.
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge1 > 0}">
   										Средний расход ${product.nameOfAverageDischarge1} - ${product.averageDischarge1} мл./м.кв.
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge2 > 0}">
   										Средний расход ${product.nameOfAverageDischarge2} - ${product.averageDischarge2} мл./м.кв.
										<br/>
									</c:if>
									<c:if test="${product.averageDischarge3 > 0}">
   										Средний расход ${product.nameOfAverageDischarge3} - ${product.averageDischarge3} мл./м.кв.
									</c:if>
   								</td>
   							</tr>
						</c:if>
                       
                       <c:if test="${!empty product.compatibleInk}">
   							<tr><td>Совместимые чернила:</td><td>
	                   			<c:forEach var="tp" items="${product.compatibleInk}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.typeDrops}">
   							<tr><td>Тип капли:</td><td>
	                   			<c:forEach var="tp" items="${product.typeDrops}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.sizeDropStatic > 0}">
   							<tr><td>Размер капли (постоянная):</td><td>${product.sizeDropStatic} pl</td></tr>
						</c:if>
						
						<c:if test="${product.valueOfNewTypeDrop > 0}">
   							<tr><td>Размер капли (product.nameOfNewTypeDrop):</td><td>${product.valueOfNewTypeDrop} pl</td></tr>
						</c:if>
                       
                       <c:if test="${(product.sizeDropRangeFrom > 0) && (product.sizeDropRangeUntil > 0) &&
                       					(product.sizeDropRangeFrom < product.sizeDropRangeUntil)}">
   								<tr><td>Размер капли:</td><td>
	                   			Переменная от ${product.sizeDropRangeFrom} pl до ${product.sizeDropRangeUntil} pl                     
                       			</td></tr>
						</c:if>
						
						<c:if test="${(product.sizeDropRangeFrom < 0.001) || (product.sizeDropRangeUntil < 0.001) ||
                       					(product.sizeDropRangeFrom > product.sizeDropRangeUntil)}">
                       		<c:if test="${!empty product.sizeDrops}">
   								<tr><td>Размер капли:</td><td>
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
   							<tr><td>Скорость печати:</td>
   								<td>
   								
   								<c:if test="${product.speedPrintDraft > 0.001}">
   									Draft Speed:<c:if test="${product.speedPrintDraftPass > 0}"> ${product.speedPrintDraftPass} pass</c:if><c:if test="${product.speedPrintDraftResolution!='None'}"> ${product.speedPrintDraftResolution} dpi -</c:if> ${product.speedPrintDraft} м.кв./ч.
   									<br/>
								</c:if>
   							
   								<c:if test="${product.speedPrintFast > 0.001}">
   									Fast Speed:<c:if test="${product.speedPrintFastPass > 0}"> ${product.speedPrintFastPass} pass</c:if><c:if test="${product.speedPrintFastResolution!='None'}"> ${product.speedPrintFastResolution} dpi -</c:if> ${product.speedPrintFast} м.кв./ч.
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintNormal > 0.001}">
   									Normal Speed:<c:if test="${product.speedPrintNormalPass > 0}"> ${product.speedPrintNormalPass} pass</c:if><c:if test="${product.speedPrintNormalResolution!='None'}"> ${product.speedPrintNormalResolution} dpi -</c:if> ${product.speedPrintNormal} м.кв./ч.
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintQuality > 0.001}">
   									Quality Speed:<c:if test="${product.speedPrintQualityPass > 0}"> ${product.speedPrintQualityPass} pass</c:if><c:if test="${product.speedPrintQualityResolution!='None'}"> ${product.speedPrintQualityResolution} dpi -</c:if> ${product.speedPrintQuality} м.кв./ч.
   									<br/>
								</c:if>
								
								<c:if test="${product.speedPrintHiQual > 0.001}">
   									Hi-Quality Speed:<c:if test="${product.speedPrintHiqualPass > 0}"> ${product.speedPrintHiqualPass} pass</c:if><c:if test="${product.speedPrintHiqualResolution!='None'}"> ${product.speedPrintHiqualResolution} dpi -</c:if> ${product.speedPrintHiQual} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint1 > 0.001}">
   									<c:if test="${product.speedPrintPass1 > 0}">${product.speedPrintPass1} pass </c:if><c:if test="${product.speedPrintResolution1!='None'}"> ${product.speedPrintResolution1} dpi -</c:if> ${product.speedPrint1} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint2 > 0.001}">
   									<c:if test="${product.speedPrintPass2 > 0}">${product.speedPrintPass2} pass </c:if><c:if test="${product.speedPrintResolution2!='None'}"> ${product.speedPrintResolution2} dpi -</c:if> ${product.speedPrint2} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint3 > 0.001}">
   									<c:if test="${product.speedPrintPass3 > 0}">${product.speedPrintPass3} pass </c:if><c:if test="${product.speedPrintResolution3!='None'}"> ${product.speedPrintResolution3} dpi -</c:if> ${product.speedPrint3} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint4 > 0.001}">
   									<c:if test="${product.speedPrintPass4 > 0}">${product.speedPrintPass4} pass </c:if><c:if test="${product.speedPrintResolution4!='None'}"> ${product.speedPrintResolution4} dpi -</c:if> ${product.speedPrint4} м.кв./ч.
									<br/>
								</c:if>
								
								<c:if test="${product.speedPrint5 > 0.001}">
   									<c:if test="${product.speedPrintPass5 > 0}">${product.speedPrintPass5} pass </c:if><c:if test="${product.speedPrintResolution5!='None'}"> ${product.speedPrintResolution5} dpi -</c:if> ${product.speedPrint5} м.кв./ч.
								</c:if>
   								</td>
   							</tr>
						</c:if>
                      
                      <c:if test="${product.inputFirstPrintResolution != 0 && product.inputSecondPrintResolution != 0}">
   							<tr><td>Разрешение печати:</td><td>${product.inputFirstPrintResolution}x${product.inputSecondPrintResolution}dpi</td></tr>
						</c:if>
                      
                      	<c:if test="${(product.inputFirstPrintResolution == 0 || product.inputSecondPrintResolution == 0) && !empty product.printResolution}">
   							<tr><td>Разрешение печати:</td><td>
	                   			<c:forEach var="tp" items="${product.printResolution}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                      		 </td></tr>
						</c:if>
                      
                      	<c:if test="${!empty product.equipmentManufacturer}">
   							<tr><td>Производитель оборудования:</td><td>${product.equipmentManufacturer}</td></tr>
						</c:if>
                      
                      	<c:if test="${!empty product.interfaceConnection}">
   							<tr><td>Интерфейс подключения:</td><td>
	                   			<c:forEach var="tp" items="${product.interfaceConnection}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                       
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.maximumMediaThickness > 0}">
   							<tr><td>Максимальная толщина носителя:</td><td>${product.maximumMediaThickness} мм</td></tr>
						</c:if>
                       
                       <c:if test="${product.maximumWeightOfVehicle > 0}">
   							<tr><td>Максимальный вес носителя:</td><td>${product.maximumWeightOfVehicle} кг</td></tr>
						</c:if>
                       
                       <c:if test="${!empty product.rip}">
   							<tr><td>Программное обеспечение:</td><td>
	                   			<c:forEach var="tp" items="${product.rip}" varStatus="status">  
	    							${tp}<c:if test="${ ! status.last}" >, </c:if>  
								</c:forEach>                        
                       		</td></tr>
						</c:if>
                       
                       <c:if test="${product.averagePowerConsumption > 0}">
   							<tr><td>Средняя потребляемая мощность:</td><td>${product.averagePowerConsumption} Вт</td></tr>
						</c:if>
                       
                       <c:if test="${product.maxPowerConsumption > 0}">
   							<tr><td>Максимальная потребляемая мощность:</td><td>${product.maxPowerConsumption} Вт</td></tr>
						</c:if>
                       
                       <c:if test="${product.weight > 0}">
   							<tr><td>Вес:</td><td>${product.weight} кг</td></tr>
						</c:if>
                       
                       <c:if test="${product.width > 0}">
   							<tr><td>Ширина:</td><td>${product.width} мм</td></tr>
						</c:if>
                       
                       <c:if test="${product.depth > 0}">
   							<tr><td>Глубина:</td><td>${product.depth} мм</td></tr>
						</c:if>
                       
                       <c:if test="${product.heigth > 0}">
   							<tr><td>Высота:</td><td>${product.heigth} мм</td></tr>
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