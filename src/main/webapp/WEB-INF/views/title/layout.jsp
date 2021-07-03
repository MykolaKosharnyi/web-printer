<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<!--[if lt IE 7]><html lang="ru" class="lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html lang="ru" class="lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html lang="ru" class="lt-ie9"><![endif]-->
<!--[if gt IE 8]><!-->
<html lang="ru">
<!--<![endif]-->
<head>
	<meta charset="utf-8" />
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>

	<meta name="description" content="широкоформатная печать" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="shortcut icon" href="/images/logo.jpg" />

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">

	<link rel="stylesheet" href="/css/jquery-ui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/font-awesome-4.2.0/css/font-awesome.min.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/fancybox/jquery.fancybox.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/owl-carousel/owl.carousel.css" />
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/countdown/jquery.countdown.css" />
	<link rel="stylesheet" href="/css/fonts.css" />
	<link rel="stylesheet" href="/css/main.css" />
	<link rel="stylesheet" href="/css/media.css" />

    <link rel="stylesheet" href="/css/title.css"/>	
	<link rel="stylesheet" href="/css/home.css"/>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="http://malsup.github.io/jquery.form.js"></script>
	
<!--  	

<link rel="stylesheet" href="/css/flipclock.css">
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
-->
<c:set var="localeCode" scope = "session" value="${pageContext.response.locale}" />

</head>
<body>

	<tiles:insertAttribute name="header" />

	<div class="container">
		<div class="col-md-12">
			<div class="row">
				<tiles:insertAttribute name="path" />
			</div>
		</div>
	</div>

	<div class="container" style="margin-top: 140px;">
		<div class="col-md-2" style="max-width: 207px;">
			<div class="row">
				<div class="left_field">
					<tiles:insertAttribute name="left-menu" />
					<tiles:insertAttribute name="user-menu" />
					<tiles:insertAttribute name="search" />
					<tiles:insertAttribute name="reklam" />
				</div>		
			</div>
		</div>
		<div class="col-md-10">
			<div class="row" style="padding-left: 5px;">
				<tiles:insertAttribute name="body" />	
			</div>
		</div>
	</div>
	
	<tiles:insertAttribute name="footer" />

<!-- include cart on pages -->
<jsp:include page="modal_cart_window.jsp" />

<!-- modal window for showing where office on map -->
<div id="myAdress" class="modal fade">
    <div class="modal-dialog" style="width:600px;height: auto;">
        <div class="modal-content">
			<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Офис на карте</h4>
            </div>
            <div class="modal-body" >
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d635.477901903038!2d30.384235388132957!3d50.42411849871069!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cb928eb049e1%3A0x8fac369d19f70638!2sKartvelishvili+St%2C+7%2C+Kyiv%2C+Ukraine!5e0!3m2!1sen!2sua!4v1484153860942" style="border:0; width: 100%; height:420px;" ></iframe>
            </div>

        </div>
    </div>
</div>

<!-- Google Code for &#1054;&#1090;&#1095;&#1077;&#1090; &#1087;&#1086; &#1089;&#1072;&#1081;&#1090;&#1091; E-Machine Conversion Page -->
<script type="text/javascript">
/* <![CDATA[ */
var google_conversion_id = 959055246;
var google_conversion_language = "en";
var google_conversion_format = "3";
var google_conversion_color = "ffffff";
var google_conversion_label = "GUltCKWhpHUQjouoyQM";
var google_conversion_value = 0.10;
var google_conversion_currency = "UAH";
var google_remarketing_only = false;
/* ]]> */
</script>
<script type="text/javascript" src="//www.googleadservices.com/pagead/conversion.js">
</script>
<noscript>
<div style="display:inline;">
<img height="1" width="1" style="border-style:none;" alt="" src="//www.googleadservices.com/pagead/conversion/959055246/?value=0.10&amp;currency_code=UAH&amp;label=GUltCKWhpHUQjouoyQM&amp;guid=ON&amp;script=0"/>
</div>
</noscript>

<!--[if lt IE 9]>
	<script src="libs/html5shiv/es5-shim.min.js"></script>
	<script src="libs/html5shiv/html5shiv.min.js"></script>
	<script src="libs/html5shiv/html5shiv-printshiv.min.js"></script>
	<script src="libs/respond/respond.min.js"></script>
	<![endif]-->
	
	<!--<script src="<%=request.getContextPath()%>/resources/js/jquery.sticky-kit.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/flipclock.min.js"></script>-->

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	<script src="<%=request.getContextPath()%>/resources/libs/jquery-mousewheel/jquery.mousewheel.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/fancybox/jquery.fancybox.pack.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/waypoints/waypoints-1.6.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/scrollto/jquery.scrollTo.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/owl-carousel/owl.carousel.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/countdown/jquery.plugin.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/countdown/jquery.countdown.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/countdown/jquery.countdown-ru.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/landing-nav/navigation.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/js.cookie.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin/maskinput.js"></script>
	
	<script src="<%=request.getContextPath()%>/resources/js/cart.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/common.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/user/title.js"></script>

	<!-- Yandex.Metrika counter --><!-- /Yandex.Metrika counter -->
	<!-- Google Analytics counter --><!-- /Google Analytics counter -->		
	
