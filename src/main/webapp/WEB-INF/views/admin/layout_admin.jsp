<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/common.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/admin/add_change_printer.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery-ui.css">
	
<!--  	
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	
    <script src="<%=request.getContextPath()%>/resources/js/tiny_mce/tinymce.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin/common.js"></script>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="tree" />
	<tiles:insertAttribute name="body" />	
</body>
</html>