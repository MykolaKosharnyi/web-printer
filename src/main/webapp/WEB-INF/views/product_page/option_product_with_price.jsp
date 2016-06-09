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
		</div>
	</c:if> 
		                  
	<label class="total_ptice_title">Стоимость:</label>
		                  
	<label class="total_price">$<span><fmt:formatNumber type="number" 
			   	maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></span>
	</label>
		                  
	<a href="javascript:void(0)" onclick="addToCart('${type}', ${product.id});" class="products_buy">
		<img src="/images/button_buy.png" alt="" />
	</a>
</div>