<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div id="top_result_of_search">
	<c:forEach items="${listProducts}" var="product">
		<c:if test="${product.top}">
			<div class="products">
				<div class="inner_div_product">
					<a id="
					
						<c:choose>
			   		 		<c:when test="${fn:length(product.pathPictures) > 1}">/images/${product.type}s/${product.id}/${product.pathPictures.get(1)}</c:when>    
			    			<c:otherwise>/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}</c:otherwise>
						</c:choose>
			
						
						" onmouseover="" class="link" href="<c:url value='/${product.type}/${product.id}' />">	
								<div class="outer_a_img"><img src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
					</a>
		
					<div class="name_price_cart_block">
						<a href="<c:url value='/${product.type}/${product.id}' />" class="products_title">${product.name}</a>
						<div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
							<input type="hidden" name="price_value" value="${product.prise}">
				       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
							<c:if test="${!(product.prise < 0.1)}">
								<div></div>
							</c:if>
		           		</div>
		
						<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="padding-right: 5px; top: 2px; right: 10px; position: absolute;"
							onclick="addToCart('${product.type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}');"></i>
					</div>	
					
					<div class="name_price_cart_block_hidden">
						<c:if test="${product.type=='printer' && product.ratingOverallRating > 0}">
							<!-- Общая оценка -->
								<div class="rating_block">
									<p style="font-weight: bold;">Общая оценка:</p>
									<div style="width: 100px; float: left;">
										<ul class="rating_average clearfix">
											<li class="current" style="width: ${product.ratingOverallRating * 20}%;"><span class="star1" title="Плохо"></span></li>
											<li><span class="star2" title="Ниже среднего" ></span></li>
											<li><span class="star3" title="Средне" ></span></li>
											<li><span class="star4" title="Хорошо"  ></span></li>
											<li><span class="star5" title="Очень хорошо" ></span></li>
										</ul>
									</div>
								</div>
						</c:if>
						
						<!-- type of printhead -->
						<c:if test="${product.type=='printer' && !empty product.typeOfPrinthead}">							
							<div style="height: 40px; margin-bottom: 5px;">
								<p style="font-weight: bold; width: 50%; float: left;">Тип печатающей головки:</p>
								<div style="float: left; width: 50%;">${product.typeOfPrinthead}</div>
							</div>
						</c:if>			
						
						<!-- print resolution -->
						<c:if test="${product.type=='printer' && product.inputFirstPrintResolution != 0 && product.inputSecondPrintResolution != 0}">
							<div style="height: 40px; margin-bottom: 5px;">
								<p style="font-weight: bold; width: 50%; float: left;">Разрешение печати:</p>
								<div style="float: left; width: 50%;">${product.inputFirstPrintResolution}x${product.inputSecondPrintResolution}dpi</div>
							</div>
						</c:if>
                      
                      	<c:if test="${product.type=='printer' && (product.inputFirstPrintResolution == 0 || product.inputSecondPrintResolution == 0) && !empty product.printResolution}">
                      		<div style="height: 40px; margin-bottom: 5px;">
								<p style="font-weight: bold; width: 50%; float: left;">Разрешение печати:</p>
								<div style="float: left; width: 50%;">
									<c:forEach var="tp" items="${product.printResolution}" varStatus="status">  
	    								${tp}<c:if test="${ ! status.last}" >, </c:if>  
									</c:forEach>  </div>
							</div>
						</c:if>
						
						<!-- chromaticity -->
						<c:if test="${product.type=='printer' && !empty product.chromaticity}">
							<div style="height: 30px; margin-bottom: 5px;">
								<p style="font-weight: bold; width: 50%; float: left;">Цветовая схема:</p>
								<div style="float: left; width: 50%;">
									<c:forEach var="tp" items="${product.chromaticity}" varStatus="status">  
		                   		
			                   			<c:if test="${tp.equals('CMYK')}">
											${tp}<c:if test="${product.chromaticityCMYK!=''}" >+${product.chromaticityCMYK}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
										</c:if>
										
										<c:if test="${tp.equals('CMYK x 2')}">
											${tp}<c:if test="${product.chromaticityCMYKx2!=''}" >+${product.chromaticityCMYKx2}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
										</c:if>
										
										<c:if test="${tp.equals('CMYKLcLm')}">
											${tp}<c:if test="${product.chromaticityCMYKLcLm!=''}" >+${product.chromaticityCMYKLcLm}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
										</c:if>
										
										<c:if test="${tp.equals('CMYKLcLmOG')}">
											${tp}<c:if test="${product.chromaticityCMYKLcLmOG!=''}" >+${product.chromaticityCMYKLcLmOG}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
										</c:if>
		    						
									</c:forEach> 
								</div>
							</div>
						</c:if>	
						
					</div>	
		
					<c:if test="${!empty product.leftSharesLink}">
						<div class="ribbon-search-wrapper-left">
							<div class="ribbon-search-left" style="color:${product.leftSharesLinkColorText}; background:${product.leftSharesLinkColorFone};">
								${product.leftSharesLink}
							</div>
						</div>
					</c:if>
					
					<c:if test="${!empty product.rightSharesLink}">
						<div class="ribbon-search-wrapper-right">
							<div class="ribbon-search-right" style="color:${product.rightSharesLinkColorText}; background:${product.rightSharesLinkColorFone};">
								${product.rightSharesLink}
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</c:if>
	</c:forEach>
