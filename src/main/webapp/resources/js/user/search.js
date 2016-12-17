function ifCheckedOptionSearch(this_object) {
	this_object.parent('.search_criteria').css("background", "#E8F2FE").find(
			".block_title").find("i, p").css('color', '#006080')
}

function ifUnCheckedOptionSearch(this_object) {
	this_object.parent('.search_criteria').css("background", "#FFFFFF").find(
			".block_title").find("i, p").css('color', 'rgb(144, 144, 144)')
}

function checkOptionSearch(element, class0, class1) {
	if (element.has(class0).length > 0)
		element.find(class0).val() != element.find(class1).val() ? ifCheckedOptionSearch(element)
				: ifUnCheckedOptionSearch(element);
}

function rangeSearch(range, left_edge, right_edge, min_val, max_val){
	$( range ).slider({
          range: true,
          min: min_val,
          max: max_val,
          create: function () {
      	    $(this).slider( "values", 0, $(this).closest('.check_boxes').find('.text_output').find( left_edge ).val() );
      	    $(this).slider( "values", 1, $(this).closest('.check_boxes').find('.text_output').find( right_edge ).val() );
      	},
          slide: function( event, ui ) {
            $( left_edge ).val(ui.values[ 0 ]);
            $( right_edge ).val(ui.values[ 1 ]);
          }
        });
            
        $( left_edge ).val( $( range ).slider("values", 0 ));             
        $( right_edge ).val( $( range ).slider("values", 1 ));
            
        $( left_edge ).change(function() {
        	$( range ).slider('values',0,this.value);
            });
            
        $( right_edge ).change(function() {
        	$( range ).slider('values',1,this.value);
            });
}

/*-- реализация подпунктов ширины в виде вкладок --*/
(function($){				
    jQuery.fn.lightTabs = function(options){
        var createTabs = function(){
            tabs = this;
            i = 0;

            showPage = function(i){
                $(tabs).children("div").children("div").hide();
                $(tabs).children("div").children("div").eq(i).show();
                $(tabs).children("ul").children("li").removeClass("active");
                $(tabs).children("ul").children("li").eq(i).addClass("active");
            }

            showPage(0);				

            $(tabs).children("ul").children("li").each(function(index, element){
                $(element).attr("data-page", i);
                i++;                        
            });

            $(tabs).children("ul").children("li").click(function(){
                showPage(parseInt($(this).attr("data-page")));
            });				
        };		
        return this.each(createTabs);
    };	
})(jQuery);
$(document).ready(function(){
    $("#tabs").lightTabs();
});
/*--- реализация выпадающих подпунктов ---*/
$( function(){
    $(".search_criteria .block_title").click(function(){
        var check = $(this).parent('.search_criteria').find(".check_boxes");
        var check_point = $(this).find("i");
        if (check.css('display') == 'none') {
            check.slideDown();
          /*  check.css('display', 'block');*/
            check_point.addClass('opened');
        }else{
            check.slideUp();
         /*   check.css('display', 'none');*/
            check_point.removeClass('opened');
        }
    });
} );
/* for block characteric */
$( function(){
    $(".block_search_criteria .block_block_title").click(function(){
        var check = $(this).parent('.block_search_criteria').find(".block_check_boxes");
        var check_point = $(this).find("i").first();
var description = $(this).find("p").first();
        if (check.css('display') == 'none') {
            check.slideDown();
            description.css('color', '#006080');
            check_point.addClass('opened');
        }else{
            check.slideUp();
            description.css('color', 'rgb(144, 144, 144)');
            check_point.removeClass('opened');
        }
    });
} );

/*---- Button change display on search block ----*/
$( function() {
   $("#display_search").click(function(){ 
    var check_point = $(this).find("i");
      if ( $("#search_product").css('display') == 'none' ) {
             $("#search_product").slideDown(1000);
             check_point.addClass('opened');
              } else {
             $("#search_product").slideUp(1000);
             check_point.removeClass('opened');
             }
      });
} );
