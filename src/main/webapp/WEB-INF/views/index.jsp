<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery File Upload Example</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
 
<script src="<%=request.getContextPath()%>/resources/js/vendor/jquery.ui.widget.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.iframe-transport.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.fileupload.js"></script>
 
<!-- bootstrap just to have good looking page -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
<link href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.css" type="text/css" rel="stylesheet" />
 
<!-- we code these -->
<link href="<%=request.getContextPath()%>/resources/css/dropzone.css" type="text/css" rel="stylesheet" />
<script src="<%=request.getContextPath()%>/resources/js/myuploadfunction.js"></script>
<script>
function uploadJqueryForm(){
    $('#result').html('');
 
   $("#form2").ajaxForm({
    success:function(data) { 
          $('#result').html(data);
     },
     dataType:"text"
   }).submit();
}

</script>
</head>
 
<body>
<h1>Spring MVC - jQuery File Upload</h1>
		<c:url var="addAction1" value="/controller/upload" ></c:url>
		<form:form id="form2" method="POST"  action="${addAction1}" enctype="multipart/form-data">
	<div style="width:500px;padding:20px">
 
    <input id="fileupload" type="file" name="files[]">
 
    <div id="dropzone">Drop files here</div>
 
    <div id="progress">
        <div style="width: 0%;"></div>
    </div>
 
    <table id="uploaded-files" style="border: 1px red solid;">
        <tr>
        	<th>Index</th>
        	<th>Picture</th>
            <th>File Name</th>
            <th>File Size</th>
            <th>File Type</th>
            <th></th>
            <th></th>
        </tr>
    </table>
 
</div>
		</form:form>
</body> 
</html>