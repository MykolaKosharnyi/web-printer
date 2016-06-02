/*--- реализация выпадающих подпунктов ---*/
        $( function(){
            $(".block_title").click(function(){
                var check = $(this).parent('.characteristic').find(".check_boxes, .box_text_area");
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
        
/*-- для перетаскивания картинок(изменения порядка показа) --*/
        $(function() {
            $( "#file-list" ).sortable({
            	cursor: "move",
            	opacity: 1
            });
            $( "#file-list" ).disableSelection();
          });
        
        $(function() {
            $( "#file-list_update" ).sortable({
            	cursor: "move",
            	opacity: 1
            });
            $( "#file-list_update" ).disableSelection();
          });
        
/*--- сохранение состояния дерева переходов при переходе на новую страницу ---*/
        /* сохранение состояние узла при переходе или обновлении страницы javascript */
$( function() {
	if(sessionStorage.getItem('left_tree')!=null){
        	$("div#tree_links").html('').append(sessionStorage.getItem('left_tree'));
		}
    }); 

/*--- Для дерева переходов 
  Cохранение состояния дерева переходов при переходе на новую страницу ---*/
        $( function() {
            $("#tree_links .Expand").click(function(){
            	var node = $(this).closest('.Node');             
                
            	if(node.hasClass("ExpandClosed")){
                	node.removeClass("ExpandClosed").addClass("ExpandOpen");
                	sessionStorage.setItem('left_tree', $("div#tree_links").html()); // сохраняем значение в ключ left_tree
                	
                } else if(node.hasClass("ExpandOpen")){
                	node.removeClass("ExpandOpen").addClass("ExpandClosed");
                	sessionStorage.setItem('left_tree', $("div#tree_links").html()); // сохраняем значение в ключ left_tree
                }

               });
         } ); 
        

/*--- Что бы безопасность пропускала AJAX POST вызовы ---*/        
        $(function () {
      	  var token = $("meta[name='_csrf']").attr("content");
      	  var header = $("meta[name='_csrf_header']").attr("content");
      	  $(document).ajaxSend(function(e, xhr, options) {
      	    xhr.setRequestHeader(header, token);
      	  });
      	});
        
/* Для розкрытия заполненных полей и придания им цвета */       
        $(function() {
        	$( '.check_boxes' ).each(function() {
        		  $( this ).has(':checked').length ? changeFillStyle($( this )) : changeEmptyStyle($( this )) ;
        		  if($( this ).find(":text").val()!='' &&
        				  ($( this ).find(":text").val()!=0 || $( this ).find(":text").val()!=0.0) &&
        				  !($( this ).has("input:radio").length>0 || $( this ).has("input:checkbox").length>0)){
        			  changeFillStyle($( this ));
        		  }
        		});
        	
        function changeFillStyle(element){
        		element.css( "display", "block" );
        		element.parent('.characteristic').css( "background", "#99cc99" );
        		element.parent('.characteristic').find("i").addClass("opened");
        	}

		function changeEmptyStyle(element){
        		element.css( "display", "none" );
        		element.parent('.characteristic').css( "background", "#f00" );
        		element.parent('.characteristic').find("i").removeClass("opened");
        	}
		
		$( '.use_with_product' ).each(function() {
			var input = $(this).find(".input_uwp"); 
        	var background = $(this);
        	
        	if (input.prop( "checked" )) {
        		background.css('background', '#5E9AF3');
            }else{
            	background.css('background', '#eee');
            }
  		});
		
        });
        
/* Для продукта используемого с товаром */
        $( function() {
            $(".use_with_product div,.use_with_product img").click(function(){
            	var input = $(this).parent('.use_with_product').find(".input_uwp"); 
            	var background = $(this).parent('.use_with_product');
            	
            	if (input.prop( "checked" )) {
            		input.prop("checked", false );
            		background.css('background', '#eee');
                }else{
                	input.prop("checked", true );
                	background.css('background', '#5E9AF3');
                }

               });
            
            $(".use_with_product .input_uwp").click(function(){
            	var input = $(this).parent('.use_with_product').find(".input_uwp");
            	var background = $(this).parent('.use_with_product');
            	
            	if (input.prop( "checked" )) {
            		input.prop("checked", false );
            		background.css('background', '#eee');
                }else{
                	input.prop("checked", true );
                	background.css('background', '#5E9AF3');
                }

               });
            
         } ); 