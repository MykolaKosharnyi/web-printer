<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<script type="text/javascript">
	$(function () {
		var austDay = new Date();
		austDay = new Date(${product.timeShares.getTime()});
		$('#clock').countdown({until: austDay, format: 'D H M'});
	});
	
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
			return typeOfOperation ?
					((totalPrice/valueVATOption) + addPrice) * valueVATOption : 
					((totalPrice/valueVATOption) - addPrice) * valueVATOption;
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