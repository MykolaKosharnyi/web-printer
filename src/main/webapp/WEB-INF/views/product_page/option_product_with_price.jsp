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
		<c:if test="${product.optionRIP > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="Програмное обеспечение" id="optionRIP_price" style="top:-18px;">
	        	<label class="add_price_title" for="optionRIP_price">Програмное обеспечение</label>
	        </td>
	        <td>
				<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.optionRIP}" /></span>
				</label>
			</td>
	        <td>${product.descriptionOptionRIP}</td>
	      </tr>
		</c:if>
	
		<c:if test="${product.optionSNCP > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="СНЧП" id="optionSNCP_price">
	        	<label class="add_price_title" for="optionSNCP_price">СНЧП</label>
	        </td>
	        <td>
				<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.optionSNCP}" /></span>
				</label>
			</td>
	        <td>${product.descriptionOptionSNCP}</td>
	      </tr>
		</c:if>

      <c:if test="${product.optionDelivery > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="Доставка" id="optionDelivery_price">
	        	<label class="add_price_title" for="optionDelivery_price">Доставка</label>
	        </td>
	        <td>
				<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.optionDelivery}" /></span>
				</label>
			</td>
	        <td>${product.descriptionOptionDelivery}</td>
	      </tr>
      </c:if>

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

      <c:if test="${product.optionGuarantee > 0.01}">
	      <tr class="block_product_price">
	        <td><input class="add_price" type="checkbox" value="Гарантия" id="optionGuarantee_price">
	        	<label class="add_price_title" for="optionGuarantee_price">Гарантия</label>
	        </td>
	        <td>
				<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.optionGuarantee}" /></span>
				</label>
			</td>
	        <td>${product.descriptionOptionGuarantee}</td>
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
	
	<tr class="delivery">
		<td colspan="3">
			<div class="delivery_options">
				<i class="fa fa-arrow-right"></i>
				<p class="delivery_options_title">Доставка</p>
			</div>
			<div class="delivery_options_body">
				<table class="table table-hover table_delivery_options">
					<tbody>
						<tr class="block_product_price">
					        <td><input class="add_price_delivery" type="checkbox" value="Авиа" id="aviaDelivery_price">
					        	<label class="add_price_delivery_title" for="aviaDelivery_price">Авиа</label>
					        </td>
					        <td>
					        	<label class="add_price_delivery_value">С учетом габаритов: 1м * 1.5м * 1.5м * $10 = $<span><fmt:formatNumber type="number" 
										maxFractionDigits="2" minFractionDigits="2" value="${1 * 1.5 * 1.5 * 10}" /></span>
								</label>
								<br>
								<label class="add_price_delivery_value">С учетом веса: 2000кг * $5 = $<span><fmt:formatNumber type="number" 
										maxFractionDigits="2" minFractionDigits="2" value="${2000 * 5}" /></span>
								</label>
								
							</td>
						</tr>
						
						<tr class="block_product_price">
					        <td><input class="add_price_delivery" type="checkbox" value="Морем" id="seaDelivery_price">
					        	<label class="add_price_delivery_title" for="seaDelivery_price">Морем</label>
					        </td>
					        <td>
					        	С учетом габаритов: 1м * 1.5м * 1.5м * $10 = $22.5
								<br>
								С учетом веса: 2000кг * $5 = $10 000
							</td>
						</tr>
						
					</tbody>
				</table>
			</div>
			
		</td>
	</tr>

	<tr class="output_result_of_option">
		<td style="vertical-align: middle;">Общая стоимость:</td>
        <td style="vertical-align: middle;">
        	<label class="total_price">$<span><fmt:formatNumber type="number" 
			   	maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></span>
			</label>
        </td>
        <td>
        	<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="top: 0px; right: -30px; float: none;"
			onclick="addToCartProductPage('${type}', ${product.id}, '${product.name}',
			 '${product.prise}', '${product.pathPictures.get(0)}', getCheckedOption());"></i>		
        </td>
	</tr>

    </tbody>
  </table>	
					
</div>