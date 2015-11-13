/*---- диапазон для цены ----*/          
            $(function() {
            $( ".slider-range-prise" ).slider({
              range: "min",
              min: 1,
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
/*---- диапазон для скорости печати----*/ 
          $(function() {
            $( ".slider-range-speed-print" ).slider({
              range: "min",
              min: 1,
              max: 300,
              create: function () {
          	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-speed-print').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-speed-print" ).val( ui.value);
              }
            });
              
            $( ".amount-speed-print" ).val($( ".slider-range-speed-print" ).slider( "value"));
              
              
            $( ".amount-speed-print" ).change(function() {
            $(".slider-range-speed-print").slider('value', this.value);
                });
                
          });
/*---- диапазон для максимальной толщины носителя ----*/
          $(function() {
            $( ".slider-range-maximum_media_thickness" ).slider({
              range: "min",
              min: 1,
              max: 500,
              create: function () {
            	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-maximum_media_thickness').val() );
            	},
              slide: function( event, ui ) {
                $( ".amount-maximum_media_thickness" ).val( ui.value);
              }
            });
              
            $( ".amount-maximum_media_thickness" ).val( $( ".slider-range-maximum_media_thickness" ).slider( "value"));    
            
            $( ".amount-maximum_media_thickness" ).change(function() {
            $(".slider-range-maximum_media_thickness").slider('value',this.value);
                });
 
          });

/*--- для максимального веса носителя ---*/
          $(function() {
            $( ".slider-range-maximum_weight_of_vehicle" ).slider({
              range: "min",
              min: 5,
              max: 500,
              create: function () {
          	    $(this).slider( "option", "value", $(this).closest('.check_boxes').find('.text_output').find('.amount-maximum_weight_of_vehicle').val() );
          	},
              slide: function( event, ui ) {
                $( ".amount-maximum_weight_of_vehicle" ).val( ui.value);
              }
            });
              
            $( ".amount-maximum_weight_of_vehicle" ).val($( ".slider-range-maximum_weight_of_vehicle" ).slider( "value")); 
              
            $( ".amount-maximum_weight_of_vehicle" ).change(function() {
            $(".slider-range-maximum_weight_of_vehicle").slider('value',this.value);
                });
              
          });
/*--- для максимальной потребляемой мощности ----*/
          $(function() {
            $( ".slider-range-max_power_consumption" ).slider({
              range: "min",
              min: 1,
              max: 100,
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
/*--- для веса ----*/
          $(function() {
            $( ".slider-range-weight" ).slider({
              range: "min",
              min: 50,
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
              
          });
/*--- для ширины ---*/
          $(function() {
            $( ".slider-range-width" ).slider({
              range: "min",
              min: 1,
              max: 10,
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
              min: 1,
              max: 10,
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
              min: 1,
              max: 10,
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
/*-*/
        $(document).ready(function() {
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

        		$('#add_picture').ajaxForm( {
        			type: 'post',
        			success: function(result){
        				li.id = result;
        			}
        			}).submit(); 
        		
        		
        		
        	/*	// Uploading - for Firefox, Google Chrome and Safari
        		xhr = new XMLHttpRequest();

        		// Update progress bar
        		xhr.upload.addEventListener("progress", function(evt) {
        			if (evt.lengthComputable) {
        				progressBar.style.width = (evt.loaded / evt.total)
        						* 100 + "%";
        			} else {
        				// No data to calculate on
        			}
        		}, false);

        		// File uploaded
        		xhr.addEventListener("load", function() {
        			progressBarContainer.className += " uploaded";
        			progressBar.innerHTML = "Uploaded!";
        		}, false);*/

        	/*	xhr.open("post", "http://localhost:8080/nk/printer/upload_pictures", true);

        		// Set appropriate headers
        		xhr.setRequestHeader("Content-Type", "multipart/form-data");
        		xhr.setRequestHeader("X-File-Name", file.name);
        		xhr.setRequestHeader("X-File-Size", file.size);
        		xhr.setRequestHeader("X-File-Type", file.type);

        		// Send the file (doh)
        		xhr.send(file);*/

        		// Present file info and append it to the list of files
        	/*	fileInfo = "<div><strong>Name:</strong> " + file.name
        				+ "</div>";
        		fileInfo += "<div><strong>Size:</strong> "
        				+ parseInt(file.size / 1024, 10) + " kb</div>";
        		fileInfo += "<div><strong>Type:</strong> " + file.type
        				+ "</div>";*/
        		fileInfo += "<p class=\"delete_img\">Удалить</p>";
        		div.innerHTML = fileInfo;

        		fileList.appendChild(li);
        	}

        	function traverseFiles(files) {
        		if (typeof files !== "undefined") {
        			for (var i = 0, l = files.length; i < l; i++) {
        				uploadFile(files[i]);
        				/*if(i==files.length){
        					resetFormElement(filesUpload);
        				}*/
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
        	
        /*	function resetFormElement(e) {
        		  e.wrap('<form>').closest('form').get(0).reset();
        		  e.unwrap();

        		  // Prevent form submission
        		  e.stopPropagation();
        		  e.preventDefault();
        		}*/
        });

        $(document).ready(function(){
        	$('#file-list').sortable({
        		update: function(event, ui) {
        			var pictureOrder = $(this).sortable('toArray');
        			var data = JSON.stringify(pictureOrder);
        			$.ajax({
        				  type: 'POST',
        				  url: "/nk/admin/printer/change_order_pictures",
        				  data: data,
        				  contentType: "application/json; charset=utf-8",
        		          dataType: "json"
        				  });
        			/*$.post('/nk/admin/printer/change_order_pictures', JSON.stringify(data), function() {}, 'json');*/
        		}
        	});
        });

        jQuery(document).on('click', '.delete_img', function(){
        	var li = $(this).closest('li');
        	var id = li.attr('id').replace(".", ":");
        	
        	$.ajax({
        		  type: 'POST',
        		  url: "/nk/admin/printer/remove_picture/" + $(this).closest('li').attr('id').replace(".", ":"),
        		  contentType: "application/json; charset=utf-8",
                  dataType: "json"
        		  });	
        	
        	  li.remove();
        	});
       
