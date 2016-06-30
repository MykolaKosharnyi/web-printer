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
  #sortable li img{ width:370px ; height:335px; margin: 0px 5px 5px 5px; }
  #file-list li {width: 300px;}
  </style>

	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<title>
		<spring:message text="Видео на главной странице" />
	</title>
</head>
<body>
	<c:url var="addPictures" value="/admin/pictures/three_big_pictures/${directory}/${subDirectory}/upload_pictures" ></c:url>
	
	<div id="product">

		<label id="head_of_page"><spring:message text="Видео на главной странице" /></label>

		<hr style="color: #006080;">

		<label id="head_of_page" style="font-size: 21px; padding: 0px; text-decoration: underline;"><spring:message text="Добавление видео:" /></label>
			
		<span>Путь к картинке (желательно, что бы видео не повторялось):</span><input id="path" style="width: 650px; float: none; display: block;"></input>	
		<span>Подпись под картинкой (будьте вниметельны с такими символами: !%*?./ и т.п. Если все-таки придется что-то подобное добавлять в описание, обязательно после добавления нового видео перезагрузите страницу, оно отобразит как будет выглядеть в действительности):</span><input id="description_video" style="width: 650px; float: none; display: block;"></input>		
		<span id="error_video" style="color:red; display: none;">Оба поля должны быть заполнены!</span>
		
		<a style="text-decoration:none; padding: 5px; margin-top: 5px; border-radius: 5px;
			 background:yellow; color:blue; float: none; display: block; width: 330px;" href="javascript:void(0)" 
			 onclick="uploadVideo();" class="save_description">
			Добавить видео на главную страницу
		</a>
		<hr style="color: #006080;">
		
		<%-- Output added video --%>
		<ul id="file-list">
			<c:if test="${empty listVideo}">
				<li class="no-items">(ни одного видео еще не добавлено)</li>
			</c:if>
			<c:if test="${!empty listVideo}">
				<c:forEach items="${listVideo}" var="video">
					<li class="ui-state-default" id="${video.path}">
						<div>
							<p class="delete_img" onclick="deleteVideo(this,'${video.path}', '${video.description}')">Удалить</p>
							<p class="copy_video" onclick="copyVideo('${video.path}', '${video.description}')"><i class="fa fa-files-o" aria-hidden="true"></i></p>
						</div>
						<div class="slide-item-video">
							<iframe style="width: inherit;" src="http://www.youtube.com/embed/${video.path}"></iframe> 
							<p>${video.description}</p>
					    </div>
					</li>
				</c:forEach>
			</c:if>
		</ul>
		
	</div>
	<script type="text/javascript">

	function uploadVideo(){
		var pathReal = $('#product input#path').val();
		var description = $('#product input#description_video').val();
		var path = pathReal.replace("https://www.youtube.com/watch?v=", "");
		
		if((path != '') && (description != '')){
			
			/* save on server new video woth description */
			$.ajax({
	  		  type: 'POST',
	  		  url: "/admin/video_on_home_page/upload_video/" + path + "/" + description.replace(".", "^").replace("/", ">"),
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
	  		});
			
	  			$('#file-list').append($('<li/>').addClass("ui-state-default").attr("id", path)
	  								.append($('<div/>')
	  										.append($('<p/>').addClass("delete_img").click(function(){
	  									deleteVideo(this, path, description);
			                		}).text("Удалить"))
			                		
			                				.append($('<p/>').addClass("copy_video").click(function(){
			                					copyVideo(path, description);
			                		}).append($('<i/>').addClass("fa fa-files-o"))))
			                		.append($('<div/>').addClass("slide-item-video").append($('<iframe/>').css('width','inherit')
			                				.attr("src", "http://www.youtube.com/embed/" + path)).append($('<p/>').text(description)))
	  							);	
			
			/* show changes on page */
			$("#error_video").hide();
			$('#path').val('');
			$('#description_video').val('');
			
		} else {
			$("#error_video").show( 2000 );
		}
	}
	
	 $(function() {
     	$('#file-list').sortable({
     		update: function(event, ui) {
     			var videoOrder = $(this).sortable('toArray');
     			var data = JSON.stringify(videoOrder);
     			$.ajax({
     				  type: 'POST',
     				  url: "/admin/video_on_home_page/change_order_video",
     				  data: data,
     				  contentType: "application/json; charset=utf-8",
     		          dataType: "json"
     				  });
     		}
     	});
     });

     function deleteVideo(element, pathV, descriptionV){
    	var li = $(element).closest('li');
    	
    	var path = pathV.replace("http://www.youtube.com/embed/", "");
    	
    	$.ajax({
    		  type: 'POST',
    		  url: "/admin/video_on_home_page/remove_video/" + path,
			  contentType: "application/json; charset=utf-8",
              dataType: "json"
    		  });	
    	
    	  li.remove();
    	};
    
    	function copyVideo(path, description){
    		 $('#product input#path').val("https://www.youtube.com/watch?v=" + path);
    		 $('#product input#description_video').val(description);
    	}

       /*-- для перетаскивания картинок(изменения порядка показа) --*/
   $(function() {
    $( "#sortable" ).sortable();
    $( "#sortable" ).disableSelection();
  });
	</script>
</body>
</html>