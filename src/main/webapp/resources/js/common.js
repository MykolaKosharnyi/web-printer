$(document).ready(function() {

	$(".auth_buttons").click(function() {
		$(this).next().slideToggle();
	});
	$(".main_mnu_button").click(function() {
		$(".maian_mnu ul").slideToggle();
	});

	//Таймер обратного отсчета
	//Документация: http://keith-wood.name/countdown.html
	//<div class="countdown" date-time="2015-01-07"></div>
	var austDay = new Date($(".countdown").attr("date-time"));
	$(".countdown").countdown({until: austDay, format: 'yowdHMS'});

	//Попап менеджер FancyBox
	//Документация: http://fancybox.net/howto
	//<a class="fancybox"><img src="image.jpg" /></a>
	//<a class="fancybox" data-fancybox-group="group"><img src="image.jpg" /></a>
	$(".fancybox").fancybox();
	$(".fancybox_video").fancybox({
        openEffect  : 'none',
        closeEffect : 'none',
        helpers : {
            media : {}
        }
    });

	//Навигация по Landing Page
	//$(".top_mnu") - это верхняя панель со ссылками.
	//Ссылки вида <a href="#contacts">Контакты</a>
	$(".top_mnu").navigation();

	//Добавляет классы дочерним блокам .block для анимации
	//Документация: http://imakewebthings.com/jquery-waypoints/
	$(".block").waypoint(function(direction) {
		if (direction === "down") {
			$(".class").addClass("active");
		} else if (direction === "up") {
			$(".class").removeClass("deactive");
		};
	}, {offset: 100});

	//Плавный скролл до блока .div по клику на .scroll
	//Документация: https://github.com/flesler/jquery.scrollTo
	$("a.scroll").click(function() {
		$.scrollTo($(".div"), 800, {
			offset: -90
		});
	});

	//Каруселька
	//Документация: http://owlgraphic.com/owlcarousel/
	var owl = $(".carousel");
	owl.owlCarousel({
		items : 1,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:true,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl.trigger("owl.prev");
		} else {
			owl.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button").click(function() {
		owl.trigger("owl.next");
	});
	$(".prev_button").click(function() {
		owl.trigger("owl.prev");
	});
	
	$('.play_button').on('click',function(){
	    owl.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button').css('display','block');
	});
	$('.pause_button').on('click',function(){
	    owl.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button').css('display','block');
	});
	
	//Каруселька для видео
	var owl_video = $(".carousel_video");
	owl_video.owlCarousel({
		items : 4,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:true,
	    autoPlayTimeout:900,
	    autoplayHoverPause:true
	});
	owl_video.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl.trigger("owl.prev");
		} else {
			owl.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_video").click(function() {
		owl_video.trigger("owl.next");
	});
	$(".prev_button_video").click(function() {
		owl_video.trigger("owl.prev");
	});
	$('.play_button_video').on('click',function(){
	    owl.trigger('owl.play',3000);
	    $(this).css('display','none');
		$('.pause_button_video').css('display','block');
	});
	$('.pause_button_video').on('click',function(){
	    owl_video.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_video').css('display','block');
	});

	//Каруселька для принтеров
	var owl_printer = $(".carousel_printer");
	owl_printer.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_printer.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_printer.trigger("owl.prev");
		} else {
			owl_printer.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_printer").click(function() {
		owl_printer.trigger("owl.next");
	});
	$(".prev_button_printer").click(function() {
		owl_printer.trigger("owl.prev");
	});
	
	$('.play_button_printer').on('click',function(){
		owl_printer.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_printer').css('display','block');
	});
	$('.pause_button_printer').on('click',function(){
		owl_printer.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_printer').css('display','block');
	});


	//Каруселька для 3D принтеров
	var owl_printer_3d = $(".carousel_3d_printer");
	owl_printer_3d.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_printer_3d.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_printer_3d.trigger("owl.prev");
		} else {
			owl_printer_3d.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_3d_printer").click(function() {
		owl_printer_3d.trigger("owl.next");
	});
	$(".prev_button_3d_printer").click(function() {
		owl_printer_3d.trigger("owl.prev");
	});
	
	$('.play_button_3d_printer').on('click',function(){
		owl_printer_3d.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_3d_printer').css('display','block');
	});
	$('.pause_button_3d_printer').on('click',function(){
		owl_printer_3d.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_3d_printer').css('display','block');
	});

	//Каруселька для цыфровых принтеров
	var owl_printer_d = $(".carousel_digital_printer");
	owl_printer_d.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_printer_d.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_printer_d.trigger("owl.prev");
		} else {
			owl_printer_d.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_digital_printer").click(function() {
		owl_printer_d.trigger("owl.next");
	});
	$(".prev_button_digital_printer").click(function() {
		owl_printer_d.trigger("owl.prev");
	});
	
	$('.play_button_digital_printer').on('click',function(){
		owl_printer_d.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_digital_printer').css('display','block');
	});
	$('.pause_button_digital_printer').on('click',function(){
		owl_printer_d.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_digital_printer').css('display','block');
	});

//Каруселька for laminator
	var owl_laminator = $(".carousel_laminator");
	owl_laminator.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_laminator.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_laminator.trigger("owl.prev");
		} else {
			owl_laminator.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_laminator").click(function() {
		owl_laminator.trigger("owl.next");
	});
	$(".prev_button_laminator").click(function() {
		owl_laminator.trigger("owl.prev");
	});
	
	$('.play_button_laminator').on('click',function(){
		owl_laminator.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_laminator').css('display','block');
	});
	$('.pause_button_laminator').on('click',function(){
		owl_laminator.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_laminator').css('display','block');
	});

