<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div id="pictures_modal_window" class="modal fade">
	<div class="modal-dialog" style="width:800px;">
		<div class="modal-content">
			<div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>              
				<h5 class="modal-title">Управление изображениями</h5>
            </div>
            <div class="modal-body" style="padding: 5px 5px 0px 5px;">	
            
            	<input type="hidden" id="current_path_modal_pictures" value="root_path"/>
					
				<div class="form-group path_to_pictures">
					<ol class="breadcrumb">
					  <li><a href="javascript:void(0)" onclick="getPictureFromModalWindowByPathToDirectory(0);">Корневой каталог</a></li>
					  <li><a href="#">Library</a></li>
					  <li class="active">Data</li>
					</ol>
				</div>		
					
			</div>
            <div class="modal-footer">
            	<button class="btn btn-success">Добавить изображение</button>
            	<button class="btn btn-success">Добавить директорию</button>
            	<button class="btn btn-warning">Удалить изображение</button>
            	<button class="btn btn-warning">Удалить директорию</button>
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
	var rootPath = pathPictureDirectoriesInModalWindow[pathPictureDirectoriesInModalWindow.length-1]["path"];
	
	$.ajax({
		  type: 'post',
		  url: "/pictures_in_description/" + rootPath,
		  contentType: "application/json; charset=utf-8",			        
	      success: function (files) {
	    	  
	    	  var formGroup = $("<div/>").addClass("form-group modal_current_group_of_pictures");
	    	  var countOfElements = 0;
	    	  
	    	  $(files).each(function(index, file){
	    		  
 				var filePicture;
	    		  
	    		  if(file.isDirectory){
	    			  filePicture = $("<i/>").addClass("fa fa-folder-open modal_pictures_directory");
	    		  } else {
	    			  filePicture = $("<img/>").attr("src", "/images/" + file.name);
	    		  }

	    		  formGroup.append($('<div/>').addClass("file_pictures_modal_window")
	    				  .append(filePicture)
	    				  .append($('<div/>').addClass("name_of_picture_file").text(file.name)));
	    		  countOfElements++;
	  			});
	    	  
	    	 var heightOfPicturesFile = $( "#pictures_modal_window .file_pictures_modal_window" ).height();
	    	  modalBody.append(formGroup.css({'height': (countOfElements/4) * 160 + 'px'}));
	      },
		  error: function(xhr, status, error) {
			  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
		  }
		});
}

$(document).on("dblclick", '#pictures_modal_window .file_pictures_modal_window', function(){
	  var endOfPath = $(this).find("div.name_of_picture_file").text();
	  
	  pathPictureDirectoriesInModalWindow.push({path:endOfPath, name_presentation:endOfPath});
	  
	  //remove old pictures
	  $('#pictures_modal_window').find(".modal-dialog .modal-content .modal-body .modal_current_group_of_pictures").remove();
	  
	  //set new photos path
/*	  var picturesDirectory = $('#pictures_modal_window').find(".modal-dialog .modal-content .modal-body").find("input#current_path_modal_pictures");
	  
	  if("root_path"==picturesDirectory.val()){
		  picturesDirectory.val(endOfPath);
	  } else {
		  var oldPicturesPath = picturesDirectory.val();
		  picturesDirectory.val(oldPicturesPath + ":" + endOfPath);
	  }
*/	  
	  // load pictures from new path
	  getPictureFromModalWindow();
});
</script>