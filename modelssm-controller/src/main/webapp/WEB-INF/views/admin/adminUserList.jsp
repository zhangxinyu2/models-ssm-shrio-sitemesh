<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath }" ></c:set>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${path}/static_1/js/admin.js"></script>
<title>用户管理</title>
<style type="text/css">
.form-control-feedback {
    right: 15px;
    }
    
.row{
	 margin-top: 15px;  
}
</style>
</head>
<body>
	<div class="panel panel-default">
	<div class="panel-primary">
		<div class="panel-heading">
			权限管理/用户管理
		</div>
	</div>
	<div class="panel-default">
		<div class="panel-heading">
			<form class="form-group" id="formValidator" action="${path}/admin/addAdmin" method="post">
				<div class="row">
					<div class="form-group">
						<div class="col-md-2">
							<input class="form-control" name="request_param1" id="param1" value="${param.request_param1 }" placeholder="用户名" autocomplete="off" />
						</div>
						<div class="col-md-2">
							<input class="form-control" name="request_param2" id="param2" value="${param.request_param2 }" placeholder="真实姓名" autocomplete="off" />
						</div>
						<div class="col-md-2">
							<input type="submit" class="btn btn-default" id="addAdmin" value="添加">
						</div>
					</div>
				</div>
			</form>
			<form class="form-group" action="${path}/admin/quaryAdminUserList">
				<div class="row">
					<div class="form-group">
						<div class="col-md-2 col-md-offset-6">
							<input class="form-control"  name="request_param3" id="param3" value="${param.request_param3 }" placeholder="用户名"/>
						</div>
						<div class="col-md-2">
							<input class="form-control" name="request_param4" id="param4" value="${param.request_param4 }" placeholder="真实姓名"/>
						</div>
						<div class="col-md-2">
							<input type="submit" class="btn btn-primary" value="搜索">
							<input type="button" id="reset" class="btn btn-primary" value="重置">
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered">
			<thead>
				<tr>
					<th>用户名</th>
					<th>真实姓名</th>
					<th>添加时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty adminPage}"></c:when>
					<c:otherwise>
						<c:forEach var="ap" items="${adminPage.content}" varStatus="apNum">
							<tr>
								<td>${ap.name}</td>
								<td><input type="text" id="${ap.id}" class="input-small" value="${ap.realname}"/></td>
								<td>
									<c:if test="${ap.createtime!=null }">
										<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										 	value="${ap.createtime }"/>
									 </c:if>
								</td>
								<td>
									<c:if test='${ap.name !="admin"}'>
										<a onclick="updateAdmin(${ap.id})">修改</a>&nbsp;&nbsp;
										<a onclick="location.href='delete?id=${ap.id}';">删除</a>&nbsp;&nbsp;
										<a onclick="resetPwd(id='${ap.id}')">重置密码</a>&nbsp;&nbsp;
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>				
				</c:choose>
			</tbody>
		</table>
		<span id="error" style="color: red">${error}</span><br>
		<center>
			<c:choose>
				<c:when test="${empty adminPage}">
				</c:when>
				<c:otherwise>
					<tags:pagination page="${adminPage}" paginationSize="5" />
				</c:otherwise>
			</c:choose>
		</center>		
	</div>
	</div>
</body>
</html>