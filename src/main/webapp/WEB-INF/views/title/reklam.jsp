<%@ page contentType="text/html; charset=UTF-8"%>
	<div id="reklam"></div>
 <script type="text/javascript">
 $(document).ready(function () {

	  //var jsonURL = "/images/reklam.json";
	  var reklam = ${reklam};
				
		$.each(reklam, function(i, value) {
        	var outerDiv = $('<div/>');
        	
        				outerDiv.addClass("slide-item").append($('<a/>').addClass("slider_image")
        								 .attr("href", "/" + value.type + "/" + value.id)
        								 .append($('<div/>').addClass("outer_a_img").append($('<img/>').attr("src", value.pathToPicture))))
        				.append($('<a/>').addClass("slide-buy")
        								 .attr("href", "javascript:void(0)").click(function(){
        			                			addToCart(value.type, value.id);
        			                		})
        								 .append($('<img/>').attr("src", "/images/button_buy.png")))				 					 
                		.append($('<a/>').attr("href", "/" + value.type + "/" + value.id).addClass("slide-title").text(value.nameProduct))
                		.append($('<div/>').addClass("slide-price").text("Цена: $" + value.priceProduct))
        	
        	
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
