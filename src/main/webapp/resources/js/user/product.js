(function($){				
    jQuery.fn.lightTabs = function(option){
        
        var createTabs = function(){
            tabs = this;
            i = 0;
            
            showPage = function(i){
                $(tabs).children("div").children("div").hide();
                $(tabs).children("div").children("div").eq(i).show();
                $(tabs).children("ul").children("li").removeClass("active");
                $(tabs).children("ul").children("li").eq(i).addClass("active");
            }
            
            showPage(option);				
            
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

	var QueryString = function () {
		  var query_string = {"option":0};
		  var query = window.location.search.substring(1);

		    var pair = query.split("=");
		    query_string[pair[0]] = decodeURIComponent(pair[1]);		    
		  
		  return query_string;
		}();
	
	
    $("#tabs_product").lightTabs(QueryString.option);
    setNewHeightOfPicturesBlock();
    
    $('.small_pictures a').on('click', function(e) {

		var currImg = $(this).find('img').attr('src');
		var bigImage = $(this).parent('.small_pictures').parent('div.row').parent('div').parent('div#pictures')
			.find('div div.bigImage');
		bigImage.find('img').attr('src', currImg);
		bigImage.find('a').attr('href', currImg);
		
		setNewHeightOfPicturesBlock();
	});
    
	$(".small_pictures a").hover(function() {
		
		var currImg = $(this).find('img').attr('src');
		var bigImage = $(this).parent('.small_pictures').parent('div.row').parent('div').parent('div#pictures')
			.find('div div.bigImage');
		bigImage.find('img').attr('src', currImg);
		bigImage.find('a').attr('href', currImg);
		
		setNewHeightOfPicturesBlock();
	});
});

function setNewHeightOfPicturesBlock(){
	var firstDiv = $('#pictures div').first();
	var newHeight = (firstDiv.height()-firstDiv.next('div').height() > 0) ? firstDiv.height():firstDiv.next('div').height();
	$('#pictures').height( newHeight );
}