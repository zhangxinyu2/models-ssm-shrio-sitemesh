<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" /> 
<!-- navbar-inverse 黑色  白色 navbar-default -->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
	<div class="col-lg-1"></div>
	<div class="col-lg-10">
   		<div class="navbar-header">
	     	<div class="navbar-brand">
            	<p>zxy后台管理</p>
	        </div>
         	<!--这个是添加响应式按钮用的，目的为了当屏幕缩进后导航栏看不到了，或出现一个缩进按钮，进行导航的便捷-->
		   	<!--toggle 缩进切换   data-toggle 字面意思数据切换-->
		    <button type="button" class="navbar-toggle" 
		    	data-toggle="collapse" data-target="#navbar-sjnav"
		    	 aria-invalid="false">
		    	 <!-- sr-only 提示缩进  而 icon-only 表示的按钮上一个横线 3个比较好看  也可以用星星的
		       		不过不太好看 glyphicon glyphicon-star-->
			       <span class="sr-only">导航缩进</span>
			       <span class="icon-bar"></span>
			       <span class="icon-bar"></span>
			       <span class="icon-bar"></span>
		     </button>
		</div>
		<!--设置屏幕缩进后的导航显示 需要设置导航样式-->
        <div class="collapse navbar-collapse " id="navbar-sjnav">
            <!--说明以下li属于导航条的数量，可以把列项的li 变成导航栏 nav横向数据-->
            <ul class="nav navbar-nav navbar-right">
                <li><a href="">展示</a></li>
                <li class="dropdown" data-no-turbolink="true">
                    <a data-toggle="dropdown" class="dropdown-toggle" data-no-turbolink="true">用户<span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-menu-left" aria-labelledby="dropdownMenu">
                        <li><a href="">管理用户</a></li>
                        <li class="divider"></li>
                        <li><a href="">查看用户</a></li>
                    </ul>
                </li>
                <li><a href="">提醒</a></li>
                <li><a href="">修改密码</a></li>
                <li><a href="">退出</a></li>
            </ul>
        </div>
	</div>
	<div class="col-lg-1"></div>
</nav>
