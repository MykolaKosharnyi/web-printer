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
				<!-- inport pictures presentation -->
				<jsp:include page="../product_page/pictures.jsp" />
                <div class="descriptions">			
				
                	<div id="name_product_head_description">${product.name}</div>
                	<div id="name_product_head_description">Код товара: ${product.partNumber}</div>
                    <table id="table_in_head">
                       <caption></caption> 
                                          
   					   <!-- set price in table row -->
					   <jsp:include page="../product_page/price.jsp" /> 
					   
                       <c:if test="${!empty product.typeProduct}">
   							<tr><td>Тип товара:</td><td>${product.typeProduct}</td></tr>
					   </c:if> 
					   
                  </table>
                  
<div class="option_product_with_price">
	
	<c:if test="${(product.optionInstallation > 0.01) ||
    			  (product.priceAddedOption > 0.01 && (product.nameAddedOption!=null && product.nameAddedOption!='')) ||
    			  (product.priceAddedOption2 > 0.01 && (product.nameAddedOption2!=null && product.nameAddedOption2!='')) ||
    			  (product.priceAddedOption3 > 0.01 && (product.nameAddedOption3!=null && product.nameAddedOption3!=''))}">            
	    <div class="title_block_product_price">
			<span class="price">Цена</span><span class="description">Описание</span>
		</div>             
    </c:if>   
	
	<c:if test="${product.optionInstallation > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="Инсталяция" id="optionInstallation_price">
				<label class="add_price_title" for="optionInstallation_price">Инсталяция</label>
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
				<label class="add_price_title" for="priceAddedOption_price">${product.nameAddedOption}</label>
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
				<label class="add_price_title" for="priceAddedOption2_price">${product.nameAddedOption2}</label>
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
				<label class="add_price_title" for="priceAddedOption3_price">${product.nameAddedOption3}</label>
			</input>
			<label class="add_price_value">$<span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.priceAddedOption3}" /></span>
			</label>
			<label class="option_description">${product.descriptionOptionAddedOption3}</label>
		</div>
	</c:if>
	
	<c:if test="${product.optionVAT > 0.01}">
		<div class="block_product_price">
			<input class="add_price" type="checkbox" value="НДС" id="optionVAT_price">
				<label class="add_price_title" for="optionVAT_price">НДС</label>
			</input>
			<label class="add_price_value" style="display:none;"><span><fmt:formatNumber type="number" 
			   			maxFractionDigits="2" minFractionDigits="2" value="${product.optionVAT}" /></span>
			</label>
			<label class="option_description" style="margin-left:65px;">${product.descriptionOptionVAT}</label>
		</div>
	</c:if>
		                  
	<label class="total_ptice_title">Стоимость:</label>
		                  
	<label class="total_price">$<span><fmt:formatNumber type="number" 
			   	maxFractionDigits="2" minFractionDigits="2" value="${product.prise}" /></span>
	</label>
		                  
	<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="top: 5px; right: -30px; float: none;"
			onclick="addToCartProductPage('${type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}', getCheckedOption());"></i>                  
            
					
		</div>
             </div>
          </div>
            <div id="tabs_product">
                <ul id="sub_tabs_product">
                    <li>Описание</li>
                </ul>
                <div>
                    <div id="output_description">${product.description}</div>
                </div>            
            </div> 
        </div>

		 <script type="text/javascript">
	
	function getCheckedOption(){
		var checkedArray = [];
		$("input.add_price:checked").each(function(){
			checkedArray.push($(this).val());
		});
		return checkedArray;
	}
	
	/*
		Set the price after onload page. It was done for cause when user checked addition
	option and onload page or open this tab in the future. After it price include price 
	for option and VAT coeficient.
	*/
	$( document ).ready(function() {//set price while onload page
		var price_element = $('.option_product_with_price').find('label.total_price span');
		var currentPrice = new Number(price_element.text().replace(/\s/ig, '').replace(",", "."));
		
		var valueVAT = 1;
		$("input.add_price:checked").each(function(){
			//add to price or if it is VAT coeficient
			var addPrice = new Number($(this).parent('.block_product_price').find('label.add_price_value span').text().replace(/\s/ig, '').replace(",", "."));
			if($(this).val()!="НДС"){
				currentPrice = currentPrice + addPrice;
			} else {
				valueVAT = addPrice;
			}
			
			$(this).parent('.block_product_price').css('color', '#006080');
		});
		price_element.text(checkPriseProduct(currentPrice * valueVAT));
	});

	
	$(function(){
		$('.add_price').click(function(){
			// from wich we taken current price and after add/sub operation insert again value
            var price_element = $(this).parent('.block_product_price').parent('.option_product_with_price').find('label.total_price span');
			// total price in number presentation
			var currentPrice = new Number(price_element.text().replace(/\s/ig, '').replace(",", "."));
			// for changing style outer block if option checked
            var change_style = $(this).parent('.block_product_price');
			// value wich will be added or substraction from all price for the product
			var addPrice = new Number($(this).parent('.block_product_price').find('label.add_price_value span').text().replace(/\s/ig, '').replace(",", "."));
			
            if ($(this).prop( "checked" )) {
            	/* check if it not checked VAT option; because for VAT option different way to calculate price */
            	if($(this).val()!="НДС"){
                	price_element.text(checkPriseProduct( calculatePriceIncludingVAT(currentPrice, addPrice, true) ));
            	} else {
            		var valueVAT = new Number($(this).parent('.block_product_price').find('label.add_price_value span').text().replace(/\s/ig, '').replace(",", "."));
            		price_element.text(checkPriseProduct(currentPrice * valueVAT));
            	}
            	
            	change_style.css('color', '#006080');
            	
            }else{
            	/* check if it not checked VAT option; because for VAT option different way to calculate price */
            	if($(this).val()!="НДС"){
            		price_element.text(checkPriseProduct( calculatePriceIncludingVAT(currentPrice, addPrice, false) ));
            	} else {
            		var valueVAT = new Number($(this).parent('.block_product_price').find('label.add_price_value span').text().replace(/\s/ig, '').replace(",", "."));
            		price_element.text(checkPriseProduct(currentPrice / valueVAT));
            	}
            	change_style.css('color', '#333');
            }
            
        });
		
		/* calculating price include value of VAT; in the last operand boolead value: true for adding, false for substraction */
		function calculatePriceIncludingVAT(totalPrice, addPrice, typeOfOperation){
			var valueVATOption = valueVAT();
			/*if(typeOfOperation){
				return ((totalPrice/valueVATOption) + addPrice) * valueVATOption;
			} else {
				return ((totalPrice/valueVATOption) - addPrice) * valueVATOption;
			}*/
			
			return typeOfOperation ? ((totalPrice/valueVATOption) + addPrice) * valueVATOption : ((totalPrice/valueVATOption) - addPrice) * valueVATOption;
			  
		}
		
		/* get value of ckecked VAT option if it not return '1' */
		function valueVAT(){
			if($('input#optionVAT_price').prop( "checked" )){
				return new Number($('input#optionVAT_price').parent('.block_product_price')
						.find('label.add_price_value span').text().replace(/\s/ig, '').replace(",", "."));
			} else {
				return new Number(1);
			}
		}
		
	});
	
	function checkPriseProduct(num){
		  num = Math.round( num / 0.01 ) * 0.01;
		  num = new Number(num).toFixed(2);   // особенности счета JavaScript ( x/100 не всегда = x*0.01 )
		  var s = 0;
		  var str = '';
		  for( var i=num.toString().length-1; i>=0; i-- ) {
		    s++;
		    str = num.toString().charAt(i) + str;
		    if(num.toString().charAt(i)=='.') s=0;
		    if( s > 0 && !(s % 3) ) str  = " " + str;
		  }   
		  return str.replace(".", ",");
	
}
</script>

</body>
</html>