<jsp:include page="callback_proposal_price.jsp" />	
	
<script type="text/javascript">

/*
http://gnatkovsky.com.ua/maska-vvoda-nomera-telefona.html
*/
jQuery(function($){
   $("#proposal_price_phone_number, #telephone").mask("+38(099) 99-99-999");
});

$(function() {
	
	$("#proposal_price_button").click(function(){
		
		var hasEmptyFields = false;
		$('#callback_proposal_price').find('div.modal-dialog').find("div.modal-content").find("div.modal-body")
			.find("div.form-group").find("input[type=text], textarea[name=description]").each(function(){
				if($(this).val().trim()==""){
					$(this).parent("div").find(".info_of_empty_field").css("display","block");
					$(this).parent('div').removeClass('has-success').addClass('has-error');	
					hasEmptyFields = true;
				} else {
					// this if for e-mail checking
					if($(this).is( "#email_in_proposal" ) && $(this).parent('div').hasClass('has-error')){
						hasEmptyFields = true;
					} else {
						
						$(this).parent('div').removeClass('has-error').addClass('has-success');	
					}
					$(this).parent("div").find(".info_of_empty_field").css("display","none");
					
				}
		});
		
		if(!hasEmptyFields){
			
			var outerForm = $('#callback_proposal_price').find('div.modal-dialog').find("div.modal-content").find("div.modal-body").find("div.form-group");

			var logined = outerForm.parent("div.modal-body").find("input[name=logined]").val() == "true" ;
			var name = logined ? "" : outerForm.find("input[name=name]").val();
			var phoneNumber = logined ? "" : outerForm.find("input[name=phonenumber]").val();
			var email = logined ? "" : outerForm.find("input[name=email]").val();
			
	    	var proposal = {
	    			"id":null,
	    			"logined":logined,
	    			"name":name,
	    			"phoneNumber": phoneNumber,
	    			"email": email,
	    			"idUser": new Number(0),	    			
	    			"typeProduct":outerForm.find("input[name=typeProduct]").val(),
	    			"idProduct":outerForm.find("input[name=idProduct]").val(),
	    			"price":outerForm.find("input[name=price]").val(),
	    			"description":outerForm.find("textarea[name=description]").val(),
	    			"typeProposal":outerForm.find("input[name=typeProposal]").val(),
	    			"dateCreation": null
	    	};
	    	
			$.ajax({
				  type: 'post',
				  url: "/send_proposal",
				  data: JSON.stringify(proposal),
				  contentType: "application/json; charset=utf-8",			        
			      success: function () {
				  	$('#callback_proposal_price').modal('hide');
					$("#sended_proposal_alert").css("display","block").delay(5000).fadeOut("slow");
			      },
				  error: function(xhr, status, error) {
					  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
				  }
				});
		}
	});
	
	$("#email_in_proposal").keyup(function() {

		var ourElement = $(this);
		var dataToSend = $(this).val();
		
		if(dataToSend.trim()!=""){
			$.ajax({
			  type: 'post',
			  url: "/check_email",
			  contentType: "text/plain; charset=utf-8",
			  data: dataToSend,			        
		        success: function (data) {
		        	if(data.result){
		        		ourElement.parent('div').removeClass('has-error').addClass('has-success');		        		
		        		ourElement.parent('div').find('.info_of_checking_email').css('display','none');
		        		ourElement.parent('div').find('.bg-success').css('display','block');
					} else {
						ourElement.parent('div').removeClass('has-success').addClass('has-error');						
						ourElement.parent('div').find('.info_of_checking_email').css('display','block');
						ourElement.parent('div').find('.bg-success').css('display','none');
					}
		        },
			  error: function(xhr, status, error) {
				  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
			  }
			});
		
			ourElement.parent("div").find(".info_of_empty_field").css("display","none");

		} else {
			ourElement.parent('div').find('.bg-success').css('display','none');
			ourElement.parent('div').find('.bg-danger').css('display','none');
			ourElement.parent('div').removeClass('has-success').addClass('has-error');
			ourElement.parent("div").find(".info_of_empty_field").css("display","block");
		}
		
	});
	
	
	$("#email").keyup(function() {

		var parentElement = $(this).parent('div').parent('div');
		var dataToSend = $(this).val();
		
		if(dataToSend.trim()!=""){
			$.ajax({
			  type: 'post',
			  url: "/check_email",
			  contentType: "text/plain; charset=utf-8",
			  data: dataToSend,			        
		        success: function (data) {
		        	if(data.result){
		        		parentElement.removeClass('has-error').addClass('has-success');		        		
		        		parentElement.find('.info_of_checking_email').css('display','none');
		        		parentElement.find('.bg-success').css('display','block');
					} else {
						parentElement.removeClass('has-success').addClass('has-error');						
						parentElement.find('.info_of_checking_email').css('display','block');
						parentElement.find('.bg-success').css('display','none');
					}
		        },
			  error: function(xhr, status, error) {
				  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
			  }
			});
		
			parentElement.find(".info_of_empty_field").css("display","none");

		} else {
			parentElement.find('.bg-success').css('display','none');
			parentElement.find('.bg-danger').css('display','none');
			parentElement.removeClass('has-success').addClass('has-error');
			parentElement.find(".info_of_empty_field").css("display","block");
		}
		
	});
	
});

