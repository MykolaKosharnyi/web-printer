<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="true"%>
<!DOCTYPE>
<html>
<head>
<style>
  #sortable { list-style-type: none; margin: 0; padding: 0; width: 850px; height: auto;}
  #sortable li { margin: 3px 3px 3px 0; border-radius: 5px; padding: 1px; float: left; width: auto; height: auto; font-size: 1em; text-align: center; }
  #sortable li img{ width:200px ; height:145px; margin: 0px 5px 5px 5px; }
  </style>

	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>
		<spring:message text="${headOfPage}" />
	</title>
</head>
<body>
	<c:url var="addPictures" value="/admin/pictures/right_of_reklam/${subDirectory}/upload_pictures" ></c:url>
	
	<div id="product">

		<label id="head_of_page"><spring:message text="${headOfPage}" /></label>
			
		<span>Всплывающая надпись на картинке:</span>		
		
		<c:if test="${listPictures.description=='1'}">
			<input type="text"  id="textOnPicture"  name="textOnPicture" value=""/>
		</c:if>
		<c:if test="${listPictures.description!='1'}">
			<input type="text"  id="textOnPicture"  name="textOnPicture" value="${listPictures.description}"/>
		</c:if>
		
		<a style="text-decoration:none; padding: 5px; border-radius: 5px;
			 background:yellow; color:blue;" href="javascript:void(0)" 
			 onclick="saveDescpitpion();" class="save_description">
			Сохранить надпись
		</a>
		<div id="pictures">
			<h3>Выберите фотографии для загрузки</h3>
				
			<form:form method="POST" commandName="add_picture" action="${addPictures}" enctype="multipart/form-data">
				<p><input id="files-upload" type="file" id="files" name="files" accept="image/*" ></p>
			</form:form>
		
			<ul id="sortable">
				<c:forEach items="${listPictures.fileNameArray}" var="namePicture">
					<li class="ui-state-default" id="${namePicture}">
						<div>
							<p class="delete_img">Удалить</p>
						</div>
						<img src="/images/home/right_of_reklam/${subDirectory}/${namePicture}" alt="">
					</li>
				</c:forEach>
			</ul>
		</div>
		
	</div>
	<script type="text/javascript">
	$(function() {

    	var filesUpload = document.getElementById("files-upload"),
    		dropArea = document.getElementById("drop-area"),
    		fileList = document.getElementById("sortable");

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
    		if (typeof FileReader !== "undefined" && (/image/i).test(file.type)) {
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

    });

      $(function() {
    	$('#sortable').sortable({
    		update: function(event, ui) {
    			var pictureOrder = $(this).sortable('toArray');
    			var data = JSON.stringify(pictureOrder);
    			$.ajax({
    				  type: 'POST',
    				  url: "/admin/pictures/right_of_reklam/${subDirectory}/change_order_pictures",
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
    		  url: "/admin/pictures/right_of_reklam/${subDirectory}/remove_picture/" + $(this).closest('li').attr('id').replace(".", ":"),
    		  contentType: "application/json; charset=utf-8",
              dataType: "json"
    		  });	
    	
    	  li.remove();
    	});
    

    	function saveDescpitpion(){
    		if($("#textOnPicture").val()==null || ($("#textOnPicture").val())==""){
    			$.ajax({
					  type: 'POST',
					  url: "/admin/pictures/right_of_reklam/${subDirectory}/save_description/1",
					  contentType: "application/json; charset=utf-8",
			          dataType: "json"
					  });	
    		}else{
	    		$.ajax({
					  type: 'POST',
					  url: "/admin/pictures/right_of_reklam/${subDirectory}/save_description/" + $("#textOnPicture").val(),
					  contentType: "application/json; charset=utf-8",
			          dataType: "json"
					  });	
    		}
    		}
       /*-- для перетаскивания картинок(изменения порядка показа) --*/
   $(function() {
    $( "#sortable" ).sortable();
    $( "#sortable" ).disableSelection();
  });
	</script>
</body>
</html>