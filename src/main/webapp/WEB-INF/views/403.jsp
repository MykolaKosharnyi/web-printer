<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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

<title><spring:message code="403.access_denied"/></title>

</head>
<body>
	<h1><spring:message code="403.access_denied_to_visit_page"/></h1>

	<c:choose>
		<c:when test="${empty username}">
		  <h2><spring:message code="403.dont_have_permission"/></h2>
		</c:when>
		<c:otherwise>
			<div class="not_have_permission">
				<div>${username}</div><div><spring:message code="403.dont_have_permission_this_page"/></div></div>
		</c:otherwise>
	</c:choose>
	
	<div class="links">
		<a href="<c:url value='/' />"><spring:message code="403.go_to_home"/></a>
		<a href="<c:url value='/user' />"><spring:message code="403.go_to_user_page"/></a>
	</div>
	
</body>
</html>