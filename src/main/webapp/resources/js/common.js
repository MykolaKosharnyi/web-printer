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
		itemsDesktop: false
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

	//Каруселька для принтеров
	var owl_printer = $(".carousel_printer");
	owl_printer.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
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


	//Каруселька для 3D принтеров
	var owl_printer_3d = $(".carousel_printer_3d");
	owl_printer_3d.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
	});
	owl_printer_3d.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_printer_3d.trigger("owl.prev");
		} else {
			owl_printer_3d.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_printer_3d").click(function() {
		owl_printer_3d.trigger("owl.next");
	});
	$(".prev_button_printer_3d").click(function() {
		owl_printer_3d.trigger("owl.prev");
	});

	//Каруселька для цыфровых принтеров
	var owl_printer_d = $(".carousel_printer_d");
	owl_printer_d.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
	});
	owl_printer_d.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_printer_d.trigger("owl.prev");
		} else {
			owl_printer_d.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_printer_d").click(function() {
		owl_printer_d.trigger("owl.next");
	});
	$(".prev_button_printer_d").click(function() {
		owl_printer_d.trigger("owl.prev");
	});

//Каруселька for laminator
	var owl_laminator = $(".carousel_laminator");
	owl_laminator.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
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

//Каруселька for laminator
	var owl_laser = $(".carousel_laser");
	owl_laser.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
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

//Каруселька for cutter
	var owl_cutter = $(".carousel_cutter");
	owl_cutter.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
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

//Каруселька for scaner
	var owl_scaner = $(".carousel_scaner");
	owl_scaner.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
	});
	owl_scaner.on("mousewheel", ".owl-wrapper", function (e) {
		if (e.deltaY > 0) {
			owl_scaner.trigger("owl.prev");
		} else {
			owl_scaner.trigger("owl.next");
		}
		e.preventDefault();
	});
	$(".next_button_scaner").click(function() {
		owl_scaner.trigger("owl.next");
	});
	$(".prev_button_scaner").click(function() {
		owl_scaner.trigger("owl.prev");
	});

//Каруселька for previously_used
	var owl_previously_used = $(".carousel_previously_used");
	owl_previously_used.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
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

//Каруселька for rip
	var owl_rip = $(".carousel_rip");
	owl_rip.owlCarousel({
		items : 3,
		autoHeight : false,
		itemsDesktop: false
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
	$("#callback").submit(function() {
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
	});

});