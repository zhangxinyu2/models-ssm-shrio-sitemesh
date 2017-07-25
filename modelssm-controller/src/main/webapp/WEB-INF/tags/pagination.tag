<%@tag pageEncoding="UTF-8"%>
<%@ attribute name="page" type="org.springframework.data.domain.Page" required="true"%>
<%@ attribute name="paginationSize" type="java.lang.Integer" required="true"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
int current =  page.getNumber() + 1;
int begin = Math.max(1, current - paginationSize/2);
int end = Math.min(begin + (paginationSize - 1), page.getTotalPages());

long total=page.getTotalElements();
request.setAttribute("current", current);
request.setAttribute("begin", begin);
request.setAttribute("end", end);
%>
 
	<ul class="pagination pagination-lg">
		 <% if (page.hasPrevious()){%>
               	<li><a href="?page=1&sortType=${sortType}&${params}">首页</a></li>
                <li><a href="?page=${current-1}&sortType=${sortType}&${params}">上一页</a></li>
         <%}else{%>
                <li class="disabled"><a href="#">首页</a></li>
                <li class="disabled"><a href="#">上一页</a></li>
         <%} %>
 
		<c:forEach var="i" begin="${begin}" end="${end}">
            <c:choose>
                <c:when test="${i == current}">
                    <li class="active"><a href="?page=${i}&sortType=${sortType}&${params}">${i}</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="?page=${i}&sortType=${sortType}&${params}">${i}</a></li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
	  
	  	 <% if (page.hasNext()){%>
               	<li><a href="?page=${current+1}&sortType=${sortType}&${params}">下一页</a></li>
                <li><a href="?page=${page.totalPages}&sortType=${sortType}&${params}">末页</a></li>
         <%}else{%>
                <li class="disabled"><a href="#">下一页</a></li>
                <li class="disabled"><a href="#">末页</a></li>
         <%} %>&nbsp;&nbsp;<li><a href="javascript:;">共计<%=total %>条记录</a></li>

	</ul> 

