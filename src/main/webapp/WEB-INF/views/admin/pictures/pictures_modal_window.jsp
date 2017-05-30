<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta charset='utf-8'>

<div id="pictures_modal_window" class="modal fade">
	<div class="modal-dialog" style="width:800px;">
		<div class="modal-content">
			<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>              
				<h5 class="modal-title">Управление изображениями</h5>
            </div>
            <div class="modal-body" style="padding: 5px 5px 0px 5px;">	       
					
				<div class="form-group path_to_pictures">
					<ol class="breadcrumb">

					</ol>
				</div>		
					
			</div>
            <div class="modal-footer">
            	<button class="btn btn-success" onclick="">Добавить изображение</button>
            	<button class="btn btn-success" onclick="addNewDirectoryModalWindow()">Добавить директорию</button>
            	<button class="btn btn-warning" onclick="">Удалить изображение</button>
            	<button class="btn btn-warning" onclick="">Удалить директорию</button>
            </div>
		</div>
	</div>	
</div>	

<script>
var pathPictureDirectoriesInModalWindow = [{path:"root_path", name_presentation:"Корневой каталог"}];

function getPictureFromModalWindowByPathToDirectory(positioInArray){
	var sizeOfArray = pathPictureDirectoriesInModalWindow.length-1;
	for(var currentPosition = sizeOfArray; positioInArray < currentPosition; currentPosition--){
		pathPictureDirectoriesInModalWindow.splice(currentPosition, 1);	
	}
	
	getPictureFromModalWindow();
}

function getPictureFromModalWindow(){
	$('#pictures_modal_window').modal('show');
	
	var modalBody = $('#pictures_modal_window').find(".modal-dialog .modal-content .modal-body");
	var rootPath = getPathOfModalPicturesDirectories();
	
	$.ajax({
		  type: 'post',
		  url: "/pictures_in_description/" + rootPath,
		  contentType: "application/json; charset=utf-8",			        
	      success: function (files) {
	    	  
	    	  //load new path to pictures
	    	  createNewPathToPicturesInModalWindow();
	    	  
	    	  //remove old pictures
	    	  $('#pictures_modal_window').find(".modal-dialog .modal-content .modal-body .modal_current_group_of_pictures").remove();
	    	  
	    	  var formGroup = $("<div/>").addClass("form-group modal_current_group_of_pictures");
	    	  var countOfElements = 0;
	    	  
	    	  $(files).each(function(index, file){
	    		  
 				var filePicture;
	    		  
	    		  if(file.isDirectory){
	    			  filePicture = $("<i/>").addClass("fa fa-folder-open modal_pictures_directory");
	    			  
	    			  formGroup.append($('<div/>').addClass("file_pictures_modal_window directory_pictures_modal_window")
		    				  .append(filePicture)
		    				  .append($('<div/>').addClass("name_of_picture_file").text(file.name)));
	    		  } else {
	    			  var pathToPicture = getPathOfModalPicturesDirectoriesWithSlash();
	    			  filePicture = $("<img/>").attr("src", "/images/" + pathToPicture + file.name);
	    			  
	    			  formGroup.append($('<div/>').addClass("file_pictures_modal_window")
		    				  .append(filePicture)
		    				  .append($('<div/>').addClass("name_of_picture_file").text(file.name))
		    				  .attr("data-toggle","tooltip")
		    				  .attr("data-placement","top")
		    				  .attr("title","Чтобы добавить адрес картинки в буффер просто кликните по ней")
		    				  .attr("onclick","copyToClipboardModalWindow('http://e-machine.com.ua/images/" + pathToPicture + file.name + "');")
		    				  
	    			  );
	    		  }

	    		  countOfElements++;
	  			});
	    	  
	    	 var heightOfPicturesFile = $( "#pictures_modal_window .file_pictures_modal_window" ).height();
	    	  modalBody.append(formGroup.css({'height': parseInt(countOfElements/4) * 155 + 200 + 'px'}));
	      },
		  error: function(xhr, status, error) {
			  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
		  }
		});
}

