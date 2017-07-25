<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//Dth HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dth">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="${path}/static_1/js/user.js"></script>
<title>userAdd</title>
</head>
<body>
	<div class="panel panel-primary">	
		<div class="panel-heading">
	 		用户管理/添加用户
    	</div>
    </div>
    <div class="panel-body">
   		<form class="form-horizontal" id="formvalidator">
   			<div class="row">
	    		<div class="form-group">
	    			<label class="col-md-2 col-md-offset-2 control-label" >用户姓名</label>
	    			<div class="col-md-4">
	                       <input type="text" class="form-control" name="name" id="name" autocomplete="off" />
	                </div>
	    		</div>
    		</div>
    		<div class="row">
	    		<div class="form-group">
	    			<label class="col-md-2 col-md-offset-2 control-label" >用户年龄</label>
	    			<div class="col-md-4">
	                       <input type="text" class="form-control" name="age" id="age" autocomplete="off" />
	                </div>
	    		</div>
    		</div>
    		<div class="row">
	    		<div class="form-group">
	    			<label class="col-md-2 col-md-offset-2 control-label" >操作</label>
	    			<div class="col-md-4">
	                      <input class="btn btn-primary" type="button" id="addUser" value="添加"/>
	                </div>
	    		</div>
    		</div>
   		</form>
   	</div>
</body>
</html>