</div>

<div id="out_result_of_search">
	<c:forEach items="${listProducts}" var="product">
		<c:if test="${!product.top}">
		<div class="products">
			<div class="inner_div_product">
				<a id="
				
				<c:choose>
	   		 		<c:when test="${fn:length(product.pathPictures) > 1}">/images/${product.type}s/${product.id}/${product.pathPictures.get(1)}</c:when>    
	    			<c:otherwise>/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}</c:otherwise>
				</c:choose>
	
				
				" onmouseover="" class="link" href="<c:url value='/${product.type}/${product.id}' />">	
						<div class="outer_a_img"><img src="/images/${product.type}s/${product.id}/${product.pathPictures.get(0)}" alt=""></div>
				</a>
	
				<div class="name_price_cart_block">
					<a href="<c:url value='/${product.type}/${product.id}' />" class="products_title">${product.name}</a>
					<div class="product_price"><span style="float: left;">Цена:&nbsp;</span> 
						<input type="hidden" name="price_value" value="${product.prise}">
			       		<c:if test="${product.prise < 0.1}"><a href="#callback" class="fancybox">уточняйте</a></c:if>
						<c:if test="${!(product.prise < 0.1)}">					
		   					<div></div>
						</c:if>
	           		</div>
	
					<i class="fa fa-cart-plus add_to_cart" aria-hidden="true" style="padding-right: 5px; top: 2px; right: 10px; position: absolute;"
						onclick="addToCart('${product.type}', ${product.id}, '${product.name}', '${product.prise}', '${product.pathPictures.get(0)}');"></i>
				</div>	
				
				<div class="name_price_cart_block_hidden">
					<c:if test="${product.type=='printer' && product.ratingOverallRating > 0}">
						<!-- Общая оценка -->
							<div class="rating_block">
								<p style="font-weight: bold;">Общая оценка:</p>
								<div style="width: 100px; float: left;">
									<ul class="rating_average clearfix">
										<li class="current" style="width: ${product.ratingOverallRating * 20}%;"><span class="star1" title="Плохо"></span></li>
										<li><span class="star2" title="Ниже среднего" ></span></li>
										<li><span class="star3" title="Средне" ></span></li>
										<li><span class="star4" title="Хорошо"  ></span></li>
										<li><span class="star5" title="Очень хорошо" ></span></li>
									</ul>
								</div>
							</div>
					</c:if>
					
					<!-- type of printhead -->
						<c:if test="${product.type=='printer' && !empty product.typeOfPrinthead}">							
							<div style="height: 40px; margin-bottom: 5px;">
								<p style="font-weight: bold; width: 50%; float: left;">Тип печатающей головки:</p>
								<div style="float: left; width: 50%;">${product.typeOfPrinthead}</div>
							</div>
						</c:if>			
						
						<!-- print resolution -->
						<c:if test="${product.type=='printer' && product.inputFirstPrintResolution != 0 && product.inputSecondPrintResolution != 0}">
							<div style="height: 40px; margin-bottom: 5px;">
								<p style="font-weight: bold; width: 50%; float: left;">Разрешение печати:</p>
								<div style="float: left; width: 50%;">${product.inputFirstPrintResolution}x${product.inputSecondPrintResolution}dpi</div>
							</div>
						</c:if>
                      
                      	<c:if test="${product.type=='printer' && (product.inputFirstPrintResolution == 0 || product.inputSecondPrintResolution == 0) && !empty product.printResolution}">
                      		<div style="height: 40px; margin-bottom: 5px;">
								<p style="font-weight: bold; width: 50%; float: left;">Разрешение печати:</p>
								<div style="float: left; width: 50%;">
									<c:forEach var="tp" items="${product.printResolution}" varStatus="status">  
	    								${tp}<c:if test="${ ! status.last}" >, </c:if>  
									</c:forEach>  </div>
							</div>
						</c:if>
						
						<!-- chromaticity -->
						<c:if test="${product.type=='printer' && !empty product.chromaticity}">
							<div style="height: 30px; margin-bottom: 5px;">
								<p style="font-weight: bold; width: 50%; float: left;">Цветовая схема:</p>
								<div style="float: left; width: 50%;">
									<c:forEach var="tp" items="${product.chromaticity}" varStatus="status">  
		                   		
			                   			<c:if test="${tp.equals('CMYK')}">
											${tp}<c:if test="${product.chromaticityCMYK!=''}" >+${product.chromaticityCMYK}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
										</c:if>
										
										<c:if test="${tp.equals('CMYK x 2')}">
											${tp}<c:if test="${product.chromaticityCMYKx2!=''}" >+${product.chromaticityCMYKx2}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
										</c:if>
										
										<c:if test="${tp.equals('CMYKLcLm')}">
											${tp}<c:if test="${product.chromaticityCMYKLcLm!=''}" >+${product.chromaticityCMYKLcLm}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
										</c:if>
										
										<c:if test="${tp.equals('CMYKLcLmOG')}">
											${tp}<c:if test="${product.chromaticityCMYKLcLmOG!=''}" >+${product.chromaticityCMYKLcLmOG}</c:if> <c:if test="${ ! status.last}" >, </c:if> 
										</c:if>
		    						
									</c:forEach> 
								</div>
							</div>
						</c:if>	
				</div>	
	
				<c:if test="${!empty product.leftSharesLink}">
					<div class="ribbon-search-wrapper-left">
						<div class="ribbon-search-left" style="color:${product.leftSharesLinkColorText}; background:${product.leftSharesLinkColorFone};">
							${product.leftSharesLink}
						</div>
					</div>
				</c:if>
				
				<c:if test="${!empty product.rightSharesLink}">
					<div class="ribbon-search-wrapper-right">
						<div class="ribbon-search-right" style="color:${product.rightSharesLinkColorText}; background:${product.rightSharesLinkColorFone};">
							${product.rightSharesLink}
						</div>
					</div>
				</c:if>
			</div>
		</div>
		</c:if>
	</c:forEach>