function createNewPathToPicturesInModalWindow(){
	var pathKeeper = $("#pictures_modal_window .modal-dialog .modal-content .modal-body .path_to_pictures ol.breadcrumb");
	
	//remove old child element
	pathKeeper.find('li').remove();
	
	var sizeOfArray = pathPictureDirectoriesInModalWindow.length;
	for (var i = 0; i < sizeOfArray; i++) {
		if(i!=sizeOfArray-1){
			pathKeeper.append($('<li/>').append($('<a/>').attr("href","javascript:void(0)")
						.attr("onclick","getPictureFromModalWindowByPathToDirectory(" + i + ");")
						.text(pathPictureDirectoriesInModalWindow[i]["name_presentation"])));
		} else {
			pathKeeper.append($('<li/>').addClass("active")
					.text(pathPictureDirectoriesInModalWindow[i]["name_presentation"]));
		}
	}
}

function getPathOfModalPicturesDirectories(){
	
	var sizeOfArray = pathPictureDirectoriesInModalWindow.length;

	if(sizeOfArray==1){
		return "root_path";
	} else {
		var result = "";
		for (var i = 1; i < sizeOfArray; i++) {
		    result+=pathPictureDirectoriesInModalWindow[i]["path"];
		    if(i!=sizeOfArray-1){
		    	result+=":";
		    }
		}
		return result;
	}
}

function getPathOfModalPicturesDirectoriesWithSlash(){
	var sizeOfArray = pathPictureDirectoriesInModalWindow.length;

	var result = "";
	if(sizeOfArray > 1){
		for (var i = 1; i < sizeOfArray; i++) {
			result += pathPictureDirectoriesInModalWindow[i]["path"] + "/";
		}
	}
	
	return result;
}

function copyToClipboardModalWindow(path) {
	var $temp = $("<input>");
	$("body").append($temp);
	$temp.val("" + path).select();
	document.execCommand("copy");
	$temp.remove();
}

$(document).on("dblclick", '#pictures_modal_window .directory_pictures_modal_window', function(){
	  var endOfPath = $(this).find("div.name_of_picture_file").text();
	  
	  pathPictureDirectoriesInModalWindow.push({'path':endOfPath, 'name_presentation':endOfPath});
	  
	  // load pictures from new path
	  getPictureFromModalWindow();
});

//
function addNewDirectoryModalWindow(){
	var formGroup = $('#pictures_modal_window').find(".modal-dialog .modal-content .modal-body .modal_current_group_of_pictures");
	
	var filePicture = $("<i/>").addClass("fa fa-folder-open modal_pictures_directory");
	
	var countOfElements = formGroup.find('.file_pictures_modal_window').length;
	
	formGroup.append($('<div/>').addClass("file_pictures_modal_window")
			  	.append(filePicture)
			  	.append($('<div/>').addClass("name_of_picture_file").append($('<input/>')
			  			.attr("type","text")
			  			.val("New folder")			  
			  			.keypress(function(e){picturesModalWindowSaveNameOnFolder(e,$(this))})
			  			.focus()
			  			)))
			  .css({'height': parseInt(countOfElements/4) * 155 + 200 + 'px'});
}

function picturesModalWindowSaveNameOnFolder(typeOfKey,element){
	
	 var key = typeOfKey.which;
	 if(key == 13)  // the enter key code
	  {
		var parent = element.parent('.name_of_picture_file');
		var textInInput = element.val();
		parent.empty();
		parent.text(textInInput);
		parent.parent(".file_pictures_modal_window").addClass("directory_pictures_modal_window");
		
		var rootPath = getPathOfModalPicturesDirectories();
		$.ajax({
			  type: 'post',
			  url: "/create_directory_pictures_in_description/" + rootPath,
			  contentType: "application/json; charset=utf-8",		
			  data:JSON.stringify(textInInput),
		      success: function (data) {	    	  
		    	  alert(data.msg);
		    	  getPictureFromModalWindow();
		      },
			  error: function(xhr, status, error) {
				  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
			  }
			});
		
	    return false;  
	  }
}


</script>