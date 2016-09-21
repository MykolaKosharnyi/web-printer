<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="option_product_with_price">
    	                     
  <table class="table table-hover table_price_option table-striped">
    <thead>
      <tr>
        <th>Опции</th>
        <th>Цена</th>
        <th>Описание</th>
      </tr>
    </thead>
    <tbody>

      <c:if test="${product.optionInstallation > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="Инсталяция" id="optionInstallation_price">
	        	<label class="add_price_title" for="optionInstallation_price">Инсталяция</label>
	        </td>
	        <td>
				<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.optionInstallation}" /></span>
				</label>
			</td>
	        <td>${product.descriptionOptionInstallation}</td>
	      </tr>
      </c:if>

      <c:if test="${product.priceAddedOption > 0.01 && (product.nameAddedOption!=null && product.nameAddedOption!='')}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="${product.nameAddedOption}" id="priceAddedOption_price">
	        	<label class="add_price_title" for="priceAddedOption_price">${product.nameAddedOption}</label>
	        </td>
	        <td>
				<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption}" /></span>
				</label>
			</td>
	        <td>${product.descriptionOptionAddedOption}</td>
	      </tr>
      </c:if>      

      <c:if test="${product.priceAddedOption2 > 0.01 && (product.nameAddedOption2!=null && product.nameAddedOption2!='')}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="${product.nameAddedOption2}" id="priceAddedOption2_price">
	        	<label class="add_price_title" for="priceAddedOption2_price">${product.nameAddedOption2}</label>
	        </td>
	        <td>
				<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption2}" /></span>
				</label>
			</td>
	        <td>${product.descriptionOptionAddedOption2}</td>
	      </tr>
      </c:if>  
      
      <c:if test="${product.priceAddedOption3 > 0.01 && (product.nameAddedOption3!=null && product.nameAddedOption3!='')}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="${product.nameAddedOption3}" id="priceAddedOption3_price">
	        	<label class="add_price_title" for="priceAddedOption3_price">${product.nameAddedOption3}</label>
	        </td>
	        <td>
				<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption3}" /></span>
				</label>
			</td>
	        <td>${product.descriptionOptionAddedOption3}</td>
	      </tr>
      </c:if>       

	<c:if test="${product.optionVAT > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="НДС" id="optionVAT_price">
	        	<label class="add_price_title" for="optionVAT_price">НДС</label>
	        </td>
	        <td>
	        	<label class="add_price_value" style="display:none;"><span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.optionVAT}" /></span>
				</label>
	        </td>
	        <td>${product.descriptionOptionVAT}</td>
	      </tr>
	</c:if>
	
	<c:if test="${ (type == 'use_with_product') && (product.insuranceInternationalTransport/100) * product.prise > 0}">
	      <tr class="block_product_price">
	        <td style="position: relative;">
	        	<input class="add_price" style="position: absolute; top: 5px;" type="checkbox" value="Страхование груза международная перевозка" id="insuranceInternationalTransport_price">
	        	<label class="add_price_title" style="margin-left:20px;" for="insuranceInternationalTransport_price">Страхование груза международная перевозка</label>
	        </td>
	        <td>
				<label class="add_price_value">$ <span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${(product.insuranceInternationalTransport/100) * product.prise}" /></span>
				</label>
			</td>
	        <td>${product.descriptionInsuranceInternationalTransport}</td>
	      </tr>
    </c:if>
    
    <c:if test="${ (type == 'use_with_product') && (product.insuranceUkraineTransport/100) * product.prise > 0}">
	      <tr class="block_product_price">
	        <td style="position: relative;">
	        	<input class="add_price" style="position: absolute; top: 5px;" type="checkbox" value="Страхование груза по Украине" id="insuranceUkraineTransport_price">
	        	<label class="add_price_title" style="margin-left:20px;" for="insuranceUkraineTransport_price">Страхование груза по Украине</label>
	        </td>
	        <td>
				<label class="add_price_value">$ <span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${(product.insuranceUkraineTransport/100) * product.prise}" /></span>
				</label>
			</td>
	        <td>${product.descriptionInsuranceUkraineTransport}</td>
	      </tr>
    </c:if>
	
	<c:if test="${ product.ukraineDeliveryPriceSize || product.ukraineDeliveryPriceWeight ||
			       product.kyivDeliveryPriceSize || product.kyivDeliveryPriceWeight }">	
	<tr class="delivery">
		<td colspan="3">
			<div class="delivery_options">
				<i class="fa fa-arrow-right"></i>
				<p class="delivery_options_title">Доставка</p>
			</div>
			<div class="delivery_options_body">
			
				<input type="hidden" name="delivery_radio_name" class="delivery_radio_name" value="">
				<input type="hidden" name="delivery_radio_value" class="delivery_radio_value" value="0">
				
				<table class="table table-hover table_delivery_options">
					<tbody>

						<c:if test="${ product.ukraineDeliveryPriceSize || product.ukraineDeliveryPriceWeight }">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="По Украине" id="ukraineDelivery_price">
						        	<label class="add_price_delivery_title" for="ukraineDelivery_price">По Украине</label>
						        </td>
						        <td>
							    	<label class="add_price_delivery_value">$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${
											(product.ukraineDeliveryPriceSize ? product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * constants.price_ukraine_size : 0) + 
												(product.ukraineDeliveryPriceWeight ? product.deliveryWeight * constants.price_ukraine_weight : 0)
											}" /></span>
									</label>
								</td>
							</tr>
				      	</c:if>
				      	
				      	<c:if test="${ product.kyivDeliveryPriceSize || product.kyivDeliveryPriceWeight }">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="По Киеву" id="kyivDelivery_price">
						        	<label class="add_price_delivery_title" for="kyivDelivery_price">По Киеву</label>
						        </td>
						        <td>
							    	<label class="add_price_delivery_value">$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${
											(product.kyivDeliveryPriceSize ? product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * constants.price_kyiv_size : 0) + 
												(product.kyivDeliveryPriceWeight ? product.deliveryWeight * constants.price_kyiv_weight : 0)
											}" /></span>
									</label>
								</td>
							</tr>
				      	</c:if>
						
					</tbody>
				</table>
			</div>
			
		</td>
	</tr>
