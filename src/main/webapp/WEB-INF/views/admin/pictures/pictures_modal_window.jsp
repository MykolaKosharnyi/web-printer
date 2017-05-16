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
					
				<div class="form-group">
					<label style="font-size: 13px; margin: 5px;">/images</label> 
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
function getPictureFromModalWindow(){
	$('#pictures_modal_window').modal('show');
	
	$.ajax({
		  type: 'post',
		  url: "/pictures_in_description/path",
		  contentType: "application/json; charset=utf-8",			        
	      success: function (files) {
	    	  var modalBody = $('#pictures_modal_window').find(".modal-dialog .modal-content .modal-body");
	    	  var formGroup = $("<div/>").addClass("form-group");
	    	  var countOfElements = 0;
	    	  $(files).each(function(index, file){
	    		  formGroup.append($('<div/>').addClass("file_pictures_modal_window").text(file.name));
	    		  countOfElements++;
	  			});
	    	  
	    	 var heightOfPicturesFile = $( "#pictures_modal_window .file_pictures_modal_window" ).height();
	    	  modalBody.append(formGroup.css({'height': (countOfElements/4) * 50 + 25 + 'px'}));
	      },
		  error: function(xhr, status, error) {
			  alert('Request Status: ' + xhr.status + ' Status Text: ' + xhr.statusText + ' ' + xhr.responseText);
		  }
		});
}
</script>