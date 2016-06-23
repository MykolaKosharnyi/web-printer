<%@ page contentType="text/html; charset=UTF-8"%>
	<div id="reklam"></div>
 <script type="text/javascript">
 $(document).ready(function () {

	  //var jsonURL = "/images/reklam.json";
	  var reklam = ${reklam};
				
		$.each(reklam, function(i, value) {
        	var outerDiv = $('<div/>');
        				var slidePrice = $('<p/>').addClass("slide-price").append($('<div/>').text("Цена:").css(
        						{
        							"float":"left",
        							"margin-right": "5px"
        						}));
        				if(value.priceProduct < 0.1){
        					slidePrice.append($('<a/>').attr("href","#callback_reklam").addClass('fancybox').text("\u0443\u0442\u043E\u0447\u043D\u044F\u0439\u0442\u0435"));
        				} else {
        					slidePrice.append($('<div/>').text(checkPrise(value.priceProduct)));
        				}
        	
        				outerDiv.addClass("slide-item").append($('<a/>').addClass("slider_image")
        								 .attr("href", "/" + value.type + "/" + value.id)
        								 .append($('<div/>').addClass("outer_a_img").append($('<img/>').attr("src", "/images/" + value.type + "s/" + value.id+ "/" +value.pathToPicture))))				 					 
                		.append($('<a/>').attr("href", "/" + value.type + "/" + value.id).addClass("slide-title").text(value.nameProduct))
                		.append(slidePrice)
                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
        			                			addToCart(value.type, value.id, value.nameProduct, value.priceProduct+'', value.pathToPicture);
        			                		}))
        	
        	
        	if(value.leftSharesLink!=null && value.leftSharesLink!=""){
        		outerDiv.append($('<div/>').addClass("ribbon-wrapper-left")
									.append($('<div/>').addClass("ribbon-left")
													   .text(value.leftSharesLink)
													   .css( "color", value.leftSharesLinkColorText )
													   .css( "background", value.leftSharesLinkColorFone )
													   ))
			}
        	
        	if(value.rightSharesLink!=null && value.rightSharesLink!=""){
        		outerDiv.append($('<div/>').addClass("ribbon-wrapper-right")
									.append($('<div/>').addClass("ribbon-right")
													   .text(value.rightSharesLink)
													   .css( "color", value.rightSharesLinkColorText )
													   .css( "background", value.rightSharesLinkColorFone )
													   ))
			}
        	
        	$("#reklam").prepend(outerDiv)
        	
        });
		
});
</script>
