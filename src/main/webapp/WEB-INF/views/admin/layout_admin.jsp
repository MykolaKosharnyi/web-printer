<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<!DOCTYPE>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="/images/logo.jpg" />
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/add_change_printer.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/fancybox/jquery.fancybox.css" />
	
<!--  	
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/fancybox/jquery.fancybox.pack.js"></script>
	
	<script src="<%=request.getContextPath()%>/resources/js/ckeditor/ckeditor.js"></script>
   <!--  <script src="<%=request.getContextPath()%>/resources/js/tiny_mce/tiny_mce.js"></script>
    <script src="tinyfck/tiny_mce.js"></script> -->
	<script src="<%=request.getContextPath()%>/resources/js/admin/common.js"></script>
</head>
<body>
	<div style="width: 1200px; margin: 0 auto;">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="tree" />
		<tiles:insertAttribute name="body" />	
	</div>
	<ckeditor:replaceAll basePath="/ckeditor/" />
</body>
</html>