</div>

<script type="text/javascript">
jQuery(document).ready(function($) {
	var topResult = $('#top_result_of_search');
	
	if(topResult.find('.products').length > 0){
    	topResult.prepend($('<div/>').addClass('top_result_title').text("Топ Продаж"));
    	topResult.append($('<div/>').addClass('top_result_title').text("Топ Продаж"));
    	topResult.height( Math.ceil(topResult.find('.products').length/3 ) * (topResult.find('.products').first().height() + 6 ) +
    		topResult.find('.top_result_title').outerHeight(true)*2);
    	topResult.css("margin-bottom","12px");
    } else {
    	topResult.height(0);
    	topResult.css("margin-bottom","0px");
    }
}); // ready()

$(function(){
	/* for changing background picture */
	$("#top_result_of_search, #out_result_of_search").on('mouseenter', '.products a.link', function() {
		var currImg = $(this).find('img').attr('src');
	  	var needImg = $(this).attr('id');
	  
	  $(this).find('img')
		.attr('src', needImg);
	  $(this).attr('id', currImg);
	});
	
	$("#top_result_of_search, #out_result_of_search").on('mouseleave', '.products a.link', function() {
		var currImg = $(this).find('img').attr('src');
	   	var needImg = $(this).attr('id');
		  
	   $(this).find('img')
		 .attr('src', needImg);
	   $(this).attr('id', currImg);
	});
	
	$("#top_result_of_search, #out_result_of_search").on('mouseenter', '.ribbon-search-wrapper-left, .ribbon-search-wrapper-right', function() {
		var currImg = $(this).parent('.inner_div_product').parent('.products').find('.inner_div_product a.link').find('img').attr('src');
	  	var needImg = $(this).parent('.inner_div_product').parent('.products').find('.inner_div_product a.link').attr('id');
	  
	  $(this).parent('.inner_div_product').parent('.products').find('.inner_div_product a.link').find('img')
		.attr('src', needImg);
	  $(this).parent('.inner_div_product').parent('.products').find('.inner_div_product a.link').attr('id', currImg);
	});
	
	$("#top_result_of_search, #out_result_of_search").on('mouseleave', '.ribbon-search-wrapper-left, .ribbon-search-wrapper-right', function() {
		var currImg = $(this).parent('.inner_div_product').parent('.products').find('.inner_div_product a.link').find('img').attr('src');
	  	var needImg = $(this).parent('.inner_div_product').parent('.products').find('.inner_div_product a.link').attr('id');
	  
	  $(this).parent('.inner_div_product').parent('.products').find('.inner_div_product a.link').find('img')
		.attr('src', needImg);
	  $(this).parent('.inner_div_product').parent('.products').find('.inner_div_product a.link').attr('id', currImg);
	});
	
	/* for changing height of name and price after hovering on product field */
	$("#top_result_of_search, #out_result_of_search").on('mouseenter', '.products', function() {
		var name_and_price_block = $(this).find('.name_price_cart_block');
		name_and_price_block.outerHeight(name_and_price_block.find('a.products_title').outerHeight(true) + name_and_price_block.find('.product_price').outerHeight(true) + 18);
	});
	
	$("#top_result_of_search, #out_result_of_search").on('mouseleave', '.products', function() {
		var name_and_price_block = $(this).find('.name_price_cart_block');
		name_and_price_block.outerHeight(54);
	});
});

