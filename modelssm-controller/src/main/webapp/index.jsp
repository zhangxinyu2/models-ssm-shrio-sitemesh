<%@ page language="java" 
	import="java.util.*" 
	contentType="text/html; charset=UTF-8" %>  
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<head>	
</head>
<body>
<div>
	<h2>Hello You!</h2>
	<a href="${path}/user/queryUser">添加用户</a>
</div>
</body>
</html>
