<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zf
  Date: 2018/1/29
  Time: 9:44
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
<a href="back">返回</a>
<c:if test="${sessionScope.resume.state==1}">
    <p>等待面试通知</p>
</c:if>
<c:if test="${sessionScope.resume.state==2}">
    <p>面试时间：${sessionScope.resume.interviewTime}</p>
    <form action="sureInterview" method="post">
        <input type="submit" value="确认面试">
    </form>
</c:if>
<c:if test="${sessionScope.resume.state==3}">
    <p>已参加面试，等待录用通知</p>
</c:if>
<c:if test="${sessionScope.resume.state==4}">
    <p>您已被录用</p>
    <a href="employeeLogin">员工登录</a>
</c:if>
</body>
</html>