/*----  Для вывода товара при поиске  -----*/        
$(document).ready(function() {
	
	$('#search').ajaxForm( {
		type: 'post',
		success: function(products) { 
			$("#out_result_of_search").html('');
			$("#top_result_of_search").html('');
			
            $(products).each(function(i, product) {
            	var outerDiv = $('<div/>').addClass("products");
            	var innterDiv = $('<div/>').addClass('inner_div_product');

            	var slidePrice = $('<div/>').addClass("product_price").append($('<span/>').text("Цена:").css(
						{
							"float":"left",
							"margin-right": "5px"
						}));
				if(product.prise < 0.1){
					slidePrice.append($('<a/>').attr("href","#callback_reklam").addClass('fancybox').text("\u0443\u0442\u043E\u0447\u043D\u044F\u0439\u0442\u0435"));
				} else {
					slidePrice.append($('<input/>').attr("type", "hidden").val(product.prise));
					slidePrice.append($('<div/>').text(checkPrise(product.prise)));
				}
            	
				innterDiv.append($('<a/>').attr("id", "/images/${product.type}s/" + product.id + "/" + checkPicture(product.pathPictures))
   								 			 .addClass("link")
            								 .attr("href", "/${product.type}/" + product.id)
            								 .append($('<div/>').addClass("outer_a_img").append($('<img/>').attr("src", "/images/${product.type}s/" + product.id + "/" + product.pathPictures[0]))))
            				.append($('<div/>').addClass("name_price_cart_block")
	                				.append($('<a/>').attr("href", "/${product.type}/" + product.id).addClass("products_title").text(product.name))
	    	                		.append(slidePrice)
	    	                		.append($('<i/>').addClass("fa fa-cart-plus add_to_cart").click(function(){
        			                			addToCart("${product.type}" , product.id, product.name, product.prise+'', product.pathPictures[0]);
        			                		}).css(
        			        						{
        			        							"padding-right": "5px",
        			        							"top": "2px",
        			        							"right": "10px",
        			        							"position": "absolute"
        			        						})))	  
    			        						
        			        		var name_price_cart_block = $('<div/>').addClass('name_price_cart_block_hidden');			
        			        						
        			        		if("${product.type}"=='printer' && product.ratingOverallRating > 0){	       			        			
        			        			name_price_cart_block.append($('<div/>').addClass('rating_block')
        			        							.append($('<p/>').css( "font-weight", "bold" ).text("Общая оценка:"))
        			        							.append($('<div/>').css( "width", "100px" ).css( "float", "left" )
        			        									.append($('<ul/>').addClass('rating_average clearfix')
        			        											.append($('<li/>').addClass('current').css( "width", product.ratingOverallRating * 20 + "%" )
        			        													.append($('<span/>').addClass('star1').attr("title", "Плохо")))
        			        											.append($('<li/>').append($('<span/>').addClass('star2').attr("title", "Ниже среднего")))
        			        											.append($('<li/>').append($('<span/>').addClass('star3').attr("title", "Средне")))
        			        											.append($('<li/>').append($('<span/>').addClass('star4').attr("title", "Хорошо")))
        			        											.append($('<li/>').append($('<span/>').addClass('star4').attr("title", "Очень хорошо")))
        			        									)))
        			        		}
			// in this block added information about print head		
			if("${product.type}"=='printer' && product.typeOfPrinthead!=null && product.typeOfPrinthead!=""){
				name_price_cart_block.append($('<div/>').css( "height", "40px" ).css( "margin-bottom", "5px" )
						.append($('<p/>').css( "font-weight", "bold" ).css( "width", "50%" ).css( "float", "left" ).text("Тип печатающей головки:"))
						.append($('<div/>').css( "width", "50%" ).css( "float", "left" ).text(product.typeOfPrinthead))
								)
    		}

			// in this two blocks added information about printer resolution			
			if("${product.type}"=='printer' && product.inputFirstPrintResolution != 0 && product.inputSecondPrintResolution != 0){
				name_price_cart_block.append($('<div/>').css( "height", "40px" ).css( "margin-bottom", "5px" )
						.append($('<p/>').css( "font-weight", "bold" ).css( "width", "50%" ).css( "float", "left" ).text("Разрешение печати:"))
						.append($('<div/>').css( "width", "50%" ).css( "float", "left" ).text(product.inputFirstPrintResolution + "x" + product.inputSecondPrintResolution + "dpi"))
								)
    		}
			
			if("${product.type}"=='printer' && (product.inputFirstPrintResolution == 0 || product.inputSecondPrintResolution == 0) && product.printResolution!=null){
				var resultResolution="";
				$(product.printResolution).each(function(i, resolution) {
					if(resultResolution==""){
						resultResolution+="" + resolution;
					} else {
						resultResolution+=", " + resolution;
					}
					
				})

				name_price_cart_block.append($('<div/>').css( "height", "40px" ).css( "margin-bottom", "5px" )
						.append($('<p/>').css( "font-weight", "bold" ).css( "width", "50%" ).css( "float", "left" ).text("Разрешение печати:"))
						.append($('<div/>').css( "width", "50%" ).css( "float", "left" ).text(resultResolution))
								)
    		}	
 
			//in this block added information about chromaticity	
			if("${product.type}"=='printer' && product.chromaticity!=null){
				var resultChromaticity="";
				$(product.chromaticity).each(function(i, enty) {
					if(resultChromaticity==""){
						if(enty=="CMYK"){
							if(product.chromaticityCMYK!=""){
								resultChromaticity+="" + enty + "+" + product.chromaticityCMYK;
							} else {
								resultChromaticity+="" + enty;
							}
						}
						
						if(enty=="CMYK x 2"){
							if(product.chromaticityCMYKx2!=""){
								resultChromaticity+="" + enty + "+" + product.chromaticityCMYKx2;
							} else {
								resultChromaticity+="" + enty;
							}
						}
												
						if(enty=="CMYKLcLm"){
							if(product.chromaticityCMYKLcLm!=""){
								resultChromaticity+="" + enty + "+" + product.chromaticityCMYKLcLm;
							} else {
								resultChromaticity+="" + enty;
							}
						}
						
						if(enty=="CMYKLcLmOG"){
							if(product.chromaticityCMYKLcLmOG!=""){
								resultChromaticity+="" + enty + "+" + product.chromaticityCMYKLcLmOG;
							} else {
								resultChromaticity+="" + enty;
							}
						}
						
					} else {
						if(enty=="CMYK"){
							if(product.chromaticityCMYK!=""){
								resultChromaticity+=", " + enty + "+" + product.chromaticityCMYK;
							} else {
								resultChromaticity+=", " + enty;
							}
						}
						
						if(enty=="CMYK x 2"){
							if(product.chromaticityCMYKx2!=""){
								resultChromaticity+=", " + enty + "+" + product.chromaticityCMYKx2;
							} else {
								resultChromaticity+=", " + enty;
							}
						}
												
						if(enty=="CMYKLcLm"){
							if(product.chromaticityCMYKLcLm!=""){
								resultChromaticity+=", " + enty + "+" + product.chromaticityCMYKLcLm;
							} else {
								resultChromaticity+=", " + enty;
							}
						}
						
						if(enty=="CMYKLcLmOG"){
							if(product.chromaticityCMYKLcLmOG!=""){
								resultChromaticity+=", " + enty + "+" + product.chromaticityCMYKLcLmOG;
							} else {
								resultChromaticity+=", " + enty;
							}
						}
						
					}
					
				});

				name_price_cart_block.append($('<div/>').css( "height", "30px" ).css( "margin-bottom", "5px" )
						.append($('<p/>').css( "font-weight", "bold" ).css( "width", "50%" ).css( "float", "left" ).text("Цветовая схема:"))
						.append($('<div/>').css( "width", "50%" ).css( "float", "left" ).text(resultChromaticity))
								)
    		}
			
									//add inner name_price_cart_block 
									innterDiv.append(name_price_cart_block);				

	                				if(product.leftSharesLink!=null && product.leftSharesLink!=""){
	                					innterDiv.append($('<div/>').addClass("ribbon-search-wrapper-left")
	                										.append($('<div/>').addClass("ribbon-search-left")
	                														   .text(product.leftSharesLink)
	                														   .css( "color", product.leftSharesLinkColorText )
	                														   .css( "background", product.leftSharesLinkColorFone )
	                														   ))
	                				}
	                	        	
	                	        	if(product.rightSharesLink!=null && product.rightSharesLink!=""){
	                	        		innterDiv.append($('<div/>').addClass("ribbon-search-wrapper-right")
	                										.append($('<div/>').addClass("ribbon-search-right")
	                														   .text(product.rightSharesLink)
	                														   .css( "color", product.rightSharesLinkColorText )
	                														   .css( "background", product.rightSharesLinkColorFone )
	                														   ))
	                				}
	                	        	
	            outerDiv.append(innterDiv);   	        	
	                				
	            if(product.top){
	            	$("#top_result_of_search").append(outerDiv);
	            } else {
	            	$("#out_result_of_search").append(outerDiv);
	            } 				
            	
            });
            
            var topResult = $('#top_result_of_search');
            if(topResult.find('.products').length > 0){
            	topResult.prepend($('<div/>').addClass('top_result_title').text("Топ Продаж"));
            	topResult.append($('<div/>').addClass('top_result_title').text("Топ Продаж"));
            	topResult.height( Math.ceil(topResult.find('.products').length/3 ) * (topResult.find('.products').first().height() + 6 ) +
            			topResult.find('.top_result_title').outerHeight(true)*2);
            	topResult.css("margin-bottom","12px");
            } else {
            	topResult.height(0);
            	topResult.css("margin-bottom","0px");
            }

		}
		
		}); 
});

</script>