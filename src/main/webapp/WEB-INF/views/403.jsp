<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
body{
	width: 700px; margin: 80px auto;
}

h1{color: red;}

.not_have_permission{font-weight: bold; font-size: 23px;}

.not_have_permission div:first-child{color: blue; width: auto; float: left;}

.links{display: block; margin-top: 30px;}

.links a{color: blue;}

.links a:first-child{margin-right: 15px;}

</style>

<title>Access is denied!</title>

</head>
<body>
	<h1>Access is denied to visit this page!</h1>

	<c:choose>
		<c:when test="${empty username}">
		  <h2>You do not have permission to access this page!</h2>
		</c:when>
		<c:otherwise>
			<div class="not_have_permission">
				<div>${username}</div><div>, you do not have permission to access this page!</div></div>
		</c:otherwise>
	</c:choose>
	
	<div class="links">
		<a href="<c:url value='/' />">To to home page</a>
		<a href="<c:url value='/user' />">To to user page</a>
	</div>
	
</body>
</html>