$(function () {
    $('#fileupload').fileupload({
        dataType: 'json',
 
        done: function (e, data) {
            $("tr:has(td)").remove();
            $.each(data.result, function (index, file) {
 
                $("#uploaded-files").append(
                        $('<tr/>')
                        .append($('<td/>').html("<div id=\"result\" load=uploadFormData(index)></div>"))
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
    
 
  var oMyForm = new FormData();
  oMyForm.append("file", file2.files[0]);
 
  $.ajax({
    url: 'http://localhost:8080/nk/controller/loadpicture/' + id,
    data: oMyForm,
    dataType: 'text',
    processData: false,
    contentType: false,
    type: 'POST',
    success: function(data){
    	result.html(data);
    }
  });
}