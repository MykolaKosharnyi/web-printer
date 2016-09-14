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
			 '${product.prise}', '${product.pathPictures.get(0)}', getCheckedOption(), getCheckedDelivery());"></i>		
        </td>
	</tr>

    </tbody>
  </table>	
					
</div>