<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "custom" uri = "/WEB-INF/custom.tld"%>

<div class="option_product_with_price">
    	                     
  <table class="table table-hover table_price_option table-striped">
    <thead>
      <tr>
        <th><custom:getDescriptionByLocale description="${descriptions.options}"/></th>
        <th><custom:getDescriptionByLocale description="${descriptions.options_price}"/></th>
        <th><custom:getDescriptionByLocale description="${descriptions.description}"/></th>
      </tr>
    </thead>
    <tbody>
		<c:if test="${product.optionRIP > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="Програмное обеспечение" id="optionRIP_price">
	        	<label class="add_price_title" for="optionRIP_price"><custom:getDescriptionByLocale description="${descriptions.options_software}"/></label>
	        </td>
	        <td>
				<div class="product_price">
					<input name="price_value" value="${product.optionRIP}" type="hidden">				
			   		<div></div>
				</div>
			</td>
	        <td>${product.descriptionOptionRIP}</td>
	      </tr>
		</c:if>
	
		<c:if test="${product.optionSNCP > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="СНЧП" id="optionSNCP_price">
	        	<label class="add_price_title" for="optionSNCP_price"><custom:getDescriptionByLocale description="${descriptions.options_CISS}"/></label>
	        </td>
	        <td>
				<div class="product_price">
					<input name="price_value" value="${product.optionSNCP}" type="hidden">				
			   		<div></div>
				</div>
			</td>
	        <td>${product.descriptionOptionSNCP}</td>
	      </tr>
		</c:if>

      <c:if test="${product.optionInstallation > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="Инсталяция" id="optionInstallation_price">
	        	<label class="add_price_title" for="optionInstallation_price"><custom:getDescriptionByLocale description="${descriptions.installation}"/></label>
	        </td>
	        <td>
				<div class="product_price">
					<input name="price_value" value="${product.optionInstallation}" type="hidden">				
			   		<div></div>
				</div>
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
				<div class="product_price">
					<input name="price_value" value="${product.priceAddedOption}" type="hidden">				
			   		<div></div>
				</div>
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
				<div class="product_price">
					<input name="price_value" value="${product.priceAddedOption2}" type="hidden">				
			   		<div></div>
				</div>
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
				<div class="product_price">	
					<input name="price_value" value="${product.priceAddedOption3}" type="hidden">				
			   		<div></div>
				</div>
			</td>
	        <td>${product.descriptionOptionAddedOption3}</td>
	      </tr>
      </c:if>       

      <c:if test="${product.optionGuarantee > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="Гарантия" id="optionGuarantee_price">
	        	<label class="add_price_title" for="optionGuarantee_price"><custom:getDescriptionByLocale description="${descriptions.options_guarantee}"/></label>
	        </td>
	        <td>
				<div class="product_price">
					<input name="price_value" value="${product.optionGuarantee}" type="hidden">				
			   		<div></div>
				</div>
			</td>
	        <td>${product.descriptionOptionGuarantee}</td>
	      </tr>
      </c:if>

	<c:if test="${product.optionVAT > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="НДС" id="optionVAT_price">
	        	<label class="add_price_title" for="optionVAT_price"><custom:getDescriptionByLocale description="${descriptions.vat}"/></label>
	        </td>
	        <td>
	        	<div class="product_price" style="display:none;">
			   		<input name="price_value" value="${product.optionVAT}" type="hidden">				
			   		<div></div>
				</div>
	        </td>
	        <td>${product.descriptionOptionVAT}</td>
	      </tr>
	</c:if>