function openModalProposalSuggestPrise(type, idProduct, nameProduct, pathToPicture){
	var descriptionLabel = getDescriptionByLocale("feedback_form_suggest_price_title");
	proposalPriceBlock(type, idProduct, nameProduct, pathToPicture, "SUGGEST_YOUR_PRICE", descriptionLabel, getDescriptionByLocale("feedback_form_send"));
}

function openModalProposalPrise(type, idProduct, nameProduct, pathToPicture){
	var descriptionLabel = getDescriptionByLocale("feedback_form_proposal_price_title");
	proposalPriceBlock(type, idProduct, nameProduct, pathToPicture, "SPECIFY", descriptionLabel, getDescriptionByLocale("feedback_form_clarify"));
} 

function proposalPriceBlock(type, idProduct, nameProduct, pathToPicture, typeProposal,descriptionLabel, textOnButton){
	var proposalBlock = $('#callback_proposal_price');
	var proposalProduct = $('#callback_proposal_price').find("#proposal_product_link");
	proposalProduct.find("img").attr("src", "/images/" + type + "s/" + idProduct + "/" + pathToPicture);
	proposalProduct.find("a").attr("href", type + "/" + idProduct).text(nameProduct);
	proposalProduct.find("input[name=typeProduct]").val(type);
	proposalProduct.find("input[name=idProduct]").val(idProduct);
	proposalProduct.find("input[name=typeProposal]").val(typeProposal);
	
	//clear input fields
	proposalBlock.find("input[name=price]").val('');
	proposalBlock.find("textarea[name=description]").val('');
	
	//for description under textarea description // wow:)))
	proposalBlock.find("label#modal_description_title").text(descriptionLabel);
	
	proposalBlock.find("button#proposal_price_button").text(textOnButton);
	
    $('#callback_proposal_price').modal();
}

function checkPrise(num){
	if(num > 0.1){
		  var priceDollarInGrivna = new Number("${ constants.dollar_in_grivna }");
		  var priceEuroInGrivna = new Number("${ constants.euro_in_grivna }");
		
		  //return name of currency
		  var currency = readCookie('check_name_currency');
		  
		  //&#8364; - euro
		  //&#8372; - gryvna
		  if(currency==="grinva"){
			  return '\u20B4' + convernPriceToString(num*priceDollarInGrivna).replace(".", ",") + " UAH";
		  } else if (currency==="euro"){
			  return '\u20ac' + convernPriceToString(num*priceDollarInGrivna/priceEuroInGrivna).replace(".", ",");
		  } else if (currency==="dollar"){
			  return "$" + convernPriceToString(num).replace(".", ",");
		  } else {
			  return '\u20B4' + convernPriceToString(num*priceDollarInGrivna).replace(".", ",") + " UAH";
		  }

	} else {
		return getDescriptionByLocale("specify");
	}
}

function getDescriptionByLocale(descripiton){
	var locale = "${localeCode}";
	var descriptionFile = ${descriptions};
	return descriptionFile[descripiton][locale];
}

function convernPriceToString(num){
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
	  return str.indexOf(" ") == 0 ? str.substring(1) : str;
}


$(function() {
	$("#submit_registration_button").click(function(){
		
		var hasEmptyFields = false;
		$('div.login-container').find("form#userForm").find("div.form-group")
			.find('div.neccessary_for_registration').find("input[type=text], input[type=password]").each(function(){
				if($(this).val().trim()==""){
					$(this).parent("div").parent("div").find(".info_of_empty_field").css("display","block");
					$(this).parent('div').parent("div").removeClass('has-success').addClass('has-error');	
					hasEmptyFields = true;
				} else {
					// this if for e-mail checking
					if($(this).is( "#email" ) && $(this).parent('div').parent('div').hasClass('has-error')){
						hasEmptyFields = true;
					} else {
						
						$(this).parent('div').parent('div').removeClass('has-error').addClass('has-success');	
					}
					$(this).parent("div").parent('div').find(".info_of_empty_field").css("display","none");
					
				}
		});
		
		if(!hasEmptyFields){			    			
			$('div.login-container').find("form#userForm").submit();
		}
	});
});


</script>
</body>
</html>