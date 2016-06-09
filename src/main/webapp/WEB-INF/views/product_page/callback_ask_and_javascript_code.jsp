<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<div class="hidden">
	<form id="callback" class="pop_form">
		<h5 style="max-width: 300px;">Пожалуйста оставьте координаты, через некоторое время мы с вами свяжемся</h5>
		<input type="hidden" name="id" value="${product.id}">
		<input type="hidden" name="typeProduct" value="${type}">
		<input type="text" name="name" placeholder="Ваше имя..." required />
		<input type="text" name="phone" placeholder="Ваше телефон..." required />
		<button class="button" type="submit">Уточнить</button>
	</form>
</div>
<script type="text/javascript">
	$(function () {
		var austDay = new Date();
		austDay = new Date(${product.timeShares.getTime()});
		$('#clock').countdown({until: austDay, format: 'D H M'});
	});
	
	$(function(){
		$('.add_price').click(function(){
            var price_element = $(this).parent('.block_product_price').parent('.option_product_with_price').find('label.total_price span');
			var currentPrice = new Number(price_element.text().replace(/\s/ig, '').replace(",", "."));
            var change_style = $(this).parent('.block_product_price');
            var value_add_price = $(this).parent('.block_product_price').find('label.add_price_value span').text();
			var addPrice = new Number(value_add_price.replace(/\s/ig, '').replace(",", "."));

            if ($(this).prop( "checked" )) {
            	change_style.css('color', '#006080');

				price_element.text(checkPrise(currentPrice+addPrice));
            }else{
            	change_style.css('color', '#333');
				price_element.text(checkPrise(currentPrice-addPrice));
            }
            
        });
		
		function checkPrise(num){
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
	});
</script>