//Каруселька for laminator
	var owl_laser = $(".carousel_laser");
	owl_laser.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_laser.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_laser.trigger("owl.prev");
		} else {
			owl_laser.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_laser").click(function() {
		owl_laser.trigger("owl.next");
	});
	$(".prev_button_laser").click(function() {
		owl_laser.trigger("owl.prev");
	});
	
	$('.play_button_laser').on('click',function(){
		owl_laser.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_laser').css('display','block');
	});
	$('.pause_button_laser').on('click',function(){
		owl_laser.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_laser').css('display','block');
	});

//Каруселька for cutter
	var owl_cutter = $(".carousel_cutter");
	owl_cutter.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_cutter.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_cutter.trigger("owl.prev");
		} else {
			owl_cutter.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_cutter").click(function() {
		owl_cutter.trigger("owl.next");
	});
	$(".prev_button_cutter").click(function() {
		owl_cutter.trigger("owl.prev");
	});
	
	$('.play_button_cutter').on('click',function(){
		owl_cutter.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_cutter').css('display','block');
	});
	$('.pause_button_cutter').on('click',function(){
		owl_cutter.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_cutter').css('display','block');
	});

//Каруселька for scanner
	var owl_scaner = $(".carousel_scanner");
	owl_scaner.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_scaner.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_scaner.trigger("owl.prev");
		} else {
			owl_scaner.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_scanner").click(function() {
		owl_scaner.trigger("owl.next");
	});
	$(".prev_button_scanner").click(function() {
		owl_scaner.trigger("owl.prev");
	});
	
	$('.play_button_scanner').on('click',function(){
		owl_scaner.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_scanner').css('display','block');
	});
	$('.pause_button_scanner').on('click',function(){
		owl_scaner.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_scanner').css('display','block');
	});

//Каруселька for previously_used
	var owl_previously_used = $(".carousel_previously_used");
	owl_previously_used.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_previously_used.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_previously_used.trigger("owl.prev");
		} else {
			owl_previously_used.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_previously_used").click(function() {
		owl_previously_used.trigger("owl.next");
	});
	$(".prev_button_previously_used").click(function() {
		owl_previously_used.trigger("owl.prev");
	});
	
	$('.play_button_previously_used').on('click',function(){
		owl_previously_used.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_previously_used').css('display','block');
	});
	$('.pause_button_previously_used').on('click',function(){
		owl_previously_used.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_previously_used').css('display','block');
	});

//Каруселька for rip
	var owl_rip = $(".carousel_rip");
	owl_rip.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false,
		loop:true,
		autoPlay:false,
	    autoPlayTimeout:1000,
	    autoplayHoverPause:true
	});
	owl_rip.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_rip.trigger("owl.prev");
		} else {
			owl_rip.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_rip").click(function() {
		owl_rip.trigger("owl.next");
	});
	$(".prev_button_rip").click(function() {
		owl_rip.trigger("owl.prev");
	});
	
	$('.play_button_rip').on('click',function(){
		owl_rip.trigger('owl.play',4000);
	    $(this).css('display','none');
		$('.pause_button_rip').css('display','block');
	});
	$('.pause_button_rip').on('click',function(){
		owl_rip.trigger('owl.stop');
	    $(this).css('display','none');
		$('.play_button_rip').css('display','block');
	});

	//Кнопка "Наверх"
	//Документация:
	//http://api.jquery.com/scrolltop/
	//http://api.jquery.com/animate/
	$("#top").click(function () {
		$("body, html").animate({
			scrollTop: 0
		}, 800);
		return false;
	});
	
	//Аякс отправка форм
	//Документация: http://api.jquery.com/jquery.ajax/
/*	$("#callback").submit(function() {
		$.ajax({
			type: "GET",
			url: "mail.php",
			data: $("#callback").serialize()
		}).done(function() {
			alert("Спасибо за заявку!");
			setTimeout(function() {
				$.fancybox.close();
			}, 1000);
		});
		return false;
	});*/
	
	$('.reviewStars-input input:radio').click(function(){
	    return false;
	});

	$('.product_price div').each(function(){
		var priceInDollars = $(this).parent('.product_price').find('input[type=hidden]').val();
		$(this).empty().text(checkPrise(new Number(priceInDollars)));
	});
	
});

// block for changing price for current value
function convertPriceOnSite(name_currency, price_for_grivna){
	
	createCookie("check_name_currency", name_currency, 10);
	
	$('.product_price div').each(function(){
		var priceInDollars = $(this).parent('.product_price').find('input[type=hidden]').val();
		$(this).empty().text(checkPrise(new Number(priceInDollars)));
	});
}

function createCookie(name,value,days) {
	if (days) {
		var date = new Date();
		date.setTime(date.getTime()+(days*24*60*60*1000));
		var expires = "; expires="+date.toGMTString();
	}
	else var expires = "";
	document.cookie = name+"="+value+expires+"; path=/";
}

function readCookie(name) {
	var nameEQ = name + "=";
	var ca = document.cookie.split(';');
	for(var i=0;i < ca.length;i++) {
		var c = ca[i];
		while (c.charAt(0)==' ') c = c.substring(1,c.length);
		if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
	}
	return null;
}

function eraseCookie(name) {
	createCookie(name,"",-1);
}

/* code for home page */
/* for changing height of name and price after hovering on product field */
$(".sider_container .slide-item").on('mouseenter', function() {
	var name_and_price_block = $(this).find('.name_price_cart_block');
	name_and_price_block.outerHeight(name_and_price_block.find('a.slide-title').outerHeight(true) + name_and_price_block.find('.product_price').outerHeight(true) + 4);
});

$(".sider_container .slide-item").on('mouseleave', function() {
	var name_and_price_block = $(this).find('.name_price_cart_block');
	name_and_price_block.outerHeight(54);
});