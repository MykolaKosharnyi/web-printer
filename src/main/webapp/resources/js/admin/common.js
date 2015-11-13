		tinymce.init({
					selector : "textarea",
					theme : "modern",
					language : "ru",
					height: 400,
					plugins : [
							"advlist autolink lists link image charmap print preview hr anchor pagebreak",
							"searchreplace wordcount visualblocks visualchars code fullscreen",
							"insertdatetime media nonbreaking save table contextmenu directionality",
							"emoticons template paste textcolor colorpicker textpattern imagetools" ],
					toolbar1 : "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image",
					toolbar2 : "preview media | forecolor backcolor emoticons",
					image_advtab : true,
					templates : [ {
						title : 'Test template 1',
						content : 'Test 1'
					}, {
						title : 'Test template 2',
						content : 'Test 2'
					} ]
				});
		
		/*--- реализация выпадающих подпунктов ---*/
        $( function(){
            $(".block_title").click(function(){
                var check = $(this).parent('.characteristic').find(".check_boxes");
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
            	axis: "y",
            	cursor: "move",
            	opacity: 1
            });
            $( "#file-list" ).disableSelection();
          });