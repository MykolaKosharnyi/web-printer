$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
 
        done: function (e, data) {
            $("tr:has(td)").remove();
            $.each(data.result, function (index, file) {
 
            	/*var data1 = jQuery.get('http://localhost:8080/nk/controller/loadpicture/' + index);*/
            	
                $("#uploaded-files").append(
                        $('<tr/>')
                        .append($('<td/>').html("<p>" + (index+1) + "</p>"))
                        .append($('<td/>').html("<img src=\"data:image/jpeg;base64, " + file.bytes + "\"/>"))
                        .append($('<td/>').text(file.fileName))
                        .append($('<td/>').text(file.fileSize))
                        .append($('<td/>').text(file.fileType))
                        .append($('<td/>').html("<a href='nk/controller/get/"+index+"'>download</a>"))
                        .append($('<td/>').html("<a href='nk/controller/remove/"+index+"'>delete</a>"))
                        )//end $("#uploaded-files").append()
            }); 
        },
 
        progressall: function (e, data) {
            var progress = parseInt(data.loaded / data.total * 100, 10);
            $('#progress .bar').css(
                'width',
                progress + '%'
            );
        },
 
        dropZone: $('#dropzone')
    });
});
//using FormData() object
function uploadFormData(id){
	var result = $(this).html('');
 
  $.ajax({
    url: '/nk/controller/loadpicture/' + id,
    dataType: 'text',
    processData: false,
    contentType: false,
    type: 'POST',
    success: function(data){
    	result.html(data);
    }
  });
  
  jQuery(document).on('load', '.result', function(index){
	  $.ajax({
		    url: '/nk/printer/upload_pictures/' + index,
		    type: 'GET',
		    success: function(data){
		    	$(this).append($(data));
		    }
		  });
	});

}