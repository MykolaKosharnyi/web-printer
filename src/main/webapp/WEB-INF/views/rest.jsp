<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rest sample</title>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
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
<!--  Form 2 -->
<i>Uploading File With Ajax</i><br/>
<form id="form2" method="post" action="/nk/cont/upload" enctype="multipart/form-data">
  <!-- File input -->    
  <input name="file2" id="file2" type="file" /><br/>
</form>
 
<button value="Submit" onclick="uploadJqueryForm()" >Upload</button><i>Using JQuery Form Plugin</i><br/>
 
<div id="result"></div>
</body>
</html>