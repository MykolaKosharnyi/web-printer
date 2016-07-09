<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="option_product_with_price">
                 	
	<c:if test="${product.optionRIP > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Програмное обеспечение" id="optionRIP_price">
				<label class="add_price_title" for="optionRIP_price">Програмное обеспечение:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.optionRIP}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionRIP}</label>
		</div>
	</c:if>
                 		
	<c:if test="${product.optionSNCP > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="СНЧП" id="optionSNCP_price">
				<label class="add_price_title" for="optionSNCP_price">СНЧП:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
						maxFractionDigits="2" minFractionDigits="2" value="${product.optionSNCP}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionSNCP}</label>
		</div>
	</c:if>
     
    <c:if test="${product.optionVAT > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="НДС" id="optionVAT_price">
				<label class="add_price_title" for="optionVAT_price">НДС:</label>
			</input>
			<label class="add_price_value"><span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.optionVAT}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionVAT}</label>
		</div>
	</c:if>
                 		
	<c:if test="${product.optionDelivery > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Доставка" id="optionDelivery_price">
				<label class="add_price_title" for="optionDelivery_price">Доставка:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.optionDelivery}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionDelivery}</label>
		</div>
	</c:if>
	
	<c:if test="${product.optionInstallation > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Инсталяция" id="optionInstallation_price">
				<label class="add_price_title" for="optionInstallation_price">Инсталяция:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.optionInstallation}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionInstallation}</label>
		</div>
	</c:if>
                 		
	<c:if test="${product.priceAddedOption > 0.01 && (product.nameAddedOption!=null && product.nameAddedOption!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${product.nameAddedOption}" id="priceAddedOption_price">
				<label class="add_price_title" for="priceAddedOption_price">${product.nameAddedOption}:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionAddedOption}</label>
		</div>
	</c:if>
	
	<c:if test="${product.priceAddedOption2 > 0.01 && (product.nameAddedOption2!=null && product.nameAddedOption2!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${product.nameAddedOption2}" id="priceAddedOption2_price">
				<label class="add_price_title" for="priceAddedOption2_price">${product.nameAddedOption2}:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption2}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionAddedOption2}</label>
		</div>
	</c:if>
	
	<c:if test="${product.priceAddedOption3 > 0.01 && (product.nameAddedOption3!=null && product.nameAddedOption3!='')}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="${product.nameAddedOption3}" id="priceAddedOption3_price">
				<label class="add_price_title" for="priceAddedOption3_price">${product.nameAddedOption3}:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption3}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionAddedOption3}</label>
		</div>
	</c:if>
                 		
	<c:if test="${product.optionGuarantee > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Гарантия" id="optionGuarantee_price">
				<label class="add_price_title" for="optionGuarantee_price">Гарантия:</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.optionGuarantee}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionGuarantee}</label>
		</div>
	</c:if> 
		                  
	<label class="total_ptice_title">Стоимость:</label>
		                  
	<label class="total_price">$<span><fmt:formatNumber type="number" 
			   	maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></span>
	</label>
		                  
	<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="top: 5px; right: -30px; float: none;"
			onclick="addToCartProductPage('${type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}', new Array());"></i>
</div>