<c:if test="${product.airDeliveryPriceSize || product.airDeliveryPriceWeight ||
			  product.seaDeliveryPriceSize || product.seaDeliveryPriceWeight ||
			  product.ukraineDeliveryPriceSize || product.ukraineDeliveryPriceWeight ||
			  product.kyivDeliveryPriceSize || product.kyivDeliveryPriceWeight ||		 
			  product.insuranceInternationalTransport ||
			  product.insuranceUkraineTransport ||			  
			  (((product.deliveryWidth * product.deliveryHeight * product.deliveryDepth * product.variant1DeliveryPriceSize > 0) ||
						(product.deliveryWeight * product.variant1DeliveryPriceWeight > 0)) &&
						 ((product.variant1DeliveryName !=null) && (product.variant1DeliveryName!=''))) ||
			  (((product.deliveryWidth * product.deliveryHeight * product.deliveryDepth * product.variant2DeliveryPriceSize > 0) ||
						(product.deliveryWeight * product.variant2DeliveryPriceWeight > 0)) &&
						 ((product.variant2DeliveryName !=null) && (product.variant2DeliveryName!=''))) ||
			  (((product.deliveryWidth * product.deliveryHeight * product.deliveryDepth * product.variant3DeliveryPriceSize > 0) ||
						(product.deliveryWeight * product.variant3DeliveryPriceWeight > 0)) &&
						 ((product.variant3DeliveryName !=null) && (product.variant3DeliveryName!='')))}">	
	<tr class="delivery">
		<td colspan="3">
			<div class="delivery_options">
				<i class="fa fa-arrow-right"></i>
				<p class="delivery_options_title"><custom:getDescriptionByLocale description="${descriptions.delivery}"/></p>
			</div>
			<div class="delivery_options_body">
			
				<input type="hidden" name="delivery_radio_name" class="delivery_radio_name" value="">
				<input type="hidden" name="delivery_radio_value" class="delivery_radio_value" value="0">
				
				<table class="table table-hover table_delivery_options">
					<tbody>
					
						<c:if test="${ product.airDeliveryPriceSize || product.airDeliveryPriceWeight }">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="Авиа" id="aviaDelivery_price">
						        	<label class="add_price_delivery_title" for="aviaDelivery_price">
						        		<custom:getDescriptionByLocale description="${descriptions.delivery_avia}"/>
						        	</label>
						        </td>
						        <td>
						        	<div class="product_price">
										<input name="price_value" value="${
											(product.airDeliveryPriceSize ? product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * constants.price_avia_size : 0) + 
												(product.airDeliveryPriceWeight ? product.deliveryWeight * constants.price_avia_weight : 0)
											}" type="hidden">				
								   		<div></div>
									</div>
								</td>
								<td>${product.airDeliveryDescription}</td>
							</tr>
				      	</c:if>
				      	
				      	<c:if test="${ product.seaDeliveryPriceSize || product.seaDeliveryPriceWeight }">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="Морем" id="seaDelivery_price">
						        	<label class="add_price_delivery_title" for="seaDelivery_price">
						        		<custom:getDescriptionByLocale description="${descriptions.delivery_sea}"/></label>
						        </td>
						        <td>
									<div class="product_price">
										<input name="price_value" value="${
											(product.seaDeliveryPriceSize ? product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * constants.price_sea_size : 0) + 
												(product.seaDeliveryPriceWeight ? product.deliveryWeight * constants.price_sea_weight : 0)
											}" type="hidden">				
								   		<div></div>
									</div>
								</td>
								<td>${product.seaDeliveryDescription}</td>
							</tr>
				      	</c:if>
	
						<c:if test="${ product.ukraineDeliveryPriceSize || product.ukraineDeliveryPriceWeight }">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="По Украине" id="ukraineDelivery_price">
						        	<label class="add_price_delivery_title" for="ukraineDelivery_price">
						        		<custom:getDescriptionByLocale description="${descriptions.delivery_ukraine}"/>
						        	</label>
						        </td>
						        <td>
									<div class="product_price">
										<input name="price_value" value="${
											(product.ukraineDeliveryPriceSize ? product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * constants.price_ukraine_size : 0) + 
												(product.ukraineDeliveryPriceWeight ? product.deliveryWeight * constants.price_ukraine_weight : 0)
											}" type="hidden">				
								   		<div></div>
									</div>
								</td>
								<td>${product.ukraineDeliveryDescription}</td>
							</tr>
				      	</c:if>
				      	
				      	<c:if test="${ product.kyivDeliveryPriceSize || product.kyivDeliveryPriceWeight }">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="По Киеву" id="kyivDelivery_price">
						        	<label class="add_price_delivery_title" for="kyivDelivery_price"><custom:getDescriptionByLocale description="${descriptions.delivery_kiev}"/></label>
						        </td>
						        <td>
									<div class="product_price">
										<input name="price_value" value="${
											(product.kyivDeliveryPriceSize ? product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * constants.price_kyiv_size : 0) + 
												(product.kyivDeliveryPriceWeight ? product.deliveryWeight * constants.price_kyiv_weight : 0)
											}" type="hidden">				
								   		<div></div>
									</div>
								</td>
								<td>${product.kyivDeliveryDescription}</td>
							</tr>
				      	</c:if>
				      	
				      	<c:if test="${((product.deliveryWidth * product.deliveryHeight * product.deliveryDepth * product.variant1DeliveryPriceSize > 0) ||
						(product.deliveryWeight * product.variant1DeliveryPriceWeight > 0)) &&
						 ((product.variant1DeliveryName !=null) && (product.variant1DeliveryName!=''))}">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="${product.variant1DeliveryName}" id="variant1Delivery_price">
						        	<label class="add_price_delivery_title" for="variant1Delivery_price">${product.variant1DeliveryName}</label>
						        </td>
						        <td>
									<div class="product_price">
										<input name="price_value" value="${product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * product.variant1DeliveryPriceSize + 
												product.deliveryWeight * product.variant1DeliveryPriceWeight}" type="hidden">				
								   		<div></div>
									</div>
								</td>
								<td>${product.variant1DeliveryDescription}</td>
							</tr>
				      	</c:if>
				      	
				      	<c:if test="${((product.deliveryWidth * product.deliveryHeight * product.deliveryDepth * product.variant2DeliveryPriceSize > 0) ||
						(product.deliveryWeight * product.variant2DeliveryPriceWeight > 0)) &&
						 ((product.variant2DeliveryName !=null) && (product.variant2DeliveryName!=''))}">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="${product.variant2DeliveryName}" id="variant2Delivery_price">
						        	<label class="add_price_delivery_title" for="variant2Delivery_price">${product.variant2DeliveryName}</label>
						        </td>
						        <td>
									<div class="product_price">
										<input name="price_value" value="${product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * product.variant2DeliveryPriceSize + 
												product.deliveryWeight * product.variant2DeliveryPriceWeight}" type="hidden">				
								   		<div></div>
									</div>
								</td>
								<td>${product.variant2DeliveryDescription}</td>
							</tr>
				      	</c:if>
				      	
				      	<c:if test="${((product.deliveryWidth * product.deliveryHeight * product.deliveryDepth * product.variant3DeliveryPriceSize > 0) ||
						(product.deliveryWeight * product.variant3DeliveryPriceWeight > 0)) &&
						 ((product.variant3DeliveryName !=null) && (product.variant3DeliveryName!=''))}">
							<tr class="block_product_price">
								<td><input class="add_price_delivery" type="radio" name="delivery" value="${product.variant3DeliveryName}" id="variant3Delivery_price">
						        	<label class="add_price_delivery_title" for="variant3Delivery_price">${product.variant3DeliveryName}</label>
						        </td>
						        <td>
									<div class="product_price">
										<input name="price_value" value="${product.deliveryWidth * product.deliveryHeight * 
												product.deliveryDepth * product.variant3DeliveryPriceSize + 
												product.deliveryWeight * product.variant3DeliveryPriceWeight}" type="hidden">				
								   		<div></div>
									</div>
								</td>
								<td>${product.variant3DeliveryDescription}</td>
							</tr>
				      	</c:if>
				      	
				      	<c:if test="${product.insuranceInternationalTransport}">
					      <tr class="block_product_price">
					        <td>
					        	<input class="add_price" type="checkbox" value="Страхование груза международная перевозка" id="insuranceInternationalTransport_price">
					        	<label class="add_price_title"
					        	 for="insuranceInternationalTransport_price"><custom:getDescriptionByLocale description="${descriptions.delivery_insurance_international}"/></label>
					        </td>
					        <td>
								<div class="product_price">
									<input name="price_value" value="${product.prise * constants.percent_insurance_international / 100}" type="hidden">				
							   		<div></div>
								</div>
							</td>
					        <td>${product.descriptionInsuranceInternationalTransport}</td>
					      </tr>
				    </c:if>
				    
				    <c:if test="${product.insuranceUkraineTransport}">
					      <tr class="block_product_price">
					        <td>
					        	<input class="add_price" type="checkbox" value="Страхование груза по Украине" id="insuranceUkraineTransport_price">
					        	<label class="add_price_title"
					        	 for="insuranceUkraineTransport_price"><custom:getDescriptionByLocale description="${descriptions.delivery_insurance_ukraine}"/></label>
					        </td>
					        <td>
								<div class="product_price">
									<input name="price_value" value="${product.prise * constants.percent_insurance_ukraine / 100}" type="hidden">				
							   		<div></div>
								</div>
							</td>
					        <td>${product.descriptionInsuranceUkraineTransport}</td>
					      </tr>
				    </c:if>
				      	
				      	
						
					</tbody>
					
				</table>
				<div class="delivery_notes"><p>*</p><custom:getDescriptionByLocale description="${descriptions.delivery_notes}"/></div>
			</div>
		</td>
		
	</tr>
</c:if>


	<tr class="output_result_of_option">
		<td style="vertical-align: middle; min-width: 100px;"><custom:getDescriptionByLocale description="${descriptions.total_cost}"/>:</td>
        <td style="vertical-align: middle;">
        	<div class="total_price product_price">
			   	<input name="price_value" value="${product.prise}" type="hidden">				
			   	<div></div>
			</div>
        </td>
        <td>
        	<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="top: 0px; right: -30px; float: none;"
				onclick="addToCartProductPage('${type}', ${product.id}, '${product.name}', '${product.prise}', 
				'${product.pathPictures.get(0)}', getCheckedOption(), getCheckedDelivery());"></i>		
        </td>
	</tr>
	
		<tr>
	        <td colspan="3">
	        	<button class="btn btn-success" onclick="openModalProposalSuggestPrise('${type}', ${product.id}, '${product.name}', '${product.pathPictures.get(0)}')">
	        		<custom:getDescriptionByLocale description="${descriptions.ready_buy_for}"/></button>
	        </td>
		</tr>

    </tbody>
  </table>	
					
</div>