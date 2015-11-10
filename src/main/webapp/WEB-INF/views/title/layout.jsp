<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html lang="ru">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/title.css"/>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/search.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/jquery-ui.css">
<!--  	
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<title><tiles:insertAttribute name="title" ignore="true" /></title>

<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-1.9.1.js"></script>
-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/search_printer.js"></script>
</head>
<body>
		<c:url var="search-printer" value="/printers/search" ></c:url>
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="path" />
		
	<div id="the_main_part">
		<div class="left_field">
			<tiles:insertAttribute name="left-menu" />
			<tiles:insertAttribute name="search" />
			<tiles:insertAttribute name="reklam" />
		</div>
			<tiles:insertAttribute name="body" />
	</div>
		
		<tiles:insertAttribute name="footer" />

    <script>
        $( function() {
           $("#full_menu").click(function(){
               if ( $(".menu").css('display') == 'none' ) {
                     $(".menu").slideDown(1500);
                      } else {
                     $(".menu").slideUp(1500);
                     }
              });
        } );       
    </script>
</body>
</html>
