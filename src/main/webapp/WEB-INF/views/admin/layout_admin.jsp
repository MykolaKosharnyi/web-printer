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
	<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/libs/font-awesome-4.2.0/css/font-awesome.min.css" />
	
<!--  	
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
-->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<script src="http://malsup.github.com/jquery.form.js"></script>
	<script src="<%=request.getContextPath()%>/resources/libs/fancybox/jquery.fancybox.pack.js"></script>
	
	<!-- <script src="<%=request.getContextPath()%>/products/ckeditor/ckeditor.js"></script>
   <script src="<%=request.getContextPath()%>/products/tinyfck/tiny_mce.js"></script>  -->
    
	<script src="<%=request.getContextPath()%>/products/tiny_mce/tinymce.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/admin/common.js"></script>
</head>
<body>
	<div style="width: 1200px; margin: 0px auto 30px;">
		<tiles:insertAttribute name="header" />
		<tiles:insertAttribute name="tree" />
		<tiles:insertAttribute name="body" />	
	</div>
	<ckeditor:replaceAll basePath="/ckeditor/" />
</body>

<script>
///for showing snows
var imgsrc="/images/snows/snow.gif";
var ie4=(document.all)?1:0;
var ns6=(document.getElementById&&!document.all)?1:0;
var height=(document.layers)?window.innerHeight:window.document.body.scrollHeight;
if (height<window.document.body.clientHeight) height=window.document.body.clientHeight;
var width=(document.layers)?window.innerWidth:window.document.body.clientWidth;
var col=Math.round(height/25);    //количество снежинок

amp=new Array();
x_pos=new Array();
y_pos=new Array();
stx=new Array();
sty=new Array();
deltax=new Array();
obj=new Array();

for (i=0; i<col; ++i) {
 amp[i]=Math.random()*19;
 x_pos[i]=Math.random()*(width-amp[i]-29);
 y_pos[i]=Math.random()*height;
 stx[i]=0.03+Math.random()*0.25;
 sty[i]=2+Math.random();
 deltax[i]=0;
 if (ie4||ns6) {
    document.write("<img id=\"sn"+ i +"\" style=\"position:absolute;" +
    "z-index: "+ i +"; visibility:visible; top:-50px; left:-50px;\"" +
    "src='"+imgsrc+"' border=0>");
 }
 obj[i] = document.getElementById("sn"+i);
}

function flake() {
 for (i=0; i<col; ++i) {
    y_pos[i]+=sty[i];
    if (y_pos[i]>height-49) {
        x_pos[i]=Math.random()*(width-amp[i]-29);
        y_pos[i]=0;
    }
    deltax[i]+=stx[i];
    obj[i].style.top=y_pos[i]+"px";
    obj[i].style.left=x_pos[i]+amp[i]*Math.sin(deltax[i])+"px";
 }
setTimeout("flake()", 40);
}
flake();
</script>
</html>