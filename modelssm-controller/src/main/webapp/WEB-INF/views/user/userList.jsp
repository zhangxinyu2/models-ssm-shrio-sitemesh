<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 引用c 标签  c:choose 下  c:when  c:otherwise -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 引用时间格式化 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 分页标签 -->
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看用户列表</title>
</head>
<body>
	<div class="panel-primary">
		<div class="panel-heading">
			用户管理/查询用户列表
		</div>
	</div>
	<div class="panel-default">	
		<div class="panel-heading">
			<form action="${path}/user/queryUserList" method="post">
				<div class="row">
					<div class="col-md-1">
						<a href="javascript:void(0)" class="btn btn-default" onclick="history.back(-1)" >返回</a>
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" value="${param.request_realName }" name="request_realName" id="realName" placeholder="姓名">
					</div>
					<div class="col-md-2">
						<input type="text" class="form-control" value="${param.request_age}" name="request_age" id="age" placeholder="年龄">
					</div>
				</div>
				<div class="row">
					<div class="col-md-10"></div>
					<div class="col-md-1">
						<input type="submit" class="btn btn-primary" id="query_success" value="搜索">
					</div>
					<div class="col-md-1">
						<input type="button" class="btn btn-primary" id="reset_success" value="重置">
					</div>
				</div>
			</form>
		</div>
	</div>
	<div class="panel-body">
		<table class="table table-hover table-bordered">
			<tr>
				<th>用户姓名</th>
				<th>年龄</th>
				<th>创建时间</th>
			</tr>
			<c:choose>
				<c:when test="${empty userPage}"></c:when>
				<c:otherwise>
					<c:forEach items="${userPage.content}" var="user"> 
						<tr>
							<td>${user.name}</td>
							<td>${user.age}</td>
							<td>
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
									value="${user.createTime}"/>
							</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		<center>
			<c:choose>
				<c:when test="${empty userPage}">
				</c:when>
				<c:otherwise>
					<tags:pagination page="${userPage}" paginationSize="5" />
				</c:otherwise>
			</c:choose>
		</center>		
	</div>
	<script type="text/javascript">
		$("#reset_success").click(function(){
			$("#realName").val("");
			$("#age").val("");
		});
	</script>
</body>
</html>