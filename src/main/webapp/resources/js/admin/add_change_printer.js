/*---- диапазон для цены ----*/          
            $(function() {
            $( ".slider-range-prise" ).slider({
              range: "min",
              min: 0,
              max: 100000,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-prise').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-prise" ).val(ui.value);
              }
            });
                
            $( ".amount-prise" ).val( $( ".slider-range-prise" ).slider("value"));             
                
            $( ".amount-prise" ).change(function() {
            	$(".slider-range-prise").slider('value',this.value);
            });

          });

/*--- для максимальной потребляемой мощности ----*/
          $(function() {
            $( ".slider-range-max_power_consumption" ).slider({
              range: "min",
              min: 0,
              max: 2500,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-max_power_consumption').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-max_power_consumption" ).val( ui.value);
              }
            });
              
            $( ".amount-max_power_consumption" ).val($( ".slider-range-max_power_consumption" ).slider( "value"));
              
            $( ".amount-max_power_consumption" ).change(function() {
            $(".slider-range-max_power_consumption").slider('value',this.value);
                });
            
          });
/*--- для веса ----
          $(function() {
            $( ".slider-range-weight" ).slider({
              range: "min",
              min: 0,
              max: 5000,
              create: function () {
          	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-weight').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-weight" ).val( ui.value);
              }
            });
              
            $( ".amount-weight" ).val($( ".slider-range-weight" ).slider( "value"));
              
            $( ".amount-weight" ).change(function() {
            $(".slider-range-weight").slider('value', this.value);
                });
              
          });*/
/*--- для ширины ---*/
          $(function() {
            $( ".slider-range-width" ).slider({
              range: "min",
              min: 0,
              max: 10000,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-width').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-width" ).val( ui.value);
              }
            });
              
            $( ".amount-width" ).val($( ".slider-range-width" ).slider( "value"));
              
            $( ".amount-width" ).change(function() {
            $(".slider-range-width").slider('value', this.value);
                });
              
          });
/*--- для высоты ---*/
          $(function() {
            $( ".slider-range-heigth" ).slider({
              range: "min",
              min: 0,
              max: 10000,
              create: function () {
          	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-heigth').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-heigth" ).val( ui.value);
              }
            });
              
            $( ".amount-heigth" ).val($( ".slider-range-heigth" ).slider( "value"));
              
            $( ".amount-heigth" ).change(function() {
            $(".slider-range-heigth").slider('value',this.value);
                });
              
          });
/*--- для глубины ---*/
          $(function() {
            $( ".slider-range-depth" ).slider({
              range: "min",
              min: 0,
              max: 10000,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-depth').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-depth" ).val( ui.value);
              }
            });
              
            $( ".amount-depth" ).val($( ".slider-range-depth" ).slider( "value"));
              
            $( ".amount-depth" ).change(function() {
            $(".slider-range-depth").slider('value', this.value);
                });
              
          });

/*-*/
          $(function() {

        	var filesUpload = document.getElementById("files-upload"),
        		dropArea = document.getElementById("drop-area"),
        		fileList = document.getElementById("file-list");

        	function uploadFile(file) {
        		var li = document.createElement("li"),
        			div = document.createElement("div"),
        			img,
        			progressBarContainer = document.createElement("div"),
        			progressBar = document.createElement("div"),
        			reader,
        			idLI,
        			fileInfo="";

        		li.appendChild(div);
        		li.setAttribute("class", "ui-state-default");

        		progressBarContainer.className = "progress-bar-container";
        		progressBar.className = "progress-bar";
        		progressBarContainer.appendChild(progressBar);
        		li.appendChild(progressBarContainer);

        		$('#add_picture').ajaxForm( {
        			type: 'post',
        			success: function(result){
        				li.id = result;
        			}
        			}).submit();
        		
        		/*
        		If the file is an image and the web browser supports FileReader,
        		present a preview in the file list
        		 */
        		if (typeof FileReader !== "undefined"
        				&& (/image/i).test(file.type)) {
        			img = document.createElement("img");
        			li.appendChild(img);
        			reader = new FileReader();
        			reader.onload = (function(theImg) {
        				return function(evt) {
        					theImg.src = evt.target.result;
        				};
        			}(img));
        			reader.readAsDataURL(file);
        		} 

        		fileInfo += "<p class=\"delete_img\">Удалить</p>";
        		div.innerHTML = fileInfo;

        		fileList.appendChild(li);
        	}

        	function traverseFiles(files) {
        		if (typeof files !== "undefined") {
        			for (var i = 0, l = files.length; i < l; i++) {
        				uploadFile(files[i]);
        			}
        		} else {
        			fileList.innerHTML = "No support for the File API in this web browser";
        		}
        	}

        	filesUpload.addEventListener("change", function() {
        		traverseFiles(this.files);
        		jQuery(".no-items").remove();
        	}, false);

        	dropArea.addEventListener("dragleave", function(evt) {
        		var target = evt.target;

        		if (target && target === dropArea) {
        			this.className = "";
        		}
        		jQuery(".no-items").remove();
        		evt.preventDefault();
        		evt.stopPropagation();
        	}, false);

        	dropArea.addEventListener("dragenter", function(evt) {
        		this.className = "over";
        		jQuery(".no-items").remove();
        		evt.preventDefault();
        		evt.stopPropagation();
        	}, false);

        	dropArea.addEventListener("dragover", function(evt) {
        		jQuery(".no-items").remove();
        		evt.preventDefault();
        		evt.stopPropagation();
        	}, false);

        	dropArea.addEventListener("drop", function(evt) {
        		traverseFiles(evt.dataTransfer.files);
        		this.className = "";
        		jQuery(".no-items").remove();
        		evt.preventDefault();
        		evt.stopPropagation();
        	}, false);
        });

          $(function() {
        	$('#file-list').sortable({
        		update: function(event, ui) {
        			var pictureOrder = $(this).sortable('toArray');
        			var data = JSON.stringify(pictureOrder);
        			$.ajax({
        				  type: 'POST',
        				  url: "/admin/printer/change_order_pictures",
        				  data: data,
        				  contentType: "application/json; charset=utf-8",
        		          dataType: "json"
        				  });
        			/*$.post('/nk/admin/printer/change_order_pictures', JSON.stringify(data), function() {}, 'json');*/
        		}
        	});
        });

        $(document).on('click', '.delete_img', function(){
        	var li = $(this).closest('li');
        	var id = li.attr('id').replace(".", ":");
        	
        	$.ajax({
        		  type: 'POST',
        		  url: "/admin/printer/remove_picture/" + $(this).closest('li').attr('id').replace(".", ":"),
        		  contentType: "application/json; charset=utf-8",
                  dataType: "json"
        		  });	
        	
        	  li.remove();
        	});
       