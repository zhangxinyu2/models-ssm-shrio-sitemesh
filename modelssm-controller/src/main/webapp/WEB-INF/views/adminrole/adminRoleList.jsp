<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<script type="text/javascript" src="${path}/static_1/js/adminrole.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色用户列表</title>
<style type="text/css">
.form-control-feedback {
    right: 15px;
}
</style>
</head>
<body>
	<div class="panel panel-default" >
	<div class="panel-primary">
		<div class="panel-heading">
			权限管理/角色管理列表
		</div>
	</div>
	<div class="panel-default">
		<div class="panel-heading">
			<form id="roleForm" action="${path}/adminRole/addRole" method="post" class="form-group">
				<div class="row"> 
					<div class="col-md-2">
						<input type="text" class="form-control" id="param1"
						 	name="request_param1" value="${param.request_param1}" placeholder="角色名">
					</div>
					<div class="col-md-2 ">
						<input type="button" id="addRole" class="btn btn-primary" value="添加" >
						<input type="button" id="reset" class="btn btn-primary" value="重置" >
					</div>
				 </div> 
			</form>
		</div>
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>角色名称</th>
					<th>权限</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty arList}"></c:when>
					<c:otherwise>
						<c:forEach items="${arList}" var="ar" varStatus="arStatus">
							<tr>
								<td>${ar.name}</td>
								<td>
									<c:if test='${ar.name!="admin" }'>
										<a onclick="setShiro(${ar.id})">设置权限</a>
									</c:if>
									<c:if test='${ar.name!="admin" }'>
										<a onclick="location.href='delete?id=${ar.id}'">删除</a>
									</c:if>
								</td>
							</tr>							
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<span style="color: red">${error}</span>
	</div>
	</div>
</body>
</html>