</c:if>

<c:if test="${ (type == 'use_with_product') && (product.typeProduct=='Чернила для струйной печати') && ((product.cyanPaint > 0) || (product.magentaPaint > 0) || (product.yellowPaint > 0) ||
		       (product.blackPaint > 0) || (product.lightCyanPaint > 0) || (product.lightMagentaPaint > 0) || (product.solventPaint > 0) ||
		       (product.matteBlackPaint > 0) || (product.grayPaint > 0) || (product.orangePaint > 0) || (product.greenPaint > 0) ||
		       ((product.variant1Paint > 0) && (product.variant1NamePaint !=null) && (product.variant1NamePaint!='')) ||
		       ((product.variant2Paint > 0) && (product.variant2NamePaint !=null) && (product.variant2NamePaint!='')) ||
		       ((product.variant3Paint > 0) && (product.variant3NamePaint !=null) && (product.variant3NamePaint!='')))}">
	<tr class=paint>
		<td colspan="3">
			<div class="paint_options">
				<i class="fa fa-arrow-right"></i>
				<p class="paint_options_title">Краска</p>
			</div>
			<div class="paint_options_body">
				<table class="table table-hover table_paint_options">
					<thead>
				      <tr>
				        <th>Тип</th>
				        <th>Цена за 1л</th>
				        <th>Количество</th>
				        <th>Общая стоимость</th>
				      </tr>
				    </thead>
					<tbody>
						<c:if test="${ product.cyanPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Cyan" id="cyanPaint_price">
						        	<label class="add_price_paint_title" for="cyanPaint_price">Cyan</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.cyanPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.cyanPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>	
						
						<c:if test="${ product.magentaPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Magenta" id="MagentaPaint_price">
						        	<label class="add_price_paint_title" for="MagentaPaint_price">Magenta</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.magentaPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.magentaPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>	
						
						<c:if test="${ product.yellowPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Yellow" id="YellowPaint_price">
						        	<label class="add_price_paint_title" for="YellowPaint_price">Yellow</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.yellowPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.yellowPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>	
						
						<c:if test="${ product.blackPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Black" id="BlackPaint_price">
						        	<label class="add_price_paint_title" for="BlackPaint_price">Black</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.blackPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.blackPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ product.lightCyanPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Light Cyan" id="LightCyanPaint_price">
						        	<label class="add_price_paint_title" for="LightCyanPaint_price">Light Cyan</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.lightCyanPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.lightCyanPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ product.lightMagentaPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Light Magenta" id="LightMagentaPaint_price">
						        	<label class="add_price_paint_title" for="LightMagentaPaint_price">Light Magenta</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.lightMagentaPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.lightMagentaPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ product.solventPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Solvent" id="SolventPaint_price">
						        	<label class="add_price_paint_title" for="SolventPaint_price">Solvent</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.solventPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.solventPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ product.matteBlackPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Matte black" id="MatteblackPaint_price">
						        	<label class="add_price_paint_title" for="MatteblackPaint_price">Matte black</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.matteBlackPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.matteBlackPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ product.grayPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Gray" id="GrayPaint_price">
						        	<label class="add_price_paint_title" for="GrayPaint_price">Gray</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.grayPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.grayPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ product.orangePaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Orange" id="OrangePaint_price">
						        	<label class="add_price_paint_title" for="OrangePaint_price">Orange</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.orangePaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.orangePaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ product.greenPaint > 0 }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="Green" id="GreenPaint_price">
						        	<label class="add_price_paint_title" for="GreenPaint_price">Green</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.greenPaint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.greenPaint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ (product.variant1Paint > 0) && (product.variant1NamePaint !=null) && (product.variant1NamePaint!='') }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="${product.variant1NamePaint}" id="variant1NamePaint_price">
						        	<label class="add_price_paint_title" for="variant1NamePaint_price">${product.variant1NamePaint}</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.variant1Paint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.variant1Paint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ (product.variant2Paint > 0) && (product.variant2NamePaint !=null) && (product.variant2NamePaint!='') }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="${product.variant2NamePaint}" id="variant2NamePaint_price">
						        	<label class="add_price_paint_title" for="variant2NamePaint_price">${product.variant2NamePaint}</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.variant2Paint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.variant2Paint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>
						
						<c:if test="${ (product.variant3Paint > 0) && (product.variant3NamePaint !=null) && (product.variant3NamePaint!='') }">
							<tr class="block_product_price">
								<td><input class="add_price_paint" type="checkbox" value="${product.variant3NamePaint}" id="variant3NamePaint_price">
						        	<label class="add_price_paint_title" for="variant3NamePaint_price">${product.variant3NamePaint}</label>
						        </td>
						        <td class="paint_price">
									<label>$ <span><fmt:formatNumber type="number" 
											maxFractionDigits="2" minFractionDigits="2" value="${product.variant3Paint}" /></span>
									</label>
								</td>
						        <td>

									<span class="dec_value_paint">
										<i class="fa fa-minus" aria-hidden="true"></i>
									</span>
					
									<input class="quantity_paint"  value="<c:out value="1"/>"></input>
					
									<span class="inc_value_paint">
										<i class="fa fa-plus" aria-hidden="true"></i>
									</span>

								</td>
								<td class="add_price_value">
									<label>$ <span><fmt:formatNumber type="number" maxFractionDigits="2" 
										minFractionDigits="2" value="${product.variant3Paint}" /></span>
									</label>
								</td>
							</tr>
						</c:if>

					</tbody>
				</table>
			</div>
			
		</td>
	</tr>
</c:if>

	<tr class="output_result_of_option">
		<td style="vertical-align: middle;">Общая стоимость:</td>
        <td style="vertical-align: middle;">
        	<label class="total_price">$<span><fmt:formatNumber type="number" 
			   	maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></span>
			</label>
        </td>
        <td>
        	<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="top: 0px; right: -30px; float: none;"
			onclick="addToCartProductPageRIPaUWP('${type}', ${product.id}, '${product.name}',
			 '${product.prise}', '${product.pathPictures.get(0)}', getCheckedOption(), getCheckedDelivery(), getCheckedPaint());"></i>		
        </td>
	</tr>

    </tbody>
  </table>	
					
</div>