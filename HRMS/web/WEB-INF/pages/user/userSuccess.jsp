<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/26
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title></title>
</head>
<body>
<c:if test="${sessionScope.resume!=null}">
    <a href="updateResumeMiddle">修改简历</a>&nbsp;&nbsp;
</c:if>
<c:if test="${sessionScope.resume!=null&&sessionScope.resume.state!=0}">
    <a href="process">查看面试通知</a>
</c:if><br>
<c:forEach items="${sessionScope.recruits}" var="recruit">
    <c:forEach items="${sessionScope.depts}" var="dept">
        <c:forEach items="${sessionScope.posts}" var="post">
            <c:if test="${recruit.postId==post.id&&post.deptId==dept.id}">
                <div style="float: left;background: lightgray;margin: 10px">
                    <p><b style="color: cornflowerblue">部门：</b>${dept.name}</p>
                    <p><b style="color: cornflowerblue">职位：</b>${post.name}</p>
                    <p><b style="color: cornflowerblue">职位需求：</b>${recruit.requirement}</p>
                    <p><b style="color: cornflowerblue">工资范围：</b>${recruit.salary}</p>
                    <p><b style="color: cornflowerblue">公司简介：</b>${recruit.introduction}</p>
                    <p><b style="color: cornflowerblue">公司地址：</b>${recruit.address}</p>
                    <form action="apply" method="post">
                        <input type="hidden" name="recruitId" value="${recruit.id}">
                        <input type="submit" value="申请职位">
                    </form>
                </div>
            </c:if>
        </c:forEach>
    </c:forEach>
</c:forEach>
<div style="clear: both">
    <c:forEach begin="1" end="${sessionScope.totalPages}" var="i">
        <a href="showRecruit?currentPage=${i}">${i}</a>
    </c:forEach>
</div>
</body>
</html>
