<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh"
	uri="http://www.opensymphony.com/sitemesh/decorator"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 屏幕适配 -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
<!-- 绝对路径获取-->
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<!-- js获取路径配置 -->
<script type="text/javascript">
	var path="${path}"
</script>
<!-- bootstrap 引用 -->
<link type="text/css" rel="stylesheet" href="${path}/static_2/dist/css/bootstrap.min.css">
<!-- bootstrap validator css-->
<link type="text/css" rel="stylesheet" href="${path}/static_2/distvalidator/css/bootstrapValidator.min.css">
<!-- sitemesh 架构css自定义下  -->
<link type="text/css" rel="stylesheet" href="${path}/static_2/dist/css/main.css">
<script type="text/javascript" src="${path}/static_2/jquery/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="${path}/static_2/dist/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${path}/static_2/distvalidator/js/bootstrapValidator.min.js"></script>
<title>zxy后台管理系统</title>
<sitemesh:head/>
</head>
<body>
 	<%@ include file="/WEB-INF/pageLayout/header.jsp" %>
 	<!-- 他们是有区别的  %@% 是纯粹的把静态jsp页面加入当中 
 		;而jsp:include 则是动态加载，什么调用什么时候加载，
 		并且加载的2个页面最好别有相同变量，冲突 -->
 	<%-- <jsp:include page="/WEB-INF/pageLayout/left.jsp"> --%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<%@ include file="/WEB-INF/pageLayout/left.jsp" %>
			</div>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" id="contentInfo">
				<sitemesh:body />
			</div>
		</div>
	</div>
	<%-- <%@ include file="/WEB-INF/layouts/footer.jsp"%> --%>
</body>
</html>