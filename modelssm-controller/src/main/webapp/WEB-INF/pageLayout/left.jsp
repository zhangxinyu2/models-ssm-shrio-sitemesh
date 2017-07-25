<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" /> 
<ul class="nav navbar-inverse text-center">
	<li><a href="javascript:void(0);">列表展示</a></li>
	<li >
		<a data-toggle="collapse" data-target="#demo2" href="javascript:void(0);">权限管理</a>
			
		<ul id="demo2" class="nav navbar-default collapse" style="background-color: #FFFFFF">
			<li><a href="${path}/admin/quaryAdminUserList">用户管理</a></li>
			<li><a href="${path}/adminRole/queryRole">角色管理</a></li>
		</ul>
	</li>
	<li >
		<a data-toggle="collapse" data-target="#demo1" href="javascript:void(0);">用户管理</a>
			
		<ul id="demo1" class="nav navbar-default collapse" style="background-color: #FFFFFF">
			<li><a href="${path}/user/queryUser">添加用户</a></li>
			<li><a href="${path}/user/queryUserList">查询用户列表</a></li>
		</ul>
	</li>
	
</ul>

