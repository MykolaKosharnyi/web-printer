<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE>
<html lang="ru">
<head>
	
	<meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" href="/images/logo.jpg" />
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css">
    
    <link rel="stylesheet" href="/css/admin/common.css">
    <link rel="stylesheet" href="/css/admin/add_change_printer.css">
	<link rel="stylesheet" href="/css/jquery-ui.css">
	<link rel="stylesheet" href="/resources/libs/fancybox/jquery.fancybox.css" />
	<link rel="stylesheet" href="/resources/libs/font-awesome-4.2.0/css/font-awesome.min.css" />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script src="/resources/libs/fancybox/jquery.fancybox.pack.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    
	<script src="/products/tiny_mce/tinymce.min.js"></script>
	<script src="/resources/js/admin/common.js"></script>
</head>
<body>
	<div style="width: 1200px; margin: 0px auto 30px;">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="tree" />
		<tiles:insertAttribute name="body" />	
	</div>
	
	<!-- import pictures modal window -->
	<jsp:include page="pictures/pictures_modal_window.jsp" />
</body>

</html>