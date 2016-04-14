jQuery(document).ready(function(){
	
/*--------------------------------------- for first block -----------------------------------------------------------*/
		function htmSlider1(){
		/* next shift */

		/* wrapper slider */
		var slideWrap1 = jQuery('.slide-wrap1');
		/* hrefs for previous and next slide */
		var nextLink1 = jQuery('.next-slide1');
		var prevLink1 = jQuery('.prev-slide1');

		var playLink1 = jQuery('.auto1');
		
		var is_animate1 = false;
		
		/* weight slide with indent */
		var slideWidth1 = jQuery('.slide-item1').outerWidth();
		
		/* shift slider */
		var newLeftPos1 = slideWrap1.position().left - slideWidth1;
		
		/* Click for href on next slide */
		nextLink1.click(function(){
			if(!slideWrap1.is(':animated')) {
	
				slideWrap1.animate({left: newLeftPos1}, 200, function(){
					slideWrap1
						.find('.slide-item1:first')
						.appendTo(slideWrap1)
						.parent()
						.css({'left': 0});
				});

			}
		});

		/* Click for href on next slide */
		prevLink1.click(function(){
			if(!slideWrap1.is(':animated')) {
			
				slideWrap1
					.css({'left': newLeftPos1})
					.find('.slide-item1:last')
					.prependTo(slideWrap1)
					.parent()
					.animate({left: 0}, 200);

			}
		});
		
		
		/* Function automatic scroll slider */
		function autoplay(){
			
			if(!is_animate1){
				is_animate1 = true;
				slideWrap1.animate({left: newLeftPos1}, 2000, function(){
					slideWrap1
						.find('.slide-item1:first')
						.appendTo(slideWrap1)
						.parent()
						.css({'left': 0});
					is_animate1 = false;
				});
			}
			
		}
		
		/* Click on href start/pause */
		playLink1.click(function(){
			if(playLink1.hasClass('play1')){
				playLink1.removeClass('play1').addClass('pause1');
				jQuery('.navy1').addClass('disable1');
				timer = setInterval(autoplay, 0);
			} else {
				playLink1.removeClass('pause1').addClass('play1');
				jQuery('.navy1').removeClass('disable1');
				clearInterval(timer);
			}
		});

	}

	/* initial function of slider 1 */
	htmSlider1();
/*--------------------------------------- for second block -----------------------------------------------------------*/
		function htmSlider2(){
		/* next shift */

		/* wrapper slider */
		var slideWrap2 = jQuery('.slide-wrap2');
		/* hrefs for previous and next slide */
		var nextLink2 = jQuery('.next-slide2');
		var prevLink2 = jQuery('.prev-slide2');

		var playLink2 = jQuery('.auto2');
		
		var is_animate2 = false;
		
		/* weight slide with indent */
		var slideWidth2 = jQuery('.slide-item2').outerWidth();
		
		/* shift slider */
		var newLeftPos2 = slideWrap2.position().left - slideWidth2;
		
		/* Click for href on next slide */
		nextLink2.click(function(){
			if(!slideWrap2.is(':animated')) {
	
				slideWrap2.animate({left: newLeftPos2}, 200, function(){
					slideWrap2
						.find('.slide-item2:first')
						.appendTo(slideWrap2)
						.parent()
						.css({'left': 0});
				});

			}
		});

		/* Click for href on next slide */
		prevLink2.click(function(){
			if(!slideWrap2.is(':animated')) {
			
				slideWrap2
					.css({'left': newLeftPos2})
					.find('.slide-item2:last')
					.prependTo(slideWrap2)
					.parent()
					.animate({left: 0}, 200);

			}
		});
		
		
		/* Function automatic scroll slider */
		function autoplay(){
			if(!is_animate2){
				is_animate2 = true;
				slideWrap2.animate({left: newLeftPos2}, 2000, function(){
					slideWrap2
						.find('.slide-item2:first')
						.appendTo(slideWrap2)
						.parent()
						.css({'left': 0});
					is_animate2 = false;
				});
			}
		}
		
		/* Click on href start/pause */
		playLink2.click(function(){
			if(playLink2.hasClass('play2')){
				playLink2.removeClass('play2').addClass('pause2');
				jQuery('.navy2').addClass('disable2');
				timer = setInterval(autoplay, 0);
			} else {
				playLink2.removeClass('pause2').addClass('play2');
				jQuery('.navy2').removeClass('disable2');
				clearInterval(timer);
			}
		});

	}

	/* initial function of slider 2 */
	htmSlider2();

/*--------------------------------------- for third block -----------------------------------------------------------*/
		function htmSlider3(){
		/* next shift */

		/* wrapper slider */
		var slideWrap3 = jQuery('.slide-wrap3');
		/* �hrefs for previous and next slide */
		var nextLink3 = jQuery('.next-slide3');
		var prevLink3 = jQuery('.prev-slide3');

		var playLink3 = jQuery('.auto3');
		
		var is_animate3 = false;
		
		/* weight slide with indent */
		var slideWidth3 = jQuery('.slide-item3').outerWidth();
		
		/* shift slider */
		var newLeftPos3 = slideWrap3.position().left - slideWidth3;
		
		/* Click for href on next slide */
		nextLink3.click(function(){
			if(!slideWrap3.is(':animated')) {
	
				slideWrap3.animate({left: newLeftPos3}, 200, function(){
					slideWrap3
						.find('.slide-item3:first')
						.appendTo(slideWrap3)
						.parent()
						.css({'left': 0});
				});

			}
		});

		/* Click for href on next slide */
		prevLink3.click(function(){
			if(!slideWrap3.is(':animated')) {
			
				slideWrap3
					.css({'left': newLeftPos3})
					.find('.slide-item3:last')
					.prependTo(slideWrap3)
					.parent()
					.animate({left: 0}, 200);

			}
		});
		
		
		/* Function automatic scroll slider */
		function autoplay(){
			if(!is_animate3){
				is_animate3 = true;
				slideWrap3.animate({left: newLeftPos3}, 2000, function(){
					slideWrap3
						.find('.slide-item3:first')
						.appendTo(slideWrap3)
						.parent()
						.css({'left': 0});
					is_animate3 = false;
				});
			}
		}
		
		/* Click on href start/pause */
		playLink3.click(function(){
			if(playLink3.hasClass('play3')){
				playLink3.removeClass('play3').addClass('pause3');
				jQuery('.navy3').addClass('disable3');
				timer = setInterval(autoplay, 0);
			} else {
				playLink3.removeClass('pause3').addClass('play3');
				jQuery('.navy3').removeClass('disable3');
				clearInterval(timer);
			}
		});

	}

	/* initial function of slider 3 */
	htmSlider3();
/*--------------------------------------- for forth block -----------------------------------------------------------*/
		function htmSlider4(){
		/* next shift */

		/* wrapper slider */
		var slideWrap4 = jQuery('.slide-wrap4');
		/* hrefs for previous and next slide */
		var nextLink4 = jQuery('.next-slide4');
		var prevLink4 = jQuery('.prev-slide4');

		var playLink4 = jQuery('.auto4');
		
		var is_animate4 = false;
		
		/* weight slide with indent */
		var slideWidth4 = jQuery('.slide-item4').outerWidth();
		
		/* shift slider */
		var newLeftPos4 = slideWrap4.position().left - slideWidth4;
		
		/* Click for href on next slide */
		nextLink4.click(function(){
			if(!slideWrap4.is(':animated')) {
	
				slideWrap4.animate({left: newLeftPos4}, 200, function(){
					slideWrap4
						.find('.slide-item4:first')
						.appendTo(slideWrap4)
						.parent()
						.css({'left': 0});
				});

			}
		});

		/* Click for href on next slide */
		prevLink4.click(function(){
			if(!slideWrap4.is(':animated')) {
			
				slideWrap4
					.css({'left': newLeftPos4})
					.find('.slide-item4:last')
					.prependTo(slideWrap4)
					.parent()
					.animate({left: 0}, 200);

			}
		});
		
		
		/* Function automatic scroll slider */
		function autoplay(){
			if(!is_animate4){
				is_animate4 = true;
				slideWrap4.animate({left: newLeftPos4}, 2000, function(){
					slideWrap4
						.find('.slide-item4:first')
						.appendTo(slideWrap4)
						.parent()
						.css({'left': 0});
					is_animate4 = false;
				});
			}
		}
		
		/* Click on href start/pause */
		playLink4.click(function(){
			if(playLink4.hasClass('play4')){
				playLink4.removeClass('play4').addClass('pause4');
				jQuery('.navy4').addClass('disable4');
				timer = setInterval(autoplay, 0);
			} else {
				playLink4.removeClass('pause4').addClass('play4');
				jQuery('.navy4').removeClass('disable4');
				clearInterval(timer);
			}
		});

	}

	/* initial function of slider 4 */
	htmSlider4();
/*--------------------------------------- for fifth block -----------------------------------------------------------*/
		function htmSlider5(){
		/* next shift */

		/* wrapper slider */
		var slideWrap5 = jQuery('.slide-wrap5');
		/* hrefs for previous and next slide */
		var nextLink5 = jQuery('.next-slide5');
		var prevLink5 = jQuery('.prev-slide5');

		var playLink5 = jQuery('.auto5');
		
		var is_animate5 = false;
		
		/* weight slide with indent */
		var slideWidth5 = jQuery('.slide-item5').outerWidth();
		
		/* shift slider */
		var newLeftPos5 = slideWrap5.position().left - slideWidth5;
		
		/* Click for href on next slide */
		nextLink5.click(function(){
			if(!slideWrap5.is(':animated')) {
	
				slideWrap5.animate({left: newLeftPos5}, 200, function(){
					slideWrap5
						.find('.slide-item5:first')
						.appendTo(slideWrap5)
						.parent()
						.css({'left': 0});
				});

			}
		});

		/* Click for href on next slide */
		prevLink5.click(function(){
			if(!slideWrap5.is(':animated')) {
			
				slideWrap5
					.css({'left': newLeftPos5})
					.find('.slide-item5:last')
					.prependTo(slideWrap5)
					.parent()
					.animate({left: 0}, 200);

			}
		});
		
		
		/* Function automatic scroll slider */
		function autoplay(){
			if(!is_animate5){
				is_animate5 = true;
				slideWrap5.animate({left: newLeftPos5}, 2000, function(){
					slideWrap5
						.find('.slide-item5:first')
						.appendTo(slideWrap5)
						.parent()
						.css({'left': 0});
					is_animate5 = false;
				});
			}
		}
		
		/* Click on href start/pause */
		playLink5.click(function(){
			if(playLink5.hasClass('play5')){
				playLink5.removeClass('play5').addClass('pause5');
				jQuery('.navy5').addClass('disable5');
				timer = setInterval(autoplay, 0);
			} else {
				playLink5.removeClass('pause5').addClass('play5');
				jQuery('.navy5').removeClass('disable5');
				clearInterval(timer);
			}
		});

	}

	/* initial function of slider 5 */
	htmSlider5();
/*--------------------------------------- for sixth block -----------------------------------------------------------*/
		function htmSlider6(){
		/* next shift */

		/* wrapper slider */
		var slideWrap6 = jQuery('.slide-wrap6');
		/* hrefs for previous and next slide */
		var nextLink6 = jQuery('.next-slide6');
		var prevLink6 = jQuery('.prev-slide6');

		var playLink6 = jQuery('.auto6');
		
		var is_animate6 = false;
		
		/* weight slide with indent */
		var slideWidth6 = jQuery('.slide-item6').outerWidth();
		
		/* shift slider */
		var newLeftPos6 = slideWrap6.position().left - slideWidth6;
		
		/* Click for href on next slide */
		nextLink6.click(function(){
			if(!slideWrap6.is(':animated')) {
	
				slideWrap6.animate({left: newLeftPos6}, 200, function(){
					slideWrap6
						.find('.slide-item6:first')
						.appendTo(slideWrap6)
						.parent()
						.css({'left': 0});
				});

			}
		});

		/* Click for href on next slide */
		prevLink6.click(function(){
			if(!slideWrap6.is(':animated')) {
			
				slideWrap6
					.css({'left': newLeftPos6})
					.find('.slide-item6:last')
					.prependTo(slideWrap6)
					.parent()
					.animate({left: 0}, 200);

			}
		});
		
		
		/* Function automatic scroll slider */
		function autoplay(){
			if(!is_animate6){
				is_animate6 = true;
				slideWrap6.animate({left: newLeftPos6}, 2000, function(){
					slideWrap6
						.find('.slide-item6:first')
						.appendTo(slideWrap6)
						.parent()
						.css({'left': 0});
					is_animate6 = false;
				});
			}
		}
		
		/* Click on href start/pause */
		playLink6.click(function(){
			if(playLink6.hasClass('play6')){
				playLink6.removeClass('play6').addClass('pause6');
				jQuery('.navy6').addClass('disable6');
				timer = setInterval(autoplay, 0);
			} else {
				playLink6.removeClass('pause6').addClass('play6');
				jQuery('.navy6').removeClass('disable6');
				clearInterval(timer);
			}
		});

	}

	/* initial function of slider 6 */
	htmSlider6();
/*--------------------------------------- for seventh block -----------------------------------------------------------*/
		function htmSlider7(){
		/* next shift */

		/* wrapper slider */
		var slideWrap7 = jQuery('.slide-wrap7');
		/* hrefs for previous and next slide */
		var nextLink7 = jQuery('.next-slide7');
		var prevLink7 = jQuery('.prev-slide7');

		var playLink7 = jQuery('.auto7');
		
		var is_animate7 = false;
		
		/* weight slide with indent */
		var slideWidth7 = jQuery('.slide-item7').outerWidth();
		
		/* shift slider */
		var newLeftPos7 = slideWrap7.position().left - slideWidth7;
		
		/* Click for href on next slide */
		nextLink7.click(function(){
			if(!slideWrap7.is(':animated')) {
	
				slideWrap7.animate({left: newLeftPos7}, 200, function(){
					slideWrap7
						.find('.slide-item7:first')
						.appendTo(slideWrap7)
						.parent()
						.css({'left': 0});
				});

			}
		});

		/* Click for href on next slide */
		prevLink7.click(function(){
			if(!slideWrap7.is(':animated')) {
			
				slideWrap7
					.css({'left': newLeftPos7})
					.find('.slide-item7:last')
					.prependTo(slideWrap7)
					.parent()
					.animate({left: 0}, 200);

			}
		});
		
		
		/* Function automatic scroll slider */
		function autoplay(){
			if(!is_animate7){
				is_animate7 = true;
				slideWrap7.animate({left: newLeftPos7}, 2000, function(){
					slideWrap7
						.find('.slide-item7:first')
						.appendTo(slideWrap7)
						.parent()
						.css({'left': 0});
					is_animate7 = false;
				});
			}
		}
		
		/* Click on href start/pause */
		playLink7.click(function(){
			if(playLink7.hasClass('play7')){
				playLink7.removeClass('play7').addClass('pause7');
				jQuery('.navy7').addClass('disable7');
				timer = setInterval(autoplay, 0);
			} else {
				playLink7.removeClass('pause7').addClass('play7');
				jQuery('.navy7').removeClass('disable7');
				clearInterval(timer);
			}
		});

	}

	/* initial function of slider 7 */
	htmSlider7();
	/*--------------------------------------- for eiths block -----------------------------------------------------------*/
	function htmSlider8(){
	/* next shift */

	/* wrapper slider */
	var slideWrap8 = jQuery('.slide-wrap8');
	/* hrefs for previous and next slide */
	var nextLink8 = jQuery('.next-slide8');
	var prevLink8 = jQuery('.prev-slide8');

	var playLink8 = jQuery('.auto8');
	
	var is_animate8 = false;
	
	/* weight slide with indent */
	var slideWidth8 = jQuery('.slide-item8').outerWidth();
	
	/* shift slider */
	var newLeftPos8 = slideWrap8.position().left - slideWidth8;
	
	/* Click for href on next slide */
	nextLink8.click(function(){
		if(!slideWrap8.is(':animated')) {

			slideWrap8.animate({left: newLeftPos8}, 200, function(){
				slideWrap8
					.find('.slide-item8:first')
					.appendTo(slideWrap8)
					.parent()
					.css({'left': 0});
			});

		}
	});

	/* Click for href on next slide */
	prevLink8.click(function(){
		if(!slideWrap8.is(':animated')) {
		
			slideWrap8
				.css({'left': newLeftPos8})
				.find('.slide-item8:last')
				.prependTo(slideWrap8)
				.parent()
				.animate({left: 0}, 200);

		}
	});
	
	
	/* Function automatic scroll slider */
	function autoplay(){
		if(!is_animate8){
			is_animate8 = true;
			slideWrap8.animate({left: newLeftPos8}, 2000, function(){
				slideWrap8
					.find('.slide-item8:first')
					.appendTo(slideWrap8)
					.parent()
					.css({'left': 0});
				is_animate8 = false;
			});
		}
	}
	
	/* Click on href start/pause */
	playLink8.click(function(){
		if(playLink8.hasClass('play8')){
			playLink8.removeClass('play8').addClass('pause8');
			jQuery('.navy8').addClass('disable8');
			timer = setInterval(autoplay, 0);
		} else {
			playLink8.removeClass('pause8').addClass('play8');
			jQuery('.navy8').removeClass('disable8');
			clearInterval(timer);
		}
	});

}

/* initial function of slider 8 */
htmSlider8();
/*--------------------------------------- for nines block -----------------------------------------------------------*/
function htmSlider9(){
/* next shift */

/* wrapper slider */
var slideWrap9 = jQuery('.slide-wrap9');
/* hrefs for previous and next slide */
var nextLink9 = jQuery('.next-slide9');
var prevLink9 = jQuery('.prev-slide9');

var playLink9 = jQuery('.auto9');

var is_animate9 = false;

/* weight slide with indent */
var slideWidth9 = jQuery('.slide-item9').outerWidth();

/* shift slider */
var newLeftPos9 = slideWrap9.position().left - slideWidth9;

/* Click for href on next slide */
nextLink9.click(function(){
	if(!slideWrap9.is(':animated')) {

		slideWrap9.animate({left: newLeftPos9}, 200, function(){
			slideWrap9
				.find('.slide-item9:first')
				.appendTo(slideWrap9)
				.parent()
				.css({'left': 0});
		});

	}
});

/* Click for href on next slide */
prevLink9.click(function(){
	if(!slideWrap9.is(':animated')) {
	
		slideWrap9
			.css({'left': newLeftPos9})
			.find('.slide-item9:last')
			.prependTo(slideWrap9)
			.parent()
			.animate({left: 0}, 200);

	}
});


/* Function automatic scroll slider */
function autoplay(){
	if(!is_animate9){
		is_animate9 = true;
		slideWrap9.animate({left: newLeftPos9}, 2000, function(){
			slideWrap9
				.find('.slide-item9:first')
				.appendTo(slideWrap9)
				.parent()
				.css({'left': 0});
			is_animate9 = false;
		});
	}
}

/* Click on href start/pause */
playLink9.click(function(){
	if(playLink9.hasClass('play9')){
		playLink9.removeClass('play9').addClass('pause9');
		jQuery('.navy9').addClass('disable9');
		timer = setInterval(autoplay, 0);
	} else {
		playLink9.removeClass('pause9').addClass('play9');
		jQuery('.navy9').removeClass('disable9');
		clearInterval(timer);
	}
});

}

/* initial function of slider 9 */
htmSlider9();
});