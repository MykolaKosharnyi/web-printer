<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>
<c:if test="${empty product.id}">
		<script type="text/javascript">

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
			        				  url: "/admin/${type}/change_order_pictures",
			        				  data: data,
			        				  contentType: "application/json; charset=utf-8",
			        		          dataType: "json"
			        				  });
			        		}
			        	});
			        });
			          

			        $(document).on('click', '.delete_img', function(){
			        	var li = $(this).closest('li');
			        	var id = li.attr('id').replace(".", ":");
			        	
			        	$.ajax({
			        		  type: 'POST',
			        		  url: "/admin/${type}/remove_picture/" + $(this).closest('li').attr('id').replace(".", ":"),
			        		  contentType: "application/json; charset=utf-8",
			                  dataType: "json"
			        		  });	
			        	
			        	  li.remove();
			        	});
			       
	</script>			
</c:if>
	
<c:if test="${!empty product.id}">
	<script type="text/javascript">
	$(function() {

    	var filesUploadUpdate = document.getElementById("files-upload_update"),
    		dropAreaUpdate = document.getElementById("drop-area_update"),
    		fileListUpdate = document.getElementById("file-list_update");

    	function uploadFileUpdate(file) {
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

    		$('#add_picture_update').ajaxForm( {
    			type: 'post',
    			success: function(result){
    				li.id = result;
    			}
    			}).submit();

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

    		fileInfo += "<p class=\"delete_img_update\">Удалить</p>";
    		div.innerHTML = fileInfo;

    		fileListUpdate.appendChild(li);
    	}

    	function traverseFilesUpdate(files) {
    		if (typeof files !== "undefined") {
    			for (var i = 0, l = files.length; i < l; i++) {
    				uploadFileUpdate(files[i]);
    			}
    		} else {
    			fileListUpdate.innerHTML = "No support for the File API in this web browser";
    		}
    	}

    	filesUploadUpdate.addEventListener("change", function() {
    		traverseFilesUpdate(this.files);
    		jQuery(".no-items").remove();
    	}, false);

    	dropAreaUpdate.addEventListener("dragleave", function(evt) {
    		var target = evt.target;

    		if (target && target === dropArea) {
    			this.className = "";
    		}
    		jQuery(".no-items").remove();
    		evt.preventDefault();
    		evt.stopPropagation();
    	}, false);

    	dropAreaUpdate.addEventListener("dragenter", function(evt) {
    		this.className = "over";
    		jQuery(".no-items").remove();
    		evt.preventDefault();
    		evt.stopPropagation();
    	}, false);

    	dropAreaUpdate.addEventListener("dragover", function(evt) {
    		jQuery(".no-items").remove();
    		evt.preventDefault();
    		evt.stopPropagation();
    	}, false);

    	dropAreaUpdate.addEventListener("drop", function(evt) {
    		traverseFiles(evt.dataTransfer.files);
    		this.className = "";
    		jQuery(".no-items").remove();
    		evt.preventDefault();
    		evt.stopPropagation();
    	}, false);
    });

	$(function() {
    	$('#file-list_update').sortable({
    		update: function(event, ui) {
    			var pictureOrder = $(this).sortable('toArray');
    			var data = JSON.stringify(pictureOrder);
    			$.ajax({
    				  type: 'POST',
    				  url: "/admin/${type}/change_order_pictures_update/${product.id}",
    				  data: data,
    				  contentType: "application/json; charset=utf-8",
    		          dataType: "json"
    				  });
    		}
    	});
    });

	$(document).on('click', '.delete_img_update', function(){
    	var li = $(this).closest('li');
    	var namePicture = li.attr('id').replace(".", ":");
    	
    	$.ajax({
    		  type: 'POST',
    		  url: "/admin/${type}/remove_picture_update/" + namePicture + "/${product.id}",
    		  contentType: "application/json; charset=utf-8",
              dataType: "json"
    		  });	
    	
    	  li.remove();
    });

	</script>			